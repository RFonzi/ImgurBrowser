package io.github.rfonzi.imgurbrowser

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import androidx.navigation.findNavController

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_launcher)

    }

    override fun onSupportNavigateUp(): Boolean = findNavController(R.id.nav_host).navigateUp()
}
