
package dominio;

/**
 *
 * @author Marce Tangarife
 */
public class usuario {
    private int idusuario;
    private String Nombres_apellidos;
    private String Tipo_documento;
    private String Número;
    private String Email;
    private String Teléfono;
    private String Clave;

    public usuario(int idusuario) {
        this.idusuario = idusuario;
    }
    
    public usuario(){
    
}

    public usuario(int idusuario, String Nombres_apellidos, String Email, String Teléfono) {
        this.idusuario = idusuario;
        this.Nombres_apellidos = Nombres_apellidos;
        this.Email = Email;
        this.Teléfono = Teléfono;
    }
    
    public usuario(String Nombres_apellidos, String Email, String Teléfono) {
        this.Nombres_apellidos = Nombres_apellidos;
        this.Email = Email;
        this.Teléfono = Teléfono;
    }

    public usuario(int idusuario, String Nombres_apellidos, String Tipo_documento, String Número, String Email, String Teléfono, String Clave) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public int getIdusuario() {
        return idusuario;
    }

    public void setIdusuario(int idusuario) {
        this.idusuario = idusuario;
    }

    public String getNombres_apellidos() {
        return Nombres_apellidos;
    }

    public void setNombres_apellidos(String Nombres_apellidos) {
        this.Nombres_apellidos = Nombres_apellidos;
    }

    public String getTipo_documento() {
        return Tipo_documento;
    }

    public void setTipo_documento(String Tipo_documento) {
        this.Tipo_documento = Tipo_documento;
    }

    public String getNúmero() {
        return Número;
    }

    public void setNúmero(String Número) {
        this.Número = Número;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String Email) {
        this.Email = Email;
    }

    public String getTeléfono() {
        return Teléfono;
    }

    public void setTeléfono(String Teléfono) {
        this.Teléfono = Teléfono;
    }

    public String getClave() {
        return Clave;
    }

    public void setClave(String Clave) {
        this.Clave = Clave;
    }

    @Override
    public String toString() {
        return "usuario{" + "idusuario=" + idusuario + ", Nombres_apellidos=" + Nombres_apellidos + ", Tipo_documento=" + Tipo_documento + ", N\u00famero=" + Número + ", Email=" + Email + ", Tel\u00e9fono=" + Teléfono + ", Clave=" + Clave + '}';
    }
    
    
}
