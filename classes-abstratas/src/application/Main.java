package application;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import entities.Account;
import entities.BusinessAccount;
import entities.SavingsAccount;

public class Main {

	public static void main(String[] args) {

		Locale.setDefault(Locale.US);
		
		Scanner sc = new Scanner(System.in);
		
		// [erro] Account acc = new Account();
		
		Account acc1 = new SavingsAccount(1001, "Maria", 500.0, 0.01);
		Account acc2 = new BusinessAccount(1002, "Bob", 1000.0, 500.0);
		Account acc3 = new SavingsAccount(1001, "Alex", 300.0, 0.01);
		Account acc4 = new BusinessAccount(1002, "Joana", 500.0, 500.0);
		
		List<Account> list = new ArrayList<Account>();
		list.add(acc1);
		list.add(acc2);
		list.add(acc3);
		list.add(acc4);
		
		double sum = 0.0;
		for (Account acc : list) {
			sum += acc.getBalance();
		}
		
		System.out.println(sum);
		
		for (Account acc : list) {
			acc.deposit(10.0);
		}
		
		for (Account acc : list) {
			System.out.println(acc.getBalance());
		}
		
		sc.close();

	}

}
