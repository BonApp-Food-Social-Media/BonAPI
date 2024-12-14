package ch.bonapp.bonapi.repositories;


import ch.bonapp.bonapi.entities.both.Food;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.query.FluentQuery;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;

@Repository
public class BonAPI_Food_Repository implements MongoRepository<Food,String> {
    @Override
    public <S extends Food> S insert(S entity) {
        return null;
    }

    @Override
    public <S extends Food> List<S> insert(Iterable<S> entities) {
        return null;
    }

    @Override
    public <S extends Food> Optional<S> findOne(Example<S> example) {
        return Optional.empty();
    }

    @Override
    public <S extends Food> List<S> findAll(Example<S> example) {
        return null;
    }

    @Override
    public <S extends Food> List<S> findAll(Example<S> example, Sort sort) {
        return null;
    }

    @Override
    public <S extends Food> Page<S> findAll(Example<S> example, Pageable pageable) {
        return null;
    }

    @Override
    public <S extends Food> long count(Example<S> example) {
        return 0;
    }

    @Override
    public <S extends Food> boolean exists(Example<S> example) {
        return false;
    }

    @Override
    public <S extends Food, R> R findBy(Example<S> example, Function<FluentQuery.FetchableFluentQuery<S>, R> queryFunction) {
        return null;
    }

    @Override
    public <S extends Food> S save(S entity) {
        return null;
    }

    @Override
    public <S extends Food> List<S> saveAll(Iterable<S> entities) {
        return null;
    }

    @Override
    public Optional<Food> findById(String s) {
        return Optional.empty();
    }

    @Override
    public boolean existsById(String s) {
        return false;
    }

    @Override
    public List<Food> findAll() {
        return null;
    }

    @Override
    public List<Food> findAllById(Iterable<String> strings) {
        return null;
    }

    @Override
    public long count() {
        return 0;
    }

    @Override
    public void deleteById(String s) {

    }

    @Override
    public void delete(Food entity) {

    }

    @Override
    public void deleteAllById(Iterable<? extends String> strings) {

    }

    @Override
    public void deleteAll(Iterable<? extends Food> entities) {

    }

    @Override
    public void deleteAll() {

    }

    @Override
    public List<Food> findAll(Sort sort) {
        return null;
    }

    @Override
    public Page<Food> findAll(Pageable pageable) {
        return null;
    }
}
