package com.capgemini.wsb.fitnesstracker.training.internal;

import com.capgemini.wsb.fitnesstracker.training.api.Training;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/v1/trainings")

class TrainingController {

    private final TrainingServiceImpl trainingService;
    private final TrainingMapper trainingMapper;

    public TrainingController(TrainingServiceImpl trainingService, TrainingMapper trainingMapper) {
        this.trainingMapper = trainingMapper;
        this.trainingService = trainingService;
    }
    @GetMapping
    public List<TrainingDto> getTrainings() {

        return trainingService.getAllTrainings()
                              .stream()
                              .map(trainingMapper::toDto)
                              .toList();
    }
    @GetMapping("/{userId}")
    public List<TrainingDto> getAllTrainingsForDedicatedUser(@PathVariable Long userId){
        return trainingService.getAllTrainingsForDedicatedUser(userId).map(trainingMapper::toDto).toList(); // TODO: repair

    }

}
