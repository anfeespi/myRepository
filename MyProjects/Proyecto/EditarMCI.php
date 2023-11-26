<?php

include('conex.php');

$Estatura=$_POST['Estatura'];
$Peso=$_POST['Peso'];
$Genero=$_POST['Genero'];
$IMC=$Peso/($Estatura*2);

$cadenaSQL="Update MCI set Peso=".$Peso." , Estatura=".$Estatura." , Genero='".$Genero."'  where IMC=".$IMC."";

$SQL=$conex->query($cadenaSQL);


if(!$SQL){
    echo "<br> Ejecucion erronea en Edicion MCI, posiblemente hay un campo en blanco o un dato que no corresponde </br> ";
}
else{
    echo "Insercion realizada";
    $SQL='Select * from MCI';
    $resultado=$conex->query($SQL);

    echo "<table border ='1'>";
    echo "<tr><td colspan='6'><center><b>MCI</b></center></td></tr>";
    echo "<tr><td>Id_imc</td><td>Peso</td><td>Estatura</td><td>Genero</td><td>MCI</td><td>Editar</td</tr>";
    while($registro=$resultado->fetch_array()){
	    echo "<tr><td>".$registro['Id_imc']."</td><td>".$registro['Peso']."</td><td>".$registro['Estatura']."</td><td>".$registro['Genero']."</td><td>".$registro['IMC']."</td><td><a href = 'FormularioEditarMCI.php?IMC=".$registro['Id_imc']."'>Editar</a></td></tr>";
}

    echo "<tr><td colspan='6' align='center'><marquee>MCI</marquee></td></tr>";
    echo "</table>";
    
}




?>