package com.example.exemplo_1;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

import androidx.annotation.Nullable;


public class DBHelper  {

/*
    private Context context;
    private static final String DATABASE_NAME = "Desacelera.db";
    private static final int DATABASE_VERSION = 1;
    private static final String TABLE_NAME_Usuario = "usuario";
    private static final String COLUMN_ID = "_id";
    private static final String COLUMN_NOME = "usuario_nome";
    private static final String COLUMN_SOBRENOME = "usuario_sobrenome";
    private static final String COLUMN_EMAIL = "usuario_email";
    private static final String COLUMN_DATA_NASCIMENTO = "usuario_data_nascimento";
    private static final String COLUMN_TELEFONE = "usuario_telefone";
    private static final String COLUMN_SENHA = "usuario_senha";

    private static final String TABLE_NAME_Profissional = "profissional";
    private static final String COLUMN_ID_Profissional = "_id";
    private static final String COLUMN_NOME_Profissional = "profissional_nome";
    private static final String COLUMN_SOBRENOME_Profissional = "profissional_sobrenome";
    private static final String COLUMN_EMAIL_Profissional = "profissional_email";
    private static final String COLUMN_NUMEROREGISTRO_Profissional = "profissional_numero_registro";
    private static final String COLUMN_DATA_NASCIMENTO_Profissional = "profissional_data_nascimento";
    private static final String COLUMN_SENHA_Profissional = "profissional_senha";





    public DBHelper(@Nullable Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        this.context = context;
    }




    @Override
    public void onCreate(SQLiteDatabase DB) {
    String query = "CREATE TABLE " + TABLE_NAME_Usuario +  " (" + COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
            + COLUMN_NOME + "  TEXT(30) NOT NULL, " + COLUMN_SOBRENOME + " TEXT(30) NOT NULL, " + COLUMN_EMAIL + " TEXT(25) NOT NULL, "
            + COLUMN_DATA_NASCIMENTO + " INTEGER(10) NOT NULL, " + COLUMN_TELEFONE + " INTEGER(13) NOT NULL, " + COLUMN_SENHA + " TEXT(15) NOT NULL);";
    DB.execSQL(query);

    String query2 =  "CREATE TABLE " + TABLE_NAME_Profissional +  " (" + COLUMN_ID_Profissional + " INTEGER PRIMARY KEY AUTOINCREMENT, "
            + COLUMN_NOME_Profissional + " TEXT(30) NOT NULL, " + COLUMN_SOBRENOME_Profissional + " TEXT(30) NOT NULL, " + COLUMN_EMAIL_Profissional + " TEXT(25) NOT NULL,"
            + COLUMN_NUMEROREGISTRO_Profissional + " INTEGER(6) NOT NULL, " + COLUMN_DATA_NASCIMENTO_Profissional + " INTEGER(10) NOT NULL,"
            + COLUMN_SENHA_Profissional + " TEXT(15) NOT NULL);";
        DB.execSQL(query2);
    }


    @Override
    public void onUpgrade(SQLiteDatabase DB, int i, int i1) {
        DB.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME_Usuario );
        onCreate(DB);
        DB.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME_Profissional );
        onCreate(DB);
    }

    void addUsuario(String nome, String sobrenome, String email,
                    int datanascimento, int telefone, String senha){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put(COLUMN_NOME, nome);
        cv.put(COLUMN_SOBRENOME, sobrenome);
        cv.put(COLUMN_EMAIL, email);
        cv.put(COLUMN_DATA_NASCIMENTO, datanascimento);
        cv.put(COLUMN_TELEFONE, telefone);
        cv.put(COLUMN_SENHA, senha);
        long result = db.insert(TABLE_NAME_Usuario, null, cv);
       if(result == -1){
            Toast.makeText(context, "Deu errado", Toast.LENGTH_SHORT).show();
        }
        else {
           Toast.makeText(context, "Adicionado", Toast.LENGTH_SHORT).show();
        }
    }

    void addProfissional(String nome, String sobrenome, String email, int numeroregistro,
                    int datanascimento, String senha){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put(COLUMN_NOME_Profissional, nome);
        cv.put(COLUMN_SOBRENOME_Profissional, sobrenome);
        cv.put(COLUMN_EMAIL_Profissional, email);
        cv.put(COLUMN_NUMEROREGISTRO_Profissional, numeroregistro);
        cv.put(COLUMN_DATA_NASCIMENTO_Profissional, datanascimento);
        cv.put(COLUMN_SENHA_Profissional, senha);
        long result = db.insert(TABLE_NAME_Profissional, null, cv);
        if(result == -1){
            Toast.makeText(context, "Deu errado", Toast.LENGTH_SHORT).show();
        }
        else {
            Toast.makeText(context, "Adicionado", Toast.LENGTH_SHORT).show();
        }
    }

    public Boolean checkEmailSenhaUsuario(String email, String senha){
        SQLiteDatabase MyDB = this.getWritableDatabase();
        Cursor cursor = MyDB.rawQuery("Select * from usuario where usuario_email = ? and usuario_senha = ?", new String[]{email, senha});
        if(cursor.getCount() > 0 ){
            return true;
        }
        else
            return false;
    }

    public Boolean checkEmailSenhaProfissional(String email, String senha){
        SQLiteDatabase MyDB = this.getWritableDatabase();
        Cursor cursor = MyDB.rawQuery("Select * from profissional where profissional_email = ? and profissional_senha = ?", new String[]{email, senha});
        if(cursor.getCount() > 0 ){
            return true;
        }
        else
            return false;
    }

    */
}
