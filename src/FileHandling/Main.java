package FileHandling;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.ListIterator;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.Scanner;



public class Main {

//	 static public void main(String[] args) {
//		// TODO Auto-generated method stub
//		File f = new File("E:\\Document - Internal Use\\Technology\\Java\\Java Code\\FileHandling\\file.txt");
//		FileWriter fw;
//		try {
//			fw = new FileWriter(f);
//			fw.write("Hello");
//			fw.flush();
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}	
		



	@SuppressWarnings("unchecked")
	public static void main(String[] args) throws Exception  {
		int choice = -1;
		Scanner s = new Scanner(System.in);
		File file = new File("employee.txt");
		Scanner s1 = new Scanner(System.in);
		ArrayList<Employee> al= new ArrayList<Employee>();
		ObjectOutputStream oos = null;
		ObjectInputStream ois = null;
		ListIterator li = null;
		
		if(file.isFile()) {
			ois = new ObjectInputStream(new FileInputStream(file));
			al = (ArrayList<Employee>)ois.readObject();
			ois.close();
		}
		
		do {
			System.out.println("[1] Insert");
			System.out.println("[2] Display");
			System.out.println("[3] Search");
			System.out.println("[4] Delete");
			System.out.println("[5] Update");
			System.out.println("[6] Sort by EmpNo - On Screen");
			System.out.println("[0] Exit");
			System.out.println("Enter your choice: ");
			choice = s.nextInt();
			
			switch(choice) {
			case 1:
				
				System.out.println("Enter how many employees you want: ");
				int n = s.nextInt();
				for(int i = 0; i < n; i++) {
					System.out.print("Enter Employee No: ");
					int empno = s.nextInt();
					
					System.out.print("Enter Employee Name: ");
					String ename = s1.nextLine();
					
					System.out.print("Enter Employee Salary: ");
					int salary = s.nextInt();
					
					al.add(new Employee(empno,ename,salary));
					
				}
				try {
					oos = new ObjectOutputStream(new FileOutputStream(file));
					oos.writeObject(al);
					oos.close();
				} catch (FileNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

				
				break;
			case 2:
				if(file.isFile()) {
					ois = new ObjectInputStream(new FileInputStream(file));
					al = (ArrayList<Employee>)ois.readObject();
					ois.close();
					
					System.out.println("-------------------------------");
					li = al.listIterator();
					while(li.hasNext())
						System.out.println(li.next());
					System.out.println("-------------------------------");
				} else {
					System.out.println("File not exist.");
				}
				
				break;
			case 3:
				if(file.isFile()) {
					ois = new ObjectInputStream(new FileInputStream(file));
					al = (ArrayList<Employee>)ois.readObject();
					ois.close();
					
					boolean found = false;
					System.out.println("Enter empno to search: ");
					int empno = s.nextInt();
					System.out.println("-------------------------------");
					li = al.listIterator();
					while(li.hasNext()) {
						Employee e = (Employee)li.next();
						if(e.empno == empno) {
							System.out.println(e);
							found = true;				
						}

					}
					if(!found) {
						System.out.println("Record not found.");
					}
				} else {
					System.out.println("File not exist.");
				}
				System.out.println("-------------------------------");
				break;
			case 4:
				if(file.isFile()) {
					ois = new ObjectInputStream(new FileInputStream(file));
					al = (ArrayList<Employee>)ois.readObject();
					ois.close();
					
					boolean found = false;
					System.out.print("Enter empno to Delete: ");
					int empno = s.nextInt();
					System.out.println("-------------------------------");
					li = al.listIterator();
					while(li.hasNext()) {
						Employee e = (Employee)li.next();
						if(e.empno == empno) {
							li.remove();
							found = true;				
						}

					}
					if(found) {
						oos = new ObjectOutputStream(new FileOutputStream(file));
						oos.writeObject(al);
						oos.close();
						System.out.println("Record deleted successfully.");
						
					} else {
						System.out.println("Record not found.");
					}
				} else {
					System.out.println("File not exist.");
				}
				
				System.out.println("-------------------------------");
				break;
			case 5:
				if(file.isFile()) {
					ois = new ObjectInputStream(new FileInputStream(file));
					al = (ArrayList<Employee>)ois.readObject();
					ois.close();
					
					boolean found = false;
					System.out.print("Enter empno to Update: ");
					int empno = s.nextInt();
					System.out.println("-------------------------------");
					li = al.listIterator();
					while(li.hasNext()) {
						Employee e = (Employee)li.next();
						if(e.empno == empno) {
							System.out.println("Enter new employee name: ");
							String ename = s1.nextLine();
							
							System.out.println("Enter new salary: ");
							int salary = s.nextInt();
							
							li.set(new Employee(empno, ename, salary));
							found = true;				
						}

					}
					if(found) {
						oos = new ObjectOutputStream(new FileOutputStream(file));
						oos.writeObject(al);
						oos.close();
						System.out.println("Record deleted successfully.");
						
					} else {
						System.out.println("Record not found.");
					}
				} else {
					System.out.println("File not exist.");
				}
				
				System.out.println("-------------------------------");
				break;
			case 6:
				if(file.isFile()) {
					ois = new ObjectInputStream(new FileInputStream(file));
					al = (ArrayList<Employee>)ois.readObject();
					ois.close();
					
					Collections.sort(al, new Comparator<Employee>(){

						@Override
						public int compare(Employee e1, Employee e2) {
							return e1.empno - e2.empno;
						}
						
					});
					
					System.out.println("-------------------------------");
					li = al.listIterator();
					while(li.hasNext())
						System.out.println(li.next());
					System.out.println("-------------------------------");
				} else {
					System.out.println("File not exist.");
				}
				
				break;
			}

		} while(choice !=0);
	}
		
	}
