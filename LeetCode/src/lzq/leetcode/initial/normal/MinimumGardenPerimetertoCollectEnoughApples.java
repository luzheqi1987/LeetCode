package lzq.leetcode.initial.normal;

public class MinimumGardenPerimetertoCollectEnoughApples {
    /**
     * In a garden represented as an infinite 2D grid, there is an apple tree planted at every integer coordinate. The apple tree planted at an integer coordinate (i, j) has |i| + |j| apples growing on it.
     * <p>
     * You will buy an axis-aligned square plot of land that is centered at (0, 0).
     * <p>
     * Given an integer neededApples, return the minimum perimeter of a plot such that at least neededApples apples are inside or on the perimeter of that plot.
     * <p>
     * The value of |x| is defined as:
     * <p>
     * x if x >= 0
     * -x if x < 0
     *
     * @param neededApples
     * @return
     */
    public long minimumPerimeter(long neededApples) {
        long startCircle = 1;
        long currentNum = 0;
        while (currentNum < neededApples) {
            //currentNum += 4 * (((3 * startCircle) * (startCircle + 1)) / 2) +
            //              4 * (((3 * startCircle) * (startCircle - 1)) / 2);
            currentNum += 12 * startCircle * startCircle;
            if (currentNum >= neededApples) {
                break;
            }
            startCircle++;
        }
        // return startCircle * 2 * 4;
        return startCircle << 3;
    }

    public long minimumPerimeter1(long neededApples) {
        long startCircle = 1;
        long currentNum = 0;
        while (currentNum < neededApples) {
            //currentNum += 4 * (((3 * startCircle) * (startCircle + 1)) / 2) +
            //              4 * (((3 * startCircle) * (startCircle - 1)) / 2);
            //currentNum = 4 * (((1 + (1 + startCircle)) * (startCircle + 1)) / 2 * startCircle +
            //        ((startCircle + 1) + (startCircle + 1) * (startCircle - 1)) * (startCircle - 1) / 2);
            currentNum = 4 * startCircle * startCircle * startCircle + 6 * startCircle * startCircle + 2 * startCircle;
            if (currentNum >= neededApples) {
                break;
            }
            startCircle++;
        }
        // return startCircle * 2 * 4;
        return startCircle << 3;
    }


    public static void main(String[] args) {
        MinimumGardenPerimetertoCollectEnoughApples hi = new MinimumGardenPerimetertoCollectEnoughApples();
        System.out.println(hi.minimumPerimeter1(1));
        System.out.println(hi.minimumPerimeter1(13));
        System.out.println(hi.minimumPerimeter1(1000000000L));
    }
}
