package com.example.feature1app

import android.R.attr
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.example.feature1.Feature1Activity
import com.example.mptoast.showToast


class Feature1AppActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_feature1_app)

        val btn = findViewById<Button>(R.id.btnapp)
        btn.setOnClickListener {
            startActivityForResult(Feature1Activity.getInstance(this,2), REQUEST_FEATURE1)
        }

    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        when {
            requestCode === REQUEST_FEATURE1 -> {
                if (resultCode === RESULT_OK) {
                    val result= data?.getStringExtra("result")
                    showToast(result?:"empty")
                }
            }
        }
    }
    companion object{
        const val REQUEST_FEATURE1 = 123
    }
}