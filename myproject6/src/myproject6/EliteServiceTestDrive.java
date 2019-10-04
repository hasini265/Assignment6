package myproject6;

import java.lang.reflect.*;
import java.util.*;

public class EliteServiceTestDrive {
	
HashMap<String, Client> datingDB = new HashMap<String, Client>();
 	
	public static void main(String[] args) {
		EliteServiceTestDrive test = new EliteServiceTestDrive();
		test.drive();
	}
 
	public EliteServiceTestDrive() {
		initializeDatabase();
	}

	public void drive() {
		Client hasi = getPersonFromDatabase("Hasi Duda"); 
		Client ownerProxy = getOwnerProxy(hasi);
		System.out.println("Name is " + ownerProxy.getName());
		System.out.println("Gender is " + ownerProxy.getGender());
		System.out.println(ownerProxy.getName() + " Profession is " + ownerProxy.getProfession());
		ownerProxy.setInterests(" Tennis, Go Karting");
		System.out.println("Interests set from owner proxy are" + ownerProxy.getInterests());
		try {
			ownerProxy.setLikeOrNotRating(10);
		} catch (Exception e) {
			System.out.println("Can't set rating from owner proxy");
		}
		System.out.println("Rating is " + ownerProxy.getLikeOrNotRating());
		
		Client nonOwnerProxy = getNonOwnerProxy(hasi);
		System.out.println("Name is " + nonOwnerProxy.getName());
		System.out.println("Gender is " + nonOwnerProxy.getGender());
		System.out.println(nonOwnerProxy.getName() + " Profession is " + nonOwnerProxy.getProfession());
		try {
			nonOwnerProxy.setInterests("Tennis, Go Karting");
		} catch (Exception e) {
			System.out.println("Can't set interests from non owner proxy");
		}
		nonOwnerProxy.setLikeOrNotRating(6);
		System.out.println("Rating set from non owner proxy");
		System.out.println("Rating is " + nonOwnerProxy.getLikeOrNotRating());
		
	}
	
	Client getOwnerProxy(Client person) {
 		
        return (Client) Proxy.newProxyInstance( 
            	person.getClass().getClassLoader(),
            	person.getClass().getInterfaces(),
                new OwnerInvocationHandler(person));
	}

	Client getNonOwnerProxy(Client person) {
		
        return (Client) Proxy.newProxyInstance(
            	person.getClass().getClassLoader(),
            	person.getClass().getInterfaces(),
                new NonOwnerInvocationHandler(person));
	}
	
	Client getPersonFromDatabase(String name) {
		return (Client)datingDB.get(name);
	}
	

	void initializeDatabase() {
		Client hasi = new ClientMatch();
		hasi.setName("Hasi Duda");
		hasi.setGender("Female");
		hasi.setProfession("Advocate");
		hasi.setInterests("Tennis, Go Karting");
		hasi.setLikeOrNotRating(8);
		datingDB.put(hasi.getName(), hasi);

	}

}