package _case_study.model.facility_class;

import _case_study.utils.FormatString;

public class Villa extends Facility {
    private String typeOfRoom; //Tiêu chuẩn phòng
    private double areaPool;
    private int numberfloor;

    public Villa () {
        super();
        this.areaPool = 0.0d;
        this.numberfloor = 0;
        this.typeOfRoom = "";
    }

    public Villa (String idService , double area , int price ,
                  int maximumPerson , String nameService , String typeOfBorrow ,
                  String typeOfRoom , double areaPool , int numberfloor) {
        super(idService , area , price , maximumPerson , nameService , typeOfBorrow);
        this.typeOfRoom = typeOfRoom;
        this.areaPool = areaPool;
        this.numberfloor = numberfloor;
    }

    public void inputData () {
        super.inputData();
        boolean flag;
        //Nhập diện tích hồ bơi
        do {
            flag = true;
            try {
                System.out.print("Nhập diện tích hồ bơi (lớn hơn 0): ");
                this.setAreaPool(Double.parseDouble(scn.nextLine()));
            } catch (NumberFormatException e) {
                flag = false;
            }
        } while (this.getAreaPool() < 0 || !flag);

        //Nhập tiêu chuẩn phòng
        do {
            System.out.print("Tiêu chuẩn phòng (VIP, Normal, Member): ");
            this.setTypeOfRoom(scn.nextLine());
        }while (!new FormatString().typeService(this.getTypeOfRoom()));

        //Nhập số tầng
        do {
            flag = true;
            try {
                System.out.print("Nhập số tầng (lớn hơn 0): ");
                this.setNumberFloor(Integer.parseInt(scn.nextLine()));
            } catch (NumberFormatException e) {
                flag = false;
            }
        }while (this.getNumberFloor() < 0 || !flag);
    }

    public double getAreaPool () {
        return areaPool;
    }

    public void setAreaPool (double areaPool) {
        this.areaPool = areaPool;
    }

    public String getTypeOfRoom () {
        return typeOfRoom;
    }

    public void setTypeOfRoom (String typeOfRoom) {
        this.typeOfRoom = typeOfRoom;
    }

    public int getNumberFloor () {
        return numberfloor;
    }

    public void setNumberFloor (int numberfloor) {
        this.numberfloor = numberfloor;
    }

    @Override
    public String toString () {
        return super.toString() +
                "Diện tích hồ bơi: " + this.getAreaPool() + "\n" +
                "Tiêu chuẩn phòng: " + this.getTypeOfRoom() + "\n" +
                "Số tầng: " + this.getNumberFloor();
    }
}
