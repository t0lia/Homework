package serializationimplementation;

import java.io.IOException;
import java.io.Writer;
import java.lang.reflect.Field;

/**
 * Writer for text serialization
 */

public class ObjectWriter extends Writer implements AutoCloseable {

    private Writer out;

    ObjectWriter(Writer writer) {
        out = writer;
    }

    @Override
    public void write(char[] cbuf, int off, int len) throws IOException {
        out.write(cbuf, off, len);
    }

    @Override
    public void flush() throws IOException {
        out.flush();
    }

    @Override
    public void close() throws IOException {
        out.close();
    }

    public void writeObject(Object obj) throws IOException {
        write(obj.getClass().getName() + "\n");
        for (Field field : obj.getClass().getDeclaredFields()) {
            field.setAccessible(true);
            write(field.getName() + " = ");
            try {
                switch (field.getType().getName()) {
                    case "byte":
                        writeByte((byte) field.get(obj));
                        break;
                    case "char":
                        writeChar((char) field.get(obj));
                        break;
                    case "short":
                        writeShort((short) field.get(obj));
                        break;
                    case "int":
                        writeInt((int) field.get(obj));
                        break;
                    case "long":
                        writeLong((long) field.get(obj));
                        break;
                    case "boolean":
                        writeBoolean((boolean) field.get(obj));
                        break;
                    case "float":
                        writeFloat((float) field.get(obj));
                        break;
                    case "double":
                        writeDouble((double) field.get(obj));
                        break;
                }
            } catch (IllegalAccessException e) {
                throw new IOException(e);
            }
            write("\n");
        }

    }


    public void writeBoolean(boolean v) throws IOException {
        out.write(Boolean.toString(v));
    }

    public void writeByte(byte v) throws IOException {
        out.write(Byte.toString(v));
    }

    public void writeShort(short v) throws IOException {
        out.write(Short.toString(v));
    }

    public void writeChar(char v) throws IOException {
        out.write(Character.toString(v));
    }

    public void writeInt(int v) throws IOException {
        out.write(Integer.toString(v));
    }

    public void writeLong(long v) throws IOException {
        out.write(Long.toString(v));
    }

    public void writeFloat(float v) throws IOException {
        out.write(Float.toString(v));
    }

    public void writeDouble(double v) throws IOException {
        out.write(Double.toString(v));
    }


}
