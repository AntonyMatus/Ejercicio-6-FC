package com.example.controllers;

import com.example.entities.Student;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.font.PDType1Font;
import org.apache.pdfbox.pdmodel.graphics.image.PDImageXObject;

import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class GeneratePDF {

    private ArrayList<Student> studentArrayList = new ArrayList<>();
    public GeneratePDF() {
    }

    public ArrayList<Student> getStudentArrayList() {
        return studentArrayList;
    }

    public void setStudentArrayList(ArrayList<Student> studentArrayList) {
        this.studentArrayList = studentArrayList;
    }


    public void generatePDF(Student student){

        try {

            System.out.println("Generando CV de la persona con el correo " + student.getEmail());
            String fileName = "CV_"+ student.getEmail()+".pdf";
            PDDocument pdf = new PDDocument();
            PDPage page = new PDPage();
            pdf.addPage(page);
            PDImageXObject img = PDImageXObject.createFromFile("C:\\Users\\tony_\\IdeaProjects\\Ejercicio6FC\\src\\main\\java\\com\\example\\img\\wey_ya.jpg",pdf);
            PDPageContentStream content = new PDPageContentStream(pdf,page);
            content.drawImage(img, 50, 50);

            content.beginText();
            content.setFont(PDType1Font.HELVETICA, 25);
            content.newLineAtOffset(180,750);
            content.showText("CV " + student.getEmail());
            content.endText();

            content.beginText();
            content.setFont(PDType1Font.HELVETICA, 25);
            content.newLineAtOffset(80,720);
            content.showText("Name: " + student.getName());
            content.endText();

            content.beginText();
            content.setFont(PDType1Font.HELVETICA, 25);
            content.newLineAtOffset(80,700);
            content.showText("Country: " + student.getCountry());
            content.endText();

            content.beginText();
            content.setFont(PDType1Font.HELVETICA, 25);
            content.newLineAtOffset(80,670);
            content.showText("City: " + student.getCity());
            content.endText();

            content.beginText();
            content.setFont(PDType1Font.HELVETICA, 25);
            content.newLineAtOffset(80,650);
            content.showText("Phone: " + student.getPhone());
            content.endText();

            content.beginText();
            content.setFont(PDType1Font.HELVETICA, 25);
            content.newLineAtOffset(80,620);
            content.showText("Email: " + student.getEmail());
            content.endText();

            content.beginText();
            content.setFont(PDType1Font.HELVETICA, 25);
            content.newLineAtOffset(80,600);
            if (student.getStatus_transfer()) content.showText("Transfer: YES");
            else content.showText("Transfer: NO");
            content.endText();

            content.beginText();
            content.setFont(PDType1Font.HELVETICA, 25);
            content.newLineAtOffset(80,580);
            content.showText("Face_to_Face: " + student.getStatus_face_to_face());
            content.endText();

            content.close();
            pdf.save(fileName);
            pdf.close();

            System.out.println("El CV se ha creado correctamente: " + System.getProperty("user.dir"));

            int verPdf = JOptionPane.showConfirmDialog(null, "¿Deseas ver el Cv que se ha creado de "+ student.getEmail() + " ?");
            boolean respuesta = JOptionPane.OK_OPTION == verPdf;
            if (respuesta){
                try {
                    File dir = new File(fileName);
                    Desktop.getDesktop().open(dir);
                } catch (IOException exeption){
                    exeption.printStackTrace();
                }
            }

        } catch (IOException e){
            System.out.println(e.getMessage());
        }

    }
}
