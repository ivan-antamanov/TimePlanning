package timeplaner.gui.events;


public interface ProjectEventHandler<E> {
    void handle(E event);
}
