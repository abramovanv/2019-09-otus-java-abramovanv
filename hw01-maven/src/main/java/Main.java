import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.print("Input a String: ");
        String str = in.nextLine();
        HelloOtus ho = new HelloOtus(str);
        System.out.println(ho.GetResult());

    }
}