package Talleres.Taller_4.List;

public class ArrayIntegerList implements List<Integer> {
    private Integer[] list = {};

    @Override
    public void add(Integer value) {
        Integer[] newList = new Integer[list.length + 1];
        for (int i = 0; i < list.length; i++) {
            newList[i] = list[i];
        }
        newList[list.length] = value;
        list = newList;
    }

    @Override
    public int contains(Integer value) {
        for (int i = 0; i < list.length; i++) {
            if (list[i].equals(value)) return i;
        }
        return -1;
    }

    @Override
    public boolean remove(int index) {
        if (index < 0 || index >= list.length) return false;
        Integer[] newList = new Integer[list.length - 1];
        for (int i = 0, newLength = 0; i < list.length; i++) {
            if (i != index) newList[newLength++] = list[i];
        }
        list = newList;
        return true;
    }

    @Override
    public boolean isEmpty() {
        return list.length == 0;
    }

    public static void main(String[] args) {
        List<Integer> integerList = new ArrayIntegerList();
        System.out.println(integerList.isEmpty()); // true
        integerList.add(1);
        integerList.add(4);
        integerList.add(3);
        integerList.add(5);
        System.out.println(integerList.contains(3)); // 2
        System.out.println(integerList.remove(2)); // true
        System.out.println(integerList.contains(3)); // -1
        System.out.println(integerList.removeElement(1)); // true
    }
}
