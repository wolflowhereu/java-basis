package com.wolflowhereu.algorithm.leecode;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by fan on 16-4-16.
 */
public class LeeCode93 {

    List<String> result = new ArrayList<>();

    /**
     * https://leetcode.com/problems/restore-ip-addresses/
     *
     * @param s
     * @return
     */
    public List<String> restoreIpAddresses(String s) {
        if (s.length() > 12) return result;
        restoreIpAddresses(s, "", 3);
        return result;
    }

    public void restoreIpAddresses(String s, String ips, int k) {
        if (s.length() <= 0) return;
        if (k == 0) {
            if (s.length() > 1 && s.charAt(0) == '0') return;
            int ip = Integer.parseInt(s);
            if (ip < 256) {
                result.add(ips + s);
            }
            return;
        }

        for (int i = 1; i < 4 && i < s.length(); i++) {
            int ip = Integer.parseInt(s.substring(0, i));
            if (ip < 256) {
                restoreIpAddresses(s.substring(i), ips + ip + ".", k - 1);
            }
            if (ip == 0) break;
        }
    }

    @Test
    public void test() {
        System.out.println(restoreIpAddresses("25525511135"));
        System.out.println(restoreIpAddresses("0000"));
        System.out.println(restoreIpAddresses("279245587303"));
        System.out.println(restoreIpAddresses("010010"));
    }
}
