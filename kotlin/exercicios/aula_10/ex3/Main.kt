fun main() {
    val estoque = Estoque("Meu estoque", 15, 2)

    estoque.darBaixa(15)

    println(estoque.mostrar())
    println(estoque.precisaRepor())

    estoque.repor(5)

    println(estoque.mostrar())
    println(estoque.precisaRepor())
}