package saarland.cispa.trust.chipper;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.annotation.TargetApi;
import android.content.ComponentName;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.AsyncTask;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.support.v7.app.c;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;
import org.json.JSONException;
import org.json.JSONObject;

public class PostMessageActivity extends c {
    private EditText k;
    private EditText l;
    private Button m;
    private View n;
    private CheckBox o;
    private String p;
    private String q;
    private a r;

    class a extends AsyncTask<Void, Void, Boolean> {
        JSONObject a = new JSONObject();
        String b;
        String c;
        String d = "";

        a(String str, String str2, String str3, String str4, String str5, boolean z) {
            this.a.put("message", str4);
            this.a.put("link", str5);
            this.a.put("type", z);
            this.a.put("appauth", str3);
            this.c = str;
            this.b = str2;
        }

        /* renamed from: a */
        protected Boolean doInBackground(Void... voidArr) {
            String a = new c(PostMessageActivity.this.getApplicationContext()).a("https://androidlecture.de:5000/api/message/post", this.c, this.b, this.a);
            if (a == null) {
                Log.d("Chipper.PostMessageTask", "Failed, response is null");
                a = "Empty response";
            } else {
                try {
                    JSONObject jSONObject = new JSONObject(a);
                    if (jSONObject.has("result") && jSONObject.getString("result").equals("successful")) {
                        this.d = "Message posted";
                        return Boolean.valueOf(true);
                    } else if (jSONObject.has("error")) {
                        this.d = jSONObject.getString("error");
                        return Boolean.valueOf(false);
                    } else {
                        Log.d("Chipper.PostMessageTask", "Failed, no 'result' mapping.");
                        a = "Undefined error";
                    }
                } catch (Throwable e) {
                    Log.e("Chipper.PostMessageTask", "Error parsing response", e);
                    a = "Error parsing response";
                }
            }
            this.d = a;
            return Boolean.valueOf(false);
        }

        /* renamed from: a */
        protected void onPostExecute(Boolean bool) {
            PostMessageActivity.this.a(false);
            Toast.makeText(PostMessageActivity.this.getApplicationContext(), PostMessageActivity.this.r.d, 1).show();
            if (bool.booleanValue()) {
                PostMessageActivity.this.k.setText("");
                PostMessageActivity.this.l.setText("");
            }
            Intent intent = new Intent();
            intent.setComponent(new ComponentName("saarland.cispa.trust.chipper.pluginapp", "saarland.cispa.trust.chipper.pluginapp.PluginReceiver"));
            intent.setAction("saarland.cispa.trust.chipper.INFORM_PLUGIN");
            try {
                this.a.put("username", this.c);
                intent.putExtra("messages", this.a.toString());
                PostMessageActivity.this.sendBroadcast(intent);
            } catch (JSONException unused) {
                Log.e("Chipper.PostMessageTask", "Error sending message to plugin app");
            }
            PostMessageActivity.this.r = null;
            PostMessageActivity.this.finish();
        }

        protected void onCancelled() {
            PostMessageActivity.this.r = null;
            PostMessageActivity.this.a(false);
        }
    }

