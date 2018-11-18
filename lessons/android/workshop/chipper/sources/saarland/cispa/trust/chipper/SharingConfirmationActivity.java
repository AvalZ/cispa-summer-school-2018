package saarland.cispa.trust.chipper;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.c;
import android.text.TextUtils;
import android.util.Log;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import java.io.File;
import java.io.FileOutputStream;
import org.json.JSONObject;

public class SharingConfirmationActivity extends c {
    TextView k;
    TextView l;
    TextView m;
    TextView n;
    TextView o;
    Button p;

    private void a(String str) {
        Toast.makeText(this, str, 1).show();
        finish();
    }

    private void c(Intent intent) {
        String str;
        CharSequence stringExtra;
        Object stringExtra2;
        Object stringExtra3;
        if (intent.getIntExtra("sid", -1) == -1) {
            a("No message id given");
        }
        int intExtra = intent.getIntExtra("type", -1);
        if (intExtra == -1) {
            str = "No message type given";
        } else {
            TextView textView;
            CharSequence charSequence;
            TextView textView2;
            StringBuilder stringBuilder;
            if (intExtra == 0) {
                textView = this.n;
                charSequence = "Share public message:";
            } else if (intExtra == 1) {
                textView = this.n;
                charSequence = "Share PRIVATE message:";
            } else {
                str = "Illegal message type";
            }
            textView.setText(charSequence);
            stringExtra = intent.getStringExtra("message");
            if (stringExtra != null || TextUtils.isEmpty(stringExtra)) {
                a("No message content given");
            } else {
                this.k.setText(stringExtra);
            }
            stringExtra2 = intent.getStringExtra("link");
            if (stringExtra2 != null || TextUtils.isEmpty(stringExtra2)) {
                this.l.setText("with no attached link");
            } else {
                textView2 = this.l;
                stringBuilder = new StringBuilder();
                stringBuilder.append("with link ");
                stringBuilder.append(stringExtra2);
                textView2.setText(stringBuilder.toString());
            }
            stringExtra2 = intent.getStringExtra("username");
            if (stringExtra2 != null || TextUtils.isEmpty(stringExtra2)) {
                a("No username given");
            } else {
                textView2 = this.m;
                stringBuilder = new StringBuilder();
                stringBuilder.append("posted by ");
                stringBuilder.append(stringExtra2);
                textView2.setText(stringBuilder.toString());
            }
            stringExtra3 = intent.getStringExtra("time");
            if (stringExtra3 != null || TextUtils.isEmpty(stringExtra3)) {
                a("No posting time specified");
            }
            TextView textView3 = this.o;
            StringBuilder stringBuilder2 = new StringBuilder();
            stringBuilder2.append("on ");
            stringBuilder2.append(stringExtra3);
            textView3.setText(stringBuilder2.toString());
            return;
        }
        a(str);
        stringExtra = intent.getStringExtra("message");
        if (stringExtra != null) {
        }
        a("No message content given");
        stringExtra2 = intent.getStringExtra("link");
        if (stringExtra2 != null) {
        }
        this.l.setText("with no attached link");
        stringExtra2 = intent.getStringExtra("username");
        if (stringExtra2 != null) {
        }
        a("No username given");
        stringExtra3 = intent.getStringExtra("time");
        if (stringExtra3 != null) {
        }
        a("No posting time specified");
    }

    private void d(Intent intent) {
        int intExtra = intent.getIntExtra("sid", -1);
        int intExtra2 = intent.getIntExtra("type", -1);
        String stringExtra = intent.getStringExtra("message");
        CharSequence stringExtra2 = intent.getStringExtra("link");
        String stringExtra3 = intent.getStringExtra("username");
        String stringExtra4 = intent.getStringExtra("time");
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("username", stringExtra3);
        jSONObject.put("time", stringExtra4);
        jSONObject.put("type", intExtra2);
        jSONObject.put("message", stringExtra);
        if (!(stringExtra2 == null || TextUtils.isEmpty(stringExtra2))) {
            jSONObject.put("link", stringExtra2);
        }
        JSONObject jSONObject2 = new JSONObject();
        jSONObject2.put("messages", jSONObject);
        File externalFilesDir = getExternalFilesDir(null);
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(intExtra);
        stringBuilder.append(".json");
        File file = new File(externalFilesDir, stringBuilder.toString());
        FileOutputStream fileOutputStream = new FileOutputStream(file);
        fileOutputStream.write(jSONObject2.toString().getBytes());
        fileOutputStream.close();
        file.setReadable(true, false);
        StringBuilder stringBuilder2 = new StringBuilder();
        stringBuilder2.append("Sharing message in ");
        stringBuilder2.append(file.getAbsolutePath());
        Log.d("Chipper.ConfirmShareAct", stringBuilder2.toString());
        intent = new Intent("android.intent.action.VIEW");
        intent.setType("application/json");
        stringBuilder2 = new StringBuilder();
        stringBuilder2.append("file://");
        stringBuilder2.append(file.getAbsolutePath());
        intent.setData(Uri.parse(stringBuilder2.toString()));
        startActivity(Intent.createChooser(intent, "Share Chipper message"));
    }

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView((int) R.layout.activity_sharing_confirmation);
        this.k = (TextView) findViewById(R.id.confirm_message);
        this.l = (TextView) findViewById(R.id.confirm_link);
        this.m = (TextView) findViewById(R.id.confirm_username);
        this.n = (TextView) findViewById(R.id.confirm_type);
        this.o = (TextView) findViewById(R.id.confirm_time);
        this.p = (Button) findViewById(R.id.confirm_button);
        this.p.setOnClickListener(new OnClickListener() {
            /* JADX WARNING: Removed duplicated region for block: B:3:0x000c A:{ExcHandler: org.json.JSONException (r1_3 'e' java.lang.Throwable), Splitter: B:0:0x0000} */
            /* JADX WARNING: Missing block: B:3:0x000c, code:
            r1 = move-exception;
     */
            /* JADX WARNING: Missing block: B:4:0x000d, code:
            android.util.Log.e("Chipper.ConfirmShareAct", "Error sharing message", r1);
     */
            /* JADX WARNING: Missing block: B:5:0x0014, code:
            return;
     */
            public void onClick(android.view.View r2) {
                /*
                r1 = this;
                r2 = saarland.cispa.trust.chipper.SharingConfirmationActivity.this;	 Catch:{ JSONException -> 0x000c, JSONException -> 0x000c }
                r1 = saarland.cispa.trust.chipper.SharingConfirmationActivity.this;	 Catch:{ JSONException -> 0x000c, JSONException -> 0x000c }
                r1 = r1.getIntent();	 Catch:{ JSONException -> 0x000c, JSONException -> 0x000c }
                r2.d(r1);	 Catch:{ JSONException -> 0x000c, JSONException -> 0x000c }
                return;
            L_0x000c:
                r1 = move-exception;
                r2 = "Chipper.ConfirmShareAct";
                r0 = "Error sharing message";
                android.util.Log.e(r2, r0, r1);
                return;
                */
                throw new UnsupportedOperationException("Method not decompiled: saarland.cispa.trust.chipper.SharingConfirmationActivity.1.onClick(android.view.View):void");
            }
        });
        c(getIntent());
    }
}
