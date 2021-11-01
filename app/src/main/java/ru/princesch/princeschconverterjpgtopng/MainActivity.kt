package ru.princesch.princeschconverterjpgtopng

import android.os.Bundle
import moxy.MvpAppCompatActivity
import ru.princesch.princeschconverterjpgtopng.databinding.ActivityMainBinding
import ru.princesch.princeschconverterjpgtopng.view.MainFragment

class MainActivity : MvpAppCompatActivity() {
    lateinit var viewBinding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(viewBinding.root)

        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.container, MainFragment())
                .commitNow()
        }
    }
}
