import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Scanner;
import java.io.*;
import java.util.*;

public class Main {
    static BufferedReader br;
    static StringTokenizer st;
    static String YES = "YES";
    static String NO = "NO";

    static boolean multiTest = true;

    static void solve() throws IOException {

    }

    public static void main(String[] args) throws IOException {
        if (System.getProperty("ONLINE_JUDGE") == null) {
            br = new BufferedReader(new FileReader("input.txt"));
        } else {
            br = new BufferedReader(new InputStreamReader(System.in));
        }
        int t = 1;
        if (multiTest) {
            t = Integer.parseInt(br.readLine());
        }
        while (t-- > 0) {
            solve();
        }
    }
}
