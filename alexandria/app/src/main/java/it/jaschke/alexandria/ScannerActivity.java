package it.jaschke.alexandria;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;

public class ScannerActivity extends ActionBarActivity implements ScannerFragment.ScanCallback {
    @Override
    public void onCreate(Bundle state) {
        super.onCreate(state);
        setContentView(R.layout.activity_scanner);
    }

    @Override
    public void onScanFinished(String scaneCode) {
        Intent returnIntent = new Intent();
        returnIntent.putExtra("result",scaneCode);
        setResult(Activity.RESULT_OK,returnIntent);
        finish();
    }
}