package com.aipalbot.sell.taja.controllers;

import java.util.Arrays;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.aipalbot.sell.taja.models.ChatModel;

@RestController
@RequestMapping("/string")
public class StringController {

	@GetMapping("/concat/{fName}/{lName}")
	public ResponseEntity<String> getConcat(@PathVariable String fName, @PathVariable String lName){
		
		String concat = fName + " " + lName;
		
		StringBuilder sb = new StringBuilder();
		
		for(int i = concat.length()-1; i >=0; i-- ) {
			sb.append(concat.charAt(i));
		}
		
		return new ResponseEntity<>(sb.toString(), HttpStatus.OK);
	}
	
	@GetMapping("/initial/{fName}/{lName}")
	public ResponseEntity<String> getInitials(@PathVariable String fName, @PathVariable String lName){
		
		String initials = fName.charAt(0) + "." + lName.charAt(0);
		
		return new ResponseEntity<>(initials, HttpStatus.OK);
	}
	@GetMapping("/chat/split")
	public ResponseEntity<?> getResponse(@RequestBody ChatModel chat){
		//where are you coming from? tell me a little more
		String[] chatArray = chat.getUserRequest().split(" "); 
		
		List<String> wordSplits =Arrays.asList(chatArray);
		
		return new ResponseEntity<>(chatArray, HttpStatus.OK);
	}
	@GetMapping("/chat/replace")
	public ResponseEntity<?> getReplace(@RequestBody ChatModel chat){
		//where are you coming from? tell me a little more
		String replacedString = chat.getUserRequest().replace("you", "");
		
		
		
		return new ResponseEntity<>(replacedString, HttpStatus.OK);
	}
	@GetMapping("/chat/toUpper")
	public ResponseEntity<?> getCapitalized(@RequestBody ChatModel chat){
		//where are you coming from? tell me a little more
		String replacedString = chat.getUserRequest().toUpperCase();
		
		
		
		return new ResponseEntity<>(replacedString, HttpStatus.OK);
	}
	@GetMapping("/chat/toLower")
	public ResponseEntity<?> getUnCapitalized(@RequestBody ChatModel chat){
		//where are you coming from? tell me a little more
		String replacedString = chat.getUserRequest().toLowerCase();
		
		
		
		return new ResponseEntity<>(replacedString, HttpStatus.OK);
	}
	@GetMapping("/chat/findY")
	public ResponseEntity<?> getY(@RequestBody ChatModel chat){
		//where are you coming from? tell me a little more
		int yLocation = chat.getUserRequest().indexOf('y');
		
		String response =String.valueOf(yLocation);
		if(yLocation < 0)
			response = "y is not present in the context";
			
		
		return new ResponseEntity<>(response, HttpStatus.OK);
	}
	@GetMapping("/chat/searchindex/{word}")
	public ResponseEntity<?> getBySearch( @PathVariable String word,@RequestBody ChatModel chat){
		//where are you coming from? tell me a little more
		int searchLocation = chat.getUserRequest().indexOf(word);
		
		String response =String.valueOf(searchLocation);
		if(searchLocation < 0)
			response = "y is not present in the context";
			
		
		return new ResponseEntity<>(response, HttpStatus.OK);
	}
	@GetMapping("/chat/search/{word}")
	public ResponseEntity<?> findWord(@RequestBody ChatModel chat, @PathVariable String word){
		//where are you coming from? tell me a little more
		
		
		String response ="'"+word + "' is not found!";
		if(chat.getUserRequest().contains(word))
			response = "Yes, '"+word+"' is present in the context";
			
		
		return new ResponseEntity<>(response, HttpStatus.OK);
	}
	
	@GetMapping("/chat/substring/{start}/{end}")
	public ResponseEntity<?> getSubtring(@RequestBody ChatModel chat, @PathVariable int start,@PathVariable int end ){
		//where are you coming from? tell me a little more
		String substring = chat.getUserRequest().substring(start, end);
		
		
		
		return new ResponseEntity<>(substring, HttpStatus.OK);
	}
	
}
