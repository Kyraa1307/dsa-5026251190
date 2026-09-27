package lw02.prelab;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

public class Main {

    public static void main(String[] args) {

        LinkedList<String[]> transactions = new LinkedList<>();
        Scanner scanner = new Scanner(Main.class.getResourceAsStream("transactions.txt"));

        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            String[] parts = line.split(" ");
            transactions.add(parts);
        }
        scanner.close();

        LinkedList<String[]> customers = new LinkedList<>();

        for (int i = 0; i < transactions.size(); i++) {
            String name = transactions.get(i)[0];
            boolean sudahAda = false;

            for (int j = 0; j < customers.size(); j++) {
                if (customers.get(j)[0].equals(name)) {
                    sudahAda = true;
                }
            }

            if (!sudahAda) {
                String[] customerBaru = {name, "0"};
                customers.add(customerBaru);
            }
        }

        Queue<String[]> queue = new LinkedList<>();
        for (int i = 0; i < transactions.size(); i++) {
            queue.add(transactions.get(i));
        }

        Stack<String[]> gagal = new Stack<>();

        while (!queue.isEmpty()) {
            String[] trx = queue.poll();
            String name = trx[0];
            String type = trx[1];
            int amount = Integer.parseInt(trx[2]);

            int index = -1;
            for (int j = 0; j < customers.size(); j++) {
                if (customers.get(j)[0].equals(name)) {
                    index = j;
                }
            }

            int balance = Integer.parseInt(customers.get(index)[1]);

            if (type.equals("DEPOSIT")) {
                balance = balance + amount;
                customers.get(index)[1] = String.valueOf(balance);
            } else if (type.equals("WITHDRAW")) {
                if (amount > balance) {
                    gagal.push(trx);
                } else {
                    balance = balance - amount;
                    customers.get(index)[1] = String.valueOf(balance);
                }
            }
        }

        System.out.println("=== Final Balances ===");
        for (int i = 0; i < customers.size(); i++) {
            String[] c = customers.get(i);
            System.out.println(c[0] + " : " + c[1]);
        }

        System.out.println();
        System.out.println("=== Failed Transactions ===");
        while (!gagal.isEmpty()) {
            String[] trx = gagal.pop();
            System.out.println(trx[0] + " " + trx[1] + " " + trx[2]);
        }
    }
}