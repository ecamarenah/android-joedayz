var MisCursos = {
    init : function(){
        $("#btnAcceso").on("click",MisCursos.acceso);
        $("#btnEnviarCorreo").on("click",MisCursos.enviarClave);
    },
    acceso : function(){
        e.preventDefault();  
        $.ajax({
            url:CONFIG.URLEXTERNA+"alumnos/acceso",
            data:{
              
            },
            success:function(response){
                if(response){
                    
                    $.mobile.changePage("#index");
                }
            }
        });
        return false;
    },
    printList : function(obj){
        var $html ="";
        if(obj){
            $html+="";
            $html+="";
        }        
    },
    enviarClave : function(e){
        e.preventDefault();
        $.ajax({
            url:CONFIG.URLEXTERNA+"alumnos/enviarcorreo",
            data:{
                correo:$("#txtCorreo").val()
            },
            success:function(response){
                if(response){
                    $.mobile.changePage("#login");
                }                    
            }
        });
        return false;
    }
}
$(document).ready(MisCursos.init);