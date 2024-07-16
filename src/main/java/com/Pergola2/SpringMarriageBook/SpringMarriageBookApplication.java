package com.Pergola2.SpringMarriageBook;

import com.Pergola2.SpringMarriageBook.model.Participant;
import com.Pergola2.SpringMarriageBook.service.ParticipantService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class SpringMarriageBookApplication {

	public static void main(String[] args) {

		ApplicationContext context = SpringApplication.run(SpringMarriageBookApplication.class, args);


		Participant participant = context.getBean(Participant.class);

		participant.setId(5);
		participant.setName("Mickey");
		participant.setLastname("Masala");
		participant.setAge(29);
		participant.setMarried(true);


		ParticipantService service = context.getBean(ParticipantService.class);

		service.addParticipant(participant);
//		service.deleteParticipant(2);
//		service.updateParticipant(2, "Greg", "Foulton", 56, 2);
//		service.readParticipant(2);


	}


}
