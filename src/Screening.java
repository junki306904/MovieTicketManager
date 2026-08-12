import java.time.format.DateTimeFormatter;
import java.util.HashSet;
import java.time.LocalDateTime;

public class Screening {

    private int screeningNumber;
    private Movie movie;
    private String date;
    private String startTime;
    private int theaterNumber;
    private int ticketPrice;
    private int totalSeats;
    private HashSet<String> reservedSeats = new HashSet<>();

    public Screening(int screeningNumber, Movie movie, String date, String startTime, int theaterNumber,
                     int ticketPrice, int totalSeats) {
        this.screeningNumber = screeningNumber;
        this.movie = movie;
        this.date = date;
        this.startTime = startTime;
        this.theaterNumber = theaterNumber;
        this.ticketPrice = ticketPrice;
        this.totalSeats = totalSeats;
    }

    public boolean reserveSeat(String seatNumber) {
        if (!reservedSeats.contains(seatNumber)) {
            reservedSeats.add(seatNumber);
            return true;
        }
        return false;
    }

    public boolean cancelSeat(String seatNumber) {
        return reservedSeats.remove(seatNumber);
    }

    public int getReservedSeatCount() {
        return reservedSeats.size();
    }

    public int getRemainingSeatCount() {
        return totalSeats - reservedSeats.size();
    }

    public double getReservationRate() {
        return (double) (reservedSeats.size() / totalSeats) * 100;
    }

    public void printInfo() {
        System.out.println("====================================");
        System.out.println("상영 일정 번호 : " + screeningNumber);
        System.out.println("상영 영화 제목 : " + movie.getTitle());
        System.out.println("상영 날짜 : " + date);
        System.out.println("상영 시간 : " + startTime);
        System.out.println("상영관 : " + theaterNumber);
        System.out.println("티켓 가격 : " + ticketPrice);
        System.out.println("전체 좌석 : " + totalSeats);
        System.out.println("예매 좌석 수 : " + getReservedSeatCount());
        System.out.println("남은 좌석 수 : " + getRemainingSeatCount());
    }

    public LocalDateTime getDateTime() {
        String dateTime = date + startTime;
        return LocalDateTime.parse(dateTime, DateTimeFormatter.ofPattern("yyyy/MM/ddHH:mm"));
    }

    public int getTheaterNumber() {
        return theaterNumber;
    }

    public int getTicketPrice() {
        return ticketPrice;
    }

    public int getTotalSeats() {
        return totalSeats;
    }

    public String getStartTime() {
        return startTime;
    }

    public String getDate() {
        return date;
    }

    public String getMovieTitle() {
        return movie.getTitle();
    }

    public  int getMovieNumber() {
        return movie.getMovieNumber();
    }

    public int getScreeningNumber() {
        return screeningNumber;
    }

    public Movie getMovie() {
        return movie;
    }

    public HashSet<String> getReservedSeats() {
        return reservedSeats;
    }
}
