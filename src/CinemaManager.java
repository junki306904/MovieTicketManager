import java.time.LocalDateTime;
import java.util.*;

public class CinemaManager {
    ArrayList<Movie> movies = new ArrayList<>();
    ArrayList<Screening> screenings = new ArrayList<>();
    ArrayList<Customer> customers = new ArrayList<>();
    ArrayList<Reservation> reservations = new ArrayList<>();

    HashMap<Integer, Movie> movieMap = new HashMap<>();
    HashMap<Integer, Screening> screeningMap = new HashMap<>();
    HashMap<Integer, Customer> customerMap = new HashMap<>();
    HashMap<Integer, Reservation> reservationMap = new HashMap<>();

    int reservationNumber = 1;

    public void addMovie(InputMenu menu) {
        int number = menu.inputMovieNumber();
        if (movieMap.containsKey(number)) {
            System.out.println("이미 등록된 영화 번호입니다.");
            return;
        }
        Movie newMovie = menu.getNewMovie(number);
        movies.add(newMovie);
        movieMap.put(number, newMovie);
        System.out.println("영화 등록이 완료되었습니다.");
    }

    public void printAllMovies() {
        if (movies.isEmpty()) {
            System.out.println("등록된 영화가 없습니다.");
            return;
        }
        for (Movie movie : movies) {
            movie.printInfo();
        }
    }

    public void findMovie(InputMenu menu) {
        int num = menu.inputMovieNumberOrName();
        if (num == 1) {
            movieMap.get(menu.inputMovieNumber()).printInfo();
            return;
        } else {
            String title = menu.inputMovieTitle();
            for (Movie movie : movies) {
                if (movie.getTitle().contains(title)) {
                    movie.printInfo();
                    return;
                }
            }
        }
        System.out.println("해당 영화를 찾을 수 없습니다.");
    }

    public void editMovieInfo(InputMenu menu) {
        int movieNumber = menu.inputMovieNumber();
        for (Movie movie : movies) {
            if (movie.getMovieNumber() == movieNumber) {
                switch (menu.inputEditMenu()) {
                    case 1:
                        movie.setTitle(menu.inputMovieTitle());
                        break;
                    case 2:
                        movie.setGenre(menu.inputGenre());
                        break;
                    case 3:
                        movie.setRunningTime(menu.inputRunningTime());
                        break;
                    case 4:
                        movie.setAgeLimit(menu.inputAgeLimit());
                        break;
                    case 5:
                        movie.setDirector(menu.inputDirector());
                        break;
                }
                System.out.println("영화 정보 수정이 완료되었습니다.");
                return;
            }
        }
        System.out.println("해당 영화를 찾을 수 없습니다");
    }

    public void deleteMovie(InputMenu menu) {
        int movieNumber = menu.inputMovieNumber();
        for (Screening screen : screenings) {
            //날짜 비교
            if (screen.getMovieNumber() == movieNumber
                    && screen.getDateTime().isAfter(LocalDateTime.now())) {
                System.out.println("예정된 상영 일정이 존재합니다.");
                return;
            }
        }
        for (int i = 0; i < movies.size(); i++) {
            if (movies.get(i).getMovieNumber() == movieNumber) {
                movies.remove(i);
                movieMap.remove(movieNumber);
                System.out.println("영화 삭제가 완료되었습니다.");
                return;
            }
        }
        System.out.println("해당 영화를 찾을 수 없습니다.");
    }

    public void addScreening(InputMenu menu) {
        Movie m = null;
        int screeningNumber = menu.inputScreeningNumber();
        if (screeningMap.containsKey(screeningNumber)) {
            System.out.println("이미 등록된 상영일자 번호입니다.");
            return;
        }
        int movieNumber = menu.inputMovieNumber();
        if (!movieMap.containsKey(movieNumber)) {
            System.out.println("해당 영화가 존재하지 않습니다.");
            return;
        } else {
            m = movieMap.get(movieNumber);
        }
        Screening newScreen = menu.getNewScreening(screeningNumber, m);
        screenings.add(newScreen);
        screeningMap.put(newScreen.getScreeningNumber(), newScreen);
        System.out.println("상영 일정 등록이 완료되었습니다.");
    }

