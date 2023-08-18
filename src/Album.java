import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Album {

    private String artistName;

    private String name;

    private List<Song> songs;

    public Album() {
    }

    public Album(String artistName, String name) {
        this.artistName = artistName;
        this.name = name;
        this.songs = new ArrayList<>();
    }

    public String getArtistName() {
        return artistName;
    }

    public void setArtistName(String artistName) {
        this.artistName = artistName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Song> getSongs() {
        return songs;
    }

    public void setSongs(List<Song> songs) {
        this.songs = songs;
    }

    //functionalities in album

    boolean findSong(String title){
        for(Song song: songs){
            if(song.getTitle().equalsIgnoreCase(title)) return true;
        }
        return false;
    }

    //add song
   String addSongToAlbum(String title, double duration){
       if(!findSong(title)){
           //add
           Song song = new Song(title,duration);
           this.songs.add(song);
           return "Song has been added to Album";
       }
       return "Song already exist!";
   }

   //add to playlist from album
    String addToPlayListFromAlbum(String title, LinkedList<Song> playlist){

            //add in playlist
            for(Song song: this.songs){
                if(song.getTitle().equals(title)){
                    playlist.add(song);
                    return "Song has been added to your playlist";
                }
            }

        return "Song doesn't exist in album";
    }



    /**
     * polymorphism(method overloading)
     * @param songNo
     * @param playlist
     * @return
     */
    public String addToPlayListFromAlbum(int songNo,LinkedList<Song> playlist){
        int index = songNo - 1;
        if(index >= 0 && index < songs.size()){
            playlist.add(songs.get(index));
            return "Song has been added to your playlist";
        }
        return "Incorrect song number!";
    }

}
