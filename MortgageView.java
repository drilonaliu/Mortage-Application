import java.awt.*;
import javax.swing.*;

public class MortgageView extends JPanel {

    private String mortgage = "";
    private String interest = "";
    private String months = "";
    private String date = "";
    private String percentage = "";
    private String totalPaid = "";
    private String total = "";
    private int width = 620;
    private int height = 620;
    private int arcAngle = 0;
    private Color green = new Color(116, 199, 184);
    private Color ringColor = new Color(211, 156, 63);
    private Color myBlue = new Color(36, 61, 76);

    MortgageView() {
        JFrame myFrame = new JFrame();
        myFrame.setSize(width, height);
        myFrame.setTitle("Mortgage Payment");
        myFrame.add(this);
        myFrame.setResizable(false);
        myFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        myFrame.setVisible(true);
    }

    public void paintComponent(Graphics g1) {

        // Graphics properties
        super.paintComponent(g1);
        Graphics2D g = (Graphics2D) g1;
        g.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        BasicStroke stroke = new BasicStroke(10);
        g.setStroke(stroke);

        // background
        g.setColor(myBlue);
        g.fillRect(0, 0, width, height / 2);

        // title
        g.setFont(new Font("TimesRoman", Font.PLAIN, 32));
        g.setColor(Color.white);
        g.drawString("MORTGAGE PAYMENT", 120, 40);

        paintRing(g);
        drawText(g);
    }

    private void paintRing(Graphics2D g) {
        g.fillOval(200, 70, 200, 200);
        g.setColor(ringColor);
        g.fillArc(200, 70, 200, 200, 90, -arcAngle);
        g.setColor(myBlue);
        g.fillOval(225, 95, 150, 150);
        g.setColor(Color.white);
        g.setFont(new Font("TimesRoman", Font.PLAIN, 32));
        g.drawString(percentage, 263, 175);
    }

    private void drawText(Graphics2D g) {
        g.setColor(Color.white);
        g.setFont(new Font("TimesRoman", Font.PLAIN, 15));
        g.drawString("DEBT", 20, 150);
        g.drawString(mortgage, 120, 150);
        g.drawString("INTEREST", 20, 170);
        g.drawString(interest, 120, 170);
        g.drawString("MONTHS", 20, 190);
        g.drawString(months, 120, 190);
        g.drawString(total, 20, 300);
        g.setColor(myBlue);
        g.drawString("PAYMENTS", 20, 350);
        g.drawString(date, 20, 420);
        g.drawString(totalPaid, 20, 400);
    }

    public void writePayment(String paymentTime, String percentage, String totalPaid) {

        Double angle = (Double.valueOf(percentage) / 100) * 360;
        arcAngle = (int) Math.round(angle);
        if (Double.valueOf(percentage) == 100) {
            ringColor = green;
        }

        date = "\n\nThe last payment was made on:               " + paymentTime;
        this.percentage = percentage + "%";
        this.totalPaid = "You have payed so far     " + totalPaid;

        repaint();
    }

    public void writeMortgage(String value) {
        mortgage = value;
        repaint();
    }

    public void writeInterest(String value) {
        interest = value + "%";
        repaint();
    }

    public void writeTotal(String value) {
        total = "TOTAL:         " + value;
        repaint();
    }

    public void writeMonths(String value) {
        months = value;
        repaint();
    }
}