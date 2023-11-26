<?php

include("conex.php");

$SQL="select * from Reporte where Id_Usuario=".$_GET['Id_Usuario'];
$busqueda=$conex->query($SQL);
$fila=$busqueda->fetch_array();

?>
<html>
    <head>
        <title>Modificar</title>
    </head>
    <body style="background-color:#3FCAA2;">
            <form action="EditarReporte.php" method="post" oninput="resultado.value=Peso.value/(Estatura.value*2)">
            <table border="1" width="50%">
                <tr><td colspan="7"><b>Formulario para Modificar el Reporte</b></td></tr>
                <tr><td>Id_Usuario</td><td><input type="number" name="Id_Usuario" id="Id_Usuario" value="<?php echo $fila['Id_Usuario']; ?>" readonly ></td></tr>
                <tr><td>Identificacion</td><td><input type="number" name="Identificacion" id="Identificacion" value="<?php echo $fila['Identificacion']; ?>"></td></tr>
                <tr><td>Edad</td><td><input type="number" name="Edad" id="Edad" value="<?php echo $fila['Edad']; ?>" ></td></tr>
                <tr><td>Estatura(m)</td><td><input type="number" step="0.01" name="Estatura" id="Estatura" value="<?php echo $fila['Estatura']; ?>" ></td></tr>
                <tr><td>Peso</td><td><input type="number" step="0.01" name="Peso" id="Peso" value="<?php echo $fila['Peso']; ?>" ></td></tr>
                <tr><td>Genero</td><td><select name="Genero" id="Genero" value="<?php echo $fila['Genero']; ?>" >
                    <option value="">Seleccione su genero de nacimiento</option>
                    <option value="Masculino">Masculino</option>
                    <option value="Femenino">Femenino</option>
                        </select>
                </td></tr>
                <tr><td>IMC</td><td><output name="resultado" for="Peso Estatura" name="IMC" id="IMC" value="<?php echo $fila['IMC']; ?>" ></td></tr>
                <tr><td>Id_Tipo</td><td><input type="number" name="Id_Tipo" id="Id_Tipo" value="<?php echo $fila['Id_Tipo']; ?>" ></td></tr>
                <tr><td>Tipo</td><td><select name="Tipo" id="Tipo" value="<?php echo $fila['Tipo']; ?>" >
                    <option value="">Seleccione segun su IMC</option>
                    <option value="Desnutricion">Desnutricion</option>
                    <option value="Normal">Normal</option>
                    <option value="Obesidad">Obesidad</option>
                    </select>
                    </td></tr>
                <tr><td>Id_imc</td><td><input type="number" name="Id_imc" id="Id_imc" value="<?php echo $fila['Id_imc']; ?>" ></td></tr>
                  <tr><td colspan="7"><input type="submit" value="Enviar" ></td></tr>
            </table>
        </form>
    </body>
</html>