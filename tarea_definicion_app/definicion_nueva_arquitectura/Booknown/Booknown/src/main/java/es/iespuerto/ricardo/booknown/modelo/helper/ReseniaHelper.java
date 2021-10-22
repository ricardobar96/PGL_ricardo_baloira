package es.iespuerto.ricardo.booknown.modelo.helper;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.util.Date;

import es.iespuerto.ricardo.booknown.modelo.contract.ReseniaContract;

public class ReseniaHelper extends SQLiteOpenHelper {
    SQLiteDatabase baseDeDatos = null;

    public ReseniaHelper(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);

    }

    @Override
    public void onCreate(SQLiteDatabase baseDeDatos) {
        baseDeDatos.execSQL("create table " + ReseniaContract.ReseniaEntry.nombreTabla + "(" + ReseniaContract.ReseniaEntry.idResenia + " int primary key autoincrement, " + ReseniaContract.ReseniaEntry.puntuacion + " int, " + ReseniaContract.ReseniaEntry.meGusta + " int, " + ReseniaContract.ReseniaEntry.autor + "text, " + ReseniaContract.ReseniaEntry.libroTitulo + " text, " + ReseniaContract.ReseniaEntry.fecha + " text)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        baseDeDatos.execSQL("DROP TABLE IF EXISTS " + ReseniaContract.ReseniaEntry.nombreTabla);
        onCreate(baseDeDatos);
    }

    public String addRecord(int idResenia, int puntuacion, int meGusta, String autor, String libroTitulo, Date fecha){
        SQLiteDatabase database = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(ReseniaContract.ReseniaEntry.idResenia, idResenia);
        contentValues.put(ReseniaContract.ReseniaEntry.puntuacion, puntuacion);
        contentValues.put(ReseniaContract.ReseniaEntry.meGusta, meGusta);
        contentValues.put(ReseniaContract.ReseniaEntry.autor, autor);
        contentValues.put(ReseniaContract.ReseniaEntry.libroTitulo, libroTitulo);
        contentValues.put(ReseniaContract.ReseniaEntry.fecha, String.valueOf(fecha));

        long resultado = database.insert(ReseniaContract.ReseniaEntry.nombreTabla, null, contentValues);
        if(resultado==-1){
            return "No se pudo insertar datos en la tabla";
        }
        else{
            return "Se han insertado los datos en la tabla";
        }
    }
}
