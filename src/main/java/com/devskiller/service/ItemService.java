package com.devskiller.service;

import com.devskiller.dao.ItemRepository;
import com.devskiller.model.Item;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ItemService {

    private final ItemRepository itemRepository;
    @Autowired
    private Item item;

    public ItemService(ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }

    public List<String> getTitlesWithAverageRatingLowerThan(Double rating) {
        //TODO

        List<String> listaTitulos = new ArrayList<>();

        List<Item> listaItem = itemRepository.findItemsWithAverageRatingLowerThan(rating);
        Iterator<Item> it = listaItem.iterator();
        while (it.hasNext()){
            listaTitulos.add(it.next().getTitle());
        }

        return listaTitulos;
    }

}
