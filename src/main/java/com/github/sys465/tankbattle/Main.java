package com.github.sys465.tankbattle;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        List<Tank> tanks = new ArrayList<>();
        tanks.add(new Tank("Черчиль I", 68, 60,35,76,700,30,7));
        tanks.add(new Tank("Т-34", 118, 80,35,85,700,30,8));
        tanks.add(new Tank("Тигр I", 150, 85,38,88,750,20,7));
        tanks.add(new Tank("T-34-85", 101, 80,36,85,700,25,8));
        tanks.add(new Tank("Тигр II", 212, 100,32,88,800,25,7));
        tanks.add(new Tank("Матильда IV", 190, 75,30,80,750,20,6));
        tanks.add(new Tank("Т-72", 95, 90,45,85,850,18,5));
        tanks.add(new Tank("Лев", 250, 120,32,100,850,18,8));

        int battleCounter = 1;

        while (tanks.size() > 1) {
            for (int i = 1; i < tanks.size(); i += 2) {

                System.out.println("****************** БИТВА №" + battleCounter);
                battleCounter++;

                Tank tankA = tanks.get(i);
                Tank tankB = tanks.get(i - 1);

                while (tankA.getLife() > 0 && tankB.getLife() > 0) {
                    tankA.shootEnemy(tankB);
                    tankB.shootEnemy(tankA);
                }

                System.out.println("ПОБЕДИТЕЛЬ В ПАРЕ - "
                        + (tankA.getLife() > 0 ? tankA.getName() : (tankB.getLife() > 0 ? tankB.getName() : "НИКТО")));
            }

            deleteDestroyedTanks(tanks);
        }

        System.out.println("ПОБЕДИТЕЛЬ - " + tanks.get(0).getName());
    }

    private static void deleteDestroyedTanks(List<Tank> tanks) {
        int i = 0;
        while (i < tanks.size()) {
            if (tanks.get(i).getLife() <= 0) {
                tanks.remove(tanks.get(i));
            } else {
                i++;
            }
        }
    }
}