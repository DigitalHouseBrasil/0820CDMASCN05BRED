
fun main () {
    val pessoa1 = Pessoa("Felipe", Estado("PB", "Paraíba"))
    val pessoa2 = Pessoa("Gabriel", Estado("SP", "São Paulo"))
    val pessoa3 = Pessoa("Lucas", Estado("PB", "Paraíba"))
    val pessoa4 = Pessoa("José", Estado("RJ", "Rio de Janeiro"))
    val pessoa5 = Pessoa("Lais", Estado("PE", "Pernambuco"))
    val pessoa6 = Pessoa("Guilherme", Estado("PE", "Pernambuco"))

    val pessoas = listOf(pessoa1, pessoa2, pessoa3, pessoa4, pessoa5, pessoa6)

    ////

    val agrupadorPorEstado = mutableMapOf<String, MutableList<Pessoa>>()

    pessoas.forEach{
        if (!agrupadorPorEstado.containsKey(it.estado.sigla)) {
            agrupadorPorEstado[it.estado.sigla] = mutableListOf()
        }

        agrupadorPorEstado[it.estado.sigla]?.add(it)
    }
}