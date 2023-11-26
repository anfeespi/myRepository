<?php

include('conex.php');
echo "<body style='background-color:#3FCAA2;'>";

$Id_Usuario=$_POST['Id_Usuario'];
$Identificacion=$_POST['Identificacion'];
$Edad=$_POST['Edad'];
$Estatura=$_POST['Estatura'];
$Peso=$_POST['Peso'];
$Genero=$_POST['Genero'];
$IMC=$Peso/($Estatura*2);
$Id_Tipo=$_POST['Id_Tipo'];
$Tipo=$_POST['Tipo'];
$Id_imc=$_POST['Id_imc'];
$cadenaSQL="Insert Into Reporte (Id_Usuario, Identificacion, Edad, Estatura, Peso, Genero, IMC, Id_Tipo, Tipo, Id_imc) values (".$Id_Usuario.",".$Identificacion.",".$Edad.",".$Estatura.",".$Peso.",'".$Genero."',".$IMC.",".$Id_Tipo.",'".$Tipo."',".$Id_imc.")";
$SQL=$conex->query($cadenaSQL);


if(!$SQL){
    echo "<br> Ejecucion erronea en Reporte, posiblemente hay un campo en blanco o un dato que no corresponde </br> ";
}
else{
    echo "Insercion realizada";
    $SQL='Select * from Reporte';
    $resultado=$conex->query($SQL);

    echo "<table border ='1'>";
    echo "<tr><td colspan='11'><center><b>Reporte</b></center></td></tr>";
    echo "<tr><td>Id_Reporte</td><td>Id_Usuario</td><td>Identificacion</td><td>Edad</td><td>Estatura</td><td>Peso</td><td>Genero</td><td>IMC</td><td>Id_Tipo</td><td>Tipo</td><td>Editar</td></tr>";
    while($registro=$resultado->fetch_array()){
	    echo "<tr><td>".$registro['Id_Reporte']."</td><td>".$registro['Id_Usuario']."</td><td>".$registro['Identificacion']."</td><td>".$registro['Edad']."</td><td>".$registro['Estatura']."</td><td>".$registro['Peso']."</td><td>".$registro['Genero']."</td><td>".$registro['IMC']."</td><td>".$registro['Id_Tipo']."</td><td>".$registro['Tipo']."</td><td><a href = 'FormularioEditarReporte.php?Id_Usuario=".$registro['Id_Usuario']."'>Editar</a></td></tr>";
}

    echo "<tr><td colspan='11' align='center'><marquee>Reportes</marquee></td></tr>";
    echo "</table>";
}


echo "</body>";

?>