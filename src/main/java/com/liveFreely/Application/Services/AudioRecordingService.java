package com.liveFreely.Application.Services;

import org.springframework.stereotype.Repository;

import javax.sound.sampled.LineUnavailableException;
import java.io.IOException;

@Repository
public interface AudioRecordingService {

    // Method to start recording audio
    void startRecording() throws IOException, LineUnavailableException, RuntimeException;

    // Method to stop recording audio
    void stopRecording();

    // Method to check if recording is in progress
    boolean isRecording();

    // Method to save the recorded audio
    void saveRecording(String filePath);
}
