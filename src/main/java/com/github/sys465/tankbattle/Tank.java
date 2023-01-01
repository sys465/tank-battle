package com.github.sys465.tankbattle;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Tank {

    private final String name;
    private int life;
    private final int damage;

    public void shootEnemy(Tank enemy) {
        System.out.println(name + " СТРЕЛЯЕТ ПО " + enemy.getName());
        enemy.reduceHealth(damage);
        System.out.println(enemy.getName() + " ПОЛУЧАЕТ " + damage + " УРОНА");
        System.out.println("У " + enemy.getName() + " ОСТАЛОСЬ " + enemy.getLife() + " ЖИЗНЕЙ");
    }

    public void reduceHealth(int damage) {
        this.life -= damage;
    }
}
