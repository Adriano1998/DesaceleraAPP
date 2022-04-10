package com.example.exemplo_1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import com.example.exemplo_1.database.BancoSQLite;
import com.example.exemplo_1.modelos.Usuario;

public class Actvity7FormUsuario extends AppCompatActivity {

    ImageButton imgbtn_Ajudame, imgbtn_Livros, imgbtn_VoltarpTelaInicial, imgbtn_Playlists, imgbtn_Exercicios, 
            imgbtn_EncontreProfissional, imgbtn_Cadastrese, imgbtn_CrieSeuCadastro;



    EditText edttxt_CampoNome, edttxt_CampoEmail, edttxt_CampoSobrenome, edttxt_CampoDataNascimento,
    edttxt_CampoTelefone, edttxt_CampoSenha;
   // DBHelper db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_actvity7_form_usuario);

        edttxt_CampoNome = findViewById(R.id.edttxtCampoNomeTelaCadastroUsuario);
        edttxt_CampoEmail = findViewById(R.id.edttxtCampoEmailTelaCadastroUsuario);

        edttxt_CampoSobrenome = findViewById(R.id.edttxtCampoSobrenomeTelaCadastroUsuario);
        edttxt_CampoDataNascimento = findViewById(R.id.edttxtCampoDataNascimentoTelaCadastroUsuario);

        edttxt_CampoTelefone = findViewById(R.id.edttxtCampoTelefoneTelaCadastroUsuario);
        edttxt_CampoSenha = findViewById(R.id.edttxtCampoSenhaTelaCadastroUsuario);

        imgbtn_CrieSeuCadastro = findViewById(R.id.imgbtnCrieSeuCadastroTelaCadastroUsuario);


        imgbtn_EncontreProfissional = findViewById(R.id.imgbtnEncontreProfissionalTelaCadastroUsuario);
        imgbtn_EncontreProfissional.setOnClickListener(evt -> proximaTela(Activity6Login.class));

        imgbtn_Cadastrese = findViewById(R.id.imgbtnCadastreseTelaCadastroUsuario);
        imgbtn_Cadastrese.setOnClickListener(evt -> proximaTela(Activity11Redirecionamento.class));

        imgbtn_Livros = findViewById(R.id.imgbtnLivrosTelaCadastroUsuario);
        imgbtn_Livros.setOnClickListener(evt -> proximaTela(Activity3Livros.class));

        imgbtn_Playlists = findViewById(R.id.imgbtnPlaylistsTelaCadastroUsuario);
        imgbtn_Playlists.setOnClickListener(evt -> proximaTela(Activity4Playlists.class));

        imgbtn_Exercicios = findViewById(R.id.imgbtnExerciciosTelaCadastroUsuario);
        imgbtn_Exercicios.setOnClickListener(evt -> proximaTela(Activity5Exercicios.class));

        imgbtn_VoltarpTelaInicial = findViewById(R.id.imgbtnVoltarpTelaInicialTelaCadastroUsuario);
        imgbtn_VoltarpTelaInicial.setOnClickListener(evt -> proximaTela(MainActivity.class));

        imgbtn_Ajudame = findViewById(R.id.imgbtnAjudameTelaCadastroUsuario);
        imgbtn_Ajudame.setOnClickListener(evt -> proximaTela(Activity2Ajudeme.class));

     //   db = new DBHelper(this);


   /*     imgbtn_CrieSeuCadastro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DBHelper dbHelper = new DBHelper(Actvity7FormUsuario.this);
                dbHelper.addUsuario(edttxt_CampoNome.getText().toString().trim(),
                        edttxt_CampoSobrenome.getText().toString().trim(),
                        edttxt_CampoEmail.getText().toString().trim(),
                        Integer.valueOf(edttxt_CampoDataNascimento.getText().toString().trim()),
                        Integer.valueOf(edttxt_CampoTelefone.getText().toString().trim()),
                        edttxt_CampoSenha.getText().toString().trim());}
            }
        );
*/

        imgbtn_CrieSeuCadastro.setOnClickListener(view -> {
            BancoSQLite db = new BancoSQLite(this);

            if(edttxt_CampoNome.getText().toString().isEmpty() || edttxt_CampoSobrenome.getText().toString().isEmpty()
                    || edttxt_CampoDataNascimento.getText().toString().isEmpty() || edttxt_CampoTelefone.getText().toString().isEmpty()
                    || edttxt_CampoSenha.getText().toString().isEmpty() || edttxt_CampoEmail.getText().toString().isEmpty()
            ){
                Toast.makeText(this, "Digite todos os campos", Toast.LENGTH_SHORT).show();
            }
            else{
            if(db.inserirUsuario(new Usuario(
                    edttxt_CampoNome.getText().toString(),
                    edttxt_CampoSobrenome.getText().toString(),
                    edttxt_CampoEmail.getText().toString(),
                    edttxt_CampoDataNascimento.getText().toString(),
                    edttxt_CampoTelefone.getText().toString(),
                    edttxt_CampoSenha.getText().toString()
            ))){
               Toast.makeText(this, "Usuario cadastrado com sucesso", Toast.LENGTH_SHORT).show();
            }
            else {
                Toast.makeText(this, "Não foi possivel realizar o cadastro", Toast.LENGTH_SHORT).show();
            }
            };


        });
    }



    public void proximaTela(Class x) {
        Intent it = new Intent(getApplicationContext(), x);
        startActivity(it);
    }
}