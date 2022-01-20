package iespuertodelacruz.ricardo.institutoapp.database.contract;

import android.provider.BaseColumns;

public class Asig_MatriculaContract {

    /**
     * Se define la sentencia para la creacion de la tabla de la bbdd
     */
    public static final String SQL_CREATE_ENTRIES =
            "CREATE TABLE " + Asig_MatriculaEntry.TABLE_NAME + " (" +
                    Asig_MatriculaEntry._ID + " INTEGER PRIMARY KEY," +
                    Asig_MatriculaEntry.COLUMN_NAME_IDMATRICULA + " INTEGER NOT NULL," +
                    Asig_MatriculaEntry.COLUMN_NAME_IDASIGNATURA + " INTEGER NOT NULL)";

    /**
     * Se define la sentencia para la eliminacion de la tabla de la bbdd
     */
    public static final String SQL_DELETE_ENTRIES =
            "DROP TABLE IF EXISTS " + Asig_MatriculaEntry.TABLE_NAME;

    /**
     * Constructor por defecto
     */
    private Asig_MatriculaContract(){
    }

    /**
     * Se realiza la definicion de las propiedades de la tabla
     * nombre: asig_matricula
     * columna_id: se hereda de BaseColumns (String)
     * columna_name: se define el nombre de la columna (String)
     */
    public static class Asig_MatriculaEntry implements BaseColumns {
        public static final String TABLE_NAME = "asignatura_matricula";
        public static final String COLUMN_NAME_IDMATRICULA = "idMatricula";
        public static final String COLUMN_NAME_IDASIGNATURA = "idAsignatura";
    }
}
