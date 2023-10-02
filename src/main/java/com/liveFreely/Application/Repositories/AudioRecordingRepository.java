package com.liveFreely.Application.Repositories;

import com.liveFreely.Application.Entity.AudioRecording;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.security.core.userdetails.User;
import java.util.Date;
import java.util.List;

@Repository
public interface AudioRecordingRepository extends JpaRepository<AudioRecording, Long> {

    // Find audio recordings by user
    List<AudioRecording> findByUser(User user);

    // Find audio recordings by user and recording date range
    List<AudioRecording> findByUserAndRecordingDateBetween(User user, Date startDate, Date endDate);

    // Find audio recordings by user and call duration greater than a specific duration
    List<AudioRecording> findByUserAndCallDurationGreaterThan(User user, int durationInSeconds);

    // Add more custom query methods as needed based on your application's requirements

    // For example, you can add a query method to find audio recordings by a specific attribute:
    // List<AudioRecording> findBySomeAttribute(String attribute);
}
