var URL = "/";

function logar() {

    var login = { nome: $("#name").val(), senha: $("#password").val() };
    
    $.ajax({
    	  	url:URL+"logar", type:"POST", data: JSON.stringify(login), contentType:"application/json; charset=utf-8",
    	  	success: function(data, status) {
        		if (data === false) {
        			alert("Login inválido!");
        		} else {
        			window.location = "index.html";
        		}
    	  	}
    	})
}