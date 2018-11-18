package saarland.cispa.trust.chipper;

import android.app.IntentService;
import android.content.ComponentName;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.os.ResultReceiver;
import android.text.TextUtils;
import android.util.Log;
import java.util.HashSet;
import java.util.Set;
import saarland.cispa.trust.chipper.a.b;

public class PluginService extends IntentService {
    private static HashSet<String> a = new HashSet();

    static {
        a.add("saarland.cispa.trust.action.GET_CREDENTIALS");
        a.add("saarland.cispa.trust.action.SEND_MESSAGE");
    }

    public PluginService() {
        super("PluginService");
    }

    private void a(Intent intent) {
        String action = intent.getAction();
        StringBuilder stringBuilder;
        if (action == null) {
            stringBuilder = new StringBuilder();
            stringBuilder.append("Intent without action, ignoring: ");
            stringBuilder.append(intent);
            Log.d("Chipper.PluginService", stringBuilder.toString());
            return;
        }
        Object obj = -1;
        int hashCode = action.hashCode();
        if (hashCode != -1755862171) {
            if (hashCode != 678208069) {
                if (hashCode == 901322590 && action.equals("saarland.cispa.trust.action.SEND_MESSAGE")) {
                    obj = 2;
                }
            } else if (action.equals("saarland.cispa.trust.action.GET_MSGCOUNT")) {
                obj = 1;
            }
        } else if (action.equals("saarland.cispa.trust.action.GET_CREDENTIALS")) {
            obj = null;
        }
        switch (obj) {
            case null:
                d(intent);
                return;
            case 1:
                c(intent);
                return;
            case 2:
                b(intent);
                return;
            default:
                stringBuilder = new StringBuilder();
                stringBuilder.append("Unknown action: ");
                stringBuilder.append(intent);
                Log.d("Chipper.PluginService", stringBuilder.toString());
                return;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:59:0x0170 A:{ExcHandler: android.content.pm.PackageManager.NameNotFoundException (r9_18 'e' java.lang.Throwable), Splitter: B:28:0x0093} */
    /* JADX WARNING: Removed duplicated region for block: B:59:0x0170 A:{ExcHandler: android.content.pm.PackageManager.NameNotFoundException (r9_18 'e' java.lang.Throwable), Splitter: B:28:0x0093} */
    /* JADX WARNING: Removed duplicated region for block: B:59:0x0170 A:{ExcHandler: android.content.pm.PackageManager.NameNotFoundException (r9_18 'e' java.lang.Throwable), Splitter: B:28:0x0093} */
    /* JADX WARNING: Missing block: B:59:0x0170, code:
            r9 = move-exception;
     */
    /* JADX WARNING: Missing block: B:60:0x0171, code:
            android.util.Log.e("Chipper.PluginService", "Error sending message", r9);
     */
    /* JADX WARNING: Missing block: B:61:0x0178, code:
            return;
     */
    private void b(android.content.Intent r10) {
        /*
        r9 = this;
        r0 = "message";
        r0 = r10.getStringExtra(r0);
        r1 = "link";
        r1 = r10.getStringExtra(r1);
        r2 = "type";
        r2 = r10.getStringExtra(r2);
        r2 = java.lang.Integer.parseInt(r2);
        if (r0 == 0) goto L_0x0181;
    L_0x0018:
        r3 = android.text.TextUtils.isEmpty(r0);
        if (r3 == 0) goto L_0x0020;
    L_0x001e:
        goto L_0x0181;
    L_0x0020:
        r3 = -1;
        if (r2 != r3) goto L_0x0042;
    L_0x0023:
        r2 = "type";
        r2 = r10.hasExtra(r2);
        if (r2 == 0) goto L_0x003a;
    L_0x002b:
        r2 = "type";
        r10 = r10.getStringExtra(r2);
        r10 = java.lang.Integer.valueOf(r10);	 Catch:{ NumberFormatException -> 0x003a }
        r2 = r10.intValue();	 Catch:{ NumberFormatException -> 0x003a }
        goto L_0x0042;
    L_0x003a:
        r9 = "Chipper.PluginService";
        r10 = "Illegal value for type, ignoring intent";
    L_0x003e:
        android.util.Log.d(r9, r10);
        return;
    L_0x0042:
        r10 = 2131623994; // 0x7f0e003a float:1.8875155E38 double:1.0531621853E-314;
        r10 = r9.getString(r10);
        r3 = 0;
        r10 = r9.getSharedPreferences(r10, r3);
        r4 = 2131623993; // 0x7f0e0039 float:1.8875153E38 double:1.053162185E-314;
        r4 = r9.getString(r4);
        r5 = 0;
        r4 = r10.getString(r4, r5);
        r6 = 2131623992; // 0x7f0e0038 float:1.8875151E38 double:1.0531621843E-314;
        r6 = r9.getString(r6);
        r10 = r10.getString(r6, r5);
        r5 = "connectivity";
        r5 = r9.getSystemService(r5);
        r5 = (android.net.ConnectivityManager) r5;
        r5 = r5.getActiveNetworkInfo();
        r6 = 1;
        if (r5 == 0) goto L_0x007c;
    L_0x0074:
        r5 = r5.isConnectedOrConnecting();
        if (r5 == 0) goto L_0x007c;
    L_0x007a:
        r5 = r6;
        goto L_0x007d;
    L_0x007c:
        r5 = r3;
    L_0x007d:
        if (r5 == 0) goto L_0x0179;
    L_0x007f:
        if (r4 == 0) goto L_0x0179;
    L_0x0081:
        r5 = android.text.TextUtils.isEmpty(r4);
        if (r5 != 0) goto L_0x0179;
    L_0x0087:
        if (r10 == 0) goto L_0x0179;
    L_0x0089:
        r5 = android.text.TextUtils.isEmpty(r10);
        if (r5 != 0) goto L_0x0179;
    L_0x008f:
        r5 = r9.getPackageManager();
        r7 = r9.getPackageName();	 Catch:{ NameNotFoundException -> 0x0170, NameNotFoundException -> 0x0170, NameNotFoundException -> 0x0170, NameNotFoundException -> 0x0170 }
        r8 = 64;
        r5 = r5.getPackageInfo(r7, r8);	 Catch:{ NameNotFoundException -> 0x0170, NameNotFoundException -> 0x0170, NameNotFoundException -> 0x0170, NameNotFoundException -> 0x0170 }
        r7 = r5.signatures;	 Catch:{ NameNotFoundException -> 0x0170, NameNotFoundException -> 0x0170, NameNotFoundException -> 0x0170, NameNotFoundException -> 0x0170 }
        r7 = r7.length;	 Catch:{ NameNotFoundException -> 0x0170, NameNotFoundException -> 0x0170, NameNotFoundException -> 0x0170, NameNotFoundException -> 0x0170 }
        if (r7 >= r6) goto L_0x00ac;
    L_0x00a2:
        r10 = "Could not get package signature";
        r9 = android.widget.Toast.makeText(r9, r10, r6);	 Catch:{ NameNotFoundException -> 0x0170, NameNotFoundException -> 0x0170, NameNotFoundException -> 0x0170, NameNotFoundException -> 0x0170 }
        r9.show();	 Catch:{ NameNotFoundException -> 0x0170, NameNotFoundException -> 0x0170, NameNotFoundException -> 0x0170, NameNotFoundException -> 0x0170 }
        return;
    L_0x00ac:
        r5 = r5.signatures;	 Catch:{ NameNotFoundException -> 0x0170, NameNotFoundException -> 0x0170, NameNotFoundException -> 0x0170, NameNotFoundException -> 0x0170 }
        r3 = r5[r3];	 Catch:{ NameNotFoundException -> 0x0170, NameNotFoundException -> 0x0170, NameNotFoundException -> 0x0170, NameNotFoundException -> 0x0170 }
        r5 = "X.509";
        r5 = java.security.cert.CertificateFactory.getInstance(r5);	 Catch:{ NameNotFoundException -> 0x0170, NameNotFoundException -> 0x0170, NameNotFoundException -> 0x0170, NameNotFoundException -> 0x0170 }
        r6 = new java.io.ByteArrayInputStream;	 Catch:{ NameNotFoundException -> 0x0170, NameNotFoundException -> 0x0170, NameNotFoundException -> 0x0170, NameNotFoundException -> 0x0170 }
        r3 = r3.toByteArray();	 Catch:{ NameNotFoundException -> 0x0170, NameNotFoundException -> 0x0170, NameNotFoundException -> 0x0170, NameNotFoundException -> 0x0170 }
        r6.<init>(r3);	 Catch:{ NameNotFoundException -> 0x0170, NameNotFoundException -> 0x0170, NameNotFoundException -> 0x0170, NameNotFoundException -> 0x0170 }
        r3 = r5.generateCertificate(r6);	 Catch:{ NameNotFoundException -> 0x0170, NameNotFoundException -> 0x0170, NameNotFoundException -> 0x0170, NameNotFoundException -> 0x0170 }
        r3 = (java.security.cert.X509Certificate) r3;	 Catch:{ NameNotFoundException -> 0x0170, NameNotFoundException -> 0x0170, NameNotFoundException -> 0x0170, NameNotFoundException -> 0x0170 }
        r5 = "SHA-1";
        r5 = java.security.MessageDigest.getInstance(r5);	 Catch:{ NameNotFoundException -> 0x0170, NameNotFoundException -> 0x0170, NameNotFoundException -> 0x0170, NameNotFoundException -> 0x0170 }
        r3 = r3.getSignature();	 Catch:{ NameNotFoundException -> 0x0170, NameNotFoundException -> 0x0170, NameNotFoundException -> 0x0170, NameNotFoundException -> 0x0170 }
        r3 = r5.digest(r3);	 Catch:{ NameNotFoundException -> 0x0170, NameNotFoundException -> 0x0170, NameNotFoundException -> 0x0170, NameNotFoundException -> 0x0170 }
        r5 = 2;
        r3 = android.util.Base64.encodeToString(r3, r5);	 Catch:{ NameNotFoundException -> 0x0170, NameNotFoundException -> 0x0170, NameNotFoundException -> 0x0170, NameNotFoundException -> 0x0170 }
        r5 = "Chipper.PluginService";
        r6 = new java.lang.StringBuilder;	 Catch:{ NameNotFoundException -> 0x0170, NameNotFoundException -> 0x0170, NameNotFoundException -> 0x0170, NameNotFoundException -> 0x0170 }
        r6.<init>();	 Catch:{ NameNotFoundException -> 0x0170, NameNotFoundException -> 0x0170, NameNotFoundException -> 0x0170, NameNotFoundException -> 0x0170 }
        r7 = "Using appauth ";
        r6.append(r7);	 Catch:{ NameNotFoundException -> 0x0170, NameNotFoundException -> 0x0170, NameNotFoundException -> 0x0170, NameNotFoundException -> 0x0170 }
        r6.append(r3);	 Catch:{ NameNotFoundException -> 0x0170, NameNotFoundException -> 0x0170, NameNotFoundException -> 0x0170, NameNotFoundException -> 0x0170 }
        r6 = r6.toString();	 Catch:{ NameNotFoundException -> 0x0170, NameNotFoundException -> 0x0170, NameNotFoundException -> 0x0170, NameNotFoundException -> 0x0170 }
        android.util.Log.d(r5, r6);	 Catch:{ NameNotFoundException -> 0x0170, NameNotFoundException -> 0x0170, NameNotFoundException -> 0x0170, NameNotFoundException -> 0x0170 }
        r5 = new saarland.cispa.trust.chipper.c;	 Catch:{ NameNotFoundException -> 0x0170, NameNotFoundException -> 0x0170, NameNotFoundException -> 0x0170, NameNotFoundException -> 0x0170 }
        r9 = r9.getApplicationContext();	 Catch:{ NameNotFoundException -> 0x0170, NameNotFoundException -> 0x0170, NameNotFoundException -> 0x0170, NameNotFoundException -> 0x0170 }
        r5.<init>(r9);	 Catch:{ NameNotFoundException -> 0x0170, NameNotFoundException -> 0x0170, NameNotFoundException -> 0x0170, NameNotFoundException -> 0x0170 }
        r9 = new org.json.JSONObject;	 Catch:{ NameNotFoundException -> 0x0170, NameNotFoundException -> 0x0170, NameNotFoundException -> 0x0170, NameNotFoundException -> 0x0170 }
        r9.<init>();	 Catch:{ NameNotFoundException -> 0x0170, NameNotFoundException -> 0x0170, NameNotFoundException -> 0x0170, NameNotFoundException -> 0x0170 }
        r6 = "message";
        r9.put(r6, r0);	 Catch:{ NameNotFoundException -> 0x0170, NameNotFoundException -> 0x0170, NameNotFoundException -> 0x0170, NameNotFoundException -> 0x0170 }
        if (r1 == 0) goto L_0x010e;
    L_0x0103:
        r0 = android.text.TextUtils.isEmpty(r1);	 Catch:{ NameNotFoundException -> 0x0170, NameNotFoundException -> 0x0170, NameNotFoundException -> 0x0170, NameNotFoundException -> 0x0170 }
        if (r0 == 0) goto L_0x010e;
    L_0x0109:
        r0 = "link";
        r9.put(r0, r1);	 Catch:{ NameNotFoundException -> 0x0170, NameNotFoundException -> 0x0170, NameNotFoundException -> 0x0170, NameNotFoundException -> 0x0170 }
    L_0x010e:
        r0 = "type";
        r9.put(r0, r2);	 Catch:{ NameNotFoundException -> 0x0170, NameNotFoundException -> 0x0170, NameNotFoundException -> 0x0170, NameNotFoundException -> 0x0170 }
        r0 = "appauth";
        r9.put(r0, r3);	 Catch:{ NameNotFoundException -> 0x0170, NameNotFoundException -> 0x0170, NameNotFoundException -> 0x0170, NameNotFoundException -> 0x0170 }
        r0 = "https://androidlecture.de:5000/api/message/post";
        r9 = r5.a(r0, r4, r10, r9);	 Catch:{ NameNotFoundException -> 0x0170, NameNotFoundException -> 0x0170, NameNotFoundException -> 0x0170, NameNotFoundException -> 0x0170 }
        if (r9 != 0) goto L_0x0128;
    L_0x0120:
        r9 = "Chipper.PluginService";
        r10 = "Failed, response is null";
        android.util.Log.d(r9, r10);	 Catch:{ NameNotFoundException -> 0x0170, NameNotFoundException -> 0x0170, NameNotFoundException -> 0x0170, NameNotFoundException -> 0x0170 }
        return;
    L_0x0128:
        r10 = new org.json.JSONObject;	 Catch:{ JSONException -> 0x0167 }
        r10.<init>(r9);	 Catch:{ JSONException -> 0x0167 }
        r9 = "result";
        r9 = r10.has(r9);	 Catch:{ JSONException -> 0x0167 }
        if (r9 == 0) goto L_0x014b;
    L_0x0135:
        r9 = "result";
        r9 = r10.getString(r9);	 Catch:{ JSONException -> 0x0167 }
        r0 = "successful";
        r9 = r9.equals(r0);	 Catch:{ JSONException -> 0x0167 }
        if (r9 == 0) goto L_0x014b;
    L_0x0143:
        r9 = "Chipper.PluginService";
        r10 = "Message posted";
        android.util.Log.d(r9, r10);	 Catch:{ JSONException -> 0x0167 }
        return;
    L_0x014b:
        r9 = "error";
        r9 = r10.has(r9);	 Catch:{ JSONException -> 0x0167 }
        if (r9 == 0) goto L_0x015f;
    L_0x0153:
        r9 = "Chipper.PluginService";
        r0 = "error";
        r10 = r10.getString(r0);	 Catch:{ JSONException -> 0x0167 }
        android.util.Log.d(r9, r10);	 Catch:{ JSONException -> 0x0167 }
        return;
    L_0x015f:
        r9 = "Chipper.PluginService";
        r10 = "Failed, no 'result' mapping.";
        android.util.Log.d(r9, r10);	 Catch:{ JSONException -> 0x0167 }
        return;
    L_0x0167:
        r9 = move-exception;
        r10 = "Chipper.PluginService";
        r0 = "Error parsing response";
        android.util.Log.e(r10, r0, r9);	 Catch:{ NameNotFoundException -> 0x0170, NameNotFoundException -> 0x0170, NameNotFoundException -> 0x0170, NameNotFoundException -> 0x0170 }
        return;
    L_0x0170:
        r9 = move-exception;
        r10 = "Chipper.PluginService";
        r0 = "Error sending message";
        android.util.Log.e(r10, r0, r9);
        return;
    L_0x0179:
        r9 = "Chipper.PluginService";
        r10 = "Not sending message, either offline or no credentials set";
        android.util.Log.d(r9, r10);
        return;
    L_0x0181:
        r9 = "Chipper.PluginService";
        r10 = "Empty message, ignoring intent";
        goto L_0x003e;
        */
        throw new UnsupportedOperationException("Method not decompiled: saarland.cispa.trust.chipper.PluginService.b(android.content.Intent):void");
    }

    private void c(Intent intent) {
        ResultReceiver resultReceiver = (ResultReceiver) intent.getParcelableExtra("ResultReceiver");
        if (resultReceiver == null) {
            Log.d("Chipper.PluginService", "Caller did not include ResultReceiver, ignoring intent");
        }
        Cursor query = getContentResolver().query(b.a, new String[]{"_id"}, null, null, null);
        int count = query.getCount();
        query.close();
        Bundle bundle = new Bundle();
        bundle.putInt("count", count);
        resultReceiver.send(0, bundle);
    }

    private void d(Intent intent) {
        Object stringExtra = intent.getStringExtra("packageName");
        Object stringExtra2 = intent.getStringExtra("className");
        if (stringExtra == null || TextUtils.isEmpty(stringExtra) || stringExtra2 == null || TextUtils.isEmpty(stringExtra2)) {
            Log.d("Chipper.PluginService", "Not enough info for explicit Intent for reply, ignoring");
            return;
        }
        SharedPreferences sharedPreferences = getSharedPreferences(getString(R.string.preferences_shared), 0);
        String string = sharedPreferences.getString(getString(R.string.preference_key_username), null);
        String string2 = sharedPreferences.getString(getString(R.string.preference_key_password), null);
        Intent intent2 = new Intent();
        intent2.setComponent(new ComponentName(stringExtra, stringExtra2));
        intent2.setAction("saarland.cispa.trust.action.SERVICE_REPLY");
        intent2.putExtra("username", string);
        intent2.putExtra("password", string2);
        sendBroadcast(intent2);
    }

    protected void onHandleIntent(Intent intent) {
        String str;
        String stringBuilder;
        StringBuilder stringBuilder2 = new StringBuilder();
        stringBuilder2.append("onHandleIntent: ");
        stringBuilder2.append(intent);
        Log.d("Chipper.PluginService", stringBuilder2.toString());
        if (intent != null) {
            StringBuilder stringBuilder3;
            String str2;
            Set categories = intent.getCategories();
            if (categories != null) {
                if (!categories.contains("saarland.cispa.trust.categroy.INTERNAL_PLUGIN")) {
                    if (categories.contains("saarland.cispa.trust.categroy.EXTERNAL_PLUGIN")) {
                        if (a.contains(intent.getAction())) {
                            str = "Chipper.PluginService";
                            stringBuilder3 = new StringBuilder();
                            str2 = "Ignoring intent from external plugin for privileged action: ";
                        }
                    } else if (categories.contains("saarland.cispa.trust.category.WEBVIEW_PLUGIN")) {
                        Uri data = intent.getData();
                        if (data != null) {
                            Intent intent2 = new Intent();
                            String queryParameter = data.getQueryParameter("action");
                            if (queryParameter == null) {
                                stringBuilder3 = new StringBuilder();
                                stringBuilder3.append("No action query parameter, ignoring: ");
                                stringBuilder3.append(intent);
                                Log.d("Chipper.PluginService", stringBuilder3.toString());
                                return;
                            }
                            intent2.setAction(queryParameter);
                            for (String queryParameter2 : data.getQueryParameterNames()) {
                                intent2.putExtra(queryParameter2, data.getQueryParameter(queryParameter2));
                            }
                            a(intent2);
                            return;
                        }
                        str = "Chipper.PluginService";
                        stringBuilder3 = new StringBuilder();
                        str2 = "Intent has neither category nor URI, ignoring: ";
                    } else {
                        str = "Chipper.PluginService";
                        stringBuilder3 = new StringBuilder();
                        str2 = "Ignoring intent from unprivileged sender: ";
                    }
                }
                a(intent);
                return;
            }
            str = "Chipper.PluginService";
            stringBuilder3 = new StringBuilder();
            str2 = "No category set, ignoring call: ";
            stringBuilder3.append(str2);
            stringBuilder3.append(intent);
            stringBuilder = stringBuilder3.toString();
        } else {
            str = "Chipper.PluginService";
            stringBuilder = "No intent, ignoring call";
        }
        Log.d(str, stringBuilder);
    }
}