    public void printAllScreenings() {
        if (screenings.isEmpty()) {
            System.out.println("등록된 상영 일정이 없습니다.");
            return;
        }
        for (Screening screen : screenings) {
            screen.printInfo();
        }
    }

    public void findMovieScreening(InputMenu menu) {
        int count = 0;
        int movieNumber = menu.inputMovieNumber();
        if (!movieMap.containsKey(movieNumber)) {
            System.out.println("해당 번호의 영화를 찾을 수 없습니다.");
            return;
        }
        for (Screening screen : screenings) {
            if (screen.getMovieNumber() == movieNumber) {
                screen.printInfo();
                count++;
            }
        }
        if (count == 0) {
            System.out.println("해당 영화의 상영 일정을 찾을 수 없습니다.");
        }
    }

    public void deleteScreening(InputMenu menu) {
        int screeningNumber = menu.inputScreeningNumber();
        for (Reservation reservation : reservations) {
            if (reservation.getScreenNumber() == screeningNumber) {
                System.out.println("예매된 좌석이 있어 상영 일정을 삭제할 수 없습니다.");
                return;
            }
        }
        for (int i = 0; i < screenings.size(); i++) {
            if (screenings.get(i).getScreeningNumber() == screeningNumber) {
                screenings.remove(i);
                screeningMap.remove(screeningNumber);
                System.out.println("해당 상영 일정 삭제가 완료되었습니다.");
                return;
            }
        }
        System.out.println("해당 상영 일정을 찾을 수 없습니다");
    }

    public void addCustomer(InputMenu menu) {
        int type = menu.inputCustomerType();
        int number = menu.inputCustomerNumber();
        if (customerMap.containsKey(number)) {
            System.out.println("이미 등록된 고객 번호입니다.");
            return;
        }
        String name = menu.inputCustomerName();
        int age = menu.inputCustomerAge();
        if (type == CustomerType.NORMAL_CUSTOMER) {
            customers.add(new NormalCustomer(number, name, age));
            customerMap.put(number, new NormalCustomer(number, name, age));
        } else if (type == CustomerType.MEMBER_CUSTOMER) {
            customers.add(new MemberCustomer(number, name, age));
            customerMap.put(number, new MemberCustomer(number, name, age));
        } else if (type == CustomerType.VIP_CUSTOMER) {
            customers.add(new VipCustomer(number, name, age));
            customerMap.put(number, new VipCustomer(number, name, age));
        }
        System.out.println("고객 등록이 완료되었습니다.");
    }

    public void printAllCustomer() {
        if (customers.isEmpty()) {
            System.out.println("등록된 고객이 없습니다.");
            return;
        }
        for (Customer cs : customers) {
            cs.printInfo();
        }
    }

    public void findCustomer(InputMenu menu) {
        int customerNumber = menu.inputCustomerNumber();
        if (!customerMap.containsKey(customerNumber)) {
            System.out.println("해당 고객을 찾을 수 없습니다.");
            return;
        }
        customerMap.get(customerNumber).printInfo();
    }


