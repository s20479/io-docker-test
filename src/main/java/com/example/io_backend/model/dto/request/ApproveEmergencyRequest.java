package com.example.io_backend.model.dto.request;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class ApproveEmergencyRequest {
    List<Integer> ambulanceIds;
}
