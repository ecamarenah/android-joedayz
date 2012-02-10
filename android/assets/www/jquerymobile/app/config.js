var CONFIG = {
    URLBASE: "http://m.joedayz.m/",
    URLEXTERNA:"http://services.joedayz.pe/",
    URLEXTERNAIMAGES:"http://joedayz.pe/recursos/images/"
}
$(document).ready(function(){
    $.mobile.loadingMessage = "Espere un Momento";
    $.mobile.pageLoadErrorMessage = "Error al Cargar la Pagina";
    
    $.mobile.fixedToolbars.setTouchToggleEnabled(false);
    $.mobile.fixedToolbars.show();
    
    $.ajaxSetup({
        dataType:'jsonp',
        cache:true,
        type:'GET',
        beforeSend:function(){
            $.mobile.showPageLoadingMsg();
        },
        complete:function(){
            $.mobile.hidePageLoadingMsg();
        },
        error:function(){
            alert("Error");
            $.mobile.hidePageLoadingMsg();
        }
    });
})
