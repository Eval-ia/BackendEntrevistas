package com.evalia.backEntrevistasInformes.model.ia.informe;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class InformeGeneradoDTO {
    private String informe;
    private String fortalezas;
    private String debilidades;
}
