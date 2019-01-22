package com.stackroute.MuzixApplication.seeddata;



import com.stackroute.MuzixApplication.domain.Track;
import com.stackroute.MuzixApplication.repository.TrackRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;


@Configuration
public class SeedDataCmdLineRunner implements CommandLineRunner {
    @Autowired
    private TrackRepository trackRepository;

    @Override
    public void run(String... args) throws Exception {
        trackRepository.save(new Track(4, "D", "abc"));
        trackRepository.save(new Track(5, "E", "def"));
        trackRepository.save(new Track(6, "F", "ghi"));
    }
}

