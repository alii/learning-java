package engine.rendering;

public interface Trackable {

    int getId();

    boolean isTrackedBy(ObjectTracker<?, ?> tracker);

}
