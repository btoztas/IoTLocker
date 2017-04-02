package pt.ulisboa.tecnico.rmsf.locker.iot.iotlocker;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ListView;

import com.google.gson.Gson;
import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;

import cz.msebera.android.httpclient.Header;

public class UsersActivity extends Activity {

    ListView listview;
    Response userObj;
    CustomAdapter adapter;
    String url = "http://web.ist.utl.pt/ist179069/RMSF/get_users.php";
    Gson gson;

    AsyncHttpClient client;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_users);
        listview = (ListView) findViewById(R.id.users_list);
        client = new AsyncHttpClient();
        client.get(UsersActivity.this, url, new AsyncHttpResponseHandler() {
            @Override
            public void onSuccess(int statusCode, Header[] headers, byte[] responseBody) {
                String responseStr = new String(responseBody);
                gson = new Gson();
                userObj = gson.fromJson(responseStr, Response.class);
                adapter = new CustomAdapter(userObj.getUser(), UsersActivity.this);
                listview.setAdapter(adapter);
            }

            @Override
            public void onFailure(int statusCode, Header[] headers, byte[] responseBody, Throwable error) {

            }
        });
    }
}
