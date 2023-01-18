package pl.zadanieDomowe.MPRDzialPomocyTechnicznej;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class NotificationStorage {
    private final List<Notification> notificationList = new ArrayList<>();

    @Autowired
    public NotificationStorage(){
        notificationList.add(new Notification("Robert Lewandowski","FC Bayern München",NotificationStatus.DONE));
        notificationList.add(new Notification("Cristiano Ronaldo","Manchester United F.C.",NotificationStatus.REJECTED));
        notificationList.add(new Notification("Gavi","FC Barcelona",NotificationStatus.IN_PROGRESS));
        notificationList.add(new Notification("Lionel Messi","Asociación del Fútbol Argentino",NotificationStatus.DONE));
    }

    public List<Notification> getNotificationList() {
        return notificationList;
    }

}