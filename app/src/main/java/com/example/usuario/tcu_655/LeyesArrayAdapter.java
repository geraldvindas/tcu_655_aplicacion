package com.example.usuario.tcu_655;

import android.support.v4.app.FragmentManager;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.*;

import java.util.List;

import com.example.usuario.tcu_655.BaseDeDatos.Articulo;
import com.example.usuario.tcu_655.BaseDeDatos.Leyes;


public class LeyesArrayAdapter extends ArrayAdapter<Leyes> {

    List<Leyes> lista;
    FragmentManager manager;

    public LeyesArrayAdapter(Context context, int textViewResourceId, List<Leyes> objects, FragmentManager manager) {
        super(context, textViewResourceId, objects);
        lista = objects;
        this.manager = manager;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Context context = getContext();
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View v = inflater.inflate(R.layout.leyes_item_list, null);
        Leyes ley = lista.get(position);
        TextView nombre = (TextView) v.findViewById(R.id.nombre);
        nombre.setText(ley.getNombre());
        List<Articulo> articulos = ley.getArticulos();
        LinearLayout sublista = (LinearLayout)v.findViewById(R.id.sub_lista);
        for (int i=0; i<articulos.size(); i++) {
            Articulo ar = articulos.get(i);
            View vi = inflater.inflate(R.layout.concepto_item_list, null);
            TextView text = (TextView) vi.findViewById(R.id.nombre);
            text.setText(ar.getArticulo());
            sublista.addView(vi);
            vi.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Bundle arg = new Bundle();
                    arg.putString("art", ar.getArticulo());
                    arg.putString("desc", ar.getDescripcion());
                    LeyesItemFragment fragment = new LeyesItemFragment();
                    fragment.setArguments(arg);
                    FragmentTransaction transaction = manager.beginTransaction();
                    transaction.replace(R.id.mainF, fragment, "tag1");
                    transaction.addToBackStack(null);
                    transaction.commit();
                }
            });
        }
        ImageButton button = (ImageButton) v.findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(sublista.getVisibility() == View.VISIBLE){
                    sublista.setVisibility(View.GONE);
                }
                else{
                    sublista.setVisibility(View.VISIBLE);
                }
            }
        });
        return v;
    }
}
