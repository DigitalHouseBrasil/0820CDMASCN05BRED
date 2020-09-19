class Aluno(registro: String, nome: String, val sobrenome: String): Pessoa(nome, registro) {
    override val podeFazerLicao: Boolean
        get() = true

    override val podeAssistirAula: Boolean
        get() = true
}