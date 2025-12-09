/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.proyectotweetsfuncional.service;

import com.mycompany.proyectotweetsfuncional.model.Tweet;
import java.util.function.Function;


/**
 *
 * @author valer
 */


public class TextTransformService {
    public static Function<Tweet, Tweet> toUpperCase() {
        return t -> new Tweet(t.getId(), t.getEntidad(), t.getSentimiento(), t.getTexto().toUpperCase());
    }

    public static Function<Tweet, Tweet> removeMentions() {
        return t -> new Tweet(t.getId(), t.getEntidad(), t.getSentimiento(), t.getTexto().replaceAll("@\\w+", ""));
    }

    public static Function<Tweet, Tweet> removeHashtags() {
        return t -> new Tweet(t.getId(), t.getEntidad(), t.getSentimiento(), t.getTexto().replaceAll("#\\w+", ""));
    }
}
