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
import java.util.List;

import com.example.usuario.tcu_655.BaseDeDatos.Conceptos;
import com.example.usuario.tcu_655.BaseDeDatos.DataBaseAccess;




public class ConceptosFragment extends Fragment {

    private static ConceptosArrayAdapter conceptAdapter;
    private static List<Conceptos> mConceptos;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Activity mParentActivity = getActivity();
        DataBaseAccess databaseAccess = DataBaseAccess.getInstance(mParentActivity);
        databaseAccess.open();
        mConceptos = databaseAccess.getConceptos();
        databaseAccess.close();
        conceptAdapter = new ConceptosArrayAdapter(mParentActivity, R.layout.concepto_item_list, mConceptos);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.list_fragment, container, false);
        ListView mListView = view.findViewById(R.id.lista_datos);
        mListView.setAdapter(conceptAdapter);
        mListView.setOnItemClickListener(
                new AdapterView.OnItemClickListener()
                {


                    @Override
                    public void onItemClick(AdapterView<?> arg0, View view,
                                            int position, long id) {

                        Bundle arg = new Bundle();
                        Conceptos c = mConceptos.get(position);
                        arg.putString("titu", c.getNombre());
                        arg.putString("desc", c.getTexto());
                        arg.putString("img", c.getImagen());
                        ConceptosItemsFragment fragment = new ConceptosItemsFragment();
                        fragment.setArguments(arg);

                        assert getFragmentManager() != null;
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
