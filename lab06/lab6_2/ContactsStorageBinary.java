package lab6_2;

import java.io.*;
import java.util.*;

class ContactsStorageBinary extends ContactsStorageManagement implements ContactsStorageInterface{
    private File binaryFile;

    public ContactsStorageBinary(File ourFile){
        super(ourFile);
        this.binaryFile = ourFile;
    }

    public List<Contact> loadContacts(){
        try{
            List<Contact> contacts = new ArrayList<>();

            FileReader fileReader = new FileReader(binaryFile);
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            String line;
            while ((line = bufferedReader.readLine()) != null) {

                String currentLine[] = line.split(" - ");

                for (int i = 0; i < currentLine.length; i++){
                    Contact contact = new Contact(currentLine[i],Integer.parseInt(currentLine[++i]));
                    contacts.add(contact);
                }        
            }

            bufferedReader.close();
            fileReader.close();

            return contacts;
        }catch (Exception e){
            System.err.println("ERROR" + e.toString());
        }

        return null;
    }
    
    public boolean saveContacts (List<Contact> list){
        try {
            FileWriter fileWriter = new FileWriter(this.binaryFile);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            
            //Write contacts from list
            for (Contact currentContact: list){
               bufferedWriter.write(currentContact.toString());
               bufferedWriter.newLine();
            }

            bufferedWriter.close();
            fileWriter.close();

            return true;
        } catch(Exception e){
            return false;
        }
    }
}