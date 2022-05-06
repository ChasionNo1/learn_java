package 设计模式.迭代器模式.example;

/**
 * @ClassName Main
 * @Description TODO
 * @Author chasion
 * @Date 2022/5/5 21:16
 */
public class Main {
    public static void main(String[] args) {
        BookShelf bookShelf = new BookShelf(4);
        Book book1 = new Book("java");
        Book book2 = new Book("python");
        Book book3 = new Book("c++");
        Book book4 = new Book("php");
        bookShelf.appendBook(book1);
        bookShelf.appendBook(book2);
        bookShelf.appendBook(book3);
        bookShelf.appendBook(book4);
        // 调用迭代器方法，返回迭代器对象
        Iterator iterator = bookShelf.iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }
    }

    /*
    * 迭代器模式中：
    * 迭代器(iterator)
    * 具体迭代器(concreteIterator)
    * 集合(aggregate)
    * 具体集合(concreteIterator)
    *
    *
    * */
}
