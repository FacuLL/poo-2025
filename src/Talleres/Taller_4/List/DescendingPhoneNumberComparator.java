package Talleres.Taller_4.List;

import java.util.Comparator;

public class DescendingPhoneNumberComparator implements Comparator<PhoneNumber> {

    @Override
    public int compare(PhoneNumber o1, PhoneNumber o2) {
        int result;
        if ((result = o1.getAreaCode() - o2.getAreaCode()) != 0) return result;
        if ((result = o1.getPrefix() - o2.getPrefix()) != 0) return result;
        if ((result = o1.getLineNumber() - o2.getLineNumber()) != 0) return result;
        return result;
    }
}
