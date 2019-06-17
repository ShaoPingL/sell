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

}
