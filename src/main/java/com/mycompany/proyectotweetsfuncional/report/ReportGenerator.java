/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

package com.mycompany.proyectotweetsfuncional.report;

/**
 *
 * @author valer
 */

import com.mycompany.proyectotweetsfuncional.model.Tweet;
import java.io.*;
import java.util.List;

public class ReportGenerator {
    public static void guardarTweetsLimpios(List<Tweet> tweets, String rutaSalida) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(rutaSalida))) {
            for (Tweet t : tweets) {
                bw.write(t.toString());
                bw.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void guardarResumenEstadisticas(String resumen, String rutaSalida) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(rutaSalida))) {
            bw.write(resumen);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
