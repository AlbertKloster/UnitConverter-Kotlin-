package converter

fun main() {
    val converter = Converter()
    val parser = Parser()
    while (true) {
        print("Enter what you want to convert (or exit): ")
        val line = readln()
        if (line.lowercase() == "exit") {
            break
        }

        val query = try {
            parser.parseToQuery(line)
        } catch (e: RuntimeException) {
            println(e.message)
            continue
        }

        if (query.sourceUnit == Units.UNKNOWN || query.destinationUnit == Units.UNKNOWN || query.sourceUnit.category != query.destinationUnit.category) {
            println("Conversion from ${query.sourceUnit.plural} to ${query.destinationUnit.plural} is impossible")
            continue
        }

        val measure = Measure(
            query.sourceNumber,
            if (query.sourceNumber == 1.0) Units.getUnit(query.sourceUnit.singular) else Units.getUnit(query.sourceUnit.plural)
        )

        val response = converter.convertFromUnitToUnit(measure, query.destinationUnit)
        println("${measure.number} ${if (measure.number == 1.0) measure.unit.singular else measure.unit.plural} is ${response.number} ${if (response.number == 1.0) response.unit.singular else response.unit.plural}")
    }
}
