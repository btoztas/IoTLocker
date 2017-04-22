package pt.ulisboa.tecnico.rmsf.locker.iot.iotlocker;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

import com.google.gson.Gson;
import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;

import cz.msebera.android.httpclient.Header;

public class HistoryActivity extends Activity {


    ListView listview;
    History historyObj;
    HistoryAdapter adapter;
    String url = "http://web.ist.utl.pt/ist179069/IoTLocker/get_history.php";
    Gson gson;
    AsyncHttpClient client;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_history);
        listview = (ListView) findViewById(R.id.history_list);
        client = new AsyncHttpClient();
        client.get(HistoryActivity.this, url, new AsyncHttpResponseHandler() {
            @Override
            public void onSuccess(int statusCode, Header[] headers, byte[] responseBody) {
                String responseStr = new String(responseBody);
                gson = new Gson();
                historyObj = gson.fromJson(responseStr, History.class);
                adapter = new HistoryAdapter(historyObj.getHistory(), HistoryActivity.this);
                listview.setAdapter(adapter);
            }

            @Override
            public void onFailure(int statusCode, Header[] headers, byte[] responseBody, Throwable error) {

            }
        });

    }
}
