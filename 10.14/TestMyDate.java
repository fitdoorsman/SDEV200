public class TestMyDate {
    public static void main(String[] args) {
        MyDate date1 = new MyDate();
        MyDate date2 = new MyDate(34355555133101L);

        System.out.println("Date 1: " + (date1.getMonth() + 1) + "-" + date1.getDay() + "-" + date1.getYear());
        System.out.println("Date 2: " + (date2.getMonth() + 1) + "-" + date2.getDay() + "-" + date2.getYear());
    }
}
