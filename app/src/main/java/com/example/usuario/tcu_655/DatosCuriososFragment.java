package com.example.usuario.tcu_655;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import java.util.List;
import java.util.Random;

public class DatosCuriososFragment extends Fragment {

    Activity mParentActivity;
    static int anterior = 20;
    TextView mText;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mParentActivity = getActivity();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.datos_curiosos_fragment, container, false);
        mText = (TextView) view.findViewById(R.id.texto);
        next();

        Button button  = (Button) view.findViewById(R.id.button10);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                next();
            }
        });

        return view;
    }




    //Metodo para escoger una dato curioso aleatorio diferente al anterior.

    public void next(){
        int random = anterior;
        Random rand = new Random();
        while(random == anterior) {
            random = rand.nextInt(9);
        }
        anterior = random;
        mText.setText(Global.datosCuriosos[random]);
    }

}
