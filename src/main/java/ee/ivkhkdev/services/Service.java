package ee.ivkhkdev.services;

import ee.ivkhkdev.repository.Repository;

import java.util.List;

public interface Service<T> {
    boolean add();
    boolean edit();
    boolean remove();
    void print();
    Repository<T> getRepository();
}
