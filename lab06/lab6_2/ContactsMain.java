package lab6_2;

import java.io.File;

class ContactsMain{
    public static void main(String[] args){
        ContactsManagement addressManager = new ContactsManagement();

        File thisFile = new File("src/ex02test.txt");
        ContactsStorageInterface storage = new ContactsStorageManagement(thisFile);

        addressManager.openAndLoad(storage);

        System.out.println(addressManager.getByName("Marta"));

        addressManager.add(new Contact("Marta Ferreira",123));
        System.out.println(addressManager.getByName("Marta Ferreira"));

        addressManager.remove(addressManager.getByName("Edu"));
        System.out.println(addressManager.exist(new Contact("Edu",435)));

        /*
        thisFile = new File("src/ex02binary");
        storage = new ContactsStorageManagement(thisFile);
        addressManager.saveAndClose(storage);
        */
    }
    
}