package com.example.module_photo

import android.os.Bundle
import android.support.v7.app.AppCompatActivity

class PhotoActivity: AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_photo)
        supportFragmentManager.beginTransaction().replace(R.id.frameLayout, PhotoFragment()).commit()
    }
}
