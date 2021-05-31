package com.example.covid_19;

import java.io.File;
import java.io.IOException;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Covid19Application {

	public static void main(String[] args) {
		SpringApplication.run(Covid19Application.class, args);

		// This code exists here only because it was asked in assignment.
		// We wouldn't store our logs inside a file otherwise.
		try {
			File myObj = new File("errorLog.txt");

			if (myObj.createNewFile()) {
				System.out.println("File created: " + myObj.getName());
			} else {
				System.out.println("File already exists.");
			}
		} catch (IOException e) {
			System.out.println("An error occurred.");
			e.printStackTrace();
		}
	}
}
