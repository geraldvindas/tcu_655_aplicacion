package com.example.usuario.tcu_655;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ListView;
import java.util.List;

import com.example.usuario.tcu_655.BaseDeDatos.DataBaseAccess;
import com.example.usuario.tcu_655.BaseDeDatos.Leyes;


public class LeyesFragment extends Fragment {

    public static ConceptosFragment me = null;
    static LeyesArrayAdapter leyesArrayAdapter;
    ListView mListView = null;
    static List<Leyes> mLeyes;
    Activity mParentActivity;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mParentActivity = getActivity();
        DataBaseAccess databaseAccess = DataBaseAccess.getInstance(mParentActivity);
        databaseAccess.open();
        mLeyes = databaseAccess.getLeyes();
        databaseAccess.close();
        leyesArrayAdapter = new LeyesArrayAdapter(mParentActivity, R.layout.leyes_item_list, mLeyes, getFragmentManager());
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.list_fragment, container, false);;
        mListView = (ListView) view.findViewById(R.id.lista_datos);
        mListView.setAdapter(leyesArrayAdapter);
        return view;
    }
}
