package demo.audit.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import demo.audit.service.BlogService;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/category")
@RequiredArgsConstructor
public class BlogController {

	private final BlogService blogService;

	@GetMapping("/create/{name}")
	public ResponseEntity<Boolean> test1(@PathVariable("name") String name) {
		blogService.test1(name);
		return ResponseEntity.ok(true);
	}

	@GetMapping("/post/create")
	public ResponseEntity<Boolean> test() {
		blogService.test();
		return ResponseEntity.ok(true);
	}

	@DeleteMapping("/delete/{postId}")
	public ResponseEntity<Boolean> test(@PathVariable("postId") Integer postId) {
		blogService.delete(postId);
		return ResponseEntity.ok(true);
	}

	@PutMapping("/update/{postId}")
	public ResponseEntity<Boolean> update(@PathVariable("postId") Integer postId) {
		blogService.update(postId);
		return ResponseEntity.ok(true);
	}

	@GetMapping("/revision")
	public ResponseEntity<Boolean> revision() {
		blogService.revision();
		return ResponseEntity.ok(true);
	}
}
