package com.example.usuario.tcu_655;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.*;
import com.example.usuario.tcu_655.BaseDeDatos.Asadas;
import com.example.usuario.tcu_655.BaseDeDatos.TomasDeAgua;

import java.util.List;

public class AsadasArrayAdapter extends ArrayAdapter<Asadas> {

    private List<Asadas> lista;
    private FragmentManager manager;

    public AsadasArrayAdapter(Context context, int textViewResourceId, List<Asadas> objects, FragmentManager manager) {
        super(context, textViewResourceId, objects);
        this.manager = manager;
        lista = objects;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        Context context = getContext();
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        assert inflater != null;
        View v = inflater.inflate(R.layout.asadas_item_list, null);

        Asadas dato = lista.get(position);
        TextView nombre = v.findViewById(R.id.nombre);
        nombre.setText(dato.getNombre());
        nombre.setOnClickListener(new View.OnClickListener() {

                    @Override
                    public void onClick(View v) {
                        Bundle arg = new Bundle();
                        Asadas c = lista.get(position);
                        arg.putString("titu", c.getNombre());
                        arg.putString("can", c.getCanton());
                        arg.putInt("cC", c.getNumeroComunidadesAbastece());
                        arg.putInt("cP", c.getPoblacionAbastecidad());
                        arg.putInt("fund", c.getAñoConstrucción());
                        arg.putString("cond", c.getCondicion());
                        AsadasItemsFragment fragment = new AsadasItemsFragment();
                        fragment.setArguments(arg);
                        FragmentTransaction transaction = manager.beginTransaction();
                        transaction.replace(R.id.mainF, fragment, "tag1");
                        transaction.addToBackStack(null);
                        transaction.commit();
                    }
                }
        );
        TomasDeAgua toma = dato.getToma();
        if(toma != null) {
            LinearLayout sublista = v.findViewById(R.id.sub_lista);
            View vi = inflater.inflate(R.layout.concepto_item_list, null);
            TextView text = vi.findViewById(R.id.nombre);
            text.setText("Toma de agua 1");
            sublista.addView(vi);
            vi.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Bundle arg = new Bundle();
                    arg.putString("toma", "Toma 1");
                    arg.putString("desc", toma.getDescripcion1());
                    arg.putString("img", toma.getImagen1());
                    TomasItemFragment fragment = new TomasItemFragment();
                    fragment.setArguments(arg);
                    FragmentTransaction transaction = manager.beginTransaction();
                    transaction.replace(R.id.mainF, fragment, "tag1");
                    transaction.addToBackStack(null);
                    transaction.commit();
                }
            });

            View vi2 = inflater.inflate(R.layout.concepto_item_list, null);
            TextView text2 = vi2.findViewById(R.id.nombre);
            text2.setText("Toma de agua 2");
            sublista.addView(vi2);
            vi2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Bundle arg = new Bundle();
                    arg.putString("toma", "Toma 2");
                    arg.putString("desc", toma.getDescripcion2());
                    arg.putString("imagen", toma.getImagen2());
                    TomasItemFragment fragment = new TomasItemFragment();
                    fragment.setArguments(arg);
                    FragmentTransaction transaction = manager.beginTransaction();
                    transaction.replace(R.id.mainF, fragment, "tag2");
                    transaction.addToBackStack(null);
                    transaction.commit();
                }
            });

            ImageButton button = v.findViewById(R.id.button);
            button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (sublista.getVisibility() == View.VISIBLE) {
                        sublista.setVisibility(View.GONE);
                    } else {
                        sublista.setVisibility(View.VISIBLE);
                    }
                }
            });
        }
        return v;
    }
}
