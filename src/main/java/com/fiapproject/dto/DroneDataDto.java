package com.fiapproject.dto;

import lombok.*;

import java.io.Serializable;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class DroneDataDto implements Serializable {
    private static final long serialVersionUID = 1L;

    private Long id_drone;
    private Float latitude;
    private Float longitude;
    private Integer temperatura;
    private Double umidade;
    private Boolean rastreamento;
}
