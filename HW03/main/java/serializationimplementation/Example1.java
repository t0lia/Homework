package serializationimplementation;

import java.io.*;
import java.lang.reflect.Field;

/**
 * This code demonstrate serialization/deserialization using St out.
 */

public class Example1 {
    public static void main(String[] args) {
        try (StringWriter sWriter = new StringWriter();
             ObjectWriter oWriter = new ObjectWriter(sWriter)) {

            // object to serialize
            Sample sampleBefore = new Sample();

            // serialization
            oWriter.writeObject(sampleBefore);
            oWriter.flush();
            String serResult = sWriter.toString();

            // deserialization
            try (ObjectReader oReader = new ObjectReader(new StringReader(serResult))) {
                Sample sampleAfter = (Sample) oReader.readObject();

                System.out.println("============ before serialization ============");
                System.out.println(sampleBefore.toString());

                System.out.println("============ after serialization =============");
                System.out.println(serResult);

                System.out.println("============ after deserialization ===========");
                System.out.println(sampleAfter.toString());
            }
        } catch (IOException e) {
            System.err.println("Somethings goes wrong!!!");
        }

    }
}

