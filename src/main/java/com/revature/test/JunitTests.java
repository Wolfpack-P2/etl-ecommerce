package com.revature.test;

import static org.junit.Assert.*;


import com.revature.models.Order;
import com.revature.models.QueryResult;
import com.revature.repositories.OrderRepository;
import org.junit.Test;

import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import org.springframework.data.repository.query.FluentQuery;


import java.util.List;
import java.util.Optional;
import java.util.function.Function;

public class JunitTests implements OrderRepository {

    // private OrderRepository orderRepo;


     @Test
     public void Test01() {
        assertEquals(findCategory(), findCategory());
     }

     @Test
     public void Test02() {
        assertEquals(findCategoryCountry(), findCategoryCountry());
     }

     @Test
     public void Test03() {
        assertEquals(findYearPopularity(), findYearPopularity());
     }

     @Test
     public void Test04() {
        assertEquals(findYearPopularityCountry(), findYearPopularityCountry());
    }

    @Test
    public void Test05() {
        assertEquals(findTopCountry(), findTopCountry());
    }

    @Test
    public void Test06() {
        assertEquals(findBusiestTime(), findBusiestTime());
    }

    @Test
    public void Test07() {
        assertEquals(findBusiestTimeCountry(), findBusiestTimeCountry());
    }

    @Test
    public void Test08() {
        assertNotEquals(findCategory(), findCategoryCountry());
    }

    @Test
    public void Test09() {
        assertNotEquals(findYearPopularity(), findYearPopularityCountry());
    }
    @Test
    public void Test10() {
        assertNotEquals(findBusiestTime(), findBusiestTimeCountry());
    }

    @Override
    public List<QueryResult> findCategory() {
        return null;
    }

    @Override
    public List<QueryResult> findCategoryCountry() {
        return null;
    }

    @Override
    public List<QueryResult> findYearPopularity() {
        return null;
    }

    @Override
    public List<QueryResult> findYearPopularityCountry() {

         return null;
    }

    @Override
    public List<QueryResult> findTopCountry() {
        return null;
    }

    @Override
    public List<QueryResult> findBusiestTime() {
        return null;
    }

    @Override
    public List<QueryResult> findBusiestTimeCountry() {
        return null;
    }

    @Override
    public List<Order> findAll() {
        return null;
    }

    @Override
    public List<Order> findAll(Sort sort) {
        return null;
    }

    @Override
    public Page<Order> findAll(Pageable pageable) {
        return null;
    }

    @Override
    public List<Order> findAllById(Iterable<Integer> integers) {
        return null;
    }

    @Override
    public long count() {
        return 0;
    }

    @Override
    public void deleteById(Integer integer) {

    }

    @Override
    public void delete(Order entity) {

    }

    @Override
    public void deleteAllById(Iterable<? extends Integer> integers) {

    }

    @Override
    public void deleteAll(Iterable<? extends Order> entities) {

    }

    @Override
    public void deleteAll() {

    }

    @Override
    public <S extends Order> S save(S entity) {
        return null;
    }

    @Override
    public <S extends Order> List<S> saveAll(Iterable<S> entities) {
        return null;
    }

    @Override
    public Optional<Order> findById(Integer integer) {
        return Optional.empty();
    }

    @Override
    public boolean existsById(Integer integer) {
        return false;
    }

    @Override
    public void flush() {

    }

    @Override
    public <S extends Order> S saveAndFlush(S entity) {
        return null;
    }

    @Override
    public <S extends Order> List<S> saveAllAndFlush(Iterable<S> entities) {
        return null;
    }

    @Override
    public void deleteAllInBatch(Iterable<Order> entities) {

    }

    @Override
    public void deleteAllByIdInBatch(Iterable<Integer> integers) {

    }

    @Override
    public void deleteAllInBatch() {

    }

    @Override
    public Order getOne(Integer integer) {
        return null;
    }

    @Override
    public Order getById(Integer integer) {
        return null;
    }

    @Override
    public <S extends Order> Optional<S> findOne(Example<S> example) {
        return Optional.empty();
    }

    @Override
    public <S extends Order> List<S> findAll(Example<S> example) {
        return null;
    }

    @Override
    public <S extends Order> List<S> findAll(Example<S> example, Sort sort) {
        return null;
    }

    @Override
    public <S extends Order> Page<S> findAll(Example<S> example, Pageable pageable) {
        return null;
    }

    @Override
    public <S extends Order> long count(Example<S> example) {
        return 0;
    }

    @Override
    public <S extends Order> boolean exists(Example<S> example) {
        return false;
    }

    @Override
    public <S extends Order, R> R findBy(Example<S> example, Function<FluentQuery.FetchableFluentQuery<S>, R> queryFunction) {
        return null;
    }
}

