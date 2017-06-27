package com.android.horariofacil.horariofacil.Dados;

import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

/**
 * Created by Alex Andrei on 22/05/2017.
 */

public class InsertDados {
    public static void insertDadosMateria(SQLiteDatabase db){
        if(db == null){
            return;
        }

        final String SQL_INSERT_INTO_MATERIA =
                "INSERT INTO Materias (caracteristica, creditos, posFluxo, disciplina, codMateria)" +
                "VALUES ('CD2', 6, 1, 'Algoritmos Progr Computadores', 113476 ), " +
                        "('OPT', 4, 0, 'Aprendizado de Máquina', 120642 ), " +
                        "('OPT', 6, 0, 'Circuitos Eletrônicos 1', 203785 ), " +
                        "('OPT', 4, 0, 'Ciências Aeroespaciais', 208213 ), " +
                        "('OPT', 4, 0, 'Combustíveis e Biocombustíves', 195324 ), " +
                        "('CD2', 6, 1, 'Computação Básica', 116301 ), " +
                        "('OPT', 4, 0, 'Computação em Nuvem', 208680 ), " +
                        "('OPT', 4, 0, 'Confiabilidade de Com Sistemas', 101125 ), " +
                        "('OPT', 4, 0, 'Contratação S de T Informação', 101087 ), " +
                        "('OPT', 4, 0, 'Criptografia e Seg de Redes', 115568 ), " +
                        "('OBG', 6, 1, 'Cálculo 1', 113034 ), " +
                        "('OBG', 6, 2, 'Cálculo 2', 113042 ), " +
                        "('OPT', 6, 0, 'Cálculo 3', 113051 ), " +
                        "('OBG', 6, 1, 'DIAC', 199176 ), " +
                        "('OBG', 4, 7, 'Desenho Avançado de Software', 206601 ), " +
                        "('OBG', 4, 6, 'Desenho de Software', 203882 ), " +
                        "('OPT', 4, 0, 'Desenvolvimento Sustentável', 201324 ), " +
                        "('OPT', 4, 0, 'Desenvolvimento de Software', 120651 ), " +
                        "('OPT', 4, 0, 'Design de Veículos', 195316 ), " +
                        "('OPT', 4, 0, 'Din Gases Sist Aeroespaciais', 107425 ), " +
                        "('OPT', 4, 0, 'Elementos e Mét em Eletrônica', 199150 ), " +
                        "('OPT', 6, 0, 'Eletricidade Aplicada', 201634 ), " +
                        "('OPT', 4, 0, 'Eletrônica Veicular', 206237 ), " +
                        "('OPT', 4, 0, 'Eng Software Experimental', 208671 ), " +
                        "('OPT', 2, 0, 'Eng de Segurança do Trabalho', 193712 ), " +
                        "('OBG', 4, 2, 'Engenharia Econômica', 193321 ), " +
                        "('OBG', 4, 1, 'Engenharia e Ambiente', 198005 ), " +
                        "('OPT', 4, 0, 'Equações Diferenciais 1', 113301 ), " +
                        "('OPT', 4, 0, 'Ergonomia do Produto', 193879 ), " +
                        "('OPT', 4, 0, 'Estrut de Dados e Algor 2', 103209 ), " +
                        "('OBG', 4, 4, 'Estrutura de Dados e Algoritmos', 193704 ), " +
                        "('CD4', 4, 3, 'Estruturas Mat para Computação', 195405 ), " +
                        "('OBG', 14, 9, 'Estágio Supervisionado', 102512 ), " +
                        "('OPT', 5, 0, 'Fenômenos de Transporte', 168203 ), " +
                        "('OPT', 4, 0, 'Fontes Energ e Tecn Conversão', 199184 ), " +
                        "('CD1', 4, 4, 'Fund Arq de Computadores', 193674 ), " +
                        "('OPT', 4, 0, 'Fund Var Compl p/ Engenharia', 118869 ), " +
                        "('OPT', 6, 0, 'Fund da Teoria Eletromagnética', 193682 ), " +
                        "('OPT', 4, 0, 'Fund de Qualidade de Software', 208698 ), " +
                        "('OPT', 4, 0, 'Fund de Sistemas Distribuídos', 206610 ), " +
                        "('OPT', 4, 0, 'Fundamentos Redes Computadores', 203912 ), " +
                        "('OPT', 4, 0, 'Fundamentos Sist Operacionas', 201286 ), " +
                        "('OPT', 4, 0, 'Fundamentos de Arq de Software', 103179 ), " +
                        "('OPT', 4, 0, 'Fundamentos de Compiladores', 101095 ), " +
                        "('OPT', 4, 0, 'Fundamentos e Difer Engenharia', 101117 ), " +
                        "('OBG', 4, 2, 'Física 1', 118001 ), " +
                        "('OBG', 2, 2, 'Física 1 Experimental', 118010 ), " +
                        "('OPT', 6, 0, 'Física Moderna', 193691 )," +
                        "('OPT', 4, 0, 'Física p/ Jogos Eletrônicos 1', 115584 ), " +
                        "('OBG', 2, 7, 'Gerência de Config de Software', 206628 ), " +
                        "('OPT', 4, 0, 'Gestão Ambiental no Setor Ener', 193666 ), " +
                        "('OBG', 4, 6, 'Gestão Portif Proj Software', 203874 ), " +
                        "('OPT', 4, 0, 'Gestão da Produção Automotiva', 203777 ), " +
                        "('OBG', 4, 3, 'Gestão de Produção e Qualidade', 201626 ), " +
                        "('OBG', 4, 0, 'Humanidades e Cidadania', 199133 ), " +
                        "('OPT', 5, 0, 'Instrumentação Sist Controle', 208205 ), " +
                        "('OBG', 4, 5, 'Interação Humano Computador', 201316 ), " +
                        "('OPT', 4, 0, 'Intr a Atividade Empresarial', 170054 ), " +
                        "('OPT', 4, 0, 'Intro a Computação Gráfica', 208507 ), " +
                        "('OPT', 4, 0, 'Intro aos Jogos Eletrônicos', 208493 ), " +
                        "('OPT', 4, 0, 'Introd ao Desenv de Jogos', 117552 ), " +
                        "('CD2', 4, 1, 'Introdução a Cienc Computação', 113913 ), " +
                        "('OBG', 4, 0, 'Introdução a Álgebra Linear', 113093 ), " +
                        "('OPT', 2, 0, 'Introdução à Engenharia', 198013 ), " +
                        "('OPT', 4, 0, 'Laboratório de Banco de Dados', 115576 ), " +
                        "('OPT', 1, 0, 'Laboratório de Mat Construção', 119792 ), " +
                        "('OPT', 4, 0, 'Lingua Sinais Bras - Básico', 150649 ), " +
                        "('OBG', 4, 7, 'Manut e Evol de Software', 206598 ), " +
                        "('OPT', 4, 0, 'Mat de Constr de Engenharia', 193658 ), " +
                        "('CD4', 4, 3, 'Matemática Discreta 1', 120669 ), " +
                        "('OPT', 4, 0, 'Mecânica Sólid 1 p/ Engenharia', 195308 ), " +
                        "('OPT', 4, 0, 'Mecânica do vôo', 107441 ), " +
                        "('OBG', 4, 6, 'Medição e Análise', 203891 ), " +
                        "('OBG', 4, 7, 'Melhoria de Proc de Software', 208655 ), " +
                        "('OPT', 4, 0, 'Met Tec da Escrita Científica', 107450 ), " +
                        "('OBG', 4, 4, 'Met de Desenvolvimento de Software', 193640 ), " +
                        "('OPT', 4, 0, 'Microprocessadores e Microcont', 201383 ), " +
                        "('OPT', 4, 0, 'Modelagem de Processos', 203921 ), " +
                        "('OPT', 4, 0, 'Mét Experimen p/ Engenharia', 203734 ), " +
                        "('OPT', 4, 0, 'Métodos Formais', 206636 ), " +
                        "('OPT', 4, 0, 'Métodos Matemáticos Engenharia', 201642 ), " +
                        "('OBG', 4, 3, 'Métodos Numéricos para Engenharia', 195413 ), " +
                        "('OPT', 4, 0, 'Ondul Fís Térm p/ Engenharia', 120731 ), " +
                        "('OBG', 4, 3, 'Orientação a Objetos', 195341 ), " +
                        "('OPT', 4, 0, 'Paradigmas de Programação', 203904 ), " +
                        "('OPT', 4, 0, 'Plan e Gestão de Energia', 203858 ), " +
                        "('OPT', 4, 0, 'Princíp Robótica Educacional', 103187 ), " +
                        "('OPT', 4, 0, 'Princípios Computação Gráfica', 116483 ), " +
                        "('OBG', 4, 2, 'Probabil Est Apl Engenharia', 195332 ), " +
                        "('OPT', 4, 0, 'Processo de Desenv de Software', 199141 ), " +
                        "('OPT', 4, 0, 'Processos Petroquímicos', 107468 ), " +
                        "('OBG', 4, 8, 'Prod Profis Eng Software', 208663 ), " +
                        "('OPT', 4, 0, 'Programação Web', 208701 ), " +
                        "('OPT', 4, 0, 'Programação para Competições', 103195 ), " +
                        "('OBG', 4, 4, 'Proj Integrador Engenharia 1', 193861 ), " +
                        "('OBG', 6, 8, 'Proj Integrador Engenharia 2', 208175 ), " +
                        "('OPT', 4, 0, 'Projeto Circ Integr Digitais', 203831 ), " +
                        "('OPT', 4, 0, 'Projeto Sistemas de Controle', 107433 ), " +
                        "('OPT', 4, 0, 'Projeto de Veículos', 208639 ), " +
                        "('CD3', 2, 3, 'Prática de Eletrônica Digital 1', 119466 ), " +
                        "('OPT', 4, 0, 'Pré-Cálculo para Engenharia', 104248 ), " +
                        "('CD1', 6, 4, 'Química Geral', 114014 ), " +
                        "('CD1', 2, 4, 'Química Geral Experimental', 114634 ), " +
                        "('CD1', 4, 4, 'Química Geral Teórica', 114626 ), " +
                        "('OBG', 4, 0, 'Requisitos de Software', 201308 ), " +
                        "('OPT', 2, 0, 'Seminários em Eng de Software', 103217 ), " +
                        "('OPT', 4, 0, 'Sist Crit Tolerância a Falhas', 203939 ), " +
                        "('OPT', 4, 0, 'Sistemas Aeroespaciais', 101133 ), " +
                        "('OPT', 4, 0, 'Sistemas Automotivos', 199168 ), " +
                        "('CD3', 6, 3, 'Sistemas Digitais 1', 167983 ), " +
                        "('OPT', 6, 0, 'Sistemas Digitais 2', 167991 ), " +
                        "('OPT', 4, 0, 'Sistemas Embarcados', 206181 ), " +
                        "('OBG', 4, 4, 'Sistemas de Bancos de Dados', 193631 ), " +
                        "('OPT', 4, 0, 'Sistemas de Propulsão Híbridos', 207063 ), " +
                        "('OBG', 4, 9, 'TCC 1', 101141 ), " +
                        "('OBG', 6, 10, 'TCC 2', 102415 ), " +
                        "('CD3', 4, 3, 'Teoria de Eletrônica Digital 1', 119482 ), " +
                        "('OPT', 3, 0, 'Teoria de Materiais Construção', 119865 ), " +
                        "('OPT', 4, 0, 'Top Esp de Eng de Software', 193623 ), " +
                        "('OPT', 2, 0, 'Top Esp em Fís Aplicada', 103527 ), " +
                        "('OPT', 4, 0, 'Top Esp em Govern de TI', 110159 ), " +
                        "('OPT', 4, 0, 'Top Esp em Jogos Digitais', 107409 ), " +
                        "('OPT', 4, 0, 'Top Esp em Matemática Aplicada', 103535 ), " +
                        "('OPT', 4, 0, 'Top Esp em Sistemas Críticos', 107417 ), " +
                        "('OPT', 4, 0, 'Top Especiais em Programação', 110141 ), " +
                        "('OPT', 4, 0, 'Técnicas de M F e E Software', 101109 ), " +
                        "('OBG', 4, 5, 'Técnicas de Programação', 201294 ), " +
                        "('OBG', 4, 6, 'Verif Valid de Software', 206580 );";
        //insert all guests in one transaction
        try
        {
            db.beginTransaction();
            //clear the table first
            db.delete (HorarioFacilContract.MateriasEntry.TABLE_NAME,null,null);
            //go through the list and add one by one
            db.setTransactionSuccessful();
            db.execSQL(SQL_INSERT_INTO_MATERIA);
        }
        catch (SQLException e) {
            //too bad :(
            Log.e("Erro BD", "Erro Inserir" + e.toString());
        }
        finally {
            db.endTransaction();
        }

    }

