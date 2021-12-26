package com.example;

import com.example.controllers.GeneratePDF;
import com.example.entities.Student;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {


        Scanner sc = new Scanner(System.in);
        StringBuilder SB = new StringBuilder();
        GeneratePDF generatePDF = new GeneratePDF();

        ArrayList<Student> students = new ArrayList<>();

        Student student1 = new Student("Antony", "México", "Cozumel", "8938494", "antony@gmail.com", true, "antony.jpg", "antony.pdf", Student.Status_face_to_face.REMOTO);
        Student student2 = new Student("Juan", "Argentina", "Buenos Aires", "938494", "juan@gmail.com", true, "juan.jpg", "juan.pdf", Student.Status_face_to_face.MIXTO);
        Student student3 = new Student("Pedro", "España", "Barcelona", "839494", "pedro@gmail.com", false, "pedro.jpg", "pedro.pdf", Student.Status_face_to_face.PRESENCIAL);
        Student student4 = new Student("Ramon", "Chile", "Santiago", "773348", "ramon@gmail.com", true, "ramon.jpg", "ramon.pdf", Student.Status_face_to_face.REMOTO);
        Student student5 = new Student("Angel", "España", "Madrid", "98493", "angel@gmail.com", false, "angel.jpg", "angel.pdf", Student.Status_face_to_face.REMOTO);
        Student student6 = new Student("Martin", "México", "Campeche", "49473872", "martin@gmail.com", true, "martin.jpg", "martin.pdf", Student.Status_face_to_face.PRESENCIAL);
        Student student7 = new Student("Maria", "Argentina", "Buenos Aires", "782748", "maria@gmail.com", true, "maria.jpg", "maria.pdf", Student.Status_face_to_face.PRESENCIAL);
        Student student8 = new Student("Antony", "México", "Cozumel", "8938494", "antony@gmail.com", true, "antony.jpg", "antony.pdf", Student.Status_face_to_face.REMOTO);
        Student student9 = new Student("Juan", "Argentina", "Buenos Aires", "938494", "juan@gmail.com", true, "juan.jpg", "juan.pdf", Student.Status_face_to_face.MIXTO);
        Student student10 = new Student("Pedro", "España", "Barcelona", "839494", "pedro@gmail.com", false, "pedro.jpg", "pedro.pdf", Student.Status_face_to_face.PRESENCIAL);
        Student student11 = new Student("Ramon", "Chile", "Santiago", "773348", "ramon@gmail.com", true, "ramon.jpg", "ramon.pdf", Student.Status_face_to_face.REMOTO);
        Student student12 = new Student("Angel", "España", "Madrid", "98493", "angel@gmail.com", false, "angel.jpg", "angel.pdf", Student.Status_face_to_face.REMOTO);
        Student student13 = new Student("Martin", "México", "Campeche", "49473872", "martin@gmail.com", true, "martin.jpg", "martin.pdf", Student.Status_face_to_face.PRESENCIAL);
        Student student14 = new Student("Maria", "Argentina", "Buenos Aires", "782748", "maria@gmail.com", true, "maria.jpg", "maria.pdf", Student.Status_face_to_face.PRESENCIAL);

        students.add(student1);
        students.add(student2);
        students.add(student3);
        students.add(student4);
        students.add(student5);
        students.add(student6);
        students.add(student7);
        students.add(student8);
        students.add(student9);
        students.add(student10);
        students.add(student11);
        students.add(student12);
        students.add(student13);
        students.add(student14);


        generatePDF.setStudentArrayList(students);

        while (true) {

            System.out.println("Seleccione una opción: \n" +
                    "1.Generar PDF de un alumno \n" +
                    "2.Salir");

            int menu = sc.nextInt();
            switch(menu) {
                case 1 -> {
                    int position = 1;
                    SB.setLength(0);
                    for (Student student : generatePDF.getStudentArrayList()){
                        SB.append(position).append("._ ").append(student).append("\n");
                        position++;
                    }

                    try {
                        System.out.println("Elija el alumno para generar su CV "+ SB);
                        int option = sc.nextInt();

                        while(option > generatePDF.getStudentArrayList().size()){
                            System.out.println("La Respuesta ha sido incorrecta \n" +
                                    "Elija el alumno para generar su CV \n" +
                                    "" + SB);
                            option = sc.nextInt();

                        }
                        generatePDF.generatePDF(generatePDF.getStudentArrayList().get(option - 1));

                    } catch (NumberFormatException | IndexOutOfBoundsException e){
                        System.out.println("Elija una opción valida");
                    }
                    break;
                }
                case 2 -> {
                    System.out.println("Has seleccionado Salir del Programa!");
                    System.exit(0);
                }

            }
        }

    }
}
