import java.util.Scanner;
public class CalcLoan {

public static void main(String[] args){
	double TotPay = calcTotPay();
	System.out.println("Your degree costs: $" + TotPay);
	double MonthlyPay = calcMonthly(TotPay);
	System.out.println("You will have to pay: $" + MonthlyPay + " monthly to pay off your loans.");
}
public static double calcTotPay(){
	Scanner input = new Scanner(System.in);
	System.out.print("Enter the initial tuition cost: ");
	double Tuit = input.nextDouble();
	System.out.print("Enter the yearly tuition percent increase: ");
	double rate = input.nextDouble();
	if (rate > 1){
		rate = rate/100;
	}
	input.close();
	double totT = Tuit*((1-(1/Math.pow(1+rate,4))))/(rate);
	return totT;
}
public static double calcMonthly(double cost){
	Scanner input = new Scanner(System.in);
	System.out.print("Enter the APR for your loan: ");
	double rate = input.nextDouble();
	if (rate > 1){
		rate = rate/100;
	}
	System.out.print("Enter the number of years you have to repay your loans: ");
	int time = input.nextInt();
	input.close();
	double mPay = cost*((rate/12)/((Math.pow(1+rate/12,time*12))-1));
	return mPay;
}
}
