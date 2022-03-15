package lab6_2;

import java.io.File;
import java.lang.reflect.InvocationTargetException;
import java.util.List;

public class ContactsStorageManagement implements ContactsStorageInterface{
    private File textFile;

    public ContactsStorageManagement(File textFile) {
        this.textFile = textFile;
    }

    private String checkFileType() {
        String[] fileName = textFile.getName().split("\\.");
        String fileType = "";
        if (fileName[1] == "txt") {
            fileType = "txt";
        } else {
            fileType = "binary";
        }

        return fileType;
    }

    public List<Contact> loadContacts() {
        String fileType = checkFileType();

        try {
            ContactsStorageInterface specificStorage = (ContactsStorageInterface) Class.forName("ex02." + "ContactsStorage" + fileType).getConstructor(File.class).newInstance(textFile);
            return specificStorage.loadContacts();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        return null;
    }

    public boolean saveContacts(List<Contact> list) {
        String fileType = checkFileType();
        try {
            ContactsStorageInterface specificStorage = (ContactsStorageInterface) Class.forName("ex02." + "ContactsStorage" + fileType).getConstructor(File.class).newInstance(textFile);
            return specificStorage.saveContacts(list);
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        return true;

    }

}
