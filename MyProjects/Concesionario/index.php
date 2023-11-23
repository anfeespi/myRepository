<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="css/styles.css">
    <title>Concesionario</title>
</head>
<body>
    <header class="header">
        <h1>Concesionario</h1>
        <nav class="menu">
            <ol>
                <li>
                    <a class="link" href="#disponibles">Vehículos Disponibles</a>
                </li>
                <li>
                    <a class="link" href="#marca">Vehículos por marca</a>
                </li>
                <li>
                    <a class="link" href="#empleado">Ventas por empleado</a>
                </li>
                <li>
                    <a class="link" href="#mes">Empleado del mes</a>
                </li>
                <li>
                    <a class="link" href="#clientes">Clientes</a>
                </li>
            </ol>
        </nav>
    </header>
    <section class="seccion" id = "disponibles">
        <h1>Lista de todos los vehículos disponibles</h1>
        <p>A continuación, se proporciona una lista con todos los vehículos disponibles en nuestras tiendas…</p>
        <div class="tabla tabla-vehiculos">
        <?php
            include("conex.php");
            $SQL = 'Select * from vehiculo';
            $resultado = $conex -> query($SQL);
        
            echo "<table border ='1' class='datos'>";
            echo "<tr class='encabezado'><td colspan='11'><center><b>Reporte</b></center></td></tr>";
            echo "<tr class='encabezado'><td>VIN</td><td>Color</td><td>Precio</td><td>Fecha de Fabricación</td><td>Estado</td><td>Id_Modelo</td></tr>";
            while($registro = $resultado->fetch_array()){
                echo "<tr><td>".$registro['VIN']."</td><td>".$registro['Color']."</td><td>".$registro['Precio']."</td><td>".$registro['FechaFabricacion']."</td><td>".$registro['Estado']."</td><td>".$registro['ID_Modelo']."</td></tr>";
            }
            echo "<tr><td colspan='11' align='center'><marquee>Vehiculos</marquee></td></tr>";
            echo "</table>";
        ?>
        </div>
    </section>
    <section class="seccion" id = "marca">
        <h1>Lista de vehículos por marca</h1>
        <p>Escoja entre alguna de las marcas con las qué tenemos convenio para ver los carros disponibles pertenecientes a dicha marca…</p>
        <form action="#marca" method="post">
            <label for="marcas">Marcas de Vehículos:</label>
            <select name="marcas" id="lang" class="lista">
                <option value="Toyota">Toyota</option>
                <option value="Audi">Audi</option>
                <option value="Mercedes">Mercedes</option>
                <option value="Chevrolet">Chevrolet</option>
                <option value="BMW">BMW</option>
            </select>
            <button type="submit">Consultar</button>
        </form>
        <div class="tabla tabla-vehiculos-marca">
        <?php
            include("conex.php");
            try {
                if(!array_key_exists('marcas', $_POST)){
                    throw new Exception('');
                }
                $marcas = $_POST['marcas'];
            } catch (Exception $e) {
                $marcas = 'Toyota';
            }
            $SQL = 'SELECT * FROM vehiculo INNER JOIN modelo ON vehiculo.ID_Modelo = modelo.ID_Modelo WHERE modelo.Marca = \''.$marcas.'\'';
            $resultado = $conex -> query($SQL);
        
            echo "<table border ='1' class='datos'>";
            echo "<tr class='encabezado'><td colspan='11'><center><b>Reporte</b></center></td></tr>";
            echo "<tr class='encabezado'><td>VIN</td><td>Color</td><td>Precio</td><td>Fecha de Fabricación</td><td>Estado</td><td>Id_Modelo</td><td>Nombre</td><td>Marca</td><td>Año</td><td>Especificaciones</td></tr>";
            while($registro = $resultado->fetch_array()){
                echo "<tr><td>".$registro['VIN']."</td><td>".$registro['Color']."</td><td>".$registro['Precio']."</td><td>".$registro['FechaFabricacion']."</td><td>".$registro['Estado']."</td><td>".$registro['ID_Modelo']."</td><td>".$registro['Nombre']."</td><td>".$registro['Marca']."</td><td>".$registro['Anio']."</td><td>".$registro['Especificaciones']."</td></tr>";
            }
            echo "<tr><td colspan='11' align='center'><marquee>Vehiculo por marca</marquee></td></tr>";
            echo "</table>";
        ?>
        </div>
    </section>
    <section class="seccion" id = "empleado">
        <h1>Ventas realizadas por empleado</h1>
        <p>En esta sección se muestran las ventas realizadas por un empleado específico de nuestro concesionario, </br> escoja a continuación el empleado del cual desea obtener la información:</p>
        <form action="#empleado" method="post">
            <label for="nombre">Nombres del empleado:</label>
            <input name="nombre" type="text">
            <button type="submit">Filtrar</button>
        </form>
        <div class="tabla tabla-vehiculos-marca">
        <?php
            include("conex.php");
            try {
                if(!array_key_exists('nombre', $_POST)){
                    throw new Exception('');
                }
                $nombre = $_POST['nombre'];
            } catch (Exception $e) {
                $nombre = 'Pedro';
            }
            $SQL = 'SELECT * FROM venta INNER JOIN empleado ON venta.ID_Empleado = empleado.ID_Empleado WHERE empleado.Nombre = \''.$nombre.'\'';
            $resultado = $conex -> query($SQL);
        
            echo "<table border ='1' class='datos'>";
            echo "<tr class='encabezado'><td colspan='12'><center><b>Reporte</b></center></td></tr>";
            echo "<tr class='encabezado'><td>ID_Venta</td><td>DNI_Cliente</td><td>VIN</td><td>ID_Empleado</td><td>Fecha</td><td>Precio Final</td><td>ID_Empleado</td><td>Nombre</td><td>Apellido</td><td>Rol</td><td>Salario</td><td>Fecha de Contratación</td></tr>";
            while($registro = $resultado->fetch_array()){
                echo "<tr><td>".$registro['ID_Venta']."</td><td>".$registro['DNI_Cliente']."</td><td>".$registro['VIN']."</td><td>".$registro['ID_Empleado']."</td><td>".$registro['Fecha']."</td><td>".$registro['PrecioFinal']."</td><td>".$registro['ID_Empleado']."</td><td>".$registro['Nombre']."</td><td>".$registro['Apellido']."</td><td>".$registro['Rol']."</td><td>".$registro['Salario']."</td><td>".$registro['FechaContratacion']."</td></tr>";
            }
            echo "<tr><td colspan='12' align='center'><marquee>Venta por Empleado</marquee></td></tr>";
            echo "</table>";
        ?>
        </div>
    </section>
    <section class="seccion" id = "mes">
        <h1>Empleado del mes</h1>
        <p>Esta sección está dedicada para el empleado cuyas ventas fueron superiores a las de los demás…</p>
        <div class="tabla tabla-vehiculos-marca">
        <?php
            include("conex.php");
            $SQL = 'SELECT * FROM Empleado WHERE ID_Empleado = ( SELECT ID_Empleado FROM Venta WHERE Fecha BETWEEN DATE_SUB(CURDATE(), INTERVAL 12 MONTH) AND CURDATE() GROUP BY ID_Empleado ORDER BY COUNT(*) DESC LIMIT 1 )';
            $resultado = $conex -> query($SQL);
        
            echo "<table border ='1' class='datos'>";
            echo "<tr class='encabezado'><td colspan='12'><center><b>Reporte</b></center></td></tr>";
            echo "<tr class='encabezado'><td>ID_Empleado</td><td>Nombre</td><td>Apellido</td><td>Rol</td><td>Salario</td><td>Fecha de Contratacion</td></tr>";
            while($registro = $resultado->fetch_array()){
                echo "<tr><td>".$registro['ID_Empleado']."</td><td>".$registro['Nombre']."</td><td>".$registro['Apellido']."</td><td>".$registro['Rol']."</td><td>".$registro['Salario']."</td><td>".$registro['FechaContratacion']."</td></tr>";
            }
            echo "<tr><td colspan='12' align='center'><marquee>Venta por Empleado</marquee></td></tr>";
            echo "</table>";
        ?>
        </div>
    </section>
    <section class="seccion" id = "clientes">
        <h1>Lista de Clientes</h1>
        <p>A continuación, se muestra la lista de Clientes del concesionario, esta lista se puede filtrar </br> según un rango de precio, si lo desea hacer ingrese el valor mínimo y máximo qué desee: </p>
        <form action="#clientes" method="post">
            <label for="nombre">Defina los limites:</label>
            <input name="liminf" type="number" placeholder="Limite Inferior">
            <input name="limsup" type="number" placeholder="Limite Superior">
            <button type="submit">Filtrar</button>
        </form>
        <div class="tabla tabla-vehiculos-marca">
        <?php
            include("conex.php");
            try {
                if(!array_key_exists('liminf', $_POST) || !array_key_exists('limsup', $_POST)){
                    throw new Exception('');
                }
                $liminf = $_POST['liminf'];
                $limsup = $_POST['limsup'];
            } catch (Exception $e) {
                $liminf = 0;
                $limsup = 30000;
            }
            $SQL = 'SELECT cliente.DNI, cliente.Nombre, cliente.Apellido, cliente.Telefono, cliente.Direccion FROM cliente INNER JOIN venta ON cliente.DNI = venta.DNI_Cliente WHERE venta.PrecioFinal <= '.$limsup.' AND venta.PrecioFinal >= '.$liminf;
            $resultado = $conex -> query($SQL);
        
            echo "<table border ='1' class='datos'>";
            echo "<tr class='encabezado'><td colspan='5'><center><b>Reporte</b></center></td></tr>";
            echo "<tr class='encabezado'><td>DNI</td><td>Nombre</td><td>Apellido</td><td>Telefono</td><td>Direccion</td></tr>";
            while($registro = $resultado->fetch_array()){
                echo "<tr><td>".$registro['DNI']."</td><td>".$registro['Nombre']."</td><td>".$registro['Apellido']."</td><td>".$registro['Telefono']."</td><td>".$registro['Direccion']."</td></tr>";
            }
            echo "<tr><td colspan='5' align='center'><marquee>Clientes por ventas</marquee></td></tr>";
            echo "</table>";
        ?>
        </div>
    </section>
</body>
</html>