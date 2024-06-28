package Listas.Lista1.Q1;

public class Data{
    int day;
    int month;
    int year;

    public Data(int day, int month, int year){
        this.day = day;
        this.month = month;
        this.year = year;
    }

    public int getDay() {
        return day;
    }

    public int getMonth() {
        return month;
    }

    public int getYear() {
        return year;
    }

    public void setDay(int day) {
        this.day = day;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String mostrarData(){
        return (String.valueOf(day) + "/" + String.valueOf(month) + "/" + String.valueOf(year));
    }

}