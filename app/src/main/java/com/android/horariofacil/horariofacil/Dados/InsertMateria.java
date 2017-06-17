package com.android.horariofacil.horariofacil.Dados;

import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

/**
 * Created by Alex Andrei on 22/05/2017.
 */

public class InsertMateria {
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
                "                     (\n" +
                "                         'OPT',\n" +
                "                         4,\n" +
                "                         0,\n" +
                "                         'Elementos e Mét em Eletrônica',\n" +
                "                         199150\n" +
                "                     ),\n" +
                "                     (\n" +
                "                         'OPT',\n" +
                "                         6,\n" +
                "                         0,\n" +
                "                         'Eletricidade Aplicada',\n" +
                "                         201634\n" +
                "                     ),\n" +
                "                     (\n" +
                "                         'OPT',\n" +
                "                         4,\n" +
                "                         0,\n" +
                "                         'Eletrônica Veicular',\n" +
                "                         206237\n" +
                "                     ),\n" +
                "                     (\n" +
                "                         'OPT',\n" +
                "                         4,\n" +
                "                         0,\n" +
                "                         'Eng Software Experimental',\n" +
                "                         208671\n" +
                "                     ),\n" +
                "                     (\n" +
                "                         'OPT',\n" +
                "                         2,\n" +
                "                         0,\n" +
                "                         'Eng de Segurança do Trabalho',\n" +
                "                         193712\n" +
                "                     ),\n" +
                "                     (\n" +
                "                         'OBG',\n" +
                "                         4,\n" +
                "                         2,\n" +
                "                         'Engenharia Econômica',\n" +
                "                         193321\n" +
                "                     ),\n" +
                "                     (\n" +
                "                         'OBG',\n" +
                "                         4,\n" +
                "                         1,\n" +
                "                         'Engenharia e Ambiente',\n" +
                "                         198005\n" +
                "                     ),\n" +
                "                     (\n" +
                "                         'OPT',\n" +
                "                         4,\n" +
                "                         0,\n" +
                "                         'Equações Diferenciais 1',\n" +
                "                         113301\n" +
                "                     ),\n" +
                "                     (\n" +
                "                         'OPT',\n" +
                "                         4,\n" +
                "                         0,\n" +
                "                         'Ergonomia do Produto',\n" +
                "                         193879\n" +
                "                     ),\n" +
                "                     (\n" +
                "                         'OPT',\n" +
                "                         4,\n" +
                "                         0,\n" +
                "                         'Estrut de Dados e Algor 2',\n" +
                "                         103209\n" +
                "                     ),\n" +
                "                     (\n" +
                "                         'OBG',\n" +
                "                         4,\n" +
                "                         4,\n" +
                "                         'Estrutura de Dados e Algoritmos',\n" +
                "                         193704\n" +
                "                     ),\n" +
                "                     (\n" +
                "                         'CD4',\n" +
                "                         4,\n" +
                "                         3,\n" +
                "                         'Estruturas Mat para Computação',\n" +
                "                         195405\n" +
                "                     ),\n" +
                "                     (\n" +
                "                         'OBG',\n" +
                "                         14,\n" +
                "                         9,\n" +
                "                         'Estágio Supervisionado',\n" +
                "                         102512\n" +
                "                     ),\n" +
                "                     (\n" +
                "                         'OPT',\n" +
                "                         5,\n" +
                "                         0,\n" +
                "                         'Fenômenos de Transporte',\n" +
                "                         168203\n" +
                "                     ),\n" +
                "                     (\n" +
                "                         'OPT',\n" +
                "                         4,\n" +
                "                         0,\n" +
                "                         'Fontes Energ e Tecn Conversão',\n" +
                "                         199184\n" +
                "                     ),\n" +
                "                     (\n" +
                "                         'CD1',\n" +
                "                         4,\n" +
                "                         4,\n" +
                "                         'Fund Arq de Computadores',\n" +
                "                         193674\n" +
                "                     ),\n" +
                "                     (\n" +
                "                         'OPT',\n" +
                "                         4,\n" +
                "                         0,\n" +
                "                         'Fund Var Compl p/ Engenharia',\n" +
                "                         118869\n" +
                "                     ),\n" +
                "                     (\n" +
                "                         'OPT',\n" +
                "                         6,\n" +
                "                         0,\n" +
                "                         'Fund da Teoria Eletromagnética',\n" +
                "                         193682\n" +
                "                     ),\n" +
                "                     (\n" +
                "                         'OPT',\n" +
                "                         4,\n" +
                "                         0,\n" +
                "                         'Fund de Qualidade de Software',\n" +
                "                         208698\n" +
                "                     ),\n" +
                "                     (\n" +
                "                         'OPT',\n" +
                "                         4,\n" +
                "                         0,\n" +
                "                         'Fund de Sistemas Distribuídos',\n" +
                "                         206610\n" +
                "                     ),\n" +
                "                     (\n" +
                "                         'OPT',\n" +
                "                         4,\n" +
                "                         0,\n" +
                "                         'Fundamentos Redes Computadores',\n" +
                "                         203912\n" +
                "                     ),\n" +
                "                     (\n" +
                "                         'OPT',\n" +
                "                         4,\n" +
                "                         0,\n" +
                "                         'Fundamentos Sist Operacionas',\n" +
                "                         201286\n" +
                "                     ),\n" +
                "                     (\n" +
                "                         'OPT',\n" +
                "                         4,\n" +
                "                         0,\n" +
                "                         'Fundamentos de Arq de Software',\n" +
                "                         103179\n" +
                "                     ),\n" +
                "                     (\n" +
                "                         'OPT',\n" +
                "                         4,\n" +
                "                         0,\n" +
                "                         'Fundamentos de Compiladores',\n" +
                "                         101095\n" +
                "                     ),\n" +
                "                     (\n" +
                "                         'OPT',\n" +
                "                         4,\n" +
                "                         0,\n" +
                "                         'Fundamentos e Difer Engenharia',\n" +
                "                         101117\n" +
                "                     ),\n" +
                "                     (\n" +
                "                         'OBG',\n" +
                "                         4,\n" +
                "                         2,\n" +
                "                         'Física 1',\n" +
                "                         118001\n" +
                "                     ),\n" +
                "                     (\n" +
                "                         'OBG',\n" +
                "                         2,\n" +
                "                         2,\n" +
                "                         'Física 1 Experimental',\n" +
                "                         118010\n" +
                "                     ),\n" +
                "                     (\n" +
                "                         'OPT',\n" +
                "                         6,\n" +
                "                         0,\n" +
                "                         'Física Moderna',\n" +
                "                         193691\n" +
                "                     ),\n" +
                "                     (\n" +
                "                         'OPT',\n" +
                "                         4,\n" +
                "                         0,\n" +
                "                         'Física p/ Jogos Eletrônicos 1',\n" +
                "                         115584\n" +
                "                     ),\n" +
                "                     (\n" +
                "                         'OBG',\n" +
                "                         2,\n" +
                "                         7,\n" +
                "                         'Gerência de Config de Software',\n" +
                "                         206628\n" +
                "                     ),\n" +
                "                     (\n" +
                "                         'OPT',\n" +
                "                         4,\n" +
                "                         0,\n" +
                "                         'Gestão Ambiental no Setor Ener',\n" +
                "                         193666\n" +
                "                     ),\n" +
                "                     (\n" +
                "                         'OBG',\n" +
                "                         4,\n" +
                "                         6,\n" +
                "                         'Gestão Portif Proj Software',\n" +
                "                         203874\n" +
                "                     ),\n" +
                "                     (\n" +
                "                         'OPT',\n" +
                "                         4,\n" +
                "                         0,\n" +
                "                         'Gestão da Produção Automotiva',\n" +
                "                         203777\n" +
                "                     ),\n" +
                "                     (\n" +
                "                         'OBG',\n" +
                "                         4,\n" +
                "                         3,\n" +
                "                         'Gestão de Produção e Qualidade',\n" +
                "                         201626\n" +
                "                     ),\n" +
                "                     (\n" +
                "                         'OBG',\n" +
                "                         4,\n" +
                "                         0,\n" +
                "                         'Humanidades e Cidadania',\n" +
                "                         199133\n" +
                "                     ),\n" +
                "                     (\n" +
                "                         'OPT',\n" +
                "                         5,\n" +
                "                         0,\n" +
                "                         'Instrumentação Sist Controle',\n" +
                "                         208205\n" +
                "                     ),\n" +
                "                     (\n" +
                "                         'OBG',\n" +
                "                         4,\n" +
                "                         5,\n" +
                "                         'Interação Humano Computador',\n" +
                "                         201316\n" +
                "                     ),\n" +
                "                     (\n" +
                "                         'OPT',\n" +
                "                         4,\n" +
                "                         0,\n" +
                "                         'Intr a Atividade Empresarial',\n" +
                "                         170054\n" +
                "                     ),\n" +
                "                     (\n" +
                "                         'OPT',\n" +
                "                         4,\n" +
                "                         0,\n" +
                "                         'Intro a Computação Gráfica',\n" +
                "                         208507\n" +
                "                     ),\n" +
                "                     (\n" +
                "                         'OPT',\n" +
                "                         4,\n" +
                "                         0,\n" +
                "                         'Intro aos Jogos Eletrônicos',\n" +
                "                         208493\n" +
                "                     ),\n" +
                "                     (\n" +
                "                         'OPT',\n" +
                "                         4,\n" +
                "                         0,\n" +
                "                         'Introd ao Desenv de Jogos',\n" +
                "                         117552\n" +
                "                     ),\n" +
                "                     (\n" +
                "                         'CD2',\n" +
                "                         4,\n" +
                "                         1,\n" +
                "                         'Introdução a Cienc Computação',\n" +
                "                         113913\n" +
                "                     ),\n" +
                "                     (\n" +
                "                         'OBG',\n" +
                "                         4,\n" +
                "                         0,\n" +
                "                         'Introdução a Álgebra Linear',\n" +
                "                         113093\n" +
                "                     ),\n" +
                "                     (\n" +
                "                         'OPT',\n" +
                "                         2,\n" +
                "                         0,\n" +
                "                         'Introdução à Engenharia',\n" +
                "                         198013\n" +
                "                     ),\n" +
                "                     (\n" +
                "                         'OPT',\n" +
                "                         4,\n" +
                "                         0,\n" +
                "                         'Laboratório de Banco de Dados',\n" +
                "                         115576\n" +
                "                     ),\n" +
                "                     (\n" +
                "                         'OPT',\n" +
                "                         1,\n" +
                "                         0,\n" +
                "                         'Laboratório de Mat Construção',\n" +
                "                         119792\n" +
                "                     ),\n" +
                "                     (\n" +
                "                         'OPT',\n" +
                "                         4,\n" +
                "                         0,\n" +
                "                         'Lingua Sinais Bras - Básico',\n" +
                "                         150649\n" +
                "                     ),\n" +
                "                     (\n" +
                "                         'OBG',\n" +
                "                         4,\n" +
                "                         7,\n" +
                "                         'Manut e Evol de Software',\n" +
                "                         206598\n" +
                "                     ),\n" +
                "                     (\n" +
                "                         'OPT',\n" +
                "                         4,\n" +
                "                         0,\n" +
                "                         'Mat de Constr de Engenharia',\n" +
                "                         193658\n" +
                "                     ),\n" +
                "                     (\n" +
                "                         'CD4',\n" +
                "                         4,\n" +
                "                         3,\n" +
                "                         'Matemática Discreta 1',\n" +
                "                         120669\n" +
                "                     ),\n" +
                "                     (\n" +
                "                         'OPT',\n" +
                "                         4,\n" +
                "                         0,\n" +
                "                         'Mecânica Sólid 1 p/ Engenharia',\n" +
                "                         195308\n" +
                "                     ),\n" +
                "                     (\n" +
                "                         'OPT',\n" +
                "                         4,\n" +
                "                         0,\n" +
                "                         'Mecânica do vôo',\n" +
                "                         107441\n" +
                "                     ),\n" +
                "                     (\n" +
                "                         'OBG',\n" +
                "                         4,\n" +
                "                         6,\n" +
                "                         'Medição e Análise',\n" +
                "                         203891\n" +
                "                     ),\n" +
                "                     (\n" +
                "                         'OBG',\n" +
                "                         4,\n" +
                "                         7,\n" +
                "                         'Melhoria de Proc de Software',\n" +
                "                         208655\n" +
                "                     ),\n" +
                "                     (\n" +
                "                         'OPT',\n" +
                "                         4,\n" +
                "                         0,\n" +
                "                         'Met Tec da Escrita Científica',\n" +
                "                         107450\n" +
                "                     ),\n" +
                "                     (\n" +
                "                         'OBG',\n" +
                "                         4,\n" +
                "                         4,\n" +
                "                         'Met de Desenvolvimento de Software',\n" +
                "                         193640\n" +
                "                     ),\n" +
                "                     (\n" +
                "                         'OPT',\n" +
                "                         4,\n" +
                "                         0,\n" +
                "                         'Microprocessadores e Microcont',\n" +
                "                         201383\n" +
                "                     ),\n" +
                "                     (\n" +
                "                         'OPT',\n" +
                "                         4,\n" +
                "                         0,\n" +
                "                         'Modelagem de Processos',\n" +
                "                         203921\n" +
                "                     ),\n" +
                "                     (\n" +
                "                         'OPT',\n" +
                "                         4,\n" +
                "                         0,\n" +
                "                         'Mét Experimen p/ Engenharia',\n" +
                "                         203734\n" +
                "                     ),\n" +
                "                     (\n" +
                "                         'OPT',\n" +
                "                         4,\n" +
                "                         0,\n" +
                "                         'Métodos Formais',\n" +
                "                         206636\n" +
                "                     ),\n" +
                "                     (\n" +
                "                         'OPT',\n" +
                "                         4,\n" +
                "                         0,\n" +
                "                         'Métodos Matemáticos Engenharia',\n" +
                "                         201642\n" +
                "                     ),\n" +
                "                     (\n" +
                "                         'OBG',\n" +
                "                         4,\n" +
                "                         3,\n" +
                "                         'Métodos Numéricos para Engenharia',\n" +
                "                         195413\n" +
                "                     ),\n" +
                "                     (\n" +
                "                         'OPT',\n" +
                "                         4,\n" +
                "                         0,\n" +
                "                         'Ondul Fís Térm p/ Engenharia',\n" +
                "                         120731\n" +
                "                     ),\n" +
                "                     (\n" +
                "                         'OBG',\n" +
                "                         4,\n" +
                "                         3,\n" +
                "                         'Orientação a Objetos',\n" +
                "                         195341\n" +
                "                     ),\n" +
                "                     (\n" +
                "                         'OPT',\n" +
                "                         4,\n" +
                "                         0,\n" +
                "                         'Paradigmas de Programação',\n" +
                "                         203904\n" +
                "                     ),\n" +
                "                     (\n" +
                "                         'OPT',\n" +
                "                         4,\n" +
                "                         0,\n" +
                "                         'Plan e Gestão de Energia',\n" +
                "                         203858\n" +
                "                     ),\n" +
                "                     (\n" +
                "                         'OPT',\n" +
                "                         4,\n" +
                "                         0,\n" +
                "                         'Princíp Robótica Educacional',\n" +
                "                         103187\n" +
                "                     ),\n" +
                "                     (\n" +
                "                         'OPT',\n" +
                "                         4,\n" +
                "                         0,\n" +
                "                         'Princípios Computação Gráfica',\n" +
                "                         116483\n" +
                "                     ),\n" +
                "                     (\n" +
                "                         'OBG',\n" +
                "                         4,\n" +
                "                         2,\n" +
                "                         'Probabil Est Apl Engenharia',\n" +
                "                         195332\n" +
                "                     ),\n" +
                "                     (\n" +
                "                         'OPT',\n" +
                "                         4,\n" +
                "                         0,\n" +
                "                         'Processo de Desenv de Software',\n" +
                "                         199141\n" +
                "                     ),\n" +
                "                     (\n" +
                "                         'OPT',\n" +
                "                         4,\n" +
                "                         0,\n" +
                "                         'Processos Petroquímicos',\n" +
                "                         107468\n" +
                "                     ),\n" +
                "                     (\n" +
                "                         'OBG',\n" +
                "                         4,\n" +
                "                         8,\n" +
                "                         'Prod Profis Eng Software',\n" +
                "                         208663\n" +
                "                     ),\n" +
                "                     (\n" +
                "                         'OPT',\n" +
                "                         4,\n" +
                "                         0,\n" +
                "                         'Programação Web',\n" +
                "                         208701\n" +
                "                     ),\n" +
                "                     (\n" +
                "                         'OPT',\n" +
                "                         4,\n" +
                "                         0,\n" +
                "                         'Programação para Competições',\n" +
                "                         103195\n" +
                "                     ),\n" +
                "                     (\n" +
                "                         'OBG',\n" +
                "                         4,\n" +
                "                         4,\n" +
                "                         'Proj Integrador Engenharia 1',\n" +
                "                         193861\n" +
                "                     ),\n" +
                "                     (\n" +
                "                         'OBG',\n" +
                "                         6,\n" +
                "                         8,\n" +
                "                         'Proj Integrador Engenharia 2',\n" +
                "                         208175\n" +
                "                     ),\n" +
                "                     (\n" +
                "                         'OPT',\n" +
                "                         4,\n" +
                "                         0,\n" +
                "                         'Projeto Circ Integr Digitais',\n" +
                "                         203831\n" +
                "                     ),\n" +
                "                     (\n" +
                "                         'OPT',\n" +
                "                         4,\n" +
                "                         0,\n" +
                "                         'Projeto Sistemas de Controle',\n" +
                "                         107433\n" +
                "                     ),\n" +
                "                     (\n" +
                "                         'OPT',\n" +
                "                         4,\n" +
                "                         0,\n" +
                "                         'Projeto de Veículos',\n" +
                "                         208639\n" +
                "                     ),\n" +
                "                     (\n" +
                "                         'CD3',\n" +
                "                         2,\n" +
                "                         3,\n" +
                "                         'Prática de Eletrônica Digital 1',\n" +
                "                         119466\n" +
                "                     ),\n" +
                "                     (\n" +
                "                         'OPT',\n" +
                "                         4,\n" +
                "                         0,\n" +
                "                         'Pré-Cálculo para Engenharia',\n" +
                "                         104248\n" +
                "                     ),\n" +
                "                     (\n" +
                "                         'CD1',\n" +
                "                         6,\n" +
                "                         4,\n" +
                "                         'Química Geral',\n" +
                "                         114014\n" +
                "                     ),\n" +
                "                     (\n" +
                "                         'CD1',\n" +
                "                         2,\n" +
                "                         4,\n" +
                "                         'Química Geral Experimental',\n" +
                "                         114634\n" +
                "                     ),\n" +
                "                     (\n" +
                "                         'CD1',\n" +
                "                         4,\n" +
                "                         4,\n" +
                "                         'Química Geral Teórica',\n" +
                "                         114626\n" +
                "                     ),\n" +
                "                     (\n" +
                "                         'OBG',\n" +
                "                         4,\n" +
                "                         0,\n" +
                "                         'Requisitos de Software',\n" +
                "                         201308\n" +
                "                     ),\n" +
                "                     (\n" +
                "                         'OPT',\n" +
                "                         2,\n" +
                "                         0,\n" +
                "                         'Seminários em Eng de Software',\n" +
                "                         103217\n" +
                "                     ),\n" +
                "                     (\n" +
                "                         'OPT',\n" +
                "                         4,\n" +
                "                         0,\n" +
                "                         'Sist Crit Tolerância a Falhas',\n" +
                "                         203939\n" +
                "                     ),\n" +
                "                     (\n" +
                "                         'OPT',\n" +
                "                         4,\n" +
                "                         0,\n" +
                "                         'Sistemas Aeroespaciais',\n" +
                "                         101133\n" +
                "                     ),\n" +
                "                     (\n" +
                "                         'OPT',\n" +
                "                         4,\n" +
                "                         0,\n" +
                "                         'Sistemas Automotivos',\n" +
                "                         199168\n" +
                "                     ),\n" +
                "                     (\n" +
                "                         'CD3',\n" +
                "                         6,\n" +
                "                         3,\n" +
                "                         'Sistemas Digitais 1',\n" +
                "                         167983\n" +
                "                     ),\n" +
                "                     (\n" +
                "                         'OPT',\n" +
                "                         6,\n" +
                "                         0,\n" +
                "                         'Sistemas Digitais 2',\n" +
                "                         167991\n" +
                "                     ),\n" +
                "                     (\n" +
                "                         'OPT',\n" +
                "                         4,\n" +
                "                         0,\n" +
                "                         'Sistemas Embarcados',\n" +
                "                         206181\n" +
                "                     ),\n" +
                "                     (\n" +
                "                         'OBG',\n" +
                "                         4,\n" +
                "                         4,\n" +
                "                         'Sistemas de Bancos de Dados',\n" +
                "                         193631\n" +
                "                     ),\n" +
                "                     (\n" +
                "                         'OPT',\n" +
                "                         4,\n" +
                "                         0,\n" +
                "                         'Sistemas de Propulsão Híbridos',\n" +
                "                         207063\n" +
                "                     ),\n" +
                "                     (\n" +
                "                         'OBG',\n" +
                "                         4,\n" +
                "                         9,\n" +
                "                         'TCC 1',\n" +
                "                         101141\n" +
                "                     ),\n" +
                "                     (\n" +
                "                         'OBG',\n" +
                "                         6,\n" +
                "                         10,\n" +
                "                         'TCC 2',\n" +
                "                         102415\n" +
                "                     ),\n" +
                "                     (\n" +
                "                         'CD3',\n" +
                "                         4,\n" +
                "                         3,\n" +
                "                         'Teoria de Eletrônica Digital 1',\n" +
                "                         119482\n" +
                "                     ),\n" +
                "                     (\n" +
                "                         'OPT',\n" +
                "                         3,\n" +
                "                         0,\n" +
                "                         'Teoria de Materiais Construção',\n" +
                "                         119865\n" +
                "                     ),\n" +
                "                     (\n" +
                "                         'OPT',\n" +
                "                         4,\n" +
                "                         0,\n" +
                "                         'Top Esp de Eng de Software',\n" +
                "                         193623\n" +
                "                     ),\n" +
                "                     (\n" +
                "                         'OPT',\n" +
                "                         2,\n" +
                "                         0,\n" +
                "                         'Top Esp em Fís Aplicada',\n" +
                "                         103527\n" +
                "                     ),\n" +
                "                     (\n" +
                "                         'OPT',\n" +
                "                         4,\n" +
                "                         0,\n" +
                "                         'Top Esp em Govern de TI',\n" +
                "                         110159\n" +
                "                     ),\n" +
                "                     (\n" +
                "                         'OPT',\n" +
                "                         4,\n" +
                "                         0,\n" +
                "                         'Top Esp em Jogos Digitais',\n" +
                "                         107409\n" +
                "                     ),\n" +
                "                     (\n" +
                "                         'OPT',\n" +
                "                         4,\n" +
                "                         0,\n" +
                "                         'Top Esp em Matemática Aplicada',\n" +
                "                         103535\n" +
                "                     ),\n" +
                "                     (\n" +
                "                         'OPT',\n" +
                "                         4,\n" +
                "                         0,\n" +
                "                         'Top Esp em Sistemas Críticos',\n" +
                "                         107417\n" +
                "                     ),\n" +
                "                     (\n" +
                "                         'OPT',\n" +
                "                         4,\n" +
                "                         0,\n" +
                "                         'Top Especiais em Programação',\n" +
                "                         110141\n" +
                "                     ),\n" +
                "                     (\n" +
                "                         'OPT',\n" +
                "                         4,\n" +
                "                         0,\n" +
                "                         'Técnicas de M F e E Software',\n" +
                "                         101109\n" +
                "                     ),\n" +
                "                     (\n" +
                "                         'OBG',\n" +
                "                         4,\n" +
                "                         5,\n" +
                "                         'Técnicas de Programação',\n" +
                "                         201294\n" +
                "                     ),\n" +
                "                     (\n" +
                "                         'OBG',\n" +
                "                         4,\n" +
                "                         6,\n" +
                "                         'Verif Valid de Software',\n" +
                "                         206580\n" +
                "                     );";
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
}