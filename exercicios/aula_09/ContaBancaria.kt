abstract class ContaBancaria(protected val conta: Int, protected var saldo: Double):  Imprimivel {
    abstract fun sacar(quantia: Double): Boolean
    abstract fun depositar(quantia: Double): Boolean

    val numeroDaConta get() = conta
    fun obterNumero(): Int = conta

    override fun mostrarDados() {
        println("Conta: $conta")
        println("Saldo: $saldo")
    }

    fun transferir(quantia: Double, destino: ContaBancaria) {
        val saldoContaOrigem = saldo

        if (!sacar(quantia) || !destino.depositar(quantia)) {
            saldo = saldoContaOrigem
            println("Não foi possível realizar a transferência")
        } else {
            println("Transferência realizada.")
        }
    }
}