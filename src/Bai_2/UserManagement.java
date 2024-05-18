package Bai_2;

import java.sql.*;
import java.util.Scanner;

public class UserManagement {
    private static final String USER = "root";
    private static final String PASSWORD = "123456789";
    private static final String URL = "jdbc:mysql://localhost:3306/THONGTIN";

    public static void main(String[] args) {
        User user = new User("username12", "123456");
        int res = loginUserUsingPrepareStatement(user);
        Scanner input = new Scanner(System.in);
        if(res > 0) {
            System.out.println("Login thành công.");
            int choice;
            do {
                System.out.println("========= MENU =========");
                System.out.println("1. Giải phương trình bậc nhất.");
                System.out.println("2. Giải phương trình bậc hai.");
                System.out.println("3. Kiểm tra số nguyên tố.");
                System.out.println("3. Số Fibonaci.");
                System.out.println("0. Dừng chương trình.");
                choice = input.nextInt();
                switch (choice) {
                    case 0 -> System.out.println("Chương trình đã dừng lại.");
                    case 1 -> {
                        System.out.print("Nhập a: ");
                        int a = input.nextInt();
                        System.out.print("Nhập b: ");
                        int b = input.nextInt();
                        solveLinearEquation(a, b);
                    }
                    case 2 -> {
                        System.out.print("Nhập a: ");
                        int a = input.nextInt();
                        System.out.print("Nhập b: ");
                        int b = input.nextInt();
                        System.out.print("Nhập c: ");
                        int c = input.nextInt();
                        solveQuadraticEquation(a, b, c);
                    }
                    case 3 -> {
                        System.out.print("Nhập số muốn kiểm tra có phải là số nguyên tố hay không: ");
                        int nums = input.nextInt();
                        boolean result = checkIsPrime(nums);
                        if(result) System.out.println(nums + " chính là một số nguyên tố.");
                        else System.out.println(nums + " Không phải là một số nguyên tố.");
                    }
                    case 4 -> {
                        System.out.print("Nhập số muốn kiểm tra nó có phải là số fibonacci hay không: ");
                        int nums = input.nextInt();
                        boolean result = checkFibonacci(nums);
                        if(result) System.out.println(nums + " chính là 1 só fibonacci.");
                        else System.out.println(nums + " không phải là 1 số fibonacci.");
                    }
                    default -> System.out.println("Thanks!!");
                }
            } while(choice != 0);
        } else {
            System.out.println("Login thất bại do username hoặc password không đúng.");
        }
    }

    private static boolean checkFibonacci(int nums) {
        int[] fib = new int[93];
        fib[0] = 0;
        fib[1] = 1;
        for(int i = 2; i <= 92; ++i) {
            fib[i] = fib[i - 1] + fib[i - 2];
        }
        for(int i = 0; i <= 92; ++i) {
            if(fib[i] == nums) return true;
        }
        return false;
    }

    private static boolean checkIsPrime(int nums) {
        if(nums < 2) return false;
        for(int i = 2; i <= Math.sqrt(nums); ++i) {
            if(nums % i == 0) return false;
        }
        return true;
    }

    private static void solveQuadraticEquation(int a, int b, int c) {
        if(a == 0) {
            solveLinearEquation(b, c);
            if(b == 0) {
                System.out.println("Phương trình vô nghiệm.");
            }
        } else {
            double delta = (b * b) - 4 * (a * c);
            if(delta > 0) {
                double x1 = (-b + Math.sqrt(delta)) / (2 * a);
                double x2 = (-b - Math.sqrt(delta)) / (2 * a);
                System.out.println("Nghiệm thứ nhất của phương trình là: x1 = " + x1);
                System.out.println("Nghiệm thứ hai của phương trình là: x2 = " + x2);
            } else if(delta == 0) {
                double x = 1.0 * - b / (2 * a);
                System.out.println("Phương trình có nghiệm kép: x = " + x);
            } else System.out.println("Phương trình vô nghiệm.");
        }
    }

    private static void solveLinearEquation(int a, int b) {

        if(a == 0) {
            if(b == 0) System.out.println("Phương trình có vô số nghiệm.");
            else System.out.println("Phương trình vô nghiệm.");
        } else {
            double x = 1.0 * -b / a;
            System.out.println("Nghiệm của phương trình là: x = " + x);
        }
    }


    private static int loginUserUsingPrepareStatement(User user) {
        try(Connection connection = DriverManager.getConnection(URL, USER, PASSWORD)) {
            String sqlStatement = "SELECT * FROM users WHERE username = ? AND password = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(sqlStatement);
            preparedStatement.setString(1, user.getUsername());
            preparedStatement.setString(2, user.getPassword());
            ResultSet resultSet = preparedStatement.executeQuery();
            if(resultSet.next()) return 1;
            else return -1;
        } catch (SQLException e) {
            e.printStackTrace();
            return -1;
        }
    }
}
