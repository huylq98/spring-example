package com.viettel.vds.springexample;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

class SpringExampleApplicationTests {

    @Test
    void contextLoads() {
        int k = 2;
        int prices[] = {3, 2, 6, 5, 0, 3, 1, 2};
        int n = prices.length;
        if (n < 2) return;
        int ban[] = new int[n];
        ban[0] = 0;

        int mua[] = new int[n];
        mua[n - 1] = 0;

        int tempBan = prices[0];
        int tempMua = prices[n - 1];

        for (int i = 1; i < n; i++) {
            tempBan = Integer.min(tempBan, prices[i]);
            ban[i] = prices[i] - tempBan;
        }

        for (int i = n - 2; i >= 0; i--) {
            tempMua = Integer.max(prices[i], tempMua);
            int tmp = tempMua - prices[i];
            mua[i] = tmp;
        }


        int temp[] = new int[n];
        for (int i = 0; i < n; i++) temp[i] = 0;

        int ans = 0;
        for (int i = 0; i < k; i++) ans += mua[n - 1 - i];

        Assertions.assertEquals(2, ans);
    }

}
