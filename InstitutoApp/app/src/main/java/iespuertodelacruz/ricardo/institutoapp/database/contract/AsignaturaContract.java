package iespuertodelacruz.ricardo.institutoapp.database.contract;

import android.provider.BaseColumns;

public class AsignaturaContract {
    /**
     * Se define la sentencia para la creacion de la tabla de la bbdd
     */
    public static final String SQL_CREATE_ENTRIES =
            "CREATE TABLE " + AsignaturaEntry.TABLE_NAME + " (" +
                    AsignaturaEntry._ID + " INTEGER PRIMARY KEY," +
                    AsignaturaEntry.COLUMN_NAME_NOMBRE + " TEXT NOT NULL," +
                    AsignaturaEntry.COLUMN_NAME_CURSO + " TEXT NOT NULL)";

    /**
     * Se define la sentencia para la eliminacion de la tabla de la bbdd
     */
    public static final String SQL_DELETE_ENTRIES =
            "DROP TABLE IF EXISTS " + AsignaturaEntry.TABLE_NAME;

    /**
     * Constructor por defecto
     */
    private AsignaturaContract(){
    }

    /**
     * Se realiza la defincion de las propiedades de la tabla
     * nombre: asignatura
     * columna_id: se hereda de BaseColumns (String)
     * columna_name: se define el nombre de la columna (String)
     */

    public static class AsignaturaEntry implements BaseColumns {
        public static final String TABLE_NAME = "asignatura";
        public static final String COLUMN_NAME_NOMBRE = "nombre";
        public static final String COLUMN_NAME_CURSO = "curso";
    }
}
