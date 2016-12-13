package hwfpp.lesson8.lession8;

import java.text.NumberFormat;
import java.util.ArrayList;

class Sale {
	String item;
	double price;

	public Sale(String item, double price) {
		this.item = item;
		this.price = price;
	}
}

public class TallySales {
	public static void main(String[] args) {
		ArrayList<Sale> sales = new ArrayList<Sale>();
		sales.add(new Sale("DVD", 40));
		NumberFormat currency = NumberFormat.getCurrencyInstance();
		fillTheList(sales);
		Sale ob = sales.get(1);
		System.out.println(ob.item + " " + ob.price);
		double total = 0;
		
		for (Sale sale : sales) {
			
			if (sale.item.equals("DVD")) {
				
				total += sale.price;
			}
		}
		System.out.println("Total selleing price of DVD :"
				+ currency.format(total));
	}

	static void fillTheList(ArrayList<Sale> sales) {
		sales.add(new Sale("DVD", 15.00));
		sales.add(new Sale("Book", 12.00));
		sales.add(new Sale("DVD", 21.00));
		sales.add(new Sale("CD", 5.25));
	}
}
