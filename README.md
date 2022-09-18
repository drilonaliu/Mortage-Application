# Mortage-Application

https://user-images.githubusercontent.com/84543584/190902648-1b49a168-220f-4e87-aba2-e602a22cd46f.mp4

This is an application that lets a user submit a starting principal, interest rate, and loan duration. The application replies with the monthly payment. Then, each time the user presses the button on a dialog, the application makes a monthly payment and displays the remaining principal and the total paid so far. The user continues to press the dialog’s button until the loan is paid in full

The formula for calculating the correct annual payment:

$$ monthly payment = {p*({i \over 12})*(1+{i \over 12})^{m} \over (1+{i\over12})^{m}-1} $$

for principal $p$, interest rate $i$, and months $m$.

## Class architecture 

The program for calculating the mortgage loan is a program which enables the user to follow
date on the total that the user will pay, the amount of the monthly payment, giving the amount of the loan mortgage, the interest rate, as well as the number of months for the mortgage payment. These actions from the user's side make it clear that in our architecture we need a model class which holds data and refreshes user data. On the other hand, the user wants to see these date, such as the date of the last payment, what percentage of the total the user has made, and so on. These actions suggest that we should have a view class that presents this data. The controller class is needed for generating input dialogs, sending messages to the class model for updating data, as well as sending messages to the view class to present results. Therefore the architecture of this program is model-view-controller


![mortgigj](https://user-images.githubusercontent.com/84543584/190902848-156bc6c5-5a8e-41a6-abdd-95983525b1c9.png)


## Making a percentage ring

The Mortgage class has getPercentagePaid() method, which returns the percentage of the total paid of the total debpt. The controller gets this percentage from the model class, and sends it to the view class. 

    private void makePayment() {
        model.makeMonthlyPayment();
        Date date = new GregorianCalendar().getTime();
        String paymentTime = String.valueOf(date);
        String percentage = String.valueOf(formatter2.format(model.getPercentagePaid()));
        String totalPaid = String.valueOf(formatter.format(model.getTotal_paid()));
        view.writePayment(paymentTime, percentage, totalPaid);
    }

We divide percentage by 100 and multiply it by 360 (deegres), since a method that we will use below uses deegres and not radians.

       public void writePayment(String paymentTime, String percentage, String totalPaid) {
        Double angle = (Double.valueOf(percentage) / 100) * 360;
        arcAngle = (int) Math.round(angle);
        if (Double.valueOf(percentage) == 100) {
            ringColor = green;
        }
        //..//
        }

First, a circle was filled with the white color with the help of the method fillOval() from Java's Graphics class. From the same class, we use fillArc() method to draw an arc with the angle we just calculated above, concentric with the first circle. Then, we draw a third circle with the same color as the background color on top of these two circles and we get the desired ring.

![image](https://user-images.githubusercontent.com/84543584/190903604-2432260b-6499-48d4-9772-05bbcc2ac919.png)


