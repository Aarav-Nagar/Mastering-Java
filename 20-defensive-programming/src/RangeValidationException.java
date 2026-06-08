public class RangeValidationException extends ValidationException {
    public RangeValidationException(String fieldName, double actual, double min, double max) {
        super(fieldName + " must stay between " + format(min) + " and " + format(max)
            + ", but was " + format(actual) + ".");
    }

    private static String format(double value) {
        if (value == Math.rint(value)) {
            return Integer.toString((int) value);
        }
        return String.format("%.2f", value);
    }
}
