interface CustomerType {
    int NORMAL_CUSTOMER = 1;
    int MEMBER_CUSTOMER = 2;
    int VIP_CUSTOMER = 3;
}

public class Customer {

    private int customerNumber;
    private String customerName;
    private int age;
    private int point;
    private int totalPayment;

    public Customer(int customerNumber, String customerName, int age) {
        this.customerNumber = customerNumber;
        this.customerName = customerName;
        this.age = age;
    }

    public int calculateDiscount(int ticketAmount) {
        return 0;
    }

    public int calculateEarnPoint(int paymentAmount) {
        return 0;
    }

    public void addPoint(int amount) {
        point += amount;
    }

    public boolean usePoint(int amount) {
        if (amount > point) {
            return false;
        }
        point -= amount;
        return true;
    }

    public void addTotalPayment(int amount) {
        totalPayment += amount;
    }

    public void printInfo() {
        System.out.println("=======================================");
        System.out.println("고객 번호 : " + customerNumber);
        System.out.println("고객 이름 : " + customerName);
        System.out.println("고객 나이 : " + age);
        System.out.println("보유 포인트 : " + point);
        System.out.println("누적 결제 금액 : " + totalPayment);
    }

    public int getCustomerNumber() {
        return customerNumber;
    }

    public String getCustomerName() {
        return customerName;
    }

    public String getCustomerType() {
        return "";
    }

    public int getAge() {
        return age;
    }

    public int getTotalPayment() {
        return totalPayment;
    }

    public boolean reduceTotalPayment(int amount) {
        if (amount > totalPayment) {
            return false;
        }
        totalPayment -= amount;
        return true;
    }
}