    public void reserveSeat(InputMenu menu) {
        String seatNumber;
        int usedPoint = 0;
        int customerNumber = menu.inputCustomerNumber();
        if (!customerMap.containsKey(customerNumber)) {
            System.out.println("해당 번호의 고객을 찾을 수 없습니다.");
            return;
        }
        int screeningNumber = menu.inputScreeningNumber();
        if (!screeningMap.containsKey(screeningNumber)) {
            System.out.println("해당 번호의 상영 일자를 찾을 수 없습니다.");
            return;
        }
        if (!screeningMap.get(screeningNumber).getMovie().canWatch(customerMap.get(customerNumber).getAge())) {
            System.out.println("관람등급에 맞지 않아 예매할 수 없습니다.");
            return;
        }
        if (screeningMap.get(screeningNumber).getRemainingSeatCount() <= 0) {
            System.out.println("좌석이 모두 매진되었습니다.");
            return;
        }
        //좌석 중복시 좌석 선택으로 되돌아오기
        while (true) {
            seatNumber = menu.inputSeatNumber();
            if (!screeningMap.get(screeningNumber).reserveSeat(seatNumber)) {
                System.out.println("이미 예약된 좌석입니다.");
                continue;
            }
            break;
        }
        screeningMap.get(screeningNumber).reserveSeat(seatNumber);
        int originAmount = screeningMap.get(screeningNumber).getTicketPrice();
        int discountAmount = customerMap.get(customerNumber).
                calculateDiscount(screeningMap.get(screeningNumber).getTicketPrice());
        int amountAfterDiscount = originAmount - discountAmount;
        System.out.println("주문 전 금액 : " + originAmount);
        System.out.println("할인 금액 : " + discountAmount);
        System.out.println("할인 후 금액 : " + amountAfterDiscount);
        if (!(customerMap.get(customerNumber) instanceof NormalCustomer)) {
            while (true) {
                usedPoint = menu.inputPoint();
                if (!customerMap.get(customerNumber).usePoint(usedPoint)) {
                    System.out.println("보유 포인트가 부족합니다.");
                    continue;
                }
                break;
            }
        }
        int earnedPoint = customerMap.get(customerNumber).calculateEarnPoint(amountAfterDiscount - usedPoint);
        System.out.println("예매가 완료되었습니다!");
        System.out.println("========================================");
        System.out.println("예매 번호 : " + reservationNumber);
        System.out.println("영화 : " + screeningMap.get(screeningNumber).getMovieTitle());
        System.out.println("상영일 : " + screeningMap.get(screeningNumber).getDate());
        System.out.println("상영 시간 : " + screeningMap.get(screeningNumber).getStartTime());
        System.out.println("상영관 : " + screeningMap.get(screeningNumber).getTheaterNumber());
        System.out.println("좌석 : " + seatNumber);
        System.out.println("할인 금액 : " + discountAmount);
        System.out.println("사용한 포인트 : " + usedPoint);
        System.out.println("최종 결제 금액 :" + (originAmount - discountAmount - usedPoint));
        System.out.println("적립 포인트 : " + earnedPoint);
        //CustomerMap 업데이트
        customerMap.get(customerNumber).addPoint(earnedPoint);
        customerMap.get(customerNumber).addTotalPayment(originAmount - discountAmount - usedPoint);
        //CustomerList 업데이트
        for(Customer cs : customers) {
            if(cs.getCustomerNumber() == customerNumber) {
                cs.addPoint(earnedPoint);
                cs.addTotalPayment(originAmount - discountAmount - usedPoint);
            }
        }
        Reservation reserve = new Reservation(customerMap.get(customerNumber), screeningMap.get(screeningNumber), seatNumber, usedPoint);
        reserve.setSeatNumber(seatNumber);
        reserve.setOriginalAmount(originAmount);
        reserve.setDiscountAmount(discountAmount);
        reservations.add(reserve);
        reservationMap.put(reservationNumber++, reserve);
    }

    public void cancelReservation(InputMenu menu) {
        int reserveNumber = menu.inputReserveNumber();
        if (!reservationMap.containsKey(reserveNumber)) {
            System.out.println("해당 예매내역을 찾을 수 없습니다.");
            return;
        }
        String reservedSeat = reservationMap.get(reserveNumber).getSeatNumber();
        int usedPoint = reservationMap.get(reserveNumber).getUsedPoint();
        int earnedPoint = reservationMap.get(reserveNumber).getEarnedPoint();
        int finalPayment = reservationMap.get(reserveNumber).getFinalPayment();
        reservationMap.get(reserveNumber).getScreen().cancelSeat(reservedSeat); //예약죄석 취소
        reservationMap.get(reserveNumber).getCs().addPoint(usedPoint); // 사용포인트 반환
        reservationMap.get(reserveNumber).getCs().usePoint(earnedPoint); // 적립 포인트 회수
        reservationMap.get(reserveNumber).getCs().reduceTotalPayment(finalPayment); // 누적 결제금액 감소
        reservationMap.get(reserveNumber).isCanceled();
        System.out.println("예매 취소가 완료되었습니다.");
    }

    public void printAllReservation() {
        if (reservations.isEmpty()) {
            System.out.println("등록된 예매내역을 찾을 수 없습니다.");
            return;
        }
        for (Reservation reservation : reservations) {
            reservation.printInfo();
        }
    }

    public void findReservationByCustomer(InputMenu menu) {
        int count = 0;
        int customerNumber = menu.inputCustomerNumber();
        for (Reservation reservation : reservations) {
            if (reservation.getCs().getCustomerNumber() == customerNumber) {
                reservation.printInfo();
                count++;
            }
        }
        if (count == 0) {
            System.out.println("해당 고객의 예매정보를 찾을 수 없습니다.");
        }
    }

