package choubanidev.ensit.com.tp1ex5;

import android.app.ProgressDialog;
import android.net.Uri;
import android.os.AsyncTask;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.appindexing.Thing;
import com.google.android.gms.common.api.GoogleApiClient;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    RecyclerView rcv;
    EtudiantAdapter myAdapter;
    String url="http://gestionetudiants-samplewalid.rhcloud.com/students.json";

    private GoogleApiClient client;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        new LoadInfo().execute();











    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.mymenu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();
        if (id == R.id.add) {
            { Toast.makeText(getApplicationContext(), "Ajouter un étudiant", Toast.LENGTH_LONG).show();return true;}

        }
        if (id == R.id.search)
            Toast.makeText(getApplicationContext(), "Recherche d'un étudiant", Toast.LENGTH_LONG).show();
        if (id == R.id.delete)
            Toast.makeText(getApplicationContext(), "Suppression d'un étudiant", Toast.LENGTH_LONG).show();
        if (id == R.id.edit)
            Toast.makeText(getApplicationContext(), "modification d'un étudiant", Toast.LENGTH_LONG).show();
        return super.onOptionsItemSelected(item);
    }



private class LoadInfo extends AsyncTask<String,String,String>
    {
        ProgressDialog pdLoading=new ProgressDialog(MainActivity.this);

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            pdLoading.setMessage("Loading Student.Please wait...");
            pdLoading.setCancelable(false);
            pdLoading.show();
        }

        @Override
        protected String doInBackground(String... params) {
            HttpHandler sh=new HttpHandler();
            String result=sh.makeServiceCall(url);
            Log.v("info json",result);
            return result;
        }

        @Override
        protected void onPostExecute(String result) {
            pdLoading.dismiss();
            List<Etudiant> data=new ArrayList<>();
            try {
                JSONArray jArray=new JSONArray(result);
                for (int i=0;i<jArray.length();i++)
                {
                    JSONObject json_data=jArray.getJSONObject(i);
                    Etudiant etudiant=new Etudiant(json_data.getString("option"),json_data.getString("nom"),json_data.getString("email"),json_data.getInt("abs"),json_data.getString("avatar"));
                    data.add(etudiant);
                    rcv = (RecyclerView) findViewById(R.id.rcv);
                    myAdapter = new EtudiantAdapter(MainActivity.this, data);
                    rcv.setLayoutManager(new LinearLayoutManager(MainActivity.this));
                    rcv.setAdapter(myAdapter);

                }
            }
            catch (JSONException e)
            {
                Toast.makeText(MainActivity.this,e.toString(),Toast.LENGTH_LONG).show();
            }

        }
    }



}
