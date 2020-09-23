
fun main () {
    val pessoa1 = Pessoa("Felipe", 16)
    val pessoa2 = Pessoa("Gabriel", 18)
    val pessoa3 = Pessoa("Lucas", 20)
    val pessoa4 = Pessoa("José", 21)
    val pessoa5 = Pessoa("Lais", 20)
    val pessoa6 = Pessoa("Guilherme", 16)

    val pessoas = listOf(pessoa1, pessoa2, pessoa3, pessoa4, pessoa5, pessoa6)

    ////

    val pessoasAgrupadas = mutableMapOf<Int, MutableList<Pessoa>>()

    pessoas.forEach{
        if (!pessoasAgrupadas.containsKey(it.idade)) {  // False
            // Inicializa o List
            pessoasAgrupadas[it.idade] = mutableListOf()
        }

        pessoasAgrupadas[it.idade]!!.add(it)
    }

    println(pessoasAgrupadas)
}