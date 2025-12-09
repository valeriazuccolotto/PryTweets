/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */


package com.mycompany.proyectotweetsfuncional.app;

import com.mycompany.proyectotweetsfuncional.model.Tweet;
import com.mycompany.proyectotweetsfuncional.service.*;
import com.mycompany.proyectotweetsfuncional.report.ReportGenerator;
import java.util.*;
import java.util.function.*;

/**
 *
 * @author valer
 */

public class Main {
    public static void main(String[] args) {
        Supplier<List<Tweet>> lector = TweetLoader.crearLectorTweets("data/tweets.csv");

        Runnable pipelinePrincipal = () -> {
            List<Tweet> tweets = lector.get();

            List<Tweet> tweetsLimpios = TweetAnalyticsService.transformarTweets(tweets,
                    TextTransformService.removeMentions()
                            .andThen(TextTransformService.removeHashtags()));

            double promedioPositivos = TweetAnalyticsService.calcularPromedioLongitud(tweetsLimpios, "positive");
            Map<String, Long> conteo = TweetAnalyticsService.contarTweetsPorSentimiento(tweetsLimpios);

            ReportGenerator.guardarTweetsLimpios(tweetsLimpios, "output/tweets_limpios.txt");
            ReportGenerator.guardarResumenEstadisticas(
                    "Promedio positivos: " + promedioPositivos + "\nConteo: " + conteo,
                    "output/resumen_estadisticas.txt");
        };

        pipelinePrincipal.run();
    }
}
