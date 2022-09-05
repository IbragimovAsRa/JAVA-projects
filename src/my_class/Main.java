package my_class;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Main {
    public static void main(String[] args) {
        while(true) {
            try (ServerSocket serverSocket = new ServerSocket(8080)) {
                System.out.println("Server started on the port 8080\n");
                Socket socket = serverSocket.accept();
                System.out.println("New client connecting\n");

                try (BufferedReader input = new BufferedReader(
                        new InputStreamReader(
                                socket.getInputStream(), StandardCharsets.UTF_8));
                     PrintWriter output = new PrintWriter(socket.getOutputStream())) {

                    while (!input.ready()) ;

                    String firstLine = input.readLine();
                    String[] parts = firstLine.split(" ");
                    System.out.println(firstLine);

                    while (input.ready()) {
                        System.out.println(input.readLine());
                    }

                    Path path = Paths.get(".", parts[1]);
                    if(!Files.exists(path)) {
                        output.println("HTTP/1.1 200 OK");
                        output.println("HTTP/1.1 200 OK");
                        output.println("Content-Type: text/html; charset=utf-8");
                        output.println();
                        output.println("<h1>File not found</h1>");
                        output.flush();
                        continue;
                    }




                    output.println("HTTP/1.1 200 OK");
                    output.println("Content-Type: text/html; charset=utf-8");
                    output.println();
                    Files.newBufferedReader(path).transferTo(output);

                } catch (IOException e) {
                    e.printStackTrace();
                }

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
