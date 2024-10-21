package ee.ivkhkdev;

import ee.ivkhkdev.helpers.AppHelperRegisterInput;
import ee.ivkhkdev.helpers.AppHelperUserInput;
import ee.ivkhkdev.model.Book;
import ee.ivkhkdev.model.Register;
import ee.ivkhkdev.model.User;
import ee.ivkhkdev.repository.Repository;
import ee.ivkhkdev.services.BookService;
import ee.ivkhkdev.helpers.AppHelperBookInput;
import ee.ivkhkdev.services.RegisterService;
import ee.ivkhkdev.services.UserService;
import ee.ivkhkdev.storages.Storage;
import ee.ivkhkdev.interfaces.Input;

public class App {
    private final Input input;
    private final Repository<Book> repositoryBook;
    private final Repository<User> repositoryUser;
    private final Repository<Register> repositoryRegister;

    private final BookService bookService;
    private final UserService userService;
    private final RegisterService registerService;
    private final AppHelperBookInput appHelperBookInput;
    private final AppHelperUserInput appHelperUserInput;
    private final AppHelperRegisterInput appHelperRegisterInput;


    public App(Input input) {
        this.input = input;
        this.repositoryBook = new Storage<>("books");
        this.repositoryUser = new Storage<>("users");
        this.repositoryRegister = new Storage<>("register");
        this.appHelperBookInput = new AppHelperBookInput();
        this.appHelperUserInput = new AppHelperUserInput();
        this.appHelperRegisterInput = new AppHelperRegisterInput();
        this.bookService = new BookService(input, appHelperBookInput, repositoryBook);
        this.userService = new UserService(input, appHelperUserInput, repositoryUser);
        this.registerService = new RegisterService(input, repositoryRegister, appHelperRegisterInput);
    }



    public void run() {
        boolean repeat = true;
        System.out.println("--------------- JKTV23 библиотека --------------");
        do {
            System.out.println("Список задач: ");
            System.out.println("0. Выход из программы");
            System.out.println("1. Добавить книгу");
            System.out.println("2. Добавить читателя");
            System.out.println("3. Список книг");
            System.out.println("4. Список читателей");
            System.out.println("5. Выдать книгу");
            System.out.println("6. Вернуть книгу");
            System.out.print("Выберите номер задачи из списка: ");
            int task = Integer.parseInt(input.nextLine());
            switch (task) {
                case 0:
                    repeat = false;
                    break;
                case 1:
                    if(bookService.addBook()){
                        System.out.println("Книга добавлена");
                    } else {
                        System.out.println("Книгу добавить не удалось");
                    }
                    break;
                case 2:
                    if(userService.addUser()){
                        System.out.println("Читатель добавлен");
                    } else {
                        System.out.println("Читателя добавить не удалось");
                    }
                    break;
                case 3:
                    bookService.books(repositoryBook);
                    break;
                case 4:
                    userService.users(repositoryUser);
                    break;
                case 5:
                    if (registerService.bookBorrow(userService, bookService)) {
                        System.out.println("Книга выдана");
                    } else {
                        System.out.println("Книгу выдать не удалось");
                    }
                    break;
                case 6:
                    if (registerService.returnBook()) {

                    }
                    break;
                default:
                    System.out.println("Выберите номер задачи из списка!");
            }
        }while (repeat);
        System.out.println("До свидания!");

    }
}
