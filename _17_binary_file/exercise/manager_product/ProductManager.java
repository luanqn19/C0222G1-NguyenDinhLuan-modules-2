package _17_binary_file.exercise.manager_product;

import java.io.*;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Date;
import java.util.Scanner;

public class ProductManager implements Comparator<Product> {
    private static final String FILE_PATH = "src\\_17_binary_file\\exercise\\manager_product\\product-data.dat";
    private static final Scanner scn = new Scanner(System.in);
    ArrayList<Product> data = new ArrayList<>();

    public ProductManager (){
        try {
            File file = new File(FILE_PATH);
            FileReader fileReader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            String line = "";
            if ((line = bufferedReader.readLine()) != null)
                readBinaryFile(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public boolean isSameId (String id) {
        for (Product datum : data) {
            if (datum.getId().equals(id)) {
                return false;
            }
        }
        return true;
    }

    public void writeBinaryFile () {
        try (ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(FILE_PATH))) {

            objectOutputStream.writeObject(new Date()); //Date creat
            objectOutputStream.writeUTF("Product Data"); //Name data
            objectOutputStream.writeInt(data.size()); //Amount product

            for (Product item : data) {
                objectOutputStream.writeObject(item);
            }

            objectOutputStream.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("Success!");
    }

    public void readBinaryFile(File file){
        try (ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(file))) {
            Date date = (Date) objectInputStream.readObject();
            String info = objectInputStream.readUTF();
            int productCount = objectInputStream.readInt();

            System.out.println(date);
            System.out.println(info);
            System.out.println();

            for (int i = 0 ; i < productCount ; i++) {
                Product product = (Product) objectInputStream.readObject();
                data.add(product);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e){
            e.getException();
        }
    }

    public void addProduct () {
        String name, id;
        int amount, price;

        do {
            System.out.print("Nhập id: ");
            id = scn.nextLine();
        } while (! isSameId(id));
        System.out.print("Nhập tên sản phẩm: ");
        name = scn.nextLine();
        System.out.print("Nhập số lượng: ");
        amount = Integer.parseInt(scn.nextLine());
        System.out.print("Nhập giá: ");
        price = Integer.parseInt(scn.nextLine());

        Product p = new Product(id , name , amount , price);
        data.add(p);
    }

    public void editProduct () {
        boolean flag = false;
        String id;
        System.out.print("Nhập id: ");
        id = scn.nextLine();

        for (Product datum : data) {
            if (datum.getId().equals(id)) {
                flag = true;
                System.out.print("Nhập tên sản phẩm: ");
                datum.setNameProduct(scn.nextLine());
                System.out.print("Nhập số lượng: ");
                datum.setAmount(Integer.parseInt(scn.nextLine()));
                System.out.print("Nhập giá: ");
                datum.setPrice(Integer.parseInt(scn.nextLine()));
                break;
            }
        }
        if (! flag) System.out.println("ID không tìm thấy!");
    }

    public void deleteProduct () {
        boolean flag = false;
        String id;
        System.out.print("Nhập id: ");
        id = scn.nextLine();

        for (int i = 0 ; i < data.size() ; i++) {
            if (data.get(i).getId().equals(id)) {
                flag = true;
                data.remove(i);
                System.out.println("Đã xoá sản phẩm!");
                break;
            }
        }
        if (! flag) System.out.println("ID không tìm thấy!");
    }

    public void displayList () {
        System.out.println("-------Danh sách sản phẩm-------");
        for (Product datum : data) {
            datum.display();
            System.out.println("--------------");
        }
    }

    public void searchProduct () {
        boolean flag = false;
        System.out.print("Nhập tên sản phẩm: ");
        String name = scn.nextLine();

        for (Product datum : data) {
            if (datum.getNameProduct().contains(name)) {
                flag = true;
                System.out.println("-------Sản phẩm-------");
                datum.display();
                System.out.println("----------------------");
            }
        }
        if (! flag) System.out.println("Tên sản phẩm không tìm thấy!!");
    }

    public void sortListProduct () {
        int choose;
        System.out.println("Lựa chọn sắp xếp: ");
        System.out.println("1. Sắp xếp tăng theo giá");
        System.out.println("2. Sắp xếp giảm theo giá");
        System.out.println("3. thoát");
        System.out.print("Your choose: ");
        choose = scn.nextInt();
        switch ( choose ) {
            case 1:
                data.sort(this);
                this.displayList();
                break;
            case 2:
                data.sort(this.reversed());
                this.displayList();
                break;
            case 3:
                break;
        }
    }

    @Override
    public int compare (Product o1 , Product o2) {
        return Integer.compare(o1.getPrice() , o2.getPrice());
    }
}
