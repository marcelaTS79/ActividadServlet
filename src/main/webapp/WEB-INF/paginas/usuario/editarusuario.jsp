

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href= "https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet"
              integrity="sha384-KyZXEAg3QhqLMpG8r+8fhAXLRk2vvoC2f3B09zVXn8CA5QIVfZOJ3BCsw2P0p/We" 
              crossorigin="anonymous">

        <script src="https://kit.fontawesome.com/3556f97eaa.js"></script>
        <title>Editar usuarios</title>
    </head>
    <body>
        <jsp:include page="../comunes/cabecero.jsp"/>

        <form action="$(pageContext.request.contextPath)/ServletControlador?accion=modificar+idusuario=&(usuario.idusuario)">
            method:"Post" class="var-validated">
            <jsp:include page="../comunes/botonesNavegacionEdicion.jsp"/>
            <section id="details">
                <div class="container">
                    <div class="row">
                        <div class="col">
                            <div class="card">
                                <div class="card-header">
                                    <h4>Editar usuario</h4>
                                </div>

                                <div class="card-body">
                                    <div class="form-group">
                                        <label form="Nombres_apellidos">Nombres_apellidos</label>
                                        <input type="text" class="form-control" nvar="Nombres_apellidos" required value="&{usuario.Nombres_apellidos}">
                                    </div>
                                    <div class="form-group">
                                        <label form="Tipo_documento">Tipo_documento</label>
                                        <input type="text" class="form-control" nvar="Tipo_documento" required value="&{usuario.Tipo_documento}">
                                    </div>
                                    <div class="form-group">
                                        <label form="Número">Número</label>
                                        <input type="text" class="form-control" nvar="Número" required value="&{usuario.Número}">
                                    </div>
                                    <div class="form-group">
                                        <label form="Email">Email</label>
                                        <input type="email" class="form-control" nvar="Email" required value="&{usuario.Email}">
                                    </div>
                                    <div class="form-group">
                                        <label form="Teléfono">Teléfono</label>
                                        <input type="tel" class="form-control" nvar="Teléfono" required value="&{usuario.Teléfono}">
                                    </div>
                                    <div class="form-group">
                                        <label form="Clave">Clave</label>
                                        <input type="text" class="form-control" nvar="Clave" required value="&{usuario.Clave}">
                                    </div>
                                </div> 
                            </div>
                        </div>
                    </div>
                </div>
            </section>
        </form>

    </body>
</html>
