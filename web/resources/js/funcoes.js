
$(document).ready(function(){			      	
    $(".botaoAdicionar").on("click", function(){
        addCarrinho($(this));
    });           
});


function listarProdutos(){
        var total = 0, totalFinal = 0;
        carrinho = [];
        if(window.sessionStorage.getItem("carrinho") != null){            
			carrinho = JSON.parse(window.sessionStorage.getItem("carrinho"));
            itens = '<div class="row"> \
                      <div class="col-sm-12">  \
                        <table class="table"> \
                         <thead> \
                            <tr> \
                                <th scope="col">Item</th> \
                                <th scope="col">Valor</th> \
                                <th scope="col">Quantidade</th>\
                                <th scope="col">Total</th> \
                                </tr> \
                            </thead> \
                         <tbody>' ;
			for(i=0; i < carrinho.length; i++){	     
                itens = itens + '<tr>' +
                '<th scope="row">'+JSON.parse(carrinho[i]).Nome + "</th> \
                <td>"+JSON.parse(carrinho[i]).Valor + "</td> \
				<td>"+JSON.parse(carrinho[i]).Quantidade + "</td>\n\
                                <td><button type='button' onclick='deletarItem("+JSON.parse(carrinho[i]).Id+")'>Excluir</button></td></tr>";
				total = parseFloat(JSON.parse(carrinho[i]).Quantidade) * parseFloat(JSON.parse(carrinho[i]).Valor);               
				totalFinal = totalFinal + total;
			}
            itens = itens + '</tbody> \
            </table> \
            </div>	\
            <br/> \
			<table  class="table">\<thead> \<tr> \<th scope="col">Total de todos os produtos</th> \</tr> \</thead>' +
							'<tbody> \<tr> \<th scope="row">'+totalFinal+'</th></tr></tbody></table>';
			$("#itensCarrinho").html(itens);
		}    
		else{
			alert("Não há itens no carrinho!");         
                        window.history.back();
		}
	}

function deletarItem(id){    
    confirma = confirm("Deseja excluir o item");
    carrinho = [];
    carrinho = JSON.parse(window.sessionStorage.getItem("carrinho"));
    if(confirma){        
        delete carrinho[id];        
    }
    
}


function addCarrinho(component){
    //alert(component.id) simply javascript	
    var quantidade = document.getElementById("quantidade").value;
    if (quantidade == "" || quantidade < 1){
        alert("Informe uma quantidade de itens válida!");
    }else{
        id = $(component).attr('id');
    produto = JSON.stringify({
                Id: id,
                Nome: $("#produto").text(),
                Valor: $("#valor").text(),                
                Quantidade: $("#quantidade").val()                
                });
    var carrinho = [];
	
    if(window.sessionStorage.getItem("carrinho") != null){
        carrinho = JSON.parse(window.sessionStorage.getItem("carrinho"));        
    }    
    carrinho.push(produto);
    window.sessionStorage.setItem("carrinho", JSON.stringify(carrinho));
    alert('Produto adicionado com sucesso!');
        
    }
    
    
}

function validarContato(){
    var email = document.getElementById('txtEmail').value;   
    var mensagem = document.getElementById('exampleFormControlTextarea1').value;
    if(email == ""){
        alert("Digite um endereço de email");
        return false;
    }else if(mensagem == ""){
        alert("Especifique a sua mensagem!");
        return false;        
    }else{
        return true;
    }
}

function limparCarrinho(){
	window.sessionStorage.removeItem('carrinho');
        alert("Carrinho esvaziado com sucesso!");        
        window.location.reload();           
	        
	
}
