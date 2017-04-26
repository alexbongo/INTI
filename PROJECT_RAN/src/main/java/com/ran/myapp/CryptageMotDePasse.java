package com.ran.myapp;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class CryptageMotDePasse {

public static void main(String[] args) {
BCryptPasswordEncoder bc=new BCryptPasswordEncoder(12);
System.out.println(bc.encode("123"));

}

}