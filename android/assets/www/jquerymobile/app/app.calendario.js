var Calendario = {
    init : function(){
        Calendario.loadCalendario();
    },
    loadCalendario: function(){
        $.ajax({
            url:CONFIG.URLEXTERNA+"calendarios/listar",
            dataType:"jsonp",
            type:"GET",
            success:function(response){
                if(response){
                    $("#listCalendario").html(Calendario.printList(response));
                    $("#listCalendario").listview("refresh")
                }else{
                    
                }
            }
        });
    },
    printList:function(obj){
        if(obj){
            $html = "";
            for(var i = 0 ; i < obj.length ; i++){  
                $html +="<li data-role='list-divider'>";
                $html +=obj[i].CURSO;
                $html +="</li>";
                $html +="<li>";                
                $html +="<a href='"+obj[i].INSCRIPCION+"' >";
                $html +="<h3>"+obj[i].FECHA+"</h3>";
                $html +="<p>"+obj[i].LUGAR+"</p>";
                $html +="<p class='ui-li-aside'><strong>"+obj[i].HORA+"</strong></p>";
                $html +="</a>";
                $html +="</li>";
            }
            return $html;
        }else{
            return "";
        }
    }
};
$(document).ready(Calendario.init);