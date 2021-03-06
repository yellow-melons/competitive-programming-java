package src.Other;

import java.util.*;
import java.io.*;

public class graph1p3{

    static int adj[][] = new int[11][11];
    static int ans = 0, n;
    static boolean used[] = new boolean[11];

    static void dfs(int node, int min){
        //find all the cycles that has the minimum node min
        if (node > min) return;
        if (used[node]){
            if (node == min) ans++;
            return;
        }
        used[node] = true;
        for (int l = 0; l < n; ++l){
            if (adj[node][l] == 1){
                dfs(l, min);
            }
        }
        used[node] = false;
    }

    public static void main(String[] args){
        FastReader in = new FastReader();
        n = in.nextInt();
        for (int l = 0; l < n; ++l){
            for (int l2 = 0; l2 < n; ++l2){
                adj[l][l2] = in.nextInt();
            }
        }
        for (int l = 0; l < n; ++l){
            dfs(l, l);
        }
        System.out.println(ans);
    }

    static class FastReader {
        BufferedReader br;
        StringTokenizer st;

        public FastReader() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }

        String next() {
            while (st == null || !st.hasMoreElements()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }

        int nextInt() {
            return Integer.parseInt(next());
        }

        long nextLong() {
            return Long.parseLong(next());
        }

        double nextDouble() {
            return Double.parseDouble(next());
        }

        String nextLine() {
            String str = "";
            try {
                str = br.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return str;
        }
    }
}