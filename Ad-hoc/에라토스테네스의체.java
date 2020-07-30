

class Solution {
    public int solution(int n) {
		boolean[] all = new boolean[n+1];
		for (int i=2; i<=n; i++) {
			all[i] = true;
		}
        
        int root = (int)Math.sqrt(n);
        for (int i=2; i<=root; i++) {
            if (!all[i]) {
                continue;
            }
            for (int j=i; j*i <= n; j++) {
                all[i*j] = false;   
            }
        }
        
        int primeNumber = 0;
        for (int i=2; i<all.length; i++) {
            if (all[i]) {
                primeNumber++;
            }
        }

		return primeNumber;
	}
}
