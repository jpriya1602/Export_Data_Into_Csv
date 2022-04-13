package com.demo.export_data_into_csv.controller;

import com.demo.export_data_into_csv.Session;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.supercsv.io.CsvBeanWriter;
import org.supercsv.io.ICsvBeanWriter;
import org.supercsv.prefs.CsvPreference;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;


@RestController
@RequestMapping
public class CSVController {

    @GetMapping("/download")
    public ArrayList<Session> downloadCSV(HttpServletResponse response) throws IOException {
        response.setContentType("text/csv");
        response.setHeader("content-disposition","attachment; filename=sessions.csv");

       ICsvBeanWriter csvWriter = new CsvBeanWriter(response.getWriter(), CsvPreference.STANDARD_PREFERENCE);

       String[] headings = {"Subject","Start date","Start time","End date","End time"};
       String[] sessionColumns = {"name","startDate","startTime","endDate","endTime"};
       csvWriter.writeHeader(headings);


        Session newSession = new Session("SessionName","04/13/2022","10:30 AM","04/13/2022","11:00 AM");
        ArrayList<Session> sessionList = new ArrayList<>();
        sessionList.add(newSession);

        for (Session session : sessionList) {
            csvWriter.write(session, sessionColumns);
        }
        csvWriter.close();
        return sessionList;
    }

}
