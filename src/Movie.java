
public class Movie {

    private int movieNumber;
    private String title;
    private String genre;
    private int runningTime;
    private int ageLimit;
    private String director;

    Movie (int movieNumber, String title, String genre, int runningTime, int ageLimit, String director) {
        this.movieNumber = movieNumber;
        this.title = title;
        this.genre = genre;
        this.runningTime = runningTime;
        this.ageLimit = ageLimit;
        this.director = director;
    }

    public void printInfo() {
        System.out.println("===================================");
        System.out.println("영화 번호 : " + movieNumber);
        System.out.println("영화 제목 : " + title);
        System.out.println("영화 장르 : " + genre);
        System.out.println("러닝타임 : " + runningTime);
        System.out.println("관람 등급 : " + ageLimit);
        System.out.println("감독 : " + director);
    }

    public boolean canWatch(int customerAge) {
        return customerAge >= ageLimit;
    }

    public int getMovieNumber() {
        return movieNumber;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public void setRunningTime(int runningTime) {
        this.runningTime = runningTime;
    }

    public void setAgeLimit(int ageLimit) {
        this.ageLimit = ageLimit;
    }

    public void setDirector(String director) {
        this.director = director;
    }
}
