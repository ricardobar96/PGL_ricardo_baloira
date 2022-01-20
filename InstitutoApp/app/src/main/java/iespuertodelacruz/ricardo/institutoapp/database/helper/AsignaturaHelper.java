package iespuertodelacruz.ricardo.institutoapp.database.helper;

import android.content.Context;
import android.database.Cursor;

import java.util.ArrayList;
import java.util.List;

import iespuertodelacruz.ricardo.institutoapp.database.contract.AsignaturaContract;
import iespuertodelacruz.ricardo.institutoapp.model.Asignatura;

public class AsignaturaHelper extends ComunHelper{

    public AsignaturaHelper(Context context) {
        super(context);
    }

    /**
     * Medodo encargado de realizar la insercion
     * @param asignatura que se utiliza en la operacion
     */
    public boolean add(Asignatura asignatura) {
        return super.add(AsignaturaContract.AsignaturaEntry.TABLE_NAME,
                asignatura.toContentValues());
    }

    /**
     * Funcion encargada de realizar la actualizacion de un elemento
     * @param asignatura con los datos a actualizar
     * @return True en caso de que la actualizacion haya sido correcta.
     * False en caso contrario
     */
    public boolean update(Asignatura asignatura) {
        String selection = AsignaturaContract.AsignaturaEntry._ID + " = ?";
        String[] selectionArgs = { asignatura.getId() + "" };
        return super.update(
                AsignaturaContract.AsignaturaEntry.TABLE_NAME,
                asignatura.toContentValues(),
                selection,
                selectionArgs);
    }

    /**
     * Funcion que realiza la eliminacion de un elemento sobre la table
     * @param asignatura que se va a eliminar
     * @return True en caso de que la eliminación haya sido correcta. False
     * en caso contrario
     */
    public boolean delete(Asignatura asignatura) {
        String selection = AsignaturaContract.AsignaturaEntry._ID + " = ?";
        String[] selectionArgs = { asignatura.getId() + "" };
        return super.delete(
                AsignaturaContract.AsignaturaEntry.TABLE_NAME,
                selection,
                selectionArgs);
    }

    /**
     * Funcion que realiza la busqueda de un elemento a traves de su id
     * @param id de la asignatura
     * @return con los datos de la asignatura
     */
    public Asignatura searchOne(String id) {
        Asignatura asignatura = null;
        String selection = AsignaturaContract.AsignaturaEntry._ID + " = ?";
        String[] selectionArgs = { id };
        Cursor cursor = super.search(AsignaturaContract.AsignaturaEntry.TABLE_NAME,
                null,
                selection,
                selectionArgs, null);        if (cursor != null) {
            while(cursor.moveToNext()) {
                asignatura = new Asignatura(cursor.getInt(cursor.getColumnIndexOrThrow(
                        AsignaturaContract.AsignaturaEntry._ID)),
                        cursor.getString(cursor.getColumnIndexOrThrow(
                                AsignaturaContract.AsignaturaEntry.COLUMN_NAME_NOMBRE)),
                        cursor.getString(cursor.getColumnIndexOrThrow(
                                AsignaturaContract.AsignaturaEntry.COLUMN_NAME_CURSO))
                );
            }
            cursor.close();
        }
        return asignatura;
    }

    /**
     * Funcion que realiza la busqueda de todas las asignaturas
     * @return lista de asignaturas
     */
    public List<Asignatura> searchAll() {
        List<Asignatura> asignaturas = new ArrayList<>();
        Cursor cursor = super.search(AsignaturaContract.AsignaturaEntry.TABLE_NAME);
        if (cursor != null) {
            while(cursor.moveToNext()) {
                asignaturas.add(new Asignatura(cursor.getInt(cursor.getColumnIndexOrThrow(
                        AsignaturaContract.AsignaturaEntry._ID)),
                        cursor.getString(cursor.getColumnIndexOrThrow(
                                AsignaturaContract.AsignaturaEntry.COLUMN_NAME_NOMBRE)),
                        cursor.getString(cursor.getColumnIndexOrThrow(
                                AsignaturaContract.AsignaturaEntry.COLUMN_NAME_CURSO)))
                );
            }
            cursor.close();
        }
        return asignaturas;
    }

}
