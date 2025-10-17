package com.test.rentspace.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import com.test.rentspace.model.*;
import com.test.rentspace.repository.*;

import jakarta.servlet.http.HttpSession;
import java.util.Optional;

@Controller
public class PaymentController {
    private final BookingRepository bookingRepo;
    private final PaymentRepository paymentRepo;

    public PaymentController(BookingRepository bookingRepo, PaymentRepository paymentRepo){
        this.bookingRepo = bookingRepo; this.paymentRepo = paymentRepo;
    }

    @GetMapping("/payment")
    public String paymentPage(@RequestParam Long bookingId, HttpSession session, Model model){
        Object u = session.getAttribute("user");
        if(u==null) return "redirect:/login";
        Optional<Booking> b = bookingRepo.findById(bookingId);
        if(b.isEmpty()) return "redirect:/dashboard";
        model.addAttribute("booking", b.get());
        return "payment";
    }

    @PostMapping("/payment")
    public String makePayment(@RequestParam Long bookingId,
                              @RequestParam Double amount,
                              Model model) {
        Optional<Booking> b = bookingRepo.findById(bookingId);
        if(b.isEmpty()) return "redirect:/dashboard";
        Payment p = new Payment();
        p.setBooking(b.get());
        p.setAmount(amount);
        p.setStatus("PAID");
        paymentRepo.save(p);
        model.addAttribute("payment", p);
        return "payment-success";
    }
}
