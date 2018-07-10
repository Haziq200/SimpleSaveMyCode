package sg.edu.rp.dmsd.simplesave;

import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onResume() {
        super.onResume();

        //String msg = "No greetings!";

        //Step 2a: OBtain an instance of the SharedPReferences
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(this);
        // Step 2b: Reetrieve thw saved data with the key "greeting" from the SharedPreferences object
        String msg = prefs.getString("greeting","No greetings!");

        Toast toast = Toast.makeText(getApplicationContext(),msg,Toast.LENGTH_LONG);
        toast.show();

    }

    @Override
    protected void onPause() {
        super.onPause();

        // Step 1a: Obtain an instance of the SharedPreferences
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(this);
        // Step 1b: Obtain an instance of teh SharedPreference Editor for update later
        SharedPreferences.Editor prefEdit = prefs.edit();
        // Step 1c: Add the key-value pair
        prefEdit.putString("greeting","Hello!");
        // Step 1d: Call commit() method to save the changes into the SharedPreferences
        prefEdit.commit();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout);


    }
}


