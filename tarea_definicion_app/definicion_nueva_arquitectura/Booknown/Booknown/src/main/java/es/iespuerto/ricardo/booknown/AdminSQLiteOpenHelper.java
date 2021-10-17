package es.iespuerto.ricardo.booknown;
import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class AdminSQLiteOpenHelper extends SQLiteOpenHelper{
    SQLiteDatabase baseDeDatos = null;

    public AdminSQLiteOpenHelper(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);

    }

    @Override
    public void onCreate(SQLiteDatabase baseDeDatos) {
        baseDeDatos.execSQL("create table usuarios(idUsuario int primary key autoincrement, nombre text, correo text, contrasenia text, avatar text, seguidores int, especial boolean)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        baseDeDatos.execSQL("DROP TABLE IF EXISTS usuarios");
        onCreate(baseDeDatos);
    }

    public String addRecord(String nombre, String correo, String contrasenia, String avatar, int seguidores, boolean especial){
        SQLiteDatabase database = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("nombre", nombre);
        contentValues.put("correo", correo);
        contentValues.put("contrasenia", contrasenia);
        contentValues.put("avatar", avatar);
        contentValues.put("seguidores", seguidores);
        contentValues.put("especial", especial);

        long resultado = database.insert("usuarios", null, contentValues);
        if(resultado==-1){
            return "No se pudo insertar datos en la tabla";
        }
        else{
            return "Se han insertado los datos en la tabla";
        }
    }
}