    @TargetApi(13)
    private void a(final boolean z) {
        int i = 8;
        if (VERSION.SDK_INT >= 13) {
            int integer = getResources().getInteger(17694720);
            View view = this.n;
            if (z) {
                i = 0;
            }
            view.setVisibility(i);
            this.n.animate().setDuration((long) integer).alpha(z ? 1.0f : 0.0f).setListener(new AnimatorListenerAdapter() {
                public void onAnimationEnd(Animator animator) {
                    PostMessageActivity.this.n.setVisibility(z ? 0 : 8);
                }
            });
            return;
        }
        View view2 = this.n;
        if (z) {
            i = 0;
        }
        view2.setVisibility(i);
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x00b3 A:{ExcHandler: android.content.pm.PackageManager.NameNotFoundException (unused android.content.pm.PackageManager$NameNotFoundException), Splitter: B:4:0x0021} */
    /* JADX WARNING: Removed duplicated region for block: B:11:0x00b0 A:{ExcHandler: org.json.JSONException (unused org.json.JSONException), Splitter: B:4:0x0021} */
    /* JADX WARNING: Missing block: B:11:0x00b0, code:
            r1 = "Could not create request";
     */
    /* JADX WARNING: Missing block: B:12:0x00b3, code:
            r1 = "Could not get package signature";
     */
    /* JADX WARNING: Missing block: B:13:0x00b5, code:
            android.widget.Toast.makeText(r12, r1, 1).show();
            a(false);
     */
    /* JADX WARNING: Missing block: B:14:0x00bf, code:
            return;
     */
    private void k() {
        /*
        r12 = this;
        r0 = r12.k;
        r0 = r0.getText();
        r0 = android.text.TextUtils.isEmpty(r0);
        if (r0 == 0) goto L_0x0018;
    L_0x000c:
        r0 = r12.k;
        r1 = 2131623985; // 0x7f0e0031 float:1.8875137E38 double:1.053162181E-314;
        r1 = r12.getString(r1);
        r0.setError(r1);
    L_0x0018:
        r0 = 1;
        r12.a(r0);
        r1 = r12.getPackageManager();
        r2 = 0;
        r3 = r12.getPackageName();	 Catch:{ NameNotFoundException -> 0x00b3, NameNotFoundException -> 0x00b3, JSONException -> 0x00b0, JSONException -> 0x00b0 }
        r4 = 64;
        r1 = r1.getPackageInfo(r3, r4);	 Catch:{ NameNotFoundException -> 0x00b3, NameNotFoundException -> 0x00b3, JSONException -> 0x00b0, JSONException -> 0x00b0 }
        r3 = r1.signatures;	 Catch:{ NameNotFoundException -> 0x00b3, NameNotFoundException -> 0x00b3, JSONException -> 0x00b0, JSONException -> 0x00b0 }
        r3 = r3.length;	 Catch:{ NameNotFoundException -> 0x00b3, NameNotFoundException -> 0x00b3, JSONException -> 0x00b0, JSONException -> 0x00b0 }
        if (r3 >= r0) goto L_0x003a;
    L_0x0030:
        r1 = "Could not get package signature";
        r1 = android.widget.Toast.makeText(r12, r1, r0);	 Catch:{ NameNotFoundException -> 0x00b3, NameNotFoundException -> 0x00b3, JSONException -> 0x00b0, JSONException -> 0x00b0 }
        r1.show();	 Catch:{ NameNotFoundException -> 0x00b3, NameNotFoundException -> 0x00b3, JSONException -> 0x00b0, JSONException -> 0x00b0 }
        return;
    L_0x003a:
        r1 = r1.signatures;	 Catch:{ NameNotFoundException -> 0x00b3, NameNotFoundException -> 0x00b3, JSONException -> 0x00b0, JSONException -> 0x00b0 }
        r1 = r1[r2];	 Catch:{ NameNotFoundException -> 0x00b3, NameNotFoundException -> 0x00b3, JSONException -> 0x00b0, JSONException -> 0x00b0 }
        r3 = "X.509";
        r3 = java.security.cert.CertificateFactory.getInstance(r3);	 Catch:{ NameNotFoundException -> 0x00b3, NameNotFoundException -> 0x00b3, JSONException -> 0x00b0, JSONException -> 0x00b0 }
        r4 = new java.io.ByteArrayInputStream;	 Catch:{ NameNotFoundException -> 0x00b3, NameNotFoundException -> 0x00b3, JSONException -> 0x00b0, JSONException -> 0x00b0 }
        r1 = r1.toByteArray();	 Catch:{ NameNotFoundException -> 0x00b3, NameNotFoundException -> 0x00b3, JSONException -> 0x00b0, JSONException -> 0x00b0 }
        r4.<init>(r1);	 Catch:{ NameNotFoundException -> 0x00b3, NameNotFoundException -> 0x00b3, JSONException -> 0x00b0, JSONException -> 0x00b0 }
        r1 = r3.generateCertificate(r4);	 Catch:{ NameNotFoundException -> 0x00b3, NameNotFoundException -> 0x00b3, JSONException -> 0x00b0, JSONException -> 0x00b0 }
        r1 = (java.security.cert.X509Certificate) r1;	 Catch:{ NameNotFoundException -> 0x00b3, NameNotFoundException -> 0x00b3, JSONException -> 0x00b0, JSONException -> 0x00b0 }
        r3 = "SHA-1";
        r3 = java.security.MessageDigest.getInstance(r3);	 Catch:{ NameNotFoundException -> 0x00b3, NameNotFoundException -> 0x00b3, JSONException -> 0x00b0, JSONException -> 0x00b0 }
        r1 = r1.getSignature();	 Catch:{ NameNotFoundException -> 0x00b3, NameNotFoundException -> 0x00b3, JSONException -> 0x00b0, JSONException -> 0x00b0 }
        r1 = r3.digest(r1);	 Catch:{ NameNotFoundException -> 0x00b3, NameNotFoundException -> 0x00b3, JSONException -> 0x00b0, JSONException -> 0x00b0 }
        r3 = 2;
        r8 = android.util.Base64.encodeToString(r1, r3);	 Catch:{ NameNotFoundException -> 0x00b3, NameNotFoundException -> 0x00b3, JSONException -> 0x00b0, JSONException -> 0x00b0 }
        r1 = "Chipper.PostMessageAct";
        r3 = new java.lang.StringBuilder;	 Catch:{ NameNotFoundException -> 0x00b3, NameNotFoundException -> 0x00b3, JSONException -> 0x00b0, JSONException -> 0x00b0 }
        r3.<init>();	 Catch:{ NameNotFoundException -> 0x00b3, NameNotFoundException -> 0x00b3, JSONException -> 0x00b0, JSONException -> 0x00b0 }
        r4 = "Using appauth ";
        r3.append(r4);	 Catch:{ NameNotFoundException -> 0x00b3, NameNotFoundException -> 0x00b3, JSONException -> 0x00b0, JSONException -> 0x00b0 }
        r3.append(r8);	 Catch:{ NameNotFoundException -> 0x00b3, NameNotFoundException -> 0x00b3, JSONException -> 0x00b0, JSONException -> 0x00b0 }
        r3 = r3.toString();	 Catch:{ NameNotFoundException -> 0x00b3, NameNotFoundException -> 0x00b3, JSONException -> 0x00b0, JSONException -> 0x00b0 }
        android.util.Log.d(r1, r3);	 Catch:{ NameNotFoundException -> 0x00b3, NameNotFoundException -> 0x00b3, JSONException -> 0x00b0, JSONException -> 0x00b0 }
        r1 = new saarland.cispa.trust.chipper.PostMessageActivity$a;	 Catch:{ NameNotFoundException -> 0x00b3, NameNotFoundException -> 0x00b3, JSONException -> 0x00b0, JSONException -> 0x00b0 }
        r6 = r12.p;	 Catch:{ NameNotFoundException -> 0x00b3, NameNotFoundException -> 0x00b3, JSONException -> 0x00b0, JSONException -> 0x00b0 }
        r7 = r12.q;	 Catch:{ NameNotFoundException -> 0x00b3, NameNotFoundException -> 0x00b3, JSONException -> 0x00b0, JSONException -> 0x00b0 }
        r3 = r12.k;	 Catch:{ NameNotFoundException -> 0x00b3, NameNotFoundException -> 0x00b3, JSONException -> 0x00b0, JSONException -> 0x00b0 }
        r3 = r3.getText();	 Catch:{ NameNotFoundException -> 0x00b3, NameNotFoundException -> 0x00b3, JSONException -> 0x00b0, JSONException -> 0x00b0 }
        r9 = r3.toString();	 Catch:{ NameNotFoundException -> 0x00b3, NameNotFoundException -> 0x00b3, JSONException -> 0x00b0, JSONException -> 0x00b0 }
        r3 = r12.l;	 Catch:{ NameNotFoundException -> 0x00b3, NameNotFoundException -> 0x00b3, JSONException -> 0x00b0, JSONException -> 0x00b0 }
        r3 = r3.getText();	 Catch:{ NameNotFoundException -> 0x00b3, NameNotFoundException -> 0x00b3, JSONException -> 0x00b0, JSONException -> 0x00b0 }
        r10 = r3.toString();	 Catch:{ NameNotFoundException -> 0x00b3, NameNotFoundException -> 0x00b3, JSONException -> 0x00b0, JSONException -> 0x00b0 }
        r3 = r12.o;	 Catch:{ NameNotFoundException -> 0x00b3, NameNotFoundException -> 0x00b3, JSONException -> 0x00b0, JSONException -> 0x00b0 }
        r11 = r3.isChecked();	 Catch:{ NameNotFoundException -> 0x00b3, NameNotFoundException -> 0x00b3, JSONException -> 0x00b0, JSONException -> 0x00b0 }
        r4 = r1;
        r5 = r12;
        r4.<init>(r6, r7, r8, r9, r10, r11);	 Catch:{ NameNotFoundException -> 0x00b3, NameNotFoundException -> 0x00b3, JSONException -> 0x00b0, JSONException -> 0x00b0 }
        r12.r = r1;	 Catch:{ NameNotFoundException -> 0x00b3, NameNotFoundException -> 0x00b3, JSONException -> 0x00b0, JSONException -> 0x00b0 }
        r1 = r12.r;	 Catch:{ NameNotFoundException -> 0x00b3, NameNotFoundException -> 0x00b3, JSONException -> 0x00b0, JSONException -> 0x00b0 }
        r3 = new java.lang.Void[r0];	 Catch:{ NameNotFoundException -> 0x00b3, NameNotFoundException -> 0x00b3, JSONException -> 0x00b0, JSONException -> 0x00b0 }
        r4 = 0;
        r4 = (java.lang.Void) r4;	 Catch:{ NameNotFoundException -> 0x00b3, NameNotFoundException -> 0x00b3, JSONException -> 0x00b0, JSONException -> 0x00b0 }
        r3[r2] = r4;	 Catch:{ NameNotFoundException -> 0x00b3, NameNotFoundException -> 0x00b3, JSONException -> 0x00b0, JSONException -> 0x00b0 }
        r1.execute(r3);	 Catch:{ NameNotFoundException -> 0x00b3, NameNotFoundException -> 0x00b3, JSONException -> 0x00b0, JSONException -> 0x00b0 }
        return;
    L_0x00b0:
        r1 = "Could not create request";
        goto L_0x00b5;
    L_0x00b3:
        r1 = "Could not get package signature";
    L_0x00b5:
        r0 = android.widget.Toast.makeText(r12, r1, r0);
        r0.show();
        r12.a(r2);
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: saarland.cispa.trust.chipper.PostMessageActivity.k():void");
    }

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView((int) R.layout.activity_post_message);
        this.n = findViewById(R.id.posting_progress);
        this.k = (EditText) findViewById(R.id.messageText);
        this.l = (EditText) findViewById(R.id.linkText);
        this.o = (CheckBox) findViewById(R.id.privateCheckbox);
        this.m = (Button) findViewById(R.id.postButton);
        this.m.setOnClickListener(new OnClickListener() {
            public void onClick(View view) {
                PostMessageActivity.this.k();
            }
        });
    }

    public void onResume() {
        super.onResume();
        SharedPreferences sharedPreferences = getSharedPreferences(getString(R.string.preferences_shared), 0);
        this.p = sharedPreferences.getString(getString(R.string.preference_key_username), null);
        this.q = sharedPreferences.getString(getString(R.string.preference_key_password), null);
        NetworkInfo activeNetworkInfo = ((ConnectivityManager) getSystemService("connectivity")).getActiveNetworkInfo();
        int i = (activeNetworkInfo == null || !activeNetworkInfo.isConnectedOrConnecting()) ? false : 1;
        if (i == 0 || this.p == null || TextUtils.isEmpty(this.p) || this.q == null || TextUtils.isEmpty(this.q)) {
            this.m.setEnabled(false);
            this.k.setText(i != 0 ? "No user set" : "Device is offline");
            this.k.setEnabled(false);
            Toast.makeText(this, i != 0 ? "Cannot post, no user set" : "Cannot post, device is offline", 1).show();
        }
    }
}
