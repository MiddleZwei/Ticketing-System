package com.s15920.service;

import com.s15920.model.Manager;
import com.s15920.model.Musician;

public interface IMusicianService {
    void saveOrUpdate(Musician musician);
    void delete(Musician musician);

    Musician findMusicianById(Integer id);
//    void addSong(Song song);
}
