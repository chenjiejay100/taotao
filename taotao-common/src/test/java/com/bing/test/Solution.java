package com.bing.test;

import java.util.*;

public class Solution {

    public static void main(String[] args) {

        ArrayList<Integer> _ids = new ArrayList<Integer>();
        ArrayList<Integer> _parents = new ArrayList<Integer>();
        ArrayList<Integer> _costs = new ArrayList<Integer>();

        Scanner in = new Scanner(System.in);
        String line = in.nextLine();

        while (line != null && !line.isEmpty()) {
            if (line.trim().equals("0")) break;
            String[] values = line.trim().split(" ");
            if (values.length != 3) {
                break;
            }
            _ids.add(Integer.parseInt(values[0]));
            _parents.add(Integer.parseInt(values[1]));
            _costs.add(Integer.parseInt(values[2]));
            line = in.nextLine();
        }
        int res = resolve(_ids, _parents, _costs);

        System.out.println(String.valueOf(res));
    }

    // n2
    public static int resolve(ArrayList<Integer> ids, ArrayList<Integer> parents, ArrayList<Integer> costs) {

        int sum = 0;
        int max = 0;
        for (int i = 0; i < ids.size(); i++) {
            sum += costs.get(i);
            for (int j = i; j < ids.size(); j++) {
                if (parents.get(j) == ids.get(i)) {
                    sum += costs.get(j);
                    if (sum > max) {
                        max = sum;
                        sum = 0;
                    }
                    break;
                }
            }
        }

        return max;
    }
}