class Professor(nome: String, registro: String): Pessoa(nome, registro) {
    override val podeDarAula: Boolean
        get() = true

    override val podeFazerChamada: Boolean
        get() = true
}
