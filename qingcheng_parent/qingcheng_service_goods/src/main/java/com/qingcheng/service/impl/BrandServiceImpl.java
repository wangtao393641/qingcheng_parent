package com.qingcheng.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.qingcheng.dao.BrandMapper;
import com.qingcheng.entity.PageResult;
import com.qingcheng.pojo.goods.Brand;
import com.qingcheng.service.goods.BrandService;
import org.springframework.beans.factory.annotation.Autowired;
import tk.mybatis.mapper.entity.Example;

import java.util.List;
import java.util.Map;


/**
 * 品牌业务实现
 */
@Service
public class BrandServiceImpl implements BrandService {

    @Autowired
    private BrandMapper brandMapper;

    @Override
    public List<Brand> findAll() {
        List<Brand> brandList = brandMapper.selectAll();
        return brandList;
    }

    /**
     * 根据id查询
     *
     * @param id
     * @return
     */
    @Override
    public Brand findById(Integer id) {
        return brandMapper.selectByPrimaryKey(id);
    }

    /**
     * 品牌新增
     *
     * @param brand
     */
    @Override
    public void add(Brand brand) {
        brandMapper.insert(brand);
    }

    /**
     * 品牌修改
     *
     * @param brand
     */
    @Override
    public void update(Brand brand) {
        brandMapper.updateByPrimaryKeySelective(brand);
    }

    /**
     * 品牌删除
     *
     * @param id
     */
    @Override
    public void delete(Integer id) {
        brandMapper.deleteByPrimaryKey(id);
    }

    /**
     * 分页+条件查询
     *
     * @param searchMap
     * @return
     */
    @Override
    public PageResult<Brand> findPage(Map<String, Object> searchMap, int page, int size) {
        PageHelper.startPage(page, size);
        Example example = createExample(searchMap);
        Page<Brand> brands = (Page<Brand>) brandMapper.selectByExample(example);
        return new PageResult<Brand>(brands.getTotal(), brands.getResult());
    }

    /**
     * 分页查询
     *
     * @param
     * @return分页结果
     */
    @Override
    public PageResult<Brand> findPage(int page, int size) {
        PageHelper.startPage(page, size);
        Page<Brand> brands = (Page<Brand>) brandMapper.selectAll();
        return new PageResult<Brand>(brands.getTotal(), brands.getResult());
    }

    /**
     * 条件查询
     *
     * @param searchMap
     * @return
     */
    @Override
    public List<Brand> findList(Map<String, Object> searchMap) {
        Example example = createExample(searchMap);
        return brandMapper.selectByExample(example);
    }

    /**
     * 构建查询条件
     *
     * @param searchMap
     * @return
     */

    private Example createExample(Map<String, Object> searchMap) {
        Example example = new Example(Brand.class);
        Example.Criteria criteria = example.createCriteria();
        if (searchMap != null) {
            //名字条件
            if (searchMap.get("name") != null && !"".equals(searchMap.get("name"))) {
                criteria.andLike("name", "%" + (String) searchMap.get("name") + "%");
            }
            //首字母
            if (searchMap.get("letter") != null && !"".equals(searchMap.get("letter"))) {
                criteria.andEqualTo("letter", searchMap.get("letter"));
            }
        }
        return example;
    }

}