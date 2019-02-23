package com.example.usuario.tcu_655;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;




public class ConceptosItemsFragment extends Fragment {


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Activity mParentActivity = getActivity();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.items, container, false);
        Bundle args = getArguments();

        assert args != null;
        String nombre = args.getString("titu");
        String descripcion = args.getString("desc");
        String imagen = args.getString("img");

        TextView t = view.findViewById(R.id.titulo);
        TextView d = view.findViewById(R.id.descripcion);
        ImageView i = view.findViewById(R.id.imagen);
        t.setText(nombre);
        d.setText(descripcion);

        assert imagen != null;
        String img = imagen.toLowerCase().substring(0, imagen.length() - 4);
        int id = getContext().getResources().getIdentifier(img,"drawable", getContext().getPackageName());
        i.setImageResource(id);
        return view;
    }
}
