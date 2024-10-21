package ee.ivkhkdev.services;

import ee.ivkhkdev.helpers.AppHelperUserInput;
import ee.ivkhkdev.model.Book;
import ee.ivkhkdev.model.User;
import ee.ivkhkdev.repository.Repository;
import ee.ivkhkdev.interfaces.Input;

public class UserService {
    private final Input input;
    private final AppHelperUserInput appHelperUserInput;
    private final Repository<User> repository;

    public UserService(Input input, AppHelperUserInput appHelperUserInput, Repository<User> repository) {
        this.input = input;
        this.appHelperUserInput = appHelperUserInput;
        this.repository = repository;
    }
    public boolean addUser(){
        User user = appHelperUserInput.createUser(input);
        if(user != null){
            repository.save(user);
            return true;
        }else{
            return false;
        }
    }

    public void users(Repository<User> repositoryUser) {
        appHelperUserInput.printUsers(repositoryUser.getEntities());
    }

    public Repository<User> getRepository() {
        return repository;
    }
}
