//atribui a funcao para o botao castrar
$("#btnCadastrar").click(function(event){
	event.preventDefault();

	$.get("/cadastro", function(data){
	    $(".container").html(data);
	            history.pushState({}, '', "/cadastro");
	    $("#btnEnviar").click(validaEnvio);
	});
});

