package pl.zadanieDomowe.MPRDzialPomocyTechnicznej;

import org.junit.Test;
import java.util.List;
import static org.junit.Assert.assertEquals;

public class NotificationServiceUnitTest {
    private NotificationStorage notificationStorage = new NotificationStorage();
    private NotificationService notificationService = new NotificationService(notificationStorage);

    @Test
    public void shouldAddNewNotification() {

        String clientName = "Karim Benzema";
        String employeeName = "Real Madrid CF";

        notificationService.addNewNotification(clientName, employeeName);
        List<Notification> notificationList = notificationStorage.getNotificationList();
        Notification newlyAddedNotification = notificationList.get(notificationList.size() - 1);

        assertEquals(newlyAddedNotification.getId(), notificationList.size());
        assertEquals(clientName, newlyAddedNotification.getClientName());
        assertEquals(employeeName, newlyAddedNotification.getEmployeeName());
    }

    @Test
    public void shouldUpdateNotificationStatus() {

        NotificationStatus testStatus1 = NotificationStatus.DONE;
        NotificationStatus testStatus2 = NotificationStatus.IN_PROGRESS;
        NotificationStatus testStatus3 = NotificationStatus.REJECTED;

        int checkId = 2;  // notification o nr 2 ma status "REJECTED", wiec test wykona sie dla testStatus1; dla id = 1 || id = 4 (gdyz maja status "DONE") pojawi sie String o niemożliwości update'u

        notificationService.updateNotificationStatus(checkId, testStatus1);
        List<Notification> notificationList = notificationStorage.getNotificationList();
        Notification newlyUpdatedNotification = notificationList.get(checkId - 1);

        assertEquals(testStatus1, newlyUpdatedNotification.getNotificationStatus());
    }

    @Test
    public void shouldUpdateEmployee() {

        String newEmployeeName1 = "Mekambe";                            // wykona sie dla checkId = 4
        String newEmployeeName2 = "ASOCiación del FútbOL ARGentino";    // dla checkId = 4 pojawi sie komunikat o niemozliwosci zmiany employee na takiego samego co juz jest
        int checkId = 4;

        notificationService.updateEmployee(checkId, newEmployeeName1);
        List<Notification> notificationList = notificationStorage.getNotificationList();
        Notification newlyUpdatedEmployee = notificationList.get(checkId - 1);

        assertEquals(newEmployeeName1.toLowerCase(), newlyUpdatedEmployee.getEmployeeName().toLowerCase());
    }

    @Test
    public void shouldPrintById() {

        int byId = 2;

        notificationService.printById(byId);

        assertEquals(byId, notificationStorage.getNotificationList().get(byId - 1).getId());
    }
}
