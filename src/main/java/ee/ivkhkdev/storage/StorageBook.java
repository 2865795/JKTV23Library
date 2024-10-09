package ee.ivkhkdev.storage;

import ee.ivkhkdev.model.Book;
import ee.ivkhkdev.repository.BookRepository;

import java.util.List;

public class StorageBook implements BookRepository {

    @Override
    public void saveBooks(Book book) {
        
    }

    @Override
    public List<Book> loadBooks() {
        return List.of();
    }
}
