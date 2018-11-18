package saarland.cispa.trust.chipper;

import android.content.ContentProvider;
import android.content.ContentUris;
import android.content.ContentValues;
import android.content.Context;
import android.content.UriMatcher;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.net.Uri;
import android.util.Log;
import java.util.HashMap;
import saarland.cispa.trust.chipper.a.b;

public class CacheProvider extends ContentProvider {
    private static HashMap<String, String> a = new HashMap();
    private static HashMap<String, String> b = new HashMap();
    private static final UriMatcher c = new UriMatcher(-1);
    private a d;

    private static class a extends SQLiteOpenHelper {
        a(Context context) {
            super(context, "cache.db", null, 1);
        }

        public void onCreate(SQLiteDatabase sQLiteDatabase) {
            Log.d("Chipper.CacheProvider", "inner onCreate called");
            sQLiteDatabase.execSQL("CREATE TABLE html (_id INTEGER PRIMARY KEY AUTOINCREMENT,url TEXT,content TEXT,time DATETIME DEFAULT CURRENT_TIMESTAMP);");
            sQLiteDatabase.execSQL("CREATE TABLE posts (_id INTEGER PRIMARY KEY AUTOINCREMENT,username TEXT,message TEXT,type INTEGER,link TEXT,time DATETIME DEFAULT CURRENT_TIMESTAMP,sid INTEGER);");
        }

