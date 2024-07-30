package part;

import java.util.*;


public class CollectionSet {
    public static Set<Integer> returnHashSet(int[] arr) {
        Set<Integer> set = new HashSet<>();
        for (int i : arr) {
            set.add(i);
        }

        return set;
    }

    public static Set<Integer> returnLinkedTree(int[] arr) {
        Set<Integer> set = new LinkedHashSet<>();
        for (int i : arr) {
            set.add(i);
        }

        return set;
    }

    public static Set<Integer> returnTreeSet(int[] arr) {
        Set<Integer> set = new TreeSet<>();
        for (int i : arr) {
            set.add(i);
        }

        return set;
    }

    public static Integer firstNonDuplicate(int[] arr) {
        LinkedHashSet<Integer> linked_set = new LinkedHashSet<>();
//        HashSet<Integer> set = new HashSet<>();

        for (int i : arr) {
            if (linked_set.contains(i)) {
                linked_set.remove(i);
//                set.add(i);
            } else {
                linked_set.add(i);
            }
        }
        Integer value = null;
        Iterator<Integer> iterator = linked_set.iterator();
        if (iterator.hasNext()) value = iterator.next();
        return value;
    }

    public static boolean isSubset(Set<Integer> set_1, Set<Integer> set_2) {
        return set_2.containsAll(set_1);
    }


    //  generate random number form 1 to 10000
    public static int generateRandomNumber() {
        return (int) Math.floor(Math.random() * 10000 + 1);
    }

    public static void addList(Set<Integer> set) {
        long l = System.currentTimeMillis();
        for (int i = 0; i < 100000000; i++) {
            set.add(generateRandomNumber());
        }
        long l1 = System.currentTimeMillis();

        long timeout = l1 - l;
        System.out.println(set.getClass().getName() + "\t" + (timeout * 0.001) + " second");
    }

    public static void performance() {
        Set<Integer> hash = new HashSet<>();
        Set<Integer> linked = new LinkedHashSet<>();
        Set<Integer> tree = new TreeSet<>();

        addList(hash);
        addList(linked);
        addList(tree);
    }

    public static Set<Integer> intersection(List<Set<Integer>> sets) {
        if (sets == null || sets.isEmpty()) {
            return new HashSet<>();
        }

        Set<Integer> intersection = new HashSet<>(sets.get(0));

        for (Set<Integer> i : sets) {
            intersection.retainAll(i);
        }
        return intersection;
    }

    public static void removeElementsLessThan(TreeSet<Integer> treeSet, int threshold) {
        Iterator<Integer> iterator = treeSet.iterator();
        while (iterator.hasNext()) {
            if (iterator.next() < threshold) {
                iterator.remove();
            }
        }

    }

    public static void main(String[] args) {
        int[] arr = {2, 5, 1, 3, 3, 5, 1, 2};
        int[] a = {7, 2, 9, 1, 2, 9};

        Set<Integer> hash_set = returnHashSet(arr);
        Set<Integer> linked_hash_set = returnLinkedTree(arr);
        Set<Integer> tree_set = returnTreeSet(a);

        Integer i = firstNonDuplicate(arr);

        Set<Integer> set1 = new HashSet<>(Arrays.asList(1, 2, 3));
        Set<Integer> set2 = new HashSet<>(Arrays.asList(1, 2, 3, 4));
        Set<Integer> set3 = new HashSet<>(Set.of(4, 5, 3, 6, 7));
        boolean subset = isSubset(set1, set2);


        System.out.println(hash_set);
        System.out.println(linked_hash_set);
        System.out.println(tree_set);
        System.out.println(i);
        System.out.println(subset);
        System.out.println(set1 + " " + set2);

//        performance();


        List<Set<Integer>> sets = List.of(set1, set2, set3);
        Set<Integer> intersection = intersection(sets);
        System.out.println(sets);
        System.out.println(intersection);


        TreeSet<Integer> treeSet = new TreeSet<>(Arrays.asList(1, 2, 3, 4, 6, 5, 3, 6, 7));

        int threshold = 6;
        System.out.println(treeSet);
        removeElementsLessThan(treeSet, threshold);
        System.out.println(treeSet);

    }


}
