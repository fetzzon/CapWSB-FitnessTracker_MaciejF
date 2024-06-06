package com.capgemini.wsb.fitnesstracker.training.internal;

import com.capgemini.wsb.fitnesstracker.training.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class TrainingServiceImpl implements TrainingProvider {

    private final TrainingRepository trainingRepository;
    private final TrainingMapper trainingMapper;

    @Autowired
    public TrainingServiceImpl(TrainingRepository trainingRepository, TrainingMapper trainingMapper) {
        this.trainingRepository = trainingRepository;
        this.trainingMapper = trainingMapper;
    }

    @Override
    public Optional<TrainingDto> getTraining(final Long trainingId) {
        return trainingRepository.findById(trainingId)
                .map(trainingMapper::toDto);
    }

    @Override
    public List<TrainingDto> findAllTrainings() {
        return trainingRepository.findAll().stream()
                .map(trainingMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public List<TrainingDto> findTrainingsByUserId(Long userId) {
        return trainingRepository.findByUserId(userId).stream()
                .map(trainingMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public TrainingDto createTraining(TrainingDto trainingDto) {
        Training training = trainingMapper.toEntity(trainingDto);
        Training savedTraining = trainingRepository.save(training);
        return trainingMapper.toDto(savedTraining);
    }

    @Override
    public List<TrainingDto> findTrainingsByActivityType(String activityType) {
        ActivityType activityTypeEnum = ActivityType.valueOf(activityType.toUpperCase());
        return trainingRepository.findAllByActivityType(activityTypeEnum).stream()
                .map(trainingMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public List<TrainingDto> findCompletedTrainingsByDate(Date date) {
        return trainingRepository.findAllByEndTimeBefore(date).stream()
                .map(trainingMapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public TrainingDto updateTraining(Long trainingId, TrainingDto trainingDto) {
        Training training = trainingRepository.findById(trainingId)
                .orElseThrow(() -> new TrainingNotFoundException(trainingId));
        training.setDistance(trainingDto.getDistance());
        // Możesz dodać więcej pól do aktualizacji tutaj
        Training updatedTraining = trainingRepository.save(training);
        return trainingMapper.toDto(updatedTraining);
    }
}
