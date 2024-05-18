package Bai_1;

import java.util.ArrayList;
import java.util.Scanner;

public class TuyenSinh {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in); // tạo đối tượng của Scanner để nhập
        ArrayList<ThiSinh> thiSinhList = new ArrayList<>(); // Tạo ra 1 list đối tượng của ThiSinh
        int choice; // biến choice để lựa chọn ở menu
        do { // do while để thực hiện chọn thao tác trong menu
            System.out.println("============ MENU ============");
            System.out.println("1. Nhập danh sách thí sinh.");
            System.out.println("2. Hiển thị danh sách thí sinh.");
            System.out.println("3. Tìm kiếm thí sinh theo số báo danh.");
            System.out.println("0. Dừng chương trình.");
            System.out.print("Nhập lựa chọn của bạn: ");
            choice = input.nextInt(); // nhập giá trị cho choice
            input.nextLine(); // này để xuống dòng, tránh việc bị nhảy dòng khi chưa ngắt khi nhập với Scanner
            switch (choice) {
                case 0 -> System.out.println("Chương trình đã được dừng."); // chọn choice = 0 thì dừng
                case 1 -> { // chọn choice = 1 thì sẽ nhập thí sinh
                    System.out.print("Nhập số lượng thí sinh mà bạn muốn nhập vào danh sách: ");
                    int n = input.nextInt(); // nhập số lượng thí sinh muốn nhập vào danh sách
                    input.nextLine(); // tương tự như ở trên nhé
                    while (n != 0) { // vòng while để thực hiện việc nhập thí sinh;
                        ThiSinh createNewThiSinh = createThiSinh(input); // createNewThiSinh là đối tượng của ThiSinh
                        // nó bằng với hàm createThiSinh, và hàm đấy trả về 1 đối tượng của ThiSinh
                        // truyền input là đối tượng của Scanner vào để có thể thực hiện việc nhập ở hàm đấy
                        System.out.println("===============================");
                        thiSinhList.add(createNewThiSinh); // này là truyền giá trị của createNewThiSinh vào trong list
                        //List ở đây chính là thiSinhList ở dòng 9
                        n--; // này là sau khi nhập 1 thí sinh vào thì trừ đi n 1 đơn vị, nếu sau khi trừ đi
                        // n 1 đơn vị và n = 0 thì vòng lặp while dừng lại.
                    }
                }
                case 2 -> getAllListThiSinh(thiSinhList); // choice = 2 thì gọi method getALlListThiSinh
                // và method đó nhận vào 1 list thiSinhList ở dòng 9
                case 3 -> {
                    if (!thiSinhList.isEmpty()) {
                        System.out.print("Nhập số báo danh mà bạn muốn tìm kiếm: ");
                        String sbd = input.nextLine();
                        ArrayList<ThiSinh> res = searchBySBD(thiSinhList, sbd);
                        if (res.isEmpty()) {
                            System.out.println("Không tìm thấy thí sinh có số báo danh " + sbd);
                        } else {
                            for (ThiSinh thiSinh : res) {
                                showThiSinh(thiSinh);
                            }
                        }
                    } else {
                        System.out.println("Danh sách rỗng.");
                    }
                }
            }
        } while (choice != 0);


    }

    private static ThiSinh createThiSinh(Scanner input) {
        System.out.print("Nhập số báo danh thí sinh: ");
        String sbd = input.nextLine();
        System.out.print("Nhập họ tên thí sinh: ");
        String hoTen = input.nextLine();
        System.out.print("Nhập địa chỉ thí sinh: ");
        String diaChi = input.nextLine();
        System.out.print("Nhập ưu tiên của thí sinh: ");
        String uuTien = input.nextLine();
        return new ThiSinh(sbd, hoTen, diaChi, uuTien);
    }

    private static void getAllListThiSinh(ArrayList<ThiSinh> thiSinhList) {
        for (ThiSinh thiSinh : thiSinhList) {
            showThiSinh(thiSinh);
        }
    }

    private static void showThiSinh(ThiSinh thiSinh) {
        System.out.println("Số báo danh: " + thiSinh.getSbd());
        System.out.println("Họ tên: " + thiSinh.getHoTen());
        System.out.println("Địa chỉ: " + thiSinh.getDiaChi());
        System.out.println("Ưu tiên: " + thiSinh.getUuTien());
        System.out.println();
    }

    private static ArrayList<ThiSinh> searchBySBD(ArrayList<ThiSinh> thiSinhList, String sbd) {
        ArrayList<ThiSinh> thiSinhArrayList = new ArrayList<>();
        for (ThiSinh thiSinh : thiSinhList) {
            String sbdThiSinh = thiSinh.getSbd();
            if (sbdThiSinh.compareToIgnoreCase(sbd) == 0) {
                thiSinhArrayList.add(thiSinh);
            }
        }
        return thiSinhArrayList;
    }
}
