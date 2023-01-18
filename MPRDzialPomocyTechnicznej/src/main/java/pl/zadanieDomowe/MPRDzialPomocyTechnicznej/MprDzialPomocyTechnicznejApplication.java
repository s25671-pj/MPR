package pl.zadanieDomowe.MPRDzialPomocyTechnicznej;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MprDzialPomocyTechnicznejApplication {
	private NotificationService notificationService;

	public MprDzialPomocyTechnicznejApplication(NotificationService notificationService){
		this.notificationService = notificationService;
	}


	public static void main(String[] args) {
		SpringApplication.run(MprDzialPomocyTechnicznejApplication.class, args);
	}



}