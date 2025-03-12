import java.io.*;
import java.util.*;

class Magnetic {
    double x;
    double m;

    public Magnetic(double x, double m) {
        this.x = x;
        this.m = m;
    }
}

public class Solution {
    static int n;
    static List<Magnetic> mglist;

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int cs = Integer.parseInt(br.readLine());
        for (int c = 1; c <= cs; c++) {
            n = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine());
            mglist = new ArrayList<>();

            int[] cord = new int[n];
            int[] mass = new int[n];
            for (int i = 0; i < n; i++) {
                cord[i] = Integer.parseInt(st.nextToken());
            }
            for (int i = 0; i < n; i++) {
                mass[i] = Integer.parseInt(st.nextToken());
            }
            for (int i = 0; i < n; i++) {
                mglist.add(new Magnetic(cord[i], mass[i]));
            }

            System.out.print("#" + c + " ");
            for (int i = 0; i < n - 1; i++) {
                double result = binarySearch(mglist.get(i).x, mglist.get(i + 1).x);
                System.out.printf("%.10f ", result);
            }
            System.out.println();
        }
    }

    static double binarySearch(double left, double right) {
        while (right - left > 1e-12) { // 부동소수정
            double mid = (left + right) / 2.0;
            double force = calculateForce(mid);

            if (force > 0) { // 힘이 양수면 왼쪽이 더 강하므로 오른쪽 이동
                left = mid;
            } else { // 힘이 음수면 오른쪽이 더 강하므로 왼쪽 이동
                right = mid;
            }
        }
        return left;
    }

    static double calculateForce(double pos) {
        double totalForce = 0;

        for (Magnetic m : mglist) {
            double distance = pos - m.x;
            totalForce += (m.m / (distance * Math.abs(distance))); // F = m / d^2
        }

        return totalForce;
    }
}
