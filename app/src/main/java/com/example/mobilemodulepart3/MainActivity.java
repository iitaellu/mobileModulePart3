package com.example.mobilemodulepart3;

import   androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {

    ListView myListView;
    String[] pokemons;
    String[] types;
    String[] description;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Resources res = getResources();
        myListView = (ListView) findViewById(R.id.myListView);
        pokemons = res.getStringArray(R.array.pokemons);

        //myListView.setAdapter((new ArrayAdapter<String>(this, R.layout.my_listview_detail, items)));

        types = res.getStringArray(R.array.types);
        description = res.getStringArray(R.array.description);

        itemAdapter iAdapter = new itemAdapter(this, pokemons, types, description);
        myListView.setAdapter(iAdapter);

        myListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent showDetailActivity =
                        new Intent(getApplicationContext(), DetailActivity.class);
                showDetailActivity.putExtra("com.example.ITEM_INDEX", i);
                startActivity(showDetailActivity);
            }
        });


    }
}