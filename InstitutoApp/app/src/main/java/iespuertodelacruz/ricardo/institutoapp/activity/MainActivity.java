package iespuertodelacruz.ricardo.institutoapp.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import iespuertodelacruz.ricardo.institutoapp.R;

import java.util.ArrayList;
import java.util.List;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import iespuertodelacruz.ricardo.institutoapp.adapter.AlumnoAdapter;
import iespuertodelacruz.ricardo.institutoapp.adapter.AsignaturaAdapter;
import iespuertodelacruz.ricardo.institutoapp.connection.APIUtils;
import iespuertodelacruz.ricardo.institutoapp.connection.AsignaturaService;
import iespuertodelacruz.ricardo.institutoapp.model.Alumno;
import iespuertodelacruz.ricardo.institutoapp.connection.AlumnoService;

import iespuertodelacruz.ricardo.institutoapp.model.Asignatura;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    Button btnAddALumno;
    Button btnGetalumnosList;
    //Button botonAlumno;
    ListView listView;
    AlumnoService alumnoService = APIUtils.getAlumnoService();
    AsignaturaService asignaturaService = APIUtils.getAsignaturaService();
    List<Alumno> list = new ArrayList<Alumno>();
    List<Asignatura> listAs = new ArrayList<Asignatura>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //botonAlumno = (Button) findViewById(R.id.buttonAlumno);
        listView = findViewById(R.id.listView);
        getAlumnosList();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.menu_listas, menu);
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem item){
        switch(item.getItemId()){
            case R.id.menuAlumnos:
                getAlumnosList();
                Toast.makeText(MainActivity.this, "Cargada lista de alumnos",
                        Toast.LENGTH_SHORT).show();
                break;
            case R.id.menuAsignaturas:
                getAsigList();
                Toast.makeText(MainActivity.this, "Cargada lista de asignaturas",
                        Toast.LENGTH_SHORT).show();
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    public void getAlumnosList(){
        Call<List<Alumno>> call = alumnoService.getAlumnos();
        call.enqueue(new Callback<List<Alumno>>() {
            @Override
            public void onResponse(Call<List<Alumno>> call, Response<List<Alumno>> response) {
                if(response.isSuccessful()){
                    list = response.body();

//                    for(int i=0; i<list.size(); i++){
//                        System.out.println(list.get(i));
//                    }

                    listView.setAdapter(
                            new AlumnoAdapter(MainActivity.this,
                                    R.layout.list_alumno, list));
                }
            }

            @Override
            public void onFailure(Call<List<Alumno>> call, Throwable t) {
                Log.e("ERROR: ", t.getMessage());
            }
        });
    }

    public void getAsigList(){
        Call<List<Asignatura>> call = asignaturaService.getAsignaturas();
        call.enqueue(new Callback<List<Asignatura>>() {
            @Override
            public void onResponse(Call<List<Asignatura>> call, Response<List<Asignatura>> response) {
                if(response.isSuccessful()){
                    listAs = response.body();

//                    for(int i=0; i<listAs.size(); i++){
//                        System.out.println(listAs.get(i));
//                    }

                    listView.setAdapter(
                            new AsignaturaAdapter(MainActivity.this,
                                    R.layout.list_asig, listAs));
                }
            }

            @Override
            public void onFailure(Call<List<Asignatura>> call, Throwable t) {
                Log.e("ERROR: ", t.getMessage());
            }
        });
    }
    /*
    public void accionesAlumno(View view) {
        Intent cambioAlumno = new Intent(MainActivity.this,
                AlumnoActivity.class);
        startActivity(cambioAlumno);
    }
    */
}