package com.example.fgredblue181124.fragments

import androidx.fragment.app.Fragment

interface FragmentNavigator {
    fun cambiarFragment(containerId: Int, fragmentToLoad: Fragment)
}