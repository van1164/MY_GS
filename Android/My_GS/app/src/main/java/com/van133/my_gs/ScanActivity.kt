//package com.van133.my_gs
//
//import android.content.Intent
//import android.os.Bundle
//import androidx.appcompat.app.AppCompatActivity
//import me.dm7.barcodescanner.zxing.ZXingScannerView
//import com.google.zxing.integration.android.IntentResult
//
//class ScanActivity  : AppCompatActivity(), ZXingScannerView.ResultHandler{
////    private var mScannerView: ZXingScannerView? = null
////
////    public override fun onCreate(state: Bundle?) {
////        super.onCreate(state)
////        mScannerView = ZXingScannerView(this)
////        setContentView(mScannerView)
////    }
////
////    public override fun onResume() {
////        super.onResume()
////        mScannerView!!.flash = true
////        mScannerView!!.setAutoFocus(true)
////        mScannerView!!.setResultHandler(this)
////        mScannerView!!.startCamera()
////    }
////
////    public override fun onPause() {
////        super.onPause()
////        mScannerView!!.stopCamera()
////    }
////
////    override fun handleResult(rawResult: Result) {
////        val intent = Intent(this@ScanActivity, InActivity::class.java)
////        intent.putExtra("result_msg", rawResult.text)
////        setResult(RESULT_OK, intent)
////        finish()
////    }
//
//}