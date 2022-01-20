package iespuertodelacruz.ricardo.institutoapp.database.helper;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;
import java.util.List;

import iespuertodelacruz.ricardo.institutoapp.database.contract.AlumnoContract;
import iespuertodelacruz.ricardo.institutoapp.model.Alumno;

public class AlumnoHelper extends ComunHelper{

    public AlumnoHelper(Context context) {
        super(context);
    }

    /**
     * Medodo encargado de realizar la insercion
     * @param alumno que se utiliza en la operacion
     */
    public boolean add(Alumno alumno) {
        return super.add(AlumnoContract.AlumnoEntry.TABLE_NAME,
                alumno.toContentValues());
    }

    /**
     * Funcion encargada de realizar la actualizacion de un elemento
     * @param alumno con los datos a actualizar
     * @return True en caso de que la actualizacion haya sido correcta.
     * False en caso contrario
     */
    public boolean update(Alumno alumno) {
        String selection = AlumnoContract.AlumnoEntry.COLUMN_NAME_DNI + " = ?";
        String[] selectionArgs = { alumno.getDni() };
        return super.update(
                AlumnoContract.AlumnoEntry.TABLE_NAME,
                alumno.toContentValues(),
                selection,
                selectionArgs);
    }

    /**
     * Funcion que realiza la eliminacion de un elemento sobre la table
     * @param alumno que se va a eliminar
     * @return True en caso de que la eliminación haya sido correcta. False
     * en caso contrario
     */
    public boolean delete(Alumno alumno) {
        String selection = AlumnoContract.AlumnoEntry.COLUMN_NAME_DNI + " = ?";
        String[] selectionArgs = { alumno.getDni() };
        return super.delete(
                AlumnoContract.AlumnoEntry.TABLE_NAME,
                selection,
                selectionArgs);
    }

    /**
     * Funcion que realiza la busqueda de un elemento a traves de su id
     * @param dni del alumno
     * @return con los datos del alimno
     */
    public Alumno searchOne(String dni) {
        Alumno alumno = null;
        String selection = AlumnoContract.AlumnoEntry.COLUMN_NAME_DNI + " = ?";
        String[] selectionArgs = { dni };
        Cursor cursor = super.search(AlumnoContract.AlumnoEntry.TABLE_NAME,
                null,
                selection,
                selectionArgs, null);        if (cursor != null) {
            while(cursor.moveToNext()) {
                alumno = new Alumno(cursor.getString(cursor.getColumnIndexOrThrow(
                        AlumnoContract.AlumnoEntry.COLUMN_NAME_DNI)),
                        cursor.getString(cursor.getColumnIndexOrThrow(
                                AlumnoContract.AlumnoEntry.COLUMN_NAME_NOMBRE)),
                        cursor.getString(cursor.getColumnIndexOrThrow(
                                AlumnoContract.AlumnoEntry.COLUMN_NAME_APELLIDO)),
                        cursor.getString(cursor.getColumnIndexOrThrow(
                                AlumnoContract.AlumnoEntry.COLUMN_NAME_FECHA))
                );
            }
            cursor.close();
        }
        return alumno;
    }

    /**
     * Funcion que realiza la busqueda de todos los alumnos
     * @return lista de alumnos
     */
    public List<Alumno> searchAll() {
        List<Alumno> alumnos = new ArrayList<>();
        Cursor cursor = super.search(AlumnoContract.AlumnoEntry.TABLE_NAME);
        if (cursor != null) {
            while(cursor.moveToNext()) {
                alumnos.add(new Alumno(cursor.getString(cursor.getColumnIndexOrThrow(
                        AlumnoContract.AlumnoEntry.COLUMN_NAME_DNI)),
                        cursor.getString(cursor.getColumnIndexOrThrow(
                                AlumnoContract.AlumnoEntry.COLUMN_NAME_NOMBRE)),
                        cursor.getString(cursor.getColumnIndexOrThrow(
                                AlumnoContract.AlumnoEntry.COLUMN_NAME_APELLIDO)),
                        cursor.getString(cursor.getColumnIndexOrThrow(
                                AlumnoContract.AlumnoEntry.COLUMN_NAME_FECHA)))
                );
            }
            cursor.close();
        }
        return alumnos;
    }

}
