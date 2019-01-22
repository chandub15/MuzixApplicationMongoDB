package com.stackroute.MuzixApplication.seedComponent;

import com.stackroute.MuzixApplication.domain.Track;
import com.stackroute.MuzixApplication.repository.TrackRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Order(2)
public class SeedApplicationRunner implements ApplicationRunner {

    @Autowired
    private TrackRepository trackRepository;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        trackRepository.save(new Track("A","abc"));
        trackRepository.save(new Track("B","def"));
        trackRepository.save(new Track("C","ghi"));
    }
}
