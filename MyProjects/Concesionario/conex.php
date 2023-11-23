<?php
    $conex = mysqli_connect('localhost','root','','concesionario');
    if($conex){
        //echo "¡Conexion Correcta!";
    }
    else{
        echo "¡Error en la Conexion!";
    }
?>