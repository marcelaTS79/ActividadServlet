
package datos;

import dominio.usuario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Marce Tangarife
 */
public class usuarioDAOJDBC {
    
   private static final String SQL_SELECT= "SELECT idusuario, Nombres_apellidos, Tipo_documento, Número, Email, Teléfono, Clave FROM usuario";
   private static final String SQL_SELECT_BY_ID= "SELECT idusuario, Nombres_apellidos, Tipo_documento, Número, Email, Teléfono, Clave FROM usuario WHERE idusuario=?"; 
   private static final String SQL_INSERT= "INSERT INTO usuario(Nombres_apellidos, Tipo_documento, Número, Email, Teléfono, Clave)VALUES (?,?,?,?,?,?)"; 
   private static final String SQL_UPDATE= "UPDATE usuario SET Nombres_apellidos=?,Tipo_documento=?, Número=?, Email=?, Teléfono=?, Clave=? WHERE idusuario=? ";
   private static final String SQL_DELETE=  "DELETE FROM usuario WHERE idusuario=?";
   
   public List<usuario> listar(){
    Connection conn=null;
    PreparedStatement stmt=null;
    ResultSet rs=null;
    List<usuario> usuario= new ArrayList<usuario>();
       
       try{
           conn= Conexion.getConnection();
           stmt=conn.prepareStatement(SQL_SELECT);
           rs=stmt.executeQuery();
           while(rs.next()) {
               int idusuario=rs.getInt("idusuario");
               String Nombres_apellidos=rs.getString("Nombres_apellidos");
               String Tipo_documento=rs.getString("tipo_documento");
               String Número=rs.getString("Número");
               String Email=rs.getString("Email");
               String Teléfono=rs.getString("Teléfono");
               String Clave=rs.getString("Clave");
               System.out.println(Nombres_apellidos+" "+Email+" ");
            usuario.add(new usuario(idusuario,Nombres_apellidos,Tipo_documento, Número, Email, Teléfono, Clave));
           }
       } catch (Exception e){
           e.printStackTrace(System.out);
       } finally {
       Conexion.Close(rs);
       Conexion.Close(stmt);
       Conexion.Close(conn);
   }
       return usuario;
   }
   
   public usuario buscar(usuario usuario){
    Connection conn=null;
    PreparedStatement stmt=null;
    ResultSet rs=null;
   
       
       try{
           conn= Conexion.getConnection();
           stmt=conn.prepareStatement(SQL_SELECT_BY_ID);
           stmt.setInt(1, usuario.getIdusuario());
           rs=stmt.executeQuery();
               rs.next();
               int idusuario=rs.getInt("idusuario");
               String Nombres_apellidos=rs.getString("Nombres_apellidos");
               String Tipo_documento=rs.getString("tipo_documento");
               String Número=rs.getString("Número");
               String Email=rs.getString("Email");
               String Teléfono=rs.getString("Teléfono");
               String Clave=rs.getString("Clave");
               
               usuario.setIdusuario(idusuario);
               usuario.setNombres_apellidos(Nombres_apellidos);
               usuario.setTipo_documento(Tipo_documento);
               usuario.setNúmero(Número);
               usuario.setEmail(Email);
               usuario.setTeléfono(Teléfono);
               usuario.setClave(Clave);
           
       } catch (Exception e){
           e.printStackTrace(System.out);
       } finally {
       Conexion.Close(rs);
       Conexion.Close(stmt);
       Conexion.Close(conn);
   }
       return usuario;
   }
   
   public int insertar (usuario usuario){
    Connection conn=null;
    PreparedStatement stmt=null;
    int rows=0;
   
       
       try{
           conn= Conexion.getConnection();
           stmt=conn.prepareStatement(SQL_INSERT);
           stmt.setString(1, usuario.getNombres_apellidos());
           stmt.setString(2, usuario.getTipo_documento());
           stmt.setString(3, usuario.getNúmero());
           stmt.setString(4, usuario.getEmail());
           stmt.setString(5, usuario.getTeléfono());
           stmt.setString(6, usuario.getClave());
           
           rows=stmt.executeUpdate();
           
       } catch (Exception e){
           e.printStackTrace(System.out);
       } finally {
       
       Conexion.Close(stmt);
       Conexion.Close(conn);
   }
       return rows; 
   }
   
   public int actualizar (usuario usuario){
    Connection conn=null;
    PreparedStatement stmt=null;
    int rows=0;
   
       
       try{
           conn= Conexion.getConnection();
           stmt=conn.prepareStatement(SQL_UPDATE);
           stmt.setString(1, usuario.getNombres_apellidos());
           stmt.setString(2, usuario.getTipo_documento());
           stmt.setString(3, usuario.getNúmero());
           stmt.setString(4, usuario.getEmail());
           stmt.setString(5, usuario.getTeléfono());
           stmt.setString(6, usuario.getClave());
           stmt.setInt(6, usuario.getIdusuario());
           
           rows=stmt.executeUpdate();
           
       } catch (Exception e){
           e.printStackTrace(System.out);
       } finally {
       
       Conexion.Close(stmt);
       Conexion.Close(conn);
   }
       return rows; 
   }
   
   public int eliminar(usuario usuario){
    Connection conn=null;
    PreparedStatement stmt=null;
    int rows=0;
   
       
       try{
           conn= Conexion.getConnection();
           stmt=conn.prepareStatement(SQL_DELETE);
           stmt.setInt(1, usuario.getIdusuario());
           
           rows=stmt.executeUpdate();
           
       } catch (Exception e){
           e.printStackTrace(System.out);
       } finally {
       
       Conexion.Close(stmt);
       Conexion.Close(conn);
   }
       return rows; 
   }
   public static void main(String[] args){
       usuarioDAOJDBC usuario= new usuarioDAOJDBC();
       usuario.listar();
       
   }
}