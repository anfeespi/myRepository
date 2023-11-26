<?php

include('conex.php');
echo "<body style='background-color:#3FCAA2;'>";
$Identificacion=$_POST['Identificacion'];
$Nombre=$_POST['Nombre'];
$Apellido=$_POST['Apellido'];
$Edad=$_POST['Edad'];
$Telefono=$_POST['Telefono'];
$Fecha_Nacimiento=$_POST['Fecha_Nacimiento'];
$Fecha_Nacimiento=date('Y/m/d', strtotime($Fecha_Nacimiento));
$cadenaSQL="Insert Into Usuario ( Identificacion, Nombre, Apellido,  Edad, Telefono, Fecha_Nacimiento) values (".$Identificacion.",'".$Nombre."','".$Apellido."',".$Edad.",".$Telefono.",'".$Fecha_Nacimiento."')";
$SQL=$conex->query($cadenaSQL);
    //Usuario
if(!$SQL){
    echo "<br> Ejecucion erronea en Usuario, posiblemente hay un campo en blanco o un dato que no corresponde </br> ";
}
else{
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
echo "</body>"
?>