    public static void insertDadosRequisitos(SQLiteDatabase db) {
        if (db == null) {
            return;
        }

        final String SQL_INSERT_INTO_REQUISITO =
                "INSERT INTO Requisitos ( codMateria, codRequisito ) " +
                "VALUES ('113042', '113034'), " +
                "('195332', '113034')," +
                "('120651', '113476')," +
                "('195413', '113042')," +
                "('119482', '113093')," +
                "('119466', '113093')," +
                "('195341', '113476')," +
                "('201626', '193321')," +
                "('193631', '195405')," +
                "('193640', '195341')," +
                "('193674', '119466')," +
                "('193674', '119482')," +
                "('193704', '113476')," +
                "('120642', '113093')," +
                "('120642', '103209')," +
                "('120642', '195332')," +
                "('113051', '113042')," +
                "('203785', '113042')," +
                "('195324', '114626')," +
                "('195324', '114634')," +
                "('208680', '193631')," +
                "('101125', '195332')," +
                "('101125', '201359')," +
                "('101087', '203874')," +
                "('101087', '116700')," +
                "('101087', '181307')," +
                "('101087', '205397')," +
                "('115568', '195405')," +
                "('195316', '199176')," +
                "('107425', '104779')," +
                "('208671', '193640')," +
                "('113301', '113042')," +
                "('193879', '195316')," +
                "('103209', '193704')," +
                "('168203', '113051')," +
                "('168203', '195308')," +
                "('193691', '113051')," +
                "('193691', '118001')," +
                "('115584', '113093')," +
                "('115584', '118001')," +
                "('115584', '113034')," +
                "('193682', '118001')," +
                "('193682', '113051')," +
                "('208698', '201626')," +
                "('208698', '206580')," +
                "('201308', '101109')," +
                "('208213', '101133')," +
                "('118001', '101133')," +
                "('101141', '102415')," +
                "('113476', '103187')," +
                "('193704', '103195')," +
                "('195341', '103195')," +
                "('113476', '103217')," +
                "('113042', '103527')," +
                "('118001', '103527')," +
                "('113042', '103535')," +
                "('113476', '107409')," +
                "('113476', '107417')," +
                "('203793', '107433')," +
                "('201332', '107468')," +
                "('195324', '107468')," +
                "('193704', '116483')," +
                "('114014', '119865')," +
                "('118001', '120731')," +
                "('118010', '120731')," +
                "('113034', '120731')," +
                "('167983', '167991')," +
                "('167991', '203831')," +
                "('208558', '203858')," +
                "('195341', '203904')," +
                "('113476', '203904')," +
                "('193640', '203904')," +
                "('113476', '203939')," +
                "('167983', '203939')," +
                "('201383', '206181')," +
                "('168203', '207063')," +
                "('193861', '208175')," +
                "('208591', '208639')," +
                "('203874', '208663')," +
                "('199133', '208663')," +
                "('201294', '208701')," +
                "('193631', '208701')," +
                "('206610', '201286')," +
                "('118869', '113051')," +
                "('118869', '113093')," +
                "('103179', '201308')," +
                "('101095', '193704')," +
                "('101117', '113093')," +
                "('101117', '113051')," +
                "('203912', '193674')," +
                "('201286', '201383')," +
                "('201286', '193674')," +
                "('193666', '198005')," +
                "('203777', '201626')," +
                "('208205', '203734')," +
                "('208205', '203785')," +
                "('208205', '113301')," +
                "('208507', '193704')," +
                "('208493', '195341')," +
                "('208493', '193704')," +
                "('117552', '193704')," +
                "('117552', '195341')," +
                "('117552', '203882')," +
                "('115576', '206598')," +
                "('195308', '118001')," +
                "('203734', '118010')," +
                "('206636', '195405')," +
                "('206636', '201294')," +
                "('206636', '193640')," +
                "('201462', '113051'), " +
                "('201383', '193674'), " +
                "('201383', '119474'), " +
                "('201383', '119491'), " +
                "('203921', '201626');";

        //insert all guests in one transaction
        try {
            db.beginTransaction();
            //clear the table first
            db.delete(HorarioFacilContract.RequisitosEntry.TABLE_NAME, null, null);
            //go through the list and add one by one
            db.setTransactionSuccessful();
            db.execSQL(SQL_INSERT_INTO_REQUISITO);
        } catch (SQLException e) {
            //too bad :(
            Log.e("Erro BD", "Erro Inserir" + e.toString());
        } finally {
            db.endTransaction();
        }
    }
}