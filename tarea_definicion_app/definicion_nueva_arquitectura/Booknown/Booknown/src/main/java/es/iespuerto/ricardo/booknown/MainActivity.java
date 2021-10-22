package es.iespuerto.ricardo.booknown;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import es.iespuerto.ricardo.booknown.controlador.ILoginController;
import es.iespuerto.ricardo.booknown.controlador.LoginController;
import es.iespuerto.ricardo.booknown.vista.ILoginView;

public class MainActivity extends AppCompatActivity implements ILoginView {

    EditText email,password;
    Button loginb;
    Button botonCrearCuenta;
    ILoginController loginPresenter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        email = (EditText) findViewById(R.id.email);
        password = (EditText)findViewById(R.id.password);
        loginb = (Button) findViewById(R.id.loginb);
        botonCrearCuenta = (Button) findViewById(R.id.botonCrearCuenta);
        loginPresenter = new LoginController(this);
        loginb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                loginPresenter.OnLogin(email.getText().toString().trim(),password.getText().toString().trim());
            }
        });

        botonCrearCuenta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), PantallaCrearUsuario.class);
                startActivity(intent);
            }
        });
    }
    @Override
    public void OnLoginSuccess(String message) {
        Toast.makeText(this,message,Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(this, PantallaPrincipal.class);
        startActivity(intent);
    }
    @Override
    public void OnLoginError(String message) {
        Toast.makeText(this,message,Toast.LENGTH_SHORT).show();
    }
}