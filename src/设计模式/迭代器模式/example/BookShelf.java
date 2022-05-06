package 设计模式.迭代器模式.example;

/**
 * @ClassName BookShelf
 * @Description TODO
 * @Author chasion
 * @Date 2022/5/5 21:07
 *
 * 书架实现类，要实现聚合接口，这个接口里有迭代方法，也应该包含其他集合的方法，例如添加、删除、修改、索引等；
 * 这样这个书架，就具有了迭代的功能
 * 类似于集合有了迭代器
 */
public class BookShelf implements Aggregate{

    private Book[] books;
    private int last;
    public BookShelf(int maxsize){
        this.books = new Book[maxsize];
    }

    public Book getBook(int index){
        return books[index];
    }

    public void appendBook(Book book){
        books[last++] = book;
    }

    public int getLength(){
        return last;
    }

    // 返回迭代器实现类对象
    @Override
    public Iterator iterator() {
        return new BookShelfIterator(this);
    }
}
