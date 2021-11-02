package ua.konstantynov.hw26.service;

import ua.konstantynov.hw26.dao.AlbumDao;
import ua.konstantynov.hw26.entities.Album;

import java.util.List;

public class AlbumService {
    private static final AlbumDao ALBUM_DAO = new AlbumDao();

    public void save(Album album) {
        ALBUM_DAO.save(album);
    }

    public void update(Album album) {
        ALBUM_DAO.update(album);
    }

    public void delete(String id) {
        ALBUM_DAO.delete(id);
    }

    public Album get(String id) {
        return ALBUM_DAO.get(id);
    }

    public List<Album> getAll() {
        return ALBUM_DAO.getAll();
    }

    public void saveRandom(int count) {
        ALBUM_DAO.saveRandom(count);
    }
}
