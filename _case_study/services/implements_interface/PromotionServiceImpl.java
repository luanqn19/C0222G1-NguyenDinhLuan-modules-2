package _case_study.services.implements_interface;

import _case_study.model.other_class.Booking;
import _case_study.model.other_class.Promotion;
import _case_study.services.interface_services.PromotionService;

import java.util.*;

public class PromotionServiceImpl implements PromotionService {
    private static final Scanner scn = new Scanner(System.in);
    private Set<Promotion> dataPromotion = new TreeSet<>();
    private int numberVoucher = dataPromotion.size();
    private int numberVoucher10 = 0;
    private int numberVoucher20 = 0;
    private int numberVoucher50 = 0;

    public void inputData (BookingServiceImpl bookingService) {
        Stack<Promotion> listSetVoucher = new Stack<>();
        Set<Promotion> dataTemp = new TreeSet<>();
        Promotion promotion = new Promotion();
        // Add element for Data list promotion
        for (Booking item : bookingService.getDataListBooking()) {
            System.out.println(item);
            promotion.inputDate(item);
            dataTemp.add(promotion);
        }

        // Set number voucher
        inputVoucher(dataTemp , listSetVoucher);

        // Set voucher for promotion object
        setVoucher(listSetVoucher);
    }

    public void inputVoucher (Set<Promotion> dataSet , Stack<Promotion> listSetVoucher) {
        boolean flag;
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
                    System.err.println("Dữ liệu không hợp lệ");
                    flag = false;
                }
            } while (! flag);
        } while (numberVoucher10 + numberVoucher20 + numberVoucher50 > numberVoucher);

        // Add element for listSetVoucher
        for (Promotion promotion : dataSet) {
            listSetVoucher.push(promotion);
        }
    }

    public void setVoucher (Stack<Promotion> listSetVoucher) {
        Promotion promotion = new Promotion();
        while (! listSetVoucher.isEmpty()) {
            if (numberVoucher50 > 0) {
                promotion = listSetVoucher.pop();
                promotion.setVoucher("Voucher 50%");
                dataPromotion.add(promotion);
                numberVoucher50--;
            } else if (numberVoucher50 == 0 && numberVoucher10 == 0 && numberVoucher20 > 0) {
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
    }

    @Override
    public void displayCustomerUseService () {
        System.out.println("------Danh sách promotion------");
        for (Promotion promotion : dataPromotion) {
            System.out.println(promotion.getBooking().getCustomer());
            System.out.println("Số năm sử dụng: " + promotion.getYearOfUse());
            System.out.println("-----------------------------");
        }
    }

    @Override
    public void displayCustomerGetVoucher () {
        System.out.println("------Danh sách khách hàng nhận voucher------");
        for (Promotion promotion : dataPromotion) {
            System.out.println(promotion.getBooking().getCustomer());
            System.out.println("Loại voucher: " + promotion.getVoucher());
            System.out.println("-----------------------------");
        }
    }

    public Set<Promotion> getDataListPromotion() {
        return dataPromotion;
    }

    public void setDataPromotion (Set<Promotion> dataPromotion) {
        this.dataPromotion = dataPromotion;
    }
}
