package com.android.horariofacil.horariofacil.Dados;

import android.content.Context;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import static com.android.horariofacil.horariofacil.Dados.InsertMateria.insertDadosMateria;


/**
 * Created by Alex Andrei on 22/05/2017.
 */

public class HorarioFacilBDHelper extends SQLiteOpenHelper{
    // The database namex
    private static final String DATABASE_NAME = "horarioFacil.db";

    // If you change the database schema, you must increment the database version
    private static final int DATABASE_VERSION = 1;

    // Constructor
    public HorarioFacilBDHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        Log.i("Info BD", "Criacao da string Materia");
        final String SQL_CREATE_MATERIA_TABLE = "CREATE TABLE IF NOT EXISTS " + HorarioFacilContract.MateriasEntry.TABLE_NAME + " ( " +
                HorarioFacilContract.MateriasEntry.COLUMN_COD_MATERIA + " TEXT(6) PRIMARY KEY UNIQUE NOT NULL, " +
                HorarioFacilContract.MateriasEntry.COLUMN_DISCIPLINA + " TEXT(50) UNIQUE NOT NULL, " +
                HorarioFacilContract.MateriasEntry.COLUMN_POS_FLUXO + " TEXT(2)  NOT NULL, " +
                HorarioFacilContract.MateriasEntry.COLUMN_CREDITOS + " TEXT(2)  NOT NULL, " +
                HorarioFacilContract.MateriasEntry.COLUMN_CARACTERISTICA + " TEXT(3)" +
                "); ";
        Log.i("Info BD", "Criacao da string Usuario");
        final String SQL_CREATE_USUARIO_TABLE = "CREATE TABLE IF NOT EXISTS " + HorarioFacilContract.UsuarioEntry.TABLE_NAME + " ( " +
                HorarioFacilContract.UsuarioEntry.COLUMN_MATRICULA + " VARCHAR(9) PRIMARY KEY UNIQUE NOT NULL, " +
                HorarioFacilContract.UsuarioEntry.COLUMN_NOME + " VARCHAR(100) NOT NULL, " +
                HorarioFacilContract.UsuarioEntry.COLUMN_SENHA + " VARCHAR(50)  NOT NULL, " +
                HorarioFacilContract.UsuarioEntry.COLUMN_SOBRENOME + " VARCHAR(100)  NOT NULL, " +
                HorarioFacilContract.UsuarioEntry.COLUMN_EMAIL + " VARCHAR(100) NOT NULL" +
                "); ";
        Log.i("Info BD", "Execucao do codigo sql");
        db.beginTransaction();
        try{
            Log.i("Info BD", "Criar tabela Usuario");
            db.execSQL(SQL_CREATE_USUARIO_TABLE);
            Log.i("Info BD", "Criar tabela Materia");
            db.execSQL(SQL_CREATE_MATERIA_TABLE);
            Log.i("Info BD", "Transaction Sucessful");
            db.setTransactionSuccessful();
        } catch (SQLException e){
            Log.e("Erro BD", e.toString());
        }
        finally {
            Log.i("Info BD", "Codigo sql execultado");
            db.endTransaction();
            Log.i("Info BD", "Inserindo dados Tabela Materias");
            insertDadosMateria(db);
        }

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + HorarioFacilContract.MateriasEntry.TABLE_NAME);
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + HorarioFacilContract.UsuarioEntry.TABLE_NAME);
        onCreate(sqLiteDatabase);
    }
}