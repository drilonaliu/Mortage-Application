# Mortage-Application

https://user-images.githubusercontent.com/84543584/190902648-1b49a168-220f-4e87-aba2-e602a22cd46f.mp4

This is an application that lets a user submit a starting principal, interest rate, and loan duration. The application replies with the monthly payment. Then, each time the user presses the button on a dialog, the application makes a monthly payment and displays the remaining principal and the total paid so far. The user continues to press the dialog’s button until the loan is paid in full

The formula for calculating the correct annual payment:

$$ monthly payment = {p*({i \over 12})*(1+{i \over 12})^{m} \over (1+{i\over12})^{m}-1} $$

for principal $p$, interest rate $i$, and years $y$.

## Class architecture 

The program for calculating the mortgage loan is a program which enables the user to follow
date on the total that the user will pay, the amount of the monthly payment, giving the amount of the loan mortgage, the interest rate, as well as the number of months for the mortgage payment. These actions from the user's side make it clear that in our architecture we need a model class which holds data and refreshes user data. On the other hand, the user wants to see these date, such as the date of the last payment, what percentage of the total the user has made, and so on. These actions suggest that we should have a view class that presents this data. The controller class is needed for generating input dialogs, sending messages to the class model for updating data, as well as sending messages to the view class to present results. Therefore the architecture of this program is model-view-controller


![mortgigj](https://user-images.githubusercontent.com/84543584/190902848-156bc6c5-5a8e-41a6-abdd-95983525b1c9.png)
