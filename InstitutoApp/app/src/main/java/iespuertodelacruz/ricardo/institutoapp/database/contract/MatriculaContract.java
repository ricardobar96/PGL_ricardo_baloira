package iespuertodelacruz.ricardo.institutoapp.database.contract;

import android.provider.BaseColumns;

public class MatriculaContract {

    /**
     * Se define la sentencia para la creacion de la tabla de la bbdd
     */
    public static final String SQL_CREATE_ENTRIES =
            "CREATE TABLE " + MatriculaEntry.TABLE_NAME + " (" +
                    MatriculaEntry._ID + " INTEGER PRIMARY KEY," +
                    MatriculaEntry.COLUMN_NAME_DNI + " TEXT NOT NULL," +
                    MatriculaEntry.COLUMN_NAME_YEAR + " INTEGER NOT NULL)";

    /**
     * Se define la sentencia para la eliminacion de la tabla de la bbdd
     */
    public static final String SQL_DELETE_ENTRIES =
            "DROP TABLE IF EXISTS " + MatriculaEntry.TABLE_NAME;

    /**
     * Constructor por defecto
     */
    private MatriculaContract(){
    }

    /**
     * Se realiza la defincion de las propiedades de la tabla
     * nombre: matricula
     * columna_id: se hereda de BaseColumns (String)
     * columna_name: se define el nombre de la columna (String)
     */
    public static class MatriculaEntry implements BaseColumns {
        public static final String TABLE_NAME = "matricula";
        public static final String COLUMN_NAME_DNI = "dni";
        public static final String COLUMN_NAME_YEAR = "year";
    }
}
