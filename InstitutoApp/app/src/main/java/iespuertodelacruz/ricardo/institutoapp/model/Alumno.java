package iespuertodelacruz.ricardo.institutoapp.model;

import android.content.ContentValues;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import iespuertodelacruz.ricardo.institutoapp.database.contract.AlumnoContract;

public class Alumno {
    @SerializedName("dni")
    @Expose
    private String dni;

    @SerializedName("nombre")
    @Expose
    private String nombre;

    @SerializedName("apellidos")
    @Expose
    private String apellido;

    @SerializedName("fechanacimiento")
    @Expose
    private Long fechaNac;

    public Alumno() {
    }

    public Alumno(String dni, String nombre, String apellido, Long fechaNac) {
        this.dni = dni;
        this.nombre = nombre;
        this.apellido = apellido;
        this.fechaNac = fechaNac;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public Long getFechaNac() {
        return fechaNac;
    }

    public void setFechaNac(Long fechaNac) {
        this.fechaNac = fechaNac;
    }

    public ContentValues toContentValues() {
        ContentValues values = new ContentValues();
        values.put(AlumnoContract.AlumnoEntry.COLUMN_NAME_DNI, this.dni);
        values.put(AlumnoContract.AlumnoEntry.COLUMN_NAME_NOMBRE, this.nombre);
        values.put(AlumnoContract.AlumnoEntry.COLUMN_NAME_APELLIDO, this.apellido);
        values.put(AlumnoContract.AlumnoEntry.COLUMN_NAME_FECHA, this.fechaNac);
        return values;
    }

    @Override
    public String toString() {
        return "Alumno{" +
                "dni='" + dni + '\'' +
                ", nombre='" + nombre + '\'' +
                ", apellido='" + apellido + '\'' +
                ", fechaNac='" + fechaNac + '\'' +
                '}';
    }
}
