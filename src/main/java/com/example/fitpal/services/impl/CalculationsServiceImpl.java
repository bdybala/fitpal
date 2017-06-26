package com.example.fitpal.services.impl;

import com.example.fitpal.dtos.InputDataDto;
import com.example.fitpal.services.CalculationsService;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

@Service
@Primary
public class CalculationsServiceImpl implements CalculationsService {

    @Override
    public Integer calculateKcal(InputDataDto inputDataDto) {
        return 1000 * Double.valueOf(Math.random()).intValue();
    }
}
