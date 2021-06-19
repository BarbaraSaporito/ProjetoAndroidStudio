package com.example.fatecmobile.telas.restaurante;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.fatecmobile.R;
import com.example.fatecmobile.dbs.ControllerRestaurante;
import com.example.fatecmobile.modelos.RestauranteBean;

public class UptRestauranteActivity extends AppCompatActivity {

    Button uptTer, delTer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_upt_restaurante);
        final ControllerRestaurante ge = new ControllerRestaurante(getBaseContext());
        final EditText nome = (EditText)findViewById(R.id.nome);
        final EditText cep = (EditText)findViewById((R.id.cep));
        final EditText endereco = (EditText)findViewById(R.id.endereco);
        final EditText bairro = (EditText)findViewById(R.id.bairro);
        final EditText telefone = (EditText)findViewById(R.id.telefone);
        Intent it = getIntent();
        final RestauranteBean recuperado = (RestauranteBean) it.getSerializableExtra("Restaurante");
        nome.setText(recuperado.getNome());
        cep.setText(recuperado.getCep());
        endereco.setText(recuperado.getEndereco());
        bairro.setText(recuperado.getBairro());
        telefone.setText(recuperado.getTelefone());

        uptTer = (Button) findViewById(R.id.btalterar);
        uptTer.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                String nomeString = nome.getText().toString();
                String cepString = cep.getText().toString();
                String enderecoString = endereco.getText().toString();
                String bairroString = bairro.getText().toString();
                String telefoneString = telefone.getText().toString();

                recuperado.setNome(nomeString);
                recuperado.setCep(cepString);
                recuperado.setEndereco(enderecoString);
                recuperado.setBairro(bairroString);
                recuperado.setTelefone(telefoneString);
                String msg = ge.alterar(recuperado);
                Toast.makeText(getApplicationContext(), msg, Toast.LENGTH_LONG).show();
            }
        });

        delTer = (Button) findViewById(R.id.btexcluir);
        delTer.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                String msg = ge.excluir(recuperado);
                Toast.makeText(getApplicationContext(), msg, Toast.LENGTH_LONG).show();
            }
        });


    }
}
