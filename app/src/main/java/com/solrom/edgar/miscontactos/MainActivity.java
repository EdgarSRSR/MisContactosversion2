package com.solrom.edgar.miscontactos;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ArrayList<Contacto> contactos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        contactos = new ArrayList<Contacto>();

        contactos.add(new Contacto("Edgar Solis", "77779999", "edgar@gmail.com"));
        contactos.add(new Contacto("Don Barredora","44445555", "plowking@gmail.com"));
        contactos.add(new Contacto("Perro Perrovich", "22223333", "bobs_burgerz@gmail.com"));
        contactos.add(new Contacto("Boaty McBoatface", "77776666", "2dank4life@gmail.com"));
        contactos.add(new Contacto("Super Hans", "33331111", "big_beatz@gmail.com"));

        ArrayList<String> nombreContacto = new ArrayList<>();

        for (Contacto contacto: contactos) {
            nombreContacto.add(contacto.getNombre());
            
        }
        
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
        });

    }
}
