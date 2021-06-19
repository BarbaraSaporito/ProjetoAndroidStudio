package com.example.fatecmobile.dbs;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.fatecmobile.modelos.RestauranteBean;

import java.util.ArrayList;
import java.util.List;

public class ControllerRestaurante {

    private static BancoHelper dbHelper = null;
    private static SQLiteDatabase db = null;

    public ControllerRestaurante(Context context) {
        if (dbHelper == null ) {
            dbHelper = new BancoHelper(context);
        }
    }

    public String inserir(RestauranteBean res) {
        db = dbHelper.getWritableDatabase();
        ContentValues valores;
        long resultado;
        String retorno;
        valores = new ContentValues();
        valores.put("NOME", res.getNome());
        valores.put("CEP", res.getCep());
        valores.put("ENDERECO", res.getEndereco());
        valores.put("BAIRRO", res.getBairro());
        valores.put("TELEFONE", res.getTelefone());

        resultado = db.insert(BancoHelper.TABELARESTAURANTE, null, valores);
        db.close();

        if (resultado == -1) {
            retorno = "Erro ao inserir registro";
        } else {
            retorno = "Registro Inserido com sucesso";
        }
        return retorno;
    }

    public String excluir(RestauranteBean res) {
        String retorno = "Resgistro Excluir com Sucesso";
        String where = "ID = " + res.getId();
        db = dbHelper.getReadableDatabase();
        db.delete(BancoHelper.TABELARESTAURANTE,where,null);
        db.close();
        return retorno;
    }

    public String alterar(RestauranteBean res) {
        db = dbHelper.getWritableDatabase();
        ContentValues valores;
        String retorno = "Registro Alterado com sucesso";
        String where = "ID = " + res.getId();
        valores = new ContentValues();
        valores.put("NOME", res.getNome());
        valores.put("CEP", res.getCep());
        valores.put("ENDERECO", res.getEndereco());
        valores.put("BAIRRO", res.getBairro());
        valores.put("TELEFONE", res.getTelefone());

        db.update(BancoHelper.TABELARESTAURANTE, valores,where,null);
        db.close();
        return retorno;
    }

    public List<RestauranteBean> listarRestaurantes() {
        List<RestauranteBean> restaurantes = new ArrayList<RestauranteBean>();
        String selectQuery = "SELECT * FROM RESTAURANTE" ;
        db = dbHelper.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);
        if (cursor.moveToFirst()) {
            do {
                RestauranteBean res = new RestauranteBean();
                res.setId(""+cursor.getInt(0));
                res.setNome(cursor.getString(1));
                res.setCep(cursor.getString(2));
                res.setEndereco(cursor.getString(3));
                res.setBairro(cursor.getString(4));
                res.setTelefone(cursor.getString(5));

                restaurantes.add(res);
            } while (cursor.moveToNext());
        }
        return restaurantes;
    }

        public List<RestauranteBean> listarRestaurantes(RestauranteBean resEnt) {
        List<RestauranteBean> restaurantes = new ArrayList<RestauranteBean>();
        String parametro = resEnt.getNome();
        String selectQuery = "SELECT ID, NOME, CEP, ENDERECO, BAIRRO, TELEFONE FROM RESTAURANTE WHERE NOME LIKE ?" ;
        String[] whereArgs = new String[] { "%" + parametro + "%"  };
        db = dbHelper.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, whereArgs);
        if (cursor.moveToFirst()) {
            do {
                RestauranteBean res = new RestauranteBean();
                res.setId(""+cursor.getInt(0));
                res.setNome(cursor.getString(1));
                res.setCep(cursor.getString(2));
                res.setEndereco(cursor.getString(3));
                res.setBairro(cursor.getString(4));
                res.setTelefone(cursor.getString(5));
                restaurantes.add(res);
            } while (cursor.moveToNext());
        }
        return restaurantes;
    }

    public RestauranteBean validarRestaurantes(RestauranteBean resEnt) {
        RestauranteBean res = new RestauranteBean();
        String nomePar = '"' + resEnt.getNome().trim() + '"';
        String cepPar = '"' + resEnt.getCep().trim() + '"';
        String enderecoPar = '"' + resEnt.getEndereco().trim() + '"';
        String bairroPar = '"' + resEnt.getBairro().trim() + '"';
        String telefonePar = '"' + resEnt.getTelefone().trim() + '"';

        String selectQuery = "SELECT ID, NOME, CEP, ENDERECO, BAIRRO, TELEFONE FROM RESTAURANTES WHERE NOME = ? AND CEP = ? " ;
        String[] whereArgs = new String [] {nomePar,cepPar};
        db = dbHelper.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, whereArgs);
        res.setNome("0 = " + nomePar + "1 = " +cepPar);
        if (cursor.moveToFirst()) {
            do {
                res.setId(""+cursor.getInt(0));
                res.setNome(cursor.getString(1));
                res.setCep(cursor.getString(2));
                res.setEndereco(cursor.getString(3));
                res.setBairro(cursor.getString(4));
                res.setTelefone(cursor.getString(5));
            } while (cursor.moveToNext());
        }
        return res;
    }

    public List<RestauranteBean> listarRestaurantesTeste() {
        List<RestauranteBean> restaurantes = new ArrayList<RestauranteBean>();
        for (int i = 0; i < 10; i++ ) {
            RestauranteBean res = new RestauranteBean();
            res.setId(" Id " + i);
            res.setNome(" Nome " + i);
            res.setCep(" Cep " + i);
            res.setEndereco(" Endereco " + i);
            res.setBairro(" Bairro " + i);
            res.setTelefone(" Telefone " + i);
            restaurantes.add(res);
        }
        return restaurantes;
    }



}
