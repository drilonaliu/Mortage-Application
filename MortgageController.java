import java.text.DecimalFormat;
import java.util.*;
import javax.swing.*;

public class MortgageController {

    private MortgageView view;
    private Mortgage model;
    private String intro = "This app enables you to calculate mortgage payment." +
            "\nStart the app by entering mortgage value.";
    private String congratulation_Message = "Congratulations! You have paid the debt!";
    private DecimalFormat formatter = new DecimalFormat("0.00");
    private DecimalFormat formatter2 = new DecimalFormat("0");

    MortgageController() {
        initModel();
        run();
    }

    private void initModel() {
        view = new MortgageView();
        double principal = askUser(intro);
        view.writeMortgage(principal + "");
        double interest = askUser("Write interest(percentage)") / 100;
        view.writeInterest(interest * 100 + "");
        int months = (int) askUser("Write the number of months:");
        view.writeMonths(months + "");
        model = new Mortgage(principal, interest, months);
    }

    private void run() {

        String press_Ok = "\nTo make monthly payment, press OK";
        String info = formatter.format(model.getMonthly_payment())
                + " is a monthly payment, and " +
                formatter.format(model.getTotalPayment()) + " is total payment" +
                press_Ok;

        showMessage(info);
        view.writeTotal(String.valueOf(formatter.format(model.getTotalPayment())));
        makePayment();

        String total_paid = formatter.format(model.getTotalPayment());
        boolean paid = false;
        while (!paid) {
            showMessage("You have paid so far " + formatter.format(model.getTotal_paid()) +
                    " out of " + total_paid + press_Ok);
            makePayment();
            if (model.isPaymentDone()) {
                paid = true;
                showMessage(congratulation_Message);
                break;
            }
        }
    }

    private void makePayment() {
        model.makeMonthlyPayment();
        Date date = new GregorianCalendar().getTime();
        String paymentTime = String.valueOf(date);
        String percentage = String.valueOf(formatter2.format(model.getPercentagePaid()));
        String totalPaid = String.valueOf(formatter.format(model.getTotal_paid()));
        view.writePayment(paymentTime, percentage, totalPaid);
    }

    private double askUser(String message) {
        String input = getUserInput(message);
        double value = 0;
        try {
            value = Double.valueOf(input);
        } catch (Exception e) {
            return askUser("Error occured, try again!");
        }

        if (value < 0) {
            return askUser("No negative values are allowed");
        }
        return value;
    }

    private String getUserInput(String message) {
        return JOptionPane.showInputDialog(null, message);
    }

    private void showMessage(String message) {
        JOptionPane.showMessageDialog(null, message);
    }

}