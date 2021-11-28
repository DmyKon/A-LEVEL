package ua.konstantynov.hw11_enum_junit;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)

public class KnightTest {

    Knight knight;
    @Mock
    Coordinate coordinate;

    @Before
    public void setUp() {
        coordinate = Mockito.mock(Coordinate.class);
        knight = new Knight(coordinate);
    }

    @Test
    public void testCorrectKnightsMove() {
        Mockito.when(coordinate.getCoordinate()).thenReturn(new int[]{1, 1, 2, 3});
        knight.setCoordinate(coordinate.getCoordinate());
        Assert.assertTrue(knight.knightCanMove());
        Mockito.when(coordinate.getCoordinate()).thenReturn(new int[]{2, 3, 4, 4});
        knight.setCoordinate(coordinate.getCoordinate());
        Assert.assertTrue(knight.knightCanMove());
    }

    @Test
    public void testIncorrectKnightsMove() {
        Mockito.when(coordinate.getCoordinate()).thenReturn(new int[]{5, 5, 6, 8});
        knight.setCoordinate(coordinate.getCoordinate());
        Assert.assertFalse(knight.knightCanMove());
        Mockito.when(coordinate.getCoordinate()).thenReturn(new int[]{1, 5, 6, 3});
        knight.setCoordinate(coordinate.getCoordinate());
        Assert.assertFalse(knight.knightCanMove());
    }

    @Test
    public void testOutOfBoardKnightsMove() {
        Mockito.when(coordinate.getCoordinate()).thenReturn(new int[]{1, 1, 9, 9});
        knight.setCoordinate(coordinate.getCoordinate());
        Assert.assertFalse(knight.knightCanMove());
        Mockito.when(coordinate.getCoordinate()).thenReturn(new int[]{10, 13, 0, -1});
        knight.setCoordinate(coordinate.getCoordinate());
        Assert.assertFalse(knight.knightCanMove());
    }

    @Test
    public void testNullInputKnightsMove() {
        Mockito.when(coordinate.getCoordinate()).thenReturn(null);
        knight.setCoordinate(coordinate.getCoordinate());
        Assert.assertFalse(knight.knightCanMove());
    }

}