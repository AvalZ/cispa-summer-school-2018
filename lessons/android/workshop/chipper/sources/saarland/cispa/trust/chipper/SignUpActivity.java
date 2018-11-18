package saarland.cispa.trust.chipper;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.annotation.TargetApi;
import android.content.SharedPreferences.Editor;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.AsyncTask;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.support.v7.app.c;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewPropertyAnimator;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.TextView.OnEditorActionListener;
import android.widget.Toast;
import org.json.JSONObject;
import saarland.cispa.trust.chipper.a.b;

public class SignUpActivity extends c {
    private a k = null;
    private EditText l;
    private EditText m;
    private View n;
    private View o;
    private Button p;
    private Button q;

    public class a extends AsyncTask<Void, Void, Boolean> {
        JSONObject a;
        String b;
        String c;
        boolean d;
        String e = "";

        a(String str, String str2, String str3, boolean z) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("appauth: ");
            stringBuilder.append(str3);
            stringBuilder.append(", user: ");
            stringBuilder.append(str);
            stringBuilder.append(", password: ");
            stringBuilder.append(str2);
            Log.d("UserAPITask", stringBuilder.toString());
            this.a = new JSONObject();
            this.a.put("username", str);
            if (!z) {
                this.a.put("password", str2);
            }
            this.a.put("appauth", str3);
            this.c = str;
            this.b = str2;
            this.d = z;
        }

