
package web;

import datos.usuarioDAOJDBC;
import dominio.usuario;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

/**
 *
 * @author Marce Tangarife
 */
@WebServlet(name = "ServletControlador", urlPatterns = {"/ServletControlador"})
public class ServletControlador extends HttpServlet {
           
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String accion=request.getParameter("accion");
        if(accion !=null){
                switch(accion){
                   case "editar":
                    editarusuario(request, response);
                    break;
                case "eliminar":
                    eliminarusuario(request, response);
                    break;
                default:
                    accionDefault(request, response);
                    break;
            }
        } else {
            accionDefault(request, response);
        }
    }

 @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String accion=request.getParameter("accion");
        if(accion !=null){
                switch(accion){
                   case "insertar":
                    insertarusuario(request, response);
                    break;
                case "modificar":
                    modificarusuario(request, response);
                    break;
                case "eliminar":
                    eliminarusuario(request, response);
                    break;
                default:
                    accionDefault(request, response);
                    break;
            }
        } else {
            accionDefault(request, response);
        }
    }


    protected void accionDefault(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            List<usuario> usuarios = new usuarioDAOJDBC().listar();
            HttpSession sesion = request.getSession();
            sesion.setAttribute("usuarios", usuarios);
        
            int totalUsuarios = usuarios.size();
            sesion.setAttribute("totalUsuarios", totalUsuarios);
        
            response.sendRedirect("usuario.jsp");
        } catch (Exception e) {
            
            e.printStackTrace(); 
            
            response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "Error al procesar la solicitud.");
        }
    }

    protected void editarusuario(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            int idusuario = Integer.parseInt(request.getParameter("idusuario"));
            usuario usuario = new usuarioDAOJDBC().buscar(new usuario(idusuario));
            request.setAttribute("usuario", usuario);
            String jspEditar = "/WEB-INF/paginas/usuario/editar.jsp";
            request.getRequestDispatcher(jspEditar).forward(request, response);
        } catch (Exception e) {
           
            e.printStackTrace(); 
            
            response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "Error al procesar la solicitud.");
        }
    }

    protected void modificarusuario(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            int idusuario = Integer.parseInt(request.getParameter("idusuario"));
            String Nombres_apellidos = request.getParameter("Nombres_apellidos");
            String Tipo_documento = request.getParameter("Tipo_documento");
            String Número = request.getParameter("Número");
            String Email = request.getParameter("Email");
            String Teléfono = request.getParameter("Teléfono");
            String Clave = request.getParameter("Clave");

            usuario usuario = new usuario(idusuario, Nombres_apellidos, Tipo_documento, Número, Email, Teléfono, Clave);
            int registroModificado = new usuarioDAOJDBC().actualizar(usuario);
            accionDefault(request, response); 
        } catch (Exception e) {
           
            e.printStackTrace(); 
            
            response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "Error al procesar la solicitud.");
        }
    }

    protected void eliminarusuario(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            int idusuario = Integer.parseInt(request.getParameter("idusuario"));
            usuario usuario = new usuario(idusuario);
            int registroModificado = new usuarioDAOJDBC().eliminar(usuario);
            accionDefault(request, response);
        } catch (Exception e) {
           
            e.printStackTrace(); 
            
            response.sendError(HttpServletResponse.SC_INTERNAL_SERVER_ERROR, "Error al procesar la solicitud.");
        }
    }  

    private void insertarusuario(HttpServletRequest request, HttpServletResponse response) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}

