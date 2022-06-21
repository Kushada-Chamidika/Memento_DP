package designpatterns02day09mementopattern;

import java.util.ArrayList;
import java.util.Stack;

/**
 *
 * @author 1999k
 */
public class Test {

    public static void main(String[] args) {

        A_Originator ao = new A_Originator(1);
        ao.save();
        ao.setI(2);
        ao.save();
        ao.setI(3);
        ao.save();

        ao.undo();
        System.out.println(ao.getI());

        ao.undo();
        System.out.println(ao.getI());

        ao.undo();
        System.out.println(ao.getI());

        ao.undo();
        System.out.println(ao.getI());

    }

}

class A_Originator { // Originator

    // me class eke getter methods hadanne na meka thama ape object meken hadana object thama api undo karanna puluwan wenna hadanne meya thama main class eke meya thama Originator eka
    private int i;
    private final A_Caretaker a_Caretaker = new A_Caretaker();

    public A_Originator(int i) {
        this.i = i;
//        a_Caretaker.addMemento(new A_Memento(i));
    }

    public void setI(int i) {
        this.i = i;
//        a_Caretaker.addMemento(new A_Memento(i)); // me widiyata set weddima add wenna hadananth puluwan ethakota set karana hama ekama automa add wenawa mehema dmmoth aniwa constructo eketh dnna one naththam object hadana welawe pass karana eka add wenne nathi wena nisa
    }

    public int getI() {
        return i;
    }

    public void save() { // apita me widiyata wenama method ekk hadala one eka witharak save wenna e kiyanne api save eka call karoth witharak save wenan hadannath puluwan eka api requirement eka anauwa depend
        a_Caretaker.addMemento(new A_Memento(i));
    }

    public A_Originator undo() {
        A_Memento am = a_Caretaker.getMemento();
        if (am != null) {
            this.i = am.getI();
        }
        return this;
    }

}

class A_Memento { // Memento

    // me class eka originator eke copyakmai ekama wenasa wenne meke setter methods na namuth getter methods thinawa dekema thinne ekama data tika
    private final int i;

    public A_Memento(int i) {
        this.i = i;
    }

    public int getI() {
        return i;
    }

}

class A_Caretaker { // care taker

    //meya karanne memento eke list ekk thiyan inna eka meya gawa thama ethakota history eka thiyan inne
//    private final ArrayList<A_Memento> mementos = new ArrayList<>();
    private final Stack<A_Memento> mementos = new Stack<>();

    public void addMemento(A_Memento memento) {
        mementos.push(memento);
    }

    public A_Memento getMemento() {
        A_Memento am = null;
        if (mementos.size() > 0) {
//            am = mementos.remove(mementos.size() - 1);
            am = mementos.pop();
        } else {
            System.out.println("End");
        }
        return am;
    }

}
