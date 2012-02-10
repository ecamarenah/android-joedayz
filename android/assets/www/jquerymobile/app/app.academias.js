var Academia = {
    init : function(){
        Academia.loadAcademias();
    },
    printList : function(obj){
        if(obj){
            $html = "";
            for(var i = 0 ; i < obj.length ; i++){
                $html +="<li>";
                $html +="<a data-codigo = "+obj[i].CODE+">";
                $html+="<h3>"+obj[i].NOMBRE+"</h3>";
                $html +="</a>";
                $html +="</li>";
            }
            return $html;
        }else{
            return "";
        }
    },
    printCurso : function(obj){
        if(obj){
            $html="";
            $html+="<p>"+obj.DESCRIPCION+"</p>";
            $("#detallercurso").html($html);
        }
    },
    showTaller : function(){
        academia = $(this).data("codigo");
        $(document).data("taller",academia);
        $.mobile.changePage("#ver");
        $("#header-academia").html("ACADEMIA " + academia.toUpperCase());
        Academia.loadAcademiaCursos(academia);
    },
    showCursoTaller : function(){
        curso = $(this).data("codigo");
        $(document).data("curso",curso);
        $.mobile.changePage("#curso");
        $("#header-curso").html("CURSO " + curso.toUpperCase());
        Academia.loadAcademiaCursosDetalle( $(document).data("taller") , curso );
    },
    loadAcademias: function(){
        $.ajax({
            url:CONFIG.URLEXTERNA+'academias/listaracademias',
            dataType:'jsonp',
            type:'GET',
            success:function(response){
                if(response){
                    list = Academia.printList(response);
                    $("#listAcademias").html(list).off("click","a").on("click","a",Academia.showTaller);
                    $("#listAcademias").listview("refresh");                
                }
            }            
        })
    },
    loadAcademiaCursos : function(nombre){
        $.ajax({
            url:CONFIG.URLEXTERNA+'academias/listarAcademiaCurso',
            data:{taller : nombre},
            success:function(response){
                if(response){
                    list = Academia.printList(response);
                    $("#listCurso").html(list).off("click","a").on("click","a",Academia.showCursoTaller);
                    $("#listCurso").listview("refresh");
                }
            }            
        });
    },
    loadAcademiaCursosDetalle : function(_taller,_curso){
        $.ajax({
            url:CONFIG.URLEXTERNA+'academias/mostrarAcademiaCursoDetalle',
            data:{taller:_taller,curso:_curso},
            success:function(response){
                if(response){
                    list = Academia.printCurso(response);
                }
            }
        })
    }
}
$(document).ready(Academia.init)