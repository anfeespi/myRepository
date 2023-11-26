<?php
include("conex.php");

echo "<body style='background-color:#3FCAA2;'>";

    echo "Tabla Reporte";
    
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


    
    echo "Tabla Usuario";
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
    
     echo "Tabla Music";
    $SQL='Select * from Music';
    $resultado=$conex->query($SQL);

    echo "<table border ='1'>";
    echo "<tr><td colspan='5'><center><b>Music</b></center></td></tr>";
    echo "<tr><td>Id_Cancion</td><td>Autor</td><td>Nombre</td><td>Duracion</td><td>Editar</td></tr>";
    while($registro=$resultado->fetch_array()){
	    echo "<tr><td>".$registro['Id_Cancion']."</td><td>".$registro['Autor']."</td><td>".$registro['Nombre']."</td><td>".$registro['Duracion']."</td><td><a href = 'FormularioEditarMusic.php?Id_Cancion=".$registro["Id_Cancion"]."'>Editar</a></td></tr>";
}

    echo "<tr><td colspan='5' align='center'><marquee>Music</marquee></td></tr>";
    echo "</table>";
    
    
    
    
    
    echo "Tabla MCI";
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
    
    
   
    
    
    
    
    echo "Tabla Tipos";
    $SQL='Select * from Tipos';
    $resultado=$conex->query($SQL);

    echo "<table border ='1'>";
    echo "<tr><td colspan='5'><center><b>Tipos</b></center></td></tr>";
    echo "<tr><td>Id_Tipo</td><td>Tipo</td><td>IMC_Menor</td><td>IMC_Mayor</td><td>Editar</td</tr>";
    while($registro=$resultado->fetch_array()){
	    echo "<tr><td>".$registro['Id_Tipo']."</td><td>".$registro['Tipo']."</td><td>".$registro['IMC_Menor']."</td><td>".$registro['IMC_Mayor']."</td><td><a href = 'FormularioEditarTipos.php?IMC_Mayor=".$registro['IMC_Mayor']."'>Editar</a></td></tr>";
}

    echo "<tr><td colspan='5' align='center'><marquee>Tipos</marquee></td></tr>";
    echo "</table>";
    

    
echo "</body>";   
    
    
?>