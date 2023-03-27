package com.admin.backpresstodialogboxshow;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.os.Bundle;
import android.os.Handler;

public class MainActivity extends AppCompatActivity {
    //back press to show dialog box - normal
    private boolean mDoubleBackToExitPressedOnce = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


    }


    //back press to show dialog box - normal
    @Override
    public void onBackPressed() {
        if (mDoubleBackToExitPressedOnce) {
            super.onBackPressed();
            return;
        }

        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setIcon(R.drawable.ic_baseline_warning_amber_24);
        builder.setTitle("Jamil Lab LTD");
        builder.setMessage("Do you want to exit the app?");
        builder.setCancelable(false);
        builder.setPositiveButton("Yes", (dialog, id) -> {
            mDoubleBackToExitPressedOnce = true;
            finish();
        });
        builder.setNegativeButton("No", (dialog, id) -> {
            dialog.cancel();
        });
        builder.setNeutralButton("Cancel", (dialog, id) -> {
            // Do nothing
        });
        AlertDialog dialog = builder.create();
        dialog.show();

        new Handler().postDelayed(() -> mDoubleBackToExitPressedOnce = false, 2000);
    }
}