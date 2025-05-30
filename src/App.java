public class App {

    public static void main(String a[]) {

        DoublyLinkedList<Character> list = new DoublyLinkedList<>();
        list.addAtEnd('H');
        list.addAtEnd('e');
        list.addAtEnd('l');
        list.addAtEnd('l');
        list.addAtEnd('o');
        System.out.println(list);
        list.addAtFront('A');   
        list.addAtPosition(3, 'x');
        System.out.println(list);
                
        }
}
