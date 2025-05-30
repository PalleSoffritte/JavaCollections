public class DoubleNode<T> {
        private DoubleNode<T> prev;
        private DoubleNode<T> next;
        private T c;
        
        public DoubleNode(){
                c = null;
                next = null;
                prev = null;
        }
        
       
        public DoubleNode(T ch){
                super();
                c = ch;
        }
        
        
        public DoubleNode(DoubleNode<T> p, T ch, DoubleNode<T> n){
                prev = p;
                next = n;
                c = ch;
        }
        
        public DoubleNode<T> getPrev() {
            return prev;
        }

        public void setPrev(DoubleNode<T> prev) {
            this.prev = prev;
        }

        public DoubleNode<T> getNext() {
            return next;
        }

        public void setNext(DoubleNode<T> next) {
            this.next = next;
        }

        public T getC() {
            return c;
        }

        public void setC(T c) {
            this.c = c;
        }
        
        @Override
    public String toString() {
        return "DoubleNode{" +
                "prev=" + (prev != null ? prev.c : "null") +
                ", c=" + c +
                ", next=" + (next != null ? next.c : "null") +
                '}';
    }
}