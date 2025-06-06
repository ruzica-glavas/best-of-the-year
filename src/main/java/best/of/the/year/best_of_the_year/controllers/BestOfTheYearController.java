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




@Controller
@RequestMapping("/")

public class BestOfTheYearController {

    @GetMapping
    public String home(Model model) {
        model.addAttribute("name" , "Ruzi");
        return "index";
    }

    @GetMapping("/string/movies")
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

    @GetMapping("/string/songs")
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
    
    @GetMapping("/movies")
    public String moviesList(Model model) {
        model.addAttribute("titolo", "Movies");
        model.addAttribute("list", getBestMovies());
        return "list";
    }

    @GetMapping("/songs")
    public String songsList(Model model) {
        model.addAttribute("titolo", "Songs");
        model.addAttribute("list", getBestSongs());
        return "list";
    }
    
    
    @GetMapping("/movies/{id}")
    public String moviedetail(@PathVariable ("id") int movieId, Model model) {
        Movie movieFound = null;
        for(Movie movie : getBestMovies()){
            if(movie.getId()== (movieId)){
                movieFound=movie;
                break;
            }
        }
        model.addAttribute("id",movieId);
        model.addAttribute("item", movieFound);
        return "detail";
    }
    
    @GetMapping("/songs/{id}")
    public String songDetail(@PathVariable ("id") int songId, Model model) {
        Song songFound = null;

        for(Song song : getBestSongs()){
            if(song.getId() == (songId)){
                songFound=song;
                break;
            }
        }
        model.addAttribute("id",songId);
        model.addAttribute("item", songFound);
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
        songs.add(new Song(4, "We are the champions"));
        songs.add(new Song(5, "Waka Waka"));
        return songs;
    };
}
