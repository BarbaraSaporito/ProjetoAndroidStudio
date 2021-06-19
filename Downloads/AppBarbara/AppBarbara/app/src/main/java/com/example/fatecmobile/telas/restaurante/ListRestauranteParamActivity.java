package com.example.fatecmobile.telas.restaurante;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.fatecmobile.R;
import com.example.fatecmobile.dbs.ControllerRestaurante;
import com.example.fatecmobile.modelos.RestauranteBean;

import java.util.List;

public class ListRestauranteParamActivity extends AppCompatActivity implements AdapterView.OnItemClickListener, AdapterView.OnItemLongClickListener {

    ListView ListaDeAlunos;
    List<RestauranteBean> restaurantes;
    Button pesqTer;
    ArrayAdapter<RestauranteBean> adapter = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_restaurante_param);
        final Context con = getBaseContext();
        final ControllerRestaurante ge = new ControllerRestaurante(con);
        ListaDeAlunos = (ListView) findViewById(R.id.listares);
        ListaDeAlunos.setOnItemClickListener(this); // Clique no item
        ListaDeAlunos.setOnItemLongClickListener(this); //
        final EditText nome = (EditText)findViewById(R.id.nome);

        pesqTer = (Button) findViewById(R.id.btpesquisarrestaurante);
        pesqTer.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                String nomeString = nome.getText().toString();
                RestauranteBean res = new RestauranteBean();
                res.setNome(nomeString);
                restaurantes = ge.listarRestaurantes(res);
                adapter = new ArrayAdapter<RestauranteBean>(con,android.R.layout.simple_list_item_1,restaurantes);
                ListaDeAlunos.setAdapter(adapter);
            }
        });
    }

    @Override
    public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
        // Código para trabalhar com o item que foi pressionado
        // position é a posição do item no adapter
        RestauranteBean res = (RestauranteBean) parent.getItemAtPosition(position);
        Intent it = new Intent(ListRestauranteParamActivity.this, UptRestauranteActivity.class);
        it.putExtra("Restaurante",res);
        startActivity(it);
        Toast.makeText(getApplicationContext(),"Item Pressionado :-" + position + " ID= " + res.getId(),Toast.LENGTH_LONG).show();
        return true;
    }

    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        // Código para trabalhar com o item que foi clicado
        // position é a posição do item no adapter
        RestauranteBean res = (RestauranteBean) parent.getItemAtPosition(position);
        Intent it = new Intent(ListRestauranteParamActivity.this, UptRestauranteActivity.class);
        it.putExtra("Restaurante",res);
        startActivity(it);
        Toast.makeText(getApplicationContext(),"Item Click :-" + position + " ID= " + res.getId(),Toast.LENGTH_LONG).show();
    }
}