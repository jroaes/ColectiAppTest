package com.jroaes.colectiapptest.base;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Typeface;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.jroaes.colectiapptest.Constants;


public class BaseActivity extends AppCompatActivity {

    public Typeface typefaceFA, typefaceSolidFA, typefaceRegularFA;
    protected final String TAG = getClass().getSimpleName();
    private SharedPreferences.Editor editor;
    private Context context;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        editor = getSharedPreferences(Constants.SHARED_PREFERENCE_NAME, MODE_PRIVATE).edit();
        context = this;
        typefaceFA = Typeface.createFromAsset(getAssets(), "fontawesome-webfont.ttf");
        typefaceSolidFA = Typeface.createFromAsset(getAssets(), "fa-solid-900.ttf");
        typefaceRegularFA = Typeface.createFromAsset(getAssets(), "fa-regular-400.ttf");
    }

    public void go(Context packageContext, Class<?> cls) {
        Intent intent = new Intent(packageContext, cls);
        startActivity(intent);
    }
}
