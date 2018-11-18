package saarland.cispa.trust.chipper.pluginapp;

import android.Manifest;
import android.content.ComponentName;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;

public class MainActivity extends AppCompatActivity {

    final static String TAG = "ChipperAttack";

    final static int MY_PERMISSIONS_REQUEST_READ_EXTERNAL_STORAGE = 1;
    final static int MY_PERMISSIONS_REQUEST_READ_PHONE_STATE = 2;

    final static int FOR_RESULT_PLUGIN = 1;

    Button btnPoisonCache, btnEscalatePrivileges, btnReadSharedPosts, btnReadBackupFile;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnPoisonCache = findViewById(R.id.btnPoisonCache);
        btnEscalatePrivileges = findViewById(R.id.btnEscalatePrivileges);
        btnReadSharedPosts = findViewById(R.id.btnReadSharedPosts);
        btnReadBackupFile = findViewById(R.id.btnReadBackupFile);

        btnPoisonCache.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                poisonCache();
            }
        });

        btnEscalatePrivileges.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                callForResult();
            }
        });

        btnReadSharedPosts.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                readSharedMessages();
            }
        });

        btnReadBackupFile.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                readAndDecryptBackupFile();
            }
        });


        //Request necessary permissions
        int permissionCheck = ContextCompat.checkSelfPermission(getApplicationContext(),
                Manifest.permission.READ_EXTERNAL_STORAGE);
        if(permissionCheck == PackageManager.PERMISSION_DENIED) {
            ActivityCompat.requestPermissions(this,
                    new String[]{Manifest.permission.READ_EXTERNAL_STORAGE},
                    MY_PERMISSIONS_REQUEST_READ_EXTERNAL_STORAGE);
        }

        permissionCheck = ContextCompat.checkSelfPermission(getApplicationContext(),
                Manifest.permission.READ_PHONE_STATE);
        if(permissionCheck == PackageManager.PERMISSION_DENIED) {
            ActivityCompat.requestPermissions(this,
                    new String[]{Manifest.permission.READ_PHONE_STATE},
                    MY_PERMISSIONS_REQUEST_READ_PHONE_STATE);
        }
    }

    /**
     * Handles the response of the grant permission request.
     */
    @Override
    public void onRequestPermissionsResult(int requestCode,
                                           String permissions[], int[] grantResults) {
        switch (requestCode) {
            case MY_PERMISSIONS_REQUEST_READ_EXTERNAL_STORAGE: {
                if (grantResults.length > 0
                        && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                } else {
                    Toast.makeText(getApplicationContext(), "Reading external storage " +
                            "required for reading the backup file",
                            Toast.LENGTH_LONG).show();
                }
                return;
            }
            case MY_PERMISSIONS_REQUEST_READ_PHONE_STATE: {
                if (grantResults.length > 0
                        && grantResults[0] == PackageManager.PERMISSION_GRANTED) {

                } else {
                    Toast.makeText(getApplicationContext(), "Reading external storage " +
                            "required for reading the backup file",
                            Toast.LENGTH_LONG).show();
                }
                return;
            }
        }
    }

    /**
     * Given a file's path, this method returns its content as a string. This is included here
     * only to save you some time.
     */
    public static String getFileContent(String filePath) throws Exception {
        File fl = new File(filePath);
        FileInputStream fin = new FileInputStream(fl);
        BufferedReader reader = new BufferedReader(new InputStreamReader(fin));
        StringBuilder sb = new StringBuilder();
        String line = null;
        while ((line = reader.readLine()) != null) {
            sb.append(line).append("\n");
        }
        reader.close();
        String ret = sb.toString();
        fin.close();
        return ret;
    }

    /**
     * Attack: Javascript Injection - Poison the cache.
     * @TODO: implement
     */
    public void poisonCache() {
        /**
         * Use a ContentResolver to read entries of the repository used to store Chipper's posts
         *  and then inject javascript in there such that, when rendered, it leaks user's credentials.
         */
        Log.d(TAG, "poisonCache");
    }

    /**
     * Attack: Escalate Privileges - First attack
     */
    public void callForResult() {
        /**
         * Start PluginActivity for result to retrieve the PendingIntent for the PluginService. The
         * result, however, is handled on onActivityResult.
         */
        Log.d(TAG, "callForResult");
        Intent intent = new Intent();
        intent.setComponent(new ComponentName("saarland.cispa.trust.chipper",
                "saarland.cispa.trust.chipper.PluginActivity"));
        startActivityForResult(intent, FOR_RESULT_PLUGIN);
    }

    /**
     * Attack: Escalate Privileges - First attack
     * @TODO: implement
     */
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        //Handle the asynchronous response for the request above.
        if(requestCode == FOR_RESULT_PLUGIN) {
            if(resultCode == RESULT_OK) {

                Intent i = new Intent();
                i.setClassName("saarland.cispa.trust.chipper", "saarland.cispa.trust.chipper.PluginActivity");




                //@TODO write the attack code
                this.startActivityForResult();

                Log.d(TAG, "onActivityResult");
            } else if (resultCode == RESULT_CANCELED) {
                Log.d(TAG, "Got result canceld");
            }
        }
    }

    /**
     * Attack: File System Leaks - First attack
     * @TODO: implement
     */
    public void readSharedMessages() {
        //Use the getFileContent if you have a file's path and you want to print its content
        Log.d(TAG, "readSharedMessages");
    }

    /**
     * Attack: File System Leaks - Second attack
     * @TODO: implement
     */
    public void readAndDecryptBackupFile() {
        //Read backup file (encrypted) and then decrypt it.
        Log.d(TAG, "readAndDecryptBackupFile");
    }
}
