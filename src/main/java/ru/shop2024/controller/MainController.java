package ru.shop2024.controller;

import org.apache.catalina.User;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.shop2024.service.MainService;
import ru.shop2024.vo.MainRequest;
import ru.shop2024.vo.MainResponse;

@RequestMapping(value = "main")
@RestController
public class MainController {

    private final MainService mainService;

    public MainController(MainService mainService) {
        this.mainService = mainService;
    }

    @GetMapping(value = "list")
    public ResponseEntity<MainResponse> list(
    ) {
        mainService.log();
        return ResponseEntity.ok(new MainResponse("SUCCESS HELLO"));
    }



        //post  @PstMapping

        //put

        //delete
    }

