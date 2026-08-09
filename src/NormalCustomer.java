public class NormalCustomer extends Customer{

    private String customerType = "일반 고객";

    public NormalCustomer(int customerNumber, String customerName, int age) {
        super(customerNumber, customerName, age);
    }

    @Override
    public String getCustomerType() {
        return customerType;
    }

    @Override
    public int calculateDiscount(int ticketAmount) {
        return super.calculateDiscount(ticketAmount);
    }

    @Override
    public int calculateEarnPoint(int paymentAmount) {
        return super.calculateEarnPoint(paymentAmount);
    }

    @Override
    public boolean usePoint(int amount) {
        return false;
    }
}
