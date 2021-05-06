package com.bridgelabz;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class EmployeePayrollService {
    public List<EmployeePayrollData> employeePayrollList = new ArrayList<>();

    public EmployeePayrollService(ArrayList<EmployeePayrollData> employeePayrollList) {
    }

    public static void main(String[] args) {
        System.out.println("Wel-Come to EmployeePayrollservice");
        ArrayList<EmployeePayrollData> employeePayrollList = new ArrayList<EmployeePayrollData>();
        EmployeePayrollService employeePayrollService = new EmployeePayrollService(employeePayrollList);
        Scanner consoleInputReader = new Scanner(System.in);
        employeePayrollService.readEmployeeData(consoleInputReader);
        employeePayrollService.writeEmployeeData();
    }

    /**
     * @writeEmployeeData method is for writing the data
     */
    private void writeEmployeeData() {
        System.out.println("\nwriting employee payroll data to console\n"+ employeePayrollList);
    }

    /**
     * @readEmployeeData method is for read data from console
     */
    private void readEmployeeData(Scanner consoleInputReader) {
        System.out.println("Enter Employee id: ");
        int id = consoleInputReader.nextInt();
        System.out.println("Enter Employee name ");
        String name = consoleInputReader.next();
        System.out.println("Enter Employee salary ");
        double salary = consoleInputReader.nextDouble();
        employeePayrollList.add(new EmployeePayrollData(id,name,salary));
    }
}
