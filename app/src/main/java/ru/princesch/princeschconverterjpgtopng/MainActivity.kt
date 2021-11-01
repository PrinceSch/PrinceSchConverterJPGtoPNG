package ru.princesch.princeschconverterjpgtopng

import android.os.Bundle
import moxy.MvpAppCompatActivity
import ru.princesch.princeschconverterjpgtopng.databinding.ActivityMainBinding

class MainActivity : MvpAppCompatActivity() {
    lateinit var viewBinding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(viewBinding.root)
    }
}
