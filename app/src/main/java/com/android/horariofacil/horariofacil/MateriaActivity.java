package com.android.horariofacil.horariofacil;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.android.horariofacil.horariofacil.Dados.HorarioFacilBDHelper;
import com.android.horariofacil.horariofacil.Dados.HorarioFacilContract;

/**
 * Created by lucas on 25/06/17.
 */


public class MateriaActivity extends AppCompatActivity {

    private SQLiteDatabase mDB;
    private TextView descricaodamateria;

    @Override
    protected void onCreate(Bundle savedIstanceState){
        super.onCreate(savedIstanceState);
        setContentView(R.layout.activity_materia);


    HorarioFacilBDHelper dbHelper = new HorarioFacilBDHelper(this);

    mDB = dbHelper.getReadableDatabase();

    String codMateria = "Parametro";

    descricaodamateria = (TextView) findViewById(R.id.descricaomateria);

    Cursor c = mDB.query(HorarioFacilContract.MateriasEntry.TABLE_NAME,
            null,
            null,
            null,
            null,
            null,
            HorarioFacilContract.MateriasEntry.COLUMN_COD_MATERIA);

        c.moveToFirst();
        do {
        if (codMateria.equals(c.getString(c.getColumnIndexOrThrow(HorarioFacilContract.MateriasEntry.COLUMN_COD_MATERIA)))) {
            // Se entrou aqui é pq achou a linha q vc queria
            String codigo, disciplina, posfluxo, creditos, caracteristica;

            codigo = c.getString(0);
            disciplina = c.getString(1);
            posfluxo = c.getString(2);
            creditos = c.getString(3);
            caracteristica = c.getString(4);

            String descricaomateria = "Disciplina: "+disciplina+"\n"+
                    "Código da disciplina: "+codigo+"\n"+
                    "Tipo: "+caracteristica+"\n"+
                    "Créditos: "+creditos+"\n"+
                    "Posição no fluxo: "+posfluxo+"\n";

            descricaodamateria.setText(descricaomateria);


            // esse codigo vai pegar o valor do campo na linha, basta colocar a coluna q vc quer. Da uma ulhada em HorarioFacilCtract pra saber as colunas
        }
        c.moveToNext();
    } while (!c.isLast());
    }
}



