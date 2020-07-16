package test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class CurrencySort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<Currency> cs=new ArrayList<Currency>();
		Scanner sc=new Scanner(System.in);
		System.out.println("HKD:");
		if(sc.hasNext()) {
			cs.add(Currency.HKD);
			cs.get(0).setOriginalValue(sc.nextInt());
		}
		System.out.println("USD:");
		if(sc.hasNext()) {
			cs.add(Currency.USD);
			cs.get(1).setOriginalValue(sc.nextInt());
		}
		System.out.println("EUR:");
		if(sc.hasNext()) {
			cs.add(Currency.EUR);
			cs.get(2).setOriginalValue(sc.nextInt());
		}
		
		Collections.sort(cs, new Comparator<Currency>() {
			@Override
			public int compare(Currency o1, Currency o2) {
				// TODO Auto-generated method stub	
				return (int)(o1.getValue()-o2.getValue());//Ë³Ðò
				/*return (int)(o2.getValue()-o1.getValue());
				 * Õâ¸öÊÇÄæÐò
				 */
			}	
		});
		cs.forEach(v->System.out.println(v.toString()+v.getValue()));
	}

}
