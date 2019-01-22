package com.stackroute.MuzixApplication.Controller;

import com.stackroute.MuzixApplication.domain.Track;
import com.stackroute.MuzixApplication.exceptions.NullValuesPassed;
import com.stackroute.MuzixApplication.exceptions.TrackAlreadyExists;
import com.stackroute.MuzixApplication.exceptions.TrackDoesNotExists;
import com.stackroute.MuzixApplication.service.TrackService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "api/v1")
@Api(value = "Track Service ", description = "tracks")
public class TrackController {


    private TrackService trackService;
    private Track track;
    private GlobalExceptionHandler globalExceptionHandler;

    @Autowired
    public TrackController(TrackService trackService){
        this.trackService=trackService;
    }

    @ApiOperation(value = "posts tracks")
    @ApiResponses(
            value = {
                    @ApiResponse(code = 100, message = "100 is the message"),
                    @ApiResponse(code = 200, message = "Successfully posted")
            }
    )
    @PostMapping("track")
    public ResponseEntity<?> saveTrack(@RequestBody Track track) throws TrackAlreadyExists, NullValuesPassed {
        ResponseEntity responseEntity;
        Track savedTrack =trackService.saveTrack(track);
        responseEntity= new ResponseEntity<Track>(savedTrack, HttpStatus.CREATED);
        return responseEntity;
    }

    @ApiOperation(value = "Gets all tracks")
    @GetMapping("track")
    public ResponseEntity<?> getAllTracks(){
        return new ResponseEntity<List<Track>>(trackService.getAllTracks(),HttpStatus.OK);
    }

    @ApiOperation(value = "updates the tracks")
    @PutMapping("track")
    public ResponseEntity<?> updateTrack(@RequestBody Track track)throws TrackDoesNotExists {
        ResponseEntity responseEntity;
        Track updatedTrack = trackService.updateTrack(track);
        responseEntity= new ResponseEntity<Track>(updatedTrack, HttpStatus.CREATED);
        return responseEntity;
    }


    @DeleteMapping("track/{id}")
    public ResponseEntity<?> deleteTrack(@PathVariable("id") int trackId) throws TrackDoesNotExists {
        ResponseEntity responseEntity;
        Track track = trackService.deleteTrack(trackId);
        responseEntity= new ResponseEntity<Track>(track, HttpStatus.CREATED);
        return responseEntity;
    }
}
