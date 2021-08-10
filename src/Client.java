import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class Client {
    static List<Phonebook> listPhoneBook = new ArrayList<>();
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        int choice;
        do {
            showMenu();
            choice = Integer.parseInt(sc.nextLine());

            switch (choice) {
                case 1:
                    displayPhoneBook();
                    break;
                case 2:
                    addPhoneBook();
                    break;
                case 3:
                    editPhoneBook();
                    break;
                case 4:
                    deletePhoneBook();
                    break;
                case 5:
                    findPhoneBook();
                    break;
                case 6:
                    readFilePhoneBook();
                    break;
                case 7:
                    writeFilePhoneBook();
                    break;
                case 8:
                    System.out.println("Exit");
                    break;
                default:
                    System.out.println("Nhập sai");
                    break;
            }
        }while(choice!=8);
    }

    private static void writeFilePhoneBook() {
        System.out.println("Bắt đầu ghi file:");
        FileOutputStream fos = null;
        try {
            fos = new FileOutputStream("src/phone.txt",true);

            for (Phonebook phonebook : listPhoneBook){
                String line = phonebook.getFileLine();

                byte[] b = line.getBytes(StandardCharsets.UTF_8);

                fos.write(b);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if (fos != null){
                try {
                    fos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private static void readFilePhoneBook() {
        FileInputStream fis = null;
        InputStreamReader reader = null;
        BufferedReader bufferedReader = null;

        try {
            fis = new FileInputStream("phone.txt");

            reader = new InputStreamReader(fis, StandardCharsets.UTF_8);

            bufferedReader = new BufferedReader(reader);

            String line = null;

            while ((line = bufferedReader.readLine()) !=null){
                if(line.isEmpty()){
                    continue;
                }
                Phonebook phonebook = new Phonebook();
                phonebook.parse(line);

                listPhoneBook.add(phonebook);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if(fis!=null){
                try {
                    fis.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if(reader != null){
                try {
                    reader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if(bufferedReader!=null){
                try {
                    bufferedReader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    private static void findPhoneBook() {
        System.out.println("Nhập số điện thoại để tìm kiếm:");
        int id = Integer.parseInt(sc.nextLine());

        for (Phonebook phonebook : listPhoneBook){
            if(phonebook.getPhoneNumber()==id){
                phonebook.display();
            }
        }

    }

    private static void deletePhoneBook() {
        System.out.println("Nhập số điện thoại để xoá:");
        int id = Integer.parseInt(sc.nextLine());

        for (Phonebook phonebook : listPhoneBook) {
            if(phonebook.getPhoneNumber()==id){
                listPhoneBook.remove(phonebook);
                break;
            }
        }
    }

    private static void editPhoneBook() {
        System.out.println("Nhập số điện thoại để sửa:");
        int id = Integer.parseInt(sc.nextLine());

        for (Phonebook phonebook : listPhoneBook){
            if(phonebook.getPhoneNumber()==id){
                phonebook.input();
                break;
            }
        }
    }

    private static void addPhoneBook() {
        System.out.println("Nhập số lượng danh bạ cần thêm:");
        int n = Integer.parseInt(sc.nextLine());

        for (int i =0; i<n;i++){
            Phonebook phonebook = new Phonebook();
            phonebook.input();
            listPhoneBook.add(phonebook);
        }
    }

    private static void displayPhoneBook() {
        for(Phonebook phonebook : listPhoneBook){
            phonebook.display();
        }
    }

    public static void showMenu() {
        System.out.println("----CHƯƠNG TRÌNH QUẢN LÝ DANH BẠ----");
        System.out.println("Chọn chức năng theo số (để tiếp tục):");
        System.out.println("1. Xem danh sách");
        System.out.println("2. Thêm mới");
        System.out.println("3. Cập nhật");
        System.out.println("4. Xoá");
        System.out.println("5. Tìm kiếm");
        System.out.println("6. Đọc từ file");
        System.out.println("7. Ghi vào file");
        System.out.println("8. Thoát");
    }
}
