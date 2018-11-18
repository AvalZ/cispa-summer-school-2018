package saarland.cispa.trust.chipper;

import android.content.ContentResolver;
import android.database.Cursor;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.c;
import android.telephony.TelephonyManager;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.security.MessageDigest;
import java.util.Arrays;
import javax.crypto.Cipher;
import javax.crypto.CipherOutputStream;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import org.json.JSONArray;
import org.json.JSONObject;
import saarland.cispa.trust.chipper.a.b;

public class BackupActivity extends c {
    Button k;

    public class a extends AsyncTask<Void, Void, Boolean> {
        private String b;

        /* renamed from: a */
        protected Boolean doInBackground(Void... voidArr) {
            ContentResolver contentResolver = BackupActivity.this.getContentResolver();
            ContentResolver contentResolver2 = contentResolver;
            Cursor query = contentResolver2.query(b.a, new String[]{"_id"}, null, null, null);
            int count = query.getCount();
            query.close();
            if (count == 0) {
                this.b = "No messages to backup";
                return Boolean.valueOf(false);
            }
            try {
                this.b = "Error in creating backup";
                JSONObject jSONObject = new JSONObject();
                JSONArray jSONArray = new JSONArray();
                Cursor query2 = contentResolver.query(b.a, null, null, null, null);
                if (query2 == null) {
                    Log.d("Chipper.BackupTask", "Null cursor");
                    return Boolean.valueOf(false);
                }
                query2.moveToFirst();
                while (!query2.isAfterLast()) {
                    JSONObject jSONObject2 = new JSONObject();
                    jSONObject2.put("username", query2.getString(query2.getColumnIndex("username")));
                    jSONObject2.put("time", query2.getString(query2.getColumnIndex("time")));
                    jSONObject2.put("type", query2.getInt(query2.getColumnIndex("type")));
                    jSONObject2.put("message", query2.getString(query2.getColumnIndex("message")));
                    CharSequence string = query2.getString(query2.getColumnIndex("link"));
                    if (!(string == null || TextUtils.isEmpty(string))) {
                        jSONObject2.put("link", string);
                    }
                    jSONArray.put(jSONObject2);
                    query2.moveToNext();
                }
                jSONObject.put("messages", jSONArray);
                File file = new File(BackupActivity.this.getExternalFilesDir(null), "chipper.bckup");
                if (!file.exists()) {
                    file.createNewFile();
                }
                OutputStream fileOutputStream = new FileOutputStream(file);
                Cipher instance = Cipher.getInstance("AES/CBC/PKCS5Padding");
                instance.init(1, new SecretKeySpec(Arrays.copyOf(MessageDigest.getInstance("SHA-1").digest(((TelephonyManager) BackupActivity.this.getSystemService("phone")).getDeviceId().getBytes("UTF-8")), 16), "AES"), new IvParameterSpec(new byte[]{(byte) 0, (byte) 0, (byte) 0, (byte) 0, (byte) 0, (byte) 0, (byte) 0, (byte) 0, (byte) 0, (byte) 0, (byte) 0, (byte) 0, (byte) 0, (byte) 0, (byte) 0, (byte) 0}));
                CipherOutputStream cipherOutputStream = new CipherOutputStream(fileOutputStream, instance);
                cipherOutputStream.write(jSONObject.toString().getBytes());
                cipherOutputStream.close();
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("Created backup");
                stringBuilder.append(file.getAbsolutePath());
                this.b = stringBuilder.toString();
                stringBuilder = new StringBuilder();
                stringBuilder.append("Backup in ");
                stringBuilder.append(file.getAbsolutePath());
                Log.d("Chipper.BackupTask", stringBuilder.toString());
                return Boolean.valueOf(true);
            } catch (Throwable e) {
                Log.e("Chipper.BackupTask", "Error backing up", e);
                return Boolean.valueOf(false);
            } catch (Throwable e2) {
                Log.e("Chipper.BackupTask", "Error backing up", e2);
                return Boolean.valueOf(false);
            } catch (Throwable e22) {
                Log.e("Chipper.BackupTask", "Error backing up", e22);
                return Boolean.valueOf(false);
            } catch (Throwable e222) {
                Log.e("Chipper.BackupTask", "Error backing up", e222);
                return Boolean.valueOf(false);
            } catch (Throwable e2222) {
                Log.e("Chipper.BackupTask", "Error backing up", e2222);
                return Boolean.valueOf(false);
            } catch (Throwable e22222) {
                Log.e("Chipper.BackupTask", "Error backing up", e22222);
                return Boolean.valueOf(false);
            }
        }

        /* renamed from: a */
        protected void onPostExecute(Boolean bool) {
            Toast.makeText(BackupActivity.this.getApplicationContext(), this.b, 1).show();
        }
    }

    private void k() {
        if (android.support.v4.a.a.a(getApplicationContext(), "android.permission.READ_PHONE_STATE") == -1) {
            android.support.v4.app.a.a(this, new String[]{"android.permission.READ_PHONE_STATE"}, 23);
            return;
        }
        new a().execute(new Void[]{(Void) null});
    }

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView((int) R.layout.activity_backup);
        this.k = (Button) findViewById(R.id.backup_button);
        this.k.setOnClickListener(new OnClickListener() {
            public void onClick(View view) {
                BackupActivity.this.k();
            }
        });
    }

    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        if (i == 23) {
            if (iArr.length <= 0 || iArr[0] != 0) {
                Toast.makeText(getApplicationContext(), "Reading IMEI required for creating a device-specific backup", 1).show();
            } else {
                k();
            }
        }
    }
}
