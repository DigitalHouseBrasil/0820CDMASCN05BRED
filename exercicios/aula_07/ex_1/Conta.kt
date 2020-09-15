class Conta(val numeroDaConta: Int, var saldo: Double, val titular: Cliente) {

    fun depositar(quantia: Double) {
        saldo += quantia
        println("Deposito na conta ${titular.nome} realizado! Novo saldo R$$saldo")
    }

    fun sacar(quantia: Double) {
        if (quantia > saldo) {
            println("Saldo insuficiente")
        } else {
            saldo -= quantia
            println("Saque realizado! Novo saldo R$$saldo")
        }
    }
}