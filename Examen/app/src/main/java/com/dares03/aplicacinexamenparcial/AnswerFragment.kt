package com.dares03.aplicacinexamenparcial

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import kotlin.properties.Delegates

class AnswerFragment : Fragment(R.layout.fragment_answer) {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val respuesta_detallada = view.findViewById<TextView>(R.id.respuesta_detallada)
        when(numPregunta){
            1 -> {
                respuesta_detallada.text = getString(R.string.descripcion_1)
            }
            2 -> {
                respuesta_detallada.text = getString(R.string.descripcion_2)
            }
            3 -> {
                respuesta_detallada.text = getString(R.string.descripcion_3)
            }
        }
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

        val continuar = view.findViewById<Button>(R.id.button_continue)
        continuar.setOnClickListener(){
            numPregunta++
            if(numPregunta <= 3) {
                findNavController().navigate(R.id.questionFragment)
            }
            else{
                numPregunta = 1
                Toast.makeText(context,"Tienes $puntuacion respuestas correctas",Toast.LENGTH_LONG).show()
                puntuacion = 0
                findNavController().popBackStack(R.id.welcomeFragment, false)
            }
        }
    }
}