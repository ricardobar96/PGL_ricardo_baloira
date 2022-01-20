package iespuertodelacruz.ricardo.institutoapp.model;

import android.content.ContentValues;

import iespuertodelacruz.ricardo.institutoapp.database.contract.AlumnoContract;

public class Alumno {
    private String dni;
    private String nombre;
    private String apellido;
    private String fechaNac;

    public Alumno() {
    }

    public Alumno(String dni, String nombre, String apellido, String fechaNac) {
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

    public String getFechaNac() {
        return fechaNac;
    }

    public void setFechaNac(String fechaNac) {
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
}
