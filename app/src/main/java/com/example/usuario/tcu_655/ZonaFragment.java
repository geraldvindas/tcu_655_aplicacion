package com.example.usuario.tcu_655;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import com.example.usuario.tcu_655.BaseDeDatos.Zona;
import com.example.usuario.tcu_655.BaseDeDatos.DataBaseAccess;

import java.util.List;

public class ZonaFragment extends Fragment {

    public static ConceptosFragment me = null;
    static ZonaArrayAdapter zonaAdapter;
    ListView mListView = null;
    static List<Zona> mZonas;
    Activity mParentActivity;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mParentActivity = getActivity();
        DataBaseAccess databaseAccess = DataBaseAccess.getInstance(mParentActivity);
        databaseAccess.open();
        mZonas = databaseAccess.getZona();
        databaseAccess.close();
        zonaAdapter = new ZonaArrayAdapter(mParentActivity, R.layout.concepto_item_list, mZonas);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.list_fragment, container, false);;
        mListView = (ListView) view.findViewById(R.id.lista_datos);
        mListView.setAdapter(zonaAdapter);
        mListView.setOnItemClickListener(
                new AdapterView.OnItemClickListener()
                {


                    @Override
                    public void onItemClick(AdapterView<?> arg0, View view,
                                            int position, long id) {

                        Bundle arg = new Bundle();
                        Zona c = mZonas.get(position);
                        arg.putString("titu", c.getZona());
                        arg.putString("com", c.getComunidades());
                        arg.putString("uso", c.getUso());
                        ZonaItemsFragment fragment = new ZonaItemsFragment();
                        fragment.setArguments(arg);
                        FragmentTransaction transaction = getFragmentManager().beginTransaction();
                        transaction.replace(R.id.mainF, fragment, "tag1");
                        transaction.addToBackStack(null);
                        transaction.commit();
                    }
                }
        );
        return view;
    }
}