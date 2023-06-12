package converter

class Parser {
    fun parse(queryNumber: String, queryUnit: String) = Measure(queryNumber.toDouble(), Units.getUnit(queryUnit))

}