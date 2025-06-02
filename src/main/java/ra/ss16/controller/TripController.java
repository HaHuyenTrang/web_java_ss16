package ra.ss16.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import ra.ss16.model.Trip;
import ra.ss16.service.TripService;
import ra.ss16.service.TripServiceImpl;

import java.util.List;

@Controller
public class TripController {
    private TripService tripService = new TripServiceImpl();

    @GetMapping("/home")
    public String viewHome(
            @RequestParam(defaultValue = "") String departure,
            @RequestParam(defaultValue = "") String destination,
            @RequestParam(defaultValue = "1") int page,
            Model model
    ) {
        int size = 5; // Số phần tử mỗi trang

        List<Trip> trips = tripService.getTrips(departure, destination, page, size);
        int totalPages = tripService.countPages(departure, destination, size);

        model.addAttribute("trips", trips);
        model.addAttribute("currentPage", page);
        model.addAttribute("totalPages", totalPages);
        model.addAttribute("departure", departure);
        model.addAttribute("destination", destination);

        return "home";
    }
}
