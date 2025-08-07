package com.rohanpore.GarbageCollector.model;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Collector {

    @NotNull
    private Integer id;

    @NotBlank(message = "{collector.name.missing}")
    private String name;

    @Pattern(regexp = "^\\d{10}$", message = "{collector.phone.invalid}")
    private String contact;

    private String Status;

    private Integer numberOfPickups;

}
