package com.mainchain.mael.android_native_quick_start;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.mainchain.mael.android_native_quick_start.api.BooksAPI;

public class LibraryActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_library);

        // BooksAPI.getBooks();
    }
}
