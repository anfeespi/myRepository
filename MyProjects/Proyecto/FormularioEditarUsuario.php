<?php

include("conex.php");

$SQL="select * from Usuario where Identificacion=".$_GET['Identificacion'];
$busqueda=$conex->query($SQL);
$fila=$busqueda->fetch_array();

?>
<html>
    <head>
        <title>Modificar</title>
    </head>
    <body style="background-color:#3FCAA2;">
            <form action="EditarUsuario.php" method="post">
            <table border="1" width="50%">
                <tr><td colspan="7"><b>Formulario para Modificar el Usuario</b></td></tr>
                <tr><td>Identificacion</td><td><input type="number" name="Identificacion" id="Identificacion" value="<?php echo $fila['Identificacion']; ?>" READONLY></td></tr>
                 <tr><td>Nombre</td><td><input type="text" name="Nombre" id="Nombre" value="<?php echo $fila['Nombre']; ?>" ></td></tr>
                 <tr><td>Apellido</td><td><input type="text" name="Apellido" id="Apellido" value="<?php echo $fila['Apellido']; ?>" ></td></tr>
                <tr><td>Edad</td><td><input type="number" name="Edad" id="Edad" value="<?php echo $fila['Edad']; ?>" ></td></tr>
                <tr><td>Telefono</td><td><input type="number" name="Telefono" id="Telefono" value="<?php echo $fila['Telefono']; ?>" ></td></tr>
                <tr><td>Fecha_Nacimiento</td><td><input type="date" name="Fecha_Nacimiento" id="Fecha_Nacimiento" value="<?php echo date("Y-m-d");?>""<?php echo $fila['Fecha_Nacimiento']; ?>" ></td></tr>
                  <tr><td colspan="7"><input type="submit" value="Enviar" ></td></tr>
            </table>
        </form>
    </body>
</html>