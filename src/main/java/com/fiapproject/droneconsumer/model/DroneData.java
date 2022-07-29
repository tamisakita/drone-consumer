package com.fiapproject.droneconsumer.model;

import lombok.*;

import java.io.Serializable;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class DroneData implements Serializable {

    private Long id_drone;
    private Float latitude;
    private Float longitude;
    private Integer temperatura;
    private Double umidade;
    private Boolean rastreamento;
}
