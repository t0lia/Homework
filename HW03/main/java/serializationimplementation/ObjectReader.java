package serializationimplementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.Reader;
import java.lang.reflect.Field;

/**
 * Reader for text deserialization
 */

public class ObjectReader extends Reader implements AutoCloseable {
    private BufferedReader in;

    ObjectReader(Reader reader) {
        in = new BufferedReader(reader);
    }

    @Override
    public int read(char[] cbuf, int off, int len) throws IOException {
        return in.read(cbuf, off, len);
    }

    @Override
    public void close() throws IOException {
        in.close();
    }

    public Object readObject() throws IOException {
        try {

            Object obj = Class.forName(in.readLine()).newInstance();
            for (Field field : obj.getClass().getDeclaredFields()) {
                field.setAccessible(true);

                String val = in.readLine().split(" = ")[1];

                switch (field.getType().getName()) {
                    case "byte":
                        field.set(obj, Byte.parseByte(val));
                        break;
                    case "char":
                        field.set(obj, val.charAt(0));
                        break;
                    case "short":
                        field.set(obj, Short.parseShort(val));
                        break;
                    case "int":
                        field.set(obj, Integer.parseInt(val));
                        break;
                    case "long":
                        field.set(obj, Long.parseLong(val));
                        break;
                    case "boolean":
                        field.set(obj, Boolean.parseBoolean(val));
                        break;
                    case "float":
                        field.set(obj, Float.parseFloat(val));
                        break;
                    case "double":
                        field.set(obj, Double.parseDouble(val));
                        break;
                }


            }
            return obj;
        } catch(ReflectiveOperationException e) {
            throw new IOException(e);
        }
    }


}
