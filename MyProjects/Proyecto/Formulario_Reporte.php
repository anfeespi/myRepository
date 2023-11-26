<html>
    <head>
        <title>Formulario IMC</title>
    </head>
    <body style="background-color:#3FCAA2;">
        <form action="Reporte.php" method="post" oninput="resultado.value=Peso.value/(Estatura.value*2)">
            <table border="1" width="50%">
                <tr><td colspan="7"><b>Formulario para el IMC</b></td></tr>
                <tr><td>Id_Usuario</td><td><input type="number" name="Id_Usuario" id="Id_Usuario" ></td></tr>
                <tr><td>Identificacion</td><td><input type="number" name="Identificacion" id="Identificacion" ></td></tr>
                <tr><td>Edad</td><td><input type="number" name="Edad" id="Edad" ></td></tr>
                <tr><td>Estatura(m)</td><td><input type="number" step="0.01" name="Estatura" id="Estatura" ></td></tr>
                <tr><td>Peso</td><td><input type="number" step="0.01" name="Peso" id="Peso" ></td></tr>
                <tr><td>Genero</td><td><select name="Genero" id="Genero" >
                    <option value="">Seleccione su genero de nacimiento</option>
                    <option value="Masculino">Masculino</option>
                    <option value="Femenino">Femenino</option>
                        </select>
                </td></tr>
                <tr><td>IMC</td><td><output name="resultado" for="Peso Estatura" name="IMC" id="IMC" ></td></tr>
                <tr><td>Id_Tipo</td><td><input type="number" name="Id_Tipo" id="Id_Tipo" ></td></tr>
                <tr><td>Tipo</td><td><select name="Tipo" id="Tipo" >
                    <option value="">Seleccione segun su IMC</option>
                    <option value="Desnutricion">Desnutricion</option>
                    <option value="Normal">Normal</option>
                    <option value="Obesidad">Obesidad</option>
                    </select>
                    </td></tr>
                <tr><td>Id_imc</td><td><input type="number" name="Id_imc" id="Id_imc" ></td></tr>
                  <tr><td colspan="7"><input type="submit" value="Enviar" ></td></tr>
            </table>
        </form>
    </body>
</html>