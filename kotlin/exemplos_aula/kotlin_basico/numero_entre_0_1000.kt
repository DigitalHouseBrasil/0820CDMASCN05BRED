// Programa para que ele aceite apenas números entre 0 e 1000.

fun main() {
    do {    // Início do loop
        print("Digite um número: ")
        var numero = readLine()!!.toInt()   // Lê um número e converte para inteiro

        if (numero in 1..999) {
            break   // Para o loop
        }
    } while (true)  // Checagem do loop
}