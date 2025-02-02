package pl.fylypek.librus_unofficial

import java.net.URL

fun fetch(url: String): Promise<String> {
    return Promise { resolve, reject ->
        try {
            val connection = URL(url).openConnection()
            val data = connection.getInputStream().bufferedReader().readText()
            resolve(data)
        } catch (e: Exception) {
            reject(e)
        }
    }
}