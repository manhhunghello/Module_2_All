package service;

import Model.Brand;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BrandManager implements Manager {
    List<Brand> brandList;
    Scanner scanner;
    FileManager fileManager = new FileManager() ;

    public BrandManager() {
        brandList = new ArrayList<>();
        scanner = new Scanner(System.in);
        try {

            fileManager.readFileBrand(brandList);
        }catch (RuntimeException e){
            System.out.println(e.getMessage());
        }
        checkDefaultIndex();

    }

    @Override
    public List<Brand> add() {
        System.out.println("Nhập tên Brand: ");
        String name = scanner.nextLine();
        Brand brand = new Brand(name);
        brandList.add(brand);
        fileManager.writeFileBrand(brandList);
        return brandList;
    }


    @Override
    public List<Brand> update() {
        int idUpDate = 0 ;
        int count = 0;
        display();
        do {

            try {
                System.out.println(" Nhập id của Brand mà bạn muốn chỉnh sửa");
                idUpDate = Integer.parseInt(scanner.nextLine());

            } catch (IndexOutOfBoundsException e) {
                System.out.println(e.getMessage());
            }
        } while (count < 3);
        for (Brand e : brandList) {
            if (e.getId() == idUpDate) {
                System.out.println(" Nhập tên theo Id mà admin muốn sửa ");
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
        int idDelete = 0;
        int count = 0;
        System.out.println(" Nhập id của Brand mà bạn muốn xoá");
        idDelete = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < brandList.size(); i++) {
            if (brandList.get(i).getId() == idDelete) {
                brandList.remove(i);
            }

        }
        fileManager.writeFileBrand(brandList);

        return brandList;
    }

    public Brand getByIdBrand() {
        int idBrand;
        do {
            try {
                System.out.println(" lựa chọn Id bạn muốn thao tác: ");
                idBrand = Integer.parseInt(scanner.nextLine());
                break;
            } catch (NumberFormatException e) {
                System.err.println(" sai định dạng ! Vui lòng nhập lại. ");
            }
        } while (true);
        for (Brand b:brandList) {
            if (b.getId() == idBrand){
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

    @Override
    public void display() {
        for (Brand brand : brandList) {
            System.out.println(brand);

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
