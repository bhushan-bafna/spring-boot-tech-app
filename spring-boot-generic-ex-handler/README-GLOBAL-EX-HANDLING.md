#Global exception handling 

* In Spring Boot it refers to the practice of centralizing exception handling logic for an entire application rather than handling exceptions at individual points in the code. It is achieved using the @RestControllerAdvice and @ExceptionHandler annotations.

* <code>@RestControllerAdvice</code> and <code>@ExceptionHandler</code> are used to implement global exception handling for RESTful APIs. They allow you to define centralized exception handling logic that is applied to all <code>@RestController</code> classes in your application.

* <code>@RestControllerAdvice</code> is an annotation that combines the functionalities of <code>@ControllerAdvice</code> and <code>@ResponseBody</code>. It is used to define a global exception handler for REST controllers.

* <code>@ExceptionHandler</code> is used within the <code>@RestControllerAdvice</code> class to define methods that handle specific exceptions thrown during the execution of REST controller methods.

Example of Global Exception Handling

	import org.springframework.http.HttpStatus;
	import org.springframework.http.ResponseEntity;
	import org.springframework.web.bind.annotation.ExceptionHandler;
	import org.springframework.web.bind.annotation.RestControllerAdvice;
	
	@RestControllerAdvice
	public class GlobalExceptionHandler {
	
	    // Exception handling method for specific exception type
	    @ExceptionHandler(CustomNotFoundException.class)
	    public ResponseEntity<String> handleNotFoundException(CustomNotFoundException ex) {
	        return new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_FOUND);
	    }
	
	    // Generic exception handling method for all other exceptions
	    @ExceptionHandler(Exception.class)
	    public ResponseEntity<String> handleGenericException(Exception ex) {
	        return new ResponseEntity<>("An error occurred: " + ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
	    }
	}
