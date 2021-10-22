package es.iespuerto.ricardo.booknown.modelo.helper;
import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import es.iespuerto.ricardo.booknown.modelo.Libro;
import es.iespuerto.ricardo.booknown.modelo.contract.BibliotecaContract;
import es.iespuerto.ricardo.booknown.modelo.contract.LibroContract;
import es.iespuerto.ricardo.booknown.modelo.contract.ReseniaContract;
import es.iespuerto.ricardo.booknown.modelo.contract.UsuarioContract;

import androidx.annotation.Nullable;

public class UsuarioHelper extends SQLiteOpenHelper{
    SQLiteDatabase baseDeDatos = null;

    public UsuarioHelper(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);

    }

    @Override
    public void onCreate(SQLiteDatabase baseDeDatos) {
        //baseDeDatos.execSQL("create table usuarios(idUsuario int primary key autoincrement, nombre text, correo text, contrasenia text, avatar text, seguidores int, especial boolean)");
        baseDeDatos.execSQL("create table " + UsuarioContract.UsuarioEntry.nombreTabla + "(" + UsuarioContract.UsuarioEntry.idUsuario + " int primary key autoincrement, " + UsuarioContract.UsuarioEntry.nombre + " text, " + UsuarioContract.UsuarioEntry.correo + " text, " + UsuarioContract.UsuarioEntry.contrasenia + "text, " + UsuarioContract.UsuarioEntry.avatar + " text, " + UsuarioContract.UsuarioEntry.seguidores + " int, " + UsuarioContract.UsuarioEntry.especial + " boolean)");
        //baseDeDatos.execSQL("create table " + LibroContract.LibroEntry.nombreTabla + "(" + LibroContract.LibroEntry.idLibro + " int primary key autoincrement, " + LibroContract.LibroEntry.visualizaciones + " int, " + LibroContract.LibroEntry.paginas + " int, " + LibroContract.LibroEntry.puntuacionMedia + "double, " + LibroContract.LibroEntry.titulo + " text, " + LibroContract.LibroEntry.autor + " text, " + LibroContract.LibroEntry.genero + " text, " + LibroContract.LibroEntry.fechaActualizacion + " date, " + LibroContract.LibroEntry.fechaPublicacion + " date, " + LibroContract.LibroEntry.pagoOpcional + " boolean)");
        //baseDeDatos.execSQL("create table " + ReseniaContract.ReseniaEntry.nombreTabla + "(" + ReseniaContract.ReseniaEntry.idResenia + " int primary key autoincrement, " + ReseniaContract.ReseniaEntry.puntuacion + " int, " + ReseniaContract.ReseniaEntry.meGusta + " int, " + ReseniaContract.ReseniaEntry.autor + "text, " + ReseniaContract.ReseniaEntry.libroTitulo + " text, " + ReseniaContract.ReseniaEntry.fecha + " date)");
        //baseDeDatos.execSQL("create table " + BibliotecaContract.BibliotecaEntry.nombreTabla + "(" + BibliotecaContract.BibliotecaEntry.idBiblioteca + " int primary key autoincrement, " + BibliotecaContract.BibliotecaEntry.usuariosSeguidos + " text, " + BibliotecaContract.BibliotecaEntry.librosCreados + " text, " + BibliotecaContract.BibliotecaEntry.librosLeidos + "text)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        baseDeDatos.execSQL("DROP TABLE IF EXISTS " + UsuarioContract.UsuarioEntry.nombreTabla);
        onCreate(baseDeDatos);
    }

    public String addRecord(int idUsuario, String nombre, String correo, String contrasenia, String avatar, int seguidores, boolean especial){
        SQLiteDatabase database = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("idUsuario", idUsuario);
        contentValues.put("nombre", nombre);
        contentValues.put("correo", correo);
        contentValues.put("contrasenia", contrasenia);
        contentValues.put("avatar", avatar);
        contentValues.put("seguidores", seguidores);
        contentValues.put("especial", especial);

        long resultado = database.insert(UsuarioContract.UsuarioEntry.nombreTabla, null, contentValues);
        if(resultado==-1){
            return "No se pudo insertar datos en la tabla";
        }
        else{
            return "Se han insertado los datos en la tabla";
        }
    }
}
