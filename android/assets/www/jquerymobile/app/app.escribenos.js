var Escribenos = {
    init : function(){
        $(document).delegate("#btnEnviar","click",Escribenos.sendData);
    },
    sendData:function(e){
        e.preventDefault();
        $.ajax({
            url:CONFIG.URLEXTERNA+"escribenos/enviar",
            type:"GET",
            data:$("#webForm").serialize(),
            dataType:"jsonp",            
            success:function(response)
            {
                if(response.info){
                    $.mobile.changePage($("#success"));
                }else{                    
                    $.mobile.changePage($("#error"));
                }
            }            
        });
        
    },
    printList : function(obj){
        if(obj){
            $html = "";
            for(var i = 0 ; i < obj.length ; i++){
                $html +="<li>";
                $html+="<h3>"+obj[i].NOMBRE+"</h3>";
                $html +="</li>";
            }
            return $html;
        }else{
            return "";
        }
    }
}
$(document).ready(Escribenos.init);