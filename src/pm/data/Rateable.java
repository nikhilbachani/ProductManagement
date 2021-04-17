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

/**
 * @version 1.0
 * @author nikhilbachani
 */
@FunctionalInterface
public interface Rateable<T> {

    public static final Rating DEFAULT_RATING = Rating.NOT_RATED;

    public abstract T applyRating(Rating rating);

    public default T applyRating(int rating) {
        return applyRating(Rateable.convert(rating));
    }

    public default Rating getRating() {
        return DEFAULT_RATING;
    }

    public static Rating convert(int stars) {
        return (stars >= 0 && stars <= 5)
                ? Rating.values()[stars] : DEFAULT_RATING;
    }
}