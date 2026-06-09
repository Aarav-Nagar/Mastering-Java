public class StudySession {
    private final String date;
    private final String topic;
    private final int minutes;
    private final boolean focused;

    public StudySession(String date, String topic, int minutes, boolean focused) {
        this.date = date;
        this.topic = topic;
        this.minutes = minutes;
        this.focused = focused;
    }

    public String getDate() {
        return date;
    }

    public String getTopic() {
        return topic;
    }

    public int getMinutes() {
        return minutes;
    }

    public boolean isFocused() {
        return focused;
    }

    public String toFileLine() {
        return date + "|" + topic + "|" + minutes + "|focused=" + focused;
    }

    @Override
    public String toString() {
        return date + " - " + topic + " (" + minutes + " min, focused=" + focused + ")";
    }
}
