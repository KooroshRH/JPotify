package Data;

import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.util.ArrayList;

public class Album extends Library {
    private ArrayList<Library> musics;
    private static ArrayList<Library> albums  = new ArrayList<>();

    public Album(String name) {
        super.name = name;
        musics = new ArrayList<>();
        albums.add(this);
    }

    private void addMusic(Music music){
        musics.add(music);
    }

    public String getAlbumName() {
        return name;
    }

    private void setImage(Image image) {
        this.image = image;
    }

    public Image getImage(){
        return image;
    }

    public static void addMusicToAlbum(Music music) throws IOException {
        for (Library album : albums){
            if (((Album)album).getAlbumName().equals(music.getAlbum())){
                ((Album)album).addMusic(music);
                return;
            }
        }
        Album album = new Album("" + music.getAlbum());
        album.addMusic(music);
        album.setImage(music.getAlbumArt());
        album.setIcon(new ImageIcon(album.getImage().getScaledInstance(120, 120, Image.SCALE_SMOOTH)));
    }

    public static ArrayList<Library> getAlbums() {
        return albums;
    }

    public ArrayList<Library> getMusics() {
        return musics;
    }
}
