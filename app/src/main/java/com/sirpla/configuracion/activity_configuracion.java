package com.sirpla.configuracion;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class activity_configuracion extends AppCompatActivity {

    private EditText edt_email;
    private EditText edt_Licencia;
    private EditText edt_Empresa;
    private EditText edt_BaseDatos;
    private EditText edt_Usuario;
    private EditText edt_pws;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_configuracion);

        edt_email= findViewById(R.id.edtEmail);
        edt_Licencia=findViewById(R.id.edt_NroLicencia);
        edt_Empresa = findViewById(R.id.edtNombreEmpresa);
        edt_BaseDatos=findViewById(R.id.edtBaseDeDatos);
        edt_Usuario=findViewById(R.id.edtUsuario);
        edt_pws=findViewById(R.id.edtcontrasenia);

        SharedPreferences Config = getSharedPreferences("datos", Context.MODE_PRIVATE);
        edt_email.setText(Config.getString("mail",""));
        edt_Licencia.setText(Config.getString("licencia",""));
        edt_Empresa.setText(Config.getString("empresa",""));
        edt_BaseDatos.setText(Config.getString("basedatos",""));
        edt_Usuario.setText(Config.getString("usuario",""));
        edt_pws.setText(Config.getString("pws",""));
    }

    public void btn_Aceptar(View v){
        SharedPreferences Configuaracion = getSharedPreferences("datos", Context.MODE_PRIVATE);
        SharedPreferences.Editor Obj_editor = Configuaracion.edit();
        Obj_editor.putString("mail",edt_email.getText().toString());
        Obj_editor.putString("licencia",edt_Licencia.getText().toString());
        Obj_editor.putString("empresa",edt_Empresa.getText().toString());
        Obj_editor.putString("basedatos",edt_BaseDatos.getText().toString());
        Obj_editor.putString("usuario",edt_Usuario.getText().toString());
        Obj_editor.putString("pws",edt_pws.getText().toString());

        Obj_editor.commit();
        finish();
    }
}
