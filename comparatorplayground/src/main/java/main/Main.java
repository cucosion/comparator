package main;

import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;

public class Main {
    URL localJar;

    {
        try {
            localJar = new URL("C:/Users/Ion/.m2/repository/com/ing/ipa/comparator-implementation/1.0/comparator-implementation-1.0.jar");
            InputStream is = localJar.openStream();
            InputStream in = new DataInputStream(new BufferedInputStream(is));



            URLClassLoader cl = new URLClassLoader(new URL[]{localJar});
            Class<?> clazz = cl.loadClass("SomeClass"); // you now can load classes

        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
