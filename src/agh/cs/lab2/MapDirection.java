package agh.cs.lab2;

/**
 * Created by yurii on 10/21/16.
 */
enum MapDirection {
    North, East, South, West;

    public MapDirection next() {
        switch(this) {
            case North:
                return East;
            case West:
                return North;
            case East:
                return South;
            case South:
                return West;
        }
        return null;
    }

    public MapDirection previous(){
        switch(this){
            case North: return West;
            case South: return East;
            case West: return South;
            case East: return North;
            default: return null;
        }
    }

    public String toString(){
        switch(this) {
            case North: return "Północ";
            case South: return "Południe";
            case East: return "Wschód";
            case West: return "Zachód";
        }
        return null;
    }
}
