package com.android.horariofacil.horariofacil;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.annotation.TargetApi;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;

import com.android.horariofacil.horariofacil.Dados.HorarioFacilBDHelper;
import com.android.horariofacil.horariofacil.Dados.HorarioFacilContract;

import static com.android.horariofacil.horariofacil.R.id.matricula;

/**
 * A login screen that offers login via matricula/password.
 */
public class LoginActivity extends AppCompatActivity {

    /**
     * A dummy authentication store containing known user names and passwords.
     * TODO: remove after connecting to a real authentication system.
     */
    //Banco de Dados
    private SQLiteDatabase mDB;
    private static final String[] colunsToLogin = new String[]{
            HorarioFacilContract.UsuarioEntry.COLUMN_MATRICULA, HorarioFacilContract.UsuarioEntry.COLUMN_SENHA
    };
    /**
     * Keep track of the login task to ensure we can cancel it if requested.
     */
    private UserLoginTask mAuthTask = null;

    // UI references.
    private AutoCompleteTextView mMatriculaView;
    private EditText mPasswordView;
    private View mProgressView;
    private View mLoginFormView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        // Set up the login form.
        mMatriculaView = (AutoCompleteTextView) findViewById(matricula);
        mPasswordView = (EditText) findViewById(R.id.password);

        // Iniciar Banco de Dados
        Log.i("Info BD", "Iniciar BD");
        HorarioFacilBDHelper dbHelper = new HorarioFacilBDHelper(this);

        Log.i("Info BD", "Buscar BD");
        mDB = dbHelper.getReadableDatabase();


        Button mSignInButton = (Button) findViewById(R.id.sign_in_button);
        mSignInButton.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                attemptLogin();
            }
        });

        Button mCadastroButton = (Button) findViewById(R.id.cadastro_button);
        mCadastroButton.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                startCadastro();
            }
        });

        mLoginFormView = findViewById(R.id.login_form);
        mProgressView = findViewById(R.id.login_progress);
    }

    private void startCadastro(){
        Context context = LoginActivity.this;
        Class CadastroActivity = com.android.horariofacil.horariofacil.CadastroActivity.class;

        Intent intentCadastro = new Intent(context, CadastroActivity);

        startActivity(intentCadastro);
    }

    private void startMain(String pMatricula){
        Context context = LoginActivity.this;
        Class MainActivity = com.android.horariofacil.horariofacil.MainActivity.class;

        Intent intentMain = new Intent(context, MainActivity);
        intentMain.putExtra("usuario", pMatricula);
        startActivity(intentMain);
    }

    /**
     * Attempts to sign in or register the account specified by the login form.
     * If there are form errors (invalid matricula, missing fields, etc.), the
     * errors are presented and no actual login attempt is made.
     */
    private void attemptLogin() {
        if (mAuthTask != null) {
            return;
        }

        // Reset errors.
        mMatriculaView.setError(null);
        mPasswordView.setError(null);

        // Store values at the time of the login attempt.
        String matricula = mMatriculaView.getText().toString();
        String password = mPasswordView.getText().toString();

        boolean cancel = false;
        View focusView = null;

        // Check for a valid password, if the user entered one.
        if (!TextUtils.isEmpty(password) && !isPasswordValid(password)) {
            mPasswordView.setError(getString(R.string.error_invalid_password));
            focusView = mPasswordView;
            cancel = true;
        }

        // Check for a valid matricula address.
        if (TextUtils.isEmpty(matricula)) {
            mMatriculaView.setError(getString(R.string.error_field_required));
            focusView = mMatriculaView;
            cancel = true;
        }

        if (cancel) {
            // There was an error; don't attempt login and focus the first
            // form field with an error.
            focusView.requestFocus();
        } else {
            // Show a progress spinner, and kick off a background task to
            // perform the user login attempt.
            showProgress(true);
            mAuthTask = new UserLoginTask(matricula, password);
            mAuthTask.execute((Void) null);
        }
    }

    private boolean isPasswordValid(String password) {
        //TODO: Replace this with your own logic
        return password.length() > 6;
    }

    /**
     * Shows the progress UI and hides the login form.
     */
    @TargetApi(Build.VERSION_CODES.HONEYCOMB_MR2)
    private void showProgress(final boolean show) {
        // On Honeycomb MR2 we have the ViewPropertyAnimator APIs, which allow
        // for very easy animations. If available, use these APIs to fade-in
        // the progress spinner.
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB_MR2) {
            int shortAnimTime = getResources().getInteger(android.R.integer.config_shortAnimTime);

            mLoginFormView.setVisibility(show ? View.GONE : View.VISIBLE);
            mLoginFormView.animate().setDuration(shortAnimTime).alpha(
                    show ? 0 : 1).setListener(new AnimatorListenerAdapter() {
                @Override
                public void onAnimationEnd(Animator animation) {
                    mLoginFormView.setVisibility(show ? View.GONE : View.VISIBLE);
                }
            });

            mProgressView.setVisibility(show ? View.VISIBLE : View.GONE);
            mProgressView.animate().setDuration(shortAnimTime).alpha(
                    show ? 1 : 0).setListener(new AnimatorListenerAdapter() {
                @Override
                public void onAnimationEnd(Animator animation) {
                    mProgressView.setVisibility(show ? View.VISIBLE : View.GONE);
                }
            });
        } else {
            // The ViewPropertyAnimator APIs are not available, so simply show
            // and hide the relevant UI components.
            mProgressView.setVisibility(show ? View.VISIBLE : View.GONE);
            mLoginFormView.setVisibility(show ? View.GONE : View.VISIBLE);
        }
    }

    /**
     * Represents an asynchronous login/registration task used to authenticate
     * the user.
     */
    public class UserLoginTask extends AsyncTask<Void, Void, Boolean> {

        private final String mMatricula;
        private final String mPassword;
        private Cursor c;

        UserLoginTask(String matricula, String password) {
            mMatricula = matricula;
            mPassword = password;
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

            c = mDB.query(HorarioFacilContract.UsuarioEntry.TABLE_NAME,
                    colunsToLogin,
                    null,
                    null,
                    null,
                    null,
                    HorarioFacilContract.UsuarioEntry.COLUMN_MATRICULA);

            if(c.getCount()==0) return false;

            c.moveToFirst();
            do {
                if (mMatricula.equals(c.getString(c.getColumnIndexOrThrow(HorarioFacilContract.UsuarioEntry.COLUMN_MATRICULA)))) {
                    // Account exists, return true if the password matches.
                    if (mPassword.equals(c.getString(c.getColumnIndexOrThrow(HorarioFacilContract.UsuarioEntry.COLUMN_SENHA)))){
                        startMain(mMatricula);
                        return true;
                    }
                }
                c.moveToNext();
            } while (!c.isLast());

            // TODO: register the new account here.
            return false;
        }

        @Override
        protected void onPostExecute(final Boolean success) {
            mAuthTask = null;
            showProgress(false);

            if (success) {
                finish();
            } else {
                mPasswordView.setError(getString(R.string.error_incorrect_password));
                mPasswordView.requestFocus();
            }
        }

        @Override
        protected void onCancelled() {
            mAuthTask = null;
            showProgress(false);
        }
    }
}