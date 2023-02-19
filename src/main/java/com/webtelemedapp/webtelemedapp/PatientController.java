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

    @GetMapping("/listReports")
    public String listReports (long userId, Model model) {
        UserTm currUser = TmRepository.findById (userId).get ();
        model.addAttribute ("currUser", currUser);
        model.addAttribute (RpRepository.findByUserTm (currUser));

        return "pacijent_popis_zapisa.html";
    }

    @GetMapping("/showReportForm")
    public String showReportForm (long userId, Model model) {
        UserTm currUser = TmRepository.findById(userId).get();
        model.addAttribute("currUser", currUser);
        return "pacijent_unos_novog_zapisa.html";
    }

    @GetMapping("/delete")
    public String delete (Long id) {

        ReportTm reportTm = RpRepository.findById (id).get ();
        RpRepository.delete (reportTm);


        return "redirect:/listReports?userId=" + reportTm.getUser ().getId ();

    }

}









