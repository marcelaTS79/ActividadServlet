
package controladores;

import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import java.sql.*;

/**
 *
 * @author Marce Tangarife
 */
public class RecibeDatos {
    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response, String msg)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Resultado del Registro</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>" + msg + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String usuario="root";
        String password="diosesamor";
        String url="jdbc:mysql://localhost:3306/steir";
        Connection conexion;
        Statement statement;
        
        String idusuario = request.getParameter("idusuario");
        String Nombres_apellidos = request.getParameter("Nombres_apellidos");
        String Tipo_documento = request.getParameter(" Tipo_documento");
        String Número = request.getParameter("Número");
        String Email = request.getParameter("Email");
        String Teléfono = request.getParameter("Teléfono");
        String Clave = request.getParameter("Clave");
        String btnReg = request.getParameter("btnRegistro");
        String btnEli = request.getParameter("btnBorrado");
        String btnAct = request.getParameter("btnActualizado");
        String btnCon = request.getParameter("btnConsultas");
        ResultSet rs;
        
        if ("Registrar".equals(btnReg)) {
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            
            conexion= DriverManager.getConnection(url,usuario,password);
            statement= conexion.createStatement();
            
            statement.executeUpdate("INSERT INTO USUARIOS(IDUSUARIO,NOMBRES_APELLIDOS,TIPO_DOCUMENTO,NÚMERO, EMAIL,TELÉFONO, CLAVE) VALUES ('"+idusuario+"','"+Nombres_apellidos+"','"+Tipo_documento+"','"+Número+"','"+Email+"'"+Teléfono+"','"+Clave+"')");
        //out.print("<h1>Datos ingresados con exito<h1>");
        processRequest(request, response, "Registro de datos exitoso");
        }
        catch(Exception e){
            processRequest(request, response, "No se pudo completar el registro");
            //out.print("<h1>Error<h1>");
        } 
        }
        else if ("Eliminar".equals(btnEli)) {
            // Lógica para procesar el botón "Enviar"
            try {
        
            Class.forName("com.mysql.cj.jdbc.Driver");
            
            conexion= DriverManager.getConnection(url,usuario,password);
            statement= conexion.createStatement();
            
            statement.executeUpdate("DELETE FROM USUARIOS WHERE IDUSUARIO = '"+idusuario+"'");
            processRequest(request, response, "Usuario eliminado con exito");
        }
        catch (ClassNotFoundException | SQLException ex){
                ex.printStackTrace();
                }   
        }
            else if ("Actualizar".equals(btnAct)) {
    try {
        
            Class.forName("com.mysql.cj.jdbc.Driver");
            
            conexion= DriverManager.getConnection(url,usuario,password);
            statement= conexion.createStatement();
            
            statement.executeUpdate("UPDATE usuario SET NOMBRESAPELLIDOS = '"+Nombres_apellidos+"' WHERE IDUSUARIO = '"+idusuario+"'");
            statement.executeUpdate("UPDATE  usuario SET TIPO_DOCUMENTO = '"+Tipo_documento+"' WHERE idusuario = '"+idusuario+"'");
            statement.executeUpdate("UPDATE usuario SET NÚMERO = '"+Número+"' WHERE idusuario = '"+idusuario+"'");
            statement.executeUpdate("UPDATE usuario SET EMAIL = '"+Email+"' WHERE idusuario = '"+idusuario+"'");
            statement.executeUpdate("UPDATE usuario SET TELEFONO = '"+Teléfono+"' WHERE idusuario = '"+idusuario+"'"); 
            statement.executeUpdate("UPDATE usuario SET CLAVE = '"+Clave+"' WHERE idusuario = '"+idusuario+"'");
            processRequest(request, response, "usuario actualizado con exito");

        }
        catch (ClassNotFoundException | SQLException ex){
                ex.printStackTrace();
                }
        }
        else if ("Consultar".equals(btnCon)) {
            try {
        
            Class.forName("com.mysql.cj.jdbc.Driver");
            
            conexion= DriverManager.getConnection(url,usuario,password);
            statement= conexion.createStatement();
                        
            rs =statement.executeQuery("SELECT * FROM USUARIO where idusuario = '"+idusuario+"'");
            rs.next();
            processRequest(request, response,"Resultado de la busqueda <br/>" + "ID: " + rs.getInt("IDUSUARIO")
                    + "<br/>" + "NOMBRES_APELLIDOS: " + rs.getString("IDUSUARIO")+"<br/>"+ "NOMBRES_APELLIDOS: " + rs.getString("NOMBRES_APELLIDOS")
                    +"<br/>"+ "NÚMERO: " + rs.getString("NÚMERO")+ "<br/>"+ "EMAIL: " + rs.getString("EMAIL") 
                    + "<br/>"+ "TELEFONO: " + rs.getString("TELEFONO"));
            }
        catch (ClassNotFoundException | SQLException ex){
                ex.printStackTrace();
                }
        }
            else {
            response.getWriter().println("Boton desconocido");
        }

         
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}