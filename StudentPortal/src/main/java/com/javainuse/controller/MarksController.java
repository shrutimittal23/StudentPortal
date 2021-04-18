package com.javainuse.controller;

import java.util.List;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.javainuse.exception.UserNotFoundException;
import com.javainuse.model.Marks;
import com.javainuse.model.MarksDTO;
import com.javainuse.service.MarksService;

@RestController
@RequestMapping("/api/admin")
public class MarksController {

	private static final Logger log = LoggerFactory.getLogger(MarksController.class);

	@Autowired
	private MarksService marksService;

	@PostMapping(value = "/addmarks/{stu_id}/{sub_id}")
	public Marks addMarks(@RequestBody Marks marks, @PathVariable Integer stu_id, @PathVariable Integer sub_id) {
		return marksService.addMarks(marks, stu_id, sub_id);
	}

	@GetMapping("/all")
	public List<Marks> getall() {
		return marksService.getall();
	}

	@GetMapping(value = "/rank")
	@Scheduled(cron = "0 */5 * * * *")
	public List<MarksDTO> getranks() {
		List<MarksDTO> marks = marksService.getRanks();
		marks.forEach(e -> {
			log.info("Data in every 5 minutes :", e);
		});

		return marksService.getRanks();
	}

	@DeleteMapping(value = "/delete/{id}")
	public void delete(@PathVariable Integer id) {
		Marks marks = marksService.getMarksById(id);
		if (marks != null) {
			marksService.deleteMarks(id);
		} else {
			throw new UserNotFoundException("Marks id '" + id + "' does no exist");
		}

	}

	@GetMapping(value = "/get/{id}")
	public ResponseEntity<Marks> getMarks(@PathVariable Integer id) {
		Marks marks = marksService.getMarksById(id);
		if (marks != null) {
			return new ResponseEntity<Marks>(marks, HttpStatus.OK);
		} else {
			throw new UserNotFoundException("Marks id '" + id + "' does no exist");
		}
	}

	@PutMapping(value = "/update/{stu_id}/{sub_id}")
	public Marks update(@RequestBody Marks marks, @PathVariable Integer stu_id, @PathVariable Integer sub_id) {
		return marksService.updateMarks(marks, stu_id, sub_id);
	}

	@Scheduled(fixedDelay = 30000)
	public void send() {
		log.info("Running every 30 secs -- testing");
	}

}
