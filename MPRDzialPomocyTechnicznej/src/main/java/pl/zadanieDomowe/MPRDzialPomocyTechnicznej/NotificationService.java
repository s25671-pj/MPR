package pl.zadanieDomowe.MPRDzialPomocyTechnicznej;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class NotificationService {

    private NotificationStorage notificationStorage;

    @Autowired
    public NotificationService(NotificationStorage notificationStorage) {
        this.notificationStorage = notificationStorage;
    }

    public void addNewNotification(String clientName, String employeeName) {

        if (clientName.isEmpty()) {
            System.out.println("addNewNotification alert:\n Can't add new notification without 'clientName' parameter set.");
        } else {
            if (employeeName.isEmpty()) {
                System.out.println("addNewNotification alert:\n Can't add new notification without 'employeeName' parameter set.");
            } else {
                notificationStorage.getNotificationList().add(new Notification(clientName, employeeName, NotificationStatus.IN_PROGRESS));
                System.out.println("Notification added correctly");
                System.out.println(notificationStorage.getNotificationList().get(notificationStorage.getNotificationList().size() - 1) + "\n");
            }
        }
    }

    public void updateNotificationStatus(int id, NotificationStatus newStatus) {
        for (Notification notification : notificationStorage.getNotificationList()) {
            if (notification.getId() == id) {
                if (newStatus == notification.getNotificationStatus()) {
                    System.out.println("updateNotificationStatus alert:\n Can't update notification status to: " + newStatus + ", for notification with id: " + id
                            + ". Notification already has that status.\n" + " Proof: " + notification + "\n");
                    return;
                } else {
                    notification.setNotificationStatus(newStatus);
                    System.out.println("Notification status of id: " + id + " updated to: " + newStatus + ".");
                    System.out.println(notification + "\n");
                    return;
                }
            }
        }
        System.out.println("Notification with id: " + id + " not found.");
    }

    public void updateEmployee(int id, String newEmployeeName) {
        for (Notification notification : notificationStorage.getNotificationList()) {
            if (notification.getId() == id) {
                if (notification.getEmployeeName().toLowerCase().equals(newEmployeeName.toLowerCase())) {
                    System.out.println("updateEmployee alert:\n Can't update employee to: " + newEmployeeName + ", for notification with id: " + id
                            + ". Notification already has that employee.\n" + " Proof: " + notification + "\n");
                    return;
                } else {
                    notification.setEmployeeName(newEmployeeName);
                    System.out.println("The new employee for notification of id: " + id + ", is: " + newEmployeeName);
                    System.out.println(notification + "\n");
                    return;
                }
            }
        }
        System.out.println("Notification with id: " + id + " not found");
    }

    public void printById(int id) {
        for (Notification notification : notificationStorage.getNotificationList()) {
            if (notification.getId() == id) {
                System.out.println("You have requested to print notification with id: " + id +
                        "\n" + notification + "\n");
                return;
            }
        }
        System.out.println("Notification with id: " + id + " not found");
    }
}
