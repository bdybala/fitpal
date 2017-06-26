package com.example.fitpal.services;

import com.example.fitpal.dtos.InputDataDto;

public interface CalculationsService {

    Integer calculateKcal(InputDataDto inputDataDto);
}
