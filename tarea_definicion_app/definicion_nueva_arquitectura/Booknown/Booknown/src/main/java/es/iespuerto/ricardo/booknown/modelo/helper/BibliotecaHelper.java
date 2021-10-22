package es.iespuerto.ricardo.booknown.modelo.helper;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import java.util.ArrayList;

import androidx.annotation.Nullable;

import java.util.Date;

import es.iespuerto.ricardo.booknown.modelo.Usuario;
import es.iespuerto.ricardo.booknown.modelo.contract.BibliotecaContract;

public class BibliotecaHelper extends SQLiteOpenHelper {
    SQLiteDatabase baseDeDatos = null;

    public BibliotecaHelper(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);

    }

    @Override
    public void onCreate(SQLiteDatabase baseDeDatos) {
        baseDeDatos.execSQL("create table " + BibliotecaContract.BibliotecaEntry.nombreTabla + "(" + BibliotecaContract.BibliotecaEntry.idBiblioteca + " int primary key autoincrement, " + BibliotecaContract.BibliotecaEntry.usuariosSeguidos + " text, " + BibliotecaContract.BibliotecaEntry.librosCreados + " text, " + BibliotecaContract.BibliotecaEntry.librosLeidos + "text)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        baseDeDatos.execSQL("DROP TABLE IF EXISTS " + BibliotecaContract.BibliotecaEntry.nombreTabla);
        onCreate(baseDeDatos);
    }

    public String addRecord(int idBiblioteca, ArrayList<Usuario> usuariosSeguidos, ArrayList<String> librosCreados, ArrayList<String> librosLeidos){
        SQLiteDatabase database = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(BibliotecaContract.BibliotecaEntry.idBiblioteca, idBiblioteca);
        contentValues.put(BibliotecaContract.BibliotecaEntry.usuariosSeguidos, String.valueOf(usuariosSeguidos));
        contentValues.put(BibliotecaContract.BibliotecaEntry.librosCreados, String.valueOf(librosCreados));
        contentValues.put(BibliotecaContract.BibliotecaEntry.librosLeidos, String.valueOf(librosLeidos));

        long resultado = database.insert(BibliotecaContract.BibliotecaEntry.nombreTabla, null, contentValues);
        if(resultado==-1){
            return "No se pudo insertar datos en la tabla";
        }
        else{
            return "Se han insertado los datos en la tabla";
        }
    }
}
