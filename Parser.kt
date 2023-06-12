package converter

import kotlin.RuntimeException

class Parser {
     fun parseToQuery(input: String): Query {
        val sourceNumber: Double
        val sourceUnit: Units
        val destinationUnit: Units
        var isSourceDegree = false

        val strings = input.trim().split(Regex(" +"))

        if (strings.size < 4) {
            throw RuntimeException("Parse error")
        }

        if (strings.size > 6) {
            throw RuntimeException("Parse error")
        }

        if (isNotNumber(strings[0])) {
            throw RuntimeException("Parse error")
        }

        sourceNumber = strings[0].toDouble()

        if (strings[1].lowercase() == "degree" || strings[1].lowercase() == "degrees") {
            isSourceDegree = true
            sourceUnit = Units.getUnit("${strings[1]} ${strings[2]}")
        } else {
            sourceUnit = Units.getUnit(strings[1])
        }

        if (sourceNumber < 0 && sourceUnit.category == Category.WEIGHT) {
            throw RuntimeException("Weight shouldn't be negative")
        }

        if (sourceNumber < 0 && sourceUnit.category == Category.LENGTH) {
            throw RuntimeException("Length shouldn't be negative")
        }

        if (isSourceDegree && strings.size < 5) {
            throw RuntimeException("Parse error")
        }

        val nextIndex = if (isSourceDegree) 4 else 3

        destinationUnit = if (strings.lastIndex == nextIndex + 1 && (strings[nextIndex].lowercase() == "degree" || strings[nextIndex].lowercase() == "degrees")) {
            Units.getUnit("${strings[nextIndex]} ${strings[nextIndex + 1]}")
        } else {
            Units.getUnit(strings[nextIndex])
        }

        return Query(sourceNumber, sourceUnit, destinationUnit)
    }

    private fun isNotNumber(string: String) = !string.matches(Regex("-?[0-9]*\\.?[0-9]+"))
}