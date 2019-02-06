package com.example.usuario.tcu_655;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import com.example.usuario.tcu_655.BaseDeDatos.Zona;

import java.util.List;

public class ZonaArrayAdapter extends ArrayAdapter<Zona> {

    List<Zona> lista;

    public ZonaArrayAdapter(Context context, int textViewResourceId, List<Zona> objects) {
        super(context, textViewResourceId, objects);
        lista = objects;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        Context context = getContext();
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        assert inflater != null;
        View v = inflater.inflate(R.layout.concepto_item_list, null);

        Zona dato = lista.get(position);
        TextView nombre = v.findViewById(R.id.nombre);
        nombre.setText(dato.getZona());
        return v;

    }
}
