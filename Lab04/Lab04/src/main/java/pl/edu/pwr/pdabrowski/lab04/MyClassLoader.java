package pl.edu.pwr.pdabrowski.lab04;

import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public class MyClassLoader extends ClassLoader {
    private String directory;

    public MyClassLoader(String directory) {
        this.directory = directory;
    }

    @Override
    public Class<?> findClass(String name) throws ClassNotFoundException {
        byte[] bytes = loadClassBytes(name);
        if (bytes == null) {
            throw new ClassNotFoundException(name);
        } else {
            return defineClass(name, bytes, 0, bytes.length);
        }
    }

    private byte[] loadClassBytes(String name) {
        String fileName = directory + "/" + name.replace('.', '/') + ".class";
        try (InputStream inputStream = new FileInputStream(fileName)) {
            ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
            byte[] buffer = new byte[999999999];
            int length;
            while ((length = inputStream.read(buffer)) != -1) {
                outputStream.write(buffer, 0, length);
            }
            return outputStream.toByteArray();
        } catch (IOException e) {
            return null;
        }
    }
}
