package ee.ivkhkdev.services;

import ee.ivkhkdev.helpers.AppHelperRegisterInput;
import ee.ivkhkdev.model.Book;
import ee.ivkhkdev.model.Register;
import ee.ivkhkdev.model.User;
import ee.ivkhkdev.repository.Repository;
import ee.ivkhkdev.interfaces.Input;

import java.util.List;

public class RegisterService {
    private final Input input;
    private final AppHelperRegisterInput appHelperRegisterInput;
    private final Repository<Register> repository;
    private final List<Book> books;
    private final List<Register> registers;
    private final List<User> users;

    public RegisterService(List<Book> books, List<User> users, List<Register> registers, Input input, Repository<Register> repository, AppHelperRegisterInput appHelperRegisterInput) {
        this.input = input;
        this.repository = repository;
        this.appHelperRegisterInput = appHelperRegisterInput;
        this.books = books;
        this.users = users;
        this.registers = registers;

    }

    public boolean bookBorrow(List<Book> books,UserService userService, BookService bookService) {
        Register register = appHelperRegisterInput.bookBorrow(books, users, registers, input, userService, bookService);
        if(register != null) {
            registers.add(register);
            repository.save(registers);
            return true;
        }else{
            return false;
        }
    }

    public boolean returnBook(Input input, List<Register> registers) {
        return appHelperRegisterInput.returnBookDialog(input, registers);
    }
}
