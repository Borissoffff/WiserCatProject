package com.example.wisercatproject.service;

import com.example.wisercatproject.model.FurColor;

import java.util.Collection;

public interface FurColorService {
    Collection<FurColor> list();
    FurColor getByName(String name);
}
