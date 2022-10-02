package tao;

import java.util.Arrays;
import java.util.Comparator;

public class BestArrange {
    public static class Program {
        public int startTime;
        public int endTime;

        public Program(int startTime, int endTime) {
            this.startTime = startTime;
            this.endTime = endTime;
        }
    }

    public static int bestArrange(Program[] programs, int timePoint) {
        if (programs == null || programs.length == 0) {
            return 0;
        }
        Arrays.sort(programs, Comparator.comparingInt(a -> a.endTime));
        int res = 0;
        for (int i = 0; i < programs.length; i++) {
            if (programs[i].startTime >= timePoint) {
                res++;
                timePoint = programs[i].endTime;
            }
        }
        return res;
    }
}
