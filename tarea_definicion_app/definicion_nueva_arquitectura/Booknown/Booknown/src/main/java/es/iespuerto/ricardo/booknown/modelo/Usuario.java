package es.iespuerto.ricardo.booknown.modelo;

public class Usuario extends User{
    private int idUsuario, seguidores;
    private String nombre, correo, avatar, contrasenia;
    private boolean especial;

    /**
     * Constructor por defecto de la clase Usuario
     */
    public Usuario(String email, String password, int idUsuario, int seguidores, String nombre, String correo, String avatar, String contrasenia, boolean especial) {
        super(email, password);
        this.idUsuario = idUsuario;
        this.seguidores = seguidores;
        this.nombre = nombre;
        this.correo = email;
        this.avatar = avatar;
        this.contrasenia = password;
        this.especial = especial;
    }

    /**
     * Constructor por defecto de la clase Usuario
     * @param email
     * @param password
     */
    public Usuario(String email, String password) {
        super(email, password);
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
                ", contrasenia='" + contrasenia + '\'' +
                ", especial=" + especial +
                '}';
    }
}
