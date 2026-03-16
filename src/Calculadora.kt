import java.util.Scanner

fun main() {
    val scanner = Scanner(System.`in`)
    
    println("--- Calculadora Inteligente (Reconhecimento) ---")
    println("Regra: Mínimo de 9 caracteres e deve conter parênteses.")
    println("Exemplo: 5 + 7 * 9 / 2 (5 - 4) * 2")
    
    print("\nDigite sua expressão matemática: ")
    val expressao = scanner.nextLine()
    
    // Verificando o tamanho da expressão (Mínimo 9 caracteres)
    if (expressao.length < 9) {
        println("Erro: A expressão deve ter pelo menos 9 caracteres.")
        return
    }
    
    // Verificando se contém parênteses
    if (!expressao.contains("(") || !expressao.contains(")")) {
        println("Erro: A expressão deve conter parênteses.")
        return
    }
    
    println("\n--- Analisando a Expressão ---")
    
    // Criando listas para separar números e operadores
    val numeros = mutableListOf<String>()
    val operadores = mutableListOf<Char>()
    val simbolosEspeciais = mutableListOf<Char>()
    
    // Usando um loop For para percorrer cada caractere da String
    for (caractere in expressao) {
        when {
            // Verificando se é um dígito (Intervalo 0 a 9)
            caractere in '0'..'9' -> {
                numeros.add(caractere.toString())
            }
            // Verificando operadores matemáticos
            caractere in arrayOf('+', '-', '*', '/') -> {
                operadores.add(caractere)
            }
            // Verificando parênteses
            caractere == '(' || caractere == ')' -> {
                simbolosEspeciais.add(caractere)
            }
        }
    }
    
    // Exibindo o que foi reconhecido usando For Each
    println("Números identificados:")
    numeros.forEach { print("$it ") }
    
    println("\n\nOperadores identificados:")
    operadores.forEach { print("$it ") }
    
    println("\n\nSímbolos de agrupamento (Parênteses):")
    simbolosEspeciais.forEach { print("$it ") }
    
    println("\n\nExpressão validada com sucesso!")
}
