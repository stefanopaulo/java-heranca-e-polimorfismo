package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import entities.ImportedProduct;
import entities.Product;
import entities.UsedProduct;

public class Main {

	public static void main(String[] args) throws ParseException {
	
		Locale.setDefault(Locale.US);
		
		Scanner sc = new Scanner(System.in);
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		List<Product> products = new ArrayList<Product>();
		
		System.out.print("Enter the number of products: ");
		int n = sc.nextInt();
		
		for (int i = 1; i <= n; i++) {
			System.out.println("Product #"+i+" data:");
			System.out.print("Common, used, imported (c/u/i)? ");
			char ch = sc.next().charAt(0);
			System.out.print("Name: ");
			sc.nextLine();
			String name = sc.nextLine();
			System.out.print("Price: ");
			double price = sc.nextDouble();
			
			if (ch == 'c') {
				Product product = new Product(name, price);
				products.add(product);
			}
			
			if (ch == 'u') {
				System.out.print("Manufacture date: ");
				Date manufactureDate = sdf.parse(sc.next());
				Product product = new UsedProduct(name, price, manufactureDate);
				products.add(product);
			}
			
			if (ch == 'i') {
				System.out.print("Customs free: ");
				double customsFree = sc.nextDouble();
				Product product = new ImportedProduct(name, price, customsFree);
				products.add(product);
			}
		}
		
		System.out.println();
		System.out.println("PRICE TAGS:");
		
		for (Product product : products) {
			System.out.println(product.priceTag());
		}
		
		sc.close();
		
	}

}
