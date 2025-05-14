package com.evalia.backEntrevistasInformes.model.ia.informe;

import groovy.transform.ToString;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class InformeGeneradoDTO {
    private String informe;
    private String fortalezas;
    private String debilidades;
}
