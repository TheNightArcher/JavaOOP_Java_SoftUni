package stackOfStrings_05;

import java.util.ArrayList;
import java.util.List;

public class StackOfStrings {
    private List<String> data;
    private  int index;

    public StackOfStrings(){
        this.data = new ArrayList<>();
    }

    public void push(String element){
        this.data.add(element);
        index++;
    }

    public String pop(){
        return this.data.remove(this.index --);
    }

    public String peek(){
        return this.data.get(index);
    }

    public boolean isEmpty(){
        return data.isEmpty();
    }
}
