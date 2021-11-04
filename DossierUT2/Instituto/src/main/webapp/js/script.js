$(document).ready(function() {

    $("#tab1").click(function() {
        $(".tabs").removeClass("active1");
        $(".tabs").addClass("bg-light");
        $("#tab1").addClass("active1");
        $("#tab1").removeClass("bg-light");
    });
    $("#tab2").click(function() {
        $(".tabs").removeClass("active1");
        $(".tabs").addClass("bg-light");
        $("#tab2").addClass("active1");
        $("#tab2").removeClass("bg-light");
    });
    $("#tab3").click(function() {
        $(".tabs").removeClass("active1");
        $(".tabs").addClass("bg-light");
        $("#tab3").addClass("active1");
        $("#tab3").removeClass("bg-light");
    });
    $("#tab4").click(function() {
        $(".tabs").removeClass("active1");
        $(".tabs").addClass("bg-light");
        $("#tab4").addClass("active1");
        $("#tab4").removeClass("bg-light");
    });
})

 function clear() {
            document.getElementById("resultado").value = "";
        }

        function copy() {
            var contenido = document.getElementById('resultado');

            contenido.select();
            document.execCommand('copy');
        }


        document.getElementById("clear").addEventListener("click", clear);
        document.getElementById("copiar").addEventListener("click", copy);