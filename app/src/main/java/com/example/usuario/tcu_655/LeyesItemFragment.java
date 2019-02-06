package com.example.usuario.tcu_655;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;



public class LeyesItemFragment extends Fragment {
    public static ConceptosFragment me = null;
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

        View view = inflater.inflate(R.layout.items, container, false);
        Bundle args = getArguments();

        assert args != null;
        String nombre = /*args.getString("nom") + " " +*/ args.getString("art");

        String descripcion = args.getString("desc");
        TextView t = view.findViewById(R.id.titulo);
        TextView d = view.findViewById(R.id.descripcion);
        t.setText(nombre);
        d.setText(descripcion);
        return view;
    }
}