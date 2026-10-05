import java.util.ArrayList;
import java.util.Scanner;

public class StatistikNilai {

    // Penanda "sudah selesai", sama seperti minggu lalu
    static final int SELESAI = -1;

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        ArrayList<Integer> daftar = new ArrayList<>();

        // ===== [TAHAP 1] Baca nilai sampai -1 =====
        System.out.println("===== STATISTIK NILAI KELAS =====");
        System.out.println("Ketik -1 kalau sudah selesai.");

        int nilai;
        do {
            System.out.print("Nilai ke-" + (daftar.size() + 1) + " : ");
            nilai = input.nextInt();

            if (nilai == SELESAI) {
                continue;
            }

            if (nilai < 0 || nilai > 100) {
                System.out.println("  Ditolak, harus 0-100");
                continue;
            }

            daftar.add(nilai);
        } while (nilai != SELESAI);

        System.out.println();

        // ===== [TAHAP 2] Kasus kosong =====
        if (daftar.isEmpty()) {
            System.out.println("Belum ada nilai yang sah, jadi tidak ada yang bisa dihitung.");
            return;
        }

