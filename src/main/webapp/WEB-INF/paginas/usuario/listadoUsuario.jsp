<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<section id="usuario">
    <div class="container">
        <div class="row">
            
            <div class="col-md-9">
                <div class="card">
                    <div class="card-header">
                        <h4> Listado Usuario</h4>   
                        
                    </div>
                    <table class="table table-striped">
                        <thead class="thead-dark">
                            <tr>
                                <th>#</th>
                                <th>Nombres y Apellidos</th>
                                <th>Número</th>
                                <th></th>
                            </tr>
                        </thead>
                        <tbody>
                            
                            <c:forEach var="usuario" items="${usuario}" varStatus="status">
                               <tr>
                                <td>&[status.count]</td>
                                <td>&[usuario.Nombres_apellidos]</td>
                                <td>&[usuario.Número]</td>
                                <td>
                                    <a href="${pageContext.request.contextPat}/ServletControlador?accion=editar&idusuario=${usuario.idusuario}"
                                       class="btn btn-secondary">
                                        <i class="fas fa-angle-double-rigth"></i>Editar
                                    </a> 
                                </td>
                            </tr>  
                            </c:forEach>
                        </tbody>
                    </table>
                    
                </div> 
                
            </div>
            <div class="col-md-3">
                <div class="card text-center bg-danger text-white md-3">
                    <div class="card-body">
                        <h3>Total Usuarios</h3>
                        <h4 class="display-4">
                            <i class="fas fa-user"></i>&{Total Usuarios} 
                            
                        </h4>
                        
                    </div>
                    
                </div>
                
            </div>
            
        </div>
        
        
    </div>
    
    
</section>
<jsp:include page="agregarusuario.jsp"></jsp:include>

