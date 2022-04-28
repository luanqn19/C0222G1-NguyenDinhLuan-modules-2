package _case_study.utils;

import java.time.LocalDate;
import java.util.Date;

public class BirthOfDayException extends Exception {
    public BirthOfDayException () {
        super("Ngày sinh không hợp lệ!");
    }
}
