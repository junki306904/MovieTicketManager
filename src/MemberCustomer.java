public class MemberCustomer extends Customer {

    private String customerType = "일반 회원";

    public MemberCustomer(int customerNumber, String customerName, int age) {
        super(customerNumber, customerName, age);
    }

    @Override
    public String getCustomerType() {
        return customerType;
    }

    @Override
    public int calculateDiscount(int ticketAmount) {
        return (int) (ticketAmount * 0.05);
    }

    @Override
    public int calculateEarnPoint(int paymentAmount) {
        return (int) (paymentAmount * 0.03);
    }

    @Override
    public boolean usePoint(int amount) {
        return super.usePoint(amount);
    }
}

