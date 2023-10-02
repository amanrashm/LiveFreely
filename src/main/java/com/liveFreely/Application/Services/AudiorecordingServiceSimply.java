package com.liveFreely.Application.Services;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import javax.sound.sampled.*;
import java.io.File;
import java.io.IOException;

@Service
@Component
public class AudiorecordingServiceSimply implements AudioRecordingService {

    private boolean recording; // Flag to track recording state
    private TargetDataLine targetDataLine; // Audio line for recording
    private final AudioFileFormat.Type audioFileType = AudioFileFormat.Type.WAVE; // Specify the audio file type
    private File recordedAudioFile; // The file to which audio is being recorded

    @Override
    public void startRecording() throws LineUnavailableException, RuntimeException {
        if (!recording) {
            // Set the audio format for recording
            AudioFormat audioFormat = getAudioFormat();

            // Get a mixer that supports the desired audio format
            Mixer.Info[] mixerInfos = AudioSystem.getMixerInfo();
            Mixer mixer = null;
            for (Mixer.Info info : mixerInfos) {
                mixer = AudioSystem.getMixer(info);
                if (mixer.isLineSupported(new DataLine.Info(TargetDataLine.class, audioFormat))) {
                    break;
                }
            }

            // Open the audio line for recording
            assert mixer != null;
            try {
                targetDataLine = (TargetDataLine) mixer.getLine(new DataLine.Info(TargetDataLine.class, audioFormat));
            } catch (LineUnavailableException e) {
                throw new RuntimeException(e);
            }
            targetDataLine.open(audioFormat);
            targetDataLine.start();

            // Create a new thread for recording
            Thread recordingThread = new Thread(() -> {
                recording = true;
                System.out.println("Started audio recording.");
                try {
                    // Create an audio input stream from the target data line
                    AudioInputStream audioInputStream = new AudioInputStream(targetDataLine);

                    // Specify the file where the recorded audio will be saved
                    recordedAudioFile = new File("recorded_audio.wav");

                    // Write the audio data to the file
                    AudioSystem.write(audioInputStream, audioFileType, recordedAudioFile);
                } catch (IOException e) {
                    e.printStackTrace();
                } finally {
                    // Clean up resources after recording is complete
                    targetDataLine.close();
                    recording = false;
                    System.out.println("Stopped audio recording.");
                }
            });
            recordingThread.start();
        } else {
            System.out.println("Recording is already in progress.");
        }
    }

    private AudioFormat getAudioFormat() {
        float sampleRate = 44100; // Sample rate in Hz
        int sampleSizeInBits = 16; // Bits per sample
        int channels = 1; // Mono audio
        boolean signed = true; // Signed audio data (true for PCM)
        boolean bigEndian = false; // Little-endian byte order

        return new AudioFormat(sampleRate, sampleSizeInBits, channels, signed, bigEndian);
    }

    @Override
    public void stopRecording() {
        if (recording) {
            // Stop the recording thread and clean up resources
            if (targetDataLine != null) {
                targetDataLine.stop();
                targetDataLine.close();
            }
            recording = false; // Set the recording flag to false
            System.out.println("Stopped audio recording.");
        } else {
            System.out.println("No recording in progress to stop.");
        }
    }

    @Override
    public boolean isRecording() {
        return recording;
    }

    @Override
    public void saveRecording(String filePath) {
        if (recording) {
            System.out.println("Cannot save while recording is in progress.");
        } else {
            if (recordedAudioFile != null && recordedAudioFile.exists()) {
                File destinationFile = new File(filePath);

                try {
                    // Use Files.copy to copy the recorded audio file to the destination
                    java.nio.file.Files.copy(recordedAudioFile.toPath(), destinationFile.toPath());

                    if (destinationFile.exists()) {
                        System.out.println("Saved the recorded audio to: " + filePath);
                    } else {
                        System.out.println("Failed to save the recorded audio.");
                    }
                } catch (IOException e) {
                    System.err.println("Error while saving the recorded audio: " + e.getMessage());
                }
            } else {
                System.out.println("No recorded audio file to save.");
            }
        }
    }
}
