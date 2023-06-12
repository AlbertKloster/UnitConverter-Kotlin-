package converter

class Converter {
    fun convertFromUnitToUnit(request: Measure, unit: Units): Measure {
        val meter = convertToBaseUnit(request)
        return convertFromBaseUnitToUnit(meter, unit)
    }

    private fun convertToBaseUnit(request: Measure): Measure {
        val number = (request.number + request.unit.offset) * request.unit.coefficient
        return Measure(number, Units.M)
    }

    private fun convertFromBaseUnitToUnit(request: Measure, unit: Units): Measure {
        val number = request.number / unit.coefficient - unit.offset
        return Measure(number, unit)
    }
}