package com.example.wisercatproject.controller;

import com.example.wisercatproject.model.FurColor;
import com.example.wisercatproject.service.implementation.FurColorServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

import static org.springframework.http.HttpStatus.OK;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/furColors")
public class FurColorController {

    private final FurColorServiceImpl furColorService;

    @GetMapping("/")
    public ResponseEntity<Collection<FurColor>> getFurColors() {
        Collection<FurColor> colors = furColorService.list();
        return new ResponseEntity<>(colors, OK);
    }
}
