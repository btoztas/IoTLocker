package pt.ulisboa.tecnico.rmsf.locker.iot.iotlocker;

import android.app.Activity;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.EditText;

import java.io.IOException;

import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;

public class AddUser extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_user);



    }

    private void registerUser(String username, String userid) {

        OkHttpClient client = new OkHttpClient();
        RequestBody body = new FormBody.Builder()
                .add("id",userid)
                .add("name",username)
                .build();

        Request request = new Request.Builder()
                .url("http://web.ist.utl.pt/ist179069/IoTLocker/add_user.php")
                .post(body)
                .build();

        try {
            client.newCall(request).execute();
        } catch (IOException e) {
            e.printStackTrace();
        }
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



    }

}
