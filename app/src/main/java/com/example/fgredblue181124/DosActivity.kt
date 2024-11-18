package com.example.fgredblue181124

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.fragment.app.Fragment
import androidx.fragment.app.commit
import com.example.fgredblue181124.fragments.GreenFragment
import com.example.fgredblue181124.fragments.SilverFragment

class DosActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_dos)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        title="Dos Activity"
        loadFragment(GreenFragment(R.id.fcv_left), R.id.fcv_left)
        loadFragment(SilverFragment(R.id.fcv_right), R.id.fcv_right)
    }
    private fun loadFragment(fragmentToLoad: Fragment, containerId: Int) {
        supportFragmentManager.commit {
            setReorderingAllowed(true)
            replace(containerId, fragmentToLoad)
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_options, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when(item.itemId){
            R.id.item_salir->finishAffinity()
            R.id.item_activity_main->finish()
        }
        return super.onOptionsItemSelected(item)
    }

}