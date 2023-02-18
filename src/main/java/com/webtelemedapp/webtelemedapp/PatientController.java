package com.webtelemedapp.webtelemedapp;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;

import java.util.Date;
import java.util.List;

@Controller
public class PatientController {


    @Autowired
    ReportTmRepository RpRepository;
    @Autowired
    UserTmRepository TmRepository;


    @GetMapping("/addNewReport")
    public String addNewRecord(long userTmId, String dtm1, int st1, int dt1, int otk1, String opis1, Model model) {
        UserTm currUser = TmRepository.findById(userTmId).get();
        ReportTm newReportTm = new ReportTm(dtm1, st1, dt1, otk1, opis1);
        newReportTm.setUser(currUser);
        RpRepository.save(newReportTm);

        return "doktor_pregled_pojedinog_pacijenta.html";
    }


}









