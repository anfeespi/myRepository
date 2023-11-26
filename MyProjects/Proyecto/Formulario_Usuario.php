<html>
    <head>
        <title>Formulario Usuario</title>
    </head>
    <body style="background-color:#3FCAA2;">
        <form action="Usuario.php" method="post">
            <table border="1" width="50%">
                <tr><td colspan="6"><b>Formulario para el IMC</b></td></tr>
                <tr><td>Identificacion</td><td><input type="number" name="Identificacion" id="Identificacion" ></td></tr>
                <tr><td>Nombre</td><td><input type="text" name="Nombre" id="Nombre" ></td></tr>
                <tr><td>Apellido</td><td><input type="text" name="Apellido" id="Apellido" ></td></tr>
                <tr><td>Edad</td><td><input type="number" name="Edad" id="Edad" ></td></tr>
                <tr><td>Telefono</td><td><input type="number" name="Telefono" id="Telefono" ></td></tr>
                <tr><td>Fecha_Nacimiento</td><td><input type="date" name="Fecha_Nacimiento" id="Fecha_Nacimiento" value="<?php echo date("Y-m-d");?>"></td></tr>
                  <tr><td colspan="6"><input type="submit" value="Enviar" ></td></tr>
            </table>
        </form>
    </body>
</html>