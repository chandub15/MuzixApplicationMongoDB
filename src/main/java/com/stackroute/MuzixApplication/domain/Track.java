package com.stackroute.MuzixApplication.domain;

import io.swagger.annotations.ApiModelProperty;
import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


// if we use lombok plugin we can use plugins
@Document(value="TrackMongod")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor //instead of getter,setter,allargs,noargs we can use @Data
@ToString
public class Track {
    @Id
    private int id;
    @ApiModelProperty(notes = "Name of the Track")
    private String name;
    @ApiModelProperty(notes = "Comments")
    private String comment;

    public Track(String name, String comment) {
        this.name = name;
        this.comment = comment;
    }
}
