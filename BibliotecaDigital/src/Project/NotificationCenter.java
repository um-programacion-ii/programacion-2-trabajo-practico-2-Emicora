package Project;

import java.util.List;
import java.util.ArrayList;
import java.util.concurrent.CopyOnWriteArrayList;

public class NotificationCenter {
    private static final NotificationCenter INSTANCE = new NotificationCenter();

    private final List<String> notifications = new CopyOnWriteArrayList<>();

    private NotificationCenter() {}

    public static NotificationCenter getInstance() {
        return INSTANCE;
    }

    public void addNotification(String msg) {
        notifications.add(msg);
    }

    public List<String> fetchAll() {
        List<String> copy = new ArrayList<>(notifications);
        notifications.clear();
        return copy;
    }
}
