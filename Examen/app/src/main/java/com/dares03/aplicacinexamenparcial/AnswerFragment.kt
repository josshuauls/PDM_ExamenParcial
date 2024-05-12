package com.dares03.aplicacinexamenparcial

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import android.widget.TextView
import kotlin.properties.Delegates

class AnswerFragment : Fragment(R.layout.fragment_answer) {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        var respuesta by Delegates.notNull<Boolean>()
        arguments?.let {
            respuesta = it.getBoolean("rappy")
        }
        val txtRespuesta = view.findViewById<TextView>(R.id.valor_respuesta)
        if(respuesta) {
            txtRespuesta.text = "Correcto"
        }
        else{
            txtRespuesta.text = "Incorrecto"
        }
    }
}