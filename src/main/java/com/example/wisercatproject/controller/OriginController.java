package com.example.wisercatproject.controller;

import com.example.wisercatproject.model.Origin;
import com.example.wisercatproject.service.implementation.OriginServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;

import static org.springframework.http.HttpStatus.OK;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/origins")
public class OriginController {

    private final OriginServiceImpl originService;

    @GetMapping("/")
    public ResponseEntity<Collection<Origin>> getOrigins() {
        Collection<Origin> origins = originService.list();
        return new ResponseEntity<>(origins, OK);
    }
}
