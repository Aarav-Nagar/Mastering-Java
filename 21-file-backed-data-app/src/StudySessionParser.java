public class StudySessionParser {
    public StudySession parse(String line) throws SessionParseException {
        String[] parts = line.split("\\|");
        if (parts.length != 4) {
            throw new SessionParseException("Expected 4 fields but found " + parts.length + ".");
        }

        String date = parts[0].trim();
        String topic = parts[1].trim();
        String minutesText = parts[2].trim();
        String focusText = parts[3].trim();

        if (date.length() == 0 || topic.length() == 0) {
            throw new SessionParseException("Date and topic are required.");
        }

        int minutes;
        try {
            minutes = Integer.parseInt(minutesText);
        } catch (NumberFormatException exception) {
            throw new SessionParseException("Minutes must be an integer.");
        }

        if (minutes <= 0) {
            throw new SessionParseException("Minutes must be positive.");
        }

        if (!focusText.startsWith("focused=")) {
            throw new SessionParseException("Focus field must start with focused=.");
        }

        String focusedValue = focusText.substring("focused=".length()).trim();
        if (!"true".equalsIgnoreCase(focusedValue) && !"false".equalsIgnoreCase(focusedValue)) {
            throw new SessionParseException("Focus field must be true or false.");
        }

        return new StudySession(date, topic, minutes, Boolean.parseBoolean(focusedValue));
    }
}
