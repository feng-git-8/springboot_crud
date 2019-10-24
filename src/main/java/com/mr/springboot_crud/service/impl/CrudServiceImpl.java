package com.mr.springboot_crud.service.impl;

import com.mr.springboot_crud.entity.Crud;
import com.mr.springboot_crud.mapper.CrudMapper;
import com.mr.springboot_crud.service.ICrudService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CrudServiceImpl implements ICrudService {

    @Autowired
    private CrudMapper crudMapper;

    @Override
    public List<Crud> findCrudList() {
        return crudMapper.findCrudList();
    }

    @Override
    public int addCrud(Crud cr) {
        return crudMapper.addCrud(cr);
    }

    @Override
    public int deleteCrud(Integer cid) {
        return crudMapper.deleteCrud(cid);
    }

    @Override
    public Crud findOneCrud(Integer cid) {
        return crudMapper.findOneCrud(cid);
    }

    @Override
    public void updateCrudTrue(Crud cr) {
        crudMapper.updateCrudTrue(cr);
    }
}
