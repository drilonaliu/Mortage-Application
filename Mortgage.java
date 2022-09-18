public class Mortgage {

    private double principal;
    private double interest;
    private int months;
    private double monthly_payment;
    private double total_paid = 0;
    private double total;
    private double perqindja;

    Mortgage(double principal, double interest, int months) {
        this.principal = principal;
        this.interest = interest;
        this.months = months;

        double z = Math.pow(1 + (interest / 12.0), months);
        monthly_payment = (principal * (interest / 12.0) * z)
                / (z - 1);
        total = monthly_payment * months;
    }

    public void makeMonthlyPayment() {
        total_paid = total_paid + monthly_payment;
        perqindja = (total_paid / total) * 100;
    }

    public double getTotal_paid() {
        return total_paid;
    }

    public boolean isPaymentDone() {
        return perqindja > 99.7;
    }

    public double getMonthly_payment() {
        return monthly_payment;
    }

    public double getInterest() {
        return interest;
    }

    public double getPrincipal() {
        return principal;
    }

    public int getmonths() {
        return months;
    }

    public double getTotalPayment(){
        return total;
    }

    public double getPercentagePaid(){
        return perqindja;
    }

}