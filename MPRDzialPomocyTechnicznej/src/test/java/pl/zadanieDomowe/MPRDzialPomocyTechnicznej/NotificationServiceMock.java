package pl.zadanieDomowe.MPRDzialPomocyTechnicznej;

import static org.junit.Assert.assertEquals;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import java.util.ArrayList;
import java.util.List;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class NotificationServiceMock {

    @Mock
    private NotificationStorage notificationStorage;

    @InjectMocks
    private NotificationService notificationService;

    @Test
    public void shouldAddNewNotification() {
        String clientName = "Czeslaw Michniewicz";
        String employeeName = "Tottenham Hotspur F.C.";

        List<Notification> notificationList = new ArrayList<>();

        when(notificationStorage.getNotificationList()).thenReturn(notificationList);

        notificationService.addNewNotification(clientName, employeeName);
        Notification lastNotification = notificationList.get(notificationList.size() - 1);

        assertEquals(clientName, lastNotification.getClientName());
        assertEquals(employeeName, lastNotification.getEmployeeName());
    }


    @Test
    public void shouldUpdateNotificationStatus() {

        NotificationStatus testStatus1 = NotificationStatus.DONE;
        NotificationStatus testStatus2 = NotificationStatus.IN_PROGRESS;
        NotificationStatus testStatus3 = NotificationStatus.REJECTED;

        when(notificationStorage.getNotificationList()).thenReturn(List.of(new Notification("Zbigniew Boniek", "Polski Zwiazek Pilki Noznej", NotificationStatus.DONE)));

        notificationService.updateNotificationStatus(1, testStatus3);

        List<Notification> notificationList = notificationStorage.getNotificationList();
        Notification newlyUpdatedNotification = notificationList.get(notificationStorage.getNotificationList().size() - 1);

        assertEquals(testStatus3, newlyUpdatedNotification.getNotificationStatus());

    }

    @Test
    public void shouldUpdateEmployee() {

        String newEmployeeName1 = "Manchester City F.C.";
        String newEmployeeName2 = "BorusSiA dOrtMUnd";

        when(notificationStorage.getNotificationList()).thenReturn(List.of(new Notification("Erling Haaland", "Borussia Dortmund", NotificationStatus.DONE)));

        List<Notification> notificationList = notificationStorage.getNotificationList();
        int checkId = notificationList.get(notificationStorage.getNotificationList().size() - 1).getId();

        notificationService.updateEmployee(checkId, newEmployeeName2);
        Notification newlyUpdatedEmployee = notificationList.get(checkId - 1);

        assertEquals(newEmployeeName2.toLowerCase(), newlyUpdatedEmployee.getEmployeeName().toLowerCase());
    }

    @Test
    public void shouldPrintById() {


        when(notificationStorage.getNotificationList()).thenReturn(List.of(new Notification("Pedri", "FC Barcelona", NotificationStatus.IN_PROGRESS)));

        List<Notification> notificationList = notificationStorage.getNotificationList();
        int byId = notificationList.get(notificationStorage.getNotificationList().size() - 1).getId();
        notificationService.printById(byId);

        assertEquals(byId, notificationStorage.getNotificationList().get(byId - 1).getId());
    }
}