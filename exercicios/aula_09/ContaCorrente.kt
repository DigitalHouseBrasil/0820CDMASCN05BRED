class ContaCorrente(conta: Int,
                    saldo: Double,
                    private val taxaDeOperacao: Double): ContaBancaria(conta, saldo) {

    override fun sacar(quantia: Double): Boolean {
        val valorTotalDoSaque = quantia + taxaDeOperacao

        if (quantia > valorTotalDoSaque) {
            println("Saldo insuficiente")
            return false
        } else {
            saldo -= valorTotalDoSaque
            return true
        }
    }

    override fun depositar(quantia: Double): Boolean {
        return if ((saldo + quantia) >= taxaDeOperacao ) {
            saldo += quantia - taxaDeOperacao
            true
        } else {
            println("Quantia insuficiente")
            false
        }
    }

    override fun mostrarDados() {
        super.mostrarDados()

        println("Taxa de operação: $taxaDeOperacao")
    }
}