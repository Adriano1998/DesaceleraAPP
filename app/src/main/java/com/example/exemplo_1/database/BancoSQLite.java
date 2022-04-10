package com.example.exemplo_1.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.Nullable;

import com.example.exemplo_1.Activity9EncontreProfissional;
import com.example.exemplo_1.modelos.FichaAnamnese;
import com.example.exemplo_1.modelos.Profissional;
import com.example.exemplo_1.modelos.Usuario;

import java.util.ArrayList;

public class BancoSQLite  extends SQLiteOpenHelper {

    private static final String NOME_BANCO = "Desacelera.db";

    private static final String ID = "id";
    private static final String LOGINEMAIL = "loginemail";
    private static final String SENHA = "senha";
    private static final String NOME = "nome";
    private static final String SOBRENOME = "sobrenome";
    private static final String DATANASCIMENTO = "dataNascimento";
    private static final String TELEFONE = "telefone";
    private static final String TABELA = "usuarios";

    private static final int VERSAO = 1;

    private static final String TABELA_PROFISSIONAIS = "profissionais";
    private static final String ID_PROFISSIONAIS = "id_profissionais";
    private static final String LOGINEMAIL_PROFISSIONAIS = "loginEmail_profissionais";
    private static final String SENHA_PROFISSIONAIS = "senha_profissionais";
    private static final String NOME_PROFISSIONAIS = "nome_profissionais";
    private static final String SOBRENOME_PROFISSIONAIS = "sobrenome_profissionais";
    private static final String NUMEROREGISTRO_PROFISSIONAIS = "numeroRegistro_profissionais";
    private static final String DATANASCIMENTO_PROFISSIONAIS = "dataNascimento_profissionais";

    private static final String TABELA_FICHA = "ficha";
    private static final String ID_FICHA = "id_ficha";
    private static final String OQUEVOCEESTASENTINDO_FICHA = "oquevoceestasentindo_ficha";
    private static final String COMOCOMECOU_FICHA = "comocomecou_ficha";
    private static final String FOIREPENTINOOUGRADUAL_FICHA = "foirepentinoougradual_ficha";
    private static final String QUAISSINTOMASVOCEESTASENTINDO_FICHA = "quaissintomasvoceestasentindo_ficha";

    Activity9EncontreProfissional activity9EncontreProfissional;
    Cursor cursor;

    public String getNomeProfissionais() {
        return "nome_profissionais";
    }

