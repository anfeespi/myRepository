<?php

include('conex.php');


$Identificacion=$_POST['Identificacion'];
$Nombre=$_POST['Nombre'];
$Apellido=$_POST['Apellido'];
$Edad=$_POST['Edad'];
$Telefono=$_POST['Telefono'];
$Fecha_Nacimiento=$_POST['Fecha_Nacimiento'];
$cadenaSQL="Update Usuario set Nombre='".$Nombre."', Apellido='".$Apellido."' , Edad=".$Edad.",  Telefono=".$Telefono.", Fecha_Nacimiento='".$Fecha_Nacimiento."' where Identificacion=".$Identificacion."";

$SQL=$conex->query($cadenaSQL);


if(!$SQL){
    echo "<br> Ejecucion erronea en Edicion Usuario, posiblemente hay un campo en blanco o un dato que no corresponde </br> ";
}
else{
    echo "Insercion realizada";
    $SQL='Select * from Usuario';
    $resultado=$conex->query($SQL);

    echo "<table border ='1'>";
    echo "<tr><td colspan='8'><center><b>Usuarios</b></center></td></tr>";
    echo "<tr><td>Id_Usuario</td><td>Identificacion</td><td>Nombre</td><td>Apellido</td><td>Edad</td><td>Telefono</td><td>Fecha_Nacimiento</td><td>Editar</td></tr>";
    while($registro=$resultado->fetch_array()){
	    echo "<tr><td>".$registro['Id_Usuario']."</td><td>".$registro['Identificacion']."</td><td>".$registro['Nombre']."</td><td>".$registro['Apellido']."</td><td>".$registro['Edad']."</td><td>".$registro['Telefono']."</td><td>".$registro['Fecha_Nacimiento']."</td><td><a href = 'FormularioEditarUsuario.php?Identificacion=".$registro['Identificacion']."'>Editar</a></td></tr>";
}

    echo "<tr><td colspan='8' align='center'><marquee>Usuarios</marquee></td></tr>";
    echo "</table>";
    
}




?>