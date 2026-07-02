package com.karthik.relationship.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name="clubs")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class StudentClub {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name="student_club_jpa_seq",sequenceName = "student_club_jpa_seq",allocationSize=1,initialValue=1)
    private long clubId;
    private String clubName;

    @OneToOne(cascade = CascadeType.ALL,fetch= FetchType.EAGER)
    @JoinColumn(name="head_of_club_student_id",referencedColumnName = "id")
    private Student headOfClub;

    @ManyToMany(mappedBy="studentClubs",fetch=FetchType.EAGER)
    private List<Student>  students;

}
