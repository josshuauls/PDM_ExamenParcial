package com.dares03.aplicacinexamenparcial

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController

var numPregunta = 1
var puntuacion = 0
class QuestionFragment : Fragment(R.layout.fragment_question) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val chamo = Bundle()
        val pregunta = view.findViewById<TextView>(R.id.questionText)
        val option1 = view.findViewById<Button>(R.id.option1)
        val option2 = view.findViewById<Button>(R.id.option2)
        val option3 = view.findViewById<Button>(R.id.option3)
        val option4 = view.findViewById<Button>(R.id.option4)
        fun preguntaActual(){
            when(numPregunta){
                1 ->{
                    pregunta.text = getString(R.string.pregunta_1)
                    option1.text = getString(R.string.respuesta_1_1)
                    option2.text = getString(R.string.respuesta_1_2)
                    option3.text = getString(R.string.respuesta_1_3)
                    option4.text = getString(R.string.respuesta_1_4)
                }
                2 ->{
                    pregunta.text = getString(R.string.pregunta_2)
                    option1.text = getString(R.string.respuesta_2_1)
                    option2.text = getString(R.string.respuesta_2_2)
                    option3.text = getString(R.string.respuesta_2_3)
                    option4.text = getString(R.string.respuesta_2_4)
                }
                3 ->{
                    pregunta.text = getString(R.string.pregunta_3)
                    option1.text = getString(R.string.respuesta_3_1)
                    option2.text = getString(R.string.respuesta_3_2)
                    option3.text = getString(R.string.respuesta_3_3)
                    option4.text = getString(R.string.respuesta_3_4)
                }
            }
        }
        preguntaActual()
        option1.setOnClickListener(){
            var respuesta = validarRespuesta(option1.text.toString())
            chamo.putBoolean("rappy",respuesta)
            findNavController().navigate(R.id.action_questionFragment_to_answerFragment,chamo)
        }
        option2.setOnClickListener(){
            var respuesta = validarRespuesta(option2.text.toString())
            chamo.putBoolean("rappy",respuesta)
            findNavController().navigate(R.id.action_questionFragment_to_answerFragment,chamo)
        }
        option3.setOnClickListener(){
            var respuesta = validarRespuesta(option3.text.toString())
            chamo.putBoolean("rappy",respuesta)
            findNavController().navigate(R.id.action_questionFragment_to_answerFragment,chamo)
        }
        option4.setOnClickListener(){
            var respuesta = validarRespuesta(option4.text.toString())
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
        if(validacion == true) {
            Toast.makeText(context, "Correcto", Toast.LENGTH_LONG).show()
        }
        else{
            Toast.makeText(context, "Más Falso que Carlitos", Toast.LENGTH_LONG).show()
        }
        if(validacion == true){
            puntuacion++
        }
        return validacion
    }

}