class Banco: Imprimivel {
    private val contas = ArrayList<ContaBancaria>()

    fun inserir(conta: ContaBancaria) {
        contas.add(conta)
        println("Conta criada!")
    }

    override fun mostrarDados() {
        contas.forEach{
            it.mostrarDados()
            println()
        }
    }

    fun procurarConta(numeroConta: Int): ContaBancaria? {
        for (conta in contas) {
            if (conta.numeroDaConta == numeroConta) {
                return conta
            }
        }

        return null
    }
}