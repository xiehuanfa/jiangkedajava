package com.neusoft.view.impl;

import com.neusoft.dao.BusinessDao;
import com.neusoft.dao.FoodDao;
import com.neusoft.dao.impl.BusinessDaoImpl;
import com.neusoft.dao.impl.FoodDaoImpl;
import com.neusoft.domain.Business;
import com.neusoft.domain.Food;
import com.neusoft.view.FoodView;

import java.util.List;
import java.util.Scanner;

public class FoodViewImpl  implements FoodView {
    private Scanner input =  new Scanner(System.in);
    @Override
    public void showFoodList(Integer businessId) {
        FoodDao dao = new FoodDaoImpl();
        List<Food> list = dao.listFoodByBusinessId(businessId);
        System.out.println("食品编号"+"\t"+"食品名称"+"\t"+"食品备注"+"\t"+"食品价格"+"\t"+"商家编码");
        for (Food b :list){
            System.out.println(b.getFoodId() +"\t"+b.getFoodName()+"\t"+b.getFoodExplain()+"\t"+b.getFoodPrice()+"\t"+b.getBusinessId());
        }
    }

    @Override
    public void saveFood(Integer businessId) {
        FoodDao dao = new FoodDaoImpl();
        Food food = new Food();
        food.setBusinessId(businessId);
        System.out.println("请输入食品编号");
        food.setFoodId(input.nextInt());
        Food food2 = dao.getFoodById(food.getFoodId());
        if(food2 !=null){
            System.out.println("该食品编码已经存在了");
        }else {
            System.out.println("请输入食品名称");
            food.setFoodName(input.next());
            System.out.println("请输入食品备注");
            food.setFoodExplain(input.next());
            System.out.println("请输入食品价格");
            food.setFoodPrice(input.nextDouble());

            int ret = dao.saveFood(food);
            // 保存成功
            if (ret > 0) {
                System.out.println("新增成功");
            } else {
                System.out.println("新增失败");
            }
        }
    }

    @Override
    public void updateFood(Integer businessId) {
        FoodDao dao = new FoodDaoImpl();
        Food food = new Food();
        food.setBusinessId(businessId);
        System.out.println("请输入需要修改食品编号");
        food.setFoodId(input.nextInt());
        Food food2 = dao.getFoodById(food.getFoodId());
        if(food2==null){
            System.out.println("不存在该食品编码");
        }else {
            System.out.println("请输入新食品名称");
            food.setFoodName(input.next());
            System.out.println("请输入新食品备注");
            food.setFoodExplain(input.next());
            System.out.println("请输入新食品价格");
            food.setFoodPrice(input.nextDouble());

            int ret = dao.updateFood(food);
            // 保存成功
            if (ret > 0) {
                System.out.println("修改成功");
            } else {
                System.out.println("修改失败");
            }
        }
    }

    @Override
    public void removeFood(Integer businessId) {
        System.out.println("请输入需要删除食品编号");
        int FoodId = input.nextInt();
        FoodDao dao = new FoodDaoImpl();
        Food food = dao.getFoodById(FoodId);
        if(food==null){
            System.out.println("不存在该食品编码");
        }else {
            int ret = dao.removeFood(FoodId);
            // 保存成功
            if (ret > 0) {
                System.out.println("删除成功");
            } else {
                System.out.println("删除失败");
            }
        }
    }
}
