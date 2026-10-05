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

        // ===== [TAHAP 3] Jumlah, tertinggi, terendah, grade (putaran pertama) =====
        int jumlah = 0;

        int tertinggi = 0;
        int terendah = 100;

        // Index: 0=A, 1=B, 2=C, 3=D, 4=E
        int[] jumlahGrade = new int[5];

        for (int n : daftar) {
            jumlah += n;

            if (n > tertinggi) {
                tertinggi = n;
            }

            if (n < terendah) {
                terendah = n;
            }

            jumlahGrade[indexGrade(n)]++;
        }

        double rataRata = (double) jumlah / daftar.size();

        // Putaran kedua: hitung yang di atas rata-rata
        int diAtasRata = 0;

        for (int n : daftar) {
            if (n > rataRata) {
                diAtasRata++;
            }
        }

        // ===== [TAHAP 4] Salinan terurut =====
        ArrayList<Integer> terurut = new ArrayList<>(daftar);
        Collections.sort(terurut);

        // ===== Cetak hasil =====
        System.out.printf("%-16s: %s%n", "Nilai tersimpan", daftar);
        System.out.printf("%-16s: %d%n", "Jumlah", daftar.size());

        System.out.printf(
                Locale.forLanguageTag("id-ID"),
                "%-16s: %.2f%n",
                "Rata-rata",
                rataRata
        );

        System.out.printf("%-16s: %d%n", "Tertinggi", tertinggi);
        System.out.printf("%-16s: %d%n", "Terendah", terendah);
        System.out.printf("%-16s: %d orang%n", "Di atas rata2", diAtasRata);

        String[] namaGrade = {"A", "B", "C", "D", "E"};

        System.out.printf("%-16s: ", "Distribusi");

        for (int i = 0; i < jumlahGrade.length; i++) {
            System.out.print(namaGrade[i] + "=" + jumlahGrade[i] + " ");
        }

        System.out.println();

        System.out.printf("%-16s: %s%n", "Terurut", terurut);
        System.out.printf("%-16s: %s%n", "Urutan asli", daftar);
    }

    // Ubah nilai jadi index grade: A=0, B=1, C=2, D=3, E=4
    static int indexGrade(int nilai) {
        if (nilai >= 90) return 0;
        if (nilai >= 80) return 1;
        if (nilai >= 70) return 2;
        if (nilai >= 60) return 3;
        return 4;
    }
}

