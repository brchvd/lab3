package Exceptions;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        ArrayList<Record> records = new ArrayList<>();
        records.add(new Record(101, "1", "Петр"));
        records.add(new Record(102, "2", "Иван"));
        records.add(new Record(103, "3", "Сергей"));
        PhoneBook phoneBook = new PhoneBook();
        for (Record rec : records) {
            try {
                phoneBook.createRecord(rec);
            } catch (PhoneNumberAlreadyExists e) {
                System.out.println(rec +" не добавлена. В справочнике уже есть запись с номером телефона " + rec.getPhoneNumber());
            }
        }
        System.out.println(phoneBook.getAllRecords());
        phoneBook.deleteRecord(103);
        System.out.println(phoneBook.getAllRecords());

        try {
            phoneBook.updateRecord(new Record(101,"5", "A"));
            phoneBook.updateRecord(new Record(101, "1234567", null));
        } catch (RecordNotValid e) {
            System.out.println(e.getMessage()+". Данные не будут обновлены.");
        }
        System.out.println(phoneBook.getAllRecords());
    }
}
