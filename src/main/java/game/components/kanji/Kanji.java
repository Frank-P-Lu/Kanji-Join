package game.components.kanji;

import java.util.List;

public class Kanji extends Placeable{

    private List<Radical> radicals;
    private String character;

    public Kanji() {
    }

    public Kanji(String character) {
        this.character = character;
    }


    @Override
    public String toString() {
        if(this.character == null){
            return "";
        }
        return character;
    }
}
