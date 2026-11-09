package lw04.unguided;

import java.util.Scanner;

public class Main {

    public static void sortCards(int[] arr, int passes) {
        int n = arr.length;
        for (int i = 0; i < passes; i++) {
            int idx = i;
            for (int j = i + 1; j < n; j++) {
                if (arr[j] < arr[idx]) {
                    idx = j;
                }
            }
            int temp = arr[i];
            arr[i] = arr[idx];
            arr[idx] = temp;
        }
    }

    public static int findCard(int[] arr, int target) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == target) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(Main.class.getResourceAsStream("cards.txt"));

        int n = scanner.nextInt();
        int[] cards = new int[n];
        for (int i = 0; i < n; i++) {
            cards[i] = scanner.nextInt();
        }

        int m = scanner.nextInt();
        int[] requests = new int[m];
        for (int i = 0; i < m; i++) {
            requests[i] = scanner.nextInt();
        }

        sortCards(cards, 2);

        for (int i = 0; i < n; i++) {
            if (i > 0) {
                System.out.print(" ");
            }
            System.out.print(cards[i]);
        }
        System.out.println();

        for (int i = 0; i < m; i++) {
            int index = findCard(cards, requests[i]);
            if (index != -1) {
                System.out.println(requests[i] + ": FOUND at index " + index);
            } else {
                System.out.println(requests[i] + ": NOT FOUND");
            }
        }

        scanner.close();
    }
}
