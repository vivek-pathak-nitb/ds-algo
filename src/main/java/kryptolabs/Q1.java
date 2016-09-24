package kryptolabs;

public class Q1 {

    public static void main(final String[] args) {
        if (args == null || args.length == 0) {
            return;
        }

        final int[] price = new int[args.length];
        for (int i = 0; i < args.length; i++) {
            price[i] = Integer.parseInt(args[i]);
        }

        System.out.println("Max profit is " + new Q1().getMaxProfit(price));
    }

    private int getMaxProfit(final int[] price) {
        if (price == null || price.length == 0) {
            return Integer.MAX_VALUE;
        }

        int min = price[0];
        int res = price[0];
        for (int i = 1; i < price.length; i++) {
            res = Math.max(res, price[i] - min);
            min = Math.min(min, price[i]);
        }

        return res;
    }
}
