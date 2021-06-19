package com.example.fatecmobile.telas.restaurante;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.fatecmobile.R;
import com.example.fatecmobile.dbs.ControllerRestaurante;
import com.example.fatecmobile.modelos.RestauranteBean;

public class AddRestauranteActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_restaurante);
        final ControllerRestaurante ge = new ControllerRestaurante(getBaseContext());
        Button Inserir = (Button) findViewById(R.id.btinserirrestaurante);

        Inserir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                EditText nome  = (EditText) findViewById(R.id.nome);
                EditText cep  = (EditText) findViewById((R.id.cep));
                EditText endereco = (EditText) findViewById(R.id.endereco);
                EditText bairro   = (EditText) findViewById(R.id.bairro);
                EditText telefone   = (EditText) findViewById(R.id.telefone);

                String nomeString = nome.getText().toString();
                String cepString = cep.getText().toString();
                String enderecoString = endereco.getText().toString();
                String bairroString = bairro.getText().toString();
                String telefoneString = telefone.getText().toString();

                RestauranteBean res = new RestauranteBean();
                res.setId("");
                res.setNome(nomeString);
                res.setCep(cepString);
                res.setEndereco(enderecoString);
                res.setBairro(bairroString);
                res.setTelefone(telefoneString);
                String msg = ge.inserir(res);
                Toast.makeText(getApplicationContext(), msg, Toast.LENGTH_LONG).show();
            }
        });
    }

}
