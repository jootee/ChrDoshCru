package com.dosh.chrcrud.Ministers;

/**
 * Created by Dosh on 8/14/2016.
 */

import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.dosh.chrcrud.*;
import com.dosh.chrcrud.Ministers.Config;
import com.dosh.chrcrud.ViewAllEmployee;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;


public class ViewEmployee extends AppCompatActivity implements View.OnClickListener {

    private EditText editTextId;
    private EditText editTextName;
    private EditText editTextCont;
    private EditText editTextTime;
    private EditText editTextDate;
    private EditText editTextFord;
    private EditText editTextImage;

    private Button buttonUpdate;
    private Button buttonDelete;

    private String id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mactivity_view_employee);

        Intent intent = getIntent();

        id = intent.getStringExtra(com.dosh.chrcrud.Ministers.Config.EMP_ID);

        editTextId = (EditText) findViewById(R.id.editTextId);
        editTextName = (EditText) findViewById(R.id.editTextName);
        editTextCont = (EditText) findViewById(R.id.editTextCont);
        editTextTime = (EditText) findViewById(R.id.editTextTime);
        editTextDate = (EditText) findViewById(R.id.editTextDate);
        editTextFord = (EditText) findViewById(R.id.editTextFord);
        editTextImage = (EditText) findViewById(R.id.editTextImage);

        buttonUpdate = (Button) findViewById(R.id.buttonUpdate);
        buttonDelete = (Button) findViewById(R.id.buttonDelete);

        buttonUpdate.setOnClickListener(this);
        buttonDelete.setOnClickListener(this);

        editTextId.setText(id);

        getEmployee();
    }

    private void getEmployee(){
        class GetEmployee extends AsyncTask<Void,Void,String>{
            ProgressDialog loading;
            @Override
            protected void onPreExecute() {
                super.onPreExecute();
                loading = ProgressDialog.show(ViewEmployee.this,"Fetching...","Wait...",false,false);
            }

            @Override
            protected void onPostExecute(String s) {
                super.onPostExecute(s);
                loading.dismiss();
                showEmployee(s);
            }

            @Override
            protected String doInBackground(Void... params) {
                com.dosh.chrcrud.RequestHandler rh = new com.dosh.chrcrud.RequestHandler();
                String s = rh.sendGetRequestParam(com.dosh.chrcrud.Ministers.Config.URL_GET_EMP,id);
                return s;
            }
        }
        GetEmployee ge = new GetEmployee();
        ge.execute();
    }

    private void showEmployee(String json){
        try {
            JSONObject jsonObject = new JSONObject(json);
            JSONArray result = jsonObject.getJSONArray(com.dosh.chrcrud.Ministers.Config.TAG_JSON_ARRAY);
            JSONObject c = result.getJSONObject(0);
            String name = c.getString(com.dosh.chrcrud.Ministers.Config.TAG_NAME);
            String cont = c.getString(com.dosh.chrcrud.Ministers.Config.TAG_CONT);
            String time = c.getString(com.dosh.chrcrud.Ministers.Config.TAG_TIME);
            String date = c.getString(com.dosh.chrcrud.Ministers.Config.TAG_DATE);
            String ford = c.getString(com.dosh.chrcrud.Ministers.Config.TAG_FORD);
            String image = c.getString(com.dosh.chrcrud.Ministers.Config.TAG_IMAGE);

            editTextName.setText(name);
            editTextCont.setText(cont);
            editTextTime.setText(time);
            editTextDate.setText(date);
            editTextFord.setText(ford);
            editTextImage.setText(image);

        } catch (JSONException e) {
            e.printStackTrace();
        }
    }


    private void updateEmployee(){
        final String name = editTextName.getText().toString().trim();
        final String cont = editTextCont.getText().toString().trim();

        final String time = editTextTime.getText().toString().trim();
        final String date = editTextDate.getText().toString().trim();
        final String ford = editTextFord.getText().toString().trim();
        final String image = editTextImage.getText().toString().trim();

        class UpdateEmployee extends AsyncTask<Void,Void,String>{
            ProgressDialog loading;
            @Override
            protected void onPreExecute() {
                super.onPreExecute();
                loading = ProgressDialog.show(ViewEmployee.this,"Updating...","Wait...",false,false);
            }

            @Override
            protected void onPostExecute(String s) {
                super.onPostExecute(s);
                loading.dismiss();
                Toast.makeText(ViewEmployee.this,s,Toast.LENGTH_LONG).show();
            }

            @Override
            protected String doInBackground(Void... params) {
                HashMap<String,String> hashMap = new HashMap<>();
                hashMap.put(com.dosh.chrcrud.Ministers.Config.KEY_EMP_ID,id);
                hashMap.put(com.dosh.chrcrud.Ministers.Config.KEY_EMP_NAME,name);
                hashMap.put(com.dosh.chrcrud.Ministers.Config.KEY_EMP_CONT,cont);
                hashMap.put(com.dosh.chrcrud.Ministers.Config.KEY_EMP_TIME,time);
                hashMap.put(com.dosh.chrcrud.Ministers.Config.KEY_EMP_DATE,date);
                hashMap.put(com.dosh.chrcrud.Ministers.Config.KEY_EMP_FORD,ford);
                hashMap.put(com.dosh.chrcrud.Ministers.Config.KEY_EMP_IMAGE,image);

                com.dosh.chrcrud.RequestHandler rh = new com.dosh.chrcrud.RequestHandler();

                String s = rh.sendPostRequest(com.dosh.chrcrud.Ministers.Config.URL_UPDATE_EMP,hashMap);

                return s;
            }
        }

        UpdateEmployee ue = new UpdateEmployee();
        ue.execute();
    }

    private void deleteEmployee(){
        class DeleteEmployee extends AsyncTask<Void,Void,String> {
            ProgressDialog loading;

            @Override
            protected void onPreExecute() {
                super.onPreExecute();
                loading = ProgressDialog.show(ViewEmployee.this, "Updating...", "Wait...", false, false);
            }

            @Override
            protected void onPostExecute(String s) {
                super.onPostExecute(s);
                loading.dismiss();
                Toast.makeText(ViewEmployee.this, s, Toast.LENGTH_LONG).show();
            }

            @Override
            protected String doInBackground(Void... params) {
                com.dosh.chrcrud.RequestHandler rh = new com.dosh.chrcrud.RequestHandler();
                String s = rh.sendGetRequestParam(com.dosh.chrcrud.Ministers.Config.URL_DELETE_EMP, id);
                return s;
            }
        }

        DeleteEmployee de = new DeleteEmployee();
        de.execute();
    }

    private void confirmDeleteEmployee(){
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(this);
        alertDialogBuilder.setMessage("Are you sure you want to delete this employee?");

        alertDialogBuilder.setPositiveButton("Yes",
                new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface arg0, int arg1) {
                        deleteEmployee();
                        startActivity(new Intent(ViewEmployee.this,ViewAllEmployee.class));
                    }
                });

        alertDialogBuilder.setNegativeButton("No",
                new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface arg0, int arg1) {

                    }
                });

        AlertDialog alertDialog = alertDialogBuilder.create();
        alertDialog.show();
    }

    @Override
    public void onClick(View v) {
        if(v == buttonUpdate){
            updateEmployee();
        }

        if(v == buttonDelete){
            confirmDeleteEmployee();
        }
    }
}