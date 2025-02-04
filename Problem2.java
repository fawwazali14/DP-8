class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        if (triangle == null || triangle.size() == 0) return 0;

        List<List<Integer>> dp = new ArrayList<>();
        dp.add(new ArrayList<>());
        dp.get(0).add(triangle.get(0).get(0));
        for (int i = 1; i <triangle.size(); i++) {
            dp.add(new ArrayList<>());

            for (int j= 0; j <triangle.get(i).size(); j++) {
                if (j==0) {
                    dp.get(i).add(dp.get(i - 1).get(0) +triangle.get(i).get(0));
                } else if (j ==triangle.get(i).size() - 1) {
                    dp.get(i).add(dp.get(i - 1).get(j - 1) +triangle.get(i).get(j));
                } else {

                    dp.get(i).add(Math.min(dp.get(i - 1).get(j - 1), dp.get(i - 1).get(j)) + triangle.get(i).get(j));
                }
            }
        }

        List<Integer> lastRow = dp.get(dp.size() - 1);
        int min = Integer.MAX_VALUE;
        for (int value :lastRow) {
            min = Math.min(min, value);
        }

        return min;
    }
}
