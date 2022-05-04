package _case_study.services.implements_interface;

import _case_study.controller.FuramaController;
import _case_study.model.other_class.Contract;
import _case_study.model.other_class.Promotion;
import _case_study.services.interface_services.PromotionService;
import _case_study.utils.ReadData;
import _case_study.utils.WriteData;

import java.util.*;

public class PromotionServiceImpl implements PromotionService {
    private static final Scanner scn = new Scanner(System.in);
    private Set<Promotion> dataPromotion = new TreeSet<>();

    public void inputData () {
        List<Contract> dataTempContract = ReadData.readDataContract();
        if (dataTempContract.isEmpty()) {
            System.out.println("file contract rỗng");
            return;
        }
        // Đọc file promotion.csv trước khi thêm mới
        this.dataPromotion = ReadData.readDataPromotion();
        //Tạo data để thêm đối tượng đã tặng voucher
        Set<Promotion> dataTemp = new TreeSet<>();
        Promotion promotion;
        // Thêm dữ liệu cho list
        for (Contract item : dataTempContract) {
            promotion = new Promotion();
            System.out.println("Contract Info: ");
            System.out.println(item);
            if (! item.isSetVoucher()) {
                promotion.inputData(item);
                dataTemp.add(promotion);
                item.setSetVoucher(true);
            }
        }

        // Nhập thông tin voucher
        inputVoucher(dataTemp);
        System.out.println("Success");
        FuramaController.contractService.setDataListContract(dataTempContract);
        // Ghi file ra contract.csv
        WriteData.writeDataListContract();
    }

    public void inputVoucher (Set<Promotion> dataSet) {
        //Tạo danh sách đối tượng chứa voucher
        Stack<Promotion> listSetVoucher = new Stack<>();
        int numberVoucher;
        int numberVoucher10 = 0;
        int numberVoucher20 = 0;
        int numberVoucher50 = 0;
        boolean flag;
        numberVoucher = dataSet.size();
        do {
            do {
                flag = true;
                try {
                    System.out.println("Tổng số voucher: " + numberVoucher);
                    System.out.println("Vui lòng nhập số lượng từng loại (< tổng voucher)");
                    System.out.println("Số lượng voucher 10% ");
                    numberVoucher10 = Integer.parseInt(scn.nextLine());
                    System.out.println("Số lượng voucher 20% ");
                    numberVoucher20 = Integer.parseInt(scn.nextLine());
                    System.out.println("Số lượng voucher 50% ");
                    numberVoucher50 = Integer.parseInt(scn.nextLine());
                } catch (NumberFormatException e) {
                    flag = false;
                }
            } while (! flag);
        } while (numberVoucher10 + numberVoucher20 + numberVoucher50 > numberVoucher);

        // Thêm dữ liệu cho listSetVoucher
        for (Promotion promotion : dataSet) {
            listSetVoucher.push(promotion);
        }

        // Cài đặt voucher cho promotion
        setVoucher(listSetVoucher , numberVoucher50 , numberVoucher20 , numberVoucher10);
    }

    public void setVoucher (Stack<Promotion> listSetVoucher , int numberVoucher50 ,
                            int numberVoucher20 , int numberVoucher10) {
        Promotion promotion;
        while (! listSetVoucher.isEmpty()) {
            if (numberVoucher50 > 0) {
                promotion = listSetVoucher.pop();
                promotion.setVoucher("Voucher 50%");
                dataPromotion.add(promotion);
                numberVoucher50--;
            } else if (numberVoucher50 == 0 && numberVoucher10 > 0 && numberVoucher20 > 0) {
                promotion = listSetVoucher.pop();
                promotion.setVoucher("Voucher 20%");
                dataPromotion.add(promotion);
                numberVoucher20--;
            } else if (numberVoucher50 == 0 && numberVoucher20 == 0 && numberVoucher10 > 0) {
                promotion = listSetVoucher.pop();
                promotion.setVoucher("Voucher 10%");
                dataPromotion.add(promotion);
                numberVoucher10--;
            }
        }
        // Ghi file ra promotion.csv
        WriteData.writeDataListPromotion();
    }

    @Override
    public void displayCustomerUseService () {
        // Đọc file promotion.csv trước khi hiển thị danh sách
        this.dataPromotion = ReadData.readDataPromotion();
        System.out.println("------Danh sách promotion------");
        for (Promotion promotion : dataPromotion) {
            System.out.println(promotion.getContract().getBooking().getCustomer());
            System.out.println("Số năm sử dụng: " + promotion.getYearOfUse());
            System.out.println("-----------------------------");
        }
    }

    @Override
    public void displayCustomerGetVoucher () {
        // Đọc file promotion.csv trước khi hiển thị danh sách
        this.dataPromotion = ReadData.readDataPromotion();
        System.out.println("------Danh sách khách hàng nhận voucher------");
        for (Promotion promotion : dataPromotion) {
            System.out.println(promotion.getContract().getBooking().getCustomer());
            System.out.println("Loại voucher: " + promotion.getVoucher());
            System.out.println("-----------------------------");
        }
    }

    public Set<Promotion> getDataListPromotion () {
        return dataPromotion;
    }

    public void setDataPromotion (Set<Promotion> dataPromotion) {
        this.dataPromotion = dataPromotion;
    }
}
