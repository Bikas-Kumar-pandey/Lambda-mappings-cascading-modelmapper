package com.list.controller;

import com.list.controller.EntityController;
import com.list.dto.NewDto;
import com.list.mulltiDbConfig.entity.Students;
import com.list.mulltiDbConfig.repo.StudRepo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MultiData {

    @Autowired
    private StudRepo studRepo;

    private static final Logger LOGGER = LoggerFactory.getLogger(EntityController.class);


    @GetMapping("/hello")
    public void demos(@RequestBody NewDto dto) {


        try {

            studRepo.findById(String.valueOf(dto));

        } catch (Exception e) {
            LOGGER.info("Exception Occured while registering Trip " + e.getMessage());
        }

        LOGGER.info("Heyy Boii :)");


    }




    @PostMapping
    public String SaveMultiDbCofig(Students students){
        studRepo.save(students);
        return "saved";
    }
}
