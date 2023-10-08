package com.liveFreely.Application.Repositories;

import com.liveFreely.Application.Entity.AudioRecording;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.Date;
import java.util.List;

@Repository
public abstract class AudioRecordingRepositorySimply implements AudioRecordingRepository {

    @PersistenceContext
    private EntityManager entityManager;

    public List<AudioRecording> findByUser(User user) {
        TypedQuery<AudioRecording> query = entityManager.createQuery(
                "SELECT ar FROM AudioRecording ar WHERE ar.user = :user",
                AudioRecording.class
        );
        query.setParameter("user", user);
        return query.getResultList();
    }

    public List<AudioRecording> findByUserAndRecordingDateBetween(User user, Date startDate, Date endDate) {
        TypedQuery<AudioRecording> query = entityManager.createQuery(
                "SELECT ar FROM AudioRecording ar " +
                        "WHERE ar.user = :user " +
                        "AND ar.recordingDate BETWEEN :startDate AND :endDate",
                AudioRecording.class
        );
        query.setParameter("user", user);
        query.setParameter("startDate", startDate);
        query.setParameter("endDate", endDate);
        return query.getResultList();
    }

    public List<AudioRecording> findByUserAndCallDurationGreaterThan(User user, int durationInSeconds) {
        TypedQuery<AudioRecording> query = entityManager.createQuery(
                "SELECT ar FROM AudioRecording ar " +
                        "WHERE ar.user = :user " +
                        "AND ar.callDuration > :durationInSeconds",
                AudioRecording.class
        );
        query.setParameter("user", user);
        query.setParameter("durationInSeconds", durationInSeconds);
        return query.getResultList();
    }
}
