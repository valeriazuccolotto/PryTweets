/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.proyectotweetsfuncional.service;

import com.mycompany.proyectotweetsfuncional.model.Tweet;
import java.util.*;
import java.util.function.Supplier;
import java.io.*;

/**
 *
 * @author valer
 */

public class TweetLoader {
    public static Supplier<List<Tweet>> crearLectorTweets(String rutaArchivo) {
        return () -> {
            List<Tweet> tweets = new ArrayList<>();
            try (BufferedReader br = new BufferedReader(new FileReader(rutaArchivo))) {
                String linea;
                while ((linea = br.readLine()) != null) {
                    String[] partes = linea.split(",");
                    if (partes.length >= 4) {
                        tweets.add(new Tweet(partes[0], partes[1], partes[2], partes[3]));
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            return tweets;
        };
    }
}
