import entities.Employee;
import entities.OutsourceEmployee;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class Program {

    public static void main(String[] args){

        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the number of employees: ");
        int n = sc.nextInt();

        List<Employee> employees = new ArrayList<>();

        for(int i = 0; i < n; i++) {

            System.out.println("Employee #" + (i + 1) + ": ");
            System.out.print("Outsourced (y/n)? ");
            char res = sc.next().charAt(0);

            System.out.print("Name: ");
            sc.nextLine();
            String name = sc.next();
            System.out.print("Hours: ");
            int hours = sc.nextInt();
            System.out.print("Value per hour: ");
            double value = sc.nextDouble();

            if (res == 'y') {
                System.out.print("Additional charge: ");
                double add = sc.nextDouble();
                employees.add(new OutsourceEmployee(name, hours, value, add));
            } else {
                employees.add(new Employee(name, hours, value));
            }
        }

        System.out.println();
        System.out.println("PAYMENTS");

        for(Employee e: employees){
            System.out.println(e.getName() + " - $" + String.format("%.2f", e.Payment()));
        }
        sc.close();
    }
}
