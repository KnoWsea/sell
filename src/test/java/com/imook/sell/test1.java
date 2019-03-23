package com.imook.sell;

import com.imook.ReferenceCountingGC;

public class test1 {
    // 请求的数量

        public Object instance = null;

        private static final int _1MB = 1024 * 1024;

        private byte[] bigSize = new byte[2 * _1MB];

        public static void main(String[] args) {
            ReferenceCountingGC objA = new ReferenceCountingGC();
            ReferenceCountingGC objB = new ReferenceCountingGC();
            objA.instance = objB;
            objB.instance = objA;

            System.gc();
        }
    }
