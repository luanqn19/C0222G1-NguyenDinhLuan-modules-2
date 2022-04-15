package _12_java_collection_framework.exercise._linked_list;

public class Product {
    private String id;
    private String nameProduct;
    private int amount;
    private int price;

    public Product () {
    }

    public Product (String id , String nameProduct , int amount , int price) {
        this.id = id;
        this.nameProduct = nameProduct;
        this.amount = amount;
        this.price = price;
    }

    @Override
    public String toString () {
        return "Product{" +
                "id='" + id + '\'' +
                ", nameProduct='" + nameProduct + '\'' +
                ", amount=" + amount +
                ", price=" + price +
                '}';
    }

    public void display(){
        System.out.println("ID: " + this.getId());
        System.out.println("Tên sản phẩm: " + this.getNameProduct());
        System.out.println("Số lượng: " + this.getAmount());
        System.out.println("Giá: " + this.getPrice());
    }

    public String getId () {
        return id;
    }

    public void setId (String id) {
        this.id = id;
    }

    public String getNameProduct () {
        return nameProduct;
    }

    public void setNameProduct (String nameProduct) {
        this.nameProduct = nameProduct;
    }

    public int getAmount () {
        return amount;
    }

    public void setAmount (int amount) {
        this.amount = amount;
    }

    public int getPrice () {
        return price;
    }

    public void setPrice (int price) {
        this.price = price;
    }
}
