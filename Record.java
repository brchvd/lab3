package Exceptions;

public class Record {
    private long id;
    private String phoneNumber;
    private String name;
    public Record(long id,String phone,String name){
        this.id = id;
        this.phoneNumber = phone;
        this.name = name;
    }

    @Override
    public String toString(){
        return "Запись №" + id + "; Имя: " + name + "; Телефон: " + phoneNumber;
    }
    public String getPhoneNumber(){
        return phoneNumber;
    }
    public String getName(){
        return name;
    }
    public long getId(){
        return id;
    }
}
