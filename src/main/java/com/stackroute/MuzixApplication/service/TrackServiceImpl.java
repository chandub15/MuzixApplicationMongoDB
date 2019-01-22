package com.stackroute.MuzixApplication.service;

import com.stackroute.MuzixApplication.domain.Track;
import com.stackroute.MuzixApplication.exceptions.NullValuesPassed;
import com.stackroute.MuzixApplication.exceptions.TrackAlreadyExists;
import com.stackroute.MuzixApplication.exceptions.TrackDoesNotExists;

import com.stackroute.MuzixApplication.repository.TrackRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service//added new after error
public class TrackServiceImpl  implements  TrackService{

    private  TrackRepository trackRepository;
    private Track track;

    @Autowired
    public  TrackServiceImpl(TrackRepository trackRepository) {
        this.trackRepository=trackRepository;
    }
    @Override
    public Track saveTrack(Track track) throws TrackAlreadyExists, NullValuesPassed {

        if(trackRepository.existsById(track.getId())){
            throw new TrackAlreadyExists("Track already exists");
        }
        if(track.getName() == null && track.getComment() == null){
            throw new NullValuesPassed("Null values passed");
        }
        Track savedTrack = trackRepository.save(track);
        return savedTrack;
    }

    @Override
    public List<Track> getAllTracks() {
        return  trackRepository.findAll();
    }

    @Override
    public Track getTrackById(int trackId) throws TrackDoesNotExists {
        if(trackRepository.existsById(trackId)){
            return trackRepository.findById(trackId).get();
        }
        else{
            throw new TrackDoesNotExists("Track does not exists");
        }

    }

    @Override
    public Track updateTrack(Track track)throws TrackDoesNotExists {

        if (trackRepository.existsById(track.getId())) {
            trackRepository.findById(track.getId()).get();
            track.setId(track.getId());
            if (track.getName() != null && track.getName() != "") {
                track.setName(track.getName());
            }
            if (track.getComment() != null && track.getComment() != "") {
                track.setComment(track.getComment());
            }
            trackRepository.save(track);
            return track;
        } else {
            throw new TrackDoesNotExists("Track does not exits");
        }
    }

    @Override
    public Track deleteTrack(int trackId) throws TrackDoesNotExists {

              if (trackRepository.existsById(trackId)) {
                Track deletedTrack = getTrackById(trackId); //storing the track to be deleted in a variable
                trackRepository.deleteById(trackId);
                return deletedTrack;
            } else {
                throw new TrackDoesNotExists("Track does not exits");
            }



    }


}
