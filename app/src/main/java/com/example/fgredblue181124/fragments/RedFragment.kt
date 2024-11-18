package com.example.fgredblue181124.fragments

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.commit
import com.example.fgredblue181124.R


class RedFragment(private val currentContainerId: Int): Fragment() {
    private  var listener: FragmentNavigator?=null
    private var contenedor=100
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_red, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        view.findViewById<Button>(R.id.btn_fg_red).setOnClickListener {
            parentFragmentManager.commit {
                setReorderingAllowed(true)
                replace(currentContainerId, BlueFragment(currentContainerId))
            }
        }
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        if(context is FragmentNavigator) listener=context
    }

    override fun onDetach() {
        super.onDetach()
        listener=null
    }

}