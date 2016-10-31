package ua.yandex.collections;

import java.util.Comparator;

class MyCollections {

    // Reverses the order of the elements in the specified list
    public static void reverse(MyList list) {
        for (int i = 0; i < list.size() / 2; i++) {
            Object temp = list.get(i);
            list.set(i, list.get(list.size() - i - 1));
            list.set(list.size() - i - 1, temp);
        }
    }

    //Реализует рекурсивный поиск в отсортированном массиве методом бисекции.
    public static int binarySearch(MyList list, Object key) {
        //Если элемент найден, то возвращается его индекс. 
        //Если не найдет, то возвращается отрицательное значение, вычисляемое по следующей формуле: 
        //(-(insertion point) - 1), где insertion point - индекс того места в массиве, где должен был бы быть указанный элемент.
        int left = 0;
        int right = list.size() - 1;
        while (left <= right) {
            if (left == right) {
                if (list.get(right).equals(key)) {
                    return right;
                } else {
                    return -right - 1;
                }
            } else {
                int mid = (left + right) / 2;
                if ((Integer) key <= (Integer) list.get(mid) && ((Integer) list.get(left) <= (Integer) list.get(right))
                        || (((Integer) key >= (Integer) list.get(mid)) && ((Integer) list.get(left) >= (Integer) list.get(right)))) {
                    right = mid;
                } else {
                    left = mid + 1;
                }
            }
        }
        return -1;
    }

    //Реализует рекурсивный поиск в отсортированном массиве методом бисекции.
    public static int binarySearch(MyList list, Object key, Comparator cp) {
        {
            return binarySearch(list, key, 0, list.size(), cp);
        }
    }

    private static int binarySearch(MyList list, Object key, int left, int right, Comparator cp) {
        if (left == right) {
            if (list.get(right).equals(key)) {
                return right;
            } else {
                return -right - 1;
            }
        }
        int mid = left + (right - left) / 2;
        int comparision = cp.compare(list.get(mid), key);
        if (comparision == 0) {
            return mid;
        } else if (comparision > 0) {
            return binarySearch(list, key, left, mid, cp);
        } else {
            return binarySearch(list, key, mid + 1, right, cp);
        }
    }
}
