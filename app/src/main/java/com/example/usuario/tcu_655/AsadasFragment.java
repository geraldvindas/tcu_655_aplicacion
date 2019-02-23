package com.example.usuario.tcu_655;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import java.util.List;

import com.example.usuario.tcu_655.BaseDeDatos.Asadas;
import com.example.usuario.tcu_655.BaseDeDatos.DataBaseAccess;


public class AsadasFragment extends Fragment {

    private static AsadasArrayAdapter asadaAdapter;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Activity mParentActivity = getActivity();
        DataBaseAccess databaseAccess = DataBaseAccess.getInstance(mParentActivity);
        databaseAccess.open();
        List<Asadas> mAsadas = databaseAccess.getAsadas();
        databaseAccess.close();
        asadaAdapter = new AsadasArrayAdapter(mParentActivity, R.layout.asadas_item_list, mAsadas, getFragmentManager());
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.list_fragment, container, false);
        ListView mListView = view.findViewById(R.id.lista_datos);
        mListView.setAdapter(asadaAdapter);
        return view;
    }
}
