package iespuertodelacruz.ricardo.institutoapp.model;

import android.content.ContentValues;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import iespuertodelacruz.ricardo.institutoapp.database.contract.AlumnoContract;
import iespuertodelacruz.ricardo.institutoapp.database.contract.AsignaturaContract;

public class Asignatura {
    @SerializedName("idasignatura")
    @Expose
    private int id;

    @SerializedName("nombre")
    @Expose
    private String nombre;

    @SerializedName("curso")
    @Expose
    private String curso;

    public Asignatura() {
    }

    public Asignatura(int id, String nombre, String curso) {
        this.id = id;
        this.nombre = nombre;
        this.curso = curso;
    }

    public Asignatura(String nombre, String curso) {
        this.nombre = nombre;
        this.curso = curso;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCurso() {
        return curso;
    }

    public void setCurso(String curso) {
        this.curso = curso;
    }

    @Override
    public String toString() {
        return "Asignatura{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", curso='" + curso + '\'' +
                '}';
    }

    public ContentValues toContentValues() {
        ContentValues values = new ContentValues();
        values.put(AsignaturaContract.AsignaturaEntry._ID, this.id);
        values.put(AsignaturaContract.AsignaturaEntry.COLUMN_NAME_NOMBRE, this.nombre);
        values.put(AsignaturaContract.AsignaturaEntry.COLUMN_NAME_CURSO, this.curso);
        return values;
    }
}
