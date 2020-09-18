fun main() {
    val contaPoupanca1 = ContaPoupanca(1010, 50.00, 5.00)
    val contaPoupanca2 = ContaPoupanca(2020, 0.00, 5.00)

    val contaCorrente1 = ContaCorrente(1111, 0.00, 5.00)
    val contaCorrente2 = ContaCorrente(2121, 5.00, 5.00)

    val relatorio = Relatorio()

    contaPoupanca1.depositar(5.00)
    contaPoupanca2.depositar(5.00)
    contaCorrente1.depositar(4.00)
    contaCorrente2.depositar(5.00)

    contaPoupanca1.sacar(70.00)
    contaPoupanca2.sacar(5.00)
    contaCorrente1.sacar(4.00)
    contaCorrente2.sacar(5.00)

    println("---------------")
    relatorio.gerarRelatorio(contaPoupanca1)
    println("---------------")
    relatorio.gerarRelatorio(contaPoupanca2)
    println("---------------")
    relatorio.gerarRelatorio(contaCorrente2)
    println("---------------")
    relatorio.gerarRelatorio(contaCorrente2)
    println("---------------")
}