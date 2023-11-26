<html>
    <head>
        <title>Formulario MCI</title>
    </head>
    <body style="background-color:#3FCAA2;">
        <form action="MCI.php" method="post" oninput="resultado.value=Peso.value/(Estatura.value*2)">
            <table border="1" width="50%">
                <tr><td colspan="6"><b>Formulario para el IMC</b></td></tr>
                <tr><td>Peso</td><td><input type="number" name="Peso" id="Peso" ></td></tr>
                <tr><td>Estatura(m)</td><td><input type="number" step="0.0000000001" name="Estatura" id="Estatura" ></td></tr>
                <tr><td>Genero</td><td><select name="Genero" id="Genero" >
                    <option value="">Seleccione su genero de nacimiento</option>
                    <option value="Masculino">Masculino</option>
                    <option value="Femenino">Femenino</option>
                        </select>
                </td></tr>
                <tr><td>IMC</td><td><output name="resultado" for="Peso Estatura" name="IMC" id="IMC" ></td></tr>
                  <tr><td colspan="6"><input type="submit" value="Enviar" ></td></tr>
            </table>
        </form>
    </body>
</html>