package converter

class Converter {
    fun convertToMeter(request: Measure): Measure {
        val number = request.number * request.unit.coefficient
        return Measure(number, Units.M)
    }

}