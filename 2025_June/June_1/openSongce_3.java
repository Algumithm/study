package exam_0610;

import java.io.*;
import java.util.*;

public class Robot {

    public static class robot {
        int num;

        public robot(int num) {
            this.num = num;
        }
    }

    static int n, k;
    static int[] arr;
    static robot[] robot;
    static int num;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] strs = br.readLine().split(" ");
        n = Integer.parseInt(strs[0]);
        k = Integer.parseInt(strs[1]);
        arr = new int[2 * n];
        robot = new robot[2 * n];
        num = 1;
        strs = br.readLine().split(" ");
        for (int i = 0; i < 2 * n; i++) {
            arr[i] = Integer.parseInt(strs[i]);
        }

        int count = 1;
        int c_robot = 1;
        while (true) {
            step_1();
            robot[n - 1] = null;
            step_2();
            robot[n - 1] = null;
            step_3();
            if (step_4()) {
                break;
            }
            count++;
        }
        System.out.println(count);
    }

    static void step_1() {
        int lastArr = arr[2 * n - 1];
        robot lastRobot = robot[2 * n - 1];
        for (int i = 2 * n - 1; i > 0; i--) {
            arr[i] = arr[i - 1];
            robot[i] = robot[i - 1];
        }
        arr[0] = lastArr;
        robot[0] = lastRobot;
    }

    static void step_2() {
        for (int i = n - 2; i >= 0; i--) {
            if (robot[i] != null && robot[i + 1] == null && arr[i + 1] > 0) {
                robot[i + 1] = robot[i];
                robot[i] = null;
                arr[i + 1]--;
            }
        }
    }

    static void step_3() {
        if (arr[0] > 0 && robot[0] == null) {
            robot[0] = new robot(num++);
            arr[0]--;
        }
    }

    static boolean step_4() {
        int count = 0;
        for (int a : arr) {
            if (a == 0) count++;
        }
        return count >= k;
    }

    static void print() {
        for (int a : arr) {
            System.out.print(a + " ");
        }
        System.out.println();
    }
}