        public void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
            Log.d("Chipper.CacheProvider", "inner onUpgrade called");
            sQLiteDatabase.execSQL("DROP TABLE IF EXISTS html");
            sQLiteDatabase.execSQL("DROP TABLE IF EXISTS posts");
            onCreate(sQLiteDatabase);
        }
    }

    static {
        a.put("_id", "_id");
        a.put("content", "content");
        a.put("time", "time");
        a.put("url", "url");
        b.put("_id", "_id");
        b.put("username", "username");
        b.put("message", "message");
        b.put("type", "type");
        b.put("link", "link");
        b.put("time", "time");
        b.put("sid", "sid");
        c.addURI("saarland.cispa.trust.chipper.cache", "html", 1);
        c.addURI("saarland.cispa.trust.chipper.cache", "html/#", 2);
        c.addURI("saarland.cispa.trust.chipper.cache", "posts", 3);
        c.addURI("saarland.cispa.trust.chipper.cache", "posts/#", 4);
    }

    /* JADX WARNING: Missing block: B:11:0x0068, code:
            r1.append(" AND (");
            r1.append(r8);
            r1.append(')');
            r8 = r1.toString();
     */
    /* JADX WARNING: Missing block: B:12:0x0078, code:
            r8 = "";
     */
    /* JADX WARNING: Missing block: B:13:0x007a, code:
            r4.append(r8);
            r8 = r0.delete(r3, r4.toString(), r9);
     */
    /* JADX WARNING: Missing block: B:15:0x0088, code:
            r8 = r0.delete(r1, r8, r9);
     */
    /* JADX WARNING: Missing block: B:16:0x008c, code:
            getContext().getContentResolver().notifyChange(r7, null);
     */
    /* JADX WARNING: Missing block: B:17:0x0098, code:
            return r8;
     */
    public int delete(android.net.Uri r7, java.lang.String r8, java.lang.String[] r9) {
        /*
        r6 = this;
        r0 = r6.d;
        r0 = r0.getWritableDatabase();
        r1 = c;
        r1 = r1.match(r7);
        r2 = 41;
        switch(r1) {
            case 1: goto L_0x0086;
            case 2: goto L_0x004a;
            case 3: goto L_0x0047;
            case 4: goto L_0x0028;
            default: goto L_0x0011;
        };
    L_0x0011:
        r6 = new java.lang.IllegalArgumentException;
        r8 = new java.lang.StringBuilder;
        r8.<init>();
        r9 = "Unknown URI ";
        r8.append(r9);
        r8.append(r7);
        r7 = r8.toString();
        r6.<init>(r7);
        throw r6;
    L_0x0028:
        r1 = r7.getLastPathSegment();
        r3 = "posts";
        r4 = new java.lang.StringBuilder;
        r4.<init>();
        r5 = "_id=";
        r4.append(r5);
        r4.append(r1);
        r1 = android.text.TextUtils.isEmpty(r8);
        if (r1 != 0) goto L_0x0078;
    L_0x0041:
        r1 = new java.lang.StringBuilder;
        r1.<init>();
        goto L_0x0068;
    L_0x0047:
        r1 = "posts";
        goto L_0x0088;
    L_0x004a:
        r1 = r7.getLastPathSegment();
        r3 = "html";
        r4 = new java.lang.StringBuilder;
        r4.<init>();
        r5 = "_id=";
        r4.append(r5);
        r4.append(r1);
        r1 = android.text.TextUtils.isEmpty(r8);
        if (r1 != 0) goto L_0x0078;
    L_0x0063:
        r1 = new java.lang.StringBuilder;
        r1.<init>();
    L_0x0068:
        r5 = " AND (";
        r1.append(r5);
        r1.append(r8);
        r1.append(r2);
        r8 = r1.toString();
        goto L_0x007a;
    L_0x0078:
        r8 = "";
    L_0x007a:
        r4.append(r8);
        r8 = r4.toString();
        r8 = r0.delete(r3, r8, r9);
        goto L_0x008c;
    L_0x0086:
        r1 = "html";
    L_0x0088:
        r8 = r0.delete(r1, r8, r9);
    L_0x008c:
        r6 = r6.getContext();
        r6 = r6.getContentResolver();
        r9 = 0;
        r6.notifyChange(r7, r9);
        return r8;
        */
        throw new UnsupportedOperationException("Method not decompiled: saarland.cispa.trust.chipper.CacheProvider.delete(android.net.Uri, java.lang.String, java.lang.String[]):int");
    }

    public String getType(Uri uri) {
        switch (c.match(uri)) {
            case 1:
                return "vnd.android.cursor.dir/vnd.chipper.html";
            case 2:
                return "vnd.android.cursor.item/vnd.chipper.html";
            case 3:
                return "vnd.android.cursor.dir/vnd.chipper.post";
            case 4:
                return "vnd.android.cursor.item/vnd.chipper.post";
            default:
                StringBuilder stringBuilder = new StringBuilder();
                stringBuilder.append("Unknown URI ");
                stringBuilder.append(uri);
                throw new IllegalArgumentException(stringBuilder.toString());
        }
    }

    public Uri insert(Uri uri, ContentValues contentValues) {
        StringBuilder stringBuilder;
        String str;
        Uri uri2;
        int match = c.match(uri);
        if (match != 1) {
            if (match != 3) {
                stringBuilder = new StringBuilder();
                stringBuilder.append("Unknown URI ");
                stringBuilder.append(uri);
                throw new IllegalArgumentException(stringBuilder.toString());
            } else if (!contentValues.containsKey("username")) {
                throw new SQLException("Failed to insert row because username is missing");
            } else if (!contentValues.containsKey("type")) {
                throw new SQLException("Failed to insert row because type is missing");
            } else if (contentValues.getAsInteger("type").intValue() < 0 || contentValues.getAsInteger("type").intValue() > 1) {
                throw new SQLException("Failed to insert row because type is outside allowed range");
            } else if (!contentValues.containsKey("message")) {
                throw new SQLException("Failed to insert row because message is missing");
            } else if (contentValues.containsKey("time")) {
                str = "posts";
                uri2 = b.a;
            } else {
                throw new SQLException("Failed to insert row because time is missing");
            }
        } else if (!contentValues.containsKey("content")) {
            throw new SQLException("Failed to insert row because content is missing");
        } else if (!contentValues.containsKey("url")) {
            throw new SQLException("Failed to insert row because url is missing");
        } else if (contentValues.containsKey("time")) {
            throw new SQLException("Failed to insert row because time is set (must be done by cache)");
        } else {
            str = "html";
            uri2 = saarland.cispa.trust.chipper.a.a.a;
        }
        long insert = this.d.getWritableDatabase().insert(str, str, contentValues);
        if (insert > 0) {
            uri = ContentUris.withAppendedId(uri2, insert);
            getContext().getContentResolver().notifyChange(uri, null);
            return uri;
        }
        stringBuilder = new StringBuilder();
        stringBuilder.append("Failed to insert row into ");
        stringBuilder.append(uri);
        throw new SQLException(stringBuilder.toString());
    }

    public boolean onCreate() {
        Log.d("Chipper.CacheProvider", "main onCreate called");
        this.d = new a(getContext());
        return true;
    }

    /* JADX WARNING: Missing block: B:7:0x004c, code:
            r1.append("_id=");
            r1.append(r9.getLastPathSegment());
            r0.appendWhere(r1.toString());
     */
    /* JADX WARNING: Missing block: B:9:0x0067, code:
            r0.setProjectionMap(r1);
     */
    /* JADX WARNING: Missing block: B:10:0x006a, code:
            r10 = r0.query(r8.d.getReadableDatabase(), r10, r11, r12, null, null, r13);
            r10.setNotificationUri(getContext().getContentResolver(), r9);
     */
    /* JADX WARNING: Missing block: B:11:0x0085, code:
            return r10;
     */
    public android.database.Cursor query(android.net.Uri r9, java.lang.String[] r10, java.lang.String r11, java.lang.String[] r12, java.lang.String r13) {
        /*
        r8 = this;
        r0 = new android.database.sqlite.SQLiteQueryBuilder;
        r0.<init>();
        r1 = c;
        r1 = r1.match(r9);
        switch(r1) {
            case 1: goto L_0x0060;
            case 2: goto L_0x003d;
            case 3: goto L_0x0035;
            case 4: goto L_0x0025;
            default: goto L_0x000e;
        };
    L_0x000e:
        r8 = new java.lang.IllegalArgumentException;
        r10 = new java.lang.StringBuilder;
        r10.<init>();
        r11 = "Unknown URI ";
        r10.append(r11);
        r10.append(r9);
        r9 = r10.toString();
        r8.<init>(r9);
        throw r8;
    L_0x0025:
        r1 = "posts";
        r0.setTables(r1);
        r1 = b;
        r0.setProjectionMap(r1);
        r1 = new java.lang.StringBuilder;
        r1.<init>();
        goto L_0x004c;
    L_0x0035:
        r1 = "posts";
        r0.setTables(r1);
        r1 = b;
        goto L_0x0067;
    L_0x003d:
        r1 = "html";
        r0.setTables(r1);
        r1 = a;
        r0.setProjectionMap(r1);
        r1 = new java.lang.StringBuilder;
        r1.<init>();
    L_0x004c:
        r2 = "_id=";
        r1.append(r2);
        r2 = r9.getLastPathSegment();
        r1.append(r2);
        r1 = r1.toString();
        r0.appendWhere(r1);
        goto L_0x006a;
    L_0x0060:
        r1 = "html";
        r0.setTables(r1);
        r1 = a;
    L_0x0067:
        r0.setProjectionMap(r1);
    L_0x006a:
        r1 = r8.d;
        r1 = r1.getReadableDatabase();
        r5 = 0;
        r6 = 0;
        r2 = r10;
        r3 = r11;
        r4 = r12;
        r7 = r13;
        r10 = r0.query(r1, r2, r3, r4, r5, r6, r7);
        r8 = r8.getContext();
        r8 = r8.getContentResolver();
        r10.setNotificationUri(r8, r9);
        return r10;
        */
        throw new UnsupportedOperationException("Method not decompiled: saarland.cispa.trust.chipper.CacheProvider.query(android.net.Uri, java.lang.String[], java.lang.String, java.lang.String[], java.lang.String):android.database.Cursor");
    }

    /* JADX WARNING: Missing block: B:11:0x0068, code:
            r1.append(" AND (");
            r1.append(r9);
            r1.append(')');
            r9 = r1.toString();
     */
    /* JADX WARNING: Missing block: B:12:0x0078, code:
            r9 = "";
     */
    /* JADX WARNING: Missing block: B:13:0x007a, code:
            r4.append(r9);
            r8 = r0.update(r3, r8, r4.toString(), r10);
     */
    /* JADX WARNING: Missing block: B:15:0x0088, code:
            r8 = r0.update(r1, r8, r9, r10);
     */
    /* JADX WARNING: Missing block: B:16:0x008c, code:
            getContext().getContentResolver().notifyChange(r7, null);
     */
    /* JADX WARNING: Missing block: B:17:0x0098, code:
            return r8;
     */
    public int update(android.net.Uri r7, android.content.ContentValues r8, java.lang.String r9, java.lang.String[] r10) {
        /*
        r6 = this;
        r0 = r6.d;
        r0 = r0.getWritableDatabase();
        r1 = c;
        r1 = r1.match(r7);
        r2 = 41;
        switch(r1) {
            case 1: goto L_0x0086;
            case 2: goto L_0x004a;
            case 3: goto L_0x0047;
            case 4: goto L_0x0028;
            default: goto L_0x0011;
        };
    L_0x0011:
        r6 = new java.lang.IllegalArgumentException;
        r8 = new java.lang.StringBuilder;
        r8.<init>();
        r9 = "Unknown URI ";
        r8.append(r9);
        r8.append(r7);
        r7 = r8.toString();
        r6.<init>(r7);
        throw r6;
    L_0x0028:
        r1 = r7.getLastPathSegment();
        r3 = "posts";
        r4 = new java.lang.StringBuilder;
        r4.<init>();
        r5 = "_id=";
        r4.append(r5);
        r4.append(r1);
        r1 = android.text.TextUtils.isEmpty(r9);
        if (r1 != 0) goto L_0x0078;
    L_0x0041:
        r1 = new java.lang.StringBuilder;
        r1.<init>();
        goto L_0x0068;
    L_0x0047:
        r1 = "posts";
        goto L_0x0088;
    L_0x004a:
        r1 = r7.getLastPathSegment();
        r3 = "html";
        r4 = new java.lang.StringBuilder;
        r4.<init>();
        r5 = "_id=";
        r4.append(r5);
        r4.append(r1);
        r1 = android.text.TextUtils.isEmpty(r9);
        if (r1 != 0) goto L_0x0078;
    L_0x0063:
        r1 = new java.lang.StringBuilder;
        r1.<init>();
    L_0x0068:
        r5 = " AND (";
        r1.append(r5);
        r1.append(r9);
        r1.append(r2);
        r9 = r1.toString();
        goto L_0x007a;
    L_0x0078:
        r9 = "";
    L_0x007a:
        r4.append(r9);
        r9 = r4.toString();
        r8 = r0.update(r3, r8, r9, r10);
        goto L_0x008c;
    L_0x0086:
        r1 = "html";
    L_0x0088:
        r8 = r0.update(r1, r8, r9, r10);
    L_0x008c:
        r6 = r6.getContext();
        r6 = r6.getContentResolver();
        r9 = 0;
        r6.notifyChange(r7, r9);
        return r8;
        */
        throw new UnsupportedOperationException("Method not decompiled: saarland.cispa.trust.chipper.CacheProvider.update(android.net.Uri, android.content.ContentValues, java.lang.String, java.lang.String[]):int");
    }
}
