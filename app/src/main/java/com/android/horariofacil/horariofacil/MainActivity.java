package com.android.horariofacil.horariofacil;

import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.ExpandableListView;

import com.android.horariofacil.horariofacil.Dados.HorarioFacilBDHelper;
import com.android.horariofacil.horariofacil.Dados.HorarioFacilContract.ConcluidoEntry;
import com.android.horariofacil.horariofacil.Dados.HorarioFacilContract.MateriasEntry;
import com.android.horariofacil.horariofacil.Dados.HorarioFacilContract.RequisitosEntry;
import com.android.horariofacil.horariofacil.Dados.Listadapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by lucas on 25/06/17.
 */

public class MainActivity extends AppCompatActivity {

    ExpandableListView expandableListView;


    private String usuario;
    private List<String> headings;
    private HashMap<String,List<String>> childList;

    private SQLiteDatabase mDB;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Iniciar Banco de Dados
        HorarioFacilBDHelper dbHelper = new HorarioFacilBDHelper(this);
        mDB = dbHelper.getWritableDatabase();

        Intent intentMain = getIntent();
        if (intentMain.hasExtra("usuario"))
        usuario = intentMain.getStringExtra("usuario");
        else{
            Log.e("Erro Intent", "usuario nao encontrado");
            finish();
        }

        expandableListView = (ExpandableListView) findViewById(R.id.ex_listview);

