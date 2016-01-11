package serializationimplementation;

import java.io.*;
import java.nio.file.Paths;

/**
 * This code demonstrate serialization/deserialization using File.
 */

public class Example2 {
    public static void main(String[] args) {

        // object to serialize
        Sample sampleBefore = new Sample();
        Sample sampleAfter = null;

        System.out.println("============ before serialization ============");
        System.out.println(sampleBefore.toString());

        try (ObjectWriter oWriter = new ObjectWriter(
                new FileWriter(Paths.get("tmp/class.txt").toFile()))) {

            // serialization
            oWriter.writeObject(sampleBefore);
            oWriter.flush();
        } catch (IOException e) {
            System.err.println("Somethings goes wrong!!!");
        }

        // deserialization
        try (ObjectReader oReader = new ObjectReader(
                new FileReader(Paths.get("tmp/class.txt").toFile()))) {

            sampleAfter = (Sample) oReader.readObject();
        } catch (IOException e) {
            System.err.println("Somethings goes wrong!!!");
        }

        System.out.println("============ after deserialization ===========");
        System.out.println(sampleAfter);
    }
}
