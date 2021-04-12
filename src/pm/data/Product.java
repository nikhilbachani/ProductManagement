/*
 * Copyright (C) 2021 nikhilbachani
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package pm.data;

import java.math.BigDecimal;
import static java.math.RoundingMode.HALF_UP;
import static pm.data.Rating.*;

/**
 * {@code Product} class represents properties and behaviors of a product in
 * Product Management System.
 * <br>
 * Each product has an id, a name, a price, and a rating
 * <br>
 * Each product can have a discount calculated based on a
 * {@link DISCOUNT_RATE discount rate}
 *
 * @version 1.0
 * @author nikhilbachani
 */
public class Product {

    /**
     * A constant that defines a {@link java.math.BigDecimal} value of the
     * discount rate
     * <br>
     * Discount rate is 10%
     */
    public static final BigDecimal DISCOUNT_RATE = BigDecimal.valueOf(0.1);

    private final int id;
    private final String name;
    private final BigDecimal price;
    private final Rating rating;

    public Product() {
        this(0, "No name", BigDecimal.ZERO);
    }

    public Product(int id, String name, BigDecimal price) {
        this(id, name, price, NOT_RATED);
    }

    public Product(int id, String name, BigDecimal price, Rating rating) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.rating = rating;
    }

    public int getId() {
        return id;
    }

//    public void setId(final int id) {
//        this.id = id;
//    }

    public String getName() {
        return name;
    }

//    public void setName(final String name) {
//        this.name = name;
//    }

    public BigDecimal getPrice() {
        return price;
    }

//    public void setPrice(final BigDecimal price) {
//        // price = BigDecimal.ONE;
//        this.price = price;
//    }

    public Rating getRating() {
        return rating;
    }

    /**
     * Calculates discount based on a product price and
     * {@link DISCOUNT_RATE discount rate}
     *
     * @return a {@link java.math.BigDecimal BigDecimal} value of the discount
     */
    public BigDecimal getDiscount() {
        return price.multiply(DISCOUNT_RATE).setScale(2, HALF_UP);
    }
    
    public Product applyRating(Rating newRating) {
        return new Product(id, name, price, newRating);
    }

}
