package com.neusoft.springbootsell.controller;

import com.neusoft.springbootsell.dataobject.ProductCategory;
import com.neusoft.springbootsell.dataobject.ProductInfo;
import com.neusoft.springbootsell.exception.SellException;
import com.neusoft.springbootsell.form.ProductForm;
import com.neusoft.springbootsell.services.CategoryService;
import com.neusoft.springbootsell.services.ProductServices;
import com.neusoft.springbootsell.utils.KeyUtil;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.querydsl.QPageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.List;
import java.util.Map;
@Controller
@RequestMapping("/seller/product")
public class SellerProductController {
    @Autowired
    ProductServices productServices;
    @Autowired
    CategoryService categoryService;
    @GetMapping("/list")
    public ModelAndView list(@RequestParam(value = "page", defaultValue = "1") Integer page,
                             @RequestParam(value = "size", defaultValue = "10")Integer size,
                             Map<String, Object> map){
        PageRequest pageRequest = new PageRequest(page - 1, size);
        Page<ProductInfo> productInfoPage = productServices.findAll(pageRequest);
        map.put("productInfoPage", productInfoPage);
        map.put("currrentPage",page);
        map.put("size",size);
        return new  ModelAndView("product/list", map);
    }
    @GetMapping("/index")
    public ModelAndView index(@RequestParam(value = "productId", required = false) String productId,
                              Map<String, Object> map){
        if(!StringUtils.isEmpty(productId)){
            // 修改
            ProductInfo productInfo = productServices.findOne(productId);
            map.put("productInfo", productInfo);
        }
        // 查询类目并且进行返回
        List<ProductCategory> categoryList = categoryService.findAll();
        map.put("categoryList", categoryList);
        return new ModelAndView("product/index");
    }
    @PostMapping("/save")
    public ModelAndView save(@Valid ProductForm form,
                             BindingResult bindingResult,
                             Map<String, Object> map){
        if (bindingResult.hasErrors()){
            // 返回错误页面
            map.put("msg", bindingResult.getFieldError().getDefaultMessage());
            map.put("url", "/seller/product/index");
            return new ModelAndView("common/error", map);
        }
        ProductInfo productInfo = new ProductInfo();
        try {
            //        productInfo.setProductName(form.getProductName());
            if (!StringUtils.isEmpty(form.getProductId())){
                // 有ProductId  修改
                productInfo = productServices.findOne(form.getProductId());

            }else {
                // 新增  生成一个id
                form.setProductId(KeyUtil.genUniqueKey());
            }

            BeanUtils.copyProperties(form, productInfo);
            productServices.save(productInfo);

        }catch (SellException exception){
            map.put("msg", exception.getMessage());
            map.put("url", "/seller/product/index");
            return new ModelAndView("common/error", map);
        }
        map.put("url", "/seller/product/list");
        return new ModelAndView("common/success", map);

    }

}



