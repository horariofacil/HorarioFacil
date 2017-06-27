package com.android.horariofacil.horariofacil;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;

import com.android.horariofacil.horariofacil.Dados.HorarioFacilBDHelper;
import com.android.horariofacil.horariofacil.Dados.HorarioFacilContract;

import static com.android.horariofacil.horariofacil.R.id.matricula;

public class CadastroActivity extends AppCompatActivity {

    private EditText mNomeView;
    private EditText mSobrenomeView;
    private EditText mSenhaView;
    private EditText mConfirmarSenhaView;
    private EditText mEmailView;
    private EditText mMatriculaView;
    private View focusView = null;

    private CadastroTask mCadastroTask = null;

    private SQLiteDatabase mDB;
    private Cursor c;
    private static final String[] verificarUsu = new String[]{
        HorarioFacilContract.UsuarioEntry.COLUMN_MATRICULA, HorarioFacilContract.UsuarioEntry.COLUMN_EMAIL};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro);

        Log.i("Info BD", "Iniciar BD Cadastro");

        // Iniciar Banco de Dados
        HorarioFacilBDHelper dbHelper = new HorarioFacilBDHelper(this);
        Log.i("Info BD", "Buscar BD");
        mDB = dbHelper.getWritableDatabase();

        mNomeView = (EditText) findViewById(R.id.nome);
        mSobrenomeView = (EditText) findViewById(R.id.sobrenome);
        mSenhaView = (EditText) findViewById(R.id.senha);
        mConfirmarSenhaView = (EditText) findViewById(R.id.confirmarSenha);
        mEmailView = (EditText) findViewById(R.id.email);
        mMatriculaView = (EditText) findViewById(matricula);

        Button mCadastrarButton = (Button) findViewById(R.id.cadastrar_button);
        mCadastrarButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                attemptCadastro();
            }
        });

        ImageButton mVoltarButton = (ImageButton) findViewById(R.id.cadastro_botao_voltar);
        mVoltarButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }

    private void attemptCadastro() {

        mNomeView.setError(null);
        mSobrenomeView.setError(null);
        mSenhaView.setError(null);
        mConfirmarSenhaView.setError(null);
        mEmailView.setError(null);
        mMatriculaView.setError(null);

        String nome = mNomeView.getText().toString();
        String sobrenome = mSobrenomeView.getText().toString();
        String senha = mSenhaView.getText().toString();
        String confirmarSenha = mConfirmarSenhaView.getText().toString();
        String email = mEmailView.getText().toString();
        String matricula = mMatriculaView.getText().toString();

        boolean cancel = false;

        if (TextUtils.isEmpty(senha)){
            mSenhaView.setError(getString(R.string.error_field_required));
        }else if( TextUtils.isEmpty(confirmarSenha)){
            mConfirmarSenhaView.setError(getString(R.string.error_field_required));
        } else if(!isPasswordValid(senha, confirmarSenha)){
            focusView = mSenhaView;
            cancel = true;
        }

        if (TextUtils.isEmpty(sobrenome)) {
            mSobrenomeView.setError(getString(R.string.error_field_required));
            focusView = mSobrenomeView;
            cancel = true;
        }

        if (TextUtils.isEmpty(email)) {
            mEmailView.setError(getString(R.string.error_field_required));
            focusView = mEmailView;
            cancel = true;
        }

        if (TextUtils.isEmpty(matricula)) {
            mMatriculaView.setError(getString(R.string.error_field_required));
            focusView = mMatriculaView;
            cancel = true;
        }

        if (TextUtils.isEmpty(nome)) {
            mNomeView.setError(getString(R.string.error_field_required));
            focusView = mNomeView;
            cancel = true;
        }

        // Adicinar o codigo para verificar se ja existe e adicionar a tabela
        int temp = verificarUsuario(matricula, email);
        if(temp != 0){
            if(temp==1) {
                mMatriculaView.setError(getString(R.string.error_matricula_already_exists));
                focusView = mMatriculaView;
            }
            if(temp==2) {
                mEmailView.setError(getString(R.string.error_email_already_exists));
                focusView = mEmailView;
            }
            cancel = true;
        };

        if (cancel) focusView.requestFocus();
        else {
            mCadastroTask = new CadastroTask(nome, sobrenome, senha, email, matricula);
            mCadastroTask.execute((Void) null);
        }
    }

    private boolean isPasswordValid(String senha, String confirmaSenha) {

        if(senha.length() > 6) {
            if (senha.equals(confirmaSenha)){
                return true;
            }
            else{
                mSenhaView.setError(getString(R.string.error_confirmar_senha));
                return false;
            }
        }
        mSenhaView.setError(getString(R.string.error_invalid_password));
        return false;
    }

    private int verificarUsuario(String matricula, String email){
        Log.i("Verificar Usuario", "Criar Cursor");
        c = mDB.query(HorarioFacilContract.UsuarioEntry.TABLE_NAME,
                verificarUsu,
                null,
                null,
                null,
                null,
                HorarioFacilContract.UsuarioEntry.COLUMN_MATRICULA);
        Log.i("Verificar Usuario", "Verificar se existem usuarios");
        if(c.getCount()==0){
            Log.i("Verificar Usuario", "Tabela Vazia");
            return 0;
        }
        c.moveToFirst();
        Log.i("Verificar Usuario", "Comecar Busca");
        do {
            Log.i("Verificar Usuario",
                    "Usu Matricula: " + c.getString(c.getColumnIndexOrThrow(HorarioFacilContract.UsuarioEntry.COLUMN_MATRICULA)));
            if (matricula.equals(c.getString(c.getColumnIndexOrThrow(HorarioFacilContract.UsuarioEntry.COLUMN_MATRICULA))))
                return 1;

            Log.i("Verificar Usuario",
                    "Usu Email: " + c.getString(c.getColumnIndexOrThrow(HorarioFacilContract.UsuarioEntry.COLUMN_EMAIL)));
            if (email.equals(c.getString(c.getColumnIndexOrThrow(HorarioFacilContract.UsuarioEntry.COLUMN_EMAIL))))
                return 2;
            c.moveToNext();
        } while ( !c.isLast());
        Log.i("Verificar Usuario", "Matricula e Email OK");
        return 0;
    }

    public class CadastroTask extends AsyncTask<Void, Void, Boolean> {

        private final String mNome;
        private final String mSobrenome;
        private final String mEmail;
        private final String mMatricula;
        private final String mSenha;

        CadastroTask(String nome, String sobrenome, String senha, String email, String matricula) {
            mMatricula = matricula;
            mSenha = senha;
            mNome = nome;
            mSobrenome = sobrenome;
            mEmail = email;
        }

        @Override
        protected Boolean doInBackground(Void... params) {
            // TODO: attempt authentication against a network service.

            try {
                // Simulate network access.
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                return false;
            }

            Log.i("Cadastrastro BD", "Cadastrar novo usuario");
            try {
                ContentValues cv = new ContentValues();
                cv.put(HorarioFacilContract.UsuarioEntry.COLUMN_MATRICULA, mMatricula);
                cv.put(HorarioFacilContract.UsuarioEntry.COLUMN_NOME, mNome);
                cv.put(HorarioFacilContract.UsuarioEntry.COLUMN_SOBRENOME, mSobrenome);
                cv.put(HorarioFacilContract.UsuarioEntry.COLUMN_SENHA, mSenha);
                cv.put(HorarioFacilContract.UsuarioEntry.COLUMN_EMAIL, mEmail);

                mDB.insert(HorarioFacilContract.UsuarioEntry.TABLE_NAME, null, cv);
            } catch (Exception e){
                Log.e("Erro BD", e.toString());
                return false;
            }
            Log.i("Cadastrastro BD", "Usuario Cadastrado");
            return true;
        }

        @Override
        protected void onPostExecute(final Boolean success) {
            mCadastroTask = null;
            finish();
        }

        @Override
        protected void onCancelled() {
            mCadastroTask = null;
        }
    }

}