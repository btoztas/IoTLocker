package pt.ulisboa.tecnico.rmsf.locker.iot.iotlocker;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ListView;

import com.google.gson.Gson;
import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;

import cz.msebera.android.httpclient.Header;

public class AlertsActivity extends Activity {

    ListView listview;
    Alert alertObj;
    AlertAdapter adapter;
    String url = "http://web.ist.utl.pt/ist179069/IoTLocker/get_alerts.php";
    Gson gson;
    AsyncHttpClient client;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alerts);
        listview = (ListView) findViewById(R.id.alertsList);
        client = new AsyncHttpClient();
        client.get(AlertsActivity.this, url, new AsyncHttpResponseHandler() {
            @Override
            public void onSuccess(int statusCode, Header[] headers, byte[] responseBody) {
                String responseStr = new String(responseBody);
                gson = new Gson();
                alertObj = gson.fromJson(responseStr, Alert.class);
                adapter = new AlertAdapter(alertObj.getAlert(), AlertsActivity.this);
                listview.setAdapter(adapter);
            }

            @Override
            public void onFailure(int statusCode, Header[] headers, byte[] responseBody, Throwable error) {

            }
        });

    }
}
