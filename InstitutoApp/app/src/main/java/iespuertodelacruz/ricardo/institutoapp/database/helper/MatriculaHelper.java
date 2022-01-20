package iespuertodelacruz.ricardo.institutoapp.database.helper;

import android.content.Context;
import android.database.Cursor;

import java.util.ArrayList;
import java.util.List;

import iespuertodelacruz.ricardo.institutoapp.database.contract.MatriculaContract;
import iespuertodelacruz.ricardo.institutoapp.model.Matricula;

public class MatriculaHelper extends ComunHelper{

    public MatriculaHelper(Context context) {
        super(context);
    }

    /**
     * Medodo encargado de realizar la insercion
     * @param matricula que se utiliza en la operacion
     */
    public boolean add(Matricula matricula) {
        return super.add(MatriculaContract.MatriculaEntry.TABLE_NAME,
                matricula.toContentValues());
    }

    /**
     * Funcion encargada de realizar la actualizacion de un elemento
     * @param matricula con los datos a actualizar
     * @return True en caso de que la actualizacion haya sido correcta.
     * False en caso contrario
     */
    public boolean update(Matricula matricula) {
        String selection = MatriculaContract.MatriculaEntry._ID + " = ?";
        String[] selectionArgs = { matricula.getId() + "" };
        return super.update(
                MatriculaContract.MatriculaEntry.TABLE_NAME,
                matricula.toContentValues(),
                selection,
                selectionArgs);
    }

    /**
     * Funcion que realiza la eliminacion de un elemento sobre la table
     * @param matricula que se va a eliminar
     * @return True en caso de que la eliminación haya sido correcta. False
     * en caso contrario
     */
    public boolean delete(Matricula matricula) {
        String selection = MatriculaContract.MatriculaEntry._ID + " = ?";
        String[] selectionArgs = { matricula.getId() + "" };
        return super.delete(
                MatriculaContract.MatriculaEntry.TABLE_NAME,
                selection,
                selectionArgs);
    }

    /**
     * Funcion que realiza la busqueda de un elemento a traves de su id
     * @param id de la matricula
     * @return con los datos de la matricula
     */
    public Matricula searchOne(String id) {
        Matricula matricula = null;
        String selection = MatriculaContract.MatriculaEntry._ID + " = ?";
        String[] selectionArgs = { id };
        Cursor cursor = super.search(MatriculaContract.MatriculaEntry.TABLE_NAME,
                null,
                selection,
                selectionArgs, null);        if (cursor != null) {
            while(cursor.moveToNext()) {
                matricula = new Matricula(cursor.getInt(cursor.getColumnIndexOrThrow(
                        MatriculaContract.MatriculaEntry._ID)),
                        cursor.getString(cursor.getColumnIndexOrThrow(
                                MatriculaContract.MatriculaEntry.COLUMN_NAME_DNI)),
                        cursor.getInt(cursor.getColumnIndexOrThrow(
                                MatriculaContract.MatriculaEntry.COLUMN_NAME_YEAR))
                );
            }
            cursor.close();
        }
        return matricula;
    }

    /**
     * Funcion que realiza la busqueda de todas las matriculas
     * @return lista de matriculas
     */
    public List<Matricula> searchAll() {
        List<Matricula> matriculas = new ArrayList<>();
        Cursor cursor = super.search(MatriculaContract.MatriculaEntry.TABLE_NAME);
        if (cursor != null) {
            while(cursor.moveToNext()) {
                matriculas.add(new Matricula(cursor.getInt(cursor.getColumnIndexOrThrow(
                        MatriculaContract.MatriculaEntry._ID)),
                        cursor.getString(cursor.getColumnIndexOrThrow(
                                MatriculaContract.MatriculaEntry.COLUMN_NAME_DNI)),
                        cursor.getInt(cursor.getColumnIndexOrThrow(
                                MatriculaContract.MatriculaEntry.COLUMN_NAME_YEAR)))
                );
            }
            cursor.close();
        }
        return matriculas;
    }

}