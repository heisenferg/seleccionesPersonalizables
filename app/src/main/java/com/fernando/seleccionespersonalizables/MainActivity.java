package com.fernando.seleccionespersonalizables;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener  {
    String[] ciudades = {"Toledo", "Ciudad Real", "Cuenca", "Guadalajara", "Albacete"};
    String [] descripciones = {"La ciudad Imperial", "Qué gran ciudad", "Casas colgadas", "Ciudad encantada", "Caga y vete"};
    int [] imagenes = {R.drawable.toledo, R.drawable.ciudadreal, R.drawable.cuenca, R.drawable.guadalajara, R.drawable.albacete};


    public class AdaptadorPersonalizado extends ArrayAdapter<String>{

        public AdaptadorPersonalizado(Context context, int resource, String[] objects) {
            super(context, resource, objects);
        }
        @Override
        public View getDropDownView(int position, View cnvView, ViewGroup prnt){
            return crearFilaPersonalizada(position, cnvView, prnt);
        }

        @Override
        public View getView(int pos, View cnvView, ViewGroup prnt){
            return crearFilaPersonalizada(pos, cnvView,prnt);
        }

    }







    @Override
    protected void onCreate(Bundle savedInstanceState) {

        //Ciudades y descripciones (Strinng) e imágenes (int)



        // Adaptador de texto (String)
       // ArrayAdapter<String> adaptador;

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        //Lista de referencia
        Spinner sp = (Spinner) findViewById(R.id.spinnerProvincias);
        AdaptadorPersonalizado adaptador = new AdaptadorPersonalizado(this, R.layout.linearspiner, ciudades);

        sp.setAdapter(adaptador);
        sp.setOnItemSelectedListener(this);
        //Pasamos adaptador a la lista


    }


    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        TextView t = (TextView) findViewById(R.id.textView);
        Spinner sp = (Spinner) findViewById(R.id.spinnerProvincias);

        t.setText(sp.getSelectedItem().toString());

    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {
        TextView t = findViewById(R.id.textView);
        t.setText("No se ha seleccionado nada");
    }






    public View crearFilaPersonalizada(int position, View converView, ViewGroup parent){
        LayoutInflater inflater = getLayoutInflater();
        View miFila = inflater.inflate(R.layout.linearspiner, parent, false);

        TextView nombre = miFila.findViewById(R.id.nombre);
        nombre.setText(ciudades[position]);

        TextView descripcion = miFila.findViewById(R.id.descripcion);
        descripcion.setText(descripciones[position]);

        ImageView imagen = miFila.findViewById(R.id.imagenCiudad);
        imagen.setImageResource(imagenes[position]);

        return miFila;

    }


}


