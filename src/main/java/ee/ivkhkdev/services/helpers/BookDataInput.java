package ee.ivkhkdev.services.helpers;

import ee.ivkhkdev.model.Author;
import ee.ivkhkdev.model.Book;

import java.util.Scanner;

public class BookDataInput {
    public Book createBook(Scanner scanner) {
        System.out.println("===== Новая книга =====");
        Book book = new Book();
        System.out.print("Название книги: ");
        book.setTitle(scanner.nextLine());
        System.out.println("Авторы: ");
        System.out.print("Кол-во авторов в книге: ");
        int countAuthors = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < countAuthors; i++) {
            Author author = new Author();
            System.out.printf("Автор %d:%n", i+1);
            System.out.print("Имя автора: ");
            author.setFirstname(scanner.nextLine());
            System.out.print("Фамилия автора: ");
            author.setLastname(scanner.nextLine());
            book.getAuthors().add(author);
        }
        System.out.print("Год публикации книги: ");
        book.setPublishedYear(Integer.parseInt(scanner.nextLine()));
        return book;
    }
}
