package iespuertodelacruz.ricardo.institutoapp.model;

import android.content.ContentValues;

import iespuertodelacruz.ricardo.institutoapp.database.contract.AlumnoContract;
import iespuertodelacruz.ricardo.institutoapp.database.contract.MatriculaContract;

public class Matricula {
    private int id;
    private String dni;
    private int year;

    public Matricula() {
    }

    public Matricula(int id, String dni, int year) {
        this.id = id;
        this.dni = dni;
        this.year = year;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public ContentValues toContentValues() {
        ContentValues values = new ContentValues();
        values.put(MatriculaContract.MatriculaEntry._ID, this.id);
        values.put(MatriculaContract.MatriculaEntry.COLUMN_NAME_DNI, this.dni);
        values.put(MatriculaContract.MatriculaEntry.COLUMN_NAME_YEAR, this.year);
        return values;
    }
}
