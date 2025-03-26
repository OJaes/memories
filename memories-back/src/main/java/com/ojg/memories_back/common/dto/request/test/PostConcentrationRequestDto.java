package com.ojg.memories_back.common.dto.request.test;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PostConcentrationRequestDto {
    @NotNull
    @Min(0)
    Integer measurementScore;

    @NotNull
    Integer errorCount;
     
}