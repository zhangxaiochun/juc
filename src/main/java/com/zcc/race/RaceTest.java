package com.zcc.race;

public class RaceTest implements Runnable{
    private static String winner;
    @Override
    public void run() {
        for (int i = 0; i <= 100; i++) {
            boolean flag = gameOver(i);
            if(flag == true){
                break;
            }
            System.out.println(Thread.currentThread().getName()+"跑了"+i+"步");
        }
    }
    public boolean gameOver(int sept){
        if(winner != null){
            return true;
        }else {
            if(sept >= 100){
                winner = Thread.currentThread().getName();
                System.out.println("winner is"+winner);
                return true;
            }
        }
           return false;
    }

    public static void main(String[] args) {
        RaceTest raceTest = new RaceTest();
        new Thread(raceTest,"兔子").start();
        new Thread(raceTest,"乌龟").start();
    }
}
