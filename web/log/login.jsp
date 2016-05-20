<%-- 
    Document   : login
    Created on : 05-17-2016, 05:47:03 AM
    Author     : Ar Montalvo
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Ingresar Usuario</title>
        <link rel="stylesheet" href="css/estiloConsu.css">
        <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Roboto:regular,bold,italic,thin,light,bolditalic,black,medium&amp;lang=en">
        <link rel="stylesheet" href="https://fonts.googleapis.com/icon?family=Material+Icons">
        <link rel="stylesheet" href="https://code.getmdl.io/1.1.3/material.min.css">

    </head>
    <body>
        <div class="mdl-layout mdl-js-layout mdl-layout--fixed-header">
            <div class="a-header mdl-layout__header mdl-layout__header--waterfall">
                <div class="mdl-layout__header-row">
                    <span class="a-title mdl-layout-title">
                        <img class="a-logo-image" src="../image/logo.jpg">
                    </span>

                    <div class="a-header-spacer mdl-layout-spacer"></div>

                    <div class="a-navegador-contenedor">
                        <nav class="a-navegador mdl-navigation">

                            <a class="mdl-navigation__link " href="inicio.html">Inicio</a>
                            <a class="mdl-navigation__link " href="qSomos.jsp">Quienes somos</a>
                            <a class="mdl-navigation__link " href="inicio.html">Salir</a>
                        </nav>
                    </div>
                </div>
            </div>
            <div class="form-formulario">     
                <form action="loginservlet" method="POST">
                    <table border="0" aling="center">
                        <thead>
                            <tr>
                                <th>Usuario:</th>
                                <th><input type="text" name="f_nombre" value="" /></th>
                            </tr>
                        </thead>
                        <tbody>
                            <tr>
                                <td>Contraseña:</td>
                                <td><input type="password" name="f_contra" value="" required="required"/></td>
                            </tr>
                            <tr>
                                <td class="botn">
                                    <input type="submit" value="Ingresar"required="required" />
                                </td>
                                <%--<td class="botn"><input type="submit" value="Olvide Contraseña" /></td>--%>
                            </tr>
                        </tbody>
                    </table>

                </form> 
                ${requestScope.msg}
            </div>    
    </body>
</html>
