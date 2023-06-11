package converter

import java.lang.RuntimeException

enum class Units(val coefficient: Int, val singular: String, val plural: String) {
    M(1, "meter", "meters"), METER(1, "meter", "meters"), METERS(1, "meter", "meters"),
    KM(1_000, "kilometer", "kilometers"), KILOMETER(1_000, "kilometer", "kilometers"), KILOMETERS(1_000, "kilometer", "kilometers");

    companion object {
        fun getUnit(input: String): Units {
            for (unit in Units.values()) {
                if (unit.name == input.uppercase()) {
                    return unit
                }
            }
            throw RuntimeException("Wrong input")
        }
    }
}