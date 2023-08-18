import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Album arijitAlbum = new Album("Arijit Singh","Arijit's album");
        Album alanWalker = new Album("AlanWalker","AlanWalker's album");

        arijitAlbum.addSongToAlbum("kesaria",3.5);
        arijitAlbum.addSongToAlbum("Tum kya mile",4.2);
        arijitAlbum.addSongToAlbum("lal Ishq",5.1);

        alanWalker.addSongToAlbum("Faded",3.5);
        alanWalker.addSongToAlbum("Alone",4.2);
        alanWalker.addSongToAlbum("Darkside",2.5);

        LinkedList<Song> myplayList = new LinkedList<>();

        System.out.println(arijitAlbum.addToPlayListFromAlbum("kesaria",myplayList));
        System.out.println(alanWalker.addToPlayListFromAlbum(2,myplayList));
        System.out.println(arijitAlbum.addToPlayListFromAlbum(2,myplayList));

        play(myplayList);
    }

    private static void play(LinkedList<Song> myPlayList){

        if(myPlayList.size() == 0){
            System.out.println("Your playlist is empty!!");
            return;
        }


        ListIterator<Song> itr = myPlayList.listIterator();
        System.out.println("Now playing");
        System.out.println(itr.next());
        boolean wasNext = true;

        Scanner sc = new Scanner(System.in);

        printMenu();

        boolean quit = false;
        while(!quit){
            System.out.println("please enter your choice");
            int choice = sc.nextInt();
            switch (choice){
                case 1:
                    printMenu();
                    break;
                case 2:
                    if(wasNext == false){
                        itr.next();
                        wasNext = true;
                    }
                    if(!itr.hasNext()){
                        System.out.println("You have reached the end of the playlist");
                    }else{
                        System.out.println("Currently playing"+itr.next());
                        wasNext = true;
                    }
                    break;
                case 3:
                    if(wasNext == true){
                        itr.previous();
                        wasNext = false;
                    }
                    if(!itr.hasPrevious()){
                        System.out.println("You are at starting of the playlist");
                    }else{
                        System.out.println("currently playing"+itr.previous());
                        wasNext = false;
                    }
                    break;
                case 4:
                    if(wasNext){
                        System.out.println("Currently playing"+itr.previous());
                        wasNext = false;
                    }else{
                        System.out.println("Currently playing"+itr.next());
                        wasNext = true;
                    }
                    break;
                case 5:
                   itr.remove();
                    System.out.println("Song removed");
                    break;
                case 6:
                    printSongs(myPlayList);
                    break;
                case 7:
                    quit = true;
                    break;
                default:
                    System.out.println("Wrong choice please select again");
            }
        }
    }

    private static void printSongs(LinkedList<Song> myPlayList) {
        for(Song song: myPlayList){
            System.out.println(song);
        }
    }


    private static void printMenu(){
        System.out.println("1. show the menu again");
        System.out.println("2. play next song");
        System.out.println("3. play previous song");
        System.out.println("4. play current song again");
        System.out.println("5. Delete current song from playlist");
        System.out.println("6. print all the songs in playlist");
        System.out.println("7. Quit application");
    }
}