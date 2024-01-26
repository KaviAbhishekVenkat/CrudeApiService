package com.kav.CrudeApiService.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class TodosDto {
    String userId;
    String id;
    String title;
    boolean completed;
}
