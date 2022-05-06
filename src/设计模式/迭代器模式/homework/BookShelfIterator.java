package 设计模式.迭代器模式.homework;

import 设计模式.迭代器模式.example.Book;

/**
 * @ClassName BookShelfIterator
 * @Description TODO
 * @Author chasion
 * @Date 2022/5/5 21:38
 */
public class BookShelfIterator implements Iterator<Book> {
    private BookShelf bookShelf;
    // 要有一个指针
    private int index;

    public BookShelfIterator(BookShelf bookShelf) {
        this.bookShelf = bookShelf;
        index = 0;
    }

    @Override
    public boolean hasNext() {
        if (index < bookShelf.getLength()){
            return true;
        }
        return false;
    }

    @Override
    public Book next() {
        Book book = bookShelf.get(index);
        index++;
        return book;
    }
}
