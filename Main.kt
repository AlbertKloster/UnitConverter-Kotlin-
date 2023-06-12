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
        if (!line.lowercase().matches(Regex("[0-9]*\\.?[0-9]* [a-zA-Z]+ [a-zA-Z]+ [a-zA-Z]+"))) {
            println("Wrong input.")
            continue
        }
        val (queryNumber, queryUnit, _, responseUnit) = line.split(Regex(" "))
        val parsedQuery = parser.parse(queryNumber, queryUnit)
        val parsedResponseUnit = Units.getUnit(responseUnit)

        if (parsedQuery.unit == Units.UNKNOWN || parsedResponseUnit == Units.UNKNOWN || parsedQuery.unit.category != parsedResponseUnit.category) {
            println("Conversion from ${if (parsedQuery.unit == Units.UNKNOWN) "???" else parsedQuery.unit.plural} to ${if (parsedResponseUnit == Units.UNKNOWN) "???" else parsedResponseUnit.plural} is impossible")
            continue
        }

        val query = Measure(
            parsedQuery.number,
            if (parsedQuery.number == 1.0) Units.getUnit(parsedQuery.unit.singular) else Units.getUnit(parsedQuery.unit.plural)
        )

        val response = converter.convertFromUnitToUnit(query, parsedResponseUnit)
        println("${query.number} ${if (query.number == 1.0) query.unit.singular else query.unit.plural} is ${response.number} ${if (response.number == 1.0) response.unit.singular else response.unit.plural}")
    }
}
