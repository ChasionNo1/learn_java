package 设计模式.迭代器模式.homework;

import 设计模式.迭代器模式.example.Book;

/**
 * @ClassName Main
 * @Description TODO
 * @Author chasion
 * @Date 2022/5/5 21:36
 *
 *
 * 在示例程序的BookShelf类(代码清单1-4)中，当书的数量超过最初指定的书架容量时，就无法继续向书架中添加书本了。
 * 请大家不使用数组，而是用java.util.ArrayList修改程序，确保当书的数量超过最初指定的书架容量时也能继续向书架中添加书本。
 */
public class Main {

    public static void main(String[] args) {
        BookShelf bookShelf = new BookShelf(4);
        Book book1 = new Book("java");
        Book book2 = new Book("python");
        Book book3 = new Book("c++");
        Book book4 = new Book("php");
        Book book5 = new Book("javascript");

        bookShelf.append(book1);
        bookShelf.append(book2);
        bookShelf.append(book3);
        bookShelf.append(book4);
        bookShelf.append(book5);
        // 调用迭代器方法，返回迭代器对象
        Iterator<Book> iterator = bookShelf.iterator();
        while (iterator.hasNext()){
            Book next = iterator.next();
            System.out.print(next + "\t");
        }
    }
}
