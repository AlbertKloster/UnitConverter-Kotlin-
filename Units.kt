package converter

enum class Units(val category: Category, val coefficient: Double, val offset: Double, val short: String, val singular: String, val plural: String, val alias1: String, val alias2: String) {
    M(Category.LENGTH, 1.0, .0, "m", "meter", "meters", "m", "m"),
    KM(Category.LENGTH, 1_000.0, .0, "km", "kilometer" , "kilometers", "km", "km"),
    CM(Category.LENGTH, .01, .0, "cm", "centimeter" , "centimeters", "cm", "cm"),
    MM(Category.LENGTH, .001, .0, "mm", "millimeter" , "millimeters", "mm", "mm"),
    MI(Category.LENGTH, 1_609.35, .0, "mi", "mile" , "miles", "mi", "mi"),
    YD(Category.LENGTH, .9144, .0, "yd", "yard" , "yards", "yd", "yd"),
    FT(Category.LENGTH, .3048, .0, "ft", "foot" , "feet", "ft", "ft"),
    IN(Category.LENGTH, .0254, .0, "in", "inch" , "inches", "in", "in"),
    G(Category.WEIGHT, 1.0, .0, "g", "gram", "grams", "g", "g"),
    KG(Category.WEIGHT, 1_000.0, .0, "kg", "kilogram" , "kilograms", "kg", "kg"),
    MG(Category.WEIGHT, .001, .0, "mg", "milligram" , "milligrams", "mg", "mg"),
    LB(Category.WEIGHT, 453.592, .0, "lb", "pound" , "pounds", "lb", "lb"),
    OZ(Category.WEIGHT, 28.3495, .0, "oz", "ounce" , "ounces", "oz", "oz"),
    DC(Category.TEMPERATURE, 1.0, .0, "dc", "degree Celsius" , "degrees Celsius", "c", "celsius"),
    DF(Category.TEMPERATURE, 5.0 / 9.0, -32.0, "df", "degree Fahrenheit" , "degrees Fahrenheit", "f", "fahrenheit"),
    K(Category.TEMPERATURE, 1.0, -273.15, "k", "kelvin" , "kelvins", "k", "k"),
    UNKNOWN(Category.UNKNOWN, 0.0, .0, "???", "???" , "???", "???", "???");

    companion object {
        fun getUnit(input: String): Units {
            for (unit in Units.values()) {
                if (unit.short.lowercase() == input.lowercase() ||
                    unit.singular.lowercase() == input.lowercase() ||
                    unit.plural.lowercase() == input.lowercase() ||
                    unit.alias1.lowercase() == input.lowercase() ||
                    unit.alias2.lowercase() == input.lowercase()) {
                    return unit
                }
            }
            return UNKNOWN
        }
    }
}