package pt.ulisboa.tecnico.rmsf.locker.iot.iotlocker;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
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

public class RemoveUserActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_remove_user);

    }

    private void deleteUser(String userid) {

        OkHttpClient client = new OkHttpClient();
        Log.d("user", "deleteUser: " + userid);
        RequestBody formBody = new FormBody.Builder()
                .add("id", userid)
                .build();

        Log.d("user", "registerUser: " + userid);
        Request request = new Request.Builder()
                .url("http://web.ist.utl.pt/ist179069/IoTLocker/delete_user.php")
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


    public void removeUser(View view)
    {

        EditText userid_view = (EditText) findViewById(R.id.user_id);
        String userid = userid_view.getText().toString();

        if(userid.length() > 0){

            deleteUser(userid);

        }

        userid_view.setText("");


    }
}
