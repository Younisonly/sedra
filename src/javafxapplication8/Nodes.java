/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxapplication8;

/**
 *
 * @author younis
 */
public class Nodes<K extends Comparable<K>, V> {
    private K key;
    private V value;
    private Nodes<K, V> left;
    private Nodes<K, V> right;
    private int height;

    public Nodes(K key, V value) {
        this.key = key;
        this.value = value;
        this.left = null;
        this.right = null;
        this.height = 1;
    }

    public K getKey() {
        return key;
    }

    public void setKey(K key) {
        this.key = key;
    }

    public V getValue() {
        return value;
    }

    public void setValue(V value) {
        this.value = value;
    }

    public Nodes<K, V> getLeft() {
        return left;
    }

    public void setLeft(Nodes<K, V> left) {
        this.left = left;
    }

    public Nodes<K, V> getRight() {
        return right;
    }

    public void setRight(Nodes<K, V> right) {
        this.right = right;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }
}