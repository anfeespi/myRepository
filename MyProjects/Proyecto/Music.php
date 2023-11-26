<?php

include('conex.php');
echo "<body style='background-color:#3FCAA2;'>";
$Id_Cancion=$_POST['Id_Cancion'];
$Autor=$_POST['Autor'];
$Nombre=$_POST['Nombre'];
$Duracion=$_POST['Duracion'];
$cadenaSQL="Insert Into Music (Id_Cancion, Autor, Nombre,  Duracion) values (".$Id_Cancion.",'".$Autor."','".$Nombre."','".$Duracion."')";
$SQL=$conex->query($cadenaSQL);

if(!$SQL){
    echo "<br> Ejecucion erronea en Music, posiblemente hay un campo en blanco o un dato que no corresponde </br> ";
}
else{
    $SQL='Select * from Music';
    $resultado=$conex->query($SQL);

    echo "<table border ='1'>";
    echo "<tr><td colspan='5'><center><b>Music</b></center></td></tr>";
    echo "<tr><td>Id_Cancion</td><td>Autor</td><td>Nombre</td><td>Duracion</td><td>Editar</td></tr>";
    while($registro=$resultado->fetch_array()){
	    echo "<tr><td>".$registro['Id_Cancion']."</td><td>".$registro['Autor']."</td><td>".$registro['Nombre']."</td><td>".$registro['Duracion']."</td><td><a href = 'FormularioEditarMusic.php?Id_Cancion=".$registro['Id_Cancion']."'>Editar</a></td></tr>";
}

    echo "<tr><td colspan='5' align='center'><marquee>Music</marquee></td></tr>";
    echo "</table>";
    
}
echo "</body>";
?>