        generateFields();


    }

    private void generateFields(){
        headings = new ArrayList<String>();
        /**
         * lista das disciplinas cursadas.
         */
        List<String> lista1 = getCursadas();
        /**
         * lista das disciplinas disponíveis.
         */
        List<String> lista2 = getDisponiveis();
        /**
         * lista das disciplinas a serem cursadas.
         */
        List<String> lista3 = getBloqueadas();

        childList = new HashMap<String,List<String>>();

        String  heading_items[] = getResources().getStringArray(R.array.header_titles );
        for(String title : heading_items)headings.add(title);

        childList.put(headings.get(0),lista1);
        childList.put(headings.get(1),lista2);
        childList.put(headings.get(2),lista3);

        Cursor materias = mDB.query(MateriasEntry.TABLE_NAME,
                new String[]{MateriasEntry.COLUMN_COD_MATERIA, MateriasEntry.COLUMN_DISCIPLINA},
                null,
                null,
                null,
                null,
                null );

        Listadapter listadapter = new Listadapter(headings,childList,this, materias);
        expandableListView.setAdapter(listadapter);
    }

    private List<String> getCursadas(){
        String tablename = ConcluidoEntry.TABLE_NAME + ", " + MateriasEntry.TABLE_NAME;
        String[] columnsReturn = new String[]{MateriasEntry.TABLE_NAME + "." + MateriasEntry.COLUMN_COD_MATERIA};
        String columnBusca = ConcluidoEntry.COLUMN_COD_USEER +" = ?";
        String[] valorBusca = new String[]{ usuario };

        List<String> listaDis = new ArrayList<String>();
        Cursor c = mDB.query(tablename,
                columnsReturn,
                columnBusca,
                valorBusca,
                null,
                null,
                MateriasEntry.COLUMN_DISCIPLINA);

        if(c.getCount()==0){
            listaDis.add("000000");
            return listaDis;
        }

        c.moveToFirst();
        do {
            listaDis.add(c.getString(c.getColumnIndexOrThrow(MateriasEntry.COLUMN_COD_MATERIA)));
            c.moveToNext();
        } while (!c.isLast());
        return listaDis;
    }

    private List<String> getDisponiveis(){

        List<String> listaDis = new ArrayList<String>();

        Log.i("Info Disponiveis", "Busca Disciplinas");
        Cursor cDisciplinas = mDB.query("Materias",new String[]{"codMateria"}, null, null, null, null, null);

        Log.i("Info Disponiveis", "Busca Concluidas");
        Cursor cConcluido = mDB.rawQuery("SELECT * FROM Concluido WHERE codUser = '" + usuario + "'", null);

        int cont;
        cDisciplinas.moveToFirst();
        do {
            cont=0;
            if(cConcluido.getCount()!=0) {
                cConcluido.moveToFirst();
                do {
                    if (cDisciplinas.getString(cDisciplinas.getColumnIndexOrThrow(MateriasEntry.COLUMN_COD_MATERIA))
                            .equals(cConcluido.getString(cConcluido.getColumnIndexOrThrow(ConcluidoEntry.COLUMN_COD_MATERIA)))) {
                        cont++;
                        break;
                    }
                    cConcluido.moveToNext();
                } while (!cConcluido.isLast());
            }

            if(cConcluido.getCount()==0 || cont==0){
                Log.i("Info Disponiveis", "Busca Requisitos");
                Cursor cRequisitos = mDB.rawQuery("SELECT * FROM Requisitos WHERE codMateria = '" +
                        cDisciplinas.getString(cDisciplinas.getColumnIndexOrThrow(MateriasEntry.COLUMN_COD_MATERIA)) + "'", null);

                if (cRequisitos.getCount()==0)
                    listaDis.add(cDisciplinas.getString(cDisciplinas.getColumnIndexOrThrow(MateriasEntry.COLUMN_COD_MATERIA)));
                else{
                    if(cConcluido.getCount()!=0) {
                        cRequisitos.moveToFirst();
                        do{
                            cConcluido.moveToFirst();
                            do {
                                if ( !cRequisitos.getString(cRequisitos.getColumnIndexOrThrow(RequisitosEntry.COLUMN_COD_REQUISITO))
                                        .equals(cConcluido.getString(cConcluido.getColumnIndexOrThrow(ConcluidoEntry.COLUMN_COD_MATERIA)))) {
                                    cont++;
                                    break;
                                }
                            } while (!cConcluido.isLast());
                            if(cont!=0) break;
                            cRequisitos.moveToNext();
                        } while (!cRequisitos.isLast());
                        if(cont==0)
                            listaDis.add(cDisciplinas.getString(cDisciplinas.getColumnIndexOrThrow(MateriasEntry.COLUMN_COD_MATERIA)));
                    }
                }

                cDisciplinas.moveToNext();
            }
        }while (!cDisciplinas.isLast());

        if(listaDis.size()==0) listaDis.add("000000");
        return listaDis;
    }

    private List<String> getBloqueadas(){
        List<String> listaDis = new ArrayList<String>();

        Log.i("Info Disponiveis", "Busca Disciplinas");
        Cursor cDisciplinas = mDB.query("Materias",new String[]{"codMateria"}, null, null, null, null, null);

        Log.i("Info Disponiveis", "Busca Concluidas");
        Cursor cConcluido = mDB.rawQuery("SELECT * FROM Concluido WHERE codUser = '" + usuario + "'", null);

        int cont;
        cDisciplinas.moveToFirst();
        do {
            cont=0;
            if(cConcluido.getCount()!=0) {
                cConcluido.moveToFirst();
                do {
                    if (cDisciplinas.getString(cDisciplinas.getColumnIndexOrThrow(MateriasEntry.COLUMN_COD_MATERIA))
                            .equals(cConcluido.getString(cConcluido.getColumnIndexOrThrow(ConcluidoEntry.COLUMN_COD_MATERIA)))) {
                        cont++;
                        break;
                    }
                    cConcluido.moveToNext();
                } while (!cConcluido.isLast());
            }

            if(cConcluido.getCount()==0 || cont==0){
                Log.i("Info Disponiveis", "Busca Requisitos");
                Cursor cRequisitos = mDB.rawQuery("SELECT * FROM Requisitos WHERE codMateria = '" +
                        cDisciplinas.getString(cDisciplinas.getColumnIndexOrThrow(MateriasEntry.COLUMN_COD_MATERIA)) + "'", null);

                if (cRequisitos.getCount()!=0){
                    if(cConcluido.getCount()==0){
                        listaDis.add(cDisciplinas.getString(cDisciplinas.getColumnIndexOrThrow(MateriasEntry.COLUMN_COD_MATERIA)));
                    }
                    else {
                        cRequisitos.moveToFirst();
                        do{
                            cConcluido.moveToFirst();
                            do {
                                if ( !cRequisitos.getString(cRequisitos.getColumnIndexOrThrow(RequisitosEntry.COLUMN_COD_REQUISITO))
                                        .equals(cConcluido.getString(cConcluido.getColumnIndexOrThrow(ConcluidoEntry.COLUMN_COD_MATERIA)))) {
                                    listaDis.add(cDisciplinas.getString(cDisciplinas.getColumnIndexOrThrow(MateriasEntry.COLUMN_COD_MATERIA)));
                                    cont++;
                                    break;
                                }
                            } while (!cConcluido.isLast());
                            if(cont!=0) break;
                            cRequisitos.moveToNext();
                        } while (!cRequisitos.isLast());
                    }
                }

                cDisciplinas.moveToNext();
            }
        }while (!cDisciplinas.isLast());

        if(listaDis.size()==0) listaDis.add("000000");
        return listaDis;
    }

    public void checkBoxes(boolean isCheked, String codMateria){
        if(isCheked){
            addMateriaConcluida(codMateria);
        }
        else{
            removeMateriaConcluida(codMateria);
        }
        generateFields();
    }

    private void addMateriaConcluida(String codMateria){
        ContentValues values = new ContentValues();
        values.put(ConcluidoEntry.COLUMN_COD_USEER, usuario);
        values.put(ConcluidoEntry.COLUMN_COD_MATERIA, codMateria);

        mDB.insert(ConcluidoEntry.TABLE_NAME, null, values);
    }
    private void removeMateriaConcluida(String codMateria){
        mDB.delete(ConcluidoEntry.TABLE_NAME,
                ConcluidoEntry.COLUMN_COD_USEER + " = " + usuario + " AND "
                        + ConcluidoEntry.COLUMN_COD_MATERIA + " = ?", new String[]{codMateria});
    }
}