/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.proyectotweetsfuncional.service;

import com.mycompany.proyectotweetsfuncional.model.Tweet;
import java.util.*;
import java.util.function.*;
import java.util.stream.*;


/**
 *
 * @author valer
 */

public class TweetAnalyticsService {

    public static List<Tweet> transformarTweets(List<Tweet> tweets, Function<Tweet, Tweet> transformacion) {
        return tweets.stream().map(transformacion).collect(Collectors.toList());
    }

    public static void procesarTweets(List<Tweet> tweets, Function<Tweet, Tweet> transformacion, Consumer<Tweet> accionFinal) {
        tweets.stream().map(transformacion).forEach(accionFinal);
    }

    public static double calcularPromedioLongitud(List<Tweet> tweets, String sentimiento) {
        return tweets.stream()
                     .filter(t -> t.getSentimiento().equalsIgnoreCase(sentimiento))
                     .mapToInt(t -> t.getTexto().length())
                     .average()
                     .orElse(0.0);
    }

    public static Map<String, Long> contarTweetsPorSentimiento(List<Tweet> tweets) {
        return tweets.stream()
                     .collect(Collectors.groupingBy(Tweet::getSentimiento, Collectors.counting()));
    }
}