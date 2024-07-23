package com.example.lab2

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.lab2.ui.theme.Lab2Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Lab2Theme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Greeting(
                        name = "Android",
                        modifier = Modifier.padding(innerPadding)
                    )
                }

            }
        }

        // Ejercicio 1
        val numbers = listOf(1.0, 2.0, 3.0, 4.0, 5.0)
        Log.d("Ejercicio1", "El promedio es: ${calcularPromedio(numbers)}")

        // Ejercicio 2
        val numeros = listOf(1, 2, 3, 4, 5, 6, 7, 8, 9, 10)
        val impares = filtrarImpares(numeros)
        Log.d("Ejercicio2", "Números impares: $impares")

        // Ejercicio 3
        val palabra = "anilina"
        Log.d("Ejercicio3", "¿Es palíndromo? ${isPalindrome(palabra)}")

        // Ejercicio 4
        val nombres = listOf("Alicia", "Bruno", "Carlos")
        val saludos = agregarSaludo(nombres)
        saludos.forEach { saludo -> Log.d("Ejercicio4", saludo) }

        // Ejercicio 5
        val suma = performOperation(4, 5) { x, y -> x + y }
        val producto = performOperation(4, 5) { x, y -> x * y }
        Log.d("Ejercicio5", "Suma: $suma")
        Log.d("Ejercicio5", "Producto: $producto")

        // Ejercicio 6
        val personas = listOf(
            Person("Carlos", 21, "Masculino"),
            Person("Alicia", 19, "Femenino"),
            Person("Bruno", 22, "Masculino")
        )

        val estudiantes = personas.mapIndexed { index, person -> mapPersonToStudent(person, "S${index + 1}") }
        estudiantes.forEach { student -> Log.d("Ejercicio6", "El Estudiante ${student.name} tiene ${student.age} años") }
    }

    // Función para calcular promedio
    fun calcularPromedio(numbers: List<Double>): Double {
        val sum = numbers.reduce { acc, num -> acc + num }
        return sum / numbers.size
    }

    // Función para filtrar números impares
    fun filtrarImpares(numbers: List<Int>): List<Int> {
        return numbers.filter { it % 2 != 0 }
    }

    // Función para verificar si es palíndromo
    fun isPalindrome(text: String): Boolean {
        val cleanedText = text.replace("\\s+".toRegex(), "").lowercase()
        return cleanedText == cleanedText.reversed()
    }

    // Función para agregar saludo
    fun agregarSaludo(nombres: List<String>): List<String> {
        return nombres.map { "¡Hola, $it!" }
    }

    // Función para realizar operaciones
    fun performOperation(a: Int, b: Int, operation: (Int, Int) -> Int): Int {
        return operation(a, b)
    }

    // Clases Person y Student
    data class Person(val name: String, val age: Int, val gender: String)
    data class Student(val name: String, val age: Int, val gender: String, val studentId: String)

    // Función de mapeo de Person a Student
    fun mapPersonToStudent(person: Person, studentId: String): Student {
        return Student(person.name, person.age, person.gender, studentId)
    }


}


@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    Lab2Theme {
        Greeting("Android")
    }
}