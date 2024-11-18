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
import com.example.fgredblue181124.fragments.BlueFragment
import com.example.fgredblue181124.fragments.FragmentNavigator
import com.example.fgredblue181124.fragments.RedFragment

class MainActivity : AppCompatActivity() , FragmentNavigator{


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        title="MainActivity"
        loadFragment(RedFragment(R.id.fcv_start), R.id.fcv_start)
        loadFragment(BlueFragment(R.id.fcv_end), R.id.fcv_end)

    }


    override fun cambiarFragment(containerId: Int, fragmentToLoad: Fragment) {
        loadFragment(fragmentToLoad, containerId)
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
            R.id.item_salir->finish()
            R.id.item_ir_dos->{
                startActivity(Intent(this, DosActivity::class.java))
            }
        }
        return super.onOptionsItemSelected(item)
    }


}

