// enum demo based on an article from http://www.25hoursaday.com/CsharpVsJava.html#same

// standard C-style enum + class-like properties (methods and fields)
enum DayOfWeek {
    SUNDAY,
    MONDAY,
    TUESDAY,
    WEDNESDAY,
    THURSDAY,
    FRIDAY,
    SATURDAY;

    public boolean isWeekend() {
        // use of 'this', because the methods are internal to the enum;
        // enum elements are addressed directly as well
        // (no need for DaysOfWeek.SUNDAY)
        return (this == SATURDAY || this == SUNDAY);
    }

    public boolean isWeekday() {
        return !isWeekend();
    }
}

class EnumDemo {
    public static void main(String[] args) {
        // choosing day of week and testing for weekday or weekend
        DayOfWeek day = DayOfWeek.SUNDAY;
        System.out.println("Sunday was chosen!");
        System.out.println("Sunday is a weekday: " + day.isWeekday());
        System.out.println("Sunday is a weekend: " + day.isWeekend());
        // choosing another day of week
        day = DayOfWeek.FRIDAY;
        System.out.println("Friday was chosen!");
        System.out.println("Friday is a weekday: " + day.isWeekday());
        System.out.println("Friday is a weekend: " + day.isWeekend());


    }
}