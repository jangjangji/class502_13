package exam02;

public class Schedule {
    int year;
    int month;
    int day;

    public int getYear() {
        return year;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        if(month == 2 && day>28){
            day= 28;
        }
        this.day = day;
    }

    public void setYear(int _year){
        year = _year;
    };

    void showDate(){
        System.out.printf("%d %d %d",year,month,day);
    }
}
