package Exceptions;
import java.util.ArrayList;
import java.util.List;
public class PhoneBook {
    private ArrayList<Record> records;
    public PhoneBook(){
        records = new ArrayList<Record>();
    }
    public List<Record> getAllRecords(){
        return records;
    }
    public void createRecord(Record record) throws PhoneNumberAlreadyExists{
        for (Record elem: records) {
            if (record.getPhoneNumber() == elem.getPhoneNumber()) {
                throw new PhoneNumberAlreadyExists("Запись с таким номером уже существует!");
            }
        }
        records.add(record);
    }
    public void updateRecord(Record record) throws RecordNotValid {
        boolean flagRecord = false;
        for (Record elem: records) {
            if (elem.getId() == record.getId()) {
                flagRecord = true;
                if ((record.getName() == null) && (record.getPhoneNumber() == null)) {
                    throw new RecordNotValid("В новой записи не заполнено поле name и поле phoneNumber");
                } else if (record.getName() == null){
                    throw new RecordNotValid("В новой записи не заполнено поле name");
                } else if (record.getPhoneNumber() == null){
                    throw new RecordNotValid("В новой записи не заполнено поле phoneNumber");
                }
                this.deleteRecord(record.getId());
                records.add(record);
                break;
            }
        }
        if (!flagRecord) {
            throw new RecordNotFound("Записи с таким id не существует");
        }
    }
    public void deleteRecord(long id){
        boolean existRecord = false;
        for (Record rec : records) {
            if (rec.getId() == id) {
                existRecord = true;
                records.remove(rec);
                break;
            }
        }
        if (!existRecord) {
            throw new RecordNotFound("Подходящая запись в справочнике не найдена");
        }
    }
}

