package com.karthik.relationship.model;

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
@Table(name="coordinator")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class,property = "coordinatorId")
public class Coordinator {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name="coordinator_jpa_seq",sequenceName = "coordinator_db_seq",allocationSize=5,initialValue=1)
    private long coordinatorId;
    private String name;
    private String email;

    @OneToMany(mappedBy = "coordinator",cascade = CascadeType.ALL, orphanRemoval = false,fetch= FetchType.EAGER)

    private List<Student> students;

}
