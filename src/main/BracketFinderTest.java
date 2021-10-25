package main;

import static main.BracketFinder.bracketsClosed;
import static org.junit.Assert.*;

public class BracketFinderTest {

    @org.junit.Test
    public void bracketsClosedTrue() {

        boolean test = bracketsClosed("(()){{}}[[]]");

        assertTrue(test);
    }
    @org.junit.Test
    public void bracketsClosedFalse() {

        boolean test = bracketsClosed("}(()){{}}[[]]");

        assertFalse(test);
    }


}