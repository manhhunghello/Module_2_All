package service;

import Model.Account;

import javax.tools.JavaFileManager;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AccountManager {
    Scanner scanner;
    List<Account> accountList;
    FileManager fileManager;


    public AccountManager() {
        scanner = new Scanner(System.in);
        fileManager = new FileManager();
        accountList = new FileManager().readFileAccount();
        checkDefaultIndex();


    }

    public void creatNewAccount() {
        String userName;
        while (true) {
            System.out.println(" userName");
            userName = scanner.nextLine();
            if (!userName.equals("")) {
                boolean flag = true;
                for (Account account : accountList) {
                    if (userName.equals(account.getUserName()) || userName.equals("admin")) {
                        System.out.println(" Lỗi rồi !! tài khoản đã tồn tại.");
                        flag = false;
                    }
                }
                if (flag && !userName.equals("admin")) {
                    break;
                } else if (userName.equals("admin")) {
                    System.out.println(" Lỗi rồi !! tài khoản đã tồn tại.");

                }
            } else {
                System.out.println(" Hãy nhập tên tài khoản của bạn ");
            }
        }

        System.out.println("Enter PassWord ");
        String passWord;
        do {
            try {
                System.out.println("Mật khẩu phải có ít nhất 8 ký tự, với 1 ký tự viết hoa," +
                        " 1 ký tự viết thường và 1 ký tự đặc biệt");
                passWord = scanner.nextLine();
                String PASSWORD_REGEX = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{8,}$";
                if (passWord.matches(PASSWORD_REGEX)) {
                    break;
                } else {
                    System.out.println("Sai định dạng, vui lòng nhập lại ! Thank you.");
                }
            }catch (IndexOutOfBoundsException e){
                e.getMessage();
            }

        } while (true);

        System.out.println("Full Name");
        String fullName = scanner.nextLine();
        System.out.println("Phone Number");
        String phoneNumber;
        do {
            try {
                System.out.println(" Số điện thoại phải bắt đầu bằng 84 hoặc số 0, Chỉ có thể là 10 số theo nhà mạng của Việt Nam");
                phoneNumber = scanner.nextLine();
                String PHONE_REGEX = "^(?:\\+?84|0)(?:\\d){9}$";

                if (phoneNumber.matches(PHONE_REGEX)) {
                    for (Account account : accountList) {
                        if (phoneNumber.equals(account.getPhoneNumber())) {
                            System.out.println("Số điện thoại đã tồn tại");
                        }
                    }
                    break;
                } else {
                    System.out.println("Sai định dạng, vui lòng nhập lại ! Thank you.");
                }
            }catch (IndexOutOfBoundsException e){
                e.getMessage();
            }
        } while (true);
        System.out.println(" Account.txt được taọ thành công");
        Account account = new Account(userName, passWord, fullName, phoneNumber);
        accountList.add(account);
        fileManager.writeFileAccount(accountList);

    }

    public String login() {
        System.out.println("Enter UserName");
        String user = scanner.nextLine();
        System.out.println(" Enter PassWord");
        String pass = scanner.nextLine();
        if (user.equals("admin") && pass.equals("aaa")) {
            System.out.println("------- Hello Admin Đẹp Trai ---------");
            return "admin";
        } else {
            for (Account a : accountList) {
                if (a.getUserName().equals(user) && a.getPassWord().equals(pass)) {
                    System.out.println(" Xin Chào ! Bạn đã đăng nhập thành công");
                    ArrayList<Account> loggingUser = new ArrayList<>();
                    // Lấy tài khoản tương ứng với user bằng cách gọi
                    // phương thức getAccountUserName(user) và gán cho biến account.
                    Account account = getAccountUserName(user);
                    loggingUser.add(account);
                    fileManager.writeFileAccountLogIn(loggingUser);
                    return user;


                }

            }
        }
        return null;
    }
    public Account getAccountUserName(String username){
        for (Account account: accountList) {
            if (account.getUserName().equals(username)){
                return account;
            }

        }

        return null;
    }

private void checkDefaultIndex(){
    if (accountList.isEmpty()) {
        // Nếu rỗng( không có tài khoản trong danh sách) thì chỉ mục là 0
        Account.idUpAccount = 0;
    } else {
        Account.idUpAccount = accountList.get(accountList.size() - 1).getId();
    }

}




}

