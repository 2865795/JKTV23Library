package ee.ivkhkdev.helpers;

import ee.ivkhkdev.interfaces.Input;
import ee.ivkhkdev.model.Author;

import java.util.List;

public class AppHelperAuthor implements AppHelper<Author> {
    private final Input input;
    private final List<Author> authors;

    public AppHelperAuthor(Input input, List<Author> authors) {
        this.input = input;
        this.authors = authors;
    }

    @Override
    public Author create(){
        Author author = new Author();
        System.out.print("Имя: ");
        author.setFirstname(input.nextLine());
        System.out.print("Фамилия: ");
        author.setLastname(input.nextLine());
        return author;
    }
    @Override
    public void printList() {
        if (authors.isEmpty()) {
            System.out.println(" --- Список авторов пуст --- ");
        } else {
            System.out.println(" --- Список авторов --- ");
            for (int i = 0; i < authors.size(); i++) {
                System.out.printf("%s6. %s %s.%n",
                        i + 1,
                        authors.get(i).getFirstname(),
                        authors.get(i).getLastname()
                );
            }
            System.out.println(" --- Конец списка --- ");
        }
    }
    @Override
    public List<Author> getList() {
        return authors;
    }
}
