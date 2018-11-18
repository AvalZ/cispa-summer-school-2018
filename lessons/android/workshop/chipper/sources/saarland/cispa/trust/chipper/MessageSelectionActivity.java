package saarland.cispa.trust.chipper;

import android.app.ListActivity;
import android.app.LoaderManager.LoaderCallbacks;
import android.content.CursorLoader;
import android.content.Intent;
import android.content.Loader;
import android.database.Cursor;
import android.os.Bundle;
import android.support.v7.widget.an.a;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemLongClickListener;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.SimpleCursorAdapter;
import saarland.cispa.trust.chipper.a.b;

public class MessageSelectionActivity extends ListActivity implements LoaderCallbacks<Cursor> {
    static final String[] b = new String[]{"_id", "message", "username", "time", "type", "link", "sid"};
    static final String c = null;
    SimpleCursorAdapter a;
    ProgressBar d;

    /* renamed from: a */
    public void onLoadFinished(Loader<Cursor> loader, Cursor cursor) {
        this.a.swapCursor(cursor);
        if (cursor.getCount() == 0) {
            this.d.setVisibility(4);
        }
    }

    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.d = new ProgressBar(this);
        this.d.setLayoutParams(new a(-2, -2, 17.0f));
        this.d.setIndeterminate(true);
        getListView().setEmptyView(this.d);
        ((ViewGroup) findViewById(16908290)).addView(this.d);
        this.a = new SimpleCursorAdapter(this, R.layout.container_list_item_view, null, new String[]{"message", "username", "time"}, new int[]{R.id.list_item_message, R.id.list_item_username, R.id.list_item_time}, 0);
        setListAdapter(this.a);
        getLoaderManager().initLoader(0, null, this);
        getListView().setLongClickable(true);
        getListView().setOnItemLongClickListener(new OnItemLongClickListener() {
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long j) {
                Cursor cursor = (Cursor) MessageSelectionActivity.this.getListAdapter().getItem(i);
                cursor.moveToPosition(i);
                String string = cursor.getString(cursor.getColumnIndex("username"));
                String string2 = cursor.getString(cursor.getColumnIndex("message"));
                String string3 = cursor.getString(cursor.getColumnIndex("link"));
                String string4 = cursor.getString(cursor.getColumnIndex("time"));
                int i2 = cursor.getInt(cursor.getColumnIndex("type"));
                int i3 = cursor.getInt(cursor.getColumnIndex("sid"));
                Intent intent = new Intent(MessageSelectionActivity.this.getApplicationContext(), SharingConfirmationActivity.class);
                intent.putExtra("sid", i3);
                intent.putExtra("type", i2);
                intent.putExtra("username", string);
                intent.putExtra("message", string2);
                intent.putExtra("link", string3);
                intent.putExtra("time", string4);
                intent.setFlags(268435456);
                MessageSelectionActivity.this.getApplicationContext().startActivity(intent);
                return true;
            }
        });
    }

    public Loader<Cursor> onCreateLoader(int i, Bundle bundle) {
        if (i != 0) {
            return null;
        }
        return new CursorLoader(this, b.a, b, c, null, "time DESC");
    }

    public void onListItemClick(ListView listView, View view, int i, long j) {
    }

    public void onLoaderReset(Loader<Cursor> loader) {
        this.a.swapCursor(null);
    }
}
