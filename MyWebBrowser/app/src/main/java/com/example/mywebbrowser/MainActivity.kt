package com.example.mywebbrowser

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.inputmethod.EditorInfo
import android.webkit.WebViewClient
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        webView.apply{
            settings.javaScriptEnabled = true
            webViewClient = WebViewClient()
        }
        webView.loadUrl("http://www.google.com")

        urlEditText.setOnEditorActionListener{_, actionId, _->
            if(actionId == EditorInfo.IME_ACTION_SEARCH){
                webView.loadUrl(urlEditText.text.toString())
                true
            }else{
                false
            }
        }
    }

    override fun onBackPressed() {
        if(webView.canGoBack()){
            webView.goBack()
        }else{
            super.onBackPressed()
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item?.itemId){
            R.id.action_google, R.id.action_home ->{
                webView.loadUrl("http://www.google.com")
                return true
            }
            R.id.action_naver ->{
                webView.loadUrl("http://www.naver.com")
                return true
            }
            R.id.action_daum ->{
                webView.loadUrl("http://www.daum.net")
                return true
            }
            R.id.action_call ->{
                val intent = Intent(Intent.ACTION_DIAL)
                intent.data = Uri.parse("tel:010-xxxx-xxxx")
                if(intent.resolveActivity(packageManager)!=null)
                    startActivity(intent)

                return true
            }
            R.id.action_send_text ->{
                //문자 보내기
                return  true
            }
            R.id.action_email->{
                //이메일 보내기
                return true
            }
        }
        return super.onOptionsItemSelected(item)
    }
}