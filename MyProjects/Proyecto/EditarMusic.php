<?php

include('conex.php');

$Id_Cancion=$_POST['Id_Cancion'];
$Nombre=$_POST['Nombre'];
$Autor=$_POST['Autor'];
$Duracion=$_POST['Duracion'];

$cadenaSQL="Update Music set  Autor='".$Autor."' , Nombre='".$Nombre."', Duracion='".$Duracion."'  where Id_Cancion=".$Id_Cancion."";


$SQL=$conex->query($cadenaSQL);


if(!$SQL){
    echo "<br> Ejecucion erronea en Edicion Music, posiblemente hay un campo en blanco o un dato que no corresponde </br> ";
}
else{
    echo "Insercion realizada";
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




?>