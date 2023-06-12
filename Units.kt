package converter

enum class Units(val category: Category, val coefficient: Double, val short: String, val singular: String, val plural: String) {
    M(Category.LENGTH, 1.0, "m", "meter", "meters"),
    KM(Category.LENGTH, 1_000.0, "km", "kilometer" , "kilometers"),
    CM(Category.LENGTH, .01, "cm", "centimeter" , "centimeters"),
    MM(Category.LENGTH, .001, "mm", "millimeter" , "millimeters"),
    MI(Category.LENGTH, 1_609.35, "mi", "mile" , "miles"),
    YD(Category.LENGTH, .9144, "yd", "yard" , "yards"),
    FT(Category.LENGTH, .3048, "ft", "foot" , "feet"),
    IN(Category.LENGTH, .0254, "in", "inch" , "inches"),
    G(Category.WEIGHT, 1.0, "g", "gram", "grams"),
    KG(Category.WEIGHT, 1_000.0, "kg", "kilogram" , "kilograms"),
    MG(Category.WEIGHT, .001, "mg", "milligram" , "milligrams"),
    LB(Category.WEIGHT, 453.592, "lb", "pound" , "pounds"),
    OZ(Category.WEIGHT, 28.3495, "oz", "ounce" , "ounces"),
    UNKNOWN(Category.UNKNOWN, 0.0, "???", "???" , "???");

    companion object {
        fun getUnit(input: String): Units {
            for (unit in Units.values()) {
                if (unit.short == input.lowercase() || unit.singular == input.lowercase() || unit.plural == input.lowercase()) {
                    return unit
                }
            }
            return UNKNOWN
        }
    }
}