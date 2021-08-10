import java.util.Scanner;

import static java.lang.Integer.parseInt;

public class Phonebook {
    private String name;
    private int phoneNumber;
    private String address;
    private String email;
    private String facebook;

    public Phonebook(){}

    public Phonebook(String name, int phoneNumber, String address, String email, String facebook) {
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.address = address;
        this.email = email;
        this.facebook = facebook;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(int phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFacebook() {
        return facebook;
    }

    public void setFacebook(String facebook) {
        this.facebook = facebook;
    }

    public void input() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhập tên: ");
        name = sc.nextLine();

        System.out.println("Nhập số điện thoại:");
        phoneNumber = Integer.parseInt(sc.nextLine());

        System.out.println("Nhập địa chỉ: ");
        address = sc.nextLine();

        System.out.println("Nhập email:");
        email = sc.nextLine();

        System.out.println("Nhập facebook:");
        facebook = sc.nextLine();
    }

    public void display(){
        System.out.println(this);
    }

    public String getFileLine() {
        return name + "," + phoneNumber + "," + address + "," + email + ","+ facebook + "\n";
    }

    public void parse(String line) {
        String[] params = line.split(",");

        try {
            name = params[0];
            phoneNumber = parseInt(params[1]);
            address = params[2];
            email = params[3];
            facebook = params[4];
        } catch (ArrayIndexOutOfBoundsException ex) {
        } finally {
        }

    }

    @Override
    public String toString() {
        return "Phonebook{" +
                "name='" + name + '\'' +
                ", phoneNumber=" + phoneNumber +
                ", address='" + address + '\'' +
                ", email='" + email + '\'' +
                ", facebook='" + facebook + '\'' +
                '}';
    }
}
