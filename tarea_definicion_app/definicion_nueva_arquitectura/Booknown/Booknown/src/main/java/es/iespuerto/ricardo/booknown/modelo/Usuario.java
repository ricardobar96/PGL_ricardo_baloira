package es.iespuerto.ricardo.booknown.modelo;

public class Usuario {
    private int idUsuario, seguidores;
    private String nombre, correo, avatar;
    private boolean especial;

    /**
     * Constructor por defecto de la clase Usuario
     */
    public Usuario() {
    }

    /**
     * Constructor de la clase Usuario
     * @param idUsuario
     * @param seguidores
     * @param nombre
     * @param correo
     * @param avatar
     * @param especial
     */
    public Usuario(int idUsuario, int seguidores, String nombre, String correo, String avatar, boolean especial) {
        this.idUsuario = idUsuario;
        this.seguidores = seguidores;
        this.nombre = nombre;
        this.correo = correo;
        this.avatar = avatar;
        this.especial = especial;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public int getSeguidores() {
        return seguidores;
    }

    public void setSeguidores(int seguidores) {
        this.seguidores = seguidores;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public boolean isEspecial() {
        return especial;
    }

    public void setEspecial(boolean especial) {
        this.especial = especial;
    }

    /**
     * Funcion que muestra los valores de los atributos del objeto Usuario
     * @return String con los valores de cada atributo del objeto Usuario
     */
    @Override
    public String toString() {
        return "Usuario{" +
                "idUsuario=" + idUsuario +
                ", seguidores=" + seguidores +
                ", nombre='" + nombre + '\'' +
                ", correo='" + correo + '\'' +
                ", avatar='" + avatar + '\'' +
                ", especial=" + especial +
                '}';
    }
}
