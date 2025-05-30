package best.of.the.year.best_of_the_year.controllers;
import best.of.the.year.best_of_the_year.classes.Movie;
import best.of.the.year.best_of_the_year.classes.Song;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestParam;



@Controller
@RequestMapping("/")

public class BestOfTheYearController {

    @GetMapping
    public String home(Model model) {
        model.addAttribute("name" , "Ruzi");
        return "index";
    }

    @GetMapping("/movies")
    public String movieString(Model model) {
        String names = "";

        for(Movie movie : getBestMovies()){
            names += movie.getTitolo() + ", ";
        }

        names = names.substring(0, names.length()-2);
        model.addAttribute("titolo", "Movies");
        model.addAttribute("names", names);
        return "listAsString";
        
    }

    @GetMapping("/songs")
    public String songString(Model model) {
        String names= "";
        for (Song song: getBestSongs()){
            names += song.getTitolo() + ", ";
        }

        names = (names.substring(0, names.length()-2));
        model.addAttribute("titolo", "Songs");
        model.addAttribute("names", names);
        return "listAsString";
    }
    
    @GetMapping("/movies/{id}")
    public String moviedetail(@PathVariable ("id") String movieId, Model model) {
        model.addAttribute(movieId);
        return "detail";
    }
    


    
    private List<Movie> getBestMovies(){
        List <Movie> movies = new ArrayList<>();
        movies.add(new Movie(1, "Interstellar"));
        movies.add(new Movie(2, "Inception"));
        movies.add(new Movie(3, "The Matrix"));
        movies.add(new Movie(4, "Titanic"));
        movies.add(new Movie(5, "Terminator"));


        return movies;
    };

    private List<Song> getBestSongs(){
        List <Song> songs = new ArrayList<>();
        songs.add(new Song(1, "Bohemian Rhapsody"));
        songs.add(new Song(2, "Imagine"));
        songs.add(new Song(3, "Smells Like Teen Spirit"));
        songs.add(new Song(4, "We are the champios"));
        songs.add(new Song(5, "Waka Waka"));
        return songs;
    };
}
