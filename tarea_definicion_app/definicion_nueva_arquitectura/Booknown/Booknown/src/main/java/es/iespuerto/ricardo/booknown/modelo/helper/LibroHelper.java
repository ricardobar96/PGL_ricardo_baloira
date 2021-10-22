package es.iespuerto.ricardo.booknown.modelo.helper;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import es.iespuerto.ricardo.booknown.modelo.contract.LibroContract;
import java.util.Date;

public class LibroHelper extends SQLiteOpenHelper {
    SQLiteDatabase baseDeDatos = null;

    public LibroHelper(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);

    }

    @Override
    public void onCreate(SQLiteDatabase baseDeDatos) {
        baseDeDatos.execSQL("create table " + LibroContract.LibroEntry.nombreTabla + "(" + LibroContract.LibroEntry.idLibro + " int primary key autoincrement, " + LibroContract.LibroEntry.visualizaciones + " int, " + LibroContract.LibroEntry.paginas + " int, " + LibroContract.LibroEntry.puntuacionMedia + "double, " + LibroContract.LibroEntry.titulo + " text, " + LibroContract.LibroEntry.autor + " text, " + LibroContract.LibroEntry.genero + " text, " + LibroContract.LibroEntry.fechaActualizacion + " text, " + LibroContract.LibroEntry.fechaPublicacion + " text, " + LibroContract.LibroEntry.pagoOpcional + " boolean)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        baseDeDatos.execSQL("DROP TABLE IF EXISTS " + LibroContract.LibroEntry.nombreTabla);
        onCreate(baseDeDatos);
    }

    public String addRecord(int idLibro, int visualizaciones, int paginas, int puntuacionMedia, String titulo, String autor, String genero, Date fechaActualizacion, Date fechaPublicacion, boolean pagoOpcional){
        SQLiteDatabase database = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(LibroContract.LibroEntry.idLibro, idLibro);
        contentValues.put(LibroContract.LibroEntry.visualizaciones, visualizaciones);
        contentValues.put(LibroContract.LibroEntry.paginas, paginas);
        contentValues.put(LibroContract.LibroEntry.puntuacionMedia, puntuacionMedia);
        contentValues.put(LibroContract.LibroEntry.titulo, titulo);
        contentValues.put(LibroContract.LibroEntry.autor, autor);
        contentValues.put(LibroContract.LibroEntry.genero, genero);
        contentValues.put(LibroContract.LibroEntry.fechaActualizacion, String.valueOf(fechaActualizacion));
        contentValues.put(LibroContract.LibroEntry.fechaPublicacion, String.valueOf(fechaPublicacion));
        contentValues.put(LibroContract.LibroEntry.pagoOpcional, pagoOpcional);

        long resultado = database.insert(LibroContract.LibroEntry.nombreTabla, null, contentValues);
        if(resultado==-1){
            return "No se pudo insertar datos en la tabla";
        }
        else{
            return "Se han insertado los datos en la tabla";
        }
    }
}
