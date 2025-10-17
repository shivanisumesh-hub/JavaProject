package com.test.rentspace.controller;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import com.test.rentspace.model.*;
import com.test.rentspace.repository.*;

import jakarta.servlet.http.HttpSession;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Controller
public class DashboardController {
    private final AccommodationRepository accRepo;
    private final BookingRepository bookingRepo;
    public DashboardController(AccommodationRepository accRepo, BookingRepository bookingRepo, UserRepository userRepo){
        this.accRepo = accRepo; this.bookingRepo = bookingRepo;
    }

    @GetMapping("/dashboard")
    public String dashboard(HttpSession session, Model model){
        User user = (User) session.getAttribute("user");
        if(user==null) return "redirect:/login";
        List<Accommodation> list = accRepo.findAll();
        model.addAttribute("accommodations", list);
        model.addAttribute("user", user);
        return "dashboard";
    }

    @GetMapping("/accommodations")
    public String accommodations(HttpSession session, Model model){
        User user = (User) session.getAttribute("user");
        if(user==null) return "redirect:/login";
        List<Accommodation> list = accRepo.findAll();
        model.addAttribute("accommodations", list);
        return "accommodations";
    }

    @PostMapping("/book")
    public String book(@RequestParam Long accId,
                       @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate startDate,
                       @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate endDate,
                       HttpSession session,
                       Model model) {
        User user = (User) session.getAttribute("user");
        if(user==null) return "redirect:/login";
        Optional<Accommodation> opt = accRepo.findById(accId);
        if(opt.isEmpty()){
            model.addAttribute("error","Accommodation not found");
            return "redirect:/accommodations";
        }
        Accommodation acc = opt.get();
        Booking booking = new Booking();
        booking.setUser(user);
        booking.setAccommodation(acc);
        booking.setStartDate(startDate);
        booking.setEndDate(endDate);
        bookingRepo.save(booking);

        // mark unavailable
        acc.setAvailable(false);
        accRepo.save(acc);

        return "redirect:/payment?bookingId=" + booking.getId();
    }
}

