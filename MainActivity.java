//Pedraza Cruz José Arturo

package com.example.listafragmentos;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class MainActivity extends Activity {

    ListView lista;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lista = findViewById(R.id.listaAnimales);

        String[] animales = {
                "Gato",
                "Perro",
                "Vaca"
        };

        ArrayAdapter<String> adapter = new ArrayAdapter<>(
                this,
                android.R.layout.simple_list_item_1,
                animales
        );

        lista.setAdapter(adapter);

        reemplazarFragment(new FragmentGato());

        lista.setOnItemClickListener((parent, view, position, id) -> {

            switch (position) {

                case 0:
                    reemplazarFragment(new FragmentGato());
                    break;

                case 1:
                    reemplazarFragment(new FragmentPerro());
                    break;

                case 2:
                    reemplazarFragment(new FragmentVaca());
                    break;
            }
        });
    }

    private void reemplazarFragment(Fragment fragment) {

        FragmentManager manager = getFragmentManager();

        manager.beginTransaction()
                .replace(R.id.contenedorFragment, fragment)
                .commit();
    }
}