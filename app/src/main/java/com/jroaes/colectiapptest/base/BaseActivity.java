package com.jroaes.colectiapptest.base;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.PorterDuff;
import android.graphics.Typeface;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.annotation.UiThread;
import androidx.appcompat.app.AppCompatActivity;

import com.google.gson.Gson;
import com.jroaes.colectiapptest.Constants;
import com.jroaes.colectiapptest.R;


public class BaseActivity extends AppCompatActivity{

    public Typeface typefaceFA, typefaceSolidFA, typefaceRegularFA;
    protected final String TAG = getClass().getSimpleName();
    private SharedPreferences.Editor editor;
    private ProgressBar progressBar;
    private Context context;
    private RelativeLayout layoutProgressBar;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        editor = getSharedPreferences(Constants.SHARED_PREFERENCE_NAME, MODE_PRIVATE).edit();
        context = this;
        typefaceFA=Typeface.createFromAsset(getAssets(), "fontawesome-webfont.ttf");
        typefaceSolidFA=Typeface.createFromAsset(getAssets(), "fa-solid-900.ttf");
        typefaceRegularFA=Typeface.createFromAsset(getAssets(), "fa-regular-400.ttf");
    }

    public void go(Context packageContext, Class<?> cls){
        Intent intent = new Intent(packageContext, cls);
        startActivity(intent);
    }
    public void setStringSharedPreference(String key, String value){
        editor.putString(key, value);
        editor.apply();
    }
    public String getStringSharedPreferences(String key){
        SharedPreferences prefs = getSharedPreferences(Constants.SHARED_PREFERENCE_NAME, MODE_PRIVATE);
        String restoredText = prefs.getString(key, null);
        if (restoredText != null) {
            return restoredText;
        }else{
            return restoredText;
        }
    }
    public void setBooleanSharedPreference(String key, Boolean value){
        editor.putBoolean(key, value);
        editor.apply();
    }
    public Boolean getBooleanSharedPreferences(String key){
        SharedPreferences prefs = getSharedPreferences(Constants.SHARED_PREFERENCE_NAME, MODE_PRIVATE);
        Boolean restoredText = prefs.getBoolean(key, false);
        if (restoredText != null) {
            return restoredText;
        }else{
            return false;
        }
    }

    public void setObjectSharedPreferences(String key, Object object){
        Gson gson = new Gson();
        String json = gson.toJson(object);
        editor.putString(key, json);
        editor.commit();
    }

    public void removeAllSharedPreferences(){
        SharedPreferences prefs = getSharedPreferences(Constants.SHARED_PREFERENCE_NAME, MODE_PRIVATE);
        editor.clear();
        editor.commit();
    }
    public void showAlertOnlyCancel(final String title, final String message){
        this.runOnUiThread(new Runnable() {
            @Override
            public void run() {
                try {
                    if (!((Activity) context).isFinishing()) {
                        final AlertDialog.Builder alertBuilder = new AlertDialog.Builder(context, AlertDialog.THEME_DEVICE_DEFAULT_LIGHT);
                        alertBuilder.setTitle(title);
                        alertBuilder.setMessage(message);
                        alertBuilder.setCancelable(false);
                        alertBuilder.setPositiveButton("Aceptar", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.dismiss();
                            }
                        });
                        AlertDialog alert = alertBuilder.create();
                        alert.show();
                    }
                }catch (Exception e){
                    e.printStackTrace();
                }
            }
        });
    }

    protected void showLoadingDialog(Context context){
        try{
            if(progressBar == null){
                progressBar = new ProgressBar(context,null,android.R.attr.progressBarStyle);

                layoutProgressBar = new RelativeLayout(context);
                progressBar.setIndeterminate(true);
                progressBar.setVisibility(View.VISIBLE);
                RelativeLayout.LayoutParams params = new RelativeLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,ViewGroup.LayoutParams.MATCH_PARENT);
                params.addRule(RelativeLayout.CENTER_IN_PARENT);
                layoutProgressBar.setLayoutParams(params);
                layoutProgressBar.setBackground(new ColorDrawable(getResources().getColor(R.color.colorGray)));

                RelativeLayout.LayoutParams params2 = new RelativeLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
                params2.addRule(RelativeLayout.CENTER_IN_PARENT);
                progressBar.setLayoutParams(params2);
                progressBar.getIndeterminateDrawable().setColorFilter(getResources().getColor(R.color.colorPrimaryDark), PorterDuff.Mode.SRC_IN);

                layoutProgressBar.addView(progressBar);

                addContentView(layoutProgressBar,layoutProgressBar.getLayoutParams());

            } else{
                layoutProgressBar.setVisibility(View.VISIBLE);
            }

        }catch (Exception e){
            e.printStackTrace();
        }
    }


    protected void hideLoadingDialog(Context context){
        try{
            if (progressBar != null && progressBar.isIndeterminate()) {
                layoutProgressBar.setVisibility(View.GONE);
                progressBar.setIndeterminate(false);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @UiThread
    protected void showErrorMessage(String msg) {
        Toast.makeText(this, msg, Toast.LENGTH_LONG).show();
    }
}
