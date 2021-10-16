package es.iespuerto.ricardo.booknown.modelo;

public class Usuario extends User{
    private int idUsuario, seguidores;
    private String nombre, correo, avatar, contrasenia;
    private boolean especial;
    private Biblioteca biblioteca; //Se asigna una instancia de Biblioteca como atributo para que cada Usuario disponga de su propia biblioteca

    /**
     * Constructor por defecto de la clase Usuario
     * @param email
     * @param password
     */
    public Usuario(String email, String password) {
        super(email, password);
    }

    /**
     * Constructor de la clase Usuario
     * @param email
     * @param password
     * @param idUsuario
     * @param seguidores
     * @param nombre
     * @param correo
     * @param avatar
     * @param contrasenia
     * @param especial
     * @param biblioteca
     */
    public Usuario(String email, String password, int idUsuario, int seguidores, String nombre, String correo, String avatar, String contrasenia, boolean especial, Biblioteca biblioteca) {
        super(email, password);
        this.idUsuario = idUsuario;
        this.seguidores = seguidores;
        this.nombre = nombre;
        this.correo = correo;
        this.avatar = avatar;
        this.contrasenia = contrasenia;
        this.especial = especial;
        this.biblioteca = biblioteca;
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
                ", biblioteca=" + biblioteca +
                '}';
    }
}
