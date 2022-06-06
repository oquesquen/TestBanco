package com.devskiller.controller;

import com.devskiller.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@RestController
public class ItemController {

    @Autowired
    private ItemService itemService;
    @RequestMapping(value = "titles")
    public List<String> getTitles(Double rating) {
        //TODO
        return itemService.getTitlesWithAverageRatingLowerThan(rating);
    }
}
