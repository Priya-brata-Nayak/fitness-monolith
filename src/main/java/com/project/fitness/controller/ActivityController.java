package com.project.fitness.controller;

import com.project.fitness.dto.ActivityRequest;
import com.project.fitness.dto.ActivityResponse;
import com.project.fitness.service.ActivitySarvice;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/activities")
@RequiredArgsConstructor
public class ActivityController {
    private final ActivitySarvice activitySarvice;
    @PostMapping
    public ResponseEntity<ActivityResponse> tracActivity(@RequestBody ActivityRequest request) {
        return ResponseEntity.ok(activitySarvice.trackActivity(request));
    }
    @GetMapping
    public ResponseEntity<List<ActivityResponse>> getUserActivities(
            @RequestHeader(value = "X-User-ID") String userId
    ){
        return ResponseEntity.ok(activitySarvice.getUserActivities(userId));
}
}