package com.ojg.memories_back.common.dto.request.openai;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.Getter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class GetWayRequestDto {
    @NotBlank
    @Pattern(regexp = "^(기억력|집중력)$")
    private String type;
}
