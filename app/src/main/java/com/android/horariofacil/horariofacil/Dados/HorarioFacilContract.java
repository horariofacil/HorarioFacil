package com.android.horariofacil.horariofacil.Dados;

import android.provider.BaseColumns;

/**
 * Created by Alex Andrei on 22/05/2017.
 */

public class HorarioFacilContract {

    public static final class MateriasEntry implements BaseColumns {
        public static final String TABLE_NAME = "Materias";
        public static final String COLUMN_COD_MATERIA = "codMateria";
        public static final String COLUMN_DISCIPLINA = "disciplina";
        public static final String COLUMN_POS_FLUXO = "posFluxo";
        public static final String COLUMN_CREDITOS = "creditos";
        public static final String COLUMN_CARACTERISTICA = "caracteristica";

    }

    public static final class UsuarioEntry implements BaseColumns {
        public static final String TABLE_NAME = "Usuario";
        public static final String COLUMN_MATRICULA = "matricula";
        public static final String COLUMN_SENHA = "senha";
        public static final String COLUMN_NOME = "nome";
        public static final String COLUMN_SOBRENOME = "sobrenome";
        public static final String COLUMN_EMAIL = "email";

    }

}
