package com.careerdevs.jsonplaceholderapi.controller;

import com.careerdevs.jsonplaceholderapi.models.PostModel;
import com.careerdevs.jsonplaceholderapi.models.ToDoModel;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/api/todos")
public class ToDoController {
    private final String jsonPHToDosEndpoint = "https://jsonplaceholder.typicode.com/todos";

    @GetMapping("/all")
    public ResponseEntity<?> getAllToDos(RestTemplate restTemplate) {
        try {
            ToDoModel[] response = restTemplate.getForObject(jsonPHToDosEndpoint, ToDoModel[].class);
            return ResponseEntity.ok(response);
        } catch (Exception e) {
            System.out.println(e.getClass());
            System.out.println(e.getMessage());

            return ResponseEntity.internalServerError().body(e.getMessage());
        }
    }

    @GetMapping("/id/{id}")
    public ResponseEntity<?> getToDoById(RestTemplate restTemplate, @PathVariable String id) {
        try {
            Integer.parseInt(id);

            System.out.println("Getting ToDo With ID: " + id);

            String url = jsonPHToDosEndpoint + "/" + id;

            ToDoModel response = restTemplate.getForObject(url, ToDoModel.class);

            return ResponseEntity.ok(response);

        } catch (NumberFormatException e) {
            return ResponseEntity.status(400).body("ID: " + id + ", is not a valid id. Must be a whole number");

        } catch (HttpClientErrorException.NotFound e) {
            return ResponseEntity.status(404).body("Todo Not Found With ID: " + id);

        } catch (Exception e) {
            System.out.println(e.getClass());
            System.out.println(e.getMessage());

            return ResponseEntity.internalServerError().body(e.getMessage());
        }
    }
}
