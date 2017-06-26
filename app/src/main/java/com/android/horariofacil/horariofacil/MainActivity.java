package com.android.horariofacil.horariofacil;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ExpandableListView;

import com.android.horariofacil.horariofacil.Dados.Listadapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by lucas on 25/06/17.
 */

public class MainActivity extends AppCompatActivity {

    ExpandableListView expandableListView;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        expandableListView = (ExpandableListView) findViewById(R.id.ex_listview);
        List<String> headings = new ArrayList<String>();

        /**
         * lista das disciplinas cursadas.
         */
        List<String> lista1 = new ArrayList<String>();
        /**
         * lista das disciplinas disponíveis.
         */
        List<String> lista2 = new ArrayList<String>();
        /**
         * lista das disciplinas a serem cursadas.
         */
        List<String> lista3 = new ArrayList<String>();

        HashMap<String,List<String>> childList = new HashMap<String,List<String>>();

        String  heading_items[] = getResources().getStringArray(R.array.header_titles );
        String  cursadas[] = getResources().getStringArray(R.array.cursadas);
        String  disponiveis[] = getResources().getStringArray(R.array.disponiveis);
        String  acursar[] = getResources().getStringArray(R.array.acursar);

        for(String title : heading_items)headings.add(title);
        for(String title : cursadas)lista1.add(title);
        for(String title : disponiveis)lista2.add(title);
        for(String title : acursar)lista3.add(title);

        childList.put(headings.get(0),lista1);
        childList.put(headings.get(1),lista2);
        childList.put(headings.get(2),lista3);
        Listadapter listadapter = new Listadapter(headings,childList,this);
        expandableListView.setAdapter(listadapter);

    }
}
