package com.careerdevs.jsonplaceholderapi.basic.controller;

import com.careerdevs.jsonplaceholderapi.mysql.Album;
import com.careerdevs.jsonplaceholderapi.mysql.repository.AlbumRepository;
import com.careerdevs.jsonplaceholderapi.basic.models.AlbumModel;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(path="/api/albums")
public class AlbumController {
    private final String jsonPHAlbumsEndpoint = "https://jsonplaceholder.typicode.com/albums";

    @RequestMapping(path="/demo")
    public class albumMainControl {
        @Autowired
        private AlbumRepository albumRepository;

        @PostMapping(path="/add")
        public @ResponseBody String addNewAlbum (@RequestParam Integer userId, @RequestParam Integer id, @RequestParam String title) {
            Album n = new Album();
            n.setUserId(userId);
            n.setId(id);
            n.setTitle(title);
            albumRepository.save(n);
            return "Saved";
        }
        @GetMapping(path="/all")
        public @ResponseBody Iterable<Album> getAllAlbums() {
            return albumRepository.findAll();
        }
    }
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

//    @GetMapping("/scrape")
//    public ResponseEntity<?> scrapeAllAlbums(RestTemplate restTemplate) {
//        try {
//            AlbumModel[] response = restTemplate.getForObject(jsonPHAlbumsEndpoint, AlbumModel[].class);
//            return ResponseEntity.ok(response);
//        } catch (Exception e) {
//            System.out.println(e.getClass());
//            System.out.println(e.getMessage());
//
//            return ResponseEntity.internalServerError().body(e.getMessage());
//        }
//    }

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
