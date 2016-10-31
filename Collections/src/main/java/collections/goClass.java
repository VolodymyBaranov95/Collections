
package ua.yandex.collections;

/**
 *
 * @author VladimirBaranov
 */
public class goClass {
    public static void main(String args[]) throws NotEnoughIndexException{
        MyLinkedList list = new MyLinkedList();
list.add("a");
list.add("b");
list.add("c");
list.add("d");
System.out.println(list.toString());
MyCollections.reverse(list);
System.out.println(list.toString());
 
        }
     }

