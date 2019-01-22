package com.stackroute.MuzixApplication.service;

import com.stackroute.MuzixApplication.domain.Track;
import com.stackroute.MuzixApplication.exceptions.NullValuesPassed;
import com.stackroute.MuzixApplication.exceptions.TrackAlreadyExists;
import com.stackroute.MuzixApplication.exceptions.TrackDoesNotExists;


import java.util.List;

public interface TrackService {

    public Track saveTrack(Track track) throws TrackAlreadyExists, NullValuesPassed;

    public List<Track> getAllTracks();

    public Track getTrackById(int trackId) throws TrackDoesNotExists;

    public Track updateTrack(Track track) throws TrackDoesNotExists;

    public Track deleteTrack(int id)throws TrackDoesNotExists;
}

