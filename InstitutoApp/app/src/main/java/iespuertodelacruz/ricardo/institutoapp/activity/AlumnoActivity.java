package iespuertodelacruz.ricardo.institutoapp.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;


import android.content.Intent;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;

import iespuertodelacruz.ricardo.institutoapp.model.Alumno;
import iespuertodelacruz.ricardo.institutoapp.connection.APIUtils;
import iespuertodelacruz.ricardo.institutoapp.connection.AlumnoService;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import iespuertodelacruz.ricardo.institutoapp.R;

public class AlumnoActivity extends AppCompatActivity {
    AlumnoService alumnoService;
    EditText edtADni;
    EditText edtANombre;
    EditText edtAApellido;
    EditText edtAFecha;
    Button btnSave;
    Button btnDel;
    TextView txtADni;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alumno);

        setTitle("Alumnos");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        txtADni = (TextView) findViewById(R.id.txtADni);
        edtADni = (EditText) findViewById(R.id.edtADni);
        edtANombre = (EditText) findViewById(R.id.edtANombre);
        edtAApellido = (EditText) findViewById(R.id.edtAApellido);
        edtAFecha = (EditText) findViewById(R.id.edtAFecha);
        btnSave = (Button) findViewById(R.id.btnSave);
        btnDel = (Button) findViewById(R.id.btnDel);

        alumnoService = APIUtils.getAlumnoService();

        Bundle extras = getIntent().getExtras();
        String alumnoDni = extras.getString("alumno_dni"); //ESTO COGE DATOS SELECCIONADOS DE BBDD; AL NO EXISTIR ESTOS DATOS DA ERROR
        String alumnoNombre = extras.getString("alumno_nombre");
        String alumnoApellido = extras.getString("alumno_apellido");
        String alumnoFecha = String.valueOf(extras.getLong("alumno_fecha"));

        edtADni.setText(alumnoDni);
        edtANombre.setText(alumnoNombre);
        edtAApellido.setText(alumnoApellido);
        edtAFecha.setText(alumnoFecha);

        if(alumnoDni != null && alumnoDni.trim().length() > 0 ){
            //edtADni.setFocusable(false); ESTO NO PERMITE ESCRIBIR EN DNI ALUMNO SI YA EXISTE
        } else {
            txtADni.setVisibility(View.INVISIBLE);
            edtADni.setVisibility(View.INVISIBLE);
            btnDel.setVisibility(View.INVISIBLE);
        }

        btnSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Alumno alumno = new Alumno();
                alumno.setDni(edtADni.getText().toString());
                alumno.setNombre(edtANombre.getText().toString());
                alumno.setApellido(edtAApellido.getText().toString());
                alumno.setFechaNac(Long.parseLong(edtAFecha.getText().toString()));

                if(alumnoDni.equals(edtADni.getText().toString())){
                    updateAlumno(alumnoDni, alumno);

                    Intent intent = new Intent(AlumnoActivity.this, MainActivity.class);
                    startActivity(intent);
                }

                Call<Alumno> call = alumnoService.addAlumno(alumno);

                Intent intent = new Intent(AlumnoActivity.this, MainActivity.class);
                startActivity(intent);

                call.enqueue(new Callback<Alumno>() {
                    @Override
                    public void onResponse(Call<Alumno> call, Response<Alumno> response) {
                        if (response.isSuccessful()){
                            Toast.makeText(AlumnoActivity.this,
                                    "Alumno creado"+response.code(),
                                    Toast.LENGTH_SHORT).show();
                        }
                    }

                    @Override
                    public void onFailure(Call<Alumno> call, Throwable t) {
                        Log.e("ERROR: ", t.getMessage());
                    }
                });
            }
        });

        btnDel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                deleteAlumno((alumnoDni));

                Intent intent = new Intent(AlumnoActivity.this, MainActivity.class);
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
    public void updateAlumno(String dni, Alumno a){
        Call<Alumno> call = alumnoService.updateAlumno(dni, a);

        call.enqueue(new Callback<Alumno>() {
            @Override
            public void onResponse(Call<Alumno> call, Response<Alumno> response) {
                if(response.isSuccessful()){
                    Toast.makeText(AlumnoActivity.this, "Alumno updated successfully!", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<Alumno> call, Throwable t) {
                Log.e("ERROR: ", t.getMessage());
            }
        });
    }

    public void deleteAlumno(String dni){
        Call<Alumno> call = alumnoService.deleteAlumno(dni);
        call.enqueue(new Callback<Alumno>() {
            @Override
            public void onResponse(Call<Alumno> call, Response<Alumno> response) {
                if(response.isSuccessful()){
                    Toast.makeText(AlumnoActivity.this, "Alumno borrado",
                            Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<Alumno> call, Throwable t) {
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