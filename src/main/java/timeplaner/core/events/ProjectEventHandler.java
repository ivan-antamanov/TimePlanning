package timeplaner.core.events;


public interface ProjectEventHandler<E> {
    void handle(E event);
}
