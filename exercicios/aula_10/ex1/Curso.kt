class Curso(val nome: String) {
    var professor: Professor? = null

    val aulas get() = ArrayList<Aula>()
    val alunos get() = ArrayList<Aluno>()
}
