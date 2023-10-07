package com.example.multimodule

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import com.example.dateformatter.formatDate
import com.example.feature1.Feature1Activity
import com.example.feature2.Feature2Activity
import com.example.mptoast.showToast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val date = "29/01/2001"


        showToast(date.formatDate("dd/MM/yyyy","DD MMM,yyy"))

        //Toast.makeText(this,date.formatDate("dd/MM/yyyy","DD MMM,yyy"),Toast.LENGTH_SHORT).show()



        val btn_feature1 = findViewById<Button>(R.id.btn_feature1)
        val btn_feature2 = findViewById<Button>(R.id.btn_feature2)



        btn_feature1.setOnClickListener {
            startActivityForResult(Feature1Activity.getInstance(this,2), REQUEST_FEATURE1)
        }
        btn_feature2.setOnClickListener {
            startActivityForResult(Feature2Activity.getInstance(this,2), REQUEST_FEATURE2)
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
            requestCode === REQUEST_FEATURE2 -> {
                if (resultCode === RESULT_OK) {
                    val result= data?.getStringExtra("result")
                    showToast(result?:"empty")
                }
            }
        }
    }
    companion object{
        const val REQUEST_FEATURE1 = 2323
        const val REQUEST_FEATURE2 = 2323
    }
}