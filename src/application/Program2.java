package application;

import java.util.ArrayList;
import java.util.List;

import db.DbException;
import model.dao.DaoFactory;
import model.dao.DepartmentDao;
import model.entities.Department;

public class Program2 {

	public static void main(String[] args) {

		DepartmentDao departmentDao = DaoFactory.createDepartmentDao();

		try {

			System.out.println("=== Insert Departments ===");
			Department department = new Department(null, "Roupas");
			// departmentDao.insert(department);
			System.out.println(department);

			System.out.println("\n=== findById ===");
			department = departmentDao.findById(6);
			System.out.println(department);

			System.out.println("\n== Update ==");
			department = new Department(8, "Acessories");
			//departmentDao.update(department);
			System.out.println(department);

			System.out.println("\n=== Delete ===");
			department = departmentDao.findById(9);
			//departmentDao.deleteById(department.getId());
			System.out.println("Delete completed");
			
			System.out.println("\n=== findAll ===");
			List<Department> departments = departmentDao.findAll();
			
			for (Department dep : departments) {
				System.out.println(dep);
			}

		} catch (DbException e) {
			System.out.println(e.getMessage());
		}

	}

}
