<?php

include('conex.php');
echo "<body style='background-color:#3FCAA2;'>";
$Peso=$_POST['Peso'];
$Estatura=$_POST['Estatura'];
$Genero=$_POST['Genero'];
$IMC=$Peso/($Estatura*2);
$cadenaSQL="Insert Into MCI ( Peso, Estatura, Genero,  IMC) values (".$Peso.",".$Estatura.",'".$Genero."',".$IMC.")";
$SQL=$conex->query($cadenaSQL);

if(!$SQL){
    echo "<br> Ejecucion erronea en MCI, posiblemente hay un campo en blanco o un dato que no corresponde </br> ";
}
else{
    $SQL='Select * from MCI';
    $resultado=$conex->query($SQL);

    echo "<table border ='1'>";
    echo "<tr><td colspan='6'><center><b>MCI</b></center></td></tr>";
    echo "<tr><td>Id_imc</td><td>Peso</td><td>Estatura</td><td>Genero</td><td>MCI</td><td>Editar</td</tr>";
    while($registro=$resultado->fetch_array()){
	    echo "<tr><td>".$registro['Id_imc']."</td><td>".$registro['Peso']."</td><td>".$registro['Estatura']."</td><td>".$registro['Genero']."</td><td>".$registro['IMC']."</td><td><a href = 'FormularioEditarMCI.php?IMC=".$registro['IMC']."'>Editar</a></td></tr>";
}

    echo "<tr><td colspan='6' align='center'><marquee>MCI</marquee></td></tr>";
    echo "</table>";
    
}
echo "</body>";
?>