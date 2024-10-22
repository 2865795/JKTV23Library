package ee.ivkhkdev.services;

import ee.ivkhkdev.helpers.AppHelperUserInput;
import ee.ivkhkdev.model.User;
import ee.ivkhkdev.repository.Repository;

import java.util.List;

public class UserService {
    private final AppHelperUserInput appHelperUserInput;
    private final Repository<User> repository;
    private final List<User> users;

    public UserService(List<User> users, AppHelperUserInput appHelperUserInput, Repository<User> repository) {
        this.users = users;
        this.repository = repository;
        this.appHelperUserInput = appHelperUserInput;
    }
    public boolean addUser(){
        User user = appHelperUserInput.createUser();
        if(user != null){
            users.add(user);
            repository.save(users);
            return true;
        }else{
            return false;
        }
    }

    public void users() {
        appHelperUserInput.printUsers();
    }

    public Repository<User> getRepository() {
        return repository;
    }
}
