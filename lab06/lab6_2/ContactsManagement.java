package lab6_2;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ContactsManagement implements ContactsInterface {
    private List<Contact> contacts;

    public ContactsManagement(){
        this.contacts = new ArrayList<>();
    }

    public void openAndLoad(ContactsStorageInterface store) {
        this.contacts.addAll(store.loadContacts());
    }

    public void saveAndClose() {
        if (contacts.size() < 1) {
            System.err.println("There are no contacts to save, please initialize first");
        } else {
             Scanner input = new Scanner(System.in);

             System.out.println("Put the file's directory: ");
             String filePath = input.nextLine();
             input.close();

             try {
                 File file2 = new File(filePath);
                 ContactsStorageInterface newStorage = new ContactsStorageManagement(file2);
                 newStorage.saveContacts(this.contacts);
             } catch (Exception e) {
                 System.exit(1);
             }
        }
    }

    public void saveAndClose(ContactsStorageInterface store) {
        if (contacts.size() < 1) {
            System.err.println("There are no contacts to save, please initialize first");
        } else {
            store.saveContacts(this.contacts);
        }
    }

    public boolean exist(Contact contact) {
        for (Contact c: this.contacts) {
            if (c.toString().equals(contact.toString())) {
                return true;
            }
        }
        return false;
    }

    public Contact getByName(String name) {
        for (Contact c: this.contacts) {
            if (c.getName().equals(name)) {
                return c;
            }
        }
        System.err.println("Contact not found");
        return null;
    }

    public boolean add(Contact contact) {
        if (this.exist(contact)) {
            return false;
        } else {
            this.add(contact);
            return true;
        }
    }

    public boolean remove(Contact contact) {
        if (this.exist(contact)) {
            this.remove(contact);
            return true;
        } else {
            return false;
        }
    }
}
