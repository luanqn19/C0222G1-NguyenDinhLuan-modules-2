package _case_study.model.facility_class;

public class Room extends Facility {
    private String freeService;

    public Room () {
        super();
        this.freeService = "";
    }

    public Room (String idService , double area , int price ,
                 int maximumPerson , String nameService , String typeOfBorrow , String freeService) {
        super(idService , area , price , maximumPerson , nameService , typeOfBorrow);
        this.freeService = freeService;
    }

    @Override
    public void inputData () {
        super.inputData();
        System.out.print("Nhập dịch vụ miễn phí: ");
        this.setFreeService(scn.nextLine());
    }

    public String getFreeService () {
        return freeService;
    }

    public void setFreeService (String freeService) {
        this.freeService = freeService;
    }

    @Override
    public String toString () {
        return super.toString() +
                "Dịch vụ đi kèm: " + this.getFreeService() + "\n";
    }
}
