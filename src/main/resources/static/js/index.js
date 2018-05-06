var URL = "/";

validar();

function validar() {
	
	$.get(URL+"validar", function(data, status) {

        if (data === "false") {
        		window.location = "login.html";
        } else {
        		$("#user").text(data);
        		getListaLogins();
        }
        
    });
}

function getListaLogins() {
	
	$.get(URL+"listar", function(data, status) {

		var lista = data;
		
        for (var i=0; i < lista.length; i++) {
            insertIntoTable(lista[i]);
        }
		        
    });
}

function logout() {
	$.get(URL+"logout", function(data, status) {});
}

function salvar() {

    var login = {
    		nome: $("#name").val(),
    		senha: $("#password").val()
    	};
    
    $.ajax({
    	  	url:URL+"salvar", type:"POST", data: JSON.stringify(login), contentType:"application/json; charset=utf-8",
    	  	success: function(data, status) {
        		
        		if (data === false) {
        			alert("Usuário já cadastrado!");
        		} else {
        			insertIntoTable(login);
                $("#name").val("");
                $("#password").val("");
        		}
    	  	}
    	})
}

function insertIntoTable(login) {
	
	$('#listagem').append([
		'<tr>',
		    '<td>'+login.nome+'</td>',
		    '<td>'+login.senha+'</td>',
		'</tr>'
	].join(''));
	
}
