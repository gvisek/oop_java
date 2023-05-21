package lab5;

class WrhProduct {
    private String pid;
    private int qty;
    private double price;

    public WrhProduct(String pid, int qty, double price) {
        this.pid = pid;
        this.qty = qty;
        this.price = price;
    }

    public static class SalesProduct {
        private String pid;
        private int qty;
        private double price;

        protected SalesProduct(String pid, int qty, double price) {
            this.pid = pid;
            this.qty = qty;
            this.price = price;
        }

        public double getTotal() { return qty*price; }
    }

    public void restockProduct(int qty){
        if (qty>0) this.qty += qty;
    }

    private class SalesProductInstance extends SalesProduct {
        public SalesProductInstance(String pid, int qty, double price){
            super(pid, qty, price);
        }
    }

    public SalesProduct grabProduct(int qty) {
        if (qty <= this.qty){
            this.qty -= qty;
            return new SalesProductInstance(pid,qty,price);
        }
        return null;
    }


}
