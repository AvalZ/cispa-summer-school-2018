package saarland.cispa.trust.chipper;

import android.app.IntentService;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.util.Log;
import java.util.HashSet;
import org.json.JSONArray;
import org.json.JSONObject;
import saarland.cispa.trust.chipper.a.a;
import saarland.cispa.trust.chipper.a.b;

public class SyncService extends IntentService {
    private String[] a = new String[]{"/", "/static/stylesheets/bootstrap.min.css", "/static/images/favicon.ico", "/static/images/chipper_logo.png"};

    public SyncService() {
        super("SyncService");
    }

    public static void a(Context context) {
        Intent intent = new Intent(context, SyncService.class);
        intent.setAction("saarland.cispa.trust.chipper.action.CACHE_PUBLIC_POSTS");
        context.startService(intent);
    }

    public static void a(Context context, String str, String str2) {
        Intent intent = new Intent(context, SyncService.class);
        intent.setAction("saarland.cispa.trust.chipper.action.CACHE_ALL_POSTS");
        intent.putExtra("saarland.cispa.trust.chipper.extra.USERNAME", str);
        intent.putExtra("saarland.cispa.trust.chipper.extra.PASSWORD", str2);
        context.startService(intent);
    }

    public static void a(Context context, String str, String str2, String str3) {
        Intent intent = new Intent(context, SyncService.class);
        intent.setAction("saarland.cispa.trust.chipper.action.CACHE_URL");
        intent.putExtra("saarland.cispa.trust.chipper.extra.EXTRA_CACHE_URL", str);
        intent.putExtra("saarland.cispa.trust.chipper.extra.USERNAME", str2);
        intent.putExtra("saarland.cispa.trust.chipper.extra.PASSWORD", str3);
        context.startService(intent);
    }

    private void a(String str, String str2, String str3) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Syncing ");
        stringBuilder.append(str);
        Log.d("Chipper.SyncService", stringBuilder.toString());
        str2 = new c(getApplicationContext()).b(str, str2, str3);
        StringBuilder stringBuilder2;
        if (str2 == null) {
            stringBuilder2 = new StringBuilder();
            stringBuilder2.append("Could not sync ");
            stringBuilder2.append(str);
            Log.e("Chipper.SyncService", stringBuilder2.toString());
            return;
        }
        ContentValues contentValues = new ContentValues();
        contentValues.put("content", str2);
        contentValues.put("url", str);
        Uri insert = getContentResolver().insert(a.a, contentValues);
        stringBuilder2 = new StringBuilder();
        stringBuilder2.append("Cached ");
        stringBuilder2.append(insert);
        Log.d("Chipper.SyncService", stringBuilder2.toString());
    }

    private void b(String str, String str2, String str3) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Syncing posts from ");
        stringBuilder.append(str);
        Log.d("Chipper.SyncService", stringBuilder.toString());
        StringBuilder stringBuilder2 = new StringBuilder();
        stringBuilder2.append(str);
        stringBuilder2.append("?limit=50");
        str = stringBuilder2.toString();
        str2 = new c(getApplicationContext()).a(str, str2, str3);
        if (str2 == null) {
            StringBuilder stringBuilder3 = new StringBuilder();
            stringBuilder3.append("Could not sync ");
            stringBuilder3.append(str);
            Log.e("Chipper.SyncService", stringBuilder3.toString());
            return;
        }
        Cursor query = getContentResolver().query(b.a, new String[]{"sid"}, null, null, "");
        if (query == null) {
            Log.e("Chipper.SyncService", "Could not query the posts cache");
            return;
        }
        int i;
        HashSet hashSet = new HashSet();
        query.moveToFirst();
        while (true) {
            i = 0;
            if (query.isAfterLast()) {
                break;
            }
            hashSet.add(Integer.valueOf(query.getInt(0)));
            query.moveToNext();
        }
        query.close();
        try {
            JSONArray jSONArray = new JSONObject(str2).getJSONArray("messages");
            while (i < jSONArray.length()) {
                JSONObject jSONObject = jSONArray.getJSONObject(i);
                if (!hashSet.contains(Integer.valueOf(jSONObject.getInt("sid")))) {
                    ContentValues contentValues = new ContentValues();
                    contentValues.put("username", jSONObject.getString("username"));
                    contentValues.put("message", jSONObject.getString("message"));
                    contentValues.put("time", jSONObject.getString("time"));
                    contentValues.put("type", Integer.valueOf(jSONObject.getInt("type")));
                    contentValues.put("link", jSONObject.getString("link"));
                    contentValues.put("sid", Integer.valueOf(jSONObject.getInt("sid")));
                    Uri insert = getContentResolver().insert(b.a, contentValues);
                    StringBuilder stringBuilder4 = new StringBuilder();
                    stringBuilder4.append("Cached ");
                    stringBuilder4.append(insert);
                    Log.d("Chipper.SyncService", stringBuilder4.toString());
                }
                i++;
            }
        } catch (Throwable e) {
            Log.e("Chipper.SyncService", "Could parse response", e);
        }
    }

    protected void onHandleIntent(Intent intent) {
        if (intent != null) {
            String action = intent.getAction();
            if ("saarland.cispa.trust.chipper.action.CACHE_URL".equals(action)) {
                a(intent.getStringExtra("saarland.cispa.trust.chipper.extra.EXTRA_CACHE_URL"), intent.getStringExtra("saarland.cispa.trust.chipper.extra.USERNAME"), intent.getStringExtra("saarland.cispa.trust.chipper.extra.PASSWORD"));
            } else if ("saarland.cispa.trust.chipper.action.CACHE_PUBLIC_POSTS".equals(action)) {
                b("https://androidlecture.de:5000/api/messages", null, null);
            } else if ("saarland.cispa.trust.chipper.action.CACHE_ALL_POSTS".equals(action)) {
                b("https://androidlecture.de:5000/api/messages-all", intent.getStringExtra("saarland.cispa.trust.chipper.extra.USERNAME"), intent.getStringExtra("saarland.cispa.trust.chipper.extra.PASSWORD"));
            }
        }
    }
}
