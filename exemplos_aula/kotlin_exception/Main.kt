import java.lang.ArithmeticException
import java.lang.Exception

val alunos = arrayListOf<Aluno>()

fun main() {
    alunos.add(Aluno("Felipe", 18))
    alunos.add(Aluno("Gabriel", 21))
    alunos.add(Aluno("Lucas", 19))

    buscaAlunoPorIdade(18)

    try {
        adicionaAlunoMaiorDeIdade(Aluno("Samael", 17))
    } catch (ex: Exception) {
        println(ex.message)
    }
}

fun buscaAlunoPorIdade(idade: Int): Int {
    for (posicao in alunos.indices) {
        if (alunos[posicao].idade == idade) {
            return posicao
        }
    }

    return -1
}

fun adicionaAlunoMaiorDeIdade(aluno: Aluno) {
    if (aluno.idade >= 18) {
        alunos.add(aluno)
    } else {
        throw Exception("Aluno menor de idade")
    }
}