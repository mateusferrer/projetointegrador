function focoEntrada() {
	try {
		focoEntradaFrm();
	} catch (e) {
	}
}

function getId(el) {
	try {
		return document.getElementById(el);
	} catch (e) {
		alert("Erro getId(el) - " + e.description);
	}
}

function tratarErros(data) {
	if (data != null) {
		var e = '';
		for (var ct = 0; ct < data.length; ct++) {
			e = e + data[ct] + '\n';
		}
		alert(e);
	}
}

function focus(id) {
	try {
		return document.getElementById(id).focus();
	} catch (e) {
		alert("Erro focus(el) - " + e.description);
	}
}

function eventoClickBotao(data, botao) {
	if (data != null) {
		tratarErros(data);
	} else {
		getId(botao).click();
	}
}

function eventoClickBotao(data, botao, id) {
	if (data != null) {
		tratarErros(data);
		focus(id);
	} else {
		getId(botao).click();
	}
}

function limpa_formulário_cep() {
	// Limpa valores do formulário de cep.
	document.getElementById('rua').value = ("");
	document.getElementById('bairro').value = ("");
	document.getElementById('cidade').value = ("");
	document.getElementById('uf').value = ("");
	document.getElementById('ibge').value = ("");
}

function meu_callback(conteudo) {
	if (!("erro" in conteudo)) {
		// Atualiza os campos com os valores.
		document.getElementById('rua').value = (conteudo.logradouro);
		document.getElementById('bairro').value = (conteudo.bairro);
		document.getElementById('cidade').value = (conteudo.localidade);
		document.getElementById('uf').value = (conteudo.uf);
		document.getElementById('ibge').value = (conteudo.ibge);
	} // end if.
	else {
		// CEP não Encontrado.
		limpa_formulário_cep();
		alert("CEP não encontrado.");
	}
}

function pesquisacep() {

	var valor = document.getElementById('cep');

	// Nova variável "cep" somente com dígitos.
	var cep = valor.replace(/\D/g, '');

	// Verifica se campo cep possui valor informado.
	if (cep != "") {

		// Expressão regular para validar o CEP.
		var validacep = /^[0-9]{8}$/;

		// Valida o formato do CEP.
		if (validacep.test(cep)) {

			// Preenche os campos com "..." enquanto consulta webservice.
			document.getElementById('rua').value = "...";
			document.getElementById('bairro').value = "...";
			document.getElementById('cidade').value = "...";
			document.getElementById('uf').value = "...";
			document.getElementById('ibge').value = "...";

			// Cria um elemento javascript.
			var script = document.createElement('script');

			// Sincroniza com o callback.
			script.src = '//viacep.com.br/ws/' + cep
					+ '/json/?callback=meu_callback';

			// Insere script no documento e carrega o conteúdo.
			document.body.appendChild(script);

		} // end if.
		else {
			// cep é inválido.
			limpa_formulário_cep();
			alert("Formato de CEP inválido.");
		}
	} // end if.
	else {
		// cep sem valor, limpa formulário.
		limpa_formulário_cep();
	}
};

function uppercase(z) {
	z.value = z.value.toUpperCase();
}