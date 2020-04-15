package kalendar;

/**
 *
 * @author Marketa.Milerova
 */
public class test2 {

    int day;
    int month;
    int year;

    public test2(int day, int month, int year) {
        this.day = day;
        this.month = month;
        this.year = year;
    }

    public int getDayInWeek() {
        int month = this.month;
        int year = this.year;
        int day = this.day;
        if (month == 1) {
            month = 13;
            year--;
        }
        if (month == 2) {
            month = 14;
            year--;
        }
        int q = day;
        int m = month;
        int k = year % 100;
        int j = year / 100;
        int h = q + 13 * (m + 1) / 5 + k + k / 4 + j / 4 + 5 * j;
        h = h % 7;
        return ((h + 5) % 7) + 1;
    }

    public String makeCalendar() {
        StringBuilder calendar = new StringBuilder();
        calendar.append(String.format("Month: %2d Year: %4d%n", month,year));
        calendar.append("PO UT ST CT PA SO NE %n");
        int tempDay = this.day;
        this.day = 1;
        int dayStart = getDayInWeek();
        for (int i = 0; i < dayStart - 1; i++) {
            calendar.append("   ");
        }
        for (int i = 0; i < daysInMonths(year)[month - 1]; i++) {
            calendar.append(String.format("%2d ", this.day));
            if (getDayInWeek() == 7) {
                calendar.append("%n");
            }
            this.day++;
        }
        int dayEnd = getDayInWeek();
        for (int i = 0; i < 7 - dayEnd + 1; i++) {
            calendar.append("   ");
        }
        calendar.append("%n");
        this.day = tempDay;
        return calendar.toString();
    }

    public void nextMonth() {
        day = 1;
        if (month == 12) {
            year++;
            month = 1;
        } else {
            month++;
        }
    }

    public void previousMonth() {
        day = 1;
        if (month == 1) {
            month = 12;
            year--;
        } else {
            month--;
        }
    }

    private static int[] daysInMonths(int year) {
        int[] daysInMonths = {31, 0, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        daysInMonths[1] = isYearLeap(year) ? 29 : 28;
        return daysInMonths;
    }

    public static boolean isYearLeap(int year) {
        if (year % 4 != 0) {
            return false;
        }
        if (year % 100 != 0) {
            return true;
        }
        return year % 400 == 0;
    }

    public static int daysInYear(int year) {
        return isYearLeap(year)? 366:365;
    }

    public static void main(String[] args) {
        test2 k1 = new test2(6, 6, 2020);
        System.out.printf(k1.makeCalendar());
        k1.previousMonth();
        System.out.printf(k1.makeCalendar());
        
    }
}