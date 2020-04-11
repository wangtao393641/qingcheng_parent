package com.qingcheng.controller.goods;

import com.alibaba.dubbo.config.annotation.Reference;
import com.qingcheng.entity.PageResult;
import com.qingcheng.entity.Result;
import com.qingcheng.pojo.goods.Brand;
import com.qingcheng.service.goods.BrandService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * 品牌业务控制层
 */
@RestController
@RequestMapping("/brand")
public class BrandController {

    @Reference
    private BrandService brandService;

    /**
     * 查询所有品牌
     *
     * @return
     */
    @RequestMapping("/findAll")
    public List<Brand> findAll() {
        List<Brand> brandList = brandService.findAll();
        return brandList;
    }

    /**
     * 分页查询
     */
    @GetMapping("/findPage")
    public PageResult<Brand> findPage(int page, int size) {
        return brandService.findPage(page, size);
    }

    /**
     * 品牌条件查询
     */
    @RequestMapping("/findList")
    public List<Brand> findList(@RequestBody Map<String, Object> searchMap) {
        return brandService.findList(searchMap);
    }

    /**
     * 品牌条件+分页查询
     */
    @PostMapping("/findPage")
    public PageResult findPage(@RequestBody Map<String, Object> searchMap, int page, int size) {
        return brandService.findPage(searchMap, page, size);
    }

    /**
     * 根据id查询
     */
    @GetMapping("/findById")
    public Brand findById(Integer id) {
        return brandService.findById(id);
    }

    /**
     * 新增
     */
    @PostMapping("/add")
    public Result add(@RequestBody Brand brand) {
        brandService.add(brand);
        return new Result();
    }
    /**
     * 品牌修改
     */
    @PostMapping("/update")
    public Result update(@RequestBody Brand brand){
        brandService.update(brand);
        return new Result();
    }
    /**
     *
     * 品牌删除
     */
    @RequestMapping("/delete")
    public  Result delete(Integer id) {
        brandService.delete(id);
        return new Result();
    }
}
