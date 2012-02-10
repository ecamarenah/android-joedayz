var Galeria = {
    init : function(){
        Galeria.loadGaleria();        
    },
    initGalery : function(window, $, PhotoSwipe){
        $("#listFotos").delegate('div.gallery-page','pageshow', function(e){
            var
            currentPage = $(e.target),
            options = {},
            photoSwipeInstance = $("ul.gallery a", e.target).photoSwipe(options,  currentPage.attr('id'));
            return true;						
        })
        .delegate('div.gallery-page','pagehide', function(e){
            var 
            currentPage = $(e.target),
            photoSwipeInstance = PhotoSwipe.getInstance(currentPage.attr('id'));
            if (typeof photoSwipeInstance != "undefined" && photoSwipeInstance != null) {
                PhotoSwipe.detatch(photoSwipeInstance);
            }
            return true;
        });
    },
    loadGaleria : function(){
        $.ajax({
            url:CONFIG.URLEXTERNA+"galerias/listar",
            dataType:"jsonp",
            success:function(response){
                if(response){
                    $("#listGaleria").html(Galeria.printList(response));
                    $("#listGaleria").listview("refresh");
                    $("#listGaleria").delegate("a","click",Galeria.showGalery)
                }else{
                    
            }
            }
        })
    },
    showGalery : function(){
        id = $(this).data("idgaleria");
        $.ajax({
            url:CONFIG.URLEXTERNA+"galerias/vergaleria",
            dataType:"jsonp",
            data:{
                idgaleria:id
            },
            success:function(response){
                
                if(response){
                    $("#listFotos").html(Galeria.printPhotos(response));
                    Galeria.initGalery(window, window.jQuery, window.Code.PhotoSwipe);
                    $.mobile.changePage("#foto");
                }
            }
        });        
    },
    printPhotos:function(obj){
        if(obj){
            $html="";            
            for(var i = 0 ;i<obj.length ; i++){
                $html+="<li>";
                $html+="<a href='"+CONFIG.URLEXTERNAIMAGES+"galeria/"+obj[i].FOTO+"' rel='external'>";
                $html+="<img src="+CONFIG.URLEXTERNAIMAGES+"galeria/"+obj[i].FOTO+" width=150 heigth=150 />";
                $html+="</a>";
                $html+="</li>";
            }
            return $html;
        }else
            return "";
    },
    printList:function(obj){
        if(obj){
            $html = "";
            for(var i = 0 ; i < obj.length ; i++){
                $html +="<li>";
                $html +="<a data-idgaleria="+obj[i].ID+">";
                $html +="<h3>"+obj[i].TITULO+"</h3>";
                $html +="<p>"+obj[i].DESCRIPCION+"</p>";                
                $html +="</a>";
                $html +="</li>";
            }
            return $html;
        }else{
            return "";
        }
    }
};
$(document).ready(Galeria.init);