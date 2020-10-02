fun main() {
    do {
        print("Digite um número: ")
        var numero = readLine()!!.toInt()

        if (numero % 2 != 0) {
            break
        }

        println("Ainda é par")
    } while (true)

    println("Agora é ímpar!")
}