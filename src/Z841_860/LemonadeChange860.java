package Z841_860;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

public class LemonadeChange860 {

    /**
     * 开了一家饮料店，一瓶5元，一队顾客，给5、10、20元，判断最终能否找完钱
     *
     * @param bills
     * @return
     */
    public boolean lemonadeChange(int[] bills) {

        // 口袋里的钱
        List<Integer> packet = new ArrayList<>();

        for (int i = 0; i <= bills.length - 1; i++) {
            if (!usePacket(packet, bills[i])) {
                return false;
            }
        }

        return true;
    }

    private boolean usePacket(List<Integer> packet, int money) {
        if (money == 5) {
            packet.add(5);
        } else if (money == 10) {
            if (!packet.contains(5)) {
                return false;
            }
            removeOne(packet, 5);
            addOne(packet, 10);
        } else if (money == 20) {
            if (hasOne10One5(packet)) {
                removeOne(packet, 10);
                removeOne(packet, 5);
//                addOne(packet, 20);
            } else if (hasThree5(packet)) {
                removeOne(packet, 5);
                removeOne(packet, 5);
                removeOne(packet, 5);
//                addOne(packet, 20);
            } else {
                return false;
            }
        } else {
            return false;
        }
        return true;
    }

    private boolean hasThree5(List<Integer> list) {
        List<Integer> list5 = list.stream()
                .filter(a -> a == 5)
                .collect(Collectors.toList());
        return list5.size() >= 3;
    }

    private boolean hasOne10One5(List<Integer> list) {
        return list.contains(10) && list.contains(5);
    }

    private void addOne(List<Integer> list, int num) {
        list.add(num);
    }

    private void removeOne(List<Integer> list, int num) {
        for (Iterator iterator = list.iterator(); iterator.hasNext();) {
            Integer a = (Integer) iterator.next();
            if (a == num) {
                iterator.remove();
                return;
            }
        }
    }

}
