package de.mpii.mph;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.io.IOException;
import java.util.Iterator;

import org.junit.Test;

public class SpotMinimalPerfectHashTest {

    @Test
    public void testMPH() throws IOException {
        final String[] spots = { "diego", "pisa", "paris", "napoleone", "lol" };
        Iterable<String> spotIterable = new Iterable<String>() {

            public Iterator<String> iterator() {
                return new Iterator<String>() {
                    private int current = -1;

                    public boolean hasNext() {
                        return current < spots.length - 1;
                    }

                    public String next() {
                        return spots[++current];
                    }

                };
            }
        };
        SpotMinimalPerfectHash mph = new SpotMinimalPerfectHash();
        mph.generateHash(spotIterable);
        int[] hashcodes = new int[spots.length];
        for (String s : spots) {
            int h = (int) mph.hash(s);
            System.out.println(s + "\t" + h);
            assertTrue(h >= 0 && h <= 4);
            hashcodes[h]++;
        }
        for (int i = 0; i < hashcodes.length; i++) {
            assertEquals(1, hashcodes[i]);
        }

    }
}
