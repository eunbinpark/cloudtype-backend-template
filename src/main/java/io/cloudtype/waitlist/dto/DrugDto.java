package io.cloudtype.waitlist.dto;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class DrugDto {
    private String ingredient;
    private String ddi;
    private String efficacy;
}
