package fr.icdc.dei.todolist.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import fr.icdc.dei.todolist.service.TodolistService;

@Controller
@RequestMapping("/")
public class TodolistController {
	
	private static final String TASKS_HTTP_ATTR = "tasks";
	
	@Autowired
	private TodolistService todolistService;
	
	@RequestMapping(method=RequestMethod.GET)
	public ModelAndView home() {
		ModelAndView page = new ModelAndView("Home");
		page.addObject(TASKS_HTTP_ATTR, todolistService.listTasks());
		return page;
	}
	
	@RequestMapping(value = "create", method=RequestMethod.GET)
	public ModelAndView renderCreateTaskForm() {
		ModelAndView page = new ModelAndView("TaskForm");
		page.addObject("status", todolistService.listTaskStatus());
		return page;
	}
	
	@RequestMapping(value = "create", method=RequestMethod.POST)
	public ModelAndView createTask(@RequestParam String taskName, @RequestParam("status") int statusId) {
		ModelAndView page = new ModelAndView("Home");
		todolistService.addTask(taskName, statusId);
		page.addObject(TASKS_HTTP_ATTR, todolistService.listTasks());
		return page;
	}
	
	@RequestMapping(value = "validate", method=RequestMethod.POST)
	public ModelAndView validateTask(@RequestParam long id) {
		ModelAndView page = new ModelAndView("Home");
		todolistService.setFinishTask(id);
		page.addObject(TASKS_HTTP_ATTR, todolistService.listTasks());
		return page;
	}

}
