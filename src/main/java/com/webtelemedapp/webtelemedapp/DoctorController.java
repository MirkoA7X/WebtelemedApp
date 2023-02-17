package com.webtelemedapp.webtelemedapp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.List;

import static com.webtelemedapp.webtelemedapp.UserTmRepository.*;

@Controller
public class DoctorController {
    UserTm currUser;
    List<UserTm> userTmList = new ArrayList<>();

   /* public DoctorController(List<UserTm> userTmList) {
        userTmList.add(new UserTm("Mirko", "Božić", "09.06.1991.", "0917256847", "mirko@gmail.com", "12345", "126547852" ));
    }*/

    @Autowired
    UserTmRepository TmRepository;

    @Autowired
    ReportTmRepository RpRepository;

    @GetMapping("/listUsers")
    public String listUsers(Model model) {
        model.addAttribute(TmRepository.findByType(0));
        return "doktor_dashboard.html";

    }

    @GetMapping("/addNewUser")
    public String addNewUser(String ime1, String prezime1, String datumRodenja1, String brojMobitela1, String email1, String lozinka1, String mbo1, Model model) {
        UserTm newTmUser = new UserTm(ime1, prezime1, datumRodenja1, brojMobitela1, email1, lozinka1, mbo1);
        TmRepository.save(new UserTm());
        return "redirect:/listUsers";

    }
    @GetMapping("/showCreateNewUser")
    public String showCreateNewUser(Model model) {
        model.addAttribute(userTmList);
        return "kreiranje_novog_usera.html";

    }


    @GetMapping("/showUser")
    public String showRecordsForUser (long userId, Model model) {
        UserTm userTm = TmRepository.findById(userId).get();
        model.addAttribute (userTm);
        model.addAttribute (RpRepository.findByUserTm(userTm));

        return "doktor_pregled_pojedinog_pacijenta.html";
    }

    @GetMapping("/deletePatientByDoctor")
    public String deletePatientByDoctor (Long id) {
        UserTm userTm = TmRepository.findById (id).get ();
        TmRepository.delete (userTm);

        return "redirect:/listUsers";
    }


    @GetMapping("/login")
    public String login() {
        return "login.html";
    }

    @GetMapping("/loginSubmit")
    public String login(String email, String lozinka, Model model) {

        UserTm userTm = TmRepository.findByEmailAndLozinka(email, lozinka);
        if (userTm != null) {
            System.out.println("UserTm found: " + userTm);
            currUser = userTm;
            if (userTm.getType() == 0)
                return "redirect:/showNewReport?userId=" + userTm.getId();
            else
                return "redirect:/listUsers";
        } else {
            model.addAttribute("userMessage", "UserTm not found!");
            return "login.html";
        }
    }

    @GetMapping("/")
    public String redirectToLogin() {
        return "redirect:/login";
    }
}






