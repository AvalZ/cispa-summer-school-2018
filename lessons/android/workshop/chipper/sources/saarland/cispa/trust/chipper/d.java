package saarland.cispa.trust.chipper;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.util.Log;
import android.webkit.JavascriptInterface;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class d {
    private Context a;

    d(Context context) {
        this.a = context;
    }

    @JavascriptInterface
    public String getSystemTime(String str) {
        String format = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss").format(Calendar.getInstance().getTime());
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Today is: ");
        stringBuilder.append(format);
        Log.d("Chipper.WebAppJSI", stringBuilder.toString());
        return format;
    }

    @JavascriptInterface
    public void sendURI(String str) {
        if (str == null) {
            Log.d("Chipper.WebAppJSI", "Empty uri, ignoring call");
            return;
        }
        Intent intent = new Intent();
        String packageName = this.a.getPackageName();
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(this.a.getPackageName());
        stringBuilder.append(".PluginService");
        intent.setComponent(new ComponentName(packageName, stringBuilder.toString()));
        intent.addCategory("saarland.cispa.trust.category.WEBVIEW_PLUGIN");
        intent.setData(Uri.parse(str));
        this.a.startService(intent);
    }
}
