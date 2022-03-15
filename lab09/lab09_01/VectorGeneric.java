import java.util.Iterator;
import java.util.ListIterator;
import java.util.NoSuchElementException;

public class VectorGeneric<T> {
    private T[] vec;
    private int nElem;
    private final static int ALLOC = 50;
    private int dimVec = ALLOC;

    @SuppressWarnings("unchecked")
    public VectorGeneric() {
        vec = (T[]) new Object[dimVec];
        nElem = 0;
    }

    public boolean addElem(T elem) {
        if (elem == null)
            return false;
        ensureSpace();
        vec[nElem++] = elem;
        return true;
    }

    private void ensureSpace() {
        if (nElem>=dimVec) {
            dimVec += ALLOC;
            @SuppressWarnings("unchecked")
            T[] newArray = (T[]) new Object[dimVec];
            System.arraycopy(vec, 0, newArray, 0, nElem );
            vec = newArray;
        }
    }

    public boolean removeElem(T elem) {
        for (int i = 0; i < nElem; i++) {
            if (vec[i].equals(elem)) {
                if (nElem-i-1 > 0) // not last element
                    System.arraycopy(vec, i+1, vec, i, nElem-i-1 );
                vec[--nElem] = null; // libertar último objecto para o GC return true;
                return true;
        } }
        return false;
    }

    public int totalElem() {
        return nElem;
    }
    public T getElem(int i) {
        return (T) vec[i];
    }

    public java.util.Iterator<T> iterator() { return new VectorIterator<T>(); };

    private class VectorIterator<E> implements Iterator<E> {
        private int ind;

        VectorIterator() {
            this.ind = 0;
        }

        @Override
        public boolean hasNext() { return (ind < nElem); }

        @Override
        public E next() {
            if (hasNext()) {
                return (E) VectorGeneric.this.vec[ind++];
            } throw new NoSuchElementException("only " + nElem + " elements");
        }
    }

    public ListIterator<T> listIterator() {
        return new VectorListIterator<T>(0);
    }

    public ListIterator<T> listIterator(int indice) {
        return new VectorListIterator<T>(indice);
    }

    private class VectorListIterator<K> implements ListIterator<K> {
        private int ind;

        VectorListIterator(int ind) { this.ind = 0; }

        @Override
        public boolean hasNext() { return (ind < nElem); }

        @Override
        public K next() {
            if (hasNext()) {
                return (K) VectorGeneric.this.vec[ind++];
            } throw new NoSuchElementException("only " + nElem + " elements");
        }

        @Override
        public boolean hasPrevious() { return (ind > 0); }

        @Override
        public K previous() {
            if (hasNext()) {
                return (K) VectorGeneric.this.vec[ind--];
            } throw new NoSuchElementException("only " + nElem + " elements");
        }

        @Override
        public int nextIndex() { return ind++; }

        @Override
        public int previousIndex() { return ind--; }

        @Override
        public void remove() { throw new UnsupportedOperationException("Operation not supported!"); }

        @Override
        public void set(K k) { throw new UnsupportedOperationException("Operation not supported!"); }

        @Override
        public void add(K k) { throw new UnsupportedOperationException("Operation not supported!"); }
    }

}

