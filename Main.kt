package converter

fun main() {
    val converter = Converter()
    val parser = Parser()
    print("Enter a number and a measure of length: ")
    try {
        val input = parser.parse(readln())
        val query = Measure(input.number, if (input.number == 1.0) Units.getUnit(input.unit.singular) else Units.getUnit(input.unit.plural))
        val response = converter.convertToMeter(input)
        println("${query.number} ${if (query.number == 1.0) query.unit.singular else query.unit.plural} is ${response.number} ${if (response.number == 1.0) response.unit.singular else response.unit.plural}")
    } catch (e: RuntimeException) {
        println(e.message)
    }

}
