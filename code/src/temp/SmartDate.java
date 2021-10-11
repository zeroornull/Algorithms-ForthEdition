package temp;

import java.time.LocalDate;
import java.util.Objects;

public class SmartDate implements Comparable<SmartDate> {

    private final int month;
    private final int day;
    private final int year;

    public SmartDate(int month, int day, int year) {
        super();
        this.month = month;
        this.day = day;
        this.year = year;

        if (!islegal()) {
            throw new RuntimeException();
        }

    }

    public SmartDate(String date) {
        String[] strings = date.split("/");
        month = Integer.parseInt(strings[0]);
        day = Integer.parseInt(strings[1]);
        year = Integer.parseInt(strings[2]);
        if (!islegal()) {
            throw new RuntimeException();
        }
    }

    private boolean islegal() {
        if (year <= 0 || month <= 0 || month > 12 || day <= 0) {
            return false;
        }
        int[] days = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        if (year % 400 == 0 || (year % 4 == 0 && year % 100 != 0)) {
            //
            days[1] = 29;
        }
        if (day > days[month - 1]) {
            return false;
        }
        return true;
    }

    public String dayOfTheWeek() {
        //
        LocalDate localDate = LocalDate.of(year, month, day);
        return localDate.getDayOfWeek().toString();
    }

    @Override
    public String toString() {
        return "SmartDate{" +
                "month=" + month +
                ", day=" + day +
                ", year=" + year +
                '}';
    }

    public int getMonth() {
        return month;
    }

    public int getDay() {
        return day;
    }

    public int getYear() {
        return year;
    }

    @Override
    public int compareTo(SmartDate that) {
        if (this.year < that.year) {
            return -1;
        }
        if (this.year > that.year) {
            return +1;
        }
        if (this.month < that.month) {
            return -1;
        }
        if (this.month > that.month) {
            return +1;
        }
        if (this.day < that.day) {
            return -1;
        }
        if (this.day > that.day) {
            return +1;
        }
        return 0;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SmartDate smartDate = (SmartDate) o;
        return month == smartDate.month && day == smartDate.day && year == smartDate.year;
    }

    @Override
    public int hashCode() {
        return Objects.hash(month, day, year);
    }

    public static void main(String[] args) {
        SmartDate today = new SmartDate(10, 11, 2021);
        System.out.println(today.dayOfTheWeek());
    }
}
