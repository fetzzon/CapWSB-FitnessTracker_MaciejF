package com.capgemini.wsb.fitnesstracker.training.internal;

import lombok.Data;

import java.util.Date;

@Data
public class TrainingDto {
    private Long id;
    private Long userId; // ID użytkownika
    private Date startTime;
    private Date endTime;
    private String activityType; // Zmiana na String zamiast ActivityType
    private double distance;
    private double averageSpeed;
}
