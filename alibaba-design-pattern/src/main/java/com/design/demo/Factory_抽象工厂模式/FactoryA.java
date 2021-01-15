package com.design.demo.Factory_抽象工厂模式;

public class FactoryA extends Factory {
    @Override
    Product createProduct(Class c)  {
        Product product = null;
        try {
            product = (Product) Class.forName(c.getName()).newInstance();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return product;
    }

    public static void main(String[] args) {
        FactoryA factoryA = new FactoryA();

        factoryA.createProduct(ProductA.class);
    }
}
