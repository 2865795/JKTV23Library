package ee.ivkhkdev.services;

import ee.ivkhkdev.helpers.AppHelperAuthorInput;
import ee.ivkhkdev.model.Author;
import ee.ivkhkdev.repository.Repository;

import java.util.List;

public class AuthorService {
    private final AppHelperAuthorInput appHelperAuthorInput;
    private final Repository<Author> repository;
    private final List<Author> authors;

    public AuthorService(List<Author> authors, AppHelperAuthorInput appHelperAuthorInput, Repository<Author> repository) {
        this.authors = authors;
        this.repository = repository;
        this.appHelperAuthorInput = appHelperAuthorInput;
    }
    public boolean addAuthor(){
        Author author = appHelperAuthorInput.createAuthor();
        if(author != null){
            authors.add(author);
            repository.save(authors);
            return true;
        }else{
            return false;
        }
    }

    public void authors() {
        appHelperAuthorInput.printAuthors();
    }

    public Repository<Author> getRepository() {
        return repository;
    }
}
