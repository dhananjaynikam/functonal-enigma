package com.leetCode;

public class CompareVersionNumbers {

    public static void main(String args[]) {
        String version1 = "";
        String version2 = "";
        System.out.print(compareVersion(version1, version2));
        System.out.print(compareVersion2(version1, version2));
    }

    public static int compareVersion(String version1, String version2) {
        String[] v1 = version1.split("\\.");
        String[] v2 = version2.split("\\.");

        int i = 0;
        while (i < v1.length || i < v2.length) {

            if (i < v1.length && i < v2.length) {
                if (Integer.parseInt(v1[i]) < Integer.parseInt(v2[i])) {
                    return -1;
                } else if (Integer.parseInt(v1[i]) > Integer.parseInt(v2[i])) {
                    return 1;
                }
            } else if (i < v1.length) {
                if (Integer.parseInt(v1[i]) != 0) {
                    return 1;
                }
            } else if (i < v2.length) {
                if (Integer.parseInt(v2[i]) != 0) {
                    return -1;
                }
            }
            i++;
        }
        return 0;
    }

    public static int compareVersion2(String version1, String version2) {
        int s1 = 0;
        int s2 = 0;
        int i1 = getDotIndex(version1, 0);
        int i2 = getDotIndex(version2, 0);

        while (s1 < version1.length() || s2 < version2.length()) {
            int v1 = (s1 < version1.length()) ? Integer.parseInt(version1.substring(s1, i1)) : 0;
            int v2 = (s2 < version2.length()) ? Integer.parseInt(version2.substring(s2, i2)) : 0;

            if (v1 != v2) {
                return v1 < v2 ? -1 : 1;
            }

            s1 = i1 + 1;
            s2 = i2 + 1;
            i1 = getDotIndex(version1, s1 + 1);
            i2 = getDotIndex(version2, s2 + 1);
        }

        return 0;
    }


    private static int getDotIndex(String version, int startPos) {
        int i = version.indexOf('.', startPos);

        if (i < 0) {
            i = version.length();
        }

        return i;
    }
}