public class VipCustomer extends Customer{

    private String customerType = "VIP 회원";

    public VipCustomer(int customerNumber, String customerName, int age) {
        super(customerNumber, customerName, age);
    }

    @Override
    public String getCustomerType() {
        return customerType;
    }

    @Override
    public int calculateDiscount(int ticketAmount) {
        return (int) (ticketAmount * 0.1);
    }

    @Override
    public int calculateEarnPoint(int paymentAmount) {
        return (int) (paymentAmount * 0.07);
    }

    @Override
    public boolean usePoint(int amount) {
        return super.usePoint(amount);
    }

}
