package br.com.sort;

import br.com.collection.NanoCollection;
import br.com.interfaces.AsyncCallback;

public class BubbleParallelSort<E> implements Runnable {

    NanoCollection list;

    public BubbleParallelSort(NanoCollection list) {
        this.list = list;

    }

    @Override
    public void run() {
        long start = System.currentTimeMillis();

        this.parallel_sort();

        long end = System.currentTimeMillis();

        float sec = (end - start) / 1000F;

        System.out.println("Thread: " + sec + " segundos");
    }

    public void parallel_sort() {

        Boolean isSorted = false;
        Integer index = 0;
        Integer swap_counter = 0;

        NanoCollection.Node current = null;
        NanoCollection.Node next = null;

        while (!isSorted) {

            if (index == list.size() - 1) {
                index = 0;
                swap_counter = 0;
            }

            if (current == null || index == 0) {
                current = list.get(index);
                next = current.next;
            } else {
                current = current.next;
                next = current.next;
            }

            if (current.compareTo(next) == 1) {
                swap_counter++;
                synchronized (current) {
                    list.swap(current, next);
                }
            }
            index++;

            if (swap_counter == 0 && index == list.size() - 1) isSorted = true;

        }
    }

    /*
    * Versão com problemas de otimização
    * */
    public void parallel_sort2() {
        Boolean isSorted = false;
        Integer index = 0;
        Integer swap_counter = 0;

        while (!isSorted) {

            if (index == list.size() - 1) {
                index = 0;
                swap_counter = 0;
            }

            if (list.get(index).compareTo(list.get(index + 1)) == 1) {
                synchronized (list) {
                    list.swap(list.get(index), list.get(index + 1));
                    swap_counter++;
                }
            }
            index++;

            if (swap_counter == 0 && index == list.size() - 1) isSorted = true;

        }
    }

    /*
    * Versão com array
    * */
    public void parallel_sort3() {

        Boolean isSorted = false;
        Integer index = 0;
        Integer swap_counter = 0;

        NanoCollection.Node current = null;
        NanoCollection.Node next = null;

        while (!isSorted) {

            if (index == list.size() - 1) {
                index = 0;
                swap_counter = 0;
            }

            if (current == null || index == 0) {
                current = list.get(index);
                next = current.next;
            } else {
                current = current.next;
                next = current.next;
            }

            if (current.compareTo(next) == 1) {
                swap_counter++;
                synchronized (list) {
                    list.swap(current, next);
                }
            }
            index++;

            if (swap_counter == 0 && index == list.size() - 1) isSorted = true;

        }
    }

    /*
    * Verção principal
    * */
    public void parallel_sort4() {

        Boolean isSorted = false;
        Integer index = 0;
        Integer swap_counter = 0;

        NanoCollection.Node current = null;
        NanoCollection.Node next = null;

        while (!isSorted) {

            if (index == list.size() - 1) {
                index = 0;
                swap_counter = 0;
            }

            if (current == null || index == 0) {
                current = list.get(index);
                next = current.next;
            } else {
                current = current.next;
                next = current.next;
            }

            if (current.compareTo(next) == 1) {
                swap_counter++;
                synchronized (list) {
                    list.swap(current, next);
                }
            }
            index++;

            if (swap_counter == 0 && index == list.size() - 1) isSorted = true;

        }
    }

    public void sort() {
        int n = list.size();
        for (int i = 0; i < n - 1; i++)
            for (int j = 0; j < n - i - 1; j++)
                if (list.get(j).compareTo(list.get(j + 1)) == 1) {
                    synchronized (list) {
                        list.swap(list.get(j), list.get(j + 1));
                    }
                }
    }

}

