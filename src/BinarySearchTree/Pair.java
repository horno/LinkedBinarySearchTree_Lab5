public class Pair<S,T> {

    private final S first;  //key
    private final T second;    //value

    public Pair(S first, T second){
        this.first = first;
        this.second = second;
    }

    public S first(){
        return  this.first;
    }

    public T second(){
        return this.second;
    }

    @Override
    public String toString(){
        return "{"+first.toString()+", "+second.toString()+"}";
    }
}
