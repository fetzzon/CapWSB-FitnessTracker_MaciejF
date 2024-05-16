package com.capgemini.wsb.fitnesstracker.training.api;

import com.capgemini.wsb.fitnesstracker.user.api.User;

import java.util.List;
import java.util.Optional;

// TODO: JAVA doc
public interface TrainingProvider {

    /**
     * Retrieves a training based on their ID.
     * If the user with given ID is not found, then {@link Optional#empty()} will be returned.
     *
     * @param trainingId id of the training to be searched
     * @return An {@link Optional} containing the located Training, or {@link Optional#empty()} if not found
     */
    Optional<User> getTraining(Long trainingId);

    // TODO JavaDoc
    List<Training> getAllTrainings();

    List<Training> getAllTrainingsForDedicatedUser(Long userId);

}
