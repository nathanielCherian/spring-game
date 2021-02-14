package AndrewFrq1;

public class StringStruct {
    public String field1;
    public String field2;
    public String field3;
    public int anInt1;
    public int anInt2;

    public String getField1() {
        return field1;
    }

    public void setField1(String field1) {
        this.field1 = field1;
    }

    public String getField2() {
        return field2;
    }

    public void setField2(String field2) {
        this.field2 = field2;
    }

    public String getField3() {
        return field3;
    }

    public void setField3(String field3) {
        this.field3 = field3;
    }

    public int getAnInt1() {
        return anInt1;
    }

    @Override
    public String toString() {
        return "StringStruct{" +
                "field1='" + field1 + '\'' +
                ", field2='" + field2 + '\'' +
                ", field3='" + field3 + '\'' +
                ", anInt1=" + anInt1 +
                ", anInt2=" + anInt2 +
                '}';
    }

    public void setAnInt1(int anInt1) {
        this.anInt1 = anInt1;
    }

    public int getAnInt2() {
        return anInt2;
    }

    public void setAnInt2(int anInt2) {
        this.anInt2 = anInt2;
    }
}
