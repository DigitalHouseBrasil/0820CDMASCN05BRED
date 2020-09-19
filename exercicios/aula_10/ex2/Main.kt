fun main() {
    // Preço negativo
    // Quantidade negativa

    val fatura = Fatura()

    var item1 = Item(1, "item1", 2, -1.0)
    var item2 = Item(2, "item2", -2, 1.0)

    fatura.itens.add(item1)
    fatura.itens.add(item2)

    println(fatura.getTotalFatura())

    // Preço positivo
    // Quantidade positiva

    val fatura2 = Fatura()

    item1 = Item(1, "item1", 3, 1.0)
    item2 = Item(2, "item2", 2, 4.0)

    fatura.itens.add(item1)
    fatura.itens.add(item2)

    println(fatura.getTotalFatura())
}