package lw03.unguided;

import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(Main.class.getResourceAsStream("enrollment.txt"));
        Map<String, Integer> enroll = new HashMap<>();
        List<String> courseOrder = new ArrayList<>();
        List<String> checkResult = new ArrayList<>();
        int failedTask = 0;
        while (sc.hasNextLine()) {
            String line = sc.nextLine().trim();
            if (line.isEmpty()) {
                continue;
            }
            String[] course = line.split(" ", 3);

            if (course[0].equals("REGISTER")) {
                int totalEnroll = Integer.parseInt(course[2]);
                if (totalEnroll <= 0) {
                    failedTask++;
                } else if (enroll.containsKey(course[1])) {
                    enroll.put(course[1], enroll.get(course[1]) + totalEnroll);
                } else {
                    enroll.put(course[1], totalEnroll);
                    courseOrder.add(course[1]);
                }
            } else if (course[0].equals("WITHDRAW")) {
                int totalRemove = Integer.parseInt(course[2]);
                if (totalRemove <= 0 || !enroll.containsKey(course[1]) || enroll.get(course[1]) < totalRemove) {
                    failedTask++;
                } else {
                    enroll.put(course[1], enroll.get(course[1]) - totalRemove);
                }
            } else if (course[0].equals("CHECK")) {
                if (enroll.containsKey(course[1])) {
                    checkResult.add(course[1] + ": " + enroll.get(course[1]) + " students");
                } else {
                    checkResult.add(course[1] + ": Not found");
                }
            }
        }
        sc.close();

        System.out.println("===== Enrollment Checks =====");
        for (String result : checkResult) {
            System.out.println(result);
        }
        System.out.println();
        System.out.println("===== Final Enrollment =====");
        for (String code : courseOrder) {
            System.out.println(code + ": " + enroll.get(code) + " students");
        }
        System.out.println();
        System.out.println("Rejected operations: " + failedTask);
    }
}