package com.example.usuario.tcu_655;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.design.widget.NavigationView;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.example.usuario.tcu_655.dummy.DummyContent;

public class Principal extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener, gloarioFragment.OnListFragmentInteractionListener {

    int ID; //fragment actual
    RelativeLayout mFragment;
    RelativeLayout mMenu;
    //final SharedPreferences prefs=PreferenceManager.getDefaultSharedPreferences(this);;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        /*FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });*/
        ID = R.id.nav_mapa;
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
        mFragment = (RelativeLayout) findViewById(R.id.mainF);
        mMenu = (RelativeLayout) findViewById(R.id.menu);
        FrameLayout mapa = (FrameLayout) findViewById(R.id.mapa);
        FrameLayout conceptos = (FrameLayout) findViewById(R.id.conceptos);
        FrameLayout asadas  = (FrameLayout) findViewById(R.id.asadas);
        FrameLayout zonificacion = (FrameLayout) findViewById(R.id.zonificacion);
        FrameLayout datos = (FrameLayout) findViewById(R.id.datos);
        FrameLayout leyes = (FrameLayout) findViewById(R.id.leyes);
        mapa.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                fragmentManager(R.id.nav_mapa);
            }
        });

        conceptos.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                fragmentManager(R.id.nav_glosario);
            }
        });

        leyes.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                fragmentManager(R.id.nav_leyes);
                }
        });

        asadas.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                fragmentManager(R.id.nav_asadas);
            }
        });
        datos.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                fragmentManager(R.id.nav_curiosos);
            }
        });

        zonificacion.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                fragmentManager(R.id.nav_zona);
            }
        });

        checkFirstRun();
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            if(mMenu.getVisibility() == View.GONE){
                mMenu.setVisibility(View.VISIBLE);
                mFragment.setVisibility(View.GONE);
                ID = -1;
            }
            else {
                super.onBackPressed();
            }
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.principal, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();
        if(id == ID){
            return false;
        }
        else {
            fragmentManager(id);
        }
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    public void checkFirstRun() {
        boolean isFirstRun = getSharedPreferences("PREFERENCE", MODE_PRIVATE).getBoolean("isFirstRun", true);
        if (isFirstRun){
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setTitle("Aviso Legal");
            builder.setMessage("Esta aplicación es desarrollada por el Trabajo Comunal Universitario \n \t \"Gestión comunitaria del agua desde el manejo de cuencas hidrográficas\"\n7 mediante el uso de sistemas de información geográfica y software libre. Esta No debe ser utilizada con fines de lucro. Su contenido no tiene fuerza de ley, se dispone como insumo de carácter educativo y accionar social para las comunidades, entidades y personas interesadas.");
            builder.setCancelable(true);
            builder.setNeutralButton("Ok", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    Toast.makeText(getApplicationContext(), "Aceptado", Toast.LENGTH_SHORT).show();
                }
            });
            builder.show();

            getSharedPreferences("PREFERENCE", MODE_PRIVATE)
                    .edit()
                    .putBoolean("isFirstRun", false)
                    .apply();
        }
    }

    @Override
    public void onListFragmentInteraction(DummyContent.DummyItem item) {

    }

    public void fragmentManager(int id){
        ID = id;
        if (id == R.id.nav_mapa) {
            FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
            ft.replace(R.id.mainF, new ArcgisAPI());
            ft.commit();
        } else if (id == R.id.nav_glosario) {
            FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
            ft.replace(R.id.mainF, new ConceptosFragment());
            ft.commit();
        } else if (id == R.id.nav_leyes) {
            FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
            ft.replace(R.id.mainF, new LeyesFragment());
            ft.commit();
        } else if (id == R.id.nav_asadas) {
            FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
            ft.replace(R.id.mainF, new AsadasFragment());
            ft.commit();
        } else if (id == R.id.nav_curiosos) {
            FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
            ft.replace(R.id.mainF, new DatosCuriososFragment());
            ft.commit();
        } else if (id == R.id.nav_zona) {
            FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
            ft.replace(R.id.mainF, new ZonaFragment());
            ft.commit();
        } else if (id == R.id.nav_contactos) {
            FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
            ft.replace(R.id.mainF, new contactos());
            ft.commit();
        }else if (id == R.id.pdf1) {
            Uri uri = Uri.parse("https://geografia.fcs.ucr.ac.cr/images/Proyectos/accion-social/tc-655/DIAGNSTICO-DE-LA-SUBCUENCA-DEL-RIO-COTO.pdf"); // missing 'http://' will cause crashed
            Intent intent = new Intent(Intent.ACTION_VIEW, uri);
            startActivity(intent);
        } else if (id == R.id.pdf2) {
            Uri uri = Uri.parse("https://geografia.fcs.ucr.ac.cr/images/Proyectos/accion-social/tc-655/PLAN-DE-MANEJO-DE-LA-SUBCUENCA-DEL-RIO-COTO.pdf"); // missing 'http://' will cause crashed
            Intent intent = new Intent(Intent.ACTION_VIEW, uri);
            startActivity(intent);
        }else if (id == R.id.facebook) {
            Uri uri = Uri.parse("https://www.facebook.com/TCU655"); // missing 'http://' will cause crashed
            Intent intent = new Intent(Intent.ACTION_VIEW, uri);
            startActivity(intent);
        }
        mMenu.setVisibility(View.GONE);
        mFragment.setVisibility(View.VISIBLE);
    }
}
