package org.example;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class Main {
    private static final String SUBJECTS_FILE_NAME = "src/main/resources/subjects.csv";
    private static final String STUDENTS_FILE_NAME = "src/main/resources/students.csv";
    private static HashMap<String, Float> subjects = new HashMap<String, Float>();
    private static HashMap<String,Float> namesAndNotes = new HashMap<>();
    private static HashMap<String,Float> namesAndCredits = new HashMap<>();
    private static String line;
    private static String[] values = new String[3];
    private static Float val;
    public static void main(String[] args)
    {
        try
        {
            processSubjects(SUBJECTS_FILE_NAME);
            processStudents(STUDENTS_FILE_NAME);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        calculateAndPrintTheMean();
    }
    private static BufferedReader readingFromFile(String path)
    {
        try
        {
            BufferedReader br = new BufferedReader(new FileReader(path));
            return br ;
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
    private static void processSubjects(String path) throws IOException
    {
        BufferedReader br = readingFromFile(path);
        while ((line = br.readLine()) != null)
        {
            values = line.split(";");
            values[0] = values[0].trim();
            val = Float.valueOf((values[1]));
            if( val == 0)
            {
                val = 1f;
            }
            subjects.put(values[0], val);
        }
    }
    private static void processStudents(String path) throws IOException
    {
       BufferedReader br = readingFromFile(path);
        while ((line = br.readLine()) != null)
        {
            values = line.split(";");
            values[0] = values[0].trim();
            values[1] = values[1].trim();
            Float credits = subjects.get(values[1]);
            val = (Float.valueOf(values[2])) * credits;

            if( namesAndNotes.containsKey(values[0]))
            {
                Float oldValue = namesAndNotes.get(values[0]);
                val += oldValue;
                namesAndNotes.replace(values[0], oldValue, val);

                oldValue = namesAndCredits.get(values[0]);
                namesAndCredits.replace(values[0], oldValue, oldValue + credits);
            }
            else
            {
                namesAndNotes.put(values[0], val);
                namesAndCredits.put(values[0], credits);
            }
        }
    }
    private static void calculateAndPrintTheMean()
    {
        for ( String name:namesAndNotes.keySet())
        {
            Float mean = namesAndNotes.get(name)/namesAndCredits.get(name);
            System.out.println(name + " has the mean " + mean + ".");
        }
    }
}