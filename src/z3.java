class Item {
    char d; // ключ
    Item next; // поле, содержащее ссылку на следующий элемент

    // конструктор
    Item(char value) {
        d = value;
    }
}

class List {
    Item pbeg = null; // указатель на начало очереди
    Item pend = null; // указатель на конец очереди

    void first(char value) {
        Item pv = new Item(value);
        pv.next = null;
        pbeg = pv;
        pend = pbeg;
    }

    // Добавление в конец очереди
    void add(char value) {
        Item pv = new Item(value);
        pv.next = null;
        pend.next = pv;
        pend = pv;
    }

    // Выборка из начала очереди
    char pop() {
        char temp = pbeg.d;
        pbeg = pbeg.next;
        return temp;
    }

    // Поиск элемента по ключу
    Item search(char key) {
        Item current = pbeg;
        while (current != null) {
            if (current.d == key) {
                return current;
            }
            current = current.next;
        }
        return null; // элемент не найден
    }
}

public class z3 {
    public static void main(String[] args) {
        List och = new List();
        och.first('A');
        for (char c = 'B'; c <= 'E'; c++) {
            och.add(c);
        }
        char searchKey = 'C'; // Заданный элемент для поиска
        Item foundItem = och.search(searchKey);
        int aaa;
        if (foundItem != null) {
            aaa= 1;
        } else {
            aaa = 0;
        }

        while (och.pbeg != null) {
            System.out.print(" " + och.pop());
        }

        if (aaa == 1) {
            System.out.print("\nЭлемент " + searchKey + " найден в очереди.");
        } else {
            System.out.print("\nЭлемент " + searchKey + " не найден в очереди.");
        }

    }
}