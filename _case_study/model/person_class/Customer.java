package _case_study.model.person_class;

import _case_study.utils.FormatString;

public class Customer extends Person {
    private static final String[] DATA_CUSTOMER_TYPE = {"Member" , "Silver" , "Gold" , "Platinium" , "Diamond"};
    private boolean isBooking = false;
    private String idCustomer;
    //Diamond: kim cương, Platinium: Bạch kim, Gold: Vàng, Silver: Bạch, Member: Thành viên
    private String customerType;

    public Customer () {
        super();
        this.isBooking = false;
        this.idCustomer = "";
        this.customerType = "";
    }

    public Customer (String name , String address ,
                     String birthDay , String phone ,
                     String email , String gender ,
                     String document , boolean isBooking ,
                     String idCustomer , String customerType) {
        super(name , address , birthDay , phone , email , gender , document);
        this.isBooking = isBooking;
        this.idCustomer = idCustomer;
        this.customerType = customerType;
    }

    public void inputData(){
        super.inputData();
        int choose = 0;
        boolean flag;

        //Nhập loại khách hàng
        System.out.println("Lựa chọn loại khách hàng: ");
        System.out.println("\t1.Thành viên. ");
        System.out.println("\t2.Bạc. ");
        System.out.println("\t3.Vàng. ");
        System.out.println("\t4.Bạch kim. ");
        System.out.println("\t5.Kim cương. ");

        do {
            flag = true;
            try {
                System.out.print("Your choose: ");
                choose = Integer.parseInt(scn.nextLine());
                if (choose < 0 && choose > 5) flag = false;
            } catch (NumberFormatException e){
                flag = false;
            }
        } while (!flag);

        switch (choose){
            case 1:
                this.setCustomerType(DATA_CUSTOMER_TYPE[0]);
                break;
            case 2:
                this.setCustomerType(DATA_CUSTOMER_TYPE[1]);
                break;
            case 3:
                this.setCustomerType(DATA_CUSTOMER_TYPE[2]);
                break;
            case 4:
                this.setCustomerType(DATA_CUSTOMER_TYPE[3]);
                break;
            case 5:
                this.setCustomerType(DATA_CUSTOMER_TYPE[4]);
                break;
        }
    }

    public boolean isBooking () {
        return isBooking;
    }

    public void setBooking (boolean booking) {
        isBooking = booking;
    }

    public String getIdCustomer () {
        return idCustomer;
    }

    public void setIdCustomer (String idCustomer) {
        this.idCustomer = idCustomer;
    }

    public String getCustomerType () {
        return customerType;
    }

    public void setCustomerType (String customerType) {
        this.customerType = customerType;
    }

    @Override
    public String toString () {
        return super.toString() +
                "ID Khách hàng: " + this.getIdCustomer() + "\n" +
                "Loại khách hàng: " + this.getCustomerType() + "\n";
    }
}
