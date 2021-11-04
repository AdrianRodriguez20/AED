document.getElementById("opcionBuscar").onchange = function() {changeInputType()};

function changeInputType() {
 if(document.getElementById("opcionBuscar").value=="marcaBuscar"){
 document.getElementById("lapizBuscar").type="text";
}else{
 document.getElementById("lapizBuscar").type="number";
}
}