package com.Pergola2.SpringMarriageBook.service;
import com.Pergola2.SpringMarriageBook.model.Participant;
import com.Pergola2.SpringMarriageBook.repository.ParticipantRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ParticipantService {

   private static ParticipantRepo repo;

    private static Participant participant;
    private ParticipantRepo participantRepo;

    public ParticipantRepo getRepo(){
       return repo;

   };

 @Autowired
    public void setRepo(ParticipantRepo repo) {
        ParticipantService.repo = repo;
    }

    public void addParticipant (Participant participant){
     repo.addParticipant(participant);
        System.out.println("Participant saved###");
    }

    public void deleteParticipant (int id){
     repo.deleteParticipant(id);
        System.out.println("Participant deleted###");
    }


    public void updateParticipant(int id, String name, String lastname, int age, int id2) {
     repo.updateParticipant(id, name, lastname, age, id2);
    }

    public void readParticipant (int id){
     repo.readParticipant(id);
        System.out.println("Participant read###");
    }

    @Autowired
    public void setParticipantRepo(ParticipantRepo participantRepo) {
        this.participantRepo = participantRepo;
    }




    @Autowired
    public void setParticipant(Participant participant) {
        this.participant = participant;
   }
}

