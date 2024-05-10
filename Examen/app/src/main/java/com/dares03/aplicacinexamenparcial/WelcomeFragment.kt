package com.dares03.aplicacinexamenparcial

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import android.widget.Button
import androidx.navigation.fragment.findNavController

class WelcomeFragment : Fragment(R.layout.fragment_welcome) {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val carlota = view.findViewById<Button>(R.id.carlota)
        val abelito = Bundle()
        abelito.putString("Soy Abelito","Hola Abelito")
        carlota.setOnClickListener(){
            findNavController().navigate(R.id.action_welcomeFragment_to_questionFragment,abelito)
        }

    }
}