package _case_study.services.implements_interface;

import _case_study.model.facility_class.Facility;
import _case_study.model.facility_class.House;
import _case_study.model.facility_class.Room;
import _case_study.model.facility_class.Villa;
import _case_study.model.other_class.Booking;
import _case_study.services.interface_services.FacilityService;
import _case_study.utils.FormatString;

import java.util.*;

public class FacilityServiceImpl implements FacilityService {
    public static final Scanner scn = new Scanner(System.in);
    private Map<Facility, Integer> dataFacility = new LinkedHashMap<>();
    private Map<Facility, Integer> dataFacilityMaintenance = new LinkedHashMap<>();

    public boolean isSameId (String id) {
        for (Map.Entry<Facility, Integer> item : dataFacility.entrySet()) {
            if (item.getKey().getIdService().equals(id)) return false;
        }
        return true;
    }

    //Kiểm tra lại
    public void equalsFacility (Facility facility) {
        Set<Facility> keySet = dataFacility.keySet();
        for (Facility item : keySet) {
            if (item.equals(facility)) {
                dataFacility.put(item , dataFacility.get(item) + 1);
                if (dataFacility.get(item) >= 5) {
                    dataFacilityMaintenance.put(facility , dataFacility.get(item));
                    dataFacility.remove(item);
                }
            } else dataFacility.put(item , 0);
        }
    }

    public void addNew () {
        int choose = 0;
        boolean flag;
        do {
            System.out.println("1\tAdd New Villa");
            System.out.println("2\tAdd New House");
            System.out.println("3\tAdd New Room");
            System.out.println("4\tBack to menu");
            do {
                flag = true;
                try {
                    System.out.print("Your choose: ");
                    choose = Integer.parseInt(scn.nextLine());
                } catch (NumberFormatException e) {
                    System.err.println("Lựa chọn không hợp lệ!");
                    flag = false;
                }
            } while (! flag);
            switch ( choose ) {
                case 1:
                    Facility newVilla = new Villa();
                    do {
                        System.out.println("ID định dạng House SVHO-xxxx (x : 0-9)");
                        System.out.print("Nhập mã dịch vụ: ");
                        newVilla.setIdService(scn.nextLine());
                    } while (! new FormatString().codeService(newVilla.getIdService())
                            || isSameId(newVilla.getIdService()));
                    newVilla.inputData();
                    equalsFacility(newVilla);
                    break;
                case 2:
                    Facility newHouse = new House();
                    do {
                        System.out.println("ID định dạng House SVHO-xxxx (x : 0-9)");
                        System.out.print("Nhập mã dịch vụ: ");
                        newHouse.setIdService(scn.nextLine());
                    } while (! new FormatString().codeService(newHouse.getIdService())
                            || isSameId(newHouse.getIdService()));
                    newHouse.inputData();
                    equalsFacility(newHouse);
                    break;
                case 3:
                    Room newRoom = new Room();
                    do {
                        System.out.println("ID định dạng House SVHO-xxxx (x : 0-9)");
                        System.out.print("Nhập mã dịch vụ: ");
                        newRoom.setIdService(scn.nextLine());
                    } while (! new FormatString().codeService(newRoom.getIdService())
                            || isSameId(newRoom.getIdService()));
                    newRoom.inputData();
                    equalsFacility(newRoom);
                    break;
                case 4:
                    break;
            }
        } while (choose != 4);
    }

    @Override
    public void displayList () {
        System.out.println("------Danh sách cơ sở vật chất------");
        for (Map.Entry<Facility, Integer> entry : dataFacility.entrySet()) {
            System.out.println(entry.getKey());
            System.out.println("Số người đã thuê: " + entry.getValue());
            System.out.println("-----------------------------");
        }
    }

    @Override
    public void displayListMaintenance () {
        System.out.println("------Danh sách cơ sở vật chất bảo dưỡng------");
        for (Map.Entry<Facility, Integer> entry : dataFacilityMaintenance.entrySet()) {
            System.out.println(entry.getKey());
            System.out.println("Số người đã thuê: " + entry.getValue());
            System.out.println("-----------------------------");
        }
    }

    public Facility getFacility (String idFacility) {
        Set<Facility> keySet = dataFacility.keySet();
        for (Facility item : keySet) {
            if (item.getIdService().equals(idFacility)) return item;
        }
        return null;
    }

    public Map<Facility, Integer> getDataFacility () {
        return dataFacility;
    }

    public void setDataFacility (Map<Facility, Integer> dataFacility) {
        this.dataFacility = dataFacility;
    }

    public Map<Facility, Integer> getDataFacilityMaintenance () {
        return dataFacilityMaintenance;
    }

    public void setDataFacilityMaintenance (Map<Facility, Integer> dataFacilityMaintenance) {
        this.dataFacilityMaintenance = dataFacilityMaintenance;
    }
}
