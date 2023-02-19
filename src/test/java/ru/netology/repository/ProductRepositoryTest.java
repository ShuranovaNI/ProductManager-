package ru.netology.repository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.netology.domain.Product;
import ru.netology.domain.Book;
import ru.netology.domain.Smartphone;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class ProductRepositoryTest {
    private final ProductRepository repo = new ProductRepository();
    Product product = new Product(11, "eggs",120);
    Product book = new Book(12, "Колобок",50,"Толстой Алексей Николаевич");
    Product smartphone = new Smartphone(13, "Galaxy S22 Ultra",150000, "SAMSUNG");
    @Test
    public void saveTest() {

        repo.save(product);
        repo.save(book);
        repo.save(smartphone);


        Product[] expected = {product,book,smartphone};
        Product[] actual = repo.getProducts();

        Assertions.assertArrayEquals(expected,actual);
    }
    @Test
    public void shouldSaveOneProduct() {

        repo.save(book);

        Product[] expected = {book};
        Product[] actual = repo.getProducts();

        assertArrayEquals(expected, actual);
    }

    @Test
    public void removeByIdTest() {

        repo.save(product);
        repo.save(book);
        repo.save(smartphone);
        repo.removeById(11);

        Product[] expected = {book,smartphone};
        Product[] actual = repo.getProducts();

        Assertions.assertArrayEquals(expected,actual);
    }
    @Test
    public void removeAllByIdTest() {

        repo.save(product);
        repo.save(book);
        repo.save(smartphone);
        repo.removeById(11);
        repo.removeById(12);
        repo.removeById(13);

        Product[] expected = {};
        Product[] actual = repo.getProducts();

        Assertions.assertArrayEquals(expected,actual);
    }

}
