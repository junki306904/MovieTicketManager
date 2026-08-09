public class Reservation {

    private int reservationNumber;
    private Customer cs;
    private Screening screen;
    private String seatNumber;
    private int originalAmount;
    private int discountAmount;
    private int usedPoint;

    public Reservation(Customer cs, Screening screen, String seatNumber, int usedPoint) {
        this.cs = cs;
        this.screen = screen;
        this.seatNumber = seatNumber;
        this.usedPoint = usedPoint;
    }

    public void printInfo() {
        System.out.println("========================================");
        System.out.println("예약 번호 : " + reservationNumber);
        System.out.println("고객 번호 : " + cs.getCustomerNumber());
        System.out.println("고객 이름 : " + cs.getCustomerName());
        System.out.println("고객 등급 : " + cs.getCustomerType());
        System.out.println("상영 번호 : " + screen.getScreeningNumber());
        System.out.println("영화 번호 : " + screen.getMovieNumber());
        System.out.println("영화 제목 : " + screen.getMovieTitle());
        System.out.println("상영 날짜 : " + screen.getDate());
        System.out.println("상영 시간 : " + screen.getStartTime());
        System.out.println("상영관 : " + screen.getTheaterNumber());
        System.out.println("좌석 번호 : " + seatNumber);
        System.out.println("할인 전 금액 : " + getOriginalAmount());
        System.out.println("할인 금액 : " + getDiscountAmount());
        System.out.println("사용한 포인트 : " + usedPoint);
        System.out.println("최종 결제 금액 : " + (getFinalPayment() - usedPoint));
        System.out.println("적립 포인트 : " + getEarnedPoint());
        if(isCanceled()) {
            System.out.println("예매 취소 여부 : O");
        }
        else {
            System.out.println("예매 취소 여부 : X");
        }
    }

    public int getScreenNumber() {
        return screen.getScreeningNumber();
    }

    public int getOriginalAmount() {
        return screen.getTicketPrice();
    }

    public int getDiscountAmount() {
        return cs.calculateDiscount(screen.getTicketPrice());
    }

    public int getFinalPayment() {
        return getOriginalAmount() - getDiscountAmount();
    }

    public int getEarnedPoint() {
        return cs.calculateEarnPoint(getFinalPayment());
    }

    public Screening getScreen() {
        return screen;
    }

    public Customer getCs() {
        return cs;
    }

    public String getSeatNumber() {
        return seatNumber;
    }

    public void setSeatNumber(String seatNumber) {
        this.seatNumber = seatNumber;
    }

    public void setOriginalAmount(int originalAmount) {
        this.originalAmount = originalAmount;
    }

    public void setDiscountAmount(int discountAmount) {
        this.discountAmount = discountAmount;
    }

    public int getUsedPoint() {
        return usedPoint;
    }

    public boolean isCanceled() {
        return !screen.getReservedSeats().contains(seatNumber);
    }

}
