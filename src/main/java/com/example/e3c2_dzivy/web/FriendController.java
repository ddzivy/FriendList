package com.example.e3c2_dzivy.web;

import java.util.ArrayList;


	import org.springframework.stereotype.Controller;
	import org.springframework.ui.Model;
	import org.springframework.web.bind.annotation.ModelAttribute;
	import org.springframework.web.bind.annotation.RequestMapping;
	import org.springframework.web.bind.annotation.RequestMethod;
	import org.springframework.web.bind.annotation.RequestParam;

import com.example.e3c2_dzivy.domain.Friend;

@Controller
public class FriendController {
	
	private ArrayList<Friend> friends = new ArrayList<Friend>();
	 
	@RequestMapping(value="/index", method=RequestMethod.GET)
	public String index(@RequestParam(name="friend", required=false) String friend, Model model) {
		if(friend!=null)
		{friends.add(new Friend(friend));}
		model.addAttribute("friends", friends);
		model.addAttribute("newFriend", new Friend());
	    return "index";
	}	 

	@RequestMapping(value="/index", method=RequestMethod.POST)
	public String addFriend(@ModelAttribute Friend newFriend, Model model) {
		friends.add(newFriend);
		model.addAttribute("newFriend", new Friend());
		model.addAttribute("friends", friends);
	    return "index";
	}

	}
/*
 * Another option:
 * @RequestMapping(value="/getindex", method=RequestMethod.GET) public String
 * addFriend(@ModelAttribute Friend newFriend, Model model) {
 * friends.add(newFriend); model.addAttribute("newFriend", new Friend());
 * model.addAttribute("friends", friends); return "index"; }
 * then in index: <form action="#" th:action="@{/getindex}" th:object="${newFriend}" method="get">
 */
