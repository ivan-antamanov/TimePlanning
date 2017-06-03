package timeplaner.gui.events;


import timeplaner.gui.events.events.ProjectEvent;

import java.util.*;

public class EventProcessor {
    private static Map<Class, List<ProjectEventHandler>> handlers = new LinkedHashMap<>();

    public static <E> void register(Class<E> clazz, ProjectEventHandler<E> handler) {
        handlers.computeIfAbsent(clazz, key -> new ArrayList<>()).add(handler);
    }

    // unregister

    public static <E extends ProjectEvent> void send(E event) {
        for (ProjectEventHandler handler : handlers.getOrDefault(event.getClass(), Collections.emptyList())) {
            ((ProjectEventHandler<E>) handler).handle(event);
        }
    }

}
