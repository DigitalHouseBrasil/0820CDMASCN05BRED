class ContaPoupanca(conta: Int,
                    saldo: Double,
                    private val limite: Double): ContaBancaria(conta, saldo) {

    override fun sacar(quantia: Double): Boolean {
        return if (quantia > (saldo + limite)) {
            println("Saldo insuficiente")
            false
        } else {
            saldo -= quantia
            true
        }
    }

    override fun depositar(quantia: Double): Boolean {
        saldo += quantia

        return true
    }

    override fun mostrarDados() {
        super.mostrarDados()

        println("Limite: $limite")
    }
}