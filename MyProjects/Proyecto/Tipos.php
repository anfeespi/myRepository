<?php

include('conex.php');
echo "<body style='background-color:#3FCAA2;'>";
$Tipo=$_POST['Tipo'];
$IMC_Menor=$_POST['IMC_Menor'];
$IMC_Mayor=$_POST['IMC_Mayor'];
$cadenaSQL="Insert Into Tipos (Tipo, IMC_Menor,  IMC_Mayor) values ('".$Tipo."',".$IMC_Menor.",".$IMC_Mayor.")";
$SQL=$conex->query($cadenaSQL);

if(!$SQL){
    echo "<br> Ejecucion erronea en Tipos, posiblemente hay un campo en blanco o un dato que no corresponde </br> ";
}
else{
    $SQL='Select * from Tipos';
    $resultado=$conex->query($SQL);

    echo "<table border ='1'>";
    echo "<tr><td colspan='5'><center><b>Tipos</b></center></td></tr>";
    echo "<tr><td>Id_Tipo</td><td>Tipo</td><td>IMC_Menor</td><td>IMC_Mayor</td><td>Editar</td</tr>";
    while($registro=$resultado->fetch_array()){
	    echo "<tr><td>".$registro['Id_Tipo']."</td><td>".$registro['Tipo']."</td><td>".$registro['IMC_Menor']."</td><td>".$registro['IMC_Mayor']."</td><td><a href = 'Formulario_Tipos.php?IMC_Mayor=".$registro['IMC_Mayor']."'>Editar</a></td></tr>";
}

    echo "<tr><td colspan='5' align='center'><marquee>Tipos</marquee></td></tr>";
    echo "</table>";
    
}
echo"</body>";
?>