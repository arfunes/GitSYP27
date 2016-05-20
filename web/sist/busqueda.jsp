<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Alcaldia Municipal de Suchitoto</title>
        <script type="text/javascript">

        </script>
        <link rel="stylesheet" href="css/estilo.css">
        <link rel="stylesheet" href="https://fonts.googleapis.com/css?family=Roboto:regular,bold,italic,thin,light,bolditalic,black,medium&amp;lang=en">
        <link rel="stylesheet" href="https://fonts.googleapis.com/icon?family=Material+Icons">
        <link rel="stylesheet" href="https://code.getmdl.io/1.1.3/material.min.css">
    </head>
    <body>
        <div class="mdl-layout mdl-js-layout mdl-layout--fixed-header">
            <div class="mdl-layout__header-row">

                <div class="a-header-spacer mdl-layout-spacer"></div>

                <div class="a-navegador-contenedor">
                    <nav class="a-navegador mdl-navigation">
                        <a class=" mdl-navigation__link " href="consultarDatos.jsp">Consultar Datos</a>
                        <a class=" mdl-navigation__link " href="ingresar.jsp">Ingresar</a>
                        <a class=" mdl-navigation__link " href="qSomos.jsp">Quienes somos</a>
                    </nav>
                </div>
            </div>

            <div class="cabecera">

                <form method="POST" action="BusquedaServlet.java">
                    <fieldset>
                        <legend>
                            <input type="text" id="valorBusqueda" name="cadenaBusqueda" maxlength="100" required="required"/>
                            <input type="submit" value="Buscar"  />
                        </legend>
                        <input type="checkbox" name="ckb" value="1" />Categoria
                        <input type="checkbox" name="ckb" value="2" />Producto
                        <input type="checkbox" name="ckb" value="3" />Zona
                    </fieldset>
                </form>
            </div>
        




        <footer>
            <div class="form-pie">
                <p class="text-footer"> SIGUENOS EN:
                    <a href="https://www.twitter.com/" target="_blank"><img class="imagen-twitter"></a>
                    <a href="https://www.facebook.com/" target="_blank"><img class="imagen-fb" ></a>
                </p>
            </div>
        </footer>


    </div>
</body>
</html>