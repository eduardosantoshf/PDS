package lab5_03;

import java.util.List;

public class Movie {
    private final String movieTitle;
    private final int movieYear;
    private final Person movieDirector;
    private final Person movieWriter;
    private final String movieSeries;
    private final List<Person> movieCast;
    private final List<Place> movieLocations;
    private final List<String> movieLanguages;
    private final List<String> movieGenres;
    private final boolean television;
    private final boolean netflix;
    private final boolean independent;

    public static class Builder {

        private String movieTitle;
        private int movieYear;
        private Person movieDirector = null;
        private Person movieWriter = null;
        private String movieSeries = null;
        private List<Person> movieCast = null;
        private List<Place> movieLocations = null;
        private List<String> movieLanguages = null;
        private List<String> movieGenres = null;
        private boolean television;
        private boolean netflix;
        private boolean independent;

        public Builder (String movieTitle, int movieYear) {
            this.movieTitle = movieTitle;
            this.movieYear = movieYear;
        }

        public Builder movieDirector(String s) {
            this.movieDirector = movieDirector;
            return this;
        }

        public Builder movieWriter(String s) {
            this.movieWriter = movieWriter;
            return this;
        }

        public Builder movieSeries(String s) {
            this.movieSeries = movieSeries;
            return this;
        }

        public Builder movieCast(String s) {
            this.movieCast = movieCast;
            return this;
        }

        public Builder movieLocations(String s) {
            this.movieLocations = movieLocations;
            return this;
        }

        public Builder movieLanguages(String s) {
            this.movieLanguages = movieLanguages;
            return this;
        }

        public Builder movieGenres(String s) {
            this.movieGenres = movieGenres;
            return this;
        }

        public Builder television(String s) {
            this.television = television;
            return this;
        }

        public Builder netflix(String s) {
            this.netflix = netflix;
            return this;
        }

        public Builder independent(String s) {
            this.independent = independent;
            return this;
        }

    }

    private Movie (Builder builder) {
        movieTitle = builder.movieTitle;
        movieYear = builder.movieYear;
        movieDirector = builder.movieDirector;
        movieWriter = builder.movieWriter;
        movieSeries = builder.movieSeries;
        movieCast =builder.movieCast;
        movieLocations = builder.movieLocations;
        movieLanguages = builder.movieLanguages;
        movieGenres = builder.movieGenres;
        television = builder.television;
        netflix = builder.netflix;
        independent = builder.independent;
    }
}
