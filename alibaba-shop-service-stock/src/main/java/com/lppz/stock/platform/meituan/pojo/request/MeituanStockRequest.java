package com.lppz.stock.platform.meituan.pojo.request;

import com.lppz.stock.platform.base.IgnoreSign;
import com.lppz.stock.platform.base.JacksonUtil;
import com.lppz.stock.platform.meituan.pojo.common.MeituanRequest;
import lombok.Data;

import java.util.List;
import java.util.Random;

@Data
public class MeituanStockRequest extends MeituanRequest {
    @IgnoreSign
    private static final long serialVersionUID = 8132494581283923480L;

    /**
     * string	是	25381	APP方门店id
     */

    private String app_poi_code;
    /**
     * string 是 [{"app_food_code": "food_0001", skus:[{"sku_id":"5"，
     * "stock":"10"},{...}]},{...}]
     * 菜品sku价格集合的json数据，菜品sku的库存。菜品stock不能为负数,也不能为小数,传"*"表示库存无限
     */
    private String food_data;
    @IgnoreSign
    private List<FoodData> food_data_list;

    public String getApp_poi_code() {
        return app_poi_code;
    }

    public void setApp_poi_code(String app_poi_code) {
        this.app_poi_code = app_poi_code;
    }

    public String getFood_data() {
        return food_data;
    }

    public void setFood_data(String food_data) {
        this.food_data = food_data;
    }

    public List<FoodData> getFood_data_list() {
        return food_data_list;
    }

    public void setFood_data_list(List<FoodData> food_data_list) {
        this.food_data = JacksonUtil.toJsonString(food_data_list);
        this.food_data_list = food_data_list;
    }


    public static class FoodData {
        private String app_food_code;
        private List<Skus> skus;

        public FoodData() {
            super();
        }

        public FoodData(String app_food_code, List<Skus> skus) {
            super();
            this.app_food_code = app_food_code;
            this.skus = skus;
        }

        public String getApp_food_code() {
            return app_food_code;
        }

        public void setApp_food_code(String app_food_code) {
            this.app_food_code = app_food_code;
        }

        public List<Skus> getSkus() {
            return skus;
        }

        public void setSkus(List<Skus> skus) {
            this.skus = skus;
        }

    }

    public static class Skus {
        private String sku_id;
        private Integer stock;

        public Skus() {
            super();
        }

        public Skus(String sku_id, Integer stock) {
            super();
            this.sku_id = sku_id;
            this.stock = stock;
        }

        public String getSku_id() {
            return sku_id;
        }

        public void setSku_id(String sku_id) {
            this.sku_id = sku_id;
        }

        public Integer getStock() {
            return stock;
        }

        public void setStock(Integer stock) {
            this.stock = stock;
        }


    }


    /**
     * 改动是 url 里的food 改成了 retail。
     * 对应美团平台接口。
     *
     * @return
     */
    @Override
    public String getMethodUrl() {
        return "/retail/sku/stock";
    }

    /**
     * 跟踪id
     *
     * @return
     */
    @Override
    public String getRequestId() {
        return System.currentTimeMillis() + "";
    }
}
