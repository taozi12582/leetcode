package tao;

public class BagProblem {
    public static int getMaxValue(int[] values, int weights[], int bag, int alreadyHave, int i) {
        if (alreadyHave > bag || i == values.length) {
            return 0;
        }
        return Math.max(
                getMaxValue(values, weights, bag, alreadyHave, i + 1),
                values[i] + getMaxValue(values, weights, bag, alreadyHave + weights[i], i + 1)
        );
    }
}
