package saarland.cispa.trust.chipper;

import android.content.ComponentName;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.net.http.SslError;
import android.text.TextUtils;
import android.util.Log;
import android.webkit.HttpAuthHandler;
import android.webkit.SslErrorHandler;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class b extends WebViewClient {
    public void onReceivedHttpAuthRequest(WebView webView, HttpAuthHandler httpAuthHandler, String str, String str2) {
        if (!httpAuthHandler.useHttpAuthUsernamePassword()) {
            httpAuthHandler.cancel();
        }
        SharedPreferences sharedPreferences = webView.getContext().getSharedPreferences(webView.getContext().getString(R.string.preferences_shared), 0);
        Object string = sharedPreferences.getString(webView.getContext().getString(R.string.preference_key_username), null);
        Object string2 = sharedPreferences.getString(webView.getContext().getString(R.string.preference_key_password), null);
        if (string == null || TextUtils.isEmpty(string) || string2 == null || TextUtils.isEmpty(string2)) {
            Log.e("Chipper.WebViewClient", "Authentication request failed, no username or password set");
        } else {
            httpAuthHandler.proceed(string, string2);
        }
    }

    public void onReceivedSslError(WebView webView, SslErrorHandler sslErrorHandler, SslError sslError) {
        if (sslError.getPrimaryError() == 3) {
            sslErrorHandler.proceed();
        }
        sslErrorHandler.cancel();
    }

    public boolean shouldOverrideUrlLoading(WebView webView, String str) {
        Uri parse = Uri.parse(str);
        if (parse.getScheme() == null || !(parse.getScheme().equals("http") || parse.getScheme().equals("https"))) {
            if (parse.getScheme() != null && parse.getScheme().equals("chipper")) {
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("Found chipper link ");
                stringBuilder.append(str);
                Log.d("Chipper.WebViewClient", stringBuilder.toString());
                Intent intent = new Intent();
                String packageName = webView.getContext().getPackageName();
                StringBuilder stringBuilder2 = new StringBuilder();
                stringBuilder2.append(webView.getContext().getPackageName());
                stringBuilder2.append(".PluginService");
                intent.setComponent(new ComponentName(packageName, stringBuilder2.toString()));
                intent.addCategory("saarland.cispa.trust.category.WEBVIEW_PLUGIN");
                intent.setData(parse);
                webView.getContext().startService(intent);
            }
            return true;
        } else if (parse.getHost() != null && parse.getHost().equals("androidlecture.de")) {
            return false;
        } else {
            webView.getContext().startActivity(new Intent("android.intent.action.VIEW", parse));
            return true;
        }
    }
}
