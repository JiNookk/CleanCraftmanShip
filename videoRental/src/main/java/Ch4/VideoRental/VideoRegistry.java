package Ch4.VideoRental;

import java.util.HashMap;
import java.util.Map;

public class VideoRegistry {
    public static Movie getMovie(String title) {
        return switch (videoRegistry.get(title)) {
            case REGULAR -> new RegularMovie(title);
            case CHILDREN -> new ChildrenMovie(title);
            default -> null;
        };
    }

    public enum VideoType {REGULAR, CHILDREN}

    private static Map<String, VideoType> videoRegistry = new HashMap<>();

    public static VideoType getType(String title) {
        return videoRegistry.get(title);
    }

    public static void addMovie(String title, VideoType type) {
        videoRegistry.put(title, type);
    }
}
