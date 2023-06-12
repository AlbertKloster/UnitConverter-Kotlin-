package converter

class Parser {
    fun parse(input: String): Measure {
        val (number, unit) = input.split(Regex(" "))
        return try { Measure(number.toDouble(), Units.getUnit(unit)) } catch (e: RuntimeException) {
            throw RuntimeException(e.message)
        }
    }
}