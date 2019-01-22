package com.stackroute.MuzixApplication.seeddata;

import com.stackroute.MuzixApplication.domain.Track;
import com.stackroute.MuzixApplication.repository.TrackRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.event.ContextRefreshedEvent;


@Configuration
public class SeedDataApplnListener  implements ApplicationListener<ContextRefreshedEvent>{

    @Autowired
    private TrackRepository trackRepository;    //or u can take object of track services and call .saveTrack method(either way is fine)

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        trackRepository.save(new Track(1,"A","abc"));
        trackRepository.save(new Track(2,"B","def"));
        trackRepository.save(new Track(3,"C","ghi"));
    }
}
