package com.adaming.myapp;

import com.adaming.myapp.service.IService;
import com.adaming.myapp.service.ServiceImpl;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Hello World!" );
        IService service = new ServiceImpl();
        System.out.println(service.generateKey(5));
    }
}
