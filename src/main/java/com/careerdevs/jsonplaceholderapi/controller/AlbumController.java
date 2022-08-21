package com.careerdevs.jsonplaceholderapi.controller;

import com.careerdevs.jsonplaceholderapi.models.AlbumModel;
import com.careerdevs.jsonplaceholderapi.models.CommentModel;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/api/albums")
public class AlbumController {
    private final String jsonPHAlbumsEndpoint = "https://jsonplaceholder.typicode.com/albums";
    @GetMapping("/all")
    public ResponseEntity<?> getAllAlbums(RestTemplate restTemplate) {
        try {
            AlbumModel[] response = restTemplate.getForObject(jsonPHAlbumsEndpoint, AlbumModel[].class);
            return ResponseEntity.ok(response);
        } catch (Exception e) {
            System.out.println(e.getClass());
            System.out.println(e.getMessage());

            return ResponseEntity.internalServerError().body(e.getMessage());
        }
    }

    @GetMapping("/id/{id}")
    public ResponseEntity<?> getAlbumById(RestTemplate restTemplate, @PathVariable String id) {
        try {
            Integer.parseInt(id);

            System.out.println("Getting Comment With ID: " + id);

            String url = jsonPHAlbumsEndpoint + "/" + id;

            AlbumModel response = restTemplate.getForObject(url, AlbumModel.class);

            return ResponseEntity.ok(response);

        } catch (NumberFormatException e) {
            return ResponseEntity.status(400).body("ID: " + id + ", is not a valid id. Must be a whole number");

        } catch (HttpClientErrorException.NotFound e) {
            return ResponseEntity.status(404).body("Album Not Found With ID: " + id);

        } catch (Exception e) {
            System.out.println(e.getClass());
            System.out.println(e.getMessage());

            return ResponseEntity.internalServerError().body(e.getMessage());
        }
    }
}
