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
		for (var ct=0; ct < data.length; ct++) {
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