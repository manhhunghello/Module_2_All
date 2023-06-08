package case_study.service;

import case_study.model.Account;
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
        accountList = fileManager.readFileAccount();
        checkDefaultIndex();
    }

    public void creatNewAccount() {
        String userName;
        while (true) {
            System.out.println("UserName ");
            userName = scanner.nextLine();
            if (!userName.equals("")) {
                boolean flag = true;
                for (Account account : accountList) {
                    if (userName.equals(account.getUserName()) || userName.equals("admin")) {
                        System.out.println(" Error !! The account already exists ");
                        flag = false;
                    }
                }
                if (flag && !userName.equals("admin")) {
                    break;
                } else if (userName.equals("admin")) {
                    System.out.println("  Error !! The account already exists");
                }
            } else {
                System.out.println("Please enter your account name !!");
            }

        }
        System.out.println("Enter PassWord ");
        String password;
        do {
            try {
                System.out.println("password must contain at least 8 characters with " +
                        "1 uppercase letter, 1 lowercase letter and 1 special character.");
                password = scanner.nextLine();
                String regex = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{8,}$";
                if (password.matches(regex)) {
                    break;
                } else {
                    System.out.println("Wrong format !! please re-enter");
                }

            } catch (IndexOutOfBoundsException e) {
                System.out.println(e.getMessage());
            }
        } while (true);

        System.out.println(" Full Name: ");
        String fullName = scanner.nextLine();
        System.out.println(" Phone Number: ");
        String phoneNumber;
        do {
            try {
                phoneNumber = scanner.nextLine();
                String regex = "0\\d{9}";
                if (phoneNumber.matches(regex)) {
                    for (Account account : accountList) {
                        if (phoneNumber.equals(account.getPhoneNumber())) {
                            System.out.println("Phone number already exists");
                        }
                    }
                    break;
                } else {
                    throw new IndexOutOfBoundsException(" Phone number already exists !!!");
                }
            } catch (IndexOutOfBoundsException e) {
                System.out.println(e.getMessage());
            }
        } while (true);
        System.out.println(" Account.txt successfully created !!");
        Account account = new Account(userName, password, fullName, phoneNumber);
        accountList.add(account);
        fileManager.writeFileAccount(accountList);
    }

    public String login() {
        System.out.println("Enter account");
        String user = scanner.nextLine();
        System.out.println("Enter password");
        String pass = scanner.nextLine();
        if (user.equals("admin") && pass.equals("123")) {
            System.out.println(" Hello admin!!!");
            return "admin";
        } else {
            for (Account a : accountList) {
                if (a.getUserName().equals(user) && a.getPassword().equals(pass)) {
                    System.out.println("Logged in successfully");
                    ArrayList<Account> loggingUser = new ArrayList<>();
                    Account account = getAccountUserName(user);
                    loggingUser.add(account);
                    fileManager.writeFileAccountLogIn(loggingUser);
                    return user;
                }
            }
        }
        return null;
    }

    private void checkDefaultIndex() {
        if (accountList.isEmpty()) {
            Account.idUpAccount = 0;
        } else {
            Account.idUpAccount = accountList.get(accountList.size() - 1).getId();
        }
    }

    public Account getAccountUserName(String username) {
        for (Account account : accountList) {
            if (account.getUserName().equals(username)) {
                return account;
            }
        }
        return null;
    }
}
