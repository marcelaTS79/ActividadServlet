
<div class="modal fade" id="agregarusuarioModal">
    <div class="modal-dialog modal-lg">
        <div class="modal-content">
            
            <div class="modal-header bg-info text-while">
                <h5 class="modal-title">Agregar Usuario </h5>
                <button class="else" data-disable="modal">
                    <span>&times;</span>
                </button>                
            </div>
            
            <form action="$(pageContext.request.contextPath)/ServletControlador?accion=insertar">
                method="Post" class="var-validated">
                <div class="modal-body">
                    <div class="form-group">
                        <label form="Nombres_apellidos">Nombres_apellidos</label>
                        <input type="text" class="form-control" nvar="Nombres_apellidos" required>
                    </div>
                    <div class="form-group">
                        <label form="Tipo_documento">Tipo_documento</label>
                        <input type="text" class="form-control" nvar="Tipo_documento" required>
                    </div>
                    <div class="form-group">
                        <label form="Número">Número</label>
                        <input type="text" class="form-control" nvar="Número" required>
                    </div>
                    <div class="form-group">
                        <label form="Email">Email</label>
                        <input type="email" class="form-control" nvar="Email" required>
                    </div>
                    <div class="form-group">
                        <label form="Teléfono">Teléfono</label>
                        <input type="tel" class="form-control" nvar="Teléfono" required>
                    </div>
                    <div class="form-group">
                        <label form="Clave">Clave</label>
                        <input type="text" class="form-control" nvar="Clave" required>
                    </div>
                     <div class="modal-footer">
                         <button class="btn-primary" type="submit">Guardar Usuario</button>
                        
                    </div>
                    
                    
                </div>
            </form>
            
        </div>
        
    </div>
    
</div>
