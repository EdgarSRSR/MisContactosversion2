package com.solrom.edgar.miscontactos;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ArrayList<Contacto> contactos;
    private RecyclerView listaContactos;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar miActionBar = (Toolbar) findViewById(R.id.miActionBar);
        setSupportActionBar(miActionBar);

        listaContactos = (RecyclerView) findViewById(R.id.rvContactos);

        //LinearLayoutManager llm = new LinearLayoutManager(this);
        //llm.setOrientation(LinearLayoutManager.VERTICAL);
        GridLayoutManager glm = new GridLayoutManager(this, 2);

        listaContactos.setLayoutManager(glm);
        inicializarListaContactos();
        inicializarAdaptador();

        /*ArrayList<String> nombreContacto = new ArrayList<>();

        for (Contacto contacto: contactos) {
            nombreContacto.add(contacto.getNombre());
            
        }*/
        /*
        ListView lstContactos = (ListView) findViewById(R.id.lstContactos);
        lstContactos.setAdapter(new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1, nombreContacto));

        lstContactos.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                Intent intent = new Intent(MainActivity.this, DetalleContacto.class);
                intent.putExtra(getResources().getString(R.string.pnombre), contactos.get(position).getNombre());
                intent.putExtra(getResources().getString(R.string.ptelefono), contactos.get(position).getTelefono());
                intent.putExtra(getResources().getString(R.string.pemail), contactos.get(position).getEmail());
                startActivity(intent);
                finish();
            }
        });*/

    }
        public ContactoAdaptador adaptador;
        public void inicializarAdaptador(){
            adaptador = new ContactoAdaptador(contactos, this);
            listaContactos.setAdapter(adaptador);
        }

        public void inicializarListaContactos(){

        contactos = new ArrayList<Contacto>();

        contactos.add(new Contacto(R.drawable.kazakhstan,"Edgar Solis", "77779999", "edgar@gmail.com"));
        contactos.add(new Contacto(R.drawable.kyrgyzstan, "Don Barredora","44445555", "plowking@gmail.com"));
        contactos.add(new Contacto(R.drawable.tajikistan, "Perro Perrovich", "22223333", "bobs_burgerz@gmail.com"));
        contactos.add(new Contacto(R.drawable.uzbekistan, "Boaty McBoatface", "77776666", "2dank4life@gmail.com"));
        contactos.add(new Contacto(R.drawable.turkmenistan, "Super Hans", "33331111", "big_beatz@gmail.com"));

        }
    }


