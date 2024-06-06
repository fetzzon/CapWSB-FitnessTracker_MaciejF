package com.capgemini.wsb.fitnesstracker.training.internal;

import com.capgemini.wsb.fitnesstracker.training.api.Training;
import com.capgemini.wsb.fitnesstracker.user.api.User;
import com.capgemini.wsb.fitnesstracker.user.api.UserProvider;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class TrainingMapper {

    private final UserProvider userProvider;

    public Training toEntity(TrainingDto trainingDto) {
        User user = userProvider.getUser(trainingDto.getUserId())
                .orElseThrow(() -> new RuntimeException("User not found"));

        return new Training(
                user,
                trainingDto.getStartTime(),
                trainingDto.getEndTime(),
                ActivityType.valueOf(trainingDto.getActivityType().toUpperCase()),
                trainingDto.getDistance(),
                trainingDto.getAverageSpeed()
        );
    }

    public TrainingDto toDto(Training training) {
        TrainingDto trainingDto = new TrainingDto();
        trainingDto.setId(training.getId());
        trainingDto.setUserId(training.getUser().getId());
        trainingDto.setStartTime(training.getStartTime());
        trainingDto.setEndTime(training.getEndTime());
        trainingDto.setActivityType(training.getActivityType().getDisplayName());
        trainingDto.setDistance(training.getDistance());
        trainingDto.setAverageSpeed(training.getAverageSpeed());
        return trainingDto;
    }
}
