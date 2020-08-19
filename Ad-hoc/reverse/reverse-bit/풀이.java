public class Solution {
    public int reverseBits(int n) {
        int ret = 0;
        for (int i=0; i<32; i++) {
            ret = ret << 1;
            ret = ret | (n & 1);
            n = n >> 1;
        }
        return ret;
    }
}
