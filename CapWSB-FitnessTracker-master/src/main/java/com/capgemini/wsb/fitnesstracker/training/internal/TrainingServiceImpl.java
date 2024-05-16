package com.capgemini.wsb.fitnesstracker.training.internal;

import com.capgemini.wsb.fitnesstracker.training.api.Training;
import com.capgemini.wsb.fitnesstracker.training.api.TrainingProvider;
import com.capgemini.wsb.fitnesstracker.user.api.User;
import com.capgemini.wsb.fitnesstracker.user.api.UserProvider;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

// TODO: Provide Impl
@Service
@AllArgsConstructor

class TrainingServiceImpl implements TrainingProvider {

    private final TrainingRepository trainingRepository;
    private final UserProvider userProvider;
    TrainingServiceImpl(TrainingRepository trainingRepository, UserProvider userProvider) {
        this.trainingRepository = trainingRepository;
        this.userProvider = userProvider;
    }

    @Override
    public Optional<User> getTraining(final Long trainingId) {
        throw new UnsupportedOperationException("Not finished yet");
    }

    @Override
    public List<Training> getAllTrainings() {
        return trainingRepository.findAll();
    }

    //TODO: repair
    @Override
    public List<Training> getAllTrainingsForDedicatedUser(Long userId) {

        if (userProvider.getUser(userId).isPresent()) {
            return trainingRepository.findAll().stream().filter(training -> training.getUser().getId().equals(userId)).toList();
        }
        else {
            return List.of();
        }
    }

}
