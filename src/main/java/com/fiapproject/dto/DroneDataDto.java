package com.fiapproject.dto;

import lombok.*;

import java.io.Serial;
import java.io.Serializable;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class DroneDataDto implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    private Long id;
    private Float latitude;
    private Float longitude;
    private Integer temperatura;
    private Double umidade;
    private Boolean rastreamento;

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb
                .append("Drone ").append(id).append("\n")
                .append("Latitude ").append(latitude).append("\n")
                .append("Longitude ").append(longitude).append("\n")
                .append("Temperatura ").append(temperatura).append("\n")
                .append("Umidade ").append(umidade).append("\n")
                .append("Rastreamento ").append(rastreamento).append("\n");
        return sb.toString();
    }
}
