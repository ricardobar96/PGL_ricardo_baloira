package es.iespuerto.ricardo.booknown.modelo;

import android.text.TextUtils;
import android.util.Patterns;

public class User implements IUser{

    private String email,password;

    /**
     * Constructor de la clase User
     * @param email del usuario
     * @param password del usuario
     */
    public User(String email, String password) {
        this.email = email;
        this.password = password;
    }
    @Override
    public String getEmail() {
        return email;
    }
    @Override
    public String getPassword() {
        return password;
    }

    /**
     * Funcion que verifica si los datos del usuario son validos
     * @return (-1..3)
     *  0. Email Empty
     *  1. Email Match pattern
     *  2. Password Empty
     *  3. Password <= 6
     * -1. Ok
     */
    @Override
    public int isValid() {

        if(TextUtils.isEmpty(getEmail()))
            return  0;
        else if(!Patterns.EMAIL_ADDRESS.matcher(getEmail()).matches())
            return  1;
        else if(TextUtils.isEmpty(getPassword()))
            return 2;
        else if(getPassword().length()<=6)
            return 3;
        else
            return -1;
    }
}
