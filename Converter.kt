package converter

class Converter {
    fun convertToMeter(input: Measure): Measure {
        val number = input.number * input.unit.coefficient
        val unit = if (number == 1) Units.METER else Units.METERS
        return Measure(number, unit)
    }

}