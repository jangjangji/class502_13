package org.choongang.file.controllers;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;

@WebServlet("/file/download")
public class FileDownloadController extends HttpServlet {
    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        File file = new File("C:/uploads/1.png");
        String contentType = Files.probeContentType(file.toPath());
        String fileName=new String(file.getName().getBytes(), "ISO8859-1");

        resp.setHeader("Content-Disposition", "attachment; filename="+fileName);
        resp.setContentType(contentType);
        resp.setHeader("Cache-Control", "must-revalidate");
        resp.setIntHeader("Expires", 0);
        resp.setContentLengthLong(file.length());

        PrintWriter out = resp.getWriter();
        out.print("ABC");
        out.print("DEF");
    }
}
