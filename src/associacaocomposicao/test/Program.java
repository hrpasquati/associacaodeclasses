package associacaocomposicao.test;

import associacaocomposicao.classes.Department;
import associacaocomposicao.classes.HourContract;
import associacaocomposicao.classes.WorkedLevel;
import associacaocomposicao.classes.Worker;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

public class Program {
    public static void main(String[] args) throws ParseException {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

        System.out.print("Enter department's name: ");
        String departmentName = sc.nextLine();
        System.out.println("Enter worker data: ");
        System.out.print("Name: ");
        String workerName = sc.nextLine();
        System.out.print("Level: ");
        String workedLevel = sc.nextLine();
        System.out.print("Base salary: ");
        double baseSalary = sc.nextDouble();

        Worker worker = new Worker(workerName, WorkedLevel.valueOf(workedLevel), baseSalary, new Department(departmentName));

        System.out.print("How many contracts to this worker? ");
        int n = sc.nextInt();

        for (int i = 0; i < n; i++) {
            System.out.println("Enter contract " + i + " data: ");
            System.out.println("Date (DD/MM/YYYY)");
            Date contractDate = sdf.parse(sc.next());
            System.out.print(" Value per hour: ");
            double valurPerHour = sc.nextDouble();
            System.out.print("Duration(hours): ");
            int hours = sc.nextInt();
            HourContract contract = new HourContract(contractDate, valurPerHour, hours);
            worker.addContract(contract);
        }

        System.out.println();
        System.out.print("Enter month and year to calculate income (MM/YYYY): ");
        String monthAndYear = sc.next();
        int month = Integer.parseInt(monthAndYear.substring(0, 2));
        int year = Integer.parseInt(monthAndYear.substring(3));
        System.out.println("Name: " + worker.getName());
        System.out.println("Departament: " + worker.getDepartment().getDepartmentName());
        System.out.println("Income for: " + monthAndYear + " : " + String.format("%.2f", worker.income(year, month)));


        sc.close();

    }
}
