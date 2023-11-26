<html>
    <head>
        <title>Filtro</title>
    </head>
    <body style="background-color:#3FCAA2;">
        <form action="ReporteFiltrado.php" method="post">
            <table border="1" width="50%">
                <tr><td colspan="7"><b>Selecciona el filtro</b></td></tr>
                <tr><td>Ordenar</td><td><select name="Order" id="Order" >
                    <option value="1">Defecto</option>
                    <option value="1">Id_Usuario</option>
                    <option value="3">Nombre</option>
                    <option value="4">Apellido</option>
                    <option value="10">Identificacion</option>
                    <option value="8">Id_Reporte</option>
                    <option value="2">Estatura</option>
                    <option value="6">Telefono</option>
                        </select>
                </td></tr>
                <tr><td>Manera</td><td><select name="Manera" id="Manera">
                    <option value=" asc">Ascendente</option>
                    <option value=" desc">Descendente</option>
                </select>
                </td></tr>
                <tr><td>Filtro</td><td><select name="Filtro" id="Filtro" >
                    <option value="0">Nada</option>
                    <option value="Id_Usuario">Id_Usuario</option>
                    <option value="Nombre">Nombre</option>
                    <option value="Apellido">Apellido</option>
                    <option value="Identificacion">Identificacion</option>
                    <option value="Edad">Edad</option>
                    <option value="Fecha_Nacimiento">Fecha_Nacimiento</option>
                    <option value="Telefono">Telefono</option>
                    <option value="Id_Reporte">Id_Reporte</option>
                    <option value="Estatura">Estatura</option>
                    <option value="Peso">Peso</option>
                    <option value="Genero">Genero</option>
                    <option value="IMC">IMC</option>
                    <option value="Id_Tipo">Id_Tipo</option>
                    <option value="Tipo">Tipo</option>
                    <option value="Id_imc">Id_imc</option>
                        </select>
                </td></tr>
                <tr><td>Donde...</td><td><input type="Text"  name="Where" id="Where"></td></tr>
                  <tr><td colspan="7"><input type="submit" value="Enviar" ></td></tr>
            </table>
        </form>
    </body>
</html>