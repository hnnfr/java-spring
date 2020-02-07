package spittr.web;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import spittr.Spittle;
import spittr.data.SpittleRepository;

@Controller
@RequestMapping("/spittles")
public class SpittleController {

	private static final String MAX_LONG_AS_STRING = "" + Long.MAX_VALUE;
	
	private SpittleRepository spittleRepository;

	@Autowired
	public SpittleController(SpittleRepository spittleRepository) {
		this.spittleRepository = spittleRepository;
	}

	// 1st version
//	@RequestMapping(method = RequestMethod.GET)
//	public String spittles(Model model) {
//		model.addAttribute(spittleRepository.findSpittles(Long.MAX_VALUE, 20));
//		return "spittles";
//	}

	// 2nd version
//	@RequestMapping(method = RequestMethod.GET)
//	public String spittles(Model model) {
//		model.addAttribute("spittleList", spittleRepository.findSpittles(Long.MAX_VALUE, 20));
//		return "spittles";
//	}
	
	// 3rd version
//	@RequestMapping(method = RequestMethod.GET)
//	public String spittles(Map<String, List<Spittle>> model) {
//		model.put("spittleList", spittleRepository.findSpittles(Long.MAX_VALUE, 20));
//		return "spittles";
//	}
	
	// 4th version
//	@RequestMapping(method = RequestMethod.GET)
//	public List<Spittle> spittles() {
//		return spittleRepository.findSpittles(Long.MAX_VALUE, 20);
//	}

	@RequestMapping(method = RequestMethod.GET)
	public String spittles(
			@RequestParam(value = "max", defaultValue = MAX_LONG_AS_STRING) long max, 
			@RequestParam(value = "count", defaultValue = "20") int count, 
			Model model) {
		model.addAttribute("spittleList", spittleRepository.findSpittles(max, count));
		return "spittles";
	}
	
//	@RequestMapping(method = RequestMethod.GET)
//	public List<Spittle> spittles(
//			@RequestParam(value = "max", defaultValue = MAX_LONG_AS_STRING) long max, 
//			@RequestParam(value = "count", defaultValue = "20") int count) {
//		return spittleRepository.findSpittles(max, count);
//	}
	
	@RequestMapping(value = "/{spittleId}", method = RequestMethod.GET)
	public String spittle(
			@PathVariable long spittleId, 
			Model model) {
		model.addAttribute("spittle", spittleRepository.findOne(spittleId)); 
		return "spittle";
	}
}
