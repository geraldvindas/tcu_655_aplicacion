package com.example.usuario.tcu_655;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

public class AsadasItemsFragment extends Fragment {
    public static AsadasFragment me = null;
    ListView mListView = null;
    Activity mParentActivity;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mParentActivity = getActivity();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.items_asadas, container, false);;
        Bundle args = getArguments();
        String nombre = args.getString("titu");
        String canton = args.getString("can");
        int cantC = args.getInt("cC");
        int cantP = args.getInt("cP");
        int fundacion = args.getInt("fund");
        String condicion = args.getString("cond");
        TextView t = (TextView) view.findViewById(R.id.titulo);
        TextView d = (TextView) view.findViewById(R.id.canton);
        TextView e = (TextView) view.findViewById(R.id.cantC);
        TextView f = (TextView) view.findViewById(R.id.cantP);
        TextView g = (TextView) view.findViewById(R.id.fundacion);
        TextView h = (TextView) view.findViewById(R.id.condicion);
        t.setText(nombre);
        if(canton != (null)) d.setText("Cantón: "+canton);
        if(cantC!= (0)) e.setText("Número de comunidades que abastece: : "+cantC);
        if(cantP!= (0)) f.setText("Población abastecida: "+cantP);
        if(fundacion!= (0)) g.setText("Fundación: "+fundacion);
        if(condicion!= (null)) h.setText("Condición: "+condicion);

        return view;
    }
}

