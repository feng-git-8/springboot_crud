package com.mr.springboot_crud.service;

import com.mr.springboot_crud.entity.Crud;

import java.util.List;

public interface ICrudService {
    List<Crud> findCrudList();

    int addCrud(Crud cr);

    int deleteCrud(Integer cid);

    Crud findOneCrud(Integer cid);

    void updateCrudTrue(Crud cr);
}
