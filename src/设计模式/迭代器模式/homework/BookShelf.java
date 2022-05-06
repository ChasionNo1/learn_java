package 设计模式.迭代器模式.homework;

import 设计模式.迭代器模式.example.Book;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName BookShelf
 * @Description TODO
 * @Author chasion
 * @Date 2022/5/5 21:38
 *
 * 在书架这个类，实现集合接口，确定泛型
 */
public class BookShelf implements Aggregate<Book>{
    private ArrayList<Book> books;
    // 这里不需要设置last了，list可以得到大小
    // 改为容量，如果容量不够，需要扩容
    private int capacity;

    public BookShelf(int maxsize){
        books = new ArrayList<>(maxsize);
        capacity = maxsize;
    }

    @Override
    public Iterator<Book> iterator() {
        return new BookShelfIterator(this);
    }

    @Override
    public int getLength() {
        return books.size();
    }

    @Override
    public void append(Book book) {
        // 考虑扩容
        if (getLength() <= capacity){
            books.add(book);
        }else {
            // 扩容了
            books = increment(books, 2 * capacity + 1);
            books.add(book);
        }

    }

    @Override
    public Book get(int index) {
        return books.get(index);
    }

    // 扩容方法
    // 需要扩容的list
    public ArrayList<Book> increment(List<Book> books, int newCapacity){
        ArrayList<Book> newBooks = new ArrayList<>(newCapacity);
        newBooks.addAll(books);
        return newBooks;
    }
}
