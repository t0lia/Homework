package serializationimplementation;

/**
 * Sample file
 */

public class Sample {
    public int publicInt = 3;
    protected int protectedInt = 2;
    byte aByte = 10;
    short aShort = 111;
    int aInt = 1213;
    long aLong = 1225324234;
    float aFloat = 21432.1f;
    double aDouble = 12345.5678;
    char aChar = 'A';
    boolean aBoolean = true;
    private int privateInt = 1;

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("publicInt = " + publicInt);
        sb.append("\nprotectedInt = " + protectedInt);
        sb.append("\naByte = " + aByte);
        sb.append("\naShort = " + aShort);
        sb.append("\naInt = " + aInt);
        sb.append("\naLong = " + aLong);
        sb.append("\naFloat = " + aFloat);
        sb.append("\naDouble = " + aDouble);
        sb.append("\naChar = " + aChar);
        sb.append("\naBoolean = " + aBoolean);
        sb.append("\nprivateInt = " + privateInt);
        return sb.toString();
    }
}