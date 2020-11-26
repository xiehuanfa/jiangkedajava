package com.neusoft.dao.impl;

import com.neusoft.dao.FoodDao;
import com.neusoft.domain.Business;
import com.neusoft.domain.Food;
import com.neusoft.utils.JDBCUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class FoodDaoImpl implements FoodDao {
    Connection conn = null;
    PreparedStatement pst = null;
    ResultSet rs = null;
    @Override
    public List<Food> listFoodByBusinessId(Integer businessId) {
        ArrayList<Food> list = new ArrayList<>();
        StringBuffer sql = new StringBuffer("select * from food WHERE businessId="+businessId);

        try {
            conn = JDBCUtils.getConnection();
            pst = conn.prepareStatement(sql.toString());
            rs = pst.executeQuery();
            while (rs.next()){
                Food food = new Food();
                food.setBusinessId(rs.getInt("businessId"));
                food.setFoodId(rs.getInt("foodId"));
                food.setFoodName(rs.getString("foodName"));
                food.setFoodExplain(rs.getString("foodExplain"));
                food.setFoodPrice(rs.getDouble("foodPrice"));
                list.add(food);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return list;
    }

    @Override
    public int saveFood(Food food) {
        int res = 0;
        String sql = "insert into food (businessId,foodName , foodExplain, foodPrice,foodId) value (?,?,?,?,?)";
        try {
            conn =  JDBCUtils.getConnection();
            pst = conn.prepareStatement(sql);
            pst.setInt(1,food.getBusinessId());
            pst.setString(2,food.getFoodName());
            pst.setString(3,food.getFoodExplain());
            pst.setDouble(4,food.getFoodPrice());
            pst.setInt(5,food.getFoodId());
            res = pst.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return res;
    }

    @Override
    public int updateFood(Food food) {
        int res = 0;
        String sql = "update food set businessId=? ,foodName = ?, foodExplain =?, foodPrice=? where foodId = ?";
        try {
            conn =  JDBCUtils.getConnection();
            pst = conn.prepareStatement(sql);
            pst.setInt(1,food.getBusinessId());
            pst.setString(2,food.getFoodName());
            pst.setString(3,food.getFoodExplain());
            pst.setDouble(4,food.getFoodPrice());
            pst.setInt(5,food.getFoodId());
            res = pst.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return res;
    }

    @Override
    public int removeFood(Integer foodId) {
        int result = 0;
        String sql = "delete from food where foodId = ?";
        try {
            conn = JDBCUtils.getConnection();
            // 开启事务
            conn.setAutoCommit(false);
            pst = conn.prepareStatement(sql);
            pst.setInt(1, foodId);
            result = pst.executeUpdate();

            conn.commit();
        } catch (Exception e) {
            result = 0;
            try {
                conn.rollback();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
            e.printStackTrace();
        }finally {
            JDBCUtils.close(pst, conn);
        }

        return result;
    }

    @Override
    public Food getFoodById(Integer foodId) {
        Food food = null;
        String sql = "select * from food where foodId = ?";
        try {
            conn = JDBCUtils.getConnection();
            pst = conn.prepareStatement(sql);
            pst.setInt(1, foodId);
            rs = pst.executeQuery();
            while (rs.next()){
                food = new Food();
                food.setBusinessId(rs.getInt("businessId"));
                food.setFoodId(rs.getInt("foodId"));
                food.setFoodName(rs.getString("foodName"));
                food.setFoodExplain(rs.getString("foodExplain"));
                food.setFoodPrice(rs.getDouble("foodPrice"));

            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            JDBCUtils.close(rs, pst, conn);
        }
        return food;
    }
}