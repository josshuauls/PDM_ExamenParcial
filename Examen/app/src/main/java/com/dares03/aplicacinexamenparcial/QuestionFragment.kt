package com.dares03.aplicacinexamenparcial

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import android.widget.Button
import android.widget.Toast
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController

var numPregunta = 1
class QuestionFragment : Fragment(R.layout.fragment_question) {
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val option1 = view.findViewById<Button>(R.id.option1)
        val option2 = view.findViewById<Button>(R.id.option2)
        val option3 = view.findViewById<Button>(R.id.option3)
        val option4 = view.findViewById<Button>(R.id.option4)
        option1.setOnClickListener(){
            var respuesta = validarRespuesta(option1.text.toString())
            var chamo = Bundle()
            chamo.putBoolean("rappy",respuesta)
            findNavController().navigate(R.id.action_questionFragment_to_answerFragment,chamo)
        }
    }
    fun validarRespuesta(entrada:String):Boolean{
        var validacion:Boolean=when(numPregunta){
            1 -> if(entrada == "París") true else false
            2 -> if(entrada == "Miguel de Cervantes") true else false
            3 -> if(entrada == "Océano Pacífico") true else false
            else -> false
        }
        Toast.makeText(context,"AAEA",Toast.LENGTH_LONG).show()
        return validacion
    }
}