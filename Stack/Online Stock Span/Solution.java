class StockSpanner {
    private Stack<int[]> stack = new Stack<>();

    public StockSpanner() {
    }
    
    public int next(int price) { 
        int weight = 1;
        while(!stack.isEmpty() && stack.peek()[0] <= price) {
            weight += stack.pop()[1];
        }
        
        stack.add(new int[]{price, weight});
        return weight;
    }
}
