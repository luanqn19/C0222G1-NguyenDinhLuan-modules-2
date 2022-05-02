package _case_study.services.implements_interface;

import _case_study.controller.FuramaController;
import _case_study.model.facility_class.Facility;
import _case_study.model.other_class.Booking;
import _case_study.model.other_class.Contract;
import _case_study.model.person_class.Customer;
import _case_study.services.interface_services.ContactService;
import _case_study.utils.FormatString;
import _case_study.utils.ReadData;
import _case_study.utils.WriteData;

import java.util.*;

public class ContractServiceImpl implements ContactService {
    private static final Scanner scn = new Scanner(System.in);
    private List<Contract> dataContract = new ArrayList<>();
    private Set<Booking> dataBooking;

    public ContractServiceImpl () {
        this.dataBooking = FuramaController.bookingService.getDataListBooking();
        this.dataContract = ReadData.readDataContract();
    }

    //Kiểm tra trùng số hợp đồng
    public boolean isSameId (String numberContract) {
        for (Contract item : dataContract) {
            if (item.getNumberOfContract().equals(numberContract)) return false;
        }
        return true;
    }

    //Điều chỉnh tăng lượt thuê facility
    public void setDataFacility () {
        //Đọc data facility
        FuramaController.facilityService.setDataFacility(ReadData.readDataFacility("FILE_FACILITY"));
        Map<Facility, Integer> temp = new LinkedHashMap<>();
        Facility facility;
        boolean flag;

        for (Map.Entry<Facility, Integer> entry : FuramaController.facilityService.getDataFacility().entrySet()) {
            flag = false;
            for (Contract item : dataContract) {
                facility = item.getBooking().getFacility();
                if (entry.getKey().getIdService().equals(facility.getIdService())) {
                    flag = true;
                    temp.put(facility , entry.getValue() + 1);
                    break;
                }
            }
            if (! flag)
                temp.put(entry.getKey() , entry.getValue());
        }

        //Thay đổi data facility
        FuramaController.facilityService.setDataFacility(temp);
        //Ghi ra file facility
        WriteData.writeDataListFacility(temp , "facility.csv");
    }

    //Kiểm tra lượt thuê facility, nếu >= 5 chuyển sang facility maintenance
    public void addDataFacilityToMaintenance () {
        //Đọc data facility maintenance
        FuramaController.facilityService.setDataFacilityMaintenance(ReadData.readDataFacility("FILE_FACILITYMAINTENANCE"));
        Map<Facility, Integer> tempFacilityMaintenance = new LinkedHashMap<>(FuramaController.facilityService.getDataFacilityMaintenance());

        for (Map.Entry<Facility, Integer> entry : FuramaController.facilityService.getDataFacility().entrySet()) {
            if (entry.getValue() >= 5) {
                tempFacilityMaintenance.put(entry.getKey() , entry.getValue());
            }
        }

        //Ghi ra file facility maintenance
        WriteData.writeDataListFacility(tempFacilityMaintenance , "facility_maintenance.csv");
    }

    @Override
    public void addNew () {
        //Đọc file booking trước khi thêm mới contract
        this.dataBooking = ReadData.readDataBooking();
        //Đọc file contract trước khi thêm mới
        this.dataContract = ReadData.readDataContract();
        //Đọc file promotion trước khi thêm mới contract
        FuramaController.promotionService.setDataPromotion(FuramaController.promotionService.getDataListPromotion());

        Queue<Booking> bookingQueue = new LinkedList<>();
        if (dataBooking.isEmpty()) {
            System.out.println("Danh sách booking rỗng");
            return;
        } else {
            //Tạo queue booking
            for (Booking item : dataBooking) {
                if (!item.isCreateContrat())
                    bookingQueue.add(item);
            }
        }

        Booking booking;
        Customer customer;

        while (! bookingQueue.isEmpty()) {
            //Lấy ra từng phần tử trong booking để tiến hành thêm contract
            booking = bookingQueue.poll();
            //Lấy thông tin khách hàng tạo contract
            customer = booking.getCustomer();
            System.out.println("Đang tạo hợp đồng booking infor: \n" + booking);
            System.out.println("Đang tạo hợp đồng khác hàng: \n" + customer);
            // Điều chỉnh trạng thái tạo contract cho booking
            booking.setCreateContrat(true);
            //Tạo contract rỗng để tiến hành set thông tin
            Contract contract = new Contract();
            //Tạo contract mới
            //Nhập mã hợp đồng
            do {
                System.out.println("ID định dạng CID-xxxx (x: 0-9)");
                System.out.print("Nhập ID hợp đồng: ");
                contract.setNumberOfContract(scn.nextLine());
            } while (! new FormatString().code(contract.getNumberOfContract())
                    || ! isSameId(contract.getNumberOfContract()));
            //Nhập thông tin contract
            contract.inputData(booking);
            //Thêm contract vào data
            dataContract.add(contract);
            System.out.println("Success create new contract");
        }

        //Ghi ra file contract thông tin thêm mới
        WriteData.writeDataListContract();
        //Nhập số lượng voucher và phân voucher cho khách đã tạo contract
        FuramaController.promotionService.inputData();
        //Ghi danh sách rỗng data booking
        WriteData.writeDataListBooking();
        //Điều chỉnh lại data facility
        setDataFacility();
        //Thêm data facility đã thuê đủ 5 và chuyển sang facility maintenance
        addDataFacilityToMaintenance();
    }

    @Override
    public void displayList () {
        //Đọc file contract trước khi hiển thị
        this.dataContract = ReadData.readDataContract();
        System.out.println("------Danh sách Contract------");
        for (Contract item : dataContract) {
            System.out.println(item);
            System.out.println("-----------------------------");
        }
    }

    @Override
    public void editContract () {
        //Đọc file contract trước khi điều chỉnh
        this.dataContract = ReadData.readDataContract();
        boolean flag;

        System.out.println("Nhập ID hợp đồng: ");
        String numberContract = scn.nextLine();

        for (Contract item : dataContract) {
            if (item.getNumberOfContract().equals(numberContract)) {
                //Nhập mã hợp đồng
                do {
                    System.out.println("ID định dạng CID-xxxx (x: 0-9)");
                    System.out.print("Nhập ID hợp đồng: ");
                    item.setNumberOfContract(scn.nextLine());
                } while (! new FormatString().code(item.getNumberOfContract()));

                //Nhập số tiền trả trước
                do {
                    flag = true;
                    try {
                        System.out.print("Nhập số tiền trả trước (lớn hơn 0)");
                        item.setDeposit(Integer.parseInt(scn.nextLine()));
                    } catch (NumberFormatException e) {
                        flag = false;
                    }
                } while (item.getDeposit() < 0 || ! flag);

                //Nhập tổng chi phí
                do {
                    flag = true;
                    try {
                        System.out.print("Nhập tổng số chi phí (lớn hơn 0)");
                        item.setTotalPay(Integer.parseInt(scn.nextLine()));
                    } catch (NumberFormatException e) {
                        flag = false;
                    }
                } while (item.getTotalPay() < 0 || ! flag);
            }
        }
        //Ghi ra file contract thông tin đã điều chỉnh
        WriteData.writeDataListContract();
    }

    public Contract getContract (String numberOfContract) {
        this.dataContract = ReadData.readDataContract();
        assert dataContract != null;
        for (Contract item : dataContract) {
            if (item.getNumberOfContract().equals(numberOfContract))
                return item;
        }
        return null;
    }

    public List<Contract> getDataListContract () {
        return dataContract;
    }

    public void setDataListContract (List<Contract> listData) {
        this.dataContract = listData;
    }
}
