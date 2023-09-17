package org.example.app.views.employees;

import java.util.Scanner;

public class EmployeeCreateView {

    public String[] getData() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter Last Name: ");
        String lastName = scanner.nextLine().trim();
        System.out.print("Enter First Name: ");
        String firstName = scanner.nextLine().trim();
        System.out.print("Enter Birth Date (YYYY/MM/DD): ");
        String birthDate = scanner.nextLine().trim();
        System.out.print("Enter Position Id: ");
        String positionId = scanner.nextLine().trim();
        System.out.print("Enter Phone (***-***-**-**): ");
        String phone = scanner.nextLine().trim();
        System.out.print("Enter Salary (****,**): ");
        String salary = scanner.nextLine().trim();

        return new String[]{lastName, firstName, birthDate, positionId, phone, salary};
    }

    public void getOutput(String output) {
        System.out.println(output);
    }
}
