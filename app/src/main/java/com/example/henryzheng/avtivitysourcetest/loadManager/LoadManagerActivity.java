package com.example.henryzheng.avtivitysourcetest.loadManager;

import android.app.LoaderManager;
import android.content.CursorLoader;
import android.content.Loader;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import android.widget.TextView;

import com.example.henryzheng.avtivitysourcetest.R;

public class LoadManagerActivity extends AppCompatActivity implements LoaderManager.LoaderCallbacks<Cursor>, TextWatcher {

    private EditText editText = null;

    private ListView listView = null;

    private SimpleCursorAdapter adapter = null;


    private final int CURSOR_LOADER_ID = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_load_manager_actviity);
        //绑定编辑框的文本变化事件
        editText = (EditText)findViewById(R.id.editText);
        editText.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                return false;
            }
        });
        editText.addTextChangedListener(this);

        //获取ListView
        listView = (ListView)findViewById(R.id.listView);

        //创建Adapter
        adapter = new SimpleCursorAdapter(
                this,
                android.R.layout.simple_list_item_2,
                null,
                new String[]{ContactsContract.Contacts.DISPLAY_NAME, ContactsContract.Contacts.CONTACT_STATUS},
                new int[]{android.R.id.text1, android.R.id.text2},
                0);
        listView.setAdapter(adapter);

        //查询全部联系人
        Bundle args = new Bundle();
        args.putString("filter", null);
        LoaderManager lm = getLoaderManager();
        lm.initLoader(CURSOR_LOADER_ID, args, this);
    }

    @Override
    public void beforeTextChanged(CharSequence s, int start, int count, int after) {
    }

    @Override
    public void onTextChanged(CharSequence s, int start, int before, int count) {
    }

    @Override
    public void afterTextChanged(Editable s) {
        String filter = editText.getText().toString();
        Bundle args = new Bundle();
        args.putString("filter", filter);
        LoaderManager lm = getLoaderManager();
        lm.restartLoader(CURSOR_LOADER_ID, args, this);
    }

    @Override
    public Loader<Cursor> onCreateLoader(int id, Bundle args) {

        Uri uri;

        String filter = args != null ? args.getString("filter") : null;

        if(filter != null){
            //根据用户指定的filter过滤显示
            uri = Uri.withAppendedPath(ContactsContract.Contacts.CONTENT_FILTER_URI, Uri.encode(filter));
        }else{
            //显示全部
            uri = ContactsContract.Contacts.CONTENT_URI;
        }

        String[] projection = new String[]{
                ContactsContract.Contacts._ID,
                ContactsContract.Contacts.DISPLAY_NAME,
                ContactsContract.Contacts.CONTACT_STATUS
        };

        String selection = "((" + ContactsContract.Contacts.DISPLAY_NAME + " NOTNULL) AND "+
                "(" + ContactsContract.Contacts.HAS_PHONE_NUMBER + " =1) AND "+
                "(" + ContactsContract.Contacts.DISPLAY_NAME + " != ''))";

        String sortOrder = ContactsContract.Contacts.DISPLAY_NAME + " COLLATE LOCALIZED ASC";

        return new CursorLoader(this, uri, projection, selection, null, sortOrder);
    }

    @Override
    public void onLoadFinished(Loader<Cursor> loader, Cursor data) {
        adapter.swapCursor(data);
    }

    @Override
    public void onLoaderReset(Loader<Cursor> loader) {
        adapter.swapCursor(null);
    }}