package com.runningcherry.pyrozhock

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.commit
import androidx.fragment.app.replace

class AddEditEventActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_edit_event)
        supportFragmentManager.commit {
            replace<AddEditEventFragment>(R.id.fragmentContainerView)
            setReorderingAllowed(true)
        }
    }
}