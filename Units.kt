package converter

import java.lang.RuntimeException

enum class Units(val coefficient: Double, val short: String, val singular: String, val plural: String) {
    M(1.0, "m", "meter", "meters"),
    KM(1_000.0, "km", "kilometer" , "kilometers"),
    CM(.01, "cm", "centimeter" , "centimeters"),
    MM(.001, "mm", "millimeter" , "millimeters"),
    MI(1_609.35, "mi", "mile" , "miles"),
    YD(.9144, "yd", "yard" , "yards"),
    FT(.3048, "ft", "foot" , "feet"),
    IN(.0254, "in", "inch" , "inches");

    companion object {
        fun getUnit(inputUnit: String): Units {
            for (unit in Units.values()) {
                if (unit.short == inputUnit.lowercase() || unit.singular == inputUnit.lowercase() || unit.plural == inputUnit.lowercase()) {
                    return unit
                }
            }
            throw RuntimeException("Wrong input. Unknown unit $inputUnit")
        }
    }
}