package com.joshrsp.clase;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;


public class MainActivity extends ActionBarActivity {

    EditText nombre,sexo,edad;
    SharedPreferences mSharedPreferences;
    String skey = "stringkey";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        nombre = (EditText) findViewById(R.id.editText);
        edad = (EditText) findViewById(R.id.editText2);
        sexo = (EditText) findViewById(R.id.editText3);

      /*  mSharedPreferences = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());*/
     cargar();
        String text = mSharedPreferences.getString(skey,"default value");


    }
    public void cargar(){
        //read back
        mSharedPreferences = getSharedPreferences("PreferenciaUsuario", Context.MODE_PRIVATE);
        nombre.setText(mSharedPreferences.getString("nombre",""));
        edad.setText(mSharedPreferences.getString("edad",""));
        sexo.setText(mSharedPreferences.getString("sexo",""));
    }
     public void buttonOnClickGuardar(View view)
     {   //store
         mSharedPreferences = getSharedPreferences("PreferenciaUsuario", Context.MODE_PRIVATE);
         SharedPreferences.Editor editor = mSharedPreferences.edit();
         editor.putString("nombre", nombre.getText().toString());
         editor.putString("edad", edad.getText().toString());
         editor.putString("sexo", sexo.getText().toString());
         editor.commit();



     }

    public void buttonOnClickBorrar(View view)
    {   //store
        mSharedPreferences = getSharedPreferences("PreferenciaUsuario", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = mSharedPreferences.edit();
        editor.putString("nombre", "");
        editor.putString("edad","");
        editor.putString("sexo", "");
        nombre.setText("");
        edad.setText("");
        sexo.setText("");
        editor.commit();



    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
