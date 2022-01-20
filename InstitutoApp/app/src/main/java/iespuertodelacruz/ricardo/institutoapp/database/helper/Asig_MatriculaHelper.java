package iespuertodelacruz.ricardo.institutoapp.database.helper;

import android.content.Context;
import android.database.Cursor;

import java.util.ArrayList;
import java.util.List;

import iespuertodelacruz.ricardo.institutoapp.database.contract.Asig_MatriculaContract;
import iespuertodelacruz.ricardo.institutoapp.model.Asignatura_matricula;

public class Asig_MatriculaHelper extends ComunHelper{

    public Asig_MatriculaHelper(Context context) {
        super(context);
    }

    /**
     * Medodo encargado de realizar la insercion
     * @param asignatura_matricula que se utiliza en la operacion
     */
    public boolean add(Asignatura_matricula asignatura_matricula) {
        return super.add(Asig_MatriculaContract.Asig_MatriculaEntry.TABLE_NAME,
                asignatura_matricula.toContentValues());
    }

    /**
     * Funcion encargada de realizar la actualizacion de un elemento
     * @param asignatura_matricula con los datos a actualizar
     * @return True en caso de que la actualizacion haya sido correcta.
     * False en caso contrario
     */
    public boolean update(Asignatura_matricula asignatura_matricula) {
        String selection = Asig_MatriculaContract.Asig_MatriculaEntry._ID + " = ?";
        String[] selectionArgs = { asignatura_matricula.getId() + "" };
        return super.update(
                Asig_MatriculaContract.Asig_MatriculaEntry.TABLE_NAME,
                asignatura_matricula.toContentValues(),
                selection,
                selectionArgs);
    }

    /**
     * Funcion que realiza la eliminacion de un elemento sobre la table
     * @param asignatura_matricula que se va a eliminar
     * @return True en caso de que la eliminación haya sido correcta. False
     * en caso contrario
     */
    public boolean delete(Asignatura_matricula asignatura_matricula) {
        String selection = Asig_MatriculaContract.Asig_MatriculaEntry._ID + " = ?";
        String[] selectionArgs = { asignatura_matricula.getId() + "" };
        return super.delete(
                Asig_MatriculaContract.Asig_MatriculaEntry.TABLE_NAME,
                selection,
                selectionArgs);
    }

    /**
     * Funcion que realiza la busqueda de un elemento a traves de su id
     * @param id de la asignatura_matricula
     * @return con los datos de la asignatura_matricula
     */
    public Asignatura_matricula searchOne(String id) {
        Asignatura_matricula asignatura_matricula = null;
        String selection = Asig_MatriculaContract.Asig_MatriculaEntry._ID + " = ?";
        String[] selectionArgs = { id };
        Cursor cursor = super.search(Asig_MatriculaContract.Asig_MatriculaEntry.TABLE_NAME,
                null,
                selection,
                selectionArgs, null);        if (cursor != null) {
            while(cursor.moveToNext()) {
                asignatura_matricula = new Asignatura_matricula(cursor.getInt(cursor.getColumnIndexOrThrow(
                        Asig_MatriculaContract.Asig_MatriculaEntry._ID)),
                        cursor.getInt(cursor.getColumnIndexOrThrow(
                                Asig_MatriculaContract.Asig_MatriculaEntry.COLUMN_NAME_IDMATRICULA)),
                        cursor.getInt(cursor.getColumnIndexOrThrow(
                                Asig_MatriculaContract.Asig_MatriculaEntry.COLUMN_NAME_IDASIGNATURA))
                );
            }
            cursor.close();
        }
        return asignatura_matricula;
    }

    /**
     * Funcion que realiza la busqueda de todas las asignaturas_matriculas
     * @return lista de asignaturas_matriculas
     */
    public List<Asignatura_matricula> searchAll() {
        List<Asignatura_matricula> asig_Matriculas = new ArrayList<>();
        Cursor cursor = super.search(Asig_MatriculaContract.Asig_MatriculaEntry.TABLE_NAME);
        if (cursor != null) {
            while(cursor.moveToNext()) {
                asig_Matriculas.add(new Asignatura_matricula(cursor.getInt(cursor.getColumnIndexOrThrow(
                        Asig_MatriculaContract.Asig_MatriculaEntry._ID)),
                        cursor.getInt(cursor.getColumnIndexOrThrow(
                                Asig_MatriculaContract.Asig_MatriculaEntry.COLUMN_NAME_IDMATRICULA)),
                        cursor.getInt(cursor.getColumnIndexOrThrow(
                                Asig_MatriculaContract.Asig_MatriculaEntry.COLUMN_NAME_IDASIGNATURA)))
                );
            }
            cursor.close();
        }
        return asig_Matriculas;
    }
}
