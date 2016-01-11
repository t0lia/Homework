package serializationimplementation;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.DataInputStream;
import java.io.StringWriter;

import static org.junit.Assert.*;

/**
 * Created by t0lia on 11.01.16.
 */
public class ObjectWriterTest {
    private StringWriter sWriter;
    private ObjectWriter oWriter;

    @Before
    public void setUp() throws Exception {
        sWriter = new StringWriter();
        oWriter = new ObjectWriter(sWriter);
    }

    @After
    public void tearDown() throws Exception {
        sWriter.flush();
        sWriter.close();

        oWriter.flush();
        oWriter.close();
    }

    @Test
    public void testWriteObject_workFine() throws Exception {
        Assert.assertEquals(true,false);
    }

    @Test
    public void testWriteBoolean_workFine() throws Exception {

        oWriter.writeBoolean(true);
        String expected = "true";
        String actual = sWriter.toString();
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testWriteByte() throws Exception {

        oWriter.writeByte((byte) 123);
        String expected = "123";
        String actual = sWriter.toString();
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testWriteShort() throws Exception {

        oWriter.writeShort((short) 123);
        String expected = "123";
        String actual = sWriter.toString();
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testWriteChar() throws Exception {

        oWriter.writeChar('b');
        String expected = "b";
        String actual = sWriter.toString();
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testWriteInt() throws Exception {

        oWriter.writeInt(2_000_000_000);
        String expected = "2000000000";
        String actual = sWriter.toString();
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testWriteLong() throws Exception {

        oWriter.writeLong(777);
        String expected = "777";
        String actual = sWriter.toString();
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testWriteFloat() throws Exception {

        oWriter.writeFloat(12.3f);
        String expected = "12.3";
        String actual = sWriter.toString();
        Assert.assertEquals(expected, actual);
    }

    @Test
    public void testWriteDouble() throws Exception {

        oWriter.writeDouble( 1.23);
        String expected = "1.23";
        String actual = sWriter.toString();
        Assert.assertEquals(expected, actual);
    }
}