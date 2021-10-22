package es.iespuerto.ricardo.booknown.modelo.contract;

import android.provider.BaseColumns;

/**
 * Esquema de la Base de Datos
 */
public class UsuarioContract {
    public static abstract class UsuarioEntry implements BaseColumns {
        public static final String nombreTabla ="usuario";
        public static final String idUsuario ="idUsuario";
        public static final String nombre ="nombre";
        public static final String correo = "correo";
        public static final String contrasenia = "contrasenia";
        public static final String avatar ="avatar";
        public static final String seguidores = "seguidores";
        public static final String especial = "especial";
    }
}
