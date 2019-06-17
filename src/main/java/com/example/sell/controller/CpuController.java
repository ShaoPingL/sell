package com.example.sell.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Author: ShaoPing
 * @Data:2019\6\17 0017 16:39
 */
@Controller
@RequestMapping("/cpu")
public class CpuController {

    private int a = 0;

    /**
     * 死循环
     */
    @GetMapping("/loop")
    public void loop(){
        while (true){
            a++;
        }
    }

    /**
     * 死锁
     */
    Object lock1 = new Object();
    Object lock2 = new Object();
    @GetMapping("/deadlock")
    public void deadlock(){
        new Thread(()->{
            synchronized (lock1){
                try{
                    Thread.sleep(1000);
                }catch (Exception e){}
                synchronized (lock2){
                    System.out.println("thread1 over");
                }
            }
        }).start();

        new Thread(()->{
            synchronized (lock2){
                try{
                    Thread.sleep(1000);
                }catch (Exception e){}
                synchronized (lock1){
                    System.out.println("thread2 over");
                }
            }
        }).start();
    }



}
