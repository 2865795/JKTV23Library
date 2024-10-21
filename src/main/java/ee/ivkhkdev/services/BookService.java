package ee.ivkhkdev.services;

import ee.ivkhkdev.model.Book;
import ee.ivkhkdev.helpers.AppHelperBookInput;
import ee.ivkhkdev.repository.Repository;
import ee.ivkhkdev.interfaces.Input;

public class BookService {
    private final Input input;
    private final AppHelperBookInput appHelperBookInput;
    private final Repository<Book> repository;

    public BookService(Input input, AppHelperBookInput appHelperBookInput, Repository<Book> repository) {
        this.input = input;
        this.repository = repository;
        this.appHelperBookInput = appHelperBookInput;

    }

    public boolean addBook(){
        Book book = appHelperBookInput.createBook(input);
        if(book != null) {
            repository.save(book);
            return true;
        }else{
            return false;
        }
    }

    public void books(Repository<Book> repositoryBook) {
        appHelperBookInput.printBooks(repositoryBook.getEntities());
    }

    public Repository<Book> getRepository() {
        return repository;
    }
}
