/* 
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Other/javascript.js to edit this template
 */

class clientes{
    static insert(){
        //toma de datos
        const Clientes = {
            email:$("#emailcliente").val(),
            password:$("#passwordcliente").val(),
            name:$("#nombrecliente").val(),
            age:$("#edadcliente").val()
        };
        //envio por ajax
        $.ajax({               
            type: "POST",
            url: "http://localhost:8080/api/Client/save",
            dataType: "json",
            crossDomain: true,
            data:JSON.stringify(Clientes),
            contentType: "application/json",
            complete: function(response){
                if (response.status===201){
                    alert("Cliente registrado");
                    document.location.href="clientes.html";
                }else{
                    alert("Cliente no adicionado");
                }                
            }
        });
    }
    
}

class cinemas{
    
}
