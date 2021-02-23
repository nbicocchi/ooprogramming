package org.nbicocchi.io.exercises.trains;

import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;

public class TrainExpress extends Train {
    /**
     *
     */
    private static final long serialVersionUID = 1L;
    protected int restaurantPlaces;

    public TrainExpress(Station start, Station end, String starttime, String endtime, int km, int places) {
        super(start, end, starttime, endtime, km, places);
        this.restaurantPlaces = 50;
    }

    @Override
    public float getMaxMoney() {
        return (places * priceKmExpress + restaurantPlaces * priceKmRestaurant) * km;
    }

    @Override
    public String toString() {
        return super.toString() + this.getRestaurantPlaces() + ",";
    }

    public int getRestaurantPlaces() {
        return restaurantPlaces;
    }

    public void setRestaurantPlaces(int restaurantPlaces) {
        this.restaurantPlaces = restaurantPlaces;
    }

    @Override
    public byte[] toByteArray() throws IOException {
        // Here trains build a byte-oriented representation of themselves
        ByteArrayOutputStream byteArray = new ByteArrayOutputStream();
        DataOutputStream out = new DataOutputStream(byteArray);

        out.write(super.toByteArray());
        out.writeInt(getRestaurantPlaces());
        return byteArray.toByteArray();
    }

}
