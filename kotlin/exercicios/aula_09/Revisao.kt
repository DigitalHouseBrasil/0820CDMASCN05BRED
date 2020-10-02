import kotlin.random.Random

val banco = Banco()

fun main() {
    do {
        val opcaoPrincipal = menuPrincipal()

        when (opcaoPrincipal) {
            1 -> submenu1()
            2 -> submenu2()
            4 -> submenu4()
        }
    } while (opcaoPrincipal < 5)

    println()
    println("Operação finalizada")
}

fun menuPrincipal(): Int {
    println()
    println("1 - Criar conta")
    println("2 - Selecionar conta")
    println("3 - Remover conta")
    println("4 - Gerar relatorio")
    println("5 - Finalizar")
    println()

    return readLine()!!.toInt()
}

fun submenu1() {
    println()
    println("a - Conta corrente")
    println("b - Conta poupança")
    println()

    val opcaoSelecionada = readLine()!!.toInt()
    var contaCriada: ContaBancaria? = null

    when (opcaoSelecionada) {
        1 -> {
            contaCriada = ContaCorrente(Random.nextInt(), 0.0, 5.00)
        }
        2 -> {
            contaCriada = ContaPoupanca(Random.nextInt(), 0.0, 5.00)
        }
    }

    banco.inserir(contaCriada!!)
}

fun submenu2() {
    val numeroConta = readLine()!!.toInt()

    val contaAchada = banco.procurarConta(numeroConta)

    if (contaAchada != null) {
        contaAchada.mostrarDados()
    } else {
        println("Conta não encontrada")
    }
}

fun submenu4() {
    banco.mostrarDados()
}
