package ee.ivkhkdev.helpers;

import ee.ivkhkdev.model.Author;
import ee.ivkhkdev.model.Book;
import ee.ivkhkdev.interfaces.Input;
import ee.ivkhkdev.interfaces.impl.ConsoleInput;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

class AppHelperBookInputTest {
    Input inputMock;
    List<Book> booksMock;
    AppHelperAuthorInput appHelperAuthorInputMock;
    AppHelperBookInput appHelperBookInput;
    @BeforeEach
    void setUp() {
        inputMock = Mockito.mock(ConsoleInput.class);
        booksMock = Mockito.mock(ArrayList.class);
        appHelperAuthorInputMock = Mockito.mock(AppHelperAuthorInput.class);
        appHelperBookInput = new AppHelperBookInput(inputMock, booksMock, appHelperAuthorInputMock);

    }

    @AfterEach
    void tearDown() {
        inputMock = null;
        booksMock = null;
        appHelperAuthorInputMock = null;
        appHelperBookInput =null;
    }

    @Test
    void CreateBook() {
        when(inputMock.nextLine()).thenReturn("Voina i mir", "0");
        Book actual = appHelperBookInput.createBook();
//        Author author = new Author("Lev","Tolstoy");
//        List<Author> authors = new ArrayList<>();
//        authors.add(author);
//        Book expected = new Book("Voina i mir", authors, 2000);
        Book expected = null;
        assertTrue(actual == expected);
    }
}