import java.util.Set;

public class UnsupportedTrackException extends ValidationException {
    public UnsupportedTrackException(String trackName, Set<String> supportedTracks) {
        super("Track '" + trackName + "' is not supported. Choose from " + supportedTracks + ".");
    }
}
