package pt.ulisboa.tecnico.rmsf.locker.iot.iotlocker;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setLogo(R.mipmap.ic_launcher);
        getSupportActionBar().setDisplayUseLogoEnabled(true);
    }

        public void goToAddUser(View view)
    {
        Intent intent = new Intent(MainActivity.this, AddUser.class);
        startActivity(intent);
    }

    public void goToHistory(View view)
    {
        Intent intent = new Intent(MainActivity.this, HistoryActivity.class);
        startActivity(intent);
    }
    public void goToAlerts(View view)
    {
        Intent intent = new Intent(MainActivity.this, AlertsActivity.class);
        startActivity(intent);
    }
    public void goToUsers(View view)
    {
        Intent intent = new Intent(MainActivity.this, UsersActivity.class);
        startActivity(intent);
    }
}
