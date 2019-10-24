package com.mr.springboot_crud.mapper;

import com.mr.springboot_crud.entity.Crud;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface CrudMapper {

    /**
     * 查询
     * @return
     */
    @Select("select * from t_crud where stauts=0")
    public List<Crud> findCrudList();

    @Insert("insert into t_crud values(#{cid},#{cname},#{cdate},0)")
    int addCrud(Crud cr);

    @Delete("update t_crud set stauts=1 where cid = #{cid}")
    int deleteCrud(Integer cid);

    @Select("select * from t_crud where cid = #{cid}")
    Crud findOneCrud(Integer cid);

    @Insert("update t_crud set cname=#{cname},cdate=#{cdate} where cid=#{cid}")
    void updateCrudTrue(Crud cr);
}