    public void printReservedInfoByScreening(InputMenu menu) {
        int screeningNumber = menu.inputScreeningNumber();
        for (Screening screen : screenings) {
            if (screen.getScreeningNumber() == screeningNumber) {
                System.out.println("전체 좌석 수 : " + screen.getTotalSeats());
                System.out.println("예매 좌석 수 : " + screen.getReservedSeatCount());
                System.out.println("남은 좌석 수 : " + screen.getRemainingSeatCount());
                System.out.print("예매된 좌석 번호 : ");
                Iterator<String> it = screen.getReservedSeats().iterator();
                while (it.hasNext()) {
                    System.out.println(it.next());
                }
            }
        }
    }

    public void totalSales() {
        int totalSales = 0;
        for (Reservation reserve : reservations) {
            if (!reserve.isCanceled()) {
                totalSales += reserve.getFinalPayment();
            }
        }
        System.out.println("총 매출 : " + totalSales + "원");
    }

//TODO
    public void salesByMovie() {
        HashMap<Integer, Integer> sales = new HashMap<>();
        if (reservations.isEmpty()) {
            System.out.println("예매 내역이 없습니다.");
            return;
        }
        for (Reservation reserve : reservations) {
            int movieNumber = reserve.getScreen().getMovieNumber();
            int totalSales = reserve.getFinalPayment();
            if (sales.containsKey(movieNumber)) {
                sales.put(movieNumber, reserve.getFinalPayment() + totalSales);
            } else {
                sales.put(movieNumber, reserve.getFinalPayment());
            }
            for (int i = 0; i < movies.size(); i++) {
                System.out.println(movies.get(i).getTitle() + " - 매출 : " + sales.get(i));
            }
        }
    }
//TODO
    public void customersByMovie() {
        HashMap<Integer, Integer> customers = new HashMap<>();
        if(reservations.isEmpty()) {
            System.out.println("예매 내역이 없습니다.");
            return;
        }
    }

    public void totalPaymentByCustomer() {
        if (customers.isEmpty()) {
            System.out.println("등록된 고객을 찾을 수 없습니다.");
            return;
        }
        for (Customer cs : customers) {
            System.out.println(cs.getCustomerName() + " - " + cs.getCustomerType() + " - 누적 결제 금액 : " +
                    cs.getTotalPayment());
        }
    }
//TODO
    public void nonReservedCustomer() {
        int count = 0;
        HashSet<Integer> reserved = new HashSet<>();
        if(customers.isEmpty()) {
            System.out.println("등록된 고객이 없습니다.");
            return;
        }
        for(int i = 1; i < reservations.size(); i++) {
            if(!reservations.get(i).isCanceled()) {
                reserved.add(reservations.get(i).getCs().getCustomerNumber());
            }
        }
        for(int i = 1; i < customers.size(); i++) {
            if(!reserved.contains(i)) {
                System.out.println(customerMap.get(i).getCustomerName());
                count++;
            }
        }
        if(count == 0) {
            System.out.println("예매하지 않은 고객이 없습니다.");
        }
    }

    public void sortByMovieName() {
        Comparator<Movie> nameCompare = new Comparator<Movie>() {
            @Override
            public int compare(Movie o1, Movie o2) {
                return o1.getTitle().compareTo(o2.getTitle());
            }
        };
        ArrayList<Movie> copiedMovies = new ArrayList<>(movies); //리스트 복사
        copiedMovies.sort(nameCompare);
        for (Movie movie : copiedMovies) {
            System.out.println(movie.getTitle());
        }
    }

    public void sortByReservationRate() {
        Comparator<Screening> reserveRate = new Comparator<Screening>() {
            @Override
            public int compare(Screening o1, Screening o2) {
                return (int) (o2.getReservationRate() - o1.getReservationRate());
            }
        };
        ArrayList<Screening> copy = new ArrayList<>(screenings);
        copy.sort(reserveRate);
        for (Screening screen : copy) {
            screen.printInfo();
        }
    }

    public void test() {
        if (movieMap.size() == movies.size()
                && screeningMap.size() == screenings.size()
                && customerMap.size() == customers.size()
                && reservationMap.size() == reservations.size()) {
            System.out.println("true");
        }
    }
}
