package com.musesite.restful;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Association {

    private final long albumId;
    private final long bandId;

    @JsonCreator
    Association(
            @JsonProperty("albumId")
            long albumId,
            @JsonProperty("bandId")
            long bandId) {

        this.albumId = albumId;
        this.bandId = bandId;
    }
}
