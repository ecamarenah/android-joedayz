var Noticias = {
    init : function(){
        Noticias.loadListarNoticias();
    },
    loadListarNoticias : function(){
        $.ajax({
            url:CONFIG.URLEXTERNA+'noticias/listarNoticias',
            success:function(response){
                if(response){
                    $("#listNoticias").html(Noticias.printList(response)).off("click","a").on("click","a",Noticias.showNoticia);
                    $("#listNoticias").listview('refresh');
                }
            }
        })
    },
    loadNoticia : function(idnoticia){
        $.ajax({
            url:CONFIG.URLEXTERNA+'noticias/mostrarNoticia',
            data:{noticia:idnoticia},
            success:function(response){
                if(response){                    
                    $("#content-noticias").html(Noticias.printNoticia(response));
                }
            }
        });
    },
    showNoticia : function(){
        noticia = $(this).data("code");
        idnoticia = $(this).data("idnoticia");
        $.mobile.changePage("#vernoticia");
        $("#header-noticia").html("NOTICIA " + noticia.toUpperCase());
        Noticias.loadNoticia(idnoticia);
    },
    printNoticia : function(obj){
        $html ="";
        if(obj){            
            $html+="<p>"+obj.DESC_LARGA+"</p>";            
        }
        return $html;
    },
    printList:function(obj){
        if(obj){
            $html="";
            for(var i=0;i<obj.length;i++){                
                $html+="<li>";
                    $html+="<a data-idnoticia='"+obj[i].ID_NOTICIA+"' data-code='"+obj[i].URL_NOTICIA+"' >";
                        $html+="<h3>"+obj[i].TITULO+"</h3>";
                        $html+="<p>"+obj[i].DESC_CORTA+"</p>";
                    $html+="</a>";
                $html+="</li>";
            }
            return $html;
        }else{
            return "";            
        }
    }
};
$(document).ready(Noticias.init);