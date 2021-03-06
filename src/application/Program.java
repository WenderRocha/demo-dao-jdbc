package application;

import java.util.Date;
import java.util.List;
import java.util.Scanner;

import db.DbException;
import model.dao.DaoFactory;
import model.dao.SellerDao;
import model.entities.Department;
import model.entities.Seller;

public class Program {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);

		SellerDao sellerDao = DaoFactory.createSellerDao();

		System.out.println("=== TESTE 1: Seller findById ===");
		Seller seller = sellerDao.findById(3);
		System.out.println(seller);

		System.out.println("\n=== TESTE 2: Seller findById ===");
		Department department = new Department(2, null);
		List<Seller> list = sellerDao.findByDepartment(department);

		for (Seller obj : list) {
			System.out.println(obj);
		}

		System.out.println("\n=== TESTE 3: Seller findAll ===");
		List<Seller> sellers = sellerDao.findAll();

		for (Seller obj : sellers) {
			System.out.println(obj);
		}

		System.out.println("\n=== TESTE 4: Seller Insert ===");
		Seller newSeller = new Seller(null, "Greg", "greg@gmail.com", new java.sql.Date(new Date().getTime()), 4000.0,
				department);
		//sellerDao.insert(newSeller);
		System.out.println("Inserted! New id = " + newSeller.getId() + " - " + newSeller.getName());
		
		
		System.out.println("\n=== TESTE 5: Seller UPDATE ===");
		seller = sellerDao.findById(13);
		seller.setName("Marta Waine");
		//sellerDao.update(seller);
		System.out.println("Update Completed");
		
		System.out.println("\n=== TESTE 6: Seller UPDATE ===");
		System.out.println("Enter id for delete test: ");
		int id = sc.nextInt();
		
		try {
			sellerDao.deleteById(id);
			System.out.println("Delete completed");
		}catch(DbException e) {
			System.out.println(e.getMessage());
		}
	
		
		
		sc.close();


	}

}
