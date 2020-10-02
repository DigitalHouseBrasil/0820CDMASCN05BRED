import kotlin.math.pow;

fun main() {
    val corDoSemaforo = "vermelho" // verde (siga!), vermelho (pare!), amarelo (atenção, pare!)
    
    if (corDoSemaforo.equals("verde")) {
        println("siga!")
    } else if (corDoSemaforo.equals("vermelho")) {
        println("pare!")
    } else if (corDoSemaforo.equals("amarelo")) {
        println("atenção, pare!")
    }
}