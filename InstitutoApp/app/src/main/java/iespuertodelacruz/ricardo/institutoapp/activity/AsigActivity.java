package iespuertodelacruz.ricardo.institutoapp.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;

import iespuertodelacruz.ricardo.institutoapp.R;
import iespuertodelacruz.ricardo.institutoapp.connection.APIUtils;
import iespuertodelacruz.ricardo.institutoapp.connection.AlumnoService;
import iespuertodelacruz.ricardo.institutoapp.connection.AsignaturaService;
import iespuertodelacruz.ricardo.institutoapp.model.Alumno;
import iespuertodelacruz.ricardo.institutoapp.model.Asignatura;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class AsigActivity extends AppCompatActivity {
    AsignaturaService asignaturaService;
    EditText edtAsId;
    EditText edtAsNombre;
    EditText edtAsCurso;
    Button btnSaveA;
    Button btnDelA;
    TextView txtAsId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_asig);

        setTitle("Asignaturas");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        txtAsId = (TextView) findViewById(R.id.txtAsId);
        edtAsId = (EditText) findViewById(R.id.edtAsId);
        edtAsNombre = (EditText) findViewById(R.id.edtAsNombre);
        edtAsCurso = (EditText) findViewById(R.id.edtAsCurso);
        btnSaveA = (Button) findViewById(R.id.btnSaveAsig);
        btnDelA = (Button) findViewById(R.id.btnDelAsig);

        asignaturaService = APIUtils.getAsignaturaService();

        Bundle extras = getIntent().getExtras();
        String asigId = String.valueOf(extras.getInt("asig_id")); //ESTO COGE DATOS SELECCIONADOS DE BBDD; AL NO EXISTIR ESTOS DATOS DA ERROR
        String asigNombre = extras.getString("asig_nombre");
        String asigCurso = extras.getString("asig_curso");

        edtAsId.setText(asigId);
        edtAsNombre.setText(asigNombre);
        edtAsCurso.setText(asigCurso);

        if(asigId != null && asigId.trim().length() > 0 ){
            //edtAsId.setFocusable(false); //ESTO NO PERMITE ESCRIBIR EN ASIG ID SI YA EXISTE
        } else {
            txtAsId.setVisibility(View.INVISIBLE);
            edtAsId.setVisibility(View.INVISIBLE);
            btnDelA.setVisibility(View.INVISIBLE);
        }

        btnSaveA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Asignatura asignatura = new Asignatura();
                asignatura.setId(Integer.valueOf(edtAsId.getText().toString()));
                asignatura.setNombre(edtAsNombre.getText().toString());
                asignatura.setCurso(edtAsCurso.getText().toString());

                if(asigId.equals(edtAsId.getText().toString())){
                    updateAsig(Integer.valueOf(asigId), asignatura);

                    Intent intent = new Intent(AsigActivity.this, MainActivity.class);
                    startActivity(intent);
                }
                //new Gson().toJson(asignatura).toString() (PARA CUANDO ES BODY EL TIPO EN SERVICE)
                Asignatura asigC = new Asignatura(asignatura.getNombre(), asignatura.getCurso());
                Call<Asignatura> call = asignaturaService.addAsignatura(asignatura);

                Intent intent = new Intent(AsigActivity.this, MainActivity.class);
                startActivity(intent);

                call.enqueue(new Callback<Asignatura>() {
                    @Override
                    public void onResponse(Call<Asignatura> call, Response<Asignatura> response) {
                        if (response.isSuccessful()){
                            Toast.makeText(AsigActivity.this,
                                    "Asignatura creada "+response.code(),
                                    Toast.LENGTH_SHORT).show();
                        }
                    }

                    @Override
                    public void onFailure(Call<Asignatura> call, Throwable t) {
                        Log.e("ERROR: ", t.getMessage());
                    }
                });
            }
        });

        btnDelA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                deleteAsignatura((Integer.valueOf(asigId)));

                Intent intent = new Intent(AsigActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });

    }
    /*
    public void addUser(Alumno a){
        Call<Alumno> call = alumnoService.addAlumno(new Gson().toJson(a).toString());
        call.enqueue(new Callback<Alumno>() {
            @Override
            public void onResponse(Call<Alumno> call, Response<Alumno> response) {
                if(response.isSuccessful()){
                    Toast.makeText(AlumnoActivity.this, "User created successfully!", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<Alumno> call, Throwable t) {
                Log.e("ERROR: ", t.getMessage());
            }
        });
    }
    */
    public void updateAsig(int id, Asignatura a){
        Call<Asignatura> call = asignaturaService.updateAsignatura(id, a);
        call.enqueue(new Callback<Asignatura>() {
            @Override
            public void onResponse(Call<Asignatura> call, Response<Asignatura> response) {
                if(response.isSuccessful()){
                    Toast.makeText(AsigActivity.this, "Asignatura updated successfully!", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<Asignatura> call, Throwable t) {
                Log.e("ERROR: ", t.getMessage());
            }
        });
    }

    public void deleteAsignatura(int id){
        Call<Asignatura> call = asignaturaService.deleteAsignatura(id);
        call.enqueue(new Callback<Asignatura>() {
            @Override
            public void onResponse(Call<Asignatura> call, Response<Asignatura> response) {
                if(response.isSuccessful()){
                    Toast.makeText(AsigActivity.this, "Asignatura borrada",
                            Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<Asignatura> call, Throwable t) {
                Log.e("ERROR: ", t.getMessage());
            }
        });
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                finish();
                return true;
        }

        return super.onOptionsItemSelected(item);
    }
}