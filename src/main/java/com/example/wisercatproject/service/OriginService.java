package com.example.wisercatproject.service;

import com.example.wisercatproject.model.Origin;

import java.util.Collection;

public interface OriginService {
    Collection<Origin> list();
    Origin getByName(String name);
}
