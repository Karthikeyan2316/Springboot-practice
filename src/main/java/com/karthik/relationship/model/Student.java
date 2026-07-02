package com.karthik.relationship.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name="Student")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class,property = "id")
public class Student {

    @Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE)
    @SequenceGenerator(name = "student_jpa_seq",sequenceName = "student_db_seq",allocationSize=5,initialValue=1)
    private long id;
    private String firstName;
    private String lastName;
    private String email;

    @OneToOne(cascade= CascadeType.ALL,fetch = FetchType.EAGER)

    private Address address;

    @ManyToOne
    @JoinColumn(name="student_coordinator_id",referencedColumnName = "coordinatorId")
    private Coordinator coordinator;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "student_club",
            joinColumns={@JoinColumn(name="student_id",referencedColumnName = "id")},
            inverseJoinColumns = {@JoinColumn(name="club_id",referencedColumnName = "clubId")}
    )
    private List<StudentClub> studentClubs;

    @OneToOne(mappedBy = "headOfClub")
    private StudentClub headOfClub;

}
