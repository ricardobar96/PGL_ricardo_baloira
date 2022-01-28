package iespuertodelacruz.ricardo.institutoapp.connection;

import java.util.List;

import iespuertodelacruz.ricardo.institutoapp.model.Alumno;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;

public interface AlumnoService {
    @GET("alumnos")
    Call<List<Alumno>> getAlumnos();

    @Headers({"Accept: application/json"})
    @POST("alumnos")
    Call<Alumno> addAlumno(@Body Alumno alumno); //String body

    @PUT("alumnos/{dni}")
    Call<Alumno> updateAlumno(@Path("dni") String dni, @Body Alumno alumno);

    @DELETE("alumnos/{dni}")
    Call<Alumno> deleteAlumno(@Path("dni") String dni);
}