        /* renamed from: a */
        protected Boolean doInBackground(Void... voidArr) {
            c cVar = new c(SignUpActivity.this.getApplicationContext());
            String a = this.d ? cVar.a("https://androidlecture.de:5000/api/user/delete", this.c, this.b, this.a) : cVar.a("https://androidlecture.de:5000/api/user/signup", this.a);
            if (a == null) {
                Log.d("Chipper.PostMessageTask", "Failed, response is null");
                a = "Empty response";
            } else {
                try {
                    JSONObject jSONObject = new JSONObject(a);
                    if (jSONObject.has("result") && jSONObject.getString("result").equals("successful")) {
                        Editor edit;
                        if (this.d) {
                            edit = SignUpActivity.this.getSharedPreferences(SignUpActivity.this.getString(R.string.preferences_shared), 0).edit();
                            edit.putString(SignUpActivity.this.getString(R.string.preference_key_username), null);
                            edit.putString(SignUpActivity.this.getString(R.string.preference_key_password), null);
                            edit.commit();
                            SignUpActivity.this.getContentResolver().delete(b.a, null, null);
                            this.e = "Account successfully deleted";
                            return Boolean.valueOf(true);
                        }
                        edit = SignUpActivity.this.getSharedPreferences(SignUpActivity.this.getString(R.string.preferences_shared), 0).edit();
                        edit.putString(SignUpActivity.this.getString(R.string.preference_key_username), this.c);
                        edit.putString(SignUpActivity.this.getString(R.string.preference_key_password), this.b);
                        edit.commit();
                        StringBuilder stringBuilder = new StringBuilder();
                        stringBuilder.append("Sign up successful (");
                        stringBuilder.append(this.c);
                        stringBuilder.append(")");
                        this.e = stringBuilder.toString();
                        return Boolean.valueOf(true);
                    } else if (jSONObject.has("error")) {
                        this.e = jSONObject.getString("error");
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
            this.e = a;
            return Boolean.valueOf(false);
        }

        /* renamed from: a */
        protected void onPostExecute(Boolean bool) {
            SignUpActivity.this.a(false);
            Toast.makeText(SignUpActivity.this.getApplicationContext(), SignUpActivity.this.k.e, 1).show();
            if (bool.booleanValue()) {
                if (SignUpActivity.this.k.d) {
                    SignUpActivity.this.l.setText("");
                    SignUpActivity.this.m.setText("");
                    SignUpActivity.this.l.setEnabled(true);
                    SignUpActivity.this.m.setEnabled(true);
                    SignUpActivity.this.p.setEnabled(true);
                    SignUpActivity.this.q.setEnabled(false);
                } else {
                    SignUpActivity.this.l.setText(SignUpActivity.this.k.c);
                    SignUpActivity.this.m.setText("");
                    SignUpActivity.this.l.setEnabled(false);
                    SignUpActivity.this.m.setEnabled(false);
                    SignUpActivity.this.p.setEnabled(false);
                    SignUpActivity.this.q.setEnabled(true);
                }
            }
            SignUpActivity.this.k = null;
        }

        protected void onCancelled() {
            SignUpActivity.this.k = null;
            SignUpActivity.this.a(false);
        }
    }

    @TargetApi(13)
    private void a(final boolean z) {
        int i = 0;
        if (VERSION.SDK_INT >= 13) {
            int integer = getResources().getInteger(17694720);
            this.o.setVisibility(z ? 8 : 0);
            long j = (long) integer;
            float f = 1.0f;
            this.o.animate().setDuration(j).alpha(z ? 0.0f : 1.0f).setListener(new AnimatorListenerAdapter() {
                public void onAnimationEnd(Animator animator) {
                    SignUpActivity.this.o.setVisibility(z ? 8 : 0);
                }
            });
            View view = this.n;
            if (!z) {
                i = 8;
            }
            view.setVisibility(i);
            ViewPropertyAnimator duration = this.n.animate().setDuration(j);
            if (!z) {
                f = 0.0f;
            }
            duration.alpha(f).setListener(new AnimatorListenerAdapter() {
                public void onAnimationEnd(Animator animator) {
                    SignUpActivity.this.n.setVisibility(z ? 0 : 8);
                }
            });
            return;
        }
        this.n.setVisibility(z ? 0 : 8);
        View view2 = this.o;
        if (z) {
            i = 8;
        }
        view2.setVisibility(i);
    }

    /* JADX WARNING: Removed duplicated region for block: B:11:0x00a7 A:{ExcHandler: android.content.pm.PackageManager.NameNotFoundException (unused android.content.pm.PackageManager$NameNotFoundException), Splitter: B:1:0x002b} */
    /* JADX WARNING: Missing block: B:11:0x00a7, code:
            r1 = "Could not get package signature";
     */
    private void k() {
        /*
        r10 = this;
        r0 = 2131623994; // 0x7f0e003a float:1.8875155E38 double:1.0531621853E-314;
        r0 = r10.getString(r0);
        r1 = 0;
        r0 = r10.getSharedPreferences(r0, r1);
        r2 = 2131623993; // 0x7f0e0039 float:1.8875153E38 double:1.053162185E-314;
        r2 = r10.getString(r2);
        r3 = 0;
        r6 = r0.getString(r2, r3);
        r2 = 2131623992; // 0x7f0e0038 float:1.8875151E38 double:1.0531621843E-314;
        r2 = r10.getString(r2);
        r7 = r0.getString(r2, r3);
        r0 = 1;
        r10.a(r0);
        r2 = r10.getPackageManager();
        r4 = r10.getPackageName();	 Catch:{ NameNotFoundException -> 0x00a7, NameNotFoundException -> 0x00a7, JSONException -> 0x00a4, NoSuchAlgorithmException -> 0x009c }
        r5 = 64;
        r2 = r2.getPackageInfo(r4, r5);	 Catch:{ NameNotFoundException -> 0x00a7, NameNotFoundException -> 0x00a7, JSONException -> 0x00a4, NoSuchAlgorithmException -> 0x009c }
        r4 = r2.signatures;	 Catch:{ NameNotFoundException -> 0x00a7, NameNotFoundException -> 0x00a7, JSONException -> 0x00a4, NoSuchAlgorithmException -> 0x009c }
        r4 = r4.length;	 Catch:{ NameNotFoundException -> 0x00a7, NameNotFoundException -> 0x00a7, JSONException -> 0x00a4, NoSuchAlgorithmException -> 0x009c }
        if (r4 >= r0) goto L_0x0044;
    L_0x003a:
        r1 = "Could not get package signature";
        r1 = android.widget.Toast.makeText(r10, r1, r0);	 Catch:{ NameNotFoundException -> 0x00a7, NameNotFoundException -> 0x00a7, JSONException -> 0x00a4, NoSuchAlgorithmException -> 0x009c }
        r1.show();	 Catch:{ NameNotFoundException -> 0x00a7, NameNotFoundException -> 0x00a7, JSONException -> 0x00a4, NoSuchAlgorithmException -> 0x009c }
        return;
    L_0x0044:
        r2 = r2.signatures;	 Catch:{ NameNotFoundException -> 0x00a7, NameNotFoundException -> 0x00a7, JSONException -> 0x00a4, NoSuchAlgorithmException -> 0x009c }
        r2 = r2[r1];	 Catch:{ NameNotFoundException -> 0x00a7, NameNotFoundException -> 0x00a7, JSONException -> 0x00a4, NoSuchAlgorithmException -> 0x009c }
        r4 = "X.509";
        r4 = java.security.cert.CertificateFactory.getInstance(r4);	 Catch:{ NameNotFoundException -> 0x00a7, NameNotFoundException -> 0x00a7, JSONException -> 0x00a4, NoSuchAlgorithmException -> 0x009c }
        r5 = new java.io.ByteArrayInputStream;	 Catch:{ NameNotFoundException -> 0x00a7, NameNotFoundException -> 0x00a7, JSONException -> 0x00a4, NoSuchAlgorithmException -> 0x009c }
        r2 = r2.toByteArray();	 Catch:{ NameNotFoundException -> 0x00a7, NameNotFoundException -> 0x00a7, JSONException -> 0x00a4, NoSuchAlgorithmException -> 0x009c }
        r5.<init>(r2);	 Catch:{ NameNotFoundException -> 0x00a7, NameNotFoundException -> 0x00a7, JSONException -> 0x00a4, NoSuchAlgorithmException -> 0x009c }
        r2 = r4.generateCertificate(r5);	 Catch:{ NameNotFoundException -> 0x00a7, NameNotFoundException -> 0x00a7, JSONException -> 0x00a4, NoSuchAlgorithmException -> 0x009c }
        r2 = (java.security.cert.X509Certificate) r2;	 Catch:{ NameNotFoundException -> 0x00a7, NameNotFoundException -> 0x00a7, JSONException -> 0x00a4, NoSuchAlgorithmException -> 0x009c }
        r4 = "SHA-1";
        r4 = java.security.MessageDigest.getInstance(r4);	 Catch:{ NameNotFoundException -> 0x00a7, NameNotFoundException -> 0x00a7, JSONException -> 0x00a4, NoSuchAlgorithmException -> 0x009c }
        r2 = r2.getSignature();	 Catch:{ NameNotFoundException -> 0x00a7, NameNotFoundException -> 0x00a7, JSONException -> 0x00a4, NoSuchAlgorithmException -> 0x009c }
        r2 = r4.digest(r2);	 Catch:{ NameNotFoundException -> 0x00a7, NameNotFoundException -> 0x00a7, JSONException -> 0x00a4, NoSuchAlgorithmException -> 0x009c }
        r4 = 2;
        r8 = android.util.Base64.encodeToString(r2, r4);	 Catch:{ NameNotFoundException -> 0x00a7, NameNotFoundException -> 0x00a7, JSONException -> 0x00a4, NoSuchAlgorithmException -> 0x009c }
        r2 = "Chipper.SignUpActivity";
        r4 = new java.lang.StringBuilder;	 Catch:{ NameNotFoundException -> 0x00a7, NameNotFoundException -> 0x00a7, JSONException -> 0x00a4, NoSuchAlgorithmException -> 0x009c }
        r4.<init>();	 Catch:{ NameNotFoundException -> 0x00a7, NameNotFoundException -> 0x00a7, JSONException -> 0x00a4, NoSuchAlgorithmException -> 0x009c }
        r5 = "Using appauth ";
        r4.append(r5);	 Catch:{ NameNotFoundException -> 0x00a7, NameNotFoundException -> 0x00a7, JSONException -> 0x00a4, NoSuchAlgorithmException -> 0x009c }
        r4.append(r8);	 Catch:{ NameNotFoundException -> 0x00a7, NameNotFoundException -> 0x00a7, JSONException -> 0x00a4, NoSuchAlgorithmException -> 0x009c }
        r4 = r4.toString();	 Catch:{ NameNotFoundException -> 0x00a7, NameNotFoundException -> 0x00a7, JSONException -> 0x00a4, NoSuchAlgorithmException -> 0x009c }
        android.util.Log.d(r2, r4);	 Catch:{ NameNotFoundException -> 0x00a7, NameNotFoundException -> 0x00a7, JSONException -> 0x00a4, NoSuchAlgorithmException -> 0x009c }
        r2 = new saarland.cispa.trust.chipper.SignUpActivity$a;	 Catch:{ NameNotFoundException -> 0x00a7, NameNotFoundException -> 0x00a7, JSONException -> 0x00a4, NoSuchAlgorithmException -> 0x009c }
        r9 = 1;
        r4 = r2;
        r5 = r10;
        r4.<init>(r6, r7, r8, r9);	 Catch:{ NameNotFoundException -> 0x00a7, NameNotFoundException -> 0x00a7, JSONException -> 0x00a4, NoSuchAlgorithmException -> 0x009c }
        r10.k = r2;	 Catch:{ NameNotFoundException -> 0x00a7, NameNotFoundException -> 0x00a7, JSONException -> 0x00a4, NoSuchAlgorithmException -> 0x009c }
        r2 = r10.k;	 Catch:{ NameNotFoundException -> 0x00a7, NameNotFoundException -> 0x00a7, JSONException -> 0x00a4, NoSuchAlgorithmException -> 0x009c }
        r4 = new java.lang.Void[r0];	 Catch:{ NameNotFoundException -> 0x00a7, NameNotFoundException -> 0x00a7, JSONException -> 0x00a4, NoSuchAlgorithmException -> 0x009c }
        r3 = (java.lang.Void) r3;	 Catch:{ NameNotFoundException -> 0x00a7, NameNotFoundException -> 0x00a7, JSONException -> 0x00a4, NoSuchAlgorithmException -> 0x009c }
        r4[r1] = r3;	 Catch:{ NameNotFoundException -> 0x00a7, NameNotFoundException -> 0x00a7, JSONException -> 0x00a4, NoSuchAlgorithmException -> 0x009c }
        r2.execute(r4);	 Catch:{ NameNotFoundException -> 0x00a7, NameNotFoundException -> 0x00a7, JSONException -> 0x00a4, NoSuchAlgorithmException -> 0x009c }
        return;
    L_0x009c:
        r1 = move-exception;
        r2 = "Chipper.SignUpActivity";
        r3 = "Error making request";
        android.util.Log.e(r2, r3, r1);
    L_0x00a4:
        r1 = "Could not create request";
        goto L_0x00a9;
    L_0x00a7:
        r1 = "Could not get package signature";
    L_0x00a9:
        r10 = android.widget.Toast.makeText(r10, r1, r0);
        r10.show();
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: saarland.cispa.trust.chipper.SignUpActivity.k():void");
    }

    /* JADX WARNING: Removed duplicated region for block: B:23:0x00da A:{ExcHandler: android.content.pm.PackageManager.NameNotFoundException (r0_32 'e' java.lang.Throwable), Splitter: B:14:0x005e} */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x00cf A:{ExcHandler: org.json.JSONException (r0_30 'e' java.lang.Throwable), Splitter: B:14:0x005e} */
    /* JADX WARNING: Missing block: B:21:0x00cf, code:
            r0 = move-exception;
     */
    /* JADX WARNING: Missing block: B:22:0x00d0, code:
            android.util.Log.e("Chipper.SignUpActivity", "Error making request", r0);
            r0 = "Could not create request";
     */
    /* JADX WARNING: Missing block: B:23:0x00da, code:
            r0 = move-exception;
     */
    /* JADX WARNING: Missing block: B:24:0x00db, code:
            android.util.Log.e("Chipper.SignUpActivity", "Error making request", r0);
            r0 = "Could not get package signature";
     */
    /* JADX WARNING: Missing block: B:25:0x00e4, code:
            android.widget.Toast.makeText(r10, r0, 1).show();
            a(false);
     */
    /* JADX WARNING: Missing block: B:26:0x00ee, code:
            return;
     */
    private void l() {
        /*
        r10 = this;
        r0 = r10.k;
        if (r0 == 0) goto L_0x0005;
    L_0x0004:
        return;
    L_0x0005:
        r0 = r10.l;
        r1 = 0;
        r0.setError(r1);
        r0 = r10.m;
        r0.setError(r1);
        r0 = r10.l;
        r0 = r0.getText();
        r4 = r0.toString();
        r0 = r10.m;
        r0 = r0.getText();
        r5 = r0.toString();
        r0 = android.text.TextUtils.isEmpty(r5);
        r2 = 2131623985; // 0x7f0e0031 float:1.8875137E38 double:1.053162181E-314;
        r8 = 0;
        r9 = 1;
        if (r0 == 0) goto L_0x003d;
    L_0x002f:
        r0 = r10.m;
        r3 = r10.getString(r2);
        r0.setError(r3);
        r0 = r10.m;
        r3 = r0;
        r0 = r9;
        goto L_0x003f;
    L_0x003d:
        r3 = r1;
        r0 = r8;
    L_0x003f:
        r6 = android.text.TextUtils.isEmpty(r4);
        if (r6 == 0) goto L_0x0051;
    L_0x0045:
        r0 = r10.l;
        r2 = r10.getString(r2);
        r0.setError(r2);
        r3 = r10.l;
        r0 = r9;
    L_0x0051:
        if (r0 == 0) goto L_0x0057;
    L_0x0053:
        r3.requestFocus();
        return;
    L_0x0057:
        r10.a(r9);
        r0 = r10.getPackageManager();
        r2 = r10.getPackageName();	 Catch:{ NameNotFoundException -> 0x00da, NameNotFoundException -> 0x00da, JSONException -> 0x00cf, JSONException -> 0x00cf }
        r3 = 64;
        r0 = r0.getPackageInfo(r2, r3);	 Catch:{ NameNotFoundException -> 0x00da, NameNotFoundException -> 0x00da, JSONException -> 0x00cf, JSONException -> 0x00cf }
        r2 = r0.signatures;	 Catch:{ NameNotFoundException -> 0x00da, NameNotFoundException -> 0x00da, JSONException -> 0x00cf, JSONException -> 0x00cf }
        r2 = r2.length;	 Catch:{ NameNotFoundException -> 0x00da, NameNotFoundException -> 0x00da, JSONException -> 0x00cf, JSONException -> 0x00cf }
        if (r2 >= r9) goto L_0x0077;
    L_0x006d:
        r0 = "Could not get package signature";
        r0 = android.widget.Toast.makeText(r10, r0, r9);	 Catch:{ NameNotFoundException -> 0x00da, NameNotFoundException -> 0x00da, JSONException -> 0x00cf, JSONException -> 0x00cf }
        r0.show();	 Catch:{ NameNotFoundException -> 0x00da, NameNotFoundException -> 0x00da, JSONException -> 0x00cf, JSONException -> 0x00cf }
        return;
    L_0x0077:
        r0 = r0.signatures;	 Catch:{ NameNotFoundException -> 0x00da, NameNotFoundException -> 0x00da, JSONException -> 0x00cf, JSONException -> 0x00cf }
        r0 = r0[r8];	 Catch:{ NameNotFoundException -> 0x00da, NameNotFoundException -> 0x00da, JSONException -> 0x00cf, JSONException -> 0x00cf }
        r2 = "X.509";
        r2 = java.security.cert.CertificateFactory.getInstance(r2);	 Catch:{ NameNotFoundException -> 0x00da, NameNotFoundException -> 0x00da, JSONException -> 0x00cf, JSONException -> 0x00cf }
        r3 = new java.io.ByteArrayInputStream;	 Catch:{ NameNotFoundException -> 0x00da, NameNotFoundException -> 0x00da, JSONException -> 0x00cf, JSONException -> 0x00cf }
        r0 = r0.toByteArray();	 Catch:{ NameNotFoundException -> 0x00da, NameNotFoundException -> 0x00da, JSONException -> 0x00cf, JSONException -> 0x00cf }
        r3.<init>(r0);	 Catch:{ NameNotFoundException -> 0x00da, NameNotFoundException -> 0x00da, JSONException -> 0x00cf, JSONException -> 0x00cf }
        r0 = r2.generateCertificate(r3);	 Catch:{ NameNotFoundException -> 0x00da, NameNotFoundException -> 0x00da, JSONException -> 0x00cf, JSONException -> 0x00cf }
        r0 = (java.security.cert.X509Certificate) r0;	 Catch:{ NameNotFoundException -> 0x00da, NameNotFoundException -> 0x00da, JSONException -> 0x00cf, JSONException -> 0x00cf }
        r2 = "SHA-1";
        r2 = java.security.MessageDigest.getInstance(r2);	 Catch:{ NameNotFoundException -> 0x00da, NameNotFoundException -> 0x00da, JSONException -> 0x00cf, JSONException -> 0x00cf }
        r0 = r0.getSignature();	 Catch:{ NameNotFoundException -> 0x00da, NameNotFoundException -> 0x00da, JSONException -> 0x00cf, JSONException -> 0x00cf }
        r0 = r2.digest(r0);	 Catch:{ NameNotFoundException -> 0x00da, NameNotFoundException -> 0x00da, JSONException -> 0x00cf, JSONException -> 0x00cf }
        r2 = 2;
        r6 = android.util.Base64.encodeToString(r0, r2);	 Catch:{ NameNotFoundException -> 0x00da, NameNotFoundException -> 0x00da, JSONException -> 0x00cf, JSONException -> 0x00cf }
        r0 = "Chipper.SignUpActivity";
        r2 = new java.lang.StringBuilder;	 Catch:{ NameNotFoundException -> 0x00da, NameNotFoundException -> 0x00da, JSONException -> 0x00cf, JSONException -> 0x00cf }
        r2.<init>();	 Catch:{ NameNotFoundException -> 0x00da, NameNotFoundException -> 0x00da, JSONException -> 0x00cf, JSONException -> 0x00cf }
        r3 = "Using appauth ";
        r2.append(r3);	 Catch:{ NameNotFoundException -> 0x00da, NameNotFoundException -> 0x00da, JSONException -> 0x00cf, JSONException -> 0x00cf }
        r2.append(r6);	 Catch:{ NameNotFoundException -> 0x00da, NameNotFoundException -> 0x00da, JSONException -> 0x00cf, JSONException -> 0x00cf }
        r2 = r2.toString();	 Catch:{ NameNotFoundException -> 0x00da, NameNotFoundException -> 0x00da, JSONException -> 0x00cf, JSONException -> 0x00cf }
        android.util.Log.d(r0, r2);	 Catch:{ NameNotFoundException -> 0x00da, NameNotFoundException -> 0x00da, JSONException -> 0x00cf, JSONException -> 0x00cf }
        r0 = new saarland.cispa.trust.chipper.SignUpActivity$a;	 Catch:{ NameNotFoundException -> 0x00da, NameNotFoundException -> 0x00da, JSONException -> 0x00cf, JSONException -> 0x00cf }
        r7 = 0;
        r2 = r0;
        r3 = r10;
        r2.<init>(r4, r5, r6, r7);	 Catch:{ NameNotFoundException -> 0x00da, NameNotFoundException -> 0x00da, JSONException -> 0x00cf, JSONException -> 0x00cf }
        r10.k = r0;	 Catch:{ NameNotFoundException -> 0x00da, NameNotFoundException -> 0x00da, JSONException -> 0x00cf, JSONException -> 0x00cf }
        r0 = r10.k;	 Catch:{ NameNotFoundException -> 0x00da, NameNotFoundException -> 0x00da, JSONException -> 0x00cf, JSONException -> 0x00cf }
        r2 = new java.lang.Void[r9];	 Catch:{ NameNotFoundException -> 0x00da, NameNotFoundException -> 0x00da, JSONException -> 0x00cf, JSONException -> 0x00cf }
        r1 = (java.lang.Void) r1;	 Catch:{ NameNotFoundException -> 0x00da, NameNotFoundException -> 0x00da, JSONException -> 0x00cf, JSONException -> 0x00cf }
        r2[r8] = r1;	 Catch:{ NameNotFoundException -> 0x00da, NameNotFoundException -> 0x00da, JSONException -> 0x00cf, JSONException -> 0x00cf }
        r0.execute(r2);	 Catch:{ NameNotFoundException -> 0x00da, NameNotFoundException -> 0x00da, JSONException -> 0x00cf, JSONException -> 0x00cf }
        return;
    L_0x00cf:
        r0 = move-exception;
        r1 = "Chipper.SignUpActivity";
        r2 = "Error making request";
        android.util.Log.e(r1, r2, r0);
        r0 = "Could not create request";
        goto L_0x00e4;
    L_0x00da:
        r0 = move-exception;
        r1 = "Chipper.SignUpActivity";
        r2 = "Error making request";
        android.util.Log.e(r1, r2, r0);
        r0 = "Could not get package signature";
    L_0x00e4:
        r0 = android.widget.Toast.makeText(r10, r0, r9);
        r0.show();
        r10.a(r8);
        return;
        */
        throw new UnsupportedOperationException("Method not decompiled: saarland.cispa.trust.chipper.SignUpActivity.l():void");
    }

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView((int) R.layout.activity_sign_up);
        this.l = (EditText) findViewById(R.id.username);
        this.m = (EditText) findViewById(R.id.password);
        this.m.setOnEditorActionListener(new OnEditorActionListener() {
            public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
                if (i != R.id.login && i != 0) {
                    return false;
                }
                SignUpActivity.this.l();
                return true;
            }
        });
        this.p = (Button) findViewById(R.id.sign_in_button);
        this.p.setOnClickListener(new OnClickListener() {
            public void onClick(View view) {
                SignUpActivity.this.l();
            }
        });
        this.q = (Button) findViewById(R.id.sign_out_button);
        this.q.setEnabled(false);
        this.q.setOnClickListener(new OnClickListener() {
            public void onClick(View view) {
                SignUpActivity.this.k();
            }
        });
        this.o = findViewById(R.id.login_form);
        this.n = findViewById(R.id.login_progress);
    }

    public void onResume() {
        super.onResume();
        boolean z = false;
        CharSequence string = getSharedPreferences(getString(R.string.preferences_shared), 0).getString(getString(R.string.preference_key_username), null);
        if (string != null) {
            this.l.setText(string);
            this.m.setText("");
            this.l.setEnabled(false);
            this.m.setEnabled(false);
            this.p.setEnabled(false);
            this.q.setEnabled(true);
        }
        NetworkInfo activeNetworkInfo = ((ConnectivityManager) getSystemService("connectivity")).getActiveNetworkInfo();
        if (activeNetworkInfo != null && activeNetworkInfo.isConnectedOrConnecting()) {
            z = true;
        }
        if (!z) {
            Toast.makeText(this, "Device offline, this won't work.", 1).show();
        }
    }
}
