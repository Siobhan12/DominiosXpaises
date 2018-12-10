package com.siobcode.dominiosxpaises;

import android.content.Context;
import android.content.Intent;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ArrayList <NombrePaises> datos = new ArrayList<NombrePaises>();
    String [] PaisesNombre;
    String [] PaisesDom;
    ImageView ivIcon;
    ListView listapaises;
    ArrayList <Integer> imagen = new ArrayList();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        PaisesNombre = getResources().getStringArray(R.array.array_paises);
        PaisesDom = getResources().getStringArray(R.array.array_dominiosPaises);
        imagen.add(R.drawable.australia);
        imagen.add(R.drawable.barbados);
        imagen.add(R.drawable.belize);
        imagen.add(R.drawable.canada);
        imagen.add(R.drawable.china);
        imagen.add(R.drawable.ecuador);
        imagen.add(R.drawable.espana);
        imagen.add(R.drawable.finlandia);
        imagen.add(R.drawable.francia);
        imagen.add(R.drawable.honduras);

        for (int i = 0; i < PaisesNombre.length; i++) {

            datos.add(new NombrePaises(imagen.get(i), PaisesNombre[i],PaisesDom[i]));
        }
        AdaptadorPaises adaptador = new AdaptadorPaises(this);

        listapaises = (ListView) findViewById(R.id.ListasPaises);
        listapaises.setAdapter(adaptador);
        listapaises.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                switch (position){

                    case 0:
                        Toast.makeText(MainActivity.this, "Australia", Toast.LENGTH_SHORT).show();
                        break;
                    case 1:
                        Toast.makeText(MainActivity.this, "Barbados", Toast.LENGTH_SHORT).show();
                        break;
                    case 2:
                        Toast.makeText(MainActivity.this, "Belize", Toast.LENGTH_SHORT).show();
                        break;
                    case 3:
                        Toast.makeText(MainActivity.this, "Canada", Toast.LENGTH_SHORT).show();
                        break;
                    case 4:
                        Toast.makeText(MainActivity.this, "China", Toast.LENGTH_SHORT).show();
                        break;
                    case 5:
                        Toast.makeText(MainActivity.this, "Ecuador", Toast.LENGTH_SHORT).show();
                        break;
                    case 6:
                        Toast.makeText(MainActivity.this, "Espana", Toast.LENGTH_SHORT).show();
                        break;
                    case 7:
                        Toast.makeText(MainActivity.this, "Finlandia", Toast.LENGTH_SHORT).show();
                        break;
                    case 8:
                        Toast.makeText(MainActivity.this, "Francia", Toast.LENGTH_SHORT).show();
                        break;
                    case 9:
                        Toast.makeText(MainActivity.this, "Honduras", Toast.LENGTH_SHORT).show();
                        break;
                }
            }
        });
    }

    class AdaptadorPaises extends ArrayAdapter<NombrePaises> {

        public AdaptadorPaises(Context context) {
            super(context, R.layout.activity_layout2m, datos);
        }
        public View getView(int position, View convertView, ViewGroup parent) {
            LayoutInflater inflater = LayoutInflater.from(getContext());
            View item = inflater.inflate(R.layout.activity_layout2m,parent,false);

            ivIcon = (ImageView) item.findViewById(R.id.ivicon);
            ivIcon.setImageDrawable(ContextCompat.getDrawable(getContext(),datos.get(position).getIcono()));

            TextView tvnombre = (TextView)item.findViewById(R.id.PaisesNombre);
            tvnombre.setText(datos.get(position).getNombre());
            TextView tvdominio = (TextView)item.findViewById(R.id.PaisesDom);
            tvdominio.setText(datos.get(position).getDominio());
            return(item);
        }
    }
}