    public BancoSQLite(Context context) {
        super(context, NOME_BANCO, null, VERSAO);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        String CREATE_USUARIOS_TABLE = "CREATE TABLE " + TABELA + " ( " + ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                LOGINEMAIL + " TEXT," + SENHA + " TEXT," + NOME + " TEXT," + SOBRENOME + " TEXT,"
                + DATANASCIMENTO + " TEXT," + TELEFONE + " TEXT )";
        db.execSQL(CREATE_USUARIOS_TABLE);

        String CREATE_PROFISSIONAIS_TABLE = "CREATE TABLE " + TABELA_PROFISSIONAIS + " ( " + ID_PROFISSIONAIS + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                LOGINEMAIL_PROFISSIONAIS + " TEXT," + SENHA_PROFISSIONAIS + " TEXT," + NOME_PROFISSIONAIS + " TEXT," + SOBRENOME_PROFISSIONAIS + " TEXT,"
                + NUMEROREGISTRO_PROFISSIONAIS + " TEXT," + DATANASCIMENTO_PROFISSIONAIS + " TEXT )";
        db.execSQL(CREATE_PROFISSIONAIS_TABLE);

        String CREATE_FICHA_TABLE = "CREATE TABLE " + TABELA_FICHA + " ( " + ID_FICHA + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                OQUEVOCEESTASENTINDO_FICHA + " TEXT," + COMOCOMECOU_FICHA + " TEXT," + FOIREPENTINOOUGRADUAL_FICHA + " TEXT," +
                QUAISSINTOMASVOCEESTASENTINDO_FICHA + " TEXT )";
        db.execSQL(CREATE_FICHA_TABLE);


    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABELA);
        db.execSQL("DROP TABLE IF EXISTS " + TABELA_PROFISSIONAIS);
        db.execSQL("DROP TABLE IF EXISTS " + TABELA_FICHA);
        onCreate(db);
    }


    public boolean inserirUsuario(Usuario u) {
        long result;
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(LOGINEMAIL, u.getLoginEmail());
        values.put(SENHA, u.getSenha());
        values.put(NOME, u.getNome());
        values.put(SOBRENOME, u.getSobrenome());
        values.put(DATANASCIMENTO, u.getDataNascimento());
        values.put(TELEFONE, u.getTelefone());
        result = db.insert(TABELA, null, values);
        db.close();


        //flag para saber se escreveu no banco de dados
        if (result == -1)
            return false;
        else
            return true;
    }

    public boolean inserirProfissional(Profissional p) {
        long result;
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(LOGINEMAIL_PROFISSIONAIS, p.getLoginEmail_profissionais());
        values.put(SENHA_PROFISSIONAIS, p.getSenha_profissionais());
        values.put(NOME_PROFISSIONAIS, p.getNome_profissionais());
        values.put(SOBRENOME_PROFISSIONAIS, p.getSobrenome_profissionais());
        values.put(NUMEROREGISTRO_PROFISSIONAIS, p.getNumeroRegistro_profissionais());
        values.put(DATANASCIMENTO_PROFISSIONAIS, p.getDataNascimento_profissionais());
        result = db.insert(TABELA_PROFISSIONAIS, null, values);
        db.close();


        //flag para saber se escreveu no banco de dados
        if (result == -1)
            return false;
        else
            return true;
    }

    public boolean inserirFicha(FichaAnamnese f) {
        long result;
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(OQUEVOCEESTASENTINDO_FICHA, f.getOquevoceestasentindo());
        values.put(COMOCOMECOU_FICHA, f.getComocomecou());
        values.put(FOIREPENTINOOUGRADUAL_FICHA, f.getFoirepentinoougradual());
        values.put(QUAISSINTOMASVOCEESTASENTINDO_FICHA, f.getQuaissintomasvoceestasentindo());
        result = db.insert(TABELA_FICHA, null, values);
        db.close();


        if (result == -1)
            return false;
        else
            return true;
    }

    public Usuario selecionarUsuario(String loginEmail) {
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.query(
                TABELA,
                new String[]{ID, LOGINEMAIL, SENHA, NOME, SOBRENOME, DATANASCIMENTO, TELEFONE},
                LOGINEMAIL + " = ?",
                new String[]{String.valueOf(loginEmail)}, null, null, null, null);

        if (cursor != null) {
            cursor.moveToFirst();
            //o cursor vai escrever os dados que estão clonados do usuario
            Usuario user = new Usuario(
                    Integer.parseInt(cursor.getString(0)),
                    cursor.getString(1),
                    cursor.getString(2),
                    cursor.getString(3),
                    cursor.getString(4),
                    cursor.getString(5),
                    cursor.getString(6));

            return (Usuario) user.clone();

        } else
            return null;
    }

    public Profissional selecionarProfissional(String loginEmail_profissionais) {
        SQLiteDatabase db2 = this.getReadableDatabase();

        Cursor cursor2 = db2.query(
                TABELA_PROFISSIONAIS,
                new String[]{ID_PROFISSIONAIS, LOGINEMAIL_PROFISSIONAIS, SENHA_PROFISSIONAIS, NOME_PROFISSIONAIS, SOBRENOME_PROFISSIONAIS, NUMEROREGISTRO_PROFISSIONAIS, DATANASCIMENTO_PROFISSIONAIS},
                LOGINEMAIL_PROFISSIONAIS + " = ?",
                new String[]{String.valueOf(loginEmail_profissionais)}, null, null, null, null);

        if (cursor2 != null) {
            cursor2.moveToFirst();
            Profissional prof = new Profissional(
                    Integer.parseInt(cursor2.getString(0)),
                    cursor2.getString(1),
                    cursor2.getString(2),
                    cursor2.getString(3),
                    cursor2.getString(4),
                    cursor2.getString(5),
                    cursor2.getString(6));

            return (Profissional) prof.clone();

        } else
            return null;
    }

    public Usuario selecionarUsuarioporID(String id) {
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.query(
                TABELA,
                new String[]{ID, LOGINEMAIL, SENHA, NOME, SOBRENOME, DATANASCIMENTO, TELEFONE},
                ID + " = ?",
                new String[]{String.valueOf(id)}, null, null, null, null);

        if (cursor != null) {
            cursor.moveToFirst();
            //o cursor vai escrever os dados que estão clonados do usuario
            Usuario user = new Usuario(
                    Integer.parseInt(cursor.getString(0)),
                    cursor.getString(1),
                    cursor.getString(2),
                    cursor.getString(3),
                    cursor.getString(4),
                    cursor.getString(5),
                    cursor.getString(6));

            return (Usuario) user.clone();

        } else
            return null;
    }

    public Profissional selecionarProfissionalporID(String id_profissionais) {
        SQLiteDatabase db2 = this.getReadableDatabase();

        Cursor cursor2 = db2.query(
                TABELA_PROFISSIONAIS,
                new String[]{ID_PROFISSIONAIS, LOGINEMAIL_PROFISSIONAIS, SENHA_PROFISSIONAIS, NOME_PROFISSIONAIS, SOBRENOME_PROFISSIONAIS, NUMEROREGISTRO_PROFISSIONAIS, DATANASCIMENTO_PROFISSIONAIS},
                ID_PROFISSIONAIS + " = ?",
                new String[]{String.valueOf(id_profissionais)}, null, null, null, null);

        if (cursor2 != null) {
            cursor2.moveToFirst();
            Profissional prof = new Profissional(
                    Integer.parseInt(cursor2.getString(0)),
                    cursor2.getString(1),
                    cursor2.getString(2),
                    cursor2.getString(3),
                    cursor2.getString(4),
                    cursor2.getString(5),
                    cursor2.getString(6));

            return (Profissional) prof.clone();

        } else
            return null;
    }


  /*  public void listProfissionais(TextView textView) {

        Cursor res = this.getReadableDatabase().rawQuery("select nome_profissionais from "+ TABELA_PROFISSIONAIS +"",null);
        textView.setText("");
        while (res.moveToNext()){
            textView.append(res.getString(1));
        }
    } */

    public Cursor fetch() {
        SQLiteDatabase db2 = this.getReadableDatabase();
        Cursor cursor = db2.query(TABELA_PROFISSIONAIS, new String[]{ID_PROFISSIONAIS, LOGINEMAIL_PROFISSIONAIS, SENHA_PROFISSIONAIS, NOME_PROFISSIONAIS, SOBRENOME_PROFISSIONAIS, NUMEROREGISTRO_PROFISSIONAIS, DATANASCIMENTO_PROFISSIONAIS}, null, null, null, null, null);
        if (cursor != null) {
            cursor.moveToFirst();
        }
        return cursor;
    }

    public FichaAnamnese selecionarFichaporId(String id_ficha) {
        SQLiteDatabase db3 = this.getReadableDatabase();

        Cursor cursor3 = db3.query(
                TABELA_FICHA,
                new String[]{ID_FICHA, OQUEVOCEESTASENTINDO_FICHA, COMOCOMECOU_FICHA, FOIREPENTINOOUGRADUAL_FICHA, QUAISSINTOMASVOCEESTASENTINDO_FICHA},
                ID_FICHA + " = ?",
                new String[]{String.valueOf(id_ficha)}, null, null, null, null);

        if (cursor3 != null) {
            cursor3.moveToFirst();
            FichaAnamnese ficha = new FichaAnamnese(
                    Integer.parseInt(cursor3.getString(0)),
                    cursor3.getString(1),
                    cursor3.getString(2),
                    cursor3.getString(3),
                    cursor3.getString(4));

            return (FichaAnamnese) ficha.clone();

        } else
            return null;
    }






}
