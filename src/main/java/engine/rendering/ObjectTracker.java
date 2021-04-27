package engine.rendering;

import engine.Game;

import java.util.HashSet;
import java.util.Set;

/**
 * Track and manipulate {@link Trackable} objects associated with a {@link Game} instance
 *      Specifically, there was a slight invocation issue with Game objects and GameWindow objects.
 *      With objects that very crucially rely on who is accessing them, we can funnel their access through
 *      the tracker, trying to prevent access that could result in an "undefined behavior"
 *
 * @param <T> type of game
 * @param <S> type of object to be tracked
 */
// TODO: Set better management system for objects and ditch this (it's a bit of a cheat)
public class ObjectTracker<T extends Game, S extends Trackable> {

    private final Set<S> tracked;
    private final T game;

    /**
     * Create a new tracker
     *
     * @param game associated game
     */
    public ObjectTracker(final T game) {
        this.game = game;
        this.tracked = new HashSet<>();
    }

    /**
     * Add a trackable item
     *
     * @param toTrack item to track
     */
    public synchronized void addTrackable(S toTrack) {
        this.tracked.add(toTrack);
    }

    /**
     * Get a tracked item
     *
     * @return item
     */
    public synchronized Set<S> getTracked() {
        return this.tracked;
    }

    /**
     * Get a tracked item by its id
     *
     * @param id trackable id {@link Trackable#getId()}
     * @return
     */
    public synchronized S getTrackedItem(int id) {
        // No streams b/c slow (who knows context of this invocation?) >:(
        for (S item : tracked) {
            if (item.getId() == id) return item;
        }
        return null;
    }


}
