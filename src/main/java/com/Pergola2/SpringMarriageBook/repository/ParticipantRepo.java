package com.Pergola2.SpringMarriageBook.repository;

import com.Pergola2.SpringMarriageBook.model.Participant;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class ParticipantRepo {


    private JdbcTemplate jdbc;

    private Participant participant;

    public JdbcTemplate getJdbc() {
        return jdbc;
    }

    @Autowired
    public void setJdbc(JdbcTemplate jdbc) {
        this.jdbc = jdbc;
    }



    public void addParticipant(Participant participant) {

        String sql = "INSERT INTO marriagesurvey (id, name, lastname, age, isMarried) VALUES (?, ?, ?, ?, ?)";

        int rows = jdbc.update(sql, participant.getId(), participant.getName(), participant.getLastname(), participant.getAge(), participant.isMarried());

        System.out.println(rows + " rows affected");

        System.out.println("Repo working fine!!!!" + participant);
    }


    public void deleteParticipant(int id) {
        String sql = "DELETE FROM marriagesurvey WHERE id2 = ?";

        int rows = jdbc.update(sql, id);
        System.out.println(rows + " rows affected");
        System.out.println("Deleted participant with id " + id + " successfully");
    }


    public void updateParticipant(int id, String name, String lastname, int age, int id2) {
        String sql = "UPDATE marriagesurvey SET id = ?, name = ?, lastname = ?, age = ? WHERE id = ?";


            int rows = jdbc.update(sql, id, name, lastname, age, id);
            System.out.println(rows + " row affected");


            System.out.println("participant " + id + " added successfully");
            System.out.println();
    }


    public void readParticipant(int id) {
        String sql = "SELECT * FROM marriagesurvey WHERE id = ?";

            // Using BeanPropertyRowMapper to map the result to a Participant object
            Participant participant = jdbc.queryForObject(sql, new Object[]{id}, new BeanPropertyRowMapper<>(Participant.class));

        System.out.println("reading participant details " + participant);
    }
}









