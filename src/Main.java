import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Oynamak istediğiniz satır: ");
        int satir = scanner.nextInt();
        System.out.print("Oynamak istediğiniz sütun: ");
        int sutun = scanner.nextInt();
        MineSweeper mineSweeper = new MineSweeper(satir,sutun);
        mineSweeper.run();
    }
}
