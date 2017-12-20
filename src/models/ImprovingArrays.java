package models;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;

public class ImprovingArrays {

    public static void main(String[] args) {
        ArrayList<String> myArrayList = new ArrayList<String>();// need () as I am calling my constructor
        HashSet<String> myHashSet = new HashSet<String>();//instantiated alltså new HashSet

        myArrayList.add("first item");
        boolean result = myArrayList.add("second item");//om man vill kolla att den blev added
        System.out.println(result);

        myArrayList.add("third item");
        myArrayList.add("fourth item");
        System.out.println(myArrayList.size());

        myHashSet.add("first item");
        myHashSet.add("second item");
        myHashSet.add("third item");
        myHashSet.add("fourth item");

        System.out.println(myHashSet.size());
        myHashSet.remove("second item");
        System.out.println(myHashSet.size());

        myArrayList.remove(1);
        myArrayList.add("first item");
        myArrayList.add(1, "first item");

        myHashSet.add("first item");
        myHashSet.add("first item");
        System.out.println("ArrayList size: "+ myArrayList.size());

        System.out.println("HashList size: "+ myHashSet.size());

        for (int i = 0; i < myArrayList.size(); i++) {//går inte för Hash eftersom det inte finnsindex
            System.out.println(myArrayList.get(i));
        }
        System.out.println("");
//        for (String string : myArrayList) { //gör samma som ovan
//            System.out.println(string);
//    
//for (String string : myHashSet) {//iterator, gör samma om nedan
//    System.out.println("HashSet: "+ string);
//            
//        }
Iterator<String> myIterator = myHashSet.iterator();//istället för att använda constructor kallar man metod
// allows us to scroll through the hashset in a forward direction
while (myIterator.hasNext()){//will queery the value of my iterator hasNext will return true if we have more to go or false if we have reached the end
String nextString = myIterator.next();
    System.out.println(nextString);//random eftersom det inte finns index

}

        HashMap<String, Book> myHashMap = new HashMap <String, Book> ();//import both HashMap and Book 
Book book1 = new Book ("1", "First book", "", "", "", 100);
Book book2 = new Book ("2", "Second book", "", "", "", 100);
Book book3 = new Book ("3", "Third book", "", "", "", 100);

myHashMap.put(book1.getTitle(),book1);
myHashMap.put(book2.getTitle(),book2);
myHashMap.put(book3.getTitle(),book3);
        System.out.println(myHashMap.size());
        
        myHashMap.remove(book2.getTitle());
        
     System.out.println(myHashMap.size());
     myHashMap.put(book2.getTitle(),book2);
     
    Iterator<Book> myValues= myHashMap.values().iterator();//myHashMap.values().iterator() vill return an obj of type book and I can use that to loop through the items
while (myValues.hasNext()){//will queery the value of my iterator hasNext will return true if we have more to go or false if we have reached the end
Book nextBook = myValues.next();
    System.out.println(nextBook.getTitle());//random eftersom det inte finns index

    }
myHashMap.keySet().iterator();

    }
    
    
    
}

