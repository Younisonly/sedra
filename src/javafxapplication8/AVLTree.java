/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxapplication8;

import java.util.ArrayList;
import java.util.List;
public class AVLTree<K extends Comparable<K>, V> {
    private Node<K, V> root;

    public void insert(K key, V value) {
        root = insert(root, key, value);
    }

    private Node<K, V> insert(Node<K, V> node, K key, V value) {
        if (node == null) {
            return new Node<>(key, value);
        }

        if (key.compareTo(node.key) < 0) {
            node.left = insert(node.left, key, value);
        } else if (key.compareTo(node.key) > 0) {
            node.right = insert(node.right, key, value);
        } else {
            node.value = value;
            return node;
        }

        // Update height and balance factor
        node.height = 1 + Math.max(height(node.left), height(node.right));
        int balanceFactor = getBalanceFactor(node);

        // Perform rotations if necessary
        if (balanceFactor > 1 && key.compareTo(node.left.key) < 0) {
            return rightRotate(node);
        }
        if (balanceFactor < -1 && key.compareTo(node.right.key) > 0) {
            return leftRotate(node);
        }
        if (balanceFactor > 1 && key.compareTo(node.left.key) > 0) {
            node.left = leftRotate(node.left);
            return rightRotate(node);
        }
        if (balanceFactor < -1 && key.compareTo(node.right.key) < 0) {
            node.right = rightRotate(node.right);
            return leftRotate(node);
        }

        return node;
    }

    public void delete(K key) {
        root = delete(root, key);
    }

    private Node<K, V> delete(Node<K, V> node, K key) {
        if (node == null) {
            return null;
        }

        if (key.compareTo(node.key) < 0) {
            node.left = delete(node.left, key);
        } else if (key.compareTo(node.key) > 0) {
            node.right = delete(node.right, key);
        } else {
            if (node.left == null || node.right == null) {
                Node<K, V> temp = node.left == null ? node.right : node.left;
                if (temp == null) {
                    return null;
                } else {
                    node = temp;
                }
            } else {
                Node<K, V> temp = minValueNode(node.right);
                node.key = temp.key;
                node.value = temp.value;
                node.right = delete(node.right, temp.key);
            }
        }

        if (node == null) {
            return null;
        }

        // Update height and balance factor
        node.height = 1 + Math.max(height(node.left), height(node.right));
        int balanceFactor = getBalanceFactor(node);

        // Perform rotations if necessary
        if (balanceFactor > 1 && getBalanceFactor(node.left) >= 0) {
            return rightRotate(node);
        }
        if (balanceFactor < -1 && getBalanceFactor(node.right) <= 0) {
            return leftRotate(node);
        }
        if (balanceFactor > 1 && getBalanceFactor(node.left) < 0) {
            node.left = leftRotate(node.left);
            return rightRotate(node);
        }
        if (balanceFactor < -1 && getBalanceFactor(node.right) > 0) {
            node.right = rightRotate(node.right);
            return leftRotate(node);
        }

        return node;
    }

    public List<V> search(K key) {
        List<V> result = new ArrayList<>();
        search(root, key, result);
        return result;
    }

    private void search(Node<K, V> node, K key, List<V> result) {
        if (node == null) {
            return;
        }

        if (key.compareTo(node.key) == 0) {
            result.add(node.value);
            search(node.left, key, result);
            search(node.right, key, result);
        } else if (key.compareTo(node.key) < 0) {
            search(node.left, key, result);
        } else {
            search(node.right, key, result);
        }
    }

    private Node<K, V> minValueNode(Node<K, V> node) {
        Node<K, V> current = node;
        while (current.left != null) {
            current = current.left;
        }
        return current;
    }

    private int height(Node<K, V> node) {
        if (node == null) {
            return 0;
        }
        return node.height;
    }

    private int getBalanceFactor(Node<K, V> node) {
        if (node == null) {
            return 0;
        }
        return height(node.left) - height(node.right);
    }

    private Node<K, V> rightRotate(Node<K, V> node) {
        Node<K, V> pivot = node.left;
        node.left = pivot.right;
        pivot.right = node;

        // Update heights
        node.height = 1 + Math.max(height(node.left), height(node.right));
        pivot.height = 1 + Math.max(height(pivot.left), height(pivot.right));

        return pivot;
    }

    private Node<K, V> leftRotate(Node<K, V> node) {
        Node<K, V> pivot = node.right;
        node.right = pivot.left;
        pivot.left = node;

        // Update heights
        node.height = 1 + Math.max(height(node.left), height(node.right));
        pivot.height = 1 + Math.max(height(pivot.left), height(pivot.right));

        return pivot;
    }

    private static class Node<K, V> {
        private K key;
        private V value;
        private Node<K, V> left;
        private Node<K, V> right;
        private int height;

        public Node(K key, V value) {
            this.key = key;
            this.value = value;
            this.height = 1;
        }
    }
}