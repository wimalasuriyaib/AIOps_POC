package com.aiopshackathon.carreservation.locationservice.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class LocationResponse {
    private int id;
    private String locationName;
    private String locationAddress;
    private String locationUuid;
}
