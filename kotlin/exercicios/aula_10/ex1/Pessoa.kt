abstract class Pessoa(val nome: String, val registro: String) {
    open val podeDarAula get() = false
    open val podeFazerChamada get() = false
    open val podeAssistirAula get() = false
    open val podeFazerLicao get() = false
}