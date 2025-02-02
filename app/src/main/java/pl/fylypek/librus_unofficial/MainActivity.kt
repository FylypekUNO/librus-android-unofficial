package pl.fylypek.librus_unofficial

import android.os.Bundle
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        val defaultView = TextView(this)
        defaultView.text = "Loading..."

        setContentView(defaultView)

        val url = "https://jsonplaceholder.typicode.com/todos/1"
        fetch(url)
            .then { data ->
                val outputView = TextView(this)
                outputView.text = data

                setContentView(outputView)

                return@then outputView
            }
            .then { outputView ->
                outputView.textSize = 18f
                outputView.setPadding(1*3, 32*3, 0, 0)
            }
            .catch { error ->
                val outputView = TextView(this)
                outputView.text = error.message

                setContentView(outputView)
            }
    }
}