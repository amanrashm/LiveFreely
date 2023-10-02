
package com.liveFreely.Application.Entity;

import jakarta.persistence.Id;
import jakarta.persistence.Table;

import jakarta.persistence.*;
import java.util.Date;

@Entity
@Table(name = "audio_recording") // Specify the table name explicitly
public class AudioRecording {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private UserEntity user;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "recording_date") // Specify the column name explicitly
    private Date recordingDate;

    @Column(name = "call_duration_in_seconds") // Specify the column name explicitly
    private int callDuration;

    // Constructors
    public AudioRecording() {
        // Default constructor
    }

    public AudioRecording(Long id, UserEntity user, Date recordingDate, int callDurationInSeconds) {
        this.id = id;
        this.user = user;
        this.recordingDate = recordingDate;
        this.callDuration = callDurationInSeconds;
    }

    // Getters and setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public UserEntity getUser() {
        return user;
    }

    public void setUser(UserEntity user) {
        this.user = user;
    }

    public Date getRecordingDate() {
        return recordingDate;
    }

    public void setRecordingDate(Date recordingDate) {
        this.recordingDate = recordingDate;
    }

    public int getCallDurationInSeconds() {
        return callDuration;
    }

    public void setCallDurationInSeconds(int callDurationInSeconds) {
        this.callDuration = callDurationInSeconds;
    }

    // You can add other properties, methods, and annotations as needed
}