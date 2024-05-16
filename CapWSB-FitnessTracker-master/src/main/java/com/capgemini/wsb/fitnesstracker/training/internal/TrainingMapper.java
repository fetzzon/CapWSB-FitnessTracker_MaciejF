package com.capgemini.wsb.fitnesstracker.training.internal;

import com.capgemini.wsb.fitnesstracker.training.api.Training;
import com.capgemini.wsb.fitnesstracker.user.api.UserMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor

public class TrainingMapper {

    public final UserMapper userMapper;

    TrainingDto toDto(Training training) {

        TrainingDto trainingDto = new TrainingDto();

        trainingDto.setUser(userMapper.toDto(training.getUser()));
        trainingDto.setId(training.getId());
        trainingDto.setStartTime(training.getStartTime());
        trainingDto.setEndTime(training.getEndTime());
        trainingDto.setActivityType(training.getActivityType());
        trainingDto.setDistance(training.getDistance());
        trainingDto.setAverageSpeed(training.getAverageSpeed());

        return trainingDto;
    }
}
