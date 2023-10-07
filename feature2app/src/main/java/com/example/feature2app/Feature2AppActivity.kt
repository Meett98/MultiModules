package com.example.feature2app

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.example.feature2.Feature2Activity
import com.example.mptoast.showToast


class Feature2AppActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_feature2_app)

        val btn = findViewById<Button>(R.id.btnapp)
        btn.setOnClickListener {
            startActivityForResult(Feature2Activity.getInstance(this,2), REQUEST_FEATURE2)
        }

    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        when {
            requestCode === REQUEST_FEATURE2 -> {
                if (resultCode === RESULT_OK) {
                    val result= data?.getStringExtra("result")
                    showToast(result?:"empty")
                }
            }
        }
    }
    companion object{
        const val REQUEST_FEATURE2 = 1234
    }
}