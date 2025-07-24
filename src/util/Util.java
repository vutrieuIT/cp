package util;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Util {
    static boolean ngTo(int n) {

        if (n <= 1) return false;
        for (int i = 2; i <= (int) Math.sqrt(n); i++) {
            if (n % i == 0) return false;
        }
        return true;
    }

    static boolean chinhPhuong(long x) {
        long can2x = (long) Math.sqrt(x);
        return Math.pow(can2x, 2) == x;
    }

    static long gcd(long a, long b) {
        while (b != 0) {
            long temp = b;
            b = a % b;
            a = temp;
        }
        return Math.abs(a);
    }

    static long lcm(long a, long b) {
        return a * b / gcd(a, b);
    }

    static class Pair<T> {
        public T a;
        public T b;

        public Pair(T a, T b) {
            this.a = a;
            this.b = b;
        }

        @Override
        public String toString() {
            return "Pair{" +
                "a=" + a +
                ", b=" + b +
                '}';
        }
    }

    static class Triple<T extends Comparable<T>> {
        public T first;
        public T second;
        public T third;

        public Triple(T first, T second, T third) {
            this.first = first;
            this.second = second;
            this.third = third;
        }

        // So sánh tăng dần: so sánh theo first, rồi second, rồi third
        public static <T extends Comparable<T>> Comparator<Triple<T>> sortAsc() {
            return Comparator.comparing((Triple<T> o) -> o.first)
                .thenComparing(o -> o.second)
                .thenComparing(o -> o.third);
        }

        // So sánh giảm dần: đảo chiều của so sánh tăng dần
        public static <T extends Comparable<T>> Comparator<Triple<T>> sortDesc() {
            return (o1, o2) -> {
                int cmp = o2.first.compareTo(o1.first);
                if (cmp != 0) return cmp;

                cmp = o2.second.compareTo(o1.second);
                if (cmp != 0) return cmp;

                return o2.third.compareTo(o1.third);
            };
        }
    }

    static List<Integer> sangNgto() {
        List<Boolean> isPrime = new ArrayList<>(Collections.nCopies(100_001, true));
        List<Integer> prime = new ArrayList<>();
        for (int i = 3; i <= 100_000; i++) {
            if (isPrime.get(i)) {
                prime.add(i);
                for (int j = i + i; j <= 100_000; j += i) {
                    isPrime.set(i, false);
                }
            }
        }
        return prime;
    }

    static int lowerBound(List<Integer> arr, int value) {
        int l = 0;
        int r = arr.size(); // chú ý: r = arr.size(), không phải arr.size() - 1
        while (l < r) {
            int mid = l + (r - l) / 2;
            if (arr.get(mid) < value) {
                l = mid + 1;
            } else {
                r = mid;
            }
        }
        return l; // vị trí đầu tiên có arr[i] >= value
    }

    static int upperBound(List<Integer> arr, int value) {
        int l = 0;
        int r = arr.size();
        while (l < r) {
            int mid = l + (r - l) / 2;
            if (arr.get(mid) <= value) {
                l = mid + 1;
            } else {
                r = mid;
            }
        }
        return l; // vị trí đầu tiên mà arr[i] > value
    }

}
