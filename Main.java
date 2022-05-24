package Responsi;

public class Main {
    public static void main(String[] args) {
        MovieView mv = new MovieView();
        ModelMovie mm = new ModelMovie();
        ControllerMovie cm = new ControllerMovie(mm, mv);
    }
}
