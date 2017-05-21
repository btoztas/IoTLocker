package pt.ulisboa.tecnico.rmsf.locker.iot.iotlocker;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class AddUserActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_user);



    }

    private void registerUser(String username, String userid) {

        OkHttpClient client = new OkHttpClient();
        Log.d("user", "registerUser: " + username + " "+ userid);
        RequestBody formBody = new FormBody.Builder()
                .add("name", username)
                .add("id", userid)
                .build();

        Log.d("user", "registerUser: " + username + " "+ userid);
        Request request = new Request.Builder()
                .url("http://web.ist.utl.pt/ist179069/IoTLocker/add_user.php")
                .post(formBody)
                .build();

        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                e.printStackTrace();
            }

            @Override
            public void onResponse(Call call, final Response response) throws IOException {
                if (!response.isSuccessful()) {
                    throw new IOException("Unexpected code " + response);
                }

                // you code to handle response
            }
        });





    }


    public void addUser(View view)
    {

        EditText username_view = (EditText) findViewById(R.id.user_name);
        EditText userid_view = (EditText) findViewById(R.id.user_id);
        String username = username_view.getText().toString();
        String userid = userid_view.getText().toString();

        if(username.length() > 0 && userid.length() > 0){

            registerUser(username, userid);

        }

        username_view.setText("");
        userid_view.setText("");


    }

}
