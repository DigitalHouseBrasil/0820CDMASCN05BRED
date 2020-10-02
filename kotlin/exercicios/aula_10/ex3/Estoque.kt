import java.lang.Exception

class Estoque(var nome: String, var qtdAtual: Int, var qntMinima: Int) {

    fun mudarNome(nome: String) {
        this.nome = nome
    }

    fun mudarQtMinima(qntMinima: Int) {
        if (qntMinima < 0) {
            throw Exception("Quantidade não pode ser negativa")
        }

        this.qntMinima = qntMinima
    }

    fun repor(quantidade: Int) {
        this.qtdAtual += quantidade
    }

    fun darBaixa(quantidade: Int) {
        if (qtdAtual - quantidade < 0) {
            throw Exception("Quantidade não pode ser negativa")
        }

        this.qtdAtual -= quantidade
    }

    fun mostrar(): String = "Nome: $nome\nQuantidade Mínima: $qntMinima\nQuantidadeAtual: $qtdAtual"

    fun precisaRepor() = qtdAtual <= qntMinima
}