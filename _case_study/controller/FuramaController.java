package _case_study.controller;

import _case_study.services.implements_interface.*;
import _case_study.utils.WriteData;

import java.util.Scanner;

public class FuramaController {
    public static final Scanner scn = new Scanner(System.in);
    private EmployeeServiceImpl employeeService = new EmployeeServiceImpl();
    private CustomerServiceImpl customerService = new CustomerServiceImpl();
    private FacilityServiceImpl facilityService = new FacilityServiceImpl();
    private BookingServiceImpl bookingService = new BookingServiceImpl(customerService , facilityService);
    private ContractServiceImpl contractService = new ContractServiceImpl();
    private PromotionServiceImpl promotionService = new PromotionServiceImpl();

    public void employeeManagementMenu () {
        int choose = 0;
        boolean flag;
        do {
            System.out.println("1\tDisplay list employees");
            System.out.println("2\tAdd new employee");
            System.out.println("3\tEdit employee");
            System.out.println("4\tReturn main menu");

            do {
                flag = true;
                try {
                    System.out.print("Your choose: ");
                    choose = Integer.parseInt(scn.nextLine());
                    if (choose < 0 && choose > 4) {
                        flag = false;
                    }
                } catch (NumberFormatException e) {
                    flag = false;
                }
            } while (! flag);

            switch ( choose ) {
                case 1:
                    employeeService.displayList();
                    break;
                case 2:
                    employeeService.addNew();
                    break;
                case 3:
                    employeeService.editInfor();
                    break;
                case 4:
                    displayMainMenu();
                    break;
            }
        } while (true);
    }

    public void customerManagementMenu () {
        int choose = 0;
        boolean flag;
        do {
            System.out.println("1.\tDisplay list customers");
            System.out.println("2.\tAdd new customer");
            System.out.println("3.\tEdit customer");
            System.out.println("4\tReturn main menu");

            do {
                flag = true;
                try {
                    System.out.print("Your choose: ");
                    choose = Integer.parseInt(scn.nextLine());
                    if (choose < 0 && choose > 4) {
                        flag = false;
                    }
                } catch (NumberFormatException e) {
                    flag = false;
                }
            } while (! flag);

            switch ( choose ) {
                case 1:
                    customerService.displayList();
                    break;
                case 2:
                    customerService.addNew();
                    break;
                case 3:
                    customerService.editInfor();
                    break;
                case 4:
                    displayMainMenu();
                    break;
            }
        } while (true);
    }

    public void facilityManagementMenu () {
        int choose = 0;
        boolean flag;
        do {
            System.out.println("1\tDisplay list facility");
            System.out.println("2\tAdd new facility");
            System.out.println("3\tDisplay list facility maintenance");
            System.out.println("4\tReturn main menu");

            do {
                flag = true;
                try {
                    System.out.print("Your choose: ");
                    choose = Integer.parseInt(scn.nextLine());
                    if (choose < 0 && choose > 4) {
                        flag = false;
                    }
                } catch (NumberFormatException e) {
                    flag = false;
                }
            } while (! flag);

            switch ( choose ) {
                case 1:
                    facilityService.displayList();
                    break;
                case 2:
                    facilityService.addNew();
                    break;
                case 3:
                    facilityService.displayListMaintenance();
                    break;
                case 4:
                    displayMainMenu();
                    break;
            }
        } while (true);
    }

    public void bookingManagementMenu () {
        int choose = 0;
        boolean flag;
        do {
            System.out.println("1.\tAdd new booking");
            System.out.println("2.\tDisplay list booking");
            System.out.println("3.\tCreate new constracts");
            System.out.println("4.\tDisplay list contracts");
            System.out.println("5.\tEdit contracts");
            System.out.println("6\tReturn main menu");

            do {
                flag = true;
                try {
                    System.out.print("Your choose: ");
                    choose = Integer.parseInt(scn.nextLine());
                    if (choose < 0 && choose > 6) {
                        flag = false;
                    }
                } catch (NumberFormatException e) {
                    flag = false;
                }
            } while (! flag);

            switch ( choose ) {
                case 1:
                    bookingService.addNew();
                    break;
                case 2:
                    bookingService.displayList();
                    break;
                case 3:
                    contractService.addNew();
                    break;
                case 4:
                    contractService.displayList();
                    break;
                case 5:
                    contractService.editContract();
                    break;
                case 6:
                    displayMainMenu();
                    break;
            }
        } while (true);
    }

    public void promotionManagementMenu () {
        int choose = 0;
        boolean flag;

        do {
            System.out.println("1.\tDisplay list customers use service");
            System.out.println("2.\tDisplay list customers get voucher");
            System.out.println("3\tReturn main menu");

            do {
                flag = true;
                try {
                    System.out.print("Your choose: ");
                    choose = Integer.parseInt(scn.nextLine());
                    if (choose < 0 && choose > 3) {
                        flag = false;
                    }
                } catch (NumberFormatException e) {
                    flag = false;
                }
            } while (! flag);

            switch ( choose ) {
                case 1:
                    promotionService.displayCustomerUseService();
                    break;
                case 2:
                    promotionService.displayCustomerGetVoucher();
                    break;
                case 3:
                    displayMainMenu();
                    break;
            }
        } while (true);
    }

    public void displayMainMenu () {
        int choose = 0;
        boolean flag;
        do {
            System.out.println("1.\tEmployee Management");
            System.out.println("2.\tCustomer Management");
            System.out.println("3.\tFacility Management");
            System.out.println("4.\tBooking Management");
            System.out.println("5.\tPromotion Management");
            System.out.println("6.\tExit");

            do {
                flag = true;
                try {
                    System.out.print("Your choose: ");
                    choose = Integer.parseInt(scn.nextLine());
                    if (choose < 0 && choose > 6) {
                        flag = false;
                    }
                } catch (NumberFormatException e) {
                    flag = false;
                }
            } while (! flag);

            switch ( choose ) {
                case 1:
                    employeeManagementMenu();
                    break;
                case 2:
                    customerManagementMenu();
                    break;
                case 3:
                    facilityManagementMenu();
                    break;
                case 4:
                    bookingManagementMenu();
                    break;
                case 5:
                    promotionManagementMenu();
                    break;
                case 6:
                    WriteData writeData = new WriteData(employeeService ,
                            customerService , facilityService ,
                            bookingService , contractService , promotionService);
                    writeData.writeAllData();
                    System.exit(0);
            }
        } while (true);
    }
}
