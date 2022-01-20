package iespuertodelacruz.ricardo.institutoapp.database.contract;

import android.provider.BaseColumns;

public class AlumnoContract {

    /**
     * Se define la sentencia para la creacion de la tabla de la bbdd
     */
    public static final String SQL_CREATE_ENTRIES =
            "CREATE TABLE " + AlumnoEntry.TABLE_NAME + " (" +
                    AlumnoEntry._ID + " INTEGER PRIMARY KEY," +
                    AlumnoEntry.COLUMN_NAME_DNI + " TEXT NOT NULL," +
                    AlumnoEntry.COLUMN_NAME_NOMBRE + " TEXT NOT NULL," +
                    AlumnoEntry.COLUMN_NAME_APELLIDO + " TEXT NOT NULL," +
                    AlumnoEntry.COLUMN_NAME_FECHA + " TEXT)";

    /**
     * Se define la sentencia para la eliminacion de la tabla de la bbdd
     */
    public static final String SQL_DELETE_ENTRIES =
            "DROP TABLE IF EXISTS " + AlumnoEntry.TABLE_NAME;

    /**
     * Constructor por defecto
     */
    private AlumnoContract(){
    }

    /**
     * Se realiza la definicion de las propiedades de la tabla
     * nombre: alumno
     * columna_id: se hereda de BaseColumns (String)
     * columna_name: se define el nombre de la columna (String)
     */
    public static class AlumnoEntry implements BaseColumns {
        public static final String TABLE_NAME = "alumno";
        public static final String COLUMN_NAME_DNI = "dni";
        public static final String COLUMN_NAME_NOMBRE = "nombre";
        public static final String COLUMN_NAME_APELLIDO = "apellido";
        public static final String COLUMN_NAME_FECHA = "fecha";
    }
}
