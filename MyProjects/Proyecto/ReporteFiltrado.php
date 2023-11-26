<?php
include("conex.php");

$Order=$_POST['Order'];
$Filtro=$_POST['Filtro'];
$Manera=$_POST['Manera'];
$Espacio="   ";
$Where=$_POST['Where'];
$Donde=" Where ";
$Igual="=";
$By=" Order By ";
$Where=' "'.$Where.'" ';
$Tabla='';

echo "<body style='background-color:#3FCAA2;'>";
if($Filtro=='Id_Usuario' or $Filtro=='Nombre' or $Filtro=='Apellido' or $Filtro=='Identificacion' or $Filtro=='Edad' or $Filtro=='Fecha_Nacimiento' or $Filtro=='Telefono'){
    $Tabla=" Usuario.";
}
else{
    $Tabla=" Reporte.";
}

    echo "Reporte Usuario-Reporte";
if($Filtro=='0'){
    $SQL='Select * From Usuario Inner Join Reporte On Usuario.Id_Usuario=Reporte.Id_Usuario Order By '.$Order.$Espacio.$Manera;
}    
else{
    $SQL='Select * from Usuario Inner Join Reporte On Usuario.Id_Usuario=Reporte.Id_Usuario '.$Donde.$Espacio.$Tabla.$Filtro.$Igual.$Where.$Espacio.$By.$Espacio.$Order.$Espacio.$Manera;
}


    $resultado=$conex->query($SQL);

    echo "<table border ='1'>";
    echo "<tr><td colspan='15'><center><b>Reporte</b></center></td></tr>";
    echo "<tr><td>Id_Usuario</td><td>Nombre</td><td>Apellido</td><td>Identificacion</td><td>Edad</td><td>Fecha_Nacimiento</td><td>Telefono</td><td>Id_Reporte</td><td>Estatura</td><td>Peso</td><td>Genero</td><td>IMC</td><td>Id_Tipo</td><td>Tipo</td><td>Id_imc</td></tr>";
    while($registro=$resultado->fetch_array()){
	    echo "<tr><td>".$registro['Id_Usuario']."</td><td>".$registro['Nombre']."</td><td>".$registro['Apellido']."</td><td>".$registro['Identificacion']."</td><td>".$registro['Edad']."</td><td>".$registro['Fecha_Nacimiento']."</td><td>".$registro['Telefono']."</td><td>".$registro['Id_Reporte']."</td><td>".$registro['Estatura']."</td><td>".$registro['Peso']."</td><td>".$registro['Genero']."</td><td>".$registro['IMC']."</td><td>".$registro['Id_Tipo']."</td><td>".$registro['Tipo']."</td><td>".$registro['Id_imc']."</td></tr>";
}

    echo "<tr><td colspan='15' align='center'><marquee>Reportes</marquee></td></tr>";
    echo "</table>";
    echo "</body>";
?>