<?php

include("conex.php");

$SQL="select * from Music where Id_Cancion=".$_GET["Id_Cancion"];
$busqueda=$conex->query($SQL);
$fila=$busqueda->fetch_array();

?>
<html>
    <head>
        <title>Modificar</title>
    </head>
    <body style="background-color:#3FCAA2;">
            <form action="EditarMusic.php" method="post">
            <table border="1" width="50%">
                <tr><td colspan="8"><b>Formulario para Modificar la Musica</b></td></tr>
                <tr><td>Id_Cancion</td><td><input type="number" name="Id_Cancion" id="Id_Cancion" value="<?php echo $fila['Id_Cancion'];?>" readonly></td></tr>
                <tr><td>Autor</td><td><input type="text" name="Autor" id="Autor" value="<?php echo $fila['Autor']; ?>"></td></tr>
                 <tr><td>Nombre</td><td><input type="text" name="Nombre" id="Nombre" value="<?php echo $fila['Nombre']; ?>" ></td></tr>
                 <tr><td>Duracion</td><td><input type="text" name="Duracion" id="Duracion" value="<?php echo $fila['Duracion']; ?>" ></td></tr>
                  <tr><td colspan="8"><input type="submit" value="Enviar" ></td></tr>
            </table>
        </form>
    </body>
</html>