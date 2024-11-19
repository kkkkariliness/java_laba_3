package ru.permyakova.name_plus_human;

import java.util.Objects;

public class HumanWParent4_6_1_8 {
    private final Name1_8 name;
    private int height;
    private final HumanWParent4_6_1_8 father;

    public HumanWParent4_6_1_8(Name1_8 name, int height) {
        this(name, height, null);
    }

    public HumanWParent4_6_1_8(Name1_8 name, int height, HumanWParent4_6_1_8 father) {
        if (height <= 0) {
            throw new IllegalArgumentException("Рост должен быть положительным!");
        }
        if (height > 500) {
            throw new IllegalArgumentException("Рост должен быть не более 500!");
        }
        this.name = name;
        this.height = height;
        this.father = father;

        if ((Objects.equals(this.name.getLastName(), "") || Objects.equals(this.name.getLastName(), null)) &&
                (this.father != null && !Objects.equals(this.father.getName().getLastName(), "") && !Objects.equals(this.father.getName().getLastName(), null))) {
            this.name.setLastName(this.father.getName().getLastName());
        }
        if ((Objects.equals(this.name.getPatronymic(), "") || Objects.equals(this.name.getPatronymic(), null)) &&
                (this.father != null && !Objects.equals(this.father.getName().getName(), "") && !Objects.equals(this.father.getName().getName(), null))) {
            this.name.setPatronymic(this.father.getName().getName() + "ович");
        }
    }

    public Name1_8 getName() {
        return this.name;
    }
    public int getHeight() {
        return this.height;
    }
    public void setHeight(int height) {
        if (height <= 0) {
            throw new IllegalArgumentException("Рост должен быть положительным!");
        }
        if (height > 500) {
            throw new IllegalArgumentException("Рост должен быть не более 500!");
        }
        this.height = height;
    }
    public HumanWParent4_6_1_8 getFather() {
        return this.father;
    }

    public String toString(){
        StringBuilder result = new StringBuilder("Человек с именем \"" + this.name + "\" и ростом " + this.height);
        if (this.father != null) {
            result.append(" и отцом \"").append(this.father.getName()).append("\"");
        }
        return result.toString();
    }
}