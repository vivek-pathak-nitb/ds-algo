package hackerrank;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;

/**
 * Created by vivek.pathak on 31/05/16.
 */
public class Rivigo1 {

    public static void main(String[] args) {
        final Scanner a = new Scanner(System.in);
        final List<List<Integer>> listOfList = new ArrayList<>();
        while (a.hasNextLine()) {
            final List<Integer> list = new ArrayList<>();
            final String input = a.nextLine();
            if (input.length() == 0) {
                break;
            }

            final String[] array = input.split(" ");
            for (final String number : array) {
                list.add(Integer.valueOf(number));
            }

            listOfList.add(list);
        }

        final List<Integer> result = new Rivigo1().mergeKSortedArray(listOfList);
        for (final int number : result) {
            System.out.print(number + " ");
        }
    }

    private class ListContainer implements Comparable<ListContainer> {
        private List<Integer> list;
        private int index;

        public ListContainer(final List<Integer> list,
                             final int index) {
            this.list = list;
            this.index = index;
        }

        @Override
        public int compareTo(final ListContainer object) {
            return this.list.get(this.index) - object.list.get(object.index);
        }
    }

    private List<Integer> mergeKSortedArray(final List<List<Integer>> listOfList) {
        final PriorityQueue<ListContainer> priorityQueue = new PriorityQueue<>();

        for (List<Integer> aListOfList : listOfList) {
            priorityQueue.add(new ListContainer(aListOfList, 0));
        }

        final List<Integer> result = new ArrayList<>();

        while (!priorityQueue.isEmpty()) {
            final ListContainer ac = priorityQueue.poll();
            result.add(ac.list.get(ac.index));

            if (ac.index < ac.list.size() - 1) {
                priorityQueue.add(new ListContainer(ac.list, ac.index + 1));
            }
        }

        return result;
    }
}
