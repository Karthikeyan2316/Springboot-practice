package com.karthik.relationship.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AddClubToStudentDto {
    private long studentId;
    private List<Integer> clubIds;

}
