package lab5;

public class RestrictedWrhProduct extends WrhProduct{
        private int limit;
        public RestrictedWrhProduct(String pid, int qty, double price, int limit) {
            super(pid, qty, price);
            this.limit=limit;
        }
        public SalesProduct grabProduct(int qty){
            SalesProduct sp=super.grabProduct(qty);
            if(qty>this.limit) throw new IllegalArgumentException();
            return sp;
        }
}
