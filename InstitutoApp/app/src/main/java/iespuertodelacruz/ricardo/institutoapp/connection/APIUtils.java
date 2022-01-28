package iespuertodelacruz.ricardo.institutoapp.connection;

import iespuertodelacruz.ricardo.institutoapp.connection.retrofit.RetrofitClient;

public class APIUtils {
    private APIUtils(){
    };

    public static final String API_URL = "https://rest-instituto.herokuapp.com/api/";
    public static final String API_URL_ASIG = "https://rest-instituto.herokuapp.com/api/asignaturas/";

    public static AlumnoService getAlumnoService(){
        return RetrofitClient.getClient(API_URL).create(AlumnoService.class);
    }

    public static AsignaturaService getAsignaturaService(){
        return RetrofitClient.getClient(API_URL_ASIG).create(AsignaturaService.class);
    }
}
