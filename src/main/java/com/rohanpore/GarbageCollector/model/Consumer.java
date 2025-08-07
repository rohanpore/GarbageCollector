package com.rohanpore.GarbageCollector.model;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Consumer {

    @NotNull
    private Integer id;

    @NotBlank(message = "{consumer.name.missing}")
    private String name;

    @Email(message = "{consumer.email.invalid}")
    @NotNull(message = "{consumer.email.missing}")
    private String email;

    @Pattern(regexp = "^\\d{10}$", message = "{consumer.phone.invalid}")
    private String contact;

    @Pattern(regexp = "Pune|Bangalore|Delhi|Kolkata", message = "{consumer.location.invalid}")
    private String location;

}
