package it.kyaw.myapp.MusicPlayer;

import java.io.Serializable;

public record Data (
        String artistName,
        Integer artistPhoto,
        Integer artistSong
) implements Serializable {
}