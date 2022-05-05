package com.example.mobilemodulepart3;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

public class itemAdapter extends BaseAdapter {

    LayoutInflater mInflater;
    String[] pokemons;
    String[] types;
    String[] description;

    public itemAdapter(Context c, String[] p, String[] t, String[] d){
        pokemons = p;
        types = t;
        description = d;
        mInflater = (LayoutInflater) c.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return pokemons.length;
    }

    @Override
    public Object getItem(int i) {
        return pokemons[i];
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {

        View v = mInflater.inflate(R.layout.my_listview_detail2, null);
        TextView nameTextView = (TextView) v.findViewById(R.id.pokemonTextView);
        TextView descriptionTextView = (TextView) v.findViewById(R.id.descriptionTextViev);
        TextView priceTextView = (TextView) v.findViewById(R.id.TypeTextView);

        String name = pokemons[i];
        String desc = description[i];
        String type = types[i];

        nameTextView.setText(name);
        descriptionTextView.setText(desc);
        priceTextView.setText(type);

        return v;
    }
}
