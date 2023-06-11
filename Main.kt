package converter

fun main() {
    val converter = Converter()
    val parser = Parser()
    print("Enter a number and a measure: ")
    try {
        val input = parser.parse(readln())
        val query = Measure(input.number, if (input.number == 1) Units.getUnit(input.unit.singular) else Units.getUnit(input.unit.plural))
        val response = converter.convertToMeter(input)
        println("${query.number} ${query.unit.name.lowercase()} is ${response.number} ${response.unit.name.lowercase()}")
    } catch (e: RuntimeException) {
        println(e.message)
    }

}
