package com.devskiller.impl;

import com.devskiller.dao.ItemRepository;
import com.devskiller.model.Item;
import com.devskiller.model.Review;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Optional;

@Repository
@Transactional
public class ItemRepositoryImpl implements ItemRepository {

    @Autowired
    private Item item;

    @Autowired
    private Item review;

    @PersistenceContext
    EntityManager entityManager;

    @Override
    public List<Item> findItemsWithAverageRatingLowerThan(Double rating) {
        String query = "FROM Review where rating < :rating";

        List<Item> listaItem = new ArrayList<Item>();

        List<Review> listaReview = entityManager.createQuery(query)
                .setParameter("rating", rating )
                .getResultList();

        if(!listaReview.isEmpty()){
            Iterator<Review> it = listaReview.iterator();
            while(it.hasNext()) {
                listaItem.add(it.next().getItem());
            }
        }

        return listaItem;
    }

    @Override
    public <S extends Item> S save(S s) {
        return null;
    }

    @Override
    public <S extends Item> Iterable<S> saveAll(Iterable<S> iterable) {
        return null;
    }

    @Override
    public Optional<Item> findById(Long aLong) {
        return Optional.empty();
    }

    @Override
    public boolean existsById(Long aLong) {
        return false;
    }

    @Override
    public Iterable<Item> findAll() {
        return null;
    }

    @Override
    public Iterable<Item> findAllById(Iterable<Long> iterable) {
        return null;
    }

    @Override
    public long count() {
        return 0;
    }

    @Override
    public void deleteById(Long aLong) {

    }

    @Override
    public void delete(Item item) {

    }

    @Override
    public void deleteAll(Iterable<? extends Item> iterable) {

    }

    @Override
    public void deleteAll() {

    }
}
