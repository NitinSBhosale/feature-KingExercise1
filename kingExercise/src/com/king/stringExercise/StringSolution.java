package com.king.stringExercise;

public class StringSolution {

    public static String restoreString(String s, int[] indices) {
        if (null != s && null != indices && s.length() == indices.length) {
            char[] c = s.toCharArray();
            char[] d = new char[c.length];
            for (int i = 0; i < indices.length; i++) {
                d[indices[i]] = c[i];
            }
            return new String(d);
        }
        return null;
    }

    public static void main(String[] args) {
        int[] indices = new int[]{3,1,4,2,0};
        System.out.println(StringSolution.restoreString("aiohn",indices));
    }
}
