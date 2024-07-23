<%--
  Created by IntelliJ IDEA.
  User: Omar
  Date: 23 jul. 2024
  Time: 20:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!DOCTYPE html>
<html>
<head>
    <title>Lista de Insumos Médicos</title>
    <script>
        async function loadInsumos() {
            try {
                console.log("Fetching insumos...");
                const response = await fetch('/DESAFIO_DWF_T/api/insumos');
                if (!response.ok) {
                    throw new Error('Network response was not ok ' + response.statusText);
                }
                const insumos = await response.json();
                console.log("Insumos fetched:", insumos);
                const insumosList = document.getElementById('insumosList');
                insumosList.innerHTML = '';

                insumos.forEach(insumo => {
                    const li = document.createElement('li');
                    li.textContent = `ID: ${insumo.id}, Nombre: ${insumo.nombre}, Cantidad: ${insumo.cantidad}, Precio: ${insumo.precio}`;
                    insumosList.appendChild(li);
                });
            } catch (error) {
                console.error('There has been a problem with your fetch operation:', error);
            }
        }

        window.onload = loadInsumos;
    </script>
</head>
<body>
<h1>Lista de Insumos Médicos</h1>
<ul id="insumosList">
    <!-- Los insumos se cargarán aquí -->
</ul>
</body>
</html>
