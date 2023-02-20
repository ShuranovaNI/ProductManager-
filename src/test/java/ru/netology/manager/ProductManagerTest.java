package ru.netology.manager;

import org.junit.jupiter.api.Test;
import ru.netology.domain.Book;
import ru.netology.domain.Product;
import ru.netology.domain.Smartphone;
import ru.netology.repository.ProductRepository;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class ProductManagerTest {
    ProductRepository repo = new ProductRepository();
    ProductManager manager = new ProductManager(repo);

    Product product = new Product(11, "eggs", 120);
    Product book = new Book(12, "инструкция Galaxy S22 Ultra", 50, "Автор");
    Product smartphone = new Smartphone(13, "Galaxy S22 Ultra", 150000, "SAMSUNG");

    @Test
    void shouldAdd() {
        manager.add(book);
        Product[] expected = {book};
        Product[] actual = repo.getProducts();
        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldAddAll() {
        manager.add(book);
        manager.add(smartphone);
        manager.add(product);
        Product[] expected = {book, smartphone, product};
        Product[] actual = repo.getProducts();
        assertArrayEquals(expected, actual);
    }

    @Test
    void ShouldSearchedWhenOneProductFits() {
        manager.add(book);
        manager.add(smartphone);
        manager.add(product);
        String name = "eggs";
        Product[] expected = {product};
        Product[] actual = manager.searchBy(name);
        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldSearchWhenFewProductsSuit() {
        manager.add(book);
        manager.add(smartphone);
        manager.add(product);
        String name = "Galaxy S22 Ultra";
        Product[] expected = {book, smartphone};
        Product[] actual = manager.searchBy(name);
        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldSearchWhenProductsNotSuit() {
        manager.add(book);
        manager.add(smartphone);
        manager.add(product);
        String name = "iPhone";
        Product[] expected = {};
        Product[] actual = manager.searchBy(name);
        assertArrayEquals(expected, actual);
    }

}

