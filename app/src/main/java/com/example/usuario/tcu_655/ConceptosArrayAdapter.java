package com.example.usuario.tcu_655;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.example.usuario.tcu_655.BaseDeDatos.Conceptos;
import java.util.List;


public class ConceptosArrayAdapter extends ArrayAdapter<Conceptos> {

    List<Conceptos> lista;

    public ConceptosArrayAdapter(Context context, int textViewResourceId, List<Conceptos> objects) {
        super(context, textViewResourceId, objects);
        lista = objects;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        Context context = getContext();
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View v = inflater.inflate(R.layout.concepto_item_list, null);
        Conceptos dato = lista.get(position);
        TextView nombre = (TextView) v.findViewById(R.id.nombre);
        nombre.setText(dato.getNombre());
        ImageView imagen = (ImageView) v.findViewById(R.id.imagen);

        if(dato.getEtiqueta() != "" && dato.getEtiqueta() != null) {
            int id = context.getResources().getIdentifier("cat"+dato.getEtiqueta().toLowerCase(),"drawable", context.getPackageName());
            imagen.setBackgroundResource(id);
            //imagen.setBackgroundResource(R.drawable.water);
        }


        return v;

    }
}
