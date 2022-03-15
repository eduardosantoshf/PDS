package lab6_2;

import java.io.*;
import java.util.*;

class ContactsStorageTxt extends ContactsStorageManagement implements ContactsStorageInterface{
    private File textFile;

    public ContactsStorageTxt (File ourFile){
        super(ourFile);
        this.textFile = ourFile;
    }

    public List<Contact> loadContacts(){
        try{
            Scanner fileScanner = new Scanner(textFile);
    
            List<Contact> contacts = new ArrayList<>();
            while (fileScanner.hasNext()) {

                String currentLine[] = fileScanner.nextLine().split("\\s+");
                for (int i = 0; i < currentLine.length; i++) {

                    Contact contact = new Contact(currentLine[i],Integer.parseInt(currentLine[++i]));
                    contacts.add(contact);
                }
            }

            fileScanner.close();

            return contacts;
        }catch (Exception e){
            System.err.println("ERROR" + e.toString());
        }

        return null;
    }
    
    public boolean saveContacts(List<Contact> list){    
        try {
            FileWriter writer = new FileWriter(textFile.getName());
            PrintWriter printWriter = new PrintWriter(writer);

            for(Contact currentContact : list){
                printWriter.print(currentContact.toString() + " ");
            }

            printWriter.close();
            writer.close();

            return true;
        } catch (Exception e){
            return false;
        }
    };
}