/**
 * Copyright (c) Uniprime Norte do Paran� Av Rio de Janeiro 1758 Londrina-PR Brazil. Todos os direitos
 * reservados. Este software cont�m informa��es confidenciais e de propriedade exclusiva da Uniprime Norte do
 * Paran� e n�o deve ser utilizado fora da corpora��o.
 */
package sistema.infra.relatorios;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Locale;
import java.util.Map;

import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.export.ooxml.JRXlsxExporter;
import net.sf.jasperreports.export.SimpleExporterInput;
import net.sf.jasperreports.export.SimpleOutputStreamExporterOutput;
import net.sf.jasperreports.export.SimpleXlsxReportConfiguration;

import com.forj.cirrus.infra.exceptions.RelatorioException;
import com.forj.cirrus.util.facades.FacadeFile;
import com.forj.cirrus.util.validacao.MsgErro;
import com.forj.cirrus.util.validacao.Val;

/**
 * Classe utilitaria de gera��o de relat�rios utilizando o framework JasperReport.
 * @author Fernando Franzini
 * @author Marcos Polverini
 * @version 2.0 - 19/05/15
 * @since 15/05/2014
 */
public final class RelatorioUtils {

    /**
     * Classe utilit�ria est�tica, n�o � poss�vel instanciar.
     */
    private RelatorioUtils() {
        throw new UnsupportedOperationException();
    }

    /**
     * Gera o arquivo em pdf temporario.
     * @param pathJasper localizacao do arquivo jasper.
     * @param map de parametros.
     * @param data valores a serem repassados para o relatorio.
     * @return arquivo pdf.
     * @throws RelatorioException caso ocorram erros.
     */
    public static File gerarPdf(String pathJasper, Map<String, Object> map, JRBeanCollectionDataSource data)
            throws RelatorioException {
        try {
            validar(pathJasper, map, data);
            File file = FacadeFile.criarArquivoTemp(".pdf");
            JasperPrint pdf = JasperFillManager.fillReport(getJasper(pathJasper), map, data);
            JasperExportManager.exportReportToPdfStream(pdf, new FileOutputStream(file));
            return file;
        } catch (Exception e) {
            throw new RelatorioException(e);
        }
    }

    /**
     * Gera o arquivo em excel temporario.
     * @param pathJasper localizacao do arquivo jasper.
     * @param map de parametros.
     * @param data valores a serem repassados para o relatorio.
     * @return arquivo pdf.
     * @throws RelatorioException caso ocorram erros.
     */
    public static File gerarExcel(String pathJasper, Map<String, Object> map, JRBeanCollectionDataSource data)
            throws RelatorioException {
        try {
            validar(pathJasper, map, data);
            File file = FacadeFile.criarArquivoTemp(".xls");
            JasperPrint print = JasperFillManager.fillReport(getJasper(pathJasper), map, data);
            JRXlsxExporter exporter = new JRXlsxExporter();
            SimpleExporterInput simpleExp = new SimpleExporterInput(print);
            exporter.setExporterInput(simpleExp);
            exporter.setExporterOutput(new SimpleOutputStreamExporterOutput(file));
            SimpleXlsxReportConfiguration configuration = new SimpleXlsxReportConfiguration();
            configuration.setWhitePageBackground(true);
            exporter.setConfiguration(configuration);
            exporter.exportReport();
            return file;
        } catch (Exception e) {
            throw new RelatorioException(e);
        }
    }
 

    // m�todos privados de apoio.

    /**
     * Carrega o jasper dentro do pacote do classpath.
     * @param pathJasper endere�o do jasper dentro da hierarquia do pacotes.
     * @return arquivo jasper.
     * @throws RelatorioException caso n�o encontrar o jasper.
     */
    private static InputStream getJasper(String pathJasper) throws RelatorioException {
        InputStream is = LinkClass.class.getResourceAsStream(pathJasper);
        if (is == null) {
            throw new RelatorioException("Arquivo jasper n�o encontrado - " + pathJasper);
        }
        return is;
    }

    /**
     * Valida os par�metros necess�rios para impress�o.
     * @param pathJasper localizacao do arquivo jasper.
     * @param map de parametros.
     * @param data valores a serem repassados para o relatorio.
     * @throws RelatorioException caso ocorram erros.
     */
    private static void validar(String pathJasper, Map<String, Object> map, JRBeanCollectionDataSource data)
            throws RelatorioException {
        if (Val.vazio(pathJasper)) {
            throw new RelatorioException(MsgErro.obrigatorio("Arquivo jasper."));
        }
        if (Val.vazio(map)) {
            throw new RelatorioException(MsgErro.obrigatorio("Mapa de par�metros."));
        }
        if (data == null) {
            throw new RelatorioException(MsgErro.obrigatorio("Dados para gera��o do arquivo"));
        }
    }
}