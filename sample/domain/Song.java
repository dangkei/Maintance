package domain;
import java.util.ArrayList;
import java.util.List;

public class Song {
    private String name;
    private Song nextSong;

    public Song(String name) {
        this.name = name;
    }

    public void setNextSong(Song nextSong) {
        this.nextSong = nextSong;
    }

    public boolean isRepeatingPlaylist() {
        List<Song> songList = new ArrayList<Song>();
        Song thisSong;
        if(null==nextSong){ 
            return false;
        }else {
        	thisSong = nextSong;
        }
        
        while(null!=thisSong.nextSong){
        	if(thisSong.name==this.name) {return true;}
            thisSong=thisSong.nextSong;
        }
		return false;

    }

    public static void main(String[] args) {
        Song first = new Song("Hello");
        Song second = new Song("Eye of the tiger");

        first.setNextSong(second);
        second.setNextSong(first);

        System.out.println(first.isRepeatingPlaylist());
    }
}