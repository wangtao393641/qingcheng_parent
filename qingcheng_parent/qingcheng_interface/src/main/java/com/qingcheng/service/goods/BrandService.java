package com.qingcheng.service.goods;

import com.qingcheng.entity.PageResult;
import com.qingcheng.pojo.goods.Brand;

import java.util.List;
import java.util.Map;

/**
 * 品牌业务逻辑层接口
 */
public interface BrandService {

    /**
     * 查询所有品牌
     *
     * @return
     */
    public List<Brand> findAll();

    /**
     * 分页查询
     *
     * @return
     */
    public PageResult<Brand> findPage(int page, int size);

    /**
     * 品牌条件查询
     *
     * @return
     */
    public List<Brand> findList(Map<String, Object> searchMap);

    /**
     * 品牌条件查询
     */
    public PageResult<Brand> findPage(Map<String, Object> searchMap, int page, int size);

    /**
     * 根据id查询
     *
     * @return
     */
    public Brand findById(Integer id);

    /**
     * 品牌新增
     */
    public void add(Brand brand);

    /**
     * 品牌修改
     */
    public void update(Brand brand);

    /**
     * 品牌删除
     */
    public void delete(Integer id);

}
