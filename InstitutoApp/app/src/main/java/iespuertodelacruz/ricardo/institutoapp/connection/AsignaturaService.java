package iespuertodelacruz.ricardo.institutoapp.connection;

import java.util.List;

import iespuertodelacruz.ricardo.institutoapp.model.Asignatura;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.DELETE;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Path;

public interface AsignaturaService {
    @GET("asignaturas")
    Call<List<Asignatura>> getAsignaturas();

    @Headers({"Accept: application/json"})
    @POST("asignaturas")
    Call<Asignatura> addAsignatura(@Body Asignatura asignatura);

    @PUT("asignaturas/{id}")
    Call<Asignatura> updateAsignatura(@Path("id") int id, @Body Asignatura asignatura);

    @DELETE("asignaturas/{id}")
    Call<Asignatura> deleteAsignatura(@Path("id") int id);
}
