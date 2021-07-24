package com.corona.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.corona.models.LocationStats;
import com.corona.services.CoronaVirusDataService;

@Controller
public class HomeController {
	
	@Autowired
	CoronaVirusDataService dataService;
	
	@GetMapping("/")
	public String home(Model model) {
		
		List<LocationStats> allStats = dataService.getAllStats();
		int totalCases = allStats.stream().mapToInt(stat -> stat.getLatestTotalCases()).sum();
		int totalIncreasedCases = allStats.stream().mapToInt(stat -> stat.getDiffFromPrevDay()).sum();
		model.addAttribute("allStats",allStats);
		model.addAttribute("totalNumberOfCases", totalCases);
		model.addAttribute("totalNumberIncreasedOfCases", totalIncreasedCases);
		 return "home";		
	}

}
