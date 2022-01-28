package iespuertodelacruz.ricardo.institutoapp.adapter;

import android.content.Context;
import android.content.Intent;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.LayoutRes;
import androidx.annotation.NonNull;

import java.util.List;

import iespuertodelacruz.ricardo.institutoapp.R;
import iespuertodelacruz.ricardo.institutoapp.activity.AlumnoActivity;
import iespuertodelacruz.ricardo.institutoapp.model.Alumno;

public class AlumnoAdapter extends ArrayAdapter<Alumno> {

    private Context context;
    private List<Alumno> alumnos;

    public AlumnoAdapter(@NonNull Context context, @LayoutRes int resource, @NonNull List<Alumno> objects) {
        super(context, resource, objects);
        this.context = context;
        this.alumnos = objects;
    }

    @Override
    public View getView(final int pos, View convertView, ViewGroup parent){
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View rowView = inflater.inflate(R.layout.list_alumno, parent, false);

        TextView txtAlumnoDni = (TextView) rowView.findViewById(R.id.txtAlumnoDni);
        TextView txtAlumnoNombre = (TextView) rowView.findViewById(R.id.txtAlumnoNombre);
        TextView txtAlumnoApellido = (TextView) rowView.findViewById(R.id.txtAlumnoApellido);
        TextView txtAlumnoFecha = (TextView) rowView.findViewById(R.id.txtAlumnoFecha);

        txtAlumnoDni.setText(String.format("#DNI: %s", alumnos.get(pos).getDni()));
        txtAlumnoNombre.setText(String.format("ALUMNO NOMBRE: %s", alumnos.get(pos).getNombre()));
        txtAlumnoApellido.setText(String.format("APELLIDO: %s", alumnos.get(pos).getApellido()));
        txtAlumnoFecha.setText(String.format("FECHA NACIMIENTO: %s", alumnos.get(pos).getFechaNac()));

        rowView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //start Activity User Form
                Intent intent = new Intent(context, AlumnoActivity.class);
                intent.putExtra("alumno_dni", String.valueOf(alumnos.get(pos).getDni()));
                intent.putExtra("alumno_nombre", alumnos.get(pos).getNombre());
                intent.putExtra("alumno_apellido", String.valueOf(alumnos.get(pos).getApellido()));
                intent.putExtra("alumno_fecha", alumnos.get(pos).getFechaNac());
                context.startActivity(intent);
            }
        });

        return rowView;
    }
}
