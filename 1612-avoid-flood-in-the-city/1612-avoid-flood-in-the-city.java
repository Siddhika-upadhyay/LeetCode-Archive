class Solution {
    public int[] avoidFlood(int[] rains) {
        int n = rains.length;
        int[] result = new int[n];
        HashMap<Integer, Integer> fullLakes = new HashMap<>();
        TreeSet<Integer> dryDays = new TreeSet<>();

        for (int i = 0; i < n; i++) {
            if (rains[i] > 0) {
                result[i] = -1; 
                if (fullLakes.containsKey(rains[i])) {
                    Integer dryDay = dryDays.higher(fullLakes.get(rains[i]));
                    if (dryDay == null) return new int[]{};
                    result[dryDay] = rains[i]; 
                    dryDays.remove(dryDay);
                }
                fullLakes.put(rains[i], i);
            } else {
                dryDays.add(i);
                result[i] = 1;
            }
        }
        return result;
    }
}