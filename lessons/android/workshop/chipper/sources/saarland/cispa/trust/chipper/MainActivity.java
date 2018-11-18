package saarland.cispa.trust.chipper;

import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.http.HttpResponseCache;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.c;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.webkit.WebView;
import android.widget.Toast;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import javax.net.ssl.HttpsURLConnection;
import saarland.cispa.trust.chipper.a.a;

public class MainActivity extends c {
    WebView k;

    private void a(String str) {
        Log.d("Chipper.MainActivity", "No connection, loading from cache");
        File file = new File(getCacheDir(), "www");
        file.mkdirs();
        String str2 = "url = ?";
        String[] strArr = new String[]{""};
        if (str == null) {
            strArr[0] = "https://androidlecture.de:5000";
        } else {
            strArr[0] = "https://androidlecture.de:5000/index_all";
        }
        Cursor query = getContentResolver().query(a.a, null, str2, strArr, "time DESC LIMIT 1");
        if (query.getCount() != 1) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("Failed to get cached content for ");
            stringBuilder.append(strArr[0]);
            Log.e("Chipper.MainActivity", stringBuilder.toString());
            Toast.makeText(this, "Could not find cached content", 1).show();
            return;
        }
        query.moveToFirst();
        String string = query.getString(query.getColumnIndex("content"));
        File file2 = new File(file, "index.html");
        try {
            OutputStream fileOutputStream = new FileOutputStream(file2);
            OutputStreamWriter outputStreamWriter = new OutputStreamWriter(fileOutputStream);
            outputStreamWriter.write(string);
            outputStreamWriter.close();
            fileOutputStream.flush();
            fileOutputStream.close();
        } catch (Throwable e) {
            Log.e("Chipper.MainActivity", "Could create cached file", e);
        } catch (Throwable th) {
            query.close();
        }
        query.close();
        WebView webView = this.k;
        StringBuilder stringBuilder2 = new StringBuilder();
        stringBuilder2.append("file://");
        stringBuilder2.append(file2.getAbsolutePath());
        webView.loadUrl(stringBuilder2.toString());
    }

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView((int) R.layout.activity_main);
        a((Toolbar) findViewById(R.id.toolbar));
        ((FloatingActionButton) findViewById(R.id.fab)).setOnClickListener(new OnClickListener() {
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this.getApplicationContext(), PostMessageActivity.class);
                intent.setFlags(268435456);
                MainActivity.this.getApplicationContext().startActivity(intent);
            }
        });
        this.k = (WebView) findViewById(R.id.webview);
        this.k.setWebViewClient(new b());
        this.k.getSettings().setJavaScriptEnabled(true);
        this.k.addJavascriptInterface(new d(this), "jsinterface");
        HttpResponseCache.setDefault(null);
        System.setProperty("http.keepAlive", "false");
        HttpsURLConnection.setFollowRedirects(false);
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem menuItem) {
        Intent intent;
        int itemId = menuItem.getItemId();
        if (itemId == R.id.action_signup) {
            intent = new Intent(this, SignUpActivity.class);
        } else if (itemId == R.id.action_share) {
            intent = new Intent(this, MessageSelectionActivity.class);
        } else if (itemId != R.id.action_backup) {
            return super.onOptionsItemSelected(menuItem);
        } else {
            intent = new Intent(this, BackupActivity.class);
        }
        startActivity(intent);
        return true;
    }

    public void onResume() {
        super.onResume();
        NetworkInfo activeNetworkInfo = ((ConnectivityManager) getSystemService("connectivity")).getActiveNetworkInfo();
        int i = (activeNetworkInfo == null || !activeNetworkInfo.isConnectedOrConnecting()) ? 0 : 1;
        SharedPreferences sharedPreferences = getSharedPreferences(getString(R.string.preferences_shared), 0);
        String string = sharedPreferences.getString(getString(R.string.preference_key_username), null);
        String string2 = sharedPreferences.getString(getString(R.string.preference_key_password), null);
        if (i == 0) {
            a(string);
        } else if (string == null) {
            this.k.loadUrl("https://androidlecture.de:5000");
            SyncService.a(getApplicationContext(), "https://androidlecture.de:5000", null, null);
            SyncService.a(getApplicationContext());
        } else {
            this.k.loadUrl("https://androidlecture.de:5000/index_all");
            SyncService.a(getApplicationContext(), "https://androidlecture.de:5000/index_all", string, string2);
            SyncService.a(getApplicationContext(), string, string2);
        }
    }
}
