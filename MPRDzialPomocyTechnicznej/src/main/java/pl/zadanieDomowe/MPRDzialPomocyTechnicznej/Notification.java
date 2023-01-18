package pl.zadanieDomowe.MPRDzialPomocyTechnicznej;

public class Notification {
    private int id;
    private static int incId = 1;
    private String clientName;
    private String employeeName;
    private NotificationStatus notificationStatus;

    public Notification(String clientName,
                        String employeeName, NotificationStatus notificationStatus) {
        this.id = incId++;
        this.clientName = clientName;
        this.employeeName = employeeName;
        this.notificationStatus = notificationStatus;
    }

    public void setClientName(String clientName) {
        this.clientName = clientName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public void setNotificationStatus(NotificationStatus notificationStatus) {
        this.notificationStatus = notificationStatus;
    }

    public int getId() {
        return id;
    }

    public String getClientName() {
        return clientName;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public NotificationStatus getNotificationStatus() {
        return notificationStatus;
    }

    @Override
    public String toString() {
        return "Notification{" +
                "id='" + id + '\'' +
                ", clientName='" + clientName + '\'' +
                ", employeeName='" + employeeName + '\'' +
                ", notificationStatus=" + notificationStatus +
                '}';
    }
}
