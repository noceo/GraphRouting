package src;

import java.util.Arrays;

public class MaxHeap {
  private int[] H;
  private int[] D;
  private int[] P;
  private int size;
  private int maxSize;

  public MaxHeap(int maxSize) {
    this.maxSize = maxSize;
    this.size = 0;
    this.H = new int[maxSize];
    this.D = new int[maxSize];
    this.P = new int[maxSize];
    Arrays.fill(this.H, -1);
    Arrays.fill(this.D, -1);
    Arrays.fill(this.P, -1);
  }

  public int max() {
    int max = D[H[0]];
    D[H[0]] = -1;
    P[H[0]] = -1;
    H[0] = H[size-1];
    size--;
    fixHeap(0);
    return max;
  }

  public void insert(int name, int value) {
    int pos = size;
    H[pos] = name;
    D[name] = value;
    P[name] = pos;
    while (getValueAt(pos) > getValueAt(parent(pos))) {
        swap(pos, parent(pos));
        pos = parent(pos);
    }
    size++;
  }

  public void delete(int name) {
    int pos = P[name];
    P[name] = -1;
    D[H[pos]] = -1;
    H[pos] = H[size-1];
    H[size-1] = -1;
    size--;
    if (getValueAt(pos) < getValueAt(parent(pos)) || pos == 0) {
      fixHeap(pos);
    }
    else {
      while (pos > 1 && getValueAt(pos) > getValueAt(parent(pos))) {
        swap(pos, parent(pos));
        pos = parent(pos);
      }
    }
  }

  public void print() {
    for (int i = 0; i < this.size / 2; i++) {
      System.out.print(
        " PARENT : " + getValueAt(i)
        + " LEFT CHILD : " + getValueAt(i * 2 + 1)
        + " RIGHT CHILD :" + getValueAt(i * 2 + 2));
      System.out.println();
    }
  }


  private int parent(int pos) { return (pos - 1) / 2; }

  private int leftChild(int pos) { return ((pos * 2) + 1); }

  private int rightChild(int pos) { return ((pos + 1) * 2); }

  private boolean isLeaf(int pos) {
    if (pos > ((size - 1) / 2) && pos <= (size - 1)) {
        return true;
    }
    return false;
  }

  private void swap(int leftPos, int rightPos) {
    int tmpH;
    int tmpP;
    tmpH = H[leftPos];
    tmpP = P[H[leftPos]];

    P[H[leftPos]] = P[H[rightPos]];
    H[leftPos] = H[rightPos];
    P[H[rightPos]] = tmpP;
    H[rightPos] = tmpH;
  }

  private void fixHeap(int i) {
    if (isLeaf(i))
        return;

    if (getValueAt(i) < getValueAt(leftChild(i)) || getValueAt(i) < getValueAt(rightChild(i))) {
      if (getValueAt(leftChild(i)) > getValueAt(rightChild(i))) {
          swap(i, leftChild(i));
          fixHeap(leftChild(i));
      }
      else {
        swap(i, rightChild(i));
        fixHeap(rightChild(i));
      }
    }
  }

  public int getMaxSize() {
    return this.maxSize;
  }

  public int getSize() {
    return this.size;
  }

  public int[] getH() {
    return this.H;
  }

  public int[] getD() {
    return this.D;
  }

  public int[] getP() {
    return this.P;
  }

  public int getValueAt(int i) {
    return i > H.length - 1 || H[i] == -1 ? -1 : D[H[i]];
  }
}