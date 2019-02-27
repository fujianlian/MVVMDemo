package com.example.module_medical

import android.support.v7.app.AppCompatActivity
import android.os.Bundle

class MedicalActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_medical)
        supportFragmentManager.beginTransaction().replace(R.id.frameLayout, MedicalFragment()).commit()
    }
}
