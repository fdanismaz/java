# F-Commons REST Framework
## Purpose
The purpose of this artifact is to handle any kind of uncaught exceptions in an HTTP Request, handle it, and 
return a standardized response to the client.

A secondary purpose is to give a easy to access request context which contains the `HttpServletRequest`, 
`HttpServletResponse`, and client time-zone.

## How To Use
### Add the Maven Dependency
```xml
<dependency>
    <groupId>com.fd</groupId>
    <artifactId>fcommons-rest</artifactId>
    <version>${fcommons.version}</version>
</dependency>
```

### Extend Your Rest Controller from `FRestController`
In your Rest Controllers, just extend from `FRestController` and use its `success()` or `success(data)` 
methods for returning response to client.

```java
import com.fcommons.rest.FRestController;

import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/account")
public class AccountController extends FRestController {
    
    @GetMapping("/{id}")
    public ResponseEntity<AwsAccount> getAccountById(@PathVariable("id") String accountId) {
        AwsAccount account = ...;
        return this.success(account);
    }
}
```

### Unexpected Conditions
All unhandled situations will be caught and handled by the `FRestControllreAdvice`. Nothing needed to be done
for this mechanism to work. It will be active as you add the dependency. Just make sure `com.fcommons` is 
included in your package scan.

With the `FRestControllerAdvice` in place:
* you don't need to use try { ... } catch(...) blocks unless you'll execute a different and meaningful handling mechanism
* you don't need to worry about invalid arguments or missing parameters
* you can throw any type of exception from any layer for unexpected situations and don't worry about the rest. It will 
be caught and handled by the `FControllerAdvice` and the client will receive the message that you put into the
exception.


### Errors in the Response Body
When the `FRestControllerAdvice` catches an exception, it returns an array of error items. Each error item has 
the following fields:
* **title**: The error title
* **message**: The error message
* **type**: FErrorType: (Default, Object, or Field) Object and field error types are produced for invalid input
parameters if you annotate your input parameters with `@Valid`. Any other type of error is considered as Default error.

When you put @Valid annotation to your input parameters in your endpoints, Spring MVC automatically validates that 
object based on the bean validation specifications that you provide in your parameter's class definition. For each
validation error, the `FRestControllerAdvice` will add separate error item into the response.

```json
{
    "errors": [
        {
            "title": "accountId",
            "message": "Invalid username. The username id should contain at least 4 characters",
            "type": "field-error"
        },
        {
            "title": "email",
            "message": "Please provide a valid e-mail address",
            "type": "field-error"
        }
    ]
}
```
In this response, the title of the each error item correspond to a field name of the related input parameter.

For the cases other than the invalid input parameter, the errors array will always contain one item which will include the
thrown exception's message like below:

```json
{
    "errors": [
        {
            "title": "Server error",
            "message": "User not found",
            "type": "default-error"
        }
    ]
}
```

