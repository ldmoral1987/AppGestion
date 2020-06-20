package com.empresa.appinventario.util;

import java.util.Scanner;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

// Esta clase permite generar contraseñas encriptadas con BCrypt
// La base de datos de esta aplicación tiene almacenadas las
// contraseñas de los usuarios según BCrypt
public class SecurePasswordGenerator {
    public static void main(String[] args) {
    	Scanner scan = new Scanner(System.in);
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        
        // Se solicita una clave en texto plano
        System.out.print("Clave en texto plano: ");
        String rawPassword = scan.next();
        
        // Se encripta la contraseña
        String encodedPassword = encoder.encode(rawPassword);
        System.out.println("Clave encriptada: " + encodedPassword);
        scan.close();
    }
}
