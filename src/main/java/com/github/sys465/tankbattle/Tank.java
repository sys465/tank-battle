package com.github.sys465.tankbattle;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Tank {

    private final String name;
    private int life; //количество жизни танка
    private final int armor; //толщина брони, чем толще тем ниже скорость танка
    private final int tank_speed; //скорость танка
    private final int caliber; // калибер орудия, чем меньше калибр, тем тоньше броня
    private final int projectile_speed; //скорость снаряда, чем меньше калибр тем выше
    private final int scatter; //разброс орудия, чем выше калибр, тем выше разброс
    private int loading_time; //время перезарядки

    private int damage; //урон

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
