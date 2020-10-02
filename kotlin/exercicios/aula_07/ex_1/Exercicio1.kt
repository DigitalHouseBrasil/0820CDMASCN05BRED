fun main() {
    val cliente1 = Cliente("Giulia", "Machado")
    val cliente2 = Cliente("David", "Bonner")

    val conta1 = Conta(123, 20.0, cliente1)
    val conta2 = Conta(321, 0.0, cliente2)

    conta1.depositar(200.0) // Deve ficar com R$ 220
    conta1.sacar(120.0) // Deve ficar com R$ 100

    conta2.depositar(210.0)
    conta2.sacar(200.0)
}