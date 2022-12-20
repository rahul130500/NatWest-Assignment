package com.rps.Assignment.controller;
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockedStatic;
import org.mockito.Mockito;
import org.mockito.Mockito.*;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class HelperTest {
    Helper  helper = new Helper();
    @Test
    void CheckValidMove(){
        assertTrue(helper.CheckValidMove("ROCK"));
        assertTrue(helper.CheckValidMove("PAPER"));
        assertTrue(helper.CheckValidMove("SCISSOR"));
        assertFalse(helper.CheckValidMove("FAKE MOVE"));
    }

    @Test
    void TestGenerateComputerMove() throws Exception{
        List<String> possibleMoves = Arrays.asList("ROCK", "PAPER", "SCISSOR");
        String result = helper.GenerateComputerMove();
        assertTrue(possibleMoves.contains(result));
    }

    @Test
    void GetResultTest() throws Exception{
        assertEquals("Player wins", helper.GetResult("ROCK", "SCISSOR"));
        assertEquals("Player wins", helper.GetResult("PAPER", "ROCK"));
        assertEquals("Player wins", helper.GetResult("SCISSOR", "PAPER"));
        assertEquals("Computer wins", helper.GetResult("ROCK", "PAPER"));
        assertEquals("Computer wins", helper.GetResult("PAPER", "SCISSOR"));
        assertEquals("Computer wins", helper.GetResult("SCISSOR", "ROCK"));
        assertEquals("It is a tie", helper.GetResult("ROCK", "ROCK"));
        assertEquals("It is a tie", helper.GetResult("PAPER", "PAPER"));
        assertEquals("It is a tie", helper.GetResult("SCISSOR", "SCISSOR"));
    }

}

