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
import iespuertodelacruz.ricardo.institutoapp.activity.AsigActivity;
import iespuertodelacruz.ricardo.institutoapp.model.Asignatura;

public class AsignaturaAdapter extends ArrayAdapter<Asignatura> {

    private Context context;
    private List<Asignatura> asignaturas;

    public AsignaturaAdapter(@NonNull Context context, @LayoutRes int resource, @NonNull List<Asignatura> objects) {
        super(context, resource, objects);
        this.context = context;
        this.asignaturas = objects;
    }

    @Override
    public View getView(final int pos, View convertView, ViewGroup parent){
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View rowView = inflater.inflate(R.layout.list_asig, parent, false);

        TextView txtAsigId = (TextView) rowView.findViewById(R.id.txtAsigId);
        TextView txtAsigNombre = (TextView) rowView.findViewById(R.id.txtAsigNombre);
        TextView txtAsigCurso = (TextView) rowView.findViewById(R.id.txtAsigCurso);

        txtAsigId.setText(String.format("#ID: %s", asignaturas.get(pos).getId()));
        txtAsigNombre.setText(String.format("NOMBRE: %s", asignaturas.get(pos).getNombre()));
        txtAsigCurso.setText(String.format("CURSO: %s", asignaturas.get(pos).getCurso()));

        rowView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, AsigActivity.class);
                intent.putExtra("asig_id", asignaturas.get(pos).getId());
                intent.putExtra("asig_nombre", asignaturas.get(pos).getNombre());
                intent.putExtra("asig_curso", asignaturas.get(pos).getCurso());
                context.startActivity(intent);
            }
        });

        return rowView;
    }
}

