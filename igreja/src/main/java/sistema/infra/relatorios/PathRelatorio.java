/**
 * Copyright (c) Uniprime Norte do Paraná Av Rio de Janeiro 1758 Londrina-PR Brazil. Todos os direitos
 * reservados. Este software contém informações confidenciais e de propriedade exclusiva da Uniprime Norte do
 * Paraná e não deve ser utilizado fora da corporação.
 */
package sistema.infra.relatorios;

/**
 * Gerencia tipagem de <b>TipoRelatorio</b>.
 * @author Luiz Santana
 * @version 1.0 - 20/06/2014
 * @since 20/06/2014
 */
public enum PathRelatorio {

    /** Indica que o status. **/
    TED_1_POR_PAG {
        @Override
        public String toString() {
            return PADRAO + "comprovanteTed1PorPag.jasper";
        }
    },
    /** Indica que o status. **/
    TED_4_POR_PAG {
        @Override
        public String toString() {
            return PADRAO + "comprovanteTed4PorPag.jasper";
        }
    },

    /** Indica que o status. **/
    TED_HIST_1_POR_PAG {
        @Override
        public String toString() {
            return PADRAO + "compHistTed1PorPag.jasper";
        }
    },
    /** Indica que o status. **/
    TED_HIST_4_POR_PAG {
        @Override
        public String toString() {
            return PADRAO + "compHistTed4PorPag.jasper";
        }
    },

    /** Indica que o status. **/
    DOC_1_POR_PAG {
        @Override
        public String toString() {
            return PADRAO + "comprovanteDoc1PorPag.jasper";
        }
    },
    /** Indica que o status. **/
    DOC_4_POR_PAG {
        @Override
        public String toString() {
            return PADRAO + "comprovanteDoc4PorPag.jasper";
        }
    },

    /** Indica que o status. **/
    DOC_HIST_1_POR_PAG {
        @Override
        public String toString() {
            return PADRAO + "compHistDoc1PorPag.jasper";
        }
    },
    /** Indica que o status. **/
    DOC_HIST_4_POR_PAG {
        @Override
        public String toString() {
            return PADRAO + "compHistDoc4PorPag.jasper";
        }
    },
    /** Indica que o status. **/
    CONTA_CORRENTE {
        @Override
        public String toString() {
            return PADRAO + "comprovanteCC.jasper";
        }
    },
    /** Indica que o status. **/
    CONVENIO_1_POR_PAG {
        @Override
        public String toString() {
            return PADRAO + "comprovanteConvenio1PorPag.jasper";
        }
    },

    /** Indica que o status. **/
    CONVENIO_4_POR_PAG {
        @Override
        public String toString() {
            return PADRAO + "comprovanteConvenio4PorPag.jasper";
        }
    },

    /** Indica o path da consulta de convênio. **/
    CONVENIO_HIST_1_POR_PAG {
        @Override
        public String toString() {
            return PADRAO + "compHistConv1PorPag.jasper";
        }
    },
    /** Indica o path da consulta de convênio. **/
    CONVENIO_HIST_4_POR_PAG {
        @Override
        public String toString() {
            return PADRAO + "compHistConv4PorPag.jasper";
        }
    },
    /** Indica que o status. **/
    TITULO_1_POR_PAG {
        @Override
        public String toString() {
            return PADRAO + "comprovanteTitulo1PorPag.jasper";
        }
    },
    /** Indica que o status. **/
    TITULO_4_POR_PAG {
        @Override
        public String toString() {
            return PADRAO + "comprovanteTitulo4PorPag.jasper";
        }
    },
    /** Indica que o status. **/
    TITULO_HIST_1_POR_PAG {
        @Override
        public String toString() {
            return PADRAO + "compHistTitulo1PorPag.jasper";
        }
    },
    /** Indica que o status. **/
    TITULO_HIST_4_POR_PAG {
        @Override
        public String toString() {
            return PADRAO + "compHistTitulo4PorPag.jasper";
        }
    },
    /** Indica que o status. **/
    FGTS_1_POR_PAG {
        @Override
        public String toString() {
            return PADRAO + "comprovanteFgts1PorPag.jasper";
        }
    },
    /** Indica que o status. **/
    FGTS_4_POR_PAG {
        @Override
        public String toString() {
            return PADRAO + "comprovanteFgts4PorPag.jasper";
        }
    },
    /** Indica que o status. **/
    GPS_1_POR_PAG {
        @Override
        public String toString() {
            return PADRAO + "comprovanteGps1PorPag.jasper";
        }
    },
    /** Indica que o status. **/
    GPS_4_POR_PAG {
        @Override
        public String toString() {
            return PADRAO + "comprovanteGps4PorPag.jasper";
        }
    },
    /** Indica que o status. **/
    GPS_AUTENTICADO {
        @Override
        public String toString() {
            return PADRAO + "comprovanteGpsAutenticado.jasper";
        }
    },
    /** Indica que o status. **/
    DARF_1_POR_PAG {
        @Override
        public String toString() {
            return PADRAO + "comprovanteDarf1PorPag.jasper";
        }
    },
    /** Indica que o status. **/
    DARF_4_POR_PAG {
        @Override
        public String toString() {
            return PADRAO + "comprovanteDarf4PorPag.jasper";
        }
    },
    /** Indica que o status. **/
    DARF_AUTENTICADO {
        @Override
        public String toString() {
            return PADRAO + "comprovanteDarfAutenticado.jasper";
        }
    },
    /** Indica que o status. **/
    TRANSFERENCIA_1_POR_PAG {
        @Override
        public String toString() {
            return PADRAO + "compTransf1PorPag.jasper";
        }
    },
    /** Indica que o status. **/
    TRANSFERENCIA_4_POR_PAG {
        @Override
        public String toString() {
            return PADRAO + "compTransf4PorPag.jasper";
        }
    },
    /** Indica que o status. **/
    TRANSFERENCIA_HIST_1_POR_PAG {
        @Override
        public String toString() {
            return PADRAO + "compHistTransf1PorPag.jasper";
        }
    },
    /** Indica que o status. **/
    TRANSFERENCIA_HIST_4_POR_PAG {
        @Override
        public String toString() {
            return PADRAO + "compHistTransf4PorPag.jasper";
        }
    },
    /** Indica que o status. **/
    CONVENIO_COBAN {
        @Override
        public String toString() {
            return PADRAO + "comprovanteConvenioCoban.jasper";
        }
    },

    /** Indica que o status. **/
    CONVENIO_COBAN_4 {
        @Override
        public String toString() {
            return PADRAO + "compConvenioCoban4.jasper";
        }
    },

    /** Indica que o status. **/
    EXTRATO_INFORME_RENDIMENTOS {
        @Override
        public String toString() {
            return PADRAO + "extratoInformeRendimentos.jasper";
        }
    },

    /** Indica que o status. **/
    COMPROVANTE_DEBITO_AUTOMATICO {
        @Override
        public String toString() {
            return PADRAO + "comprovanteDebitoAutomatico.jasper";
        }
    };

    /** Armazena o path padrão para o caminho do relatorio. **/
    public static final String PADRAO = "/sistema/infra/relatorios/jaspers/";
}