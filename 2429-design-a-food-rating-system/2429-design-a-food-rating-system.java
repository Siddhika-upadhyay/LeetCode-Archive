import java.util.*;

class FoodRatings {

    // Map from food name to its cuisine
    private Map<String, String> foodToCuisine;
    // Map from food name to its rating
    private Map<String, Integer> foodToRating;
    // Map from cuisine to sorted set of food entries
    private Map<String, TreeSet<FoodEntry>> cuisineToFoods;

    // Constructor
    public FoodRatings(String[] foods, String[] cuisines, int[] ratings) {
        foodToCuisine = new HashMap<>();
        foodToRating = new HashMap<>();
        cuisineToFoods = new HashMap<>();

        for (int i = 0; i < foods.length; i++) {
            String food = foods[i];
            String cuisine = cuisines[i];
            int rating = ratings[i];

            foodToCuisine.put(food, cuisine);
            foodToRating.put(food, rating);

            cuisineToFoods.putIfAbsent(cuisine, new TreeSet<>());
            cuisineToFoods.get(cuisine).add(new FoodEntry(food, rating));
        }
    }

    // Method to change the rating of a food
    public void changeRating(String food, int newRating) {
        String cuisine = foodToCuisine.get(food);
        int oldRating = foodToRating.get(food);

        TreeSet<FoodEntry> set = cuisineToFoods.get(cuisine);
        // Remove the old entry and add the new one
        set.remove(new FoodEntry(food, oldRating));
        set.add(new FoodEntry(food, newRating));

        foodToRating.put(food, newRating);
    }

    // Method to get the highest-rated food of a cuisine
    public String highestRated(String cuisine) {
        return cuisineToFoods.get(cuisine).first().food;
    }

    // Inner class to represent food entries
    private static class FoodEntry implements Comparable<FoodEntry> {
        String food;
        int rating;

        public FoodEntry(String food, int rating) {
            this.food = food;
            this.rating = rating;
        }

        @Override
        public int compareTo(FoodEntry other) {
            if (this.rating != other.rating) {
                return other.rating - this.rating; // Descending by rating
            }
            return this.food.compareTo(other.food); // Lexicographical order
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj) return true;
            if (obj == null || getClass() != obj.getClass()) return false;
            FoodEntry that = (FoodEntry) obj;
            return rating == that.rating && food.equals(that.food);
        }

        @Override
        public int hashCode() {
            return Objects.hash(food, rating);
        }
    }

    // Main method to test the functionality
    public static void main(String[] args) {
        String[] foods = {"kimchi", "miso", "sushi", "moussaka", "ramen", "bulgogi"};
        String[] cuisines = {"korean", "japanese", "japanese", "greek", "japanese", "korean"};
        int[] ratings = {9, 12, 8, 15, 14, 7};

        FoodRatings foodRatings = new FoodRatings(foods, cuisines, ratings);

        System.out.println(foodRatings.highestRated("korean"));   // Output: "kimchi"
        System.out.println(foodRatings.highestRated("japanese")); // Output: "ramen"

        foodRatings.changeRating("sushi", 16);
        System.out.println(foodRatings.highestRated("japanese")); // Output: "sushi"

        foodRatings.changeRating("ramen", 16);
        System.out.println(foodRatings.highestRated("japanese")); // Output: "ramen"
    }
}
