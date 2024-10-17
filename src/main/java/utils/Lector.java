package utils;

import java.util.Scanner;

public class Lector {

    private static final Scanner scanner = new Scanner(System.in);

    public static short readOption(String message){

        short option = -1;

        try {
            option = scanner.nextShort();
            scanner.nextLine();
        } catch (Exception e) {
            System.out.println(message);
            scanner.next();
        }
        return option;
    }

    public static String readEntry(String message) {
        System.out.print(message);
        return scanner.nextLine();
    }
}
 