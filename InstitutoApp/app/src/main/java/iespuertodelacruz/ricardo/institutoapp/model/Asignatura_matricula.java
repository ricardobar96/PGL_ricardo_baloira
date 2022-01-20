package iespuertodelacruz.ricardo.institutoapp.model;

import android.content.ContentValues;

import iespuertodelacruz.ricardo.institutoapp.database.contract.Asig_MatriculaContract;
import iespuertodelacruz.ricardo.institutoapp.database.contract.AsignaturaContract;

public class Asignatura_matricula {
    private int id;
    private int idMatricula;
    private int idAsignatura;

    public Asignatura_matricula() {
    }

    public Asignatura_matricula(int id, int idMatricula, int idAsignatura) {
        this.id = id;
        this.idMatricula = idMatricula;
        this.idAsignatura = idAsignatura;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdMatricula() {
        return idMatricula;
    }

    public void setIdMatricula(int idMatricula) {
        this.idMatricula = idMatricula;
    }

    public int getIdAsignatura() {
        return idAsignatura;
    }

    public void setIdAsignatura(int idAsignatura) {
        this.idAsignatura = idAsignatura;
    }

    public ContentValues toContentValues() {
        ContentValues values = new ContentValues();
        values.put(Asig_MatriculaContract.Asig_MatriculaEntry._ID, this.id);
        values.put(Asig_MatriculaContract.Asig_MatriculaEntry.COLUMN_NAME_IDMATRICULA, this.idMatricula);
        values.put(Asig_MatriculaContract.Asig_MatriculaEntry.COLUMN_NAME_IDASIGNATURA, this.idAsignatura);
        return values;
    }
}
