package com.capgemini.wsb.fitnesstracker.training.api;

import com.capgemini.wsb.fitnesstracker.training.internal.TrainingDto;

import java.util.Date;
import java.util.List;
import java.util.Optional;

public interface TrainingProvider {

    Optional<TrainingDto> getTraining(Long trainingId);

    List<TrainingDto> findAllTrainings();

    List<TrainingDto> findTrainingsByUserId(Long userId);

    TrainingDto createTraining(TrainingDto trainingDto);

    List<TrainingDto> findTrainingsByActivityType(String activityType);

    List<TrainingDto> findCompletedTrainingsByDate(Date date);

    TrainingDto updateTraining(Long trainingId, TrainingDto trainingDto);
}
