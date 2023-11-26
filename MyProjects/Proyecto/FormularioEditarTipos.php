<?php

include("conex.php");

$SQL="select * from Tipos where IMC_Mayor=".$_GET["IMC_Mayor"];
$busqueda=$conex->query($SQL);
$fila=$busqueda->fetch_array();

?>
<html>
    <head>
        <title>Modificar</title>
    </head>
    <body style="background-color:#3FCAA2;">
            <form action="EditarTipos.php" method="post">
            <table border="1" width="50%">
                <tr><td colspan="8"><b>Formulario para Modificar los Tipos</b></td></tr>
                <tr><td>Tipo</td><td><input type="text" name="Tipo" id="Tipo" value="<?php echo $fila['Tipo'];?>" readonly></td></tr>
                <tr><td>IMC_Menor</td><td><input type="number" name="IMC_Menor" id="IMC_Menor" value="<?php echo $fila['IMC_Menor']; ?>"></td></tr>
                 <tr><td>IMC_Mayor</td><td><input type="number" name="IMC_Mayor" id="IMC_Mayor" value="<?php echo $fila['IMC_Mayor']; ?>"  readonly></td></tr>
                  <tr><td colspan="8"><input type="submit" value="Enviar" ></td></tr>
            </table>
        </form>
    </body>
</html>