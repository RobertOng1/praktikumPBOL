import java.util.Scanner;
import java.util.HashMap;
import java.util.Map;

public class challenge
{
    //fungsi validasi apakah nim sudah ada di Hashmap daftarMahasiswa
    public static int validasi(Map<Integer, String> daftarMahasiswa, int nim)
    {
        for(Integer nim2 : daftarMahasiswa.keySet()){ //looping semua kunci hashmap (nim)
            if(nim2 == nim){
                return 1; //return 1 jika sudah ada
            }
        }
        return 0; //return 0 jika belum ada
    }

    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        Map<Integer, String> daftarMahasiswa = new HashMap<>();
        int status = 1;
        while(status == 1){
            System.out.println("====Selamat datang di database mahasiswa====");
            System.out.print("1. Tambah mahasiswa\n2. Lihat mahasiswa\n3. Update mahasiswa\n4. Hapus mahasiswa\n5. Exit\nPilihan: ");
            int pilihan = scanner.nextInt(); 
            scanner.nextLine(); //mengambil /n yang ditinggalkan scanner.nextInt();
            switch(pilihan){
            case 1: 
            {
                System.out.print("Masukkan nama mahasiswa baru: ");
                String nama = scanner.nextLine();
                System.out.print("Masukkan NIM mahasiswa baru: ");
                int nim = scanner.nextInt();
                scanner.nextLine(); //mengambil /n yang ditinggalkan scanner.nextInt();
                int validasi = validasi(daftarMahasiswa, nim);
                if(validasi == 0){
                    daftarMahasiswa.put(nim, nama);
                    System.out.println("Data berhasil ditambahkan.\n");
                } else {
                    System.out.println("NIM sudah terdaftar.\n");
                }
                break;
            }
            case 2:
            {
                if(!daftarMahasiswa.isEmpty()){
                    for (Map.Entry<Integer, String> data : daftarMahasiswa.entrySet()) {
                        System.out.println("NIM: " + data.getKey() + ", Nama: " + data.getValue());
                    }
                    System.out.println();
                } else {
                    System.out.println("Belum ada mahasiswa.\n");
                }
                break;
            }
            case 3: 
            {
                System.out.print("Masukkan NIM yang ingin di-update: ");
                int nim = scanner.nextInt();
                scanner.nextLine();
                int validasi = validasi(daftarMahasiswa, nim);
                if(validasi == 1){
                    System.out.print("Masukkan nama mahasiswa yang di-update: ");
                    String nama = scanner.nextLine();
                    daftarMahasiswa.put(nim, nama);
                    System.out.println("Update berhasil.\n");
                } else 
                {
                    System.out.println("NIM tidak terdaftar.\n");
                }
                break;
            }
            case 4: 
            {
                System.out.print("Masukkan NIM mahasiswa yang ingin dihapus: ");
                int nim = scanner.nextInt();
                int validasi = validasi(daftarMahasiswa, nim);
                if(validasi == 1){
                    daftarMahasiswa.remove(nim);
                    System.out.println("Delete berhasil.\n");
                } else 
                {
                    System.out.println("NIM tidak terdaftar.\n");
                }
                break;
            }
            case 5:
            default:
                status = 0;
                break;
            }
        }
    }
}