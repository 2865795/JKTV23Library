package ee.ivkhkdev.helpers;

import ee.ivkhkdev.interfaces.Input;
import ee.ivkhkdev.model.Book;
import ee.ivkhkdev.model.Register;
import ee.ivkhkdev.model.User;
import ee.ivkhkdev.repository.Repository;
import ee.ivkhkdev.services.BookService;
import ee.ivkhkdev.services.UserService;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

public class AppHelperRegisterInput {
    public Register bookBorrow(Input input, UserService userService, BookService bookService) {
        try {
            Register register = new Register();
            userService.users(userService.getRepository());
            System.out.print("Введите номер пользователя из списка: ");
            int numberUser = Integer.parseInt(input.nextLine());
            User user = userService.getRepository().getEntities().get(numberUser-1);
            bookService.books(bookService.getRepository());
            System.out.print("Введите номер книги из списка: ");
            int numberBook = Integer.parseInt(input.nextLine());
            Book book = bookService.getRepository().getEntities().get(numberBook-1);
            register.setUser(user);
            register.setBook(book);
            register.setBookBorrowDate(LocalDate.now());
            return register;
        } catch (Exception e) {
            return null;
        }
    }

    public void listBorrowedBooks(Repository repository){
        List<Register> registerList = (List<Register>) repository.getEntities();
        if (repository.getEntities().isEmpty()){
            System.out.println(" --- Список выданных книг пуст --- ");
        } else {
            System.out.println(" --- Список выданных книг --- ");
            for (int i = 0; i < repository.getEntities().size(); i++){
                if ((registerList.get(i)).getReturnBookDate() != null){
                    continue;
                }
                System.out.printf("%d. %s. %s. %d%n",
                        i+1,
                        registerList.get(i).getBook().getTitle(),
                        Arrays.toString(registerList.get(i).getBook().getAuthors().toArray()),
                        registerList.get(i).getBook().getPublishedYear()
                );
            }
            System.out.println(" --- Конец списка --- ");
        }
    }

    public boolean returnBookDialog(Input input, Repository repository) {
        try {
        listBorrowedBooks(repository);
        System.out.print("Выберите номер возвращаемой книги: ");
        int numberReturnBookRegister = Integer.parseInt(input.nextLine());
        Register register = (Register) repository.getEntities().get(numberReturnBookRegister - 1);
        register.setReturnBookDate(LocalDate.now());
        return true;
        } catch (Exception e) {
            return false;
        }
    }
}
