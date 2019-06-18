package com.s15920.model;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Musician {
    private int musicianId;
    private String songs;
    private Integer concertId;

    @Id
    @Column(name = "musician_id", nullable = false)
    public int getMusicianId() {
        return musicianId;
    }

    public void setMusicianId(int musicianId) {
        this.musicianId = musicianId;
    }

    @Basic
    @Column(name = "songs", nullable = true, length = 300)
    public String getSongs() {
        return songs;
    }

    public void setSongs(String songs) {
        this.songs = songs;
    }

    @Basic
    @Column(name = "concert_id", nullable = true)
    public Integer getConcertId() {
        return concertId;
    }

    public void setConcertId(Integer concertId) {
        this.concertId = concertId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Musician musician = (Musician) o;

        if (musicianId != musician.musicianId) return false;
        if (songs != null ? !songs.equals(musician.songs) : musician.songs != null) return false;
        if (concertId != null ? !concertId.equals(musician.concertId) : musician.concertId != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = musicianId;
        result = 31 * result + (songs != null ? songs.hashCode() : 0);
        result = 31 * result + (concertId != null ? concertId.hashCode() : 0);
        return result;
    }
}
