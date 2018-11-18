package saarland.cispa.trust.chipper;

import android.content.Context;
import java.io.InputStream;
import java.security.KeyStore;
import java.security.cert.Certificate;
import java.security.cert.CertificateFactory;
import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManagerFactory;
import org.json.JSONObject;

class c {
    private Context a;

    c(Context context) {
        this.a = context;
    }

    private SSLContext a() {
        CertificateFactory instance = CertificateFactory.getInstance("X.509");
        InputStream openRawResource = this.a.getResources().openRawResource(this.a.getResources().getIdentifier("trustedca", "raw", this.a.getPackageName()));
        try {
            Certificate generateCertificate = instance.generateCertificate(openRawResource);
            KeyStore instance2 = KeyStore.getInstance(KeyStore.getDefaultType());
            instance2.load(null, null);
            instance2.setCertificateEntry("trustedca", generateCertificate);
            TrustManagerFactory instance3 = TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm());
            instance3.init(instance2);
            SSLContext instance4 = SSLContext.getInstance("TLS");
            instance4.init(null, instance3.getTrustManagers(), null);
            return instance4;
        } finally {
            openRawResource.close();
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:24:0x00a9 A:{ExcHandler: java.security.cert.CertificateException (r2_18 'e' java.lang.Throwable), Splitter: B:1:0x0001} */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x00a9 A:{ExcHandler: java.security.cert.CertificateException (r2_18 'e' java.lang.Throwable), Splitter: B:1:0x0001} */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x00a9 A:{ExcHandler: java.security.cert.CertificateException (r2_18 'e' java.lang.Throwable), Splitter: B:1:0x0001} */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x00a9 A:{ExcHandler: java.security.cert.CertificateException (r2_18 'e' java.lang.Throwable), Splitter: B:1:0x0001} */
    /* JADX WARNING: Missing block: B:24:0x00a9, code:
            r2 = move-exception;
     */
    /* JADX WARNING: Missing block: B:25:0x00aa, code:
            android.util.Log.e("Chipper.RESTClient", "Error connecting", r2);
     */
    /* JADX WARNING: Missing block: B:26:0x00b1, code:
            return null;
     */
    public java.lang.String a(java.lang.String r3, java.lang.String r4, java.lang.String r5) {
        /*
        r2 = this;
        r0 = 0;
        r2 = r2.a();	 Catch:{ CertificateException -> 0x00a9, CertificateException -> 0x00a9, CertificateException -> 0x00a9, CertificateException -> 0x00a9, CertificateException -> 0x00a9 }
        r1 = new java.net.URL;	 Catch:{ CertificateException -> 0x00a9, CertificateException -> 0x00a9, CertificateException -> 0x00a9, CertificateException -> 0x00a9, CertificateException -> 0x00a9 }
        r1.<init>(r3);	 Catch:{ CertificateException -> 0x00a9, CertificateException -> 0x00a9, CertificateException -> 0x00a9, CertificateException -> 0x00a9, CertificateException -> 0x00a9 }
        r3 = r1.openConnection();	 Catch:{ CertificateException -> 0x00a9, CertificateException -> 0x00a9, CertificateException -> 0x00a9, CertificateException -> 0x00a9, CertificateException -> 0x00a9 }
        r3 = (javax.net.ssl.HttpsURLConnection) r3;	 Catch:{ CertificateException -> 0x00a9, CertificateException -> 0x00a9, CertificateException -> 0x00a9, CertificateException -> 0x00a9, CertificateException -> 0x00a9 }
        r2 = r2.getSocketFactory();	 Catch:{ CertificateException -> 0x00a9, CertificateException -> 0x00a9, CertificateException -> 0x00a9, CertificateException -> 0x00a9, CertificateException -> 0x00a9 }
        r3.setSSLSocketFactory(r2);	 Catch:{ CertificateException -> 0x00a9, CertificateException -> 0x00a9, CertificateException -> 0x00a9, CertificateException -> 0x00a9, CertificateException -> 0x00a9 }
        r2 = "GET";
        r3.setRequestMethod(r2);	 Catch:{ CertificateException -> 0x00a9, CertificateException -> 0x00a9, CertificateException -> 0x00a9, CertificateException -> 0x00a9, CertificateException -> 0x00a9 }
        if (r4 == 0) goto L_0x0061;
    L_0x001e:
        r2 = android.text.TextUtils.isEmpty(r4);	 Catch:{ CertificateException -> 0x00a9, CertificateException -> 0x00a9, CertificateException -> 0x00a9, CertificateException -> 0x00a9, CertificateException -> 0x00a9 }
        if (r2 != 0) goto L_0x0061;
    L_0x0024:
        if (r5 == 0) goto L_0x0061;
    L_0x0026:
        r2 = android.text.TextUtils.isEmpty(r5);	 Catch:{ CertificateException -> 0x00a9, CertificateException -> 0x00a9, CertificateException -> 0x00a9, CertificateException -> 0x00a9, CertificateException -> 0x00a9 }
        if (r2 != 0) goto L_0x0061;
    L_0x002c:
        r2 = new java.lang.StringBuilder;	 Catch:{ CertificateException -> 0x00a9, CertificateException -> 0x00a9, CertificateException -> 0x00a9, CertificateException -> 0x00a9, CertificateException -> 0x00a9 }
        r2.<init>();	 Catch:{ CertificateException -> 0x00a9, CertificateException -> 0x00a9, CertificateException -> 0x00a9, CertificateException -> 0x00a9, CertificateException -> 0x00a9 }
        r2.append(r4);	 Catch:{ CertificateException -> 0x00a9, CertificateException -> 0x00a9, CertificateException -> 0x00a9, CertificateException -> 0x00a9, CertificateException -> 0x00a9 }
        r4 = ":";
        r2.append(r4);	 Catch:{ CertificateException -> 0x00a9, CertificateException -> 0x00a9, CertificateException -> 0x00a9, CertificateException -> 0x00a9, CertificateException -> 0x00a9 }
        r2.append(r5);	 Catch:{ CertificateException -> 0x00a9, CertificateException -> 0x00a9, CertificateException -> 0x00a9, CertificateException -> 0x00a9, CertificateException -> 0x00a9 }
        r2 = r2.toString();	 Catch:{ CertificateException -> 0x00a9, CertificateException -> 0x00a9, CertificateException -> 0x00a9, CertificateException -> 0x00a9, CertificateException -> 0x00a9 }
        r4 = "UTF-8";
        r2 = r2.getBytes(r4);	 Catch:{ CertificateException -> 0x00a9, CertificateException -> 0x00a9, CertificateException -> 0x00a9, CertificateException -> 0x00a9, CertificateException -> 0x00a9 }
        r4 = 2;
        r2 = android.util.Base64.encodeToString(r2, r4);	 Catch:{ CertificateException -> 0x00a9, CertificateException -> 0x00a9, CertificateException -> 0x00a9, CertificateException -> 0x00a9, CertificateException -> 0x00a9 }
        r4 = "Authorization";
        r5 = new java.lang.StringBuilder;	 Catch:{ CertificateException -> 0x00a9, CertificateException -> 0x00a9, CertificateException -> 0x00a9, CertificateException -> 0x00a9, CertificateException -> 0x00a9 }
        r5.<init>();	 Catch:{ CertificateException -> 0x00a9, CertificateException -> 0x00a9, CertificateException -> 0x00a9, CertificateException -> 0x00a9, CertificateException -> 0x00a9 }
        r1 = "Basic ";
        r5.append(r1);	 Catch:{ CertificateException -> 0x00a9, CertificateException -> 0x00a9, CertificateException -> 0x00a9, CertificateException -> 0x00a9, CertificateException -> 0x00a9 }
        r5.append(r2);	 Catch:{ CertificateException -> 0x00a9, CertificateException -> 0x00a9, CertificateException -> 0x00a9, CertificateException -> 0x00a9, CertificateException -> 0x00a9 }
        r2 = r5.toString();	 Catch:{ CertificateException -> 0x00a9, CertificateException -> 0x00a9, CertificateException -> 0x00a9, CertificateException -> 0x00a9, CertificateException -> 0x00a9 }
        r3.setRequestProperty(r4, r2);	 Catch:{ CertificateException -> 0x00a9, CertificateException -> 0x00a9, CertificateException -> 0x00a9, CertificateException -> 0x00a9, CertificateException -> 0x00a9 }
    L_0x0061:
        r3.connect();	 Catch:{ CertificateException -> 0x00a9, CertificateException -> 0x00a9, CertificateException -> 0x00a9, CertificateException -> 0x00a9, CertificateException -> 0x00a9 }
        r2 = r3.getResponseCode();	 Catch:{ CertificateException -> 0x00a9, CertificateException -> 0x00a9, CertificateException -> 0x00a9, CertificateException -> 0x00a9, CertificateException -> 0x00a9 }
        r4 = 404; // 0x194 float:5.66E-43 double:1.996E-321;
        if (r2 != r4) goto L_0x0076;
    L_0x006c:
        r2 = "Chipper.RESTClient";
        r3 = "404: Not found";
        android.util.Log.d(r2, r3);	 Catch:{ CertificateException -> 0x00a9, CertificateException -> 0x00a9, CertificateException -> 0x00a9, CertificateException -> 0x00a9, CertificateException -> 0x00a9 }
        r2 = "{\"error\" : \"not found\"}";
        return r2;
    L_0x0076:
        r4 = 429; // 0x1ad float:6.01E-43 double:2.12E-321;
        if (r2 != r4) goto L_0x0084;
    L_0x007a:
        r2 = "Chipper.RESTClient";
        r3 = "429: Rate limit";
        android.util.Log.d(r2, r3);	 Catch:{ CertificateException -> 0x00a9, CertificateException -> 0x00a9, CertificateException -> 0x00a9, CertificateException -> 0x00a9, CertificateException -> 0x00a9 }
        r2 = "{\"error\" : \"rate limit\"}";
        return r2;
    L_0x0084:
        r2 = new java.lang.StringBuilder;	 Catch:{ CertificateException -> 0x00a9, CertificateException -> 0x00a9, CertificateException -> 0x00a9, CertificateException -> 0x00a9, CertificateException -> 0x00a9 }
        r2.<init>();	 Catch:{ CertificateException -> 0x00a9, CertificateException -> 0x00a9, CertificateException -> 0x00a9, CertificateException -> 0x00a9, CertificateException -> 0x00a9 }
        r3 = r3.getInputStream();	 Catch:{ CertificateException -> 0x00a9, CertificateException -> 0x00a9, CertificateException -> 0x00a9, CertificateException -> 0x00a9, CertificateException -> 0x00a9 }
        r4 = new java.io.BufferedReader;	 Catch:{ CertificateException -> 0x00a9, CertificateException -> 0x00a9, CertificateException -> 0x00a9, CertificateException -> 0x00a9, CertificateException -> 0x00a9 }
        r5 = new java.io.InputStreamReader;	 Catch:{ CertificateException -> 0x00a9, CertificateException -> 0x00a9, CertificateException -> 0x00a9, CertificateException -> 0x00a9, CertificateException -> 0x00a9 }
        r5.<init>(r3);	 Catch:{ CertificateException -> 0x00a9, CertificateException -> 0x00a9, CertificateException -> 0x00a9, CertificateException -> 0x00a9, CertificateException -> 0x00a9 }
        r4.<init>(r5);	 Catch:{ CertificateException -> 0x00a9, CertificateException -> 0x00a9, CertificateException -> 0x00a9, CertificateException -> 0x00a9, CertificateException -> 0x00a9 }
    L_0x0097:
        r3 = r4.readLine();	 Catch:{ CertificateException -> 0x00a9, CertificateException -> 0x00a9, CertificateException -> 0x00a9, CertificateException -> 0x00a9, CertificateException -> 0x00a9 }
        if (r3 == 0) goto L_0x00a1;
    L_0x009d:
        r2.append(r3);	 Catch:{ CertificateException -> 0x00a9, CertificateException -> 0x00a9, CertificateException -> 0x00a9, CertificateException -> 0x00a9, CertificateException -> 0x00a9 }
        goto L_0x0097;
    L_0x00a1:
        r4.close();	 Catch:{ CertificateException -> 0x00a9, CertificateException -> 0x00a9, CertificateException -> 0x00a9, CertificateException -> 0x00a9, CertificateException -> 0x00a9 }
        r2 = r2.toString();	 Catch:{ CertificateException -> 0x00a9, CertificateException -> 0x00a9, CertificateException -> 0x00a9, CertificateException -> 0x00a9, CertificateException -> 0x00a9 }
        return r2;
    L_0x00a9:
        r2 = move-exception;
        r3 = "Chipper.RESTClient";
        r4 = "Error connecting";
        android.util.Log.e(r3, r4, r2);
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: saarland.cispa.trust.chipper.c.a(java.lang.String, java.lang.String, java.lang.String):java.lang.String");
    }

    /* JADX WARNING: Removed duplicated region for block: B:28:0x0106 A:{ExcHandler: java.security.cert.CertificateException (r2_25 'e' java.lang.Throwable), Splitter: B:1:0x0001} */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x0106 A:{ExcHandler: java.security.cert.CertificateException (r2_25 'e' java.lang.Throwable), Splitter: B:1:0x0001} */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x0106 A:{ExcHandler: java.security.cert.CertificateException (r2_25 'e' java.lang.Throwable), Splitter: B:1:0x0001} */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x0106 A:{ExcHandler: java.security.cert.CertificateException (r2_25 'e' java.lang.Throwable), Splitter: B:1:0x0001} */
    /* JADX WARNING: Missing block: B:28:0x0106, code:
            r2 = move-exception;
     */
    /* JADX WARNING: Missing block: B:29:0x0107, code:
            android.util.Log.e("Chipper.RESTClient", "Error connecting", r2);
     */
    /* JADX WARNING: Missing block: B:30:0x010e, code:
            return null;
     */
    public java.lang.String a(java.lang.String r3, java.lang.String r4, java.lang.String r5, org.json.JSONObject r6) {
        /*
        r2 = this;
        r0 = 0;
        r2 = r2.a();	 Catch:{ CertificateException -> 0x0106, CertificateException -> 0x0106, CertificateException -> 0x0106, CertificateException -> 0x0106, CertificateException -> 0x0106 }
        r1 = new java.net.URL;	 Catch:{ CertificateException -> 0x0106, CertificateException -> 0x0106, CertificateException -> 0x0106, CertificateException -> 0x0106, CertificateException -> 0x0106 }
        r1.<init>(r3);	 Catch:{ CertificateException -> 0x0106, CertificateException -> 0x0106, CertificateException -> 0x0106, CertificateException -> 0x0106, CertificateException -> 0x0106 }
        r3 = r1.openConnection();	 Catch:{ CertificateException -> 0x0106, CertificateException -> 0x0106, CertificateException -> 0x0106, CertificateException -> 0x0106, CertificateException -> 0x0106 }
        r3 = (javax.net.ssl.HttpsURLConnection) r3;	 Catch:{ CertificateException -> 0x0106, CertificateException -> 0x0106, CertificateException -> 0x0106, CertificateException -> 0x0106, CertificateException -> 0x0106 }
        r2 = r2.getSocketFactory();	 Catch:{ CertificateException -> 0x0106, CertificateException -> 0x0106, CertificateException -> 0x0106, CertificateException -> 0x0106, CertificateException -> 0x0106 }
        r3.setSSLSocketFactory(r2);	 Catch:{ CertificateException -> 0x0106, CertificateException -> 0x0106, CertificateException -> 0x0106, CertificateException -> 0x0106, CertificateException -> 0x0106 }
        r2 = "Content-Type";
        r1 = "application/json";
        r3.setRequestProperty(r2, r1);	 Catch:{ CertificateException -> 0x0106, CertificateException -> 0x0106, CertificateException -> 0x0106, CertificateException -> 0x0106, CertificateException -> 0x0106 }
        r2 = "Accept";
        r1 = "application/json";
        r3.setRequestProperty(r2, r1);	 Catch:{ CertificateException -> 0x0106, CertificateException -> 0x0106, CertificateException -> 0x0106, CertificateException -> 0x0106, CertificateException -> 0x0106 }
        r2 = "POST";
        r3.setRequestMethod(r2);	 Catch:{ CertificateException -> 0x0106, CertificateException -> 0x0106, CertificateException -> 0x0106, CertificateException -> 0x0106, CertificateException -> 0x0106 }
        r2 = 1;
        r3.setDoOutput(r2);	 Catch:{ CertificateException -> 0x0106, CertificateException -> 0x0106, CertificateException -> 0x0106, CertificateException -> 0x0106, CertificateException -> 0x0106 }
        r3.setDoInput(r2);	 Catch:{ CertificateException -> 0x0106, CertificateException -> 0x0106, CertificateException -> 0x0106, CertificateException -> 0x0106, CertificateException -> 0x0106 }
        if (r4 == 0) goto L_0x0076;
    L_0x0033:
        r2 = android.text.TextUtils.isEmpty(r4);	 Catch:{ CertificateException -> 0x0106, CertificateException -> 0x0106, CertificateException -> 0x0106, CertificateException -> 0x0106, CertificateException -> 0x0106 }
        if (r2 != 0) goto L_0x0076;
    L_0x0039:
        if (r5 == 0) goto L_0x0076;
    L_0x003b:
        r2 = android.text.TextUtils.isEmpty(r5);	 Catch:{ CertificateException -> 0x0106, CertificateException -> 0x0106, CertificateException -> 0x0106, CertificateException -> 0x0106, CertificateException -> 0x0106 }
        if (r2 != 0) goto L_0x0076;
    L_0x0041:
        r2 = new java.lang.StringBuilder;	 Catch:{ CertificateException -> 0x0106, CertificateException -> 0x0106, CertificateException -> 0x0106, CertificateException -> 0x0106, CertificateException -> 0x0106 }
        r2.<init>();	 Catch:{ CertificateException -> 0x0106, CertificateException -> 0x0106, CertificateException -> 0x0106, CertificateException -> 0x0106, CertificateException -> 0x0106 }
        r2.append(r4);	 Catch:{ CertificateException -> 0x0106, CertificateException -> 0x0106, CertificateException -> 0x0106, CertificateException -> 0x0106, CertificateException -> 0x0106 }
        r4 = ":";
        r2.append(r4);	 Catch:{ CertificateException -> 0x0106, CertificateException -> 0x0106, CertificateException -> 0x0106, CertificateException -> 0x0106, CertificateException -> 0x0106 }
        r2.append(r5);	 Catch:{ CertificateException -> 0x0106, CertificateException -> 0x0106, CertificateException -> 0x0106, CertificateException -> 0x0106, CertificateException -> 0x0106 }
        r2 = r2.toString();	 Catch:{ CertificateException -> 0x0106, CertificateException -> 0x0106, CertificateException -> 0x0106, CertificateException -> 0x0106, CertificateException -> 0x0106 }
        r4 = "UTF-8";
        r2 = r2.getBytes(r4);	 Catch:{ CertificateException -> 0x0106, CertificateException -> 0x0106, CertificateException -> 0x0106, CertificateException -> 0x0106, CertificateException -> 0x0106 }
        r4 = 2;
        r2 = android.util.Base64.encodeToString(r2, r4);	 Catch:{ CertificateException -> 0x0106, CertificateException -> 0x0106, CertificateException -> 0x0106, CertificateException -> 0x0106, CertificateException -> 0x0106 }
        r4 = "Authorization";
        r5 = new java.lang.StringBuilder;	 Catch:{ CertificateException -> 0x0106, CertificateException -> 0x0106, CertificateException -> 0x0106, CertificateException -> 0x0106, CertificateException -> 0x0106 }
        r5.<init>();	 Catch:{ CertificateException -> 0x0106, CertificateException -> 0x0106, CertificateException -> 0x0106, CertificateException -> 0x0106, CertificateException -> 0x0106 }
        r1 = "Basic ";
        r5.append(r1);	 Catch:{ CertificateException -> 0x0106, CertificateException -> 0x0106, CertificateException -> 0x0106, CertificateException -> 0x0106, CertificateException -> 0x0106 }
        r5.append(r2);	 Catch:{ CertificateException -> 0x0106, CertificateException -> 0x0106, CertificateException -> 0x0106, CertificateException -> 0x0106, CertificateException -> 0x0106 }
        r2 = r5.toString();	 Catch:{ CertificateException -> 0x0106, CertificateException -> 0x0106, CertificateException -> 0x0106, CertificateException -> 0x0106, CertificateException -> 0x0106 }
        r3.setRequestProperty(r4, r2);	 Catch:{ CertificateException -> 0x0106, CertificateException -> 0x0106, CertificateException -> 0x0106, CertificateException -> 0x0106, CertificateException -> 0x0106 }
    L_0x0076:
        r3.connect();	 Catch:{ CertificateException -> 0x0106, CertificateException -> 0x0106, CertificateException -> 0x0106, CertificateException -> 0x0106, CertificateException -> 0x0106 }
        r2 = new java.io.OutputStreamWriter;	 Catch:{ CertificateException -> 0x0106, CertificateException -> 0x0106, CertificateException -> 0x0106, CertificateException -> 0x0106, CertificateException -> 0x0106 }
        r4 = r3.getOutputStream();	 Catch:{ CertificateException -> 0x0106, CertificateException -> 0x0106, CertificateException -> 0x0106, CertificateException -> 0x0106, CertificateException -> 0x0106 }
        r2.<init>(r4);	 Catch:{ CertificateException -> 0x0106, CertificateException -> 0x0106, CertificateException -> 0x0106, CertificateException -> 0x0106, CertificateException -> 0x0106 }
        r4 = r6.toString();	 Catch:{ CertificateException -> 0x0106, CertificateException -> 0x0106, CertificateException -> 0x0106, CertificateException -> 0x0106, CertificateException -> 0x0106 }
        r2.write(r4);	 Catch:{ CertificateException -> 0x0106, CertificateException -> 0x0106, CertificateException -> 0x0106, CertificateException -> 0x0106, CertificateException -> 0x0106 }
        r2.flush();	 Catch:{ CertificateException -> 0x0106, CertificateException -> 0x0106, CertificateException -> 0x0106, CertificateException -> 0x0106, CertificateException -> 0x0106 }
        r2 = r3.getResponseCode();	 Catch:{ CertificateException -> 0x0106, CertificateException -> 0x0106, CertificateException -> 0x0106, CertificateException -> 0x0106, CertificateException -> 0x0106 }
        r4 = "Chipper.RESTClient";
        r5 = new java.lang.StringBuilder;	 Catch:{ CertificateException -> 0x0106, CertificateException -> 0x0106, CertificateException -> 0x0106, CertificateException -> 0x0106, CertificateException -> 0x0106 }
        r5.<init>();	 Catch:{ CertificateException -> 0x0106, CertificateException -> 0x0106, CertificateException -> 0x0106, CertificateException -> 0x0106, CertificateException -> 0x0106 }
        r6 = "response code ";
        r5.append(r6);	 Catch:{ CertificateException -> 0x0106, CertificateException -> 0x0106, CertificateException -> 0x0106, CertificateException -> 0x0106, CertificateException -> 0x0106 }
        r5.append(r2);	 Catch:{ CertificateException -> 0x0106, CertificateException -> 0x0106, CertificateException -> 0x0106, CertificateException -> 0x0106, CertificateException -> 0x0106 }
        r5 = r5.toString();	 Catch:{ CertificateException -> 0x0106, CertificateException -> 0x0106, CertificateException -> 0x0106, CertificateException -> 0x0106, CertificateException -> 0x0106 }
        android.util.Log.d(r4, r5);	 Catch:{ CertificateException -> 0x0106, CertificateException -> 0x0106, CertificateException -> 0x0106, CertificateException -> 0x0106, CertificateException -> 0x0106 }
        r4 = 404; // 0x194 float:5.66E-43 double:1.996E-321;
        if (r2 != r4) goto L_0x00b4;
    L_0x00aa:
        r2 = "Chipper.RESTClient";
        r3 = "404: Not found";
        android.util.Log.d(r2, r3);	 Catch:{ CertificateException -> 0x0106, CertificateException -> 0x0106, CertificateException -> 0x0106, CertificateException -> 0x0106, CertificateException -> 0x0106 }
        r2 = "{\"error\" : \"not found\"}";
        return r2;
    L_0x00b4:
        r4 = 429; // 0x1ad float:6.01E-43 double:2.12E-321;
        if (r2 != r4) goto L_0x00c2;
    L_0x00b8:
        r2 = "Chipper.RESTClient";
        r3 = "429: Rate limit";
        android.util.Log.d(r2, r3);	 Catch:{ CertificateException -> 0x0106, CertificateException -> 0x0106, CertificateException -> 0x0106, CertificateException -> 0x0106, CertificateException -> 0x0106 }
        r2 = "{\"error\" : \"rate limit\"}";
        return r2;
    L_0x00c2:
        r4 = "Chipper.RESTClient";
        r5 = new java.lang.StringBuilder;	 Catch:{ CertificateException -> 0x0106, CertificateException -> 0x0106, CertificateException -> 0x0106, CertificateException -> 0x0106, CertificateException -> 0x0106 }
        r5.<init>();	 Catch:{ CertificateException -> 0x0106, CertificateException -> 0x0106, CertificateException -> 0x0106, CertificateException -> 0x0106, CertificateException -> 0x0106 }
        r6 = "some response code: ";
        r5.append(r6);	 Catch:{ CertificateException -> 0x0106, CertificateException -> 0x0106, CertificateException -> 0x0106, CertificateException -> 0x0106, CertificateException -> 0x0106 }
        r5.append(r2);	 Catch:{ CertificateException -> 0x0106, CertificateException -> 0x0106, CertificateException -> 0x0106, CertificateException -> 0x0106, CertificateException -> 0x0106 }
        r5 = r5.toString();	 Catch:{ CertificateException -> 0x0106, CertificateException -> 0x0106, CertificateException -> 0x0106, CertificateException -> 0x0106, CertificateException -> 0x0106 }
        android.util.Log.d(r4, r5);	 Catch:{ CertificateException -> 0x0106, CertificateException -> 0x0106, CertificateException -> 0x0106, CertificateException -> 0x0106, CertificateException -> 0x0106 }
        r4 = 400; // 0x190 float:5.6E-43 double:1.976E-321;
        if (r2 < r4) goto L_0x00e1;
    L_0x00dc:
        r2 = r3.getErrorStream();	 Catch:{ CertificateException -> 0x0106, CertificateException -> 0x0106, CertificateException -> 0x0106, CertificateException -> 0x0106, CertificateException -> 0x0106 }
        goto L_0x00e5;
    L_0x00e1:
        r2 = r3.getInputStream();	 Catch:{ CertificateException -> 0x0106, CertificateException -> 0x0106, CertificateException -> 0x0106, CertificateException -> 0x0106, CertificateException -> 0x0106 }
    L_0x00e5:
        r3 = new java.lang.StringBuilder;	 Catch:{ CertificateException -> 0x0106, CertificateException -> 0x0106, CertificateException -> 0x0106, CertificateException -> 0x0106, CertificateException -> 0x0106 }
        r3.<init>();	 Catch:{ CertificateException -> 0x0106, CertificateException -> 0x0106, CertificateException -> 0x0106, CertificateException -> 0x0106, CertificateException -> 0x0106 }
        r4 = new java.io.BufferedReader;	 Catch:{ CertificateException -> 0x0106, CertificateException -> 0x0106, CertificateException -> 0x0106, CertificateException -> 0x0106, CertificateException -> 0x0106 }
        r5 = new java.io.InputStreamReader;	 Catch:{ CertificateException -> 0x0106, CertificateException -> 0x0106, CertificateException -> 0x0106, CertificateException -> 0x0106, CertificateException -> 0x0106 }
        r5.<init>(r2);	 Catch:{ CertificateException -> 0x0106, CertificateException -> 0x0106, CertificateException -> 0x0106, CertificateException -> 0x0106, CertificateException -> 0x0106 }
        r4.<init>(r5);	 Catch:{ CertificateException -> 0x0106, CertificateException -> 0x0106, CertificateException -> 0x0106, CertificateException -> 0x0106, CertificateException -> 0x0106 }
    L_0x00f4:
        r2 = r4.readLine();	 Catch:{ CertificateException -> 0x0106, CertificateException -> 0x0106, CertificateException -> 0x0106, CertificateException -> 0x0106, CertificateException -> 0x0106 }
        if (r2 == 0) goto L_0x00fe;
    L_0x00fa:
        r3.append(r2);	 Catch:{ CertificateException -> 0x0106, CertificateException -> 0x0106, CertificateException -> 0x0106, CertificateException -> 0x0106, CertificateException -> 0x0106 }
        goto L_0x00f4;
    L_0x00fe:
        r4.close();	 Catch:{ CertificateException -> 0x0106, CertificateException -> 0x0106, CertificateException -> 0x0106, CertificateException -> 0x0106, CertificateException -> 0x0106 }
        r2 = r3.toString();	 Catch:{ CertificateException -> 0x0106, CertificateException -> 0x0106, CertificateException -> 0x0106, CertificateException -> 0x0106, CertificateException -> 0x0106 }
        return r2;
    L_0x0106:
        r2 = move-exception;
        r3 = "Chipper.RESTClient";
        r4 = "Error connecting";
        android.util.Log.e(r3, r4, r2);
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: saarland.cispa.trust.chipper.c.a(java.lang.String, java.lang.String, java.lang.String, org.json.JSONObject):java.lang.String");
    }

    public String a(String str, JSONObject jSONObject) {
        return a(str, null, null, jSONObject);
    }

    /* JADX WARNING: Removed duplicated region for block: B:20:0x00a8 A:{ExcHandler: java.security.cert.CertificateException (r2_15 'e' java.lang.Throwable), Splitter: B:1:0x0001} */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x00a8 A:{ExcHandler: java.security.cert.CertificateException (r2_15 'e' java.lang.Throwable), Splitter: B:1:0x0001} */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x00a8 A:{ExcHandler: java.security.cert.CertificateException (r2_15 'e' java.lang.Throwable), Splitter: B:1:0x0001} */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x00a8 A:{ExcHandler: java.security.cert.CertificateException (r2_15 'e' java.lang.Throwable), Splitter: B:1:0x0001} */
    /* JADX WARNING: Missing block: B:20:0x00a8, code:
            r2 = move-exception;
     */
    /* JADX WARNING: Missing block: B:21:0x00a9, code:
            android.util.Log.e("Chipper.RESTClient", "Error connecting", r2);
     */
    /* JADX WARNING: Missing block: B:22:0x00b0, code:
            return null;
     */
    public java.lang.String b(java.lang.String r3, java.lang.String r4, java.lang.String r5) {
        /*
        r2 = this;
        r0 = 0;
        r2 = r2.a();	 Catch:{ CertificateException -> 0x00a8, CertificateException -> 0x00a8, CertificateException -> 0x00a8, CertificateException -> 0x00a8, CertificateException -> 0x00a8 }
        r1 = new java.net.URL;	 Catch:{ CertificateException -> 0x00a8, CertificateException -> 0x00a8, CertificateException -> 0x00a8, CertificateException -> 0x00a8, CertificateException -> 0x00a8 }
        r1.<init>(r3);	 Catch:{ CertificateException -> 0x00a8, CertificateException -> 0x00a8, CertificateException -> 0x00a8, CertificateException -> 0x00a8, CertificateException -> 0x00a8 }
        r3 = r1.openConnection();	 Catch:{ CertificateException -> 0x00a8, CertificateException -> 0x00a8, CertificateException -> 0x00a8, CertificateException -> 0x00a8, CertificateException -> 0x00a8 }
        r3 = (javax.net.ssl.HttpsURLConnection) r3;	 Catch:{ CertificateException -> 0x00a8, CertificateException -> 0x00a8, CertificateException -> 0x00a8, CertificateException -> 0x00a8, CertificateException -> 0x00a8 }
        r2 = r2.getSocketFactory();	 Catch:{ CertificateException -> 0x00a8, CertificateException -> 0x00a8, CertificateException -> 0x00a8, CertificateException -> 0x00a8, CertificateException -> 0x00a8 }
        r3.setSSLSocketFactory(r2);	 Catch:{ CertificateException -> 0x00a8, CertificateException -> 0x00a8, CertificateException -> 0x00a8, CertificateException -> 0x00a8, CertificateException -> 0x00a8 }
        r2 = "GET";
        r3.setRequestMethod(r2);	 Catch:{ CertificateException -> 0x00a8, CertificateException -> 0x00a8, CertificateException -> 0x00a8, CertificateException -> 0x00a8, CertificateException -> 0x00a8 }
        if (r4 == 0) goto L_0x0061;
    L_0x001e:
        r2 = android.text.TextUtils.isEmpty(r4);	 Catch:{ CertificateException -> 0x00a8, CertificateException -> 0x00a8, CertificateException -> 0x00a8, CertificateException -> 0x00a8, CertificateException -> 0x00a8 }
        if (r2 != 0) goto L_0x0061;
    L_0x0024:
        if (r5 == 0) goto L_0x0061;
    L_0x0026:
        r2 = android.text.TextUtils.isEmpty(r5);	 Catch:{ CertificateException -> 0x00a8, CertificateException -> 0x00a8, CertificateException -> 0x00a8, CertificateException -> 0x00a8, CertificateException -> 0x00a8 }
        if (r2 != 0) goto L_0x0061;
    L_0x002c:
        r2 = new java.lang.StringBuilder;	 Catch:{ CertificateException -> 0x00a8, CertificateException -> 0x00a8, CertificateException -> 0x00a8, CertificateException -> 0x00a8, CertificateException -> 0x00a8 }
        r2.<init>();	 Catch:{ CertificateException -> 0x00a8, CertificateException -> 0x00a8, CertificateException -> 0x00a8, CertificateException -> 0x00a8, CertificateException -> 0x00a8 }
        r2.append(r4);	 Catch:{ CertificateException -> 0x00a8, CertificateException -> 0x00a8, CertificateException -> 0x00a8, CertificateException -> 0x00a8, CertificateException -> 0x00a8 }
        r4 = ":";
        r2.append(r4);	 Catch:{ CertificateException -> 0x00a8, CertificateException -> 0x00a8, CertificateException -> 0x00a8, CertificateException -> 0x00a8, CertificateException -> 0x00a8 }
        r2.append(r5);	 Catch:{ CertificateException -> 0x00a8, CertificateException -> 0x00a8, CertificateException -> 0x00a8, CertificateException -> 0x00a8, CertificateException -> 0x00a8 }
        r2 = r2.toString();	 Catch:{ CertificateException -> 0x00a8, CertificateException -> 0x00a8, CertificateException -> 0x00a8, CertificateException -> 0x00a8, CertificateException -> 0x00a8 }
        r4 = "UTF-8";
        r2 = r2.getBytes(r4);	 Catch:{ CertificateException -> 0x00a8, CertificateException -> 0x00a8, CertificateException -> 0x00a8, CertificateException -> 0x00a8, CertificateException -> 0x00a8 }
        r4 = 2;
        r2 = android.util.Base64.encodeToString(r2, r4);	 Catch:{ CertificateException -> 0x00a8, CertificateException -> 0x00a8, CertificateException -> 0x00a8, CertificateException -> 0x00a8, CertificateException -> 0x00a8 }
        r4 = "Authorization";
        r5 = new java.lang.StringBuilder;	 Catch:{ CertificateException -> 0x00a8, CertificateException -> 0x00a8, CertificateException -> 0x00a8, CertificateException -> 0x00a8, CertificateException -> 0x00a8 }
        r5.<init>();	 Catch:{ CertificateException -> 0x00a8, CertificateException -> 0x00a8, CertificateException -> 0x00a8, CertificateException -> 0x00a8, CertificateException -> 0x00a8 }
        r1 = "Basic ";
        r5.append(r1);	 Catch:{ CertificateException -> 0x00a8, CertificateException -> 0x00a8, CertificateException -> 0x00a8, CertificateException -> 0x00a8, CertificateException -> 0x00a8 }
        r5.append(r2);	 Catch:{ CertificateException -> 0x00a8, CertificateException -> 0x00a8, CertificateException -> 0x00a8, CertificateException -> 0x00a8, CertificateException -> 0x00a8 }
        r2 = r5.toString();	 Catch:{ CertificateException -> 0x00a8, CertificateException -> 0x00a8, CertificateException -> 0x00a8, CertificateException -> 0x00a8, CertificateException -> 0x00a8 }
        r3.setRequestProperty(r4, r2);	 Catch:{ CertificateException -> 0x00a8, CertificateException -> 0x00a8, CertificateException -> 0x00a8, CertificateException -> 0x00a8, CertificateException -> 0x00a8 }
    L_0x0061:
        r3.connect();	 Catch:{ CertificateException -> 0x00a8, CertificateException -> 0x00a8, CertificateException -> 0x00a8, CertificateException -> 0x00a8, CertificateException -> 0x00a8 }
        r2 = r3.getResponseCode();	 Catch:{ CertificateException -> 0x00a8, CertificateException -> 0x00a8, CertificateException -> 0x00a8, CertificateException -> 0x00a8, CertificateException -> 0x00a8 }
        r4 = 200; // 0xc8 float:2.8E-43 double:9.9E-322;
        if (r2 == r4) goto L_0x0083;
    L_0x006c:
        r3 = "Chipper.RESTClient";
        r4 = new java.lang.StringBuilder;	 Catch:{ CertificateException -> 0x00a8, CertificateException -> 0x00a8, CertificateException -> 0x00a8, CertificateException -> 0x00a8, CertificateException -> 0x00a8 }
        r4.<init>();	 Catch:{ CertificateException -> 0x00a8, CertificateException -> 0x00a8, CertificateException -> 0x00a8, CertificateException -> 0x00a8, CertificateException -> 0x00a8 }
        r5 = "Error connecting: ";
        r4.append(r5);	 Catch:{ CertificateException -> 0x00a8, CertificateException -> 0x00a8, CertificateException -> 0x00a8, CertificateException -> 0x00a8, CertificateException -> 0x00a8 }
        r4.append(r2);	 Catch:{ CertificateException -> 0x00a8, CertificateException -> 0x00a8, CertificateException -> 0x00a8, CertificateException -> 0x00a8, CertificateException -> 0x00a8 }
        r2 = r4.toString();	 Catch:{ CertificateException -> 0x00a8, CertificateException -> 0x00a8, CertificateException -> 0x00a8, CertificateException -> 0x00a8, CertificateException -> 0x00a8 }
        android.util.Log.e(r3, r2);	 Catch:{ CertificateException -> 0x00a8, CertificateException -> 0x00a8, CertificateException -> 0x00a8, CertificateException -> 0x00a8, CertificateException -> 0x00a8 }
        return r0;
    L_0x0083:
        r2 = new java.lang.StringBuilder;	 Catch:{ CertificateException -> 0x00a8, CertificateException -> 0x00a8, CertificateException -> 0x00a8, CertificateException -> 0x00a8, CertificateException -> 0x00a8 }
        r2.<init>();	 Catch:{ CertificateException -> 0x00a8, CertificateException -> 0x00a8, CertificateException -> 0x00a8, CertificateException -> 0x00a8, CertificateException -> 0x00a8 }
        r3 = r3.getInputStream();	 Catch:{ CertificateException -> 0x00a8, CertificateException -> 0x00a8, CertificateException -> 0x00a8, CertificateException -> 0x00a8, CertificateException -> 0x00a8 }
        r4 = new java.io.BufferedReader;	 Catch:{ CertificateException -> 0x00a8, CertificateException -> 0x00a8, CertificateException -> 0x00a8, CertificateException -> 0x00a8, CertificateException -> 0x00a8 }
        r5 = new java.io.InputStreamReader;	 Catch:{ CertificateException -> 0x00a8, CertificateException -> 0x00a8, CertificateException -> 0x00a8, CertificateException -> 0x00a8, CertificateException -> 0x00a8 }
        r5.<init>(r3);	 Catch:{ CertificateException -> 0x00a8, CertificateException -> 0x00a8, CertificateException -> 0x00a8, CertificateException -> 0x00a8, CertificateException -> 0x00a8 }
        r4.<init>(r5);	 Catch:{ CertificateException -> 0x00a8, CertificateException -> 0x00a8, CertificateException -> 0x00a8, CertificateException -> 0x00a8, CertificateException -> 0x00a8 }
    L_0x0096:
        r3 = r4.readLine();	 Catch:{ CertificateException -> 0x00a8, CertificateException -> 0x00a8, CertificateException -> 0x00a8, CertificateException -> 0x00a8, CertificateException -> 0x00a8 }
        if (r3 == 0) goto L_0x00a0;
    L_0x009c:
        r2.append(r3);	 Catch:{ CertificateException -> 0x00a8, CertificateException -> 0x00a8, CertificateException -> 0x00a8, CertificateException -> 0x00a8, CertificateException -> 0x00a8 }
        goto L_0x0096;
    L_0x00a0:
        r4.close();	 Catch:{ CertificateException -> 0x00a8, CertificateException -> 0x00a8, CertificateException -> 0x00a8, CertificateException -> 0x00a8, CertificateException -> 0x00a8 }
        r2 = r2.toString();	 Catch:{ CertificateException -> 0x00a8, CertificateException -> 0x00a8, CertificateException -> 0x00a8, CertificateException -> 0x00a8, CertificateException -> 0x00a8 }
        return r2;
    L_0x00a8:
        r2 = move-exception;
        r3 = "Chipper.RESTClient";
        r4 = "Error connecting";
        android.util.Log.e(r3, r4, r2);
        return r0;
        */
        throw new UnsupportedOperationException("Method not decompiled: saarland.cispa.trust.chipper.c.b(java.lang.String, java.lang.String, java.lang.String):java.lang.String");
    }
}
