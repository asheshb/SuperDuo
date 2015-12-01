package it.jaschke.alexandria;

import android.media.Ringtone;
import android.media.RingtoneManager;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import me.dm7.barcodescanner.zbar.Result;
import me.dm7.barcodescanner.zbar.ZBarScannerView;

/**
 * Created by ashbey on 11/7/2015.
 */
public class ScannerFragment extends Fragment implements ZBarScannerView.ResultHandler {
    private ZBarScannerView mScannerView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        mScannerView = new ZBarScannerView(getActivity());
        return mScannerView;
    }

    @Override
    public void onResume() {
        super.onResume();
        mScannerView.setResultHandler(this);
        mScannerView.startCamera();
    }

    @Override
    public void handleResult(Result rawResult) {
        String ean = rawResult.getContents();

        if(10 == ean.length() && !ean.startsWith("978")){
            ean="978"+ean;
        }
        if(13 != ean.length()){
            Toast.makeText(getActivity(), getString(R.string.scanner_code_mismatch), Toast.LENGTH_SHORT).show();
            mScannerView.startCamera();

        } else {
            try {
                Uri notification = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION);
                Ringtone r = RingtoneManager.getRingtone(getActivity().getApplicationContext(), notification);
                r.play();
            } catch (Exception e) {}
            ((ScanCallback) getActivity()).onScanFinished(ean);
        }



    }

    @Override
    public void onPause() {
        super.onPause();
        mScannerView.stopCamera();
    }

    /**
     * Interface implemented by ScannerActivity to get scanned book details
     */
    public interface ScanCallback {
        void onScanFinished(String scanCode);
    }
}