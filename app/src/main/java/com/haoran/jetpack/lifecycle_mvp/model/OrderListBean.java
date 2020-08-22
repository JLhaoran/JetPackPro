package com.haoran.jetpack.lifecycle_mvp.model;

import java.util.List;

/**
 * Created by mac on 2019/3/14.
 */

public class OrderListBean {
    /**
     * code : 0
     * message : OK
     * data : [{"id":1,"thumb":"http://i9.qhimg.com/t017d891ca365ef60b5.jpg","title":"商品标题1","price":1,"time":"2017-1-1"},{"id":2,"thumb":"http://i9.qhimg.com/t017d891ca365ef60b5.jpg","title":"商品标题1","price":1,"time":"2017-1-1"},{"id":3,"thumb":"http://i9.qhimg.com/t017d891ca365ef60b5.jpg","title":"商品标题1","price":1,"time":"2017-1-1"}]
     */
    public int code;
    public String message;
    public List<DataBean> data;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public List<DataBean> getData() {
        return data;
    }

    public void setData(List<DataBean> data) {
        this.data = data;
    }

    public static class DataBean {
        /**
         * id : 1
         * thumb : http://i9.qhimg.com/t017d891ca365ef60b5.jpg
         * title : 商品标题1
         * price : 1.0
         * time : 2017-1-1
         */
        private int id;
        private String thumb;
        private String title;
        private double price;
        private String time;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getThumb() {
            return thumb;
        }

        public void setThumb(String thumb) {
            this.thumb = thumb;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public double getPrice() {
            return price;
        }

        public void setPrice(double price) {
            this.price = price;
        }

        public String getTime() {
            return time;
        }

        public void setTime(String time) {
            this.time = time;
        }
    }
}
