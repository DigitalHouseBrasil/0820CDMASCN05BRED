class Fatura {
    val itens = ArrayList<Item>()

    fun getTotalFatura(): Double {
        var total = 0.0

        itens.forEach{
            total += it.quantidade * it.precoUnitario
        }

        return total
    }
}