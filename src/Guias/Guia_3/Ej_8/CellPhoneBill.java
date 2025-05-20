package Guias.Guia_3.Ej_8;

import java.util.Arrays;

public class CellPhoneBill {

    private String number;
    protected Call[] calls;
    protected int callsIndex;
    private FriendsPromotion friendsPromotion;
    private String[] friends;

    private static final int DEFAULT_SIZE = 10;

    CellPhoneBill(String number, FriendsPromotion friendsPromotion) {
        this.number = number;
        this.calls = new Call[DEFAULT_SIZE];
        this.friendsPromotion = friendsPromotion;
        this.friends = new String[friendsPromotion.getFriendsLimit()];
    }

    public void registerCall(String toNumber, int duration) {
        addCall(new Call(number, toNumber, duration));
    }

    private void addCall(Call call) {
        if(callsIndex == calls.length) {
            resize();
        }
        calls[callsIndex++] = call;
    }

    public double processBill() {
        double total = 0;
        for (int i = 0; i < callsIndex; i++) {
            total += calls[i].getCost();
        }
        return total;
    }

    private void resize() {
        calls = Arrays.copyOf(calls, calls.length + DEFAULT_SIZE);
    }

    public void setFriendsPromotion(FriendsPromotion friendsPromotion) {
        this.friendsPromotion = friendsPromotion;
    }

    public void addFriend() {

    }
}

