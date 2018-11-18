package saarland.cispa.trust.chipper;

import android.app.PendingIntent;
import android.content.ComponentName;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.os.Bundle;
import android.support.v7.app.c;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class PluginActivity extends c {
    TextView k;
    TextView l;
    Button m;
    Button n;
    ImageView o;
    PendingIntent p;

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView((int) R.layout.activity_plugin);
        this.k = (TextView) findViewById(R.id.plugin_text);
        this.l = (TextView) findViewById(R.id.plugin_info);
        this.o = (ImageView) findViewById(R.id.imageView);
        this.m = (Button) findViewById(R.id.plugin_ok_button);
        this.m.setOnClickListener(new OnClickListener() {
            public void onClick(View view) {
                Intent intent = new Intent();
                intent.putExtra("token", PluginActivity.this.p);
                PluginActivity.this.setResult(-1, intent);
                PluginActivity.this.finish();
            }
        });
        this.n = (Button) findViewById(R.id.plugin_cancel_button);
        this.n.setOnClickListener(new OnClickListener() {
            public void onClick(View view) {
                PluginActivity.this.setResult(0);
                PluginActivity.this.finish();
            }
        });
    }

    public void onResume() {
        super.onResume();
        String callingPackage = getCallingPackage();
        if (callingPackage == null) {
            this.m.setEnabled(false);
            this.k.setText("Not called for a result");
            return;
        }
        int i = 1;
        try {
            ApplicationInfo applicationInfo = getPackageManager().getApplicationInfo(callingPackage, 0);
            CharSequence charSequence = getPackageManager().getApplicationLabel(applicationInfo).toString();
            this.o.setImageDrawable(getPackageManager().getApplicationIcon(applicationInfo));
            if (charSequence == null) {
                Toast.makeText(this, "Error getting caller info", 1).show();
                this.m.setEnabled(false);
                return;
            }
            Intent intent = new Intent();
            String packageName = getPackageName();
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(getPackageName());
            stringBuilder.append(".PluginService");
            intent.setComponent(new ComponentName(packageName, stringBuilder.toString()));
            this.l.setText(charSequence);
            StringBuilder stringBuilder2 = new StringBuilder();
            stringBuilder2.append("Called from ");
            stringBuilder2.append(callingPackage);
            Log.d("Chipper.PluginAct", stringBuilder2.toString());
            if (callingPackage.startsWith("saarland.cispa.trust.chipper.pluginapp")) {
                intent.addCategory("saarland.cispa.trust.categroy.INTERNAL_PLUGIN");
                this.k.setText("Do you want to give this Chipper plugin access to your Chipper account?");
                i = 2;
            } else {
                intent.addCategory("saarland.cispa.trust.categroy.EXTERNAL_PLUGIN");
                this.k.setText("Do you want to give this external application limited plugin access to your Chipper messages?");
                this.l.setText(charSequence);
            }
            intent.setClass(this, PluginService.class);
            this.p = PendingIntent.getService(this, i, intent, 134217728);
        } catch (Throwable e) {
            Log.e("Chipper.PluginAct", "Error getting packagemanager", e);
            Toast.makeText(this, "Error getting caller info", 1).show();
            this.m.setEnabled(false);
        }
    }
}
