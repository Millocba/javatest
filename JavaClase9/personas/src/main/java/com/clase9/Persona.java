package com.clase9;

import java.time.LocalDate;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
class Persona {
    private String nombre;
    private String apellido;
    private LocalDate fechaNacimiento;
}