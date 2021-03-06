package misc;

import java.io.Serializable;
import java.util.Objects;

public class Position implements Serializable {
    private final int x;

    private final int y;

    public Position(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public boolean equals (int x, int y) {
        return getX() == x && getY() == y;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Position position = (Position) o;
        return getX() == position.getX() &&
                getY() == position.getY();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getX(), getY());
    }

    public double getAverage () {
        return (x + y) / 2.0f;
    }

    @Override
    public String toString() {
        return (char)(97 + x) + "" + (y + 1);
    }

    public Position offsetX (int x) {
        return new Position(getX() + x, getY());
    }

    public Position offsetY (int y) {
        return new Position(getX(), getY() + y);
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public static Position fromChessPosition (String string) {
        string = string.toUpperCase();
        return new Position(((int) string.charAt(0)) - 65, Integer.parseInt(String.valueOf(string.charAt(1))) - 1);
    }

    public Position subtract (Position positionOnBoard) {
        return new Position(getX() - positionOnBoard.getX(), getY() - positionOnBoard.getY());
    }
}
