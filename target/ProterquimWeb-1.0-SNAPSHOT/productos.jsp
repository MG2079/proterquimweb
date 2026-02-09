<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <title>Módulo de Productos</title>
    </head>
    <body>

        <h1>Módulo de Gestión de Productos</h1>

        <!-- ========================= -->
        <!-- FORMULARIO (POST) -->
        <!-- ========================= -->
        <h2>Registrar Producto</h2>

        <form action="ProductoServlet" method="post">
            <label>Nombre:</label><br>
            <input type="text" name="nombre" required><br><br>

            <label>Descripción:</label><br>
            <input type="text" name="descripcion" required><br><br>

            <label>Precio:</label><br>
            <input type="number" name="precio" step="0.01" required><br><br>

            <label>ID Categoría:</label><br>
            <input type="number" name="idCategoria" required><br><br>

            <label>ID Proveedor:</label><br>
            <input type="number" name="idProveedor" required><br><br>

            <input type="submit" value="Guardar Producto">
        </form>

        <hr>

        <!-- ========================= -->
        <!-- LISTADO (GET) -->
        <!-- ========================= -->
        <h2>Listado de Productos</h2>

        <table border="1">
            <thead>
                <tr>
                    <th>ID</th>
                    <th>Nombre</th>
                    <th>Descripción</th>
                    <th>Precio</th>
                    <th>Categoría</th>
                    <th>Proveedor</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach var="p" items="${productos}">
                    <tr>
                        <td>${p.idProducto}</td>
                        <td>${p.nombre}</td>
                        <td>${p.descripcion}</td>
                        <td>${p.precio}</td>
                        <td>${p.idCategoria}</td>
                        <td>${p.idProveedor}</td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>

    </body>
</html>


