package 设计模式.迭代器模式.example;

/**
 * @ClassName BookShelfIterator
 * @Description TODO
 * @Author chasion
 * @Date 2022/5/5 21:11
 *
 * 书架具体实现迭代的类
 */
public class BookShelfIterator implements Iterator{

    private BookShelf bookShelf;
    private int index;

    public BookShelfIterator(BookShelf bookShelf) {
        this.bookShelf = bookShelf;
        this.index = 0;
    }

    @Override
    public boolean hasNext() {
        if (index < bookShelf.getLength()){
            return true;
        }
        return false;
    }

    @Override
    public Object next() {
        Book book = bookShelf.getBook(index);
        index++;
        return book;
    }
}
