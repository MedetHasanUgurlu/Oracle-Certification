package org.medron.security.pack;

public class HackerHarryFoodOrder extends FoodOrder{


    public HackerHarryFoodOrder(String item, int count) {
        super(item, count);
    }

    @Override
    public int getCount() {
        return super.getCount();
    }

    @Override
    public void setCount(int count) {
        super.setCount(0);
    }
}
