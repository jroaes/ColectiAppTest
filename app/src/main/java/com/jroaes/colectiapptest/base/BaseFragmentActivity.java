package com.jroaes.colectiapptest.base;

import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.PorterDuff;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.annotation.UiThread;
import androidx.fragment.app.FragmentActivity;

import com.jroaes.colectiapptest.Constants;
import com.jroaes.colectiapptest.R;

public class BaseFragmentActivity extends FragmentActivity {

    SharedPreferences.Editor editor;
    private Context context;
    private ProgressBar progressBar;
    private RelativeLayout layoutProgressBar;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        editor = getSharedPreferences(Constants.SHARED_PREFERENCE_NAME, MODE_PRIVATE).edit();
    }

    public Context getContext() {
        return context;
    }

    protected void showLoadingDialog(Context context) {
        try {
            if (progressBar == null) {
                progressBar = new ProgressBar(context, null, android.R.attr.progressBarStyle);

                layoutProgressBar = new RelativeLayout(context);
                progressBar.setIndeterminate(true);
                progressBar.setVisibility(View.VISIBLE);
                RelativeLayout.LayoutParams params = new RelativeLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
                params.addRule(RelativeLayout.CENTER_IN_PARENT);
                layoutProgressBar.setLayoutParams(params);
                layoutProgressBar.setBackground(new ColorDrawable(getResources().getColor(R.color.colorGray)));

                RelativeLayout.LayoutParams params2 = new RelativeLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
                params2.addRule(RelativeLayout.CENTER_IN_PARENT);
                progressBar.setLayoutParams(params2);
                progressBar.getIndeterminateDrawable().setColorFilter(getResources().getColor(R.color.colorPrimaryDark), PorterDuff.Mode.SRC_IN);

                layoutProgressBar.addView(progressBar);

                addContentView(layoutProgressBar, layoutProgressBar.getLayoutParams());

            } else {
                layoutProgressBar.setVisibility(View.VISIBLE);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    protected void hideLoadingDialog(Context context) {
        try {
            if (progressBar != null && progressBar.isIndeterminate()) {
                layoutProgressBar.setVisibility(View.GONE);
                progressBar.setIndeterminate(false);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @UiThread
    protected void showErrorMessage(String msg) {
        Toast.makeText(this, msg, Toast.LENGTH_LONG).show();
    }
}
