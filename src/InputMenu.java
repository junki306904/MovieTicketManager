import java.util.InputMismatchException;
import java.util.Scanner;
public class InputMenu {
    Scanner sc = new Scanner(System.in);

    public int catchInputMisMatch() {
        while (true) {
            try {
                return sc.nextInt();
            } catch (InputMismatchException e) {
                System.out.print("숫자를 입력해주세요 : ");
                sc.nextLine();
            }
        }
    }

    public int inputMainMenu() {
        System.out.println("=====================================");
        System.out.println("1. 영화 등록");
        System.out.println("2. 전체 영화 조회");
        System.out.println("3. 영화 검색");
        System.out.println("4. 영화 정보 수정");
        System.out.println("5. 영화 삭제");
        System.out.println("6. 상영 일정 등록");
        System.out.println("7. 전체 상영 일정 조회");
        System.out.println("8. 영화별 상영 일정 조회");
        System.out.println("9. 상영 일정 삭제");
        System.out.println("10. 고객 등록");
        System.out.println("11. 전체 고객 조회");
        System.out.println("12. 고객 검색");
        System.out.println("13. 좌석 예매");
        System.out.println("14. 예매 취소");
        System.out.println("15. 전체 예매 내역 조회");
        System.out.println("16. 고객별 예매 내역 조회");
        System.out.println("17. 상영 일정별 예매 현황 조회");
        System.out.println("18. 총 매출 조회");
        System.out.println("19. 영화별 매출 조회");
        System.out.println("20. 영화별 관객 수 조회");
        System.out.println("21. 인기 영화 조회");
        System.out.println("22. 상영 일정별 예매율 조회");
        System.out.println("23. 고객 등급별 매출 조회");
        System.out.println("24. 고객별 누적 결제 금액 조회");
        System.out.println("25. 예매하지 않은 고객 조회");
        System.out.println("26. 영화 제목순 정렬 조회");
        System.out.println("27. 예매율순 상영 일정 조회");
        System.out.println("28. 컬렉션 데이터 일치 여부 검사");
        System.out.println("29. 종료");
        System.out.println("=====================================");
        System.out.print("메뉴선택 : ");
        return catchInputMisMatch();
    }

    public int inputMovieNumber() {
        System.out.print("영화 번호 : ");
        return catchInputMisMatch();
    }

    public Movie getNewMovie(int number) {
        System.out.print("영화 제목 : ");
        String title = sc.next();
        System.out.print("영화 장르 : ");
        String genre = sc.next();
        System.out.print("러닝타임 : ");
        int runningTime = catchInputMisMatch();
        System.out.print("관람 등급 : ");
        int ageLimit = catchInputMisMatch();
        System.out.print("감독 : ");
        String director = sc.next();
        return new Movie(number, title, genre, runningTime, ageLimit, director);
    }

    public int inputMovieNumberOrName() {
        System.out.println("1. 영화 번호로 검색하기");
        System.out.println("2. 영화 제목으로 검색하기");
        System.out.println("===================================");
        System.out.print("선택 : ");
        return catchInputMisMatch();
    }

    public int inputEditMenu() {
        System.out.println("===================================");
        System.out.println("수정 항목");
        System.out.println("===================================");
        System.out.println("1. 영화 제목");
        System.out.println("2. 영화 장르");
        System.out.println("3. 러닝 타임");
        System.out.println("4. 관람 등급");
        System.out.println("5. 영화 감독");
        System.out.println("===================================");
        System.out.print("선택 : ");
        return catchInputMisMatch();
    }

    public String inputMovieTitle() {
        System.out.print("영화 제목 : ");
        return sc.next();
    }

    public String inputGenre() {
        System.out.print("영화 장르 : ");
        return sc.next();
    }

    public int inputRunningTime() {
        System.out.print("러닝 타임 : ");
        return catchInputMisMatch();
    }

    public int inputAgeLimit() {
        System.out.print("관람 등급 : ");
        return catchInputMisMatch();
    }

    public String inputDirector() {
        System.out.print("감독 : ");
        return sc.next();
    }

    public int inputScreeningNumber() {
        System.out.print("상영 일정 번호 : ");
        return catchInputMisMatch();
    }

    public Screening getNewScreening(int screeningNumber, Movie movie) {
        System.out.print("상영 날짜 : ");
        String date = sc.next();
        System.out.print("상영 시간 : ");
        String startTime = sc.next();
        System.out.print("상영관 번호 : ");
        int theaterNumber = catchInputMisMatch();
        System.out.print("티켓 가격 : ");
        int ticketPrice = catchInputMisMatch();
        System.out.print("전체 좌석 수 : ");
        int totalSeats = catchInputMisMatch();
        return new Screening(screeningNumber, movie, date, startTime, theaterNumber, ticketPrice, totalSeats);
    }

    public int inputCustomerType() {
        System.out.println("===================================");
        System.out.println("등록할 고객 유형을 선택해주세요");
        System.out.println("===================================");
        System.out.println("1. 일반 고객");
        System.out.println("2. 일반 회원");
        System.out.println("3. Vip 회원");
        System.out.println("===================================");
        System.out.print("선택 : ");
        return catchInputMisMatch();
    }

    public int inputCustomerNumber() {
        System.out.print("고객 번호 : ");
        return  catchInputMisMatch();
    }

    public String inputCustomerName() {
        System.out.print("고객 이름 : ");
        return sc.next();
    }

    public int inputCustomerAge() {
        System.out.print("고객 나이 : ");
        return catchInputMisMatch();
    }

    public String inputSeatNumber() {
        System.out.print("좌석 번호 : ");
        return sc.next();
    }

    public int inputPoint() {
        System.out.print("사용할 포인트 : ");
        return catchInputMisMatch();
    }

    public int inputReserveNumber() {
        System.out.print("예매 번호 : ");
        return catchInputMisMatch();
    }


}
