package converter

class Converter {
    fun convertFromUnitToUnit(request: Measure, unit: Units): Measure {
        val meter = convertToMeter(request)
        return convertFromMeterToUnit(meter, unit)
    }

    private fun convertToMeter(request: Measure): Measure {
        val number = request.number * request.unit.coefficient
        return Measure(number, Units.M)
    }

    private fun convertFromMeterToUnit(request: Measure, unit: Units): Measure {
        val number = request.number / unit.coefficient
        return Measure(number, unit)
    }
}