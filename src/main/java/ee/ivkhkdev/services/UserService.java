package ee.ivkhkdev.services;

import ee.ivkhkdev.helpers.AppHelper;
import ee.ivkhkdev.helpers.AppHelperUser;
import ee.ivkhkdev.model.User;
import ee.ivkhkdev.repository.Repository;

import java.util.List;

public class UserService implements Service<User> {
    private final AppHelper<User> appHelperUser;
    private final Repository<User> repository;
    private final List<User> users;

    public UserService(List<User> users, AppHelper<User> appHelperUser, Repository<User> repository) {
        this.users = users;
        this.repository = repository;
        this.appHelperUser = appHelperUser;
    }
    @Override
    public boolean add(){
        User user = appHelperUser.create();
        if(user != null){
            users.add(user);
            repository.save(users);
            return true;
        }else{
            return false;
        }
    }
    @Override
    public void print() {
        appHelperUser.printList();
    }
    @Override
    public Repository<User> getRepository() {
        return repository;
    }
    @Override
    public boolean edit() {
        return false;
    }

    @Override
    public boolean remove() {
        return false;
    }
}
