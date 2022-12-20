package com.rps.Assignment.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;

@RestController
@RequestMapping("/api")
public class AssignmentController {
    static Logger logger = LoggerFactory.getLogger(AssignmentController.class);
    @GetMapping("/play")
    public static String Game(@RequestParam("move")String playerMove){
        logger.info("Game Started!");
        playerMove = playerMove.toUpperCase();
        String ans =  Helper.PlayGame(playerMove, logger);
        logger.info(ans);
        logger.info("Game End!");
        return ans;
    }
}
