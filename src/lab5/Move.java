package lab5;

import java.util.Objects;

class Move {
    private String name;
    private int power;

    public Move(String name, int power) {
        this.name = name;
        this.power = power;
    }

    public String getName() {
        return name;
    }

    public int getPower() {
        return power;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }

        if (!(obj instanceof Move)) {
            return false;
        } else {
            Move m = (Move) obj;
            return m.getName().equals(this.getName()) && m.getPower() == this.getPower();
        }
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, power);
    }
}
