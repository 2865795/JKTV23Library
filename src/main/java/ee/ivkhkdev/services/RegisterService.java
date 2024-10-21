package ee.ivkhkdev.services;

import ee.ivkhkdev.helpers.AppHelperRegisterInput;
import ee.ivkhkdev.model.Register;
import ee.ivkhkdev.repository.Repository;
import ee.ivkhkdev.interfaces.Input;

public class RegisterService {
    private final Input input;
    private final Object appHelperRegisterInput;
    private final Repository<Register> repository;

    public RegisterService(Input input, Repository<Register> repository, AppHelperRegisterInput appHelperRegisterInput) {
        this.input = input;
        this.repository = repository;
        this.appHelperRegisterInput = appHelperRegisterInput;

    }

    public boolean bookBorrow(UserService userService, BookService bookService) {
        Register register = appHelperRegisterInput.bookBorrow(input, userService, bookService);
        if(register != null) {
            repository.save(register);
            return true;
        }else{
            return false;
        }
    }

    public boolean returnBook() {
        return appHelperRegisterInput.returnBookDialog(input, repository);
    }
}
