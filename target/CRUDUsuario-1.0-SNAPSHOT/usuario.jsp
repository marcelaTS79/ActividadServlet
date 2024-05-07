<%-- 
    Document   : usuario.jsp
    Created on : 6 may 2024, 20:47:21
    Author     : Marce Tangarife
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        
        <!--Bootstrap-->
        <link href= "https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet"
              integrity="sha384-KyZXEAg3QhqLMpG8r+8fhAXLRk2vvoC2f3B09zVXn8CA5QIVfZOJ3BCsw2P0p/We" 
              crossorigin="anonymous"><!-- comment -->
        
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/js/bootstrap.min.js" 
        integrity="sha384-+sLIOodYLS7CIrQpBjl+C7nPvqq+FbNUBDunl/OZv93DB7Ln/533i8e/mZXLi/P+" crossorigin="anonymous"></script>
        
        <!--JQuery library-->
        <script src=https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js></script>
        
        <!--Popper 23-->
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.1/umd/popper.min.js"></script>
        
       <!--JavaScript--> 
   <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css"></script>
   <script src="https://kit.fontawesome.com/3556f97eaa.js"></script>
        <title>Usuario </title>
    </head>
    <body>
       <jsp:include page="WEB INT/paginas/comunes/cabecero.jsp"/>
       <jsp:include page="WEB INT/paginas/comunes/botonesNavegacion.jsp"/> 
       <jsp:include page="WEB INT/paginas/usuario/listadoUsuario.jsp"/>
       <jsp:include page="WEB INT/paginas/comunes/piePagina.jsp"/>
    </body>
</html>
