import java.util.Scanner;

public class MineSweeper {
    private int satirSayisi;
    private int sutunSayisi;
    private char[][] harita;
    private char[][] mayinliHarita;
    private static int mayinSayisi;
    private boolean game = true;
    private Scanner scanner = new Scanner(System.in);

    public MineSweeper(int satirSayisi, int sutunSayisi) {
        this.satirSayisi = satirSayisi;
        this.sutunSayisi = sutunSayisi;
        harita = new char[satirSayisi][sutunSayisi];
        mayinliHarita = new char[satirSayisi][sutunSayisi];
        mayinSayisi = (satirSayisi * sutunSayisi) / 4;
    }

    public void run() {
        prepareGame();
        print(harita);

        int satir;
        int sutun;
        while (game){
            do {
                System.out.print("Satır giriniz: ");
                satir = scanner.nextInt();
                System.out.println();
            } while (satir < 0 || satir > satirSayisi);
            satir--;

            do {
                System.out.print("Sütun giriniz: ");
                sutun = scanner.nextInt();
                System.out.println();
            } while (sutun < 0 || sutun > sutunSayisi);
            sutun--;

            if (mayinliHarita[satir][sutun] == '*'){
                System.out.println("Kaybettiniz!");
                print(mayinliHarita);
                game = false;
                break;
            }
            
            harita[satir][sutun] = check(satir,sutun);
            mayinliHarita[satir][sutun] = check(satir,sutun);

            print(harita);
            if (isWin()){
                System.out.println("Oyunu Kazandınız!");
                print(mayinliHarita);
                game = false;
            }
        }
    }

    public char check(int r,int c){
        int sayac = '0';
        if (((r-1) >= 0) && ((c-1) >= 0)){
            if (mayinliHarita[r-1][c-1] == '*')
                sayac++;
        }
        if (((r-1) >= 0) && (c >= 0)){
            if (mayinliHarita[r-1][c] == '*')
                sayac++;
        }
        if (((r-1) >= 0) && ((c+1) >= 0) && ((c+1) < sutunSayisi)){
            if (mayinliHarita[r-1][c+1] == '*')
                sayac++;
        }
        if ((r) >= 0 && (c-1) >= 0){
            if (mayinliHarita[r][c-1] == '*')
                sayac++;
        }
        if ((r >= 0) && ((c+1) >= 0) && ((c+1) < sutunSayisi)){
            if (mayinliHarita[r][c+1] == '*')
                sayac++;
        }
        if (((r+1) >= 0) && ((c-1) >= 0) && ((r+1) < satirSayisi)){
            if (mayinliHarita[r+1][c-1] == '*')
                sayac++;
        }
        if (((r+1) >= 0) && (c >= 0) && ((r+1) < satirSayisi)){
            if (mayinliHarita[r+1][c] == '*')
                sayac++;
        }
        if (((r+1) >= 0) && ((c+1) >= 0) && ((r+1) < satirSayisi) && ((c+1) < sutunSayisi)){
            if (mayinliHarita[r+1][c+1] == '*')
                sayac++;
        }
        char sonuc = (char) sayac;
        return sonuc;
    }

    public void print(char[][] arr){
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }

    public void prepareGame(){
        for (int i = 0; i < harita.length; i++) {
            for (int j = 0; j < harita[i].length; j++) {
                harita[i][j] = '-';
            }
        }

        for (int i = 0; i < mayinliHarita.length; i++) {
            for (int j = 0; j < mayinliHarita[i].length; j++) {
                mayinliHarita[i][j] = '-';
            }
        }

        int rastgeleSatir;
        int rastgeleSutun;
        while (mayinSayisi > 0) {
            rastgeleSatir = (int) (Math.random() * satirSayisi);
            rastgeleSutun = (int) (Math.random() * sutunSayisi);
            mayinliHarita[rastgeleSatir][rastgeleSutun] = '*';
            mayinSayisi--;
        }
    }

    public boolean isWin(){
        int sayac = 0;
        for (int i = 0; i < mayinliHarita.length; i++) {
            for (int j = 0; j < mayinliHarita[i].length; j++) {
                if (mayinliHarita[i][j] == '-') {
                    sayac++;
                }
            }
        }
        if (sayac == 0)
            return true;
        else
            return false;
    }
}
