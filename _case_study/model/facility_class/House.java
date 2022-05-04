package _case_study.model.facility_class;

import _case_study.utils.FormatString;

import java.util.Objects;

public class House extends Facility {
    private String typeOfRoom; //Tiêu chuẩn phòng
    private int numberfloor;

    public House () {
        super();
        this.typeOfRoom = "";
        this.numberfloor = 0;
    }

    public House (String idService , double area , int price ,
                  int maximumPerson , String nameService , String typeOfBorrow ,
                  String typeOfRoom , int numberfloor) {
        super(idService , area , price , maximumPerson , nameService , typeOfBorrow);
        this.typeOfRoom = typeOfRoom;
        this.numberfloor = numberfloor;
    }

    public void inputData(){
        boolean flag;
        super.inputData();
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
                "\nTiêu chuẩn phòng: " + this.getTypeOfRoom() + "\n" +
                "Số tầng: " + this.getNumberFloor();
    }
}
