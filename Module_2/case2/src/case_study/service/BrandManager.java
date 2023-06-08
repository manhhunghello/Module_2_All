package case_study.service;

import case_study.model.Brand;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BrandManager implements Manager {
    private final Scanner scanner;
    private List<Brand> brandList;
    FileManager fileManager = new FileManager();
    Brand brand;


    public List<Brand> getBrandList() {
        return brandList;
    }

    public void setBrandList(List<Brand> brandList) {
        this.brandList = brandList;
    }

    public BrandManager() {
        scanner = new Scanner(System.in);
        brandList = new ArrayList<>();
        try {
            fileManager.readFileBrand(brandList);
        } catch (RuntimeException e) {
            System.out.println(e.getMessage());
        }
        checkDefaultIndex();
    }

    @Override
    public List<Brand> add() {
        System.out.println("Enter name");
        String name = scanner.nextLine();
        Brand brand = new Brand(name);
        brandList.add(brand);
        fileManager.writeFileBrand(brandList);
        return brandList;
    }

    @Override
    public List<Brand> update() {
        int idUpdate = 0;
        int count = 0;
        display();
        do {
            count++;
            try {
                System.out.println("Enter the id you want to update");
                idUpdate = Integer.parseInt(scanner.nextLine());
                break;
            } catch (NumberFormatException e) {
                System.out.println(e.getMessage());
            }
        } while (count < 3);

        for (Brand e : brandList) {
            if (e.getId() == idUpdate) {
                System.out.println("Enter the name you want to edit");
                String nameUpdate = scanner.nextLine();
                e.setBrandName(nameUpdate);
            }
        }
        fileManager.writeFileBrand(brandList);
        return brandList;
    }

    @Override
    public List<Brand> delete() {
        display();
        int count = 0;
        int idDelete;
        System.out.println("Enter the id you want to delete ");
        idDelete = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < brandList.size(); i++) {
            if (brandList.get(i).getId() == idDelete) {
                brandList.remove(i);
            }
        }
        fileManager.writeFileBrand(brandList);
        return brandList;
    }


    @Override
    public void display() {
        for (Brand b : brandList) {
            System.out.println(b);
        }
    }

    public Brand getByIdBrand() {
        int idBrand;
        do {
            try {
                System.out.println("Enter id you want: ");
                idBrand = Integer.parseInt(scanner.nextLine());
                break;
            } catch (NumberFormatException e) {
                System.err.println("Have error, please try again!");
            }
        } while (true);
        for (Brand b : brandList) {
            if (b.getId() == idBrand) {
                return b;
            }
        }
        return null;
    }

    private void checkDefaultIndex() {
        if (brandList.isEmpty()) {
            Brand.idUp1 = 0;
        } else {
            Brand.idUp1 = brandList.get(brandList.size() - 1).getId();
        }
    }

    public Brand getByNameBrand(String name) {
        for (Brand b : brandList) {
            if (b.getBrandName().equals(name)) {
                return b;
            }
        }
        return null;
    }

}
