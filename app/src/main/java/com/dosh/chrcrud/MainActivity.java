package com.dosh.chrcrud;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.dosh.chrcrud.LoginMinister.LoginActivity;

import java.util.HashMap;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    //Defining views
    private EditText editTextName;
    private EditText editTextCont;
    private EditText editTextTime;
    private EditText editTextDate;
    private EditText editTextFord;
    private EditText editTextImage;

    private Button buttonAdd;
    private Button buttonView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Initializing views
        editTextName = (EditText) findViewById(R.id.editTextName);
        editTextCont = (EditText) findViewById(R.id.editTextCont);
        editTextTime = (EditText) findViewById(R.id.editTextTime);
        editTextDate = (EditText) findViewById(R.id.editTextDate);
        editTextFord = (EditText) findViewById(R.id.editTextFord);
        editTextImage = (EditText) findViewById(R.id.editTextImage);

        buttonAdd = (Button) findViewById(R.id.buttonAdd);
        buttonView = (Button) findViewById(R.id.buttonView);

        //Setting listeners to button
        buttonAdd.setOnClickListener(this);
        buttonView.setOnClickListener(this);
    }


    //Adding an employee
    private void addEmployee(){

        final String name = editTextName.getText().toString().trim();
        final String cont = editTextCont.getText().toString().trim();
        final String time = editTextTime.getText().toString().trim();
        final String date = editTextDate.getText().toString().trim();
        final String ford = editTextFord.getText().toString().trim();
        final String image = editTextImage.getText().toString().trim();

        class AddEmployee extends AsyncTask<Void,Void,String>{

            ProgressDialog loading;

            @Override
            protected void onPreExecute() {
                super.onPreExecute();
                loading = ProgressDialog.show(MainActivity.this,"Adding...","Wait...",false,false);
            }

            @Override
            protected void onPostExecute(String s) {
                super.onPostExecute(s);
                loading.dismiss();
                Toast.makeText(MainActivity.this,s,Toast.LENGTH_LONG).show();
            }

            @Override
            protected String doInBackground(Void... v) {
                HashMap<String,String> params = new HashMap<>();
                params.put(Config.KEY_EMP_NAME,name);
                params.put(Config.KEY_EMP_CONT,cont);
                params.put(Config.KEY_EMP_TIME,time);
                params.put(Config.KEY_EMP_DATE,date);
                params.put(Config.KEY_EMP_FORD,ford);
                params.put(Config.KEY_EMP_IMAGE,image);

                RequestHandler rh = new RequestHandler();
                String res = rh.sendPostRequest(Config.URL_ADD, params);
                return res;
            }
        }

        AddEmployee ae = new AddEmployee();
        ae.execute();
    }

    @Override
    public void onClick(View v) {
        if(v == buttonAdd){
            addEmployee();
        }

        if(v == buttonView){
            startActivity(new Intent(this,ViewAllEmployee.class));
        }
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
            startActivity(new Intent(this,com.dosh.chrcrud.LoginMinister.MainActivity.class));
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}