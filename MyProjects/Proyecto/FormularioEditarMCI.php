<?php

include("conex.php");

$SQL="select * from MCI where IMC=".$_GET['IMC'];
$busqueda=$conex->query($SQL);
$fila=$busqueda->fetch_array();

?>
<html>
    <head>
        <title>Modificar</title>
    </head>
    <body style="background-color:#3FCAA2;">
            <form action="EditarMCI.php" method="post" oninput="resultado.value=Peso.value/(Estatura.value*2)">
            <table border="1" width="50%">
                <tr><td colspan="7"><b>Formulario para Modificar el MCI</b></td></tr>
                <tr><td>Peso</td><td><input type="number" name="Peso" id="Peso" value="<?php echo $fila['Peso']; ?>"></td></tr>
                 <tr><td>Estatura(m)</td><td><input type="number" step="0.0000000001" name="Estatura" id="Estatura" value="<?php echo $fila['Estatura']; ?>" ></td></tr>
                 <tr><td>Genero</td><td><select name="Genero" id="Genero" value="<?php echo $fila['Genero']; ?>" >
                    <option value="">Seleccione su genero de nacimiento</option>
                    <option value="Masculino">Masculino</option>
                    <option value="Femenino">Femenino</option>
                        </select>
                 <tr><td>IMC</td><td><output name="resultado" for="Peso Estatura" name="IMC" id="IMC" value="<?php echo $fila['IMC']; ?>" ></td></tr>
                  <tr><td colspan="7"><input type="submit" value="Enviar" ></td></tr>
            </table>
        </form>
    </body>
</html>