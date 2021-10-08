public class CharacterValue {

    private Character key;

    private String value;

    private int index;

    public CharacterValue(Character key, String value) {
        this.key = key;
        this.value = value;
    }

    public Character getKey() {
        return key;
    }

    public void setKey(Character key) {
        this.key = key;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    @Override
    public String toString() {
        return "CharacterValue{" +
                "key=" + key +
                ", value='" + value + "'" +
                '}';
    }
}
