package com.capgemini.wsb.fitnesstracker.training.internal;

import com.capgemini.wsb.fitnesstracker.training.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/trainings")
public class TrainingController {

    private final TrainingProvider trainingProvider;

    @Autowired
    public TrainingController(TrainingProvider trainingProvider) {
        this.trainingProvider = trainingProvider;
    }

    @GetMapping
    public ResponseEntity<List<TrainingDto>> getAllTrainings() {
        return ResponseEntity.ok(trainingProvider.findAllTrainings());
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<List<TrainingDto>> getTrainingsByUserId(@PathVariable Long userId) {
        return ResponseEntity.ok(trainingProvider.findTrainingsByUserId(userId));
    }

    @PostMapping
    public ResponseEntity<TrainingDto> createTraining(@RequestBody TrainingDto trainingDto) {
        return ResponseEntity.status(201).body(trainingProvider.createTraining(trainingDto));
    }

    @GetMapping("/activity/{activityType}")
    public ResponseEntity<List<TrainingDto>> getTrainingsByActivityType(@PathVariable String activityType) {
        return ResponseEntity.ok(trainingProvider.findTrainingsByActivityType(activityType));
    }

    @GetMapping("/completed")
    public ResponseEntity<List<TrainingDto>> getCompletedTrainingsByDate(@RequestParam Date date) {
        return ResponseEntity.ok(trainingProvider.findCompletedTrainingsByDate(date));
    }

    @PutMapping("/{trainingId}")
    public ResponseEntity<TrainingDto> updateTraining(@PathVariable Long trainingId, @RequestBody TrainingDto trainingDto) {
        return ResponseEntity.ok(trainingProvider.updateTraining(trainingId, trainingDto));
    }